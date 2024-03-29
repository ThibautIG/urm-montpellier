CREATE OR REPLACE TYPE TEnseignement AS OBJECT
(
	ID_ENSEIGNEMENT NUMBER(10),
	ID_COURS NUMBER(10) ,
	ID_ENSEIGNANT NUMBER(10) ,
	ID_GROUPE NUMBER(10) ,
	NB_HEURE_PREVUE NUMBER(4) 
);

CREATE OR REPLACE TYPE TCaracteristique AS OBJECT
(
   ID_CARACTERISTIQUE NUMBER(10)  ,
   LIBELLE_CARACTERISTIQUE CHAR(255)
);

CREATE TYPE nt_Caracteristiques AS TABLE OF TCaracteristique;

CREATE OR REPLACE TYPE TReservation AS OBJECT
(
	ID_RESERVATION NUMBER(10)  ,
	ID_SALLE NUMBER(10) ,
	ID_CRENEAU NUMBER(10) ,
	ID_ENSEIGNEMENT NUMBER(10) ,
	DATE_RESERVATION DATE ,
	listCaract nt_Caracteristiques
);

CREATE TYPE nt_Enseignement AS TABLE OF TEnseignement;
CREATE TYPE nt_Reservation2 AS TABLE OF REF TReservation;

CREATE OR REPLACE TYPE TSalle2 AS OBJECT
(
	ID_SALLE NUMBER(10)   ,
	NUMERO_SALLE CHAR(255) ,
	listCaract nt_Caracteristiques ,
	listReserv nt_Reservation2	
);

CREATE OR REPLACE TYPE TEnseignant2 AS OBJECT
(
	ID_ENSEIGNANT NUMBER(10)  ,
	NOM CHAR(255)  ,
	PRENOM CHAR(255) ,
	MDP CHAR(255) ,
	SUPER_USER NUMBER(1) ,
	listEmp nt_Enseignement,
	listReserv nt_Reservation2
);

-- Vue Enseignant  
create view VEnseignant2 of TEnseignant2
with object oid(id_enseignant) as
	SELECT e.id_enseignant, e.nom, e.prenom, e.mdp, e.super_user,
	   cast (multiset(SELECT TEnseignement(ID_ENSEIGNEMENT,ID_COURS ,ID_ENSEIGNANT ,ID_GROUPE , NB_HEURE_PREVUE)
					  FROM ENSEIGNEMENT ens
				      WHERE ens.id_enseignant = e.id_enseignant)
		as nt_Enseignement),
		cast (multiset (SELECT make_ref(VReservation, r.ID_RESERVATION)
					  FROM RESERVATION r, ENSEIGNEMENT ens
				      WHERE r.id_enseignement = ens.id_enseignement
					  AND ens.id_enseignant = e.id_enseignant)
		as nt_Reservation2)
	FROM enseignant e;
		
	
-- Vue VReservation 
create view VReservation of TReservation
with object oid(id_reservation) as
	SELECT r.id_reservation, r.id_salle, r.id_creneau, r.id_enseignement, r.date_reservation ,
	   cast (multiset(SELECT TCaracteristique(c.ID_CARACTERISTIQUE, c.LIBELLE_CARACTERISTIQUE)
					  FROM CARACTERISTIQUE c, RESERVATION_CARACTERISTIQUE rescar
				      WHERE c.id_caracteristique = rescar.id_caracteristique
					  AND rescar.id_reservation = r.id_reservation)
		as nt_Caracteristiques)
from Reservation r;

-- Vue Salle  
create view VSalle2 of TSalle2
with object oid(id_salle) as
	SELECT s.id_salle, s.numero_salle,
		cast (multiset(SELECT TCaracteristique(c.ID_CARACTERISTIQUE, c.LIBELLE_CARACTERISTIQUE)
					  FROM CARACTERISTIQUE c, CARACTERISTIQUE_SALLE carsalle
				      WHERE c.id_caracteristique = carsalle.id_caracteristique
					  AND carsalle.id_salle = s.id_salle)
		as nt_Caracteristiques) ,
		cast (multiset(SELECT make_ref(VReservation, r.ID_RESERVATION)
						FROM RESERVATION r
						WHERE r.id_salle = s.id_salle)
		as nt_Reservation2)
	from Salle s;

-- Trigger
create or replace trigger ins_VReservation 
instead of insert on VReservation
for each row
declare i integer;
begin
	INSERT INTO Reservation
	VALUES(:new.id_reservation, :new.id_salle, :new.id_creneau, :new.id_enseignement, :new.date_reservation);
	if :new.listCaract is not null and :new.listCaract.count >0 then
		for i in :new.listCaract.first .. :new.listCaract.last loop
			insert into RESERVATION_CARACTERISTIQUE(id_caracteristique,id_reservation) 
				values (:new.listCaract(i).id_caracteristique, :new.id_reservation);
		end loop;
	end if;
end;