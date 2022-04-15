# NYPD_Retina
Realizarea unei aplicatie web care sa expuna urmatoarele endpoint-uri REST pe un sample de 1000 recorduri din setul de date disponibil:
GET endpoints:
•	dataset/stats/total – raspunde cu un JSON care contine numarul total de evenimente din dataset
•	dataset/stats/offenses – raspunde cu un JSON care contine numarul total de evenimente grupat dupa coloane KY_CD
DELETE endpoints:
•	/dataset/${id} – sterge din fisierul CSV evenimentul cu ID-ul specificat (fie ca request param, fie ca path variable) si raspunde cu true/false la succes.
POST endpoints:
•	/dataset – face post la un obiect de tipul JSON, care contine doar campurile CMPLNT_NUM, KY_CD si insereaza la sfarsitul fisierului o linie cu acele informatii.
