-- on commence par vider toutes les tables
 delete from enseignant;
  delete from crenaux;
  delete from typecours;
  delete from caracteristique;
  delete from batiment;
  delete from groupe;
  delete from salle;
  delete from ue;
  delete from caracteristique_salle;
  delete from matiere;
  delete from reservation;
  delete from cours;
  delete from reservation_caracteristique;


--Enseignant :
insert into enseignant VALUES(1,'Laurent', 'Anne', 'anne', 0);
 
insert into enseignant VALUES(2,'Fallery', 'Bernard', 'bernard', 0);
 
insert into enseignant VALUES(3,'Bourdon','Isabelle','isabelle',0);
 
insert into enseignant VALUES(4,'Buisson','Lysianne','lysianne',0);
 
insert into enseignant VALUES(5,'Cart', 'Michelle','michelle',0);
 
insert into enseignant VALUES(6,'Ruiz','Jacque','jacque',0);
 
insert into enseignant VALUES(7,'Izard','Thomas','thomas',0);
 
insert into enseignant VALUES(8,'Pacitti','Esther','esther',0);
 
insert into enseignant VALUES(9,'Seguin','Corrine','corinne',0);
 
insert into enseignant VALUES(10,'De Lauzun', 'Anne-laure','anne-laure',1);
 
insert into enseignant VALUES(11,'Stratulat', 'Tiberiu','tiberiu', 1);
 
insert into enseignant VALUES(12,'Sala', 'Michel','michel', 0);
 
insert into enseignant VALUES(13,'Dulas', 'Marc','marc', 0);


--Cr�neaux :
insert into crenaux values(1, '8h00', '9h30');
 
insert into crenaux values(2, '9h45', '11h15');
 
insert into crenaux values(3, '11h30', '13h00');
 
insert into crenaux values(4, '13h15', '14h45');
 
insert into crenaux values(5, '15h00', '16h30');
 
insert into crenaux values(6, '16h45', '18h15');
 
insert into crenaux values(7, '18h30', '20h00');


--Type de Cours :
insert into typeCours values (1,'Cours');
 
insert into typeCours values (2,'TD');
 
insert into typeCours values (3,'TP');


--Caract�ristiques :
insert into caracteristique values (1,'videoprojecteur');
 
insert into caracteristique values (2,'grande');
 
insert into caracteristique values (3,'moyenne');
 
insert into caracteristique values (4,'petite');
 
insert into caracteristique values (5,'TP');


--Batiment :
insert into Batiment values (1,'polytech');


--Groupe :
insert into groupe values (1,NULL,'IG4');
 
insert into groupe values (2,1,'IG4 G1');
 
insert into groupe values (3,1,'IG4 G2');
 
insert into groupe values (4,1,'IG4 anglais G1');
 
insert into groupe values (5,1,'IG4 anglais G2');
 
insert into groupe values (6,1,'IG4 anglais G3');


--Salle :
insert into Salle values (1,1,'amphi polytech');
 
insert into Salle values (2,1,'SC001');
 
insert into Salle values (3,1,'SC002');
 
insert into Salle values (4,1,'SC003');
 
insert into Salle values (5,1,'SC004');
 
insert into Salle values (6,1,'TP1');
 
insert into Salle values (7,1,'TP2');
 
insert into Salle values (8,1,'TP3');
 
insert into Salle values (9,1,'TP4');
 
insert into Salle values (10,1,'TP5');
 
insert into Salle values (11,1,'SC101');
 
insert into Salle values (12,1,'SC102');
 
insert into Salle values (13,1,'SC201');
 
insert into Salle values (14,1,'SC202');


--UE:
insert into UE values(1, 1, 'Conception de bases de donnees');

insert into UE values(2, 8, 'Syst�me et r�seaux');
 

insert into UE values(3, 4, 'Entreprendre et agir');
 

insert into UE values(4, 6, 'Entrepreneuriale: projet et stage');


insert into UE values(5, 9, 'Langues et communication');


