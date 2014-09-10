<?php
    header('Content-Type: text/html; charset=utf-8');
    include "integer.php";
    
    $dbhandle = mysql_connect($hostname, $username, $password) or die("Greier ikke koble til mysql");
    mysql_set_charset('utf8',$dbhandle);
    $selected = mysql_select_db("bzl_no", $dbhandle) or die("kunne ikke velge database");
    
    $query = "SELECT skole, studie, ROUND(AVG(score),1) AS snitt FROM reviews GROUP BY skole, studie ORDER BY snitt DESC";
    $result = mysql_query($query);

    while ($row = mysql_fetch_array($result)) {
        echo '<tr> <td class="skole">' 
      		. $row{'skole'} 
       		. '</td> <td class="studie">' 
      		. $row{'studie'} 
        	. '</td> <td class="score">' 
        	. $row{'snitt'} 
        	. '</td> </tr>';
    }
?>