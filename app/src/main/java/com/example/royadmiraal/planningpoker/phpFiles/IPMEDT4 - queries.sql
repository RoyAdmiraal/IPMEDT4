
-- Selecteren van de gebruiker sessies
SELECT DISTINCT sessie_id 
FROM gebruiker_sessie 
WHERE gebruiker_id = 1 
ORDER BY sessie_id 
DESC LIMIT 10;

-- Selecteren van de sessie met naam dmv de gebruiker sessies (2,1)..
SELECT sessie_id, sessie_naam 
FROM sessie 
WHERE sessie_id IN (2,1) ORDER BY sessie_id DESC;

-- Selecteren van sessies met naam van gebruiker 1!
SELECT sessie_id, sessie_naam 
FROM gebruiker_sessie, sessie 
WHERE gbr_sessie_gebruiker_id = 1 AND gbr_sessie_sessie_id;

-- Selecteren van sessies met naam en rondes van gebruiker 1!
SELECT sessie_id, sessie_naam, taak_naam, taak_beschrijving, taak_opmerking, taak_resultaat 
FROM gebruiker_sessie, sessie, ronde, taak 
WHERE gbr_sessie_gebruiker_id = 1 AND gbr_sessie_sessie_id = sessie_id AND sessie_id = ronde_sessie_id AND ronde_id = taak_ronde_id 
ORDER BY sessie_id DESC;



-- Selecteren van de sessies  van een gebruiker
SELECT 
	DISTINCT gbr_sessie_sessie_id
FROM 
	gebruiker_sessie
WHERE 
	gbr_sessie_gebruiker_id = 1
ORDER BY 
	gbr_sessie_sessie_id DESC
LIMIT 10;



-- Selecteren een sessie met taken!
SELECT 
	sessie_id, 
    sessie_naam, 
	taak_naam, 
    taak_beschrijving, 
    taak_opmerking, 
    taak_resultaat
FROM 
	sessie
INNER JOIN 
	taak
ON 
	taak_sessie_id = sessie_id
WHERE 
	sessie_id = 1;
    

    

    

    

    

    

    