--caracteristique_salle :
insert into CARACTERISTIQUE_SALLE values (1,2);

 
insert into CARACTERISTIQUE_SALLE values (1,1);

 
insert into CARACTERISTIQUE_SALLE values (2,2);

 
insert into CARACTERISTIQUE_SALLE values (2,1);

 insert into CARACTERISTIQUE_SALLE values (3,3);

 insert into CARACTERISTIQUE_SALLE values (3,1);

 insert into CARACTERISTIQUE_SALLE values (4,3);
 insert into CARACTERISTIQUE_SALLE values (4,1);
 insert into CARACTERISTIQUE_SALLE values (5,3);
 insert into CARACTERISTIQUE_SALLE values (5,1);
 insert into CARACTERISTIQUE_SALLE values (6,4);
 insert into CARACTERISTIQUE_SALLE values (6,1);
 insert into CARACTERISTIQUE_SALLE values (6,5);
 insert into CARACTERISTIQUE_SALLE values (7,4);
 insert into CARACTERISTIQUE_SALLE values (7,1);
 insert into CARACTERISTIQUE_SALLE values (7,5);
 insert into CARACTERISTIQUE_SALLE values (8,1);
 insert into CARACTERISTIQUE_SALLE values (8,4);
 insert into CARACTERISTIQUE_SALLE values (8,5);
 insert into CARACTERISTIQUE_SALLE values (9,1);
 insert into CARACTERISTIQUE_SALLE values (9,4);
 insert into CARACTERISTIQUE_SALLE values (9,5);
 insert into CARACTERISTIQUE_SALLE values (10,1);
 insert into CARACTERISTIQUE_SALLE values (10,4);
 insert into CARACTERISTIQUE_SALLE values (10,5);
 insert into CARACTERISTIQUE_SALLE values (11,1);
 insert into CARACTERISTIQUE_SALLE values (11,3);
 insert into CARACTERISTIQUE_SALLE values (12,1);
 insert into CARACTERISTIQUE_SALLE values (12,3);
 insert into CARACTERISTIQUE_SALLE values (13,1);
 insert into CARACTERISTIQUE_SALLE values (13,3);
 insert into CARACTERISTIQUE_SALLE values (14,1);
 insert into CARACTERISTIQUE_SALLE values (14,3);


--Mati�res :
insert into matiere values(1, 1, 12, 'Conception par objets');
 insert into matiere values(2, 1, 8, 'Bases de donn�es relationnelles Objet et multidimensionnelles');
 insert into matiere values(3, 2, 5, 'Syst�me d exploitation');
 insert into matiere values(4, 2, 7, 'R�seaux');
 insert into matiere values(5, 3, 3, 'Simulation d entreprise');
 insert into matiere values(6, 3, 4, 'Si et marketing');
 insert into matiere values(7, 3, 2, 'Management des syst�mes d information');
 insert into matiere values(8, 4, 6, 'Technique de gestion de projets.');
 insert into matiere values(9, 4, 6, 'M�thodologie de gestion de projets');
 insert into matiere values(10, 5, 9, 'Langue 1: anglais');
 insert into matiere values(11, 5, 4, 'Insertion professionnelle');
 insert into matiere values(12, 5, 13, 'Communication');


--Cours :
insert into cours values (1,1,1,'cours 1');
 insert into cours values (2,1,2,'cours 2');
 insert into cours values (3,1,3,'cours 3');
 insert into cours values (4,2,1,'cours 1');
 insert into cours values (5,2,2,'cours 2');
 insert into cours values (6,2,3,'cours 3');
 insert into cours values (7,3,1,'cours 1');
 insert into cours values (8,3,2,'cours 2');
 insert into cours values (9,3,3,'cours 3');
 insert into cours values (10,4,1,'cours 1');
 insert into cours values (11,4,2,'cours 2');
 insert into cours values (12,4,3,'cours 3');
 insert into cours values (13,5,1,'cours 1');
 insert into cours values (14,5,2,'cours 2');
 insert into cours values (15,5,3,'cours 3');
 insert into cours values (16,6,1,'cours 1');
 insert into cours values (17,6,2,'cours 2');
 insert into cours values (18,6,3,'cours 3');
 insert into cours values (19,7,1,'cours 1');
 insert into cours values (20,7,2,'cours 2');
 insert into cours values (21,7,3,'cours 3');
 insert into cours values (22,8,1,'cours 1');
 insert into cours values (23,8,2,'cours 2');
 insert into cours values (24,8,3,'cours 3');
 insert into cours values (25,9,1,'cours 1');
 insert into cours values (26,9,2,'cours 2');
 insert into cours values (27,9,3,'cours 3');
 insert into cours values (28,10,1,'cours 1');
 insert into cours values (29,10,2,'cours 2');
 insert into cours values (30,10,3,'cours 3');
 insert into cours values (31,11,1,'cours 1');
 insert into cours values (32,11,2,'cours 2');
 insert into cours values (33,11,3,'cours 3');
 insert into cours values (34,12,1,'cours 1');
 insert into cours values (35,12,2,'cours 2');
 insert into cours values (36,12,3,'cours 3');


