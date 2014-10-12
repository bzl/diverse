<!DOCTYPE html>
<html>
<head>
<?php
echo 	'<meta charset="UTF-8">' .
		'<title>Mitt Studium</title>' .
		'<link rel="stylesheet" href="assets/css/text.css" type="text/css" media="all">';
?>
</head>
<body>

    <h1 style="text-align: center;">Hei!</h1>

    <h3>Fag ved UiB:</h3>

    <script>
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.open("GET","assets/xml/kurs.xml",false);
xmlhttp.send();
xmlDoc=xmlhttp.responseXML; 

document.write("<table border='1'>");
var x=xmlDoc.getElementsByTagName("FAG");
  document.write("<tr><td>Fagkode</td> <td>Fag navn</td> <td>Studiepoeng</td></tr>");
for (i=0;i<x.length;i++)
  { 
  document.write("<tr><td>");
  document.write(x[i].getElementsByTagName("FAGKODE")[0].childNodes[0].nodeValue);
  document.write("</td><td>");
  document.write(x[i].getElementsByTagName("TITTEL")[0].childNodes[0].nodeValue);
  document.write("</td><td>");
  document.write(x[i].getElementsByTagName("STUDIEPOENG")[0].childNodes[0].nodeValue);
  document.write("</td></tr>");
  }
document.write("</table>");
</script>

</body>
</html>