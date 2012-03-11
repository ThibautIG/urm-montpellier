
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