-- Enseignement :
insert into enseignement values (1,36,13,6,30);
 insert into enseignement values (2,2,12,4,5);
 insert into enseignement values (3,3,11,5,15);
 insert into enseignement values (4,7,10,1,20);
 insert into enseignement values (5,33,9,2,13);
 insert into enseignement values (6,30,1,3,14);
 insert into enseignement values (7,1,4,5,20);
 insert into enseignement values (8,4,3,1,10);
 insert into enseignement values (9,5,13,2,5);
 insert into enseignement values (10,6,2,3,30);
 insert into enseignement values (11,8,1,6,10);
 insert into enseignement values (12,9,13,3,10);
 insert into enseignement values (13,13,7,4,4);
 insert into enseignement values (14,12,8,1,5);
 insert into enseignement values (15,17,5,1,10);
 insert into enseignement values (16,16,9,4,3);
 insert into enseignement values (17,11,10,5,2);
 insert into enseignement values (18,15,12,6,4);
 insert into enseignement values (19,19,13,2,10);
 insert into enseignement values (20,18,11,6,10);
 insert into enseignement values (21,21,10,1,14);
 insert into enseignement values (22,20,8,3,20);
 insert into enseignement values (23,14,9,4,13);
 insert into enseignement values (24,22,4,1,11);
 insert into enseignement values (25,23,3,1,10);
 insert into enseignement values (26,25,1,2,12);
 insert into enseignement values (27,26,2,5,3);
 insert into enseignement values (28,32,5,5,4);
 insert into enseignement values (29,31,12,1,5);
 insert into enseignement values (30,29,13,6,5);
 insert into enseignement values (31,28,3,3,8);
 insert into enseignement values (32,27,7,6,7);
 insert into enseignement values (33,34,2,4,15);
 insert into enseignement values (34,35,3,6,3);
 insert into enseignement values (35,10,13,3,10);
 insert into enseignement values (36,24,13,3,10)

