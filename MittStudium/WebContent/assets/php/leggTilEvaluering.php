<?php
    header('Content-Type: text/html; charset=utf-8');
    include "integer.php";
    
    $dbhandle = mysql_connect($hostname, $username, $password) or die("Greier ikke koble til mysql");
    mysql_set_charset('utf8',$dbhandle);
    $selected = mysql_select_db("bzl_no", $dbhandle) or die("kunne ikke velge database");
    $skole = mysql_real_escape_string($_GET['skole']);
    $studie = mysql_real_escape_string($_GET['studie']);
    $review = mysql_real_escape_string($_GET['review']);
    $score = mysql_real_escape_string($_GET['score']);
    
    $query = "INSERT INTO reviews (skole,studie,review,score) VALUES ('$skole','$studie','$review','$score')";
    $result = mysql_query($query);

?>