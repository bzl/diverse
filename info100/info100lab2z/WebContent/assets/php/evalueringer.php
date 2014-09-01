<?php
    header('Content-Type: text/html; charset=utf-8');
    include "integer.php";
    
    $dbhandle = mysql_connect($hostname, $username, $password) or die("Greier ikke koble til mysql");
    mysql_set_charset('utf8',$dbhandle);
    $selected = mysql_select_db("bzl_no", $dbhandle) or die("kunne ikke velge database");
    $skole = mysql_real_escape_string($_GET['skole']);
    $studie = mysql_real_escape_string($_GET['studie']);
    
    $query = "SELECT *  FROM reviews WHERE skole='$skole' AND studie='$studie'";
    $result = mysql_query($query);

    while ($row = mysql_fetch_array($result)) {
        echo "<li>" . $row{'review'} . "</li>";
    }
?>