<?php

    header('Content-Type: text/html; charset=utf-8');
    include "integer.php";
    
    
    $con = mysql_connect($hostname, $username, $password) or die("Unable to connect to MySQL");
    $charset = mysql_client_encoding($con);
    echo "The current character set is: $charset\n";
    
    
?>