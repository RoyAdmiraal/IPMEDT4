<?php

//////////////////////////////////////
//    Roy Admiraal                  //
//    IPMEDT4 Api - index.php       //
//    10-05-2016                    //
//////////////////////////////////////

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    require 'connection.php';

    getSessies(1);
    mysqli_close($connect);
}

function getSessies($gebruikerId) {
    global $connect;
    global $sessies;

    $query = "SELECT
                    DISTINCT gbr_sessie_sessie_id
                FROM
                    gebruiker_sessie
                WHERE
                    gbr_sessie_gebruiker_id = '$gebruikerId'
                ORDER BY
                    gbr_sessie_sessie_id DESC
                LIMIT 10";

    $result = mysqli_query($connect, $query);

    $number_of_rows = mysqli_num_rows($result);
    $temp_sessies = array();

    if ($number_of_rows > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $temp_sessies[] = $row;
        }
    } else {
        $temp_sessies = "Er bestaat geen sessie";
    }

    $sessies = array_column($temp_sessies, 'gbr_sessie_sessie_id');

    // Array bekijken voor het testen
    //print_r($sessies);
    //header('Content-Type: application/json');
    echo json_encode(array("sessies" => $temp_sessies));
}




    $gebruikerSessies = array_column($temp_gebruikerSessies, 'sessie_id');

    // Array bekijken voor het testen
    //print_r($temp_gebruikerSessies);

    //header('Content-Type: application/json');
    echo json_encode(array("resultaat" . $sessieId => $temp_gebruikerSessies));
}
