<?php
    header('Content-Type: text/html; charset=utf-8');
    include "integer.php";
    
    $dbhandle = mysql_connect($hostname, $username, $password) or die("Unable to connect to MySQL");
    mysql_set_charset('utf8',$dbhandle);
    $selected = mysql_select_db("bzl_no", $dbhandle) or die("Could not select examples");
    
    $query = "SELECT DISTINCT skole FROM reviews";
    $result = mysql_query($query);
        
    while ($row = mysql_fetch_array($result)) {
        echo "<option>" . $row{'skole'} . "</option>";
    }
?>