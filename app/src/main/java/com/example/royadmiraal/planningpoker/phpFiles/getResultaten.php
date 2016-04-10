<?php

//////////////////////////////////////
//    Collin Woerde                 //
//    IPMEDT4 Api - index.php       //
//    05-04-2016                    //
//////////////////////////////////////

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    require 'connection.php';
    getGebruikerSessies(1);
}

function getGebruikerSessies($gebruikerId) {
    global $connect;

    $query = "SELECT sessie_id, sessie_naam, taak_naam, taak_beschrijving, taak_opmerking, taak_resultaat 
            FROM gebruiker_sessie, sessie, ronde, taak 
            WHERE gbr_sessie_gebruiker_id = '$gebruikerId' AND gbr_sessie_sessie_id = sessie_id AND sessie_id = ronde_sessie_id AND ronde_id = taak_ronde_id 
            ORDER BY sessie_id DESC";


    $result = mysqli_query($connect, $query);

    $number_of_rows = mysqli_num_rows($result);
    $temp_gebruikerSessies = array();

    if ($number_of_rows > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $temp_gebruikerSessies[] = $row;
        }
    } else {
        $temp_gebruikerSessies = "Er zijn geen resultaten";
    }

    $gebruikerSessies = array_column($temp_gebruikerSessies, 'sessie_id');

    // Array bekijken voor het testen
    print_r($temp_gebruikerSessies);
}