-- Reservation
insert into reservation values (1,14,1,36,'10-03-2012');
 insert into reservation values (2,13,1,34,'10-03-2012');
 insert into reservation values (3,12,2,33,'10-03-2012');
 insert into reservation values (4,NULL,2,31,'10-03-2012');
 insert into reservation values (5,10,5,30,'10-03-2012');
 insert into reservation values (6,2,6,10,'10-03-2012');
 insert into reservation values (7,1,7,1,'10-03-2012');
 insert into reservation values (8,NULL,1,2,'11-03-2012');
 insert into reservation values (9,7,2,4,'11-03-2012');
 insert into reservation values (10,8,3,17,'11-03-2012');
 insert into reservation values (11,11,4,16,'11-03-2012');
 insert into reservation values (12,13,5,26,'11-03-2012');
 insert into reservation values (13,14,6,6,'11-03-2012');
 insert into reservation values (14,NULL,7,5,'11-03-2012');
 insert into reservation values (15,5,1,15,'12-03-2012');
 insert into reservation values (16,NULL,2,13,'12-03-2012');
 insert into reservation values (17,2,3,11,'12-03-2012');
 insert into reservation values (18,9,4,10,'12-03-2012');
 insert into reservation values (19,6,5,1,'12-03-2012');
 insert into reservation values (20,7,6,2,'12-03-2012');
 insert into reservation values (21,9,7,3,'12-03-2012');
 insert into reservation values (22,14,1,5,'13-03-2012');
 insert into reservation values (23,NULL,2,18,'13-03-2012');
 insert into reservation values (24,6,3,19,'13-03-2012');
 insert into reservation values (25,8,4,2,'13-03-2012');
 insert into reservation values (26,7,5,7,'13-03-2012');
 insert into reservation values (27,NULL,6,17,'13-03-2012');
 insert into reservation values (28,14,7,16,'13-03-2012');
 insert into reservation values (29,6,1,27,'14-03-2012');
 insert into reservation values (30,7,2,22,'14-03-2012');
 insert into reservation values (31,5,3,21,'14-03-2012');
 insert into reservation values (32,14,4,34,'14-03-2012');
 insert into reservation values (33,5,5,32,'14-03-2012');
 insert into reservation values (34,NULL,6,31,'14-03-2012');
 insert into reservation values (35,3,7,16,'14-03-2012');
 insert into reservation values (36,9,1,3,'15-03-2012');


-- Reservation_Caracteristique 
insert into reservation_caracteristique values (5,1);
 insert into reservation_caracteristique values (2,1);
 insert into reservation_caracteristique values (4,2);
 insert into reservation_caracteristique values (1,2);
 insert into reservation_caracteristique values (5,2);
 insert into reservation_caracteristique values (2,3);
 insert into reservation_caracteristique values (2,4);
 insert into reservation_caracteristique values (5,4);
 insert into reservation_caracteristique values (3,5);
 insert into reservation_caracteristique values (1,6);
 insert into reservation_caracteristique values (5,6);
 insert into reservation_caracteristique values (2,7);
 insert into reservation_caracteristique values (4,8);
 insert into reservation_caracteristique values (1,9);
 insert into reservation_caracteristique values (2,9);
 insert into reservation_caracteristique values (3,10);
 insert into reservation_caracteristique values (5,11);
 insert into reservation_caracteristique values (4,12);
 insert into reservation_caracteristique values (2,13);
 insert into reservation_caracteristique values (3,14);
 insert into reservation_caracteristique values (1,14);
 insert into reservation_caracteristique values (2,15);
 insert into reservation_caracteristique values (5,15);
 insert into reservation_caracteristique values (3,16);
 insert into reservation_caracteristique values (2,17);
 insert into reservation_caracteristique values (4,18);
 insert into reservation_caracteristique values (1,19);
 insert into reservation_caracteristique values (3,19);
 insert into reservation_caracteristique values (2,19);
 insert into reservation_caracteristique values (5,20);
 insert into reservation_caracteristique values (1,21);
 insert into reservation_caracteristique values (3,21);
 insert into reservation_caracteristique values (4,22);
 insert into reservation_caracteristique values (1,23);
 insert into reservation_caracteristique values (2,23);
 insert into reservation_caracteristique values (1,24);
 insert into reservation_caracteristique values (2,24);
 insert into reservation_caracteristique values (3,25);
 insert into reservation_caracteristique values (4,26);
 insert into reservation_caracteristique values (3,27);
 insert into reservation_caracteristique values (4,28);
 insert into reservation_caracteristique values (5,28);
 insert into reservation_caracteristique values (5,29);
 insert into reservation_caracteristique values (3,29);
 insert into reservation_caracteristique values (1,30);
 insert into reservation_caracteristique values (2,30);
 insert into reservation_caracteristique values (5,30);
 insert into reservation_caracteristique values (3,31);
 insert into reservation_caracteristique values (2,31);
 insert into reservation_caracteristique values (4,32);
 insert into reservation_caracteristique values (3,33);
 insert into reservation_caracteristique values (2,33);
 insert into reservation_caracteristique values (1,34);
 insert into reservation_caracteristique values (4,35);
 insert into reservation_caracteristique values (2,35);
 insert into reservation_caracteristique values (1,36);
