CREATE OR REPLACE TYPE TEnseignement AS OBJECT
(
	ID_ENSEIGNEMENT NUMBER(10)  NOT NULL,
	ID_COURS NUMBER(10)  NULL,
	ID_ENSEIGNANT NUMBER(10)  NULL,
	ID_GROUPE NUMBER(10)  NULL,
	NB_HEURE_PREVUE NUMBER(4)  NULL
);
/

CREATE OR REPLACE TYPE TCaracteristique AS OBJECT
(
	ID_CARACTERISTIQUE NUMBER(10)  NOT NULL,
	ID_RESERVATION NUMBER(10)  NOT NULL
);
/

CREATE TYPE nt_Caracteristiques AS TABLE OF TCaracteristique;


CREATE OR REPLACE TYPE TReservation AS OBJECT
(
	ID_RESERVATION NUMBER(10)  NOT NULL,
	ID_SALLE NUMBER(10)  NULL,
	ID_CRENEAU NUMBER(10)  NULL,
	ID_ENSEIGNEMENT NUMBER(10)  NULL,
	DATE_RESERVATION DATE  NULL
	listCaract nt_Caracteristiques
);
/

CREATE TYPE nt_Enseignement AS TABLE OF TEnseignement;
CREATE TYPE nt_Reservation AS TABLE OF TReservation;


CREATE OR REPLACE TYPE TSalle AS OBJECT
(
	ID_SALLE NUMBER(10)  NOT NULL,
	ID_BATIMENT NUMBER(10)  NULL,
	NUMERO_SALLE CHAR(255)  NULL,
	listReserv nt_Reservation
	
);
/
CREATE OR REPLACE TYPE TEnseignant AS OBJECT
(
	ID_ENSEIGNANT NUMBER(10)  NOT NULL,
	NOM CHAR(255)  NULL,
	PRENOM CHAR(255)  NULL,
	MDP CHAR(255)  NULL,
	SUPER_USER NUMBER(1)  NULL ,
	listReserv nt_Reservations ,
	listEmp nt_Emprunts
);
/


CREATE OR REPLACE VIEW VExemplaire OF TExemplaire
WITH OBJECT OID (numero)
AS
  SELECT numero, date_achat, prix, code_pret, etat
  FROM Exemplaire;


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