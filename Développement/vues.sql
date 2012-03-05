CREATE OR REPLACE TYPE TEnseignement AS OBJECT
(
	ID_ENSEIGNEMENT NUMBER(10)  NOT NULL,
	ID_COURS NUMBER(10) ,
	ID_ENSEIGNANT NUMBER(10)  ,
	ID_GROUPE NUMBER(10)  ,
	NB_HEURE_PREVUE NUMBER(4) 
);
/

CREATE OR REPLACE TYPE TReservationCaracteristique AS OBJECT
(
	ID_CARACTERISTIQUE NUMBER(10)  NOT NULL ,
	ID_RESERVATION NUMBER(10)  NOT NULL
);
/

CREATE OR REPLACE TYPE TCaracteristique AS OBJECT
(
   ID_CARACTERISTIQUE NUMBER(10)  NOT NULL,
   LIBELLE_CARACTERISTIQUE CHAR(255)
);
/

CREATE TYPE nt_Caracteristiques AS TABLE OF TCaracteristique;


CREATE TYPE nt_ResaCaracteristiques AS TABLE OF TReservationCaracteristique;


CREATE OR REPLACE TYPE TReservation AS OBJECT
(
	ID_RESERVATION NUMBER(10)  NOT NULL,
	ID_SALLE NUMBER(10) ,
	ID_CRENEAU NUMBER(10) ,
	ID_ENSEIGNEMENT NUMBER(10) ,
	DATE_RESERVATION DATE ,
	listResaCaract nt_ResaCaracteristiques
);
/

CREATE TYPE nt_Enseignement AS TABLE OF TEnseignement;
CREATE TYPE nt_Reservation AS TABLE OF TReservation;


CREATE OR REPLACE TYPE TSalle AS OBJECT
(
	ID_SALLE NUMBER(10)  NOT NULL,
	NUMERO_SALLE CHAR(255) ,
	listCaract nt_Caracteristiques,
	listReserv nt_Reservation	
);
/

CREATE OR REPLACE TYPE TEnseignant AS OBJECT
(
	ID_ENSEIGNANT NUMBER(10)  NOT NULL,
	NOM CHAR(255)  ,
	PRENOM CHAR(255)  ,
	MDP CHAR(255)  ,
	SUPER_USER NUMBER(1) ,
	listEmp nt_Enseignement,
	listReserv nt_Reservations
);
/


CREATE OR REPLACE VIEW VExemplaire OF TExemplaire
WITH OBJECT OID (numero)
AS
  SELECT numero, date_achat, prix, code_pret, etat
  FROM Exemplaire;

  
create view VEnseignant of TEnseignant
with object oid(id_enseignant) as
	SELECT e.id_enseignant, e.nom, e.prenom, e.mdp, e.super_user,
	   cast (multiset(SELECT *
					  FROM ENSEIGNEMENT ens
				      WHERE ens.id_enseignant = e.id_enseignant)
		as nt_Enseignement) ,
		cast (multiset(SELECT *
					  FROM RESERVATION res, ENSEIGNEMENT ens
				      WHERE res.id_enseignement = ens.id_enseignement
					  AND ens.id_enseignant = e.id_enseignant)
		as nt_Enseignement)
from enseignant e;
/


create view VReservation of TReservation
with object oid(id_reservation) as
	SELECT r.id_reservation, r.id_salle, r.id_creneau, r.id_enseignement, r.date_reservation ,
	   cast (multiset(SELECT *
					  FROM RESERVATION_CARACTERISTIQUE c
				      WHERE c.id_reservation = r.id_reservation)
		as nt_Reservation) ,
from Reservation r;
/


create view VSalle of TSalle
with object oid(id_salle) as
	SELECT s. ,
	   cast (multiset(SELECT *
					  FROM RESERVATION_CARACTERISTIQUE c
				      WHERE c.id_reservation = r.id_reservation)
		as nt_Reservation) ,
from Salle s;
/



create or replace trigger ins_Vabonne 
instead of insert on Vabonne
for each row
declare i integer;
begin
	INSERT INTO Abonne 
	VALUES(:new.num_ab, :new.nom, :new.prenom, :new.ville, :new.age, :new.tarif, :new.reduc);
	
	if :new.listEmp is not null and :new.listEmp.count >0 then
		for i in :new.listEmp.first .. :new.listEmp.last loop
			insert into emprunt (num_ab,num_ex,d_emprunt) values (:new.num_ab,
				deref(:new.listEmp(i).num_ex).numero, :new.listEmp(i).d_emprunt);
		end loop;
	end if;
end;
/