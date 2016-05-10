<?php

//////////////////////////////////////
//    Collin Woerde                 //
//    IPMEDT4 Api - index.php       //
//    05-04-2016                    //
//////////////////////////////////////

//define('hostname', 'localhost');
//define('user', 'root');
//define('password', '');
//define('database', 'ipmedt4');

define('hostname', 'localhost');
define('user', 'ipmedt4');
define('password', 'ipmedt1234');
define('database', 'ipmedt4');

$connect = mysqli_connect(hostname, user, password, database);