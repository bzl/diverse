<!DOCTYPE html>
<html>
<head>
<?php
echo 	'<meta charset="utf-8">' .
		'<title>Mitt Studium</title>' .
		'<link rel="stylesheet" href="assets/css/tables.css" type="text/css">' .
		'<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>' .
		'<script type="text/javascript" src="assets/js/populateSchools.js"></script>' .
		'<script type="text/javascript" src="assets/js/populateStudiesExtended.js"></script>';
?>
</head>
<body>

    <script type="text/javascript">
					$(document).ready(function() {
						$(initializeSchools);
						});
						
var visInfo = true;
function visInformasjon() {
	if(visInfo){
		document.getElementById("score").style.visibility = "hidden";
		visInfo = false;
	} else {
		document.getElementById("score").style.visibility = "visible";
		visInfo = true;
	}
}
						
	</script>

    <table class="fiftyfifty">
        <tr>
            <td class="one"><select id="first-choice">
                    <option selected value="base">Velg en utdannings-institusjon</option>
            </select></td>
            <td class="two"><select id="second-choice">
                    <option>Først må du velge utdannings-institusjon</option>
            </select></td>
        </tr>
    </table>

    <ul id="evalueringer">

    </ul>

    <br>
    <br>
	
	<button type="button" onclick="visInformasjon()">Vis/Skjul mer informasjon</button>
    <span id="score"></span>

    <br>
    <br>

</body>
</html>