<?php
    header('Content-Type: text/html; charset=utf-8');
    include "integer.php";
    
    $dbhandle = mysql_connect($hostname, $username, $password) or die("Greier ikke koble til mysql");
    mysql_set_charset('utf8',$dbhandle);
    $selected = mysql_select_db("bzl_no", $dbhandle) or die("kunne ikke velge database");
    $skole = mysql_real_escape_string($_GET['skole']);
    $studie = mysql_real_escape_string($_GET['studie']);
    $review = mysql_real_escape_string($_GET['review']);
    
    $query = "INSERT INTO reviews (skole,studie,review) VALUES ('$skole','$studie','$review')";
    $result = mysql_query($query);

?>