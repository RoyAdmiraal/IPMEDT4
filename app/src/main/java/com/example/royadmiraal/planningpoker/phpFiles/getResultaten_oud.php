<?php

//////////////////////////////////////
//    Collin Woerde                 //
//    IPMEDT4 Api - index.php       //
//    05-04-2016                    //
//////////////////////////////////////

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    require 'connection.php';
    getGebruikerSessies(1);
    getSessieNamen();
}

function getGebruikerSessies($gebruikerId) {
    global $connect;
    global $gebruikerSessies;

    $query = "SELECT DISTINCT sessie_id FROM gebruiker_sessie WHERE gebruiker_id = '$gebruikerId' ORDER BY sessie_id DESC LIMIT 10";


    $result = mysqli_query($connect, $query);

    $number_of_rows = mysqli_num_rows($result);
    $temp_gebruikerSessies = array();

    if ($number_of_rows > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $temp_gebruikerSessies[] = $row;
        }
    } else {
        $temp_gebruikerSessies[] = "Er zijn geen resultaten";
    }

    $gebruikerSessies = array_column($temp_gebruikerSessies, 'sessie_id');
    
    // Array bekijken voor het testen
    print_r($gebruikerSessies);
    
}

function getSessieNamen() {
    global $connect;
    global $gebruikerSessies;

    $query = 'SELECT sessie_id, sessie_naam FROM sessie WHERE sessie_id IN (' . implode(',', array_map('intval', $gebruikerSessies)) . ') ORDER BY sessie_id DESC';

    $result = mysqli_query($connect, $query);

    $number_of_rows = mysqli_num_rows($result);
    $temp_array = array();

    if ($number_of_rows > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $temp_array[] = $row;
        }
    } else {
        $temp_array[] = 'Er zijn geen resultaten';
    }

    $array = array_column($temp_array, 'sessie_naam');
    
    // Array bekijken voor het testen
    print_r($array);

    //header('Content-Type: application/json');
    echo json_encode(array('resultaten' => $array));

    mysqli_close($connect);
}