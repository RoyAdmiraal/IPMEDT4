
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

-- Selecteren van sessies met naam en rondes van gebruiker 1! LIMIT TEST
SELECT sessie_id, sessie_naam, taak_naam, taak_beschrijving, taak_opmerking, taak_resultaat
FROM gebruiker_sessie, sessie, ronde, taak
WHERE gbr_sessie_gebruiker_id = 1 AND gbr_sessie_sessie_id = sessie_id AND sessie_id = ronde_sessie_id AND ronde_id = taak_ronde_id
GROUP BY sessie_id
ORDER BY sessie_id DESC
LIMIT 2;

USE ipmedt4;

SELECT 
	DISTINCT gs.sessie_id
FROM 
	gebruiker_sessie AS gs
WHERE
	gs.gebruiker_id = 1
LIMIT 10;

SELECT 
	COUNT(*), gs.sessie_id
FROM 
	gebruiker_sessie AS gs
WHERE
	gs.gebruiker_id = 1
GROUP BY 
	gs.sessie_id
LIMIT 10;
    
SELECT 
	s.sessie_id, 
    s.sessie_naam, 
	t.taak_naam, 
    t.taak_beschrijving, 
    t.taak_opmerking, 
    t.taak_resultaat
FROM 
	sessie AS s
INNER JOIN
	ronde AS r
ON
	r.sessie_id = s.sessie_id
INNER JOIN 
	taak AS t
ON 
	t.ronde_id = r.ronde_id
WHERE 
	s.sessie_id = 2;
    

    

    

    

    

    

    