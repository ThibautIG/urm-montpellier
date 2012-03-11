
select count(*) 
from SALLE s, CARACTERISTIQUE_SALLE cs
where 
s.ID_SALLE = cs.ID_SALLE and

(boucle for avec pour chaque caractéristique ) IN 
(select LIBELLE_CARACTERISTIQUE
from CARACTERISTIQUE c
where cs.ID_CARACTERISTIQUE = c.ID_CARACTERISTIQUE)

and

(select count(*) from RESERVATION r where 
r.ID_SALLE=s.ID_SALLE and 
r.ID_CRENEAU=<moncreneau> and
r.DATE_RESERVATION=<madate>)=0

select count(*) 
from SALLE s 
where 1 IN (select ID_CARACTERISTIQUE from CARACTERISTIQUE_SALLE cs where s.ID_SALLE = cs.ID_SALLE) 
and 5 IN (select ID_CARACTERISTIQUE from CARACTERISTIQUE_SALLE cs where s.ID_SALLE = cs.ID_SALLE) 
and (select count(*) from RESERVATION r where r.ID_SALLE=s.ID_SALLE and r.ID_CRENEAU=4 and r.DATE_RESERVATION='Thu Mar 15 20:55:06 CET 2012')=0