<!DOCTYPE html>
<html>
<head>
<?php
echo '<meta charset="UTF-8">' .
		'<title>Mitt Studium</title>' .
		'<link rel="stylesheet" href="assets/css/tables.css" type="text/css">' .
		'<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>' .
		'<script type="text/javascript" src="assets/js/populateSchools.js"></script>' .
		'<script type="text/javascript" src="assets/js/submitReview.js"></script>' .
		'<script type="text/javascript" src="assets/js/presetInfo.js"></script>';
?>
</head>
<body>

    <h1 style="text-align: center">Legg til et nytt Studiested</h1>

    <script type="text/javascript">
		$(document).ready(function() {
			$(initializeSchools);
			settSkoleOgStudie();
		});
	</script>

    <table class="fiftyfifty">
        <tr>
            <td class="one"><select id="first-choice">
                    <option selected value="base">Velg en utdannings-institusjon</option>
            </select></td>
            <td class="two">Navn på studiet: <input type="text" id="second-choice" value="Skriv navn på studiet her" size="40" /></td>
        </tr>
    </table>
    <br>

    <table class="twentyeighty">
        <tr>
            <td class="one">Ditt navn</td>
            <td class="two"><input type="text" id="evaluer_navn" value="Skriv ditt navn her" size="30" /></td>
        </tr>
        <tr>
            <td class="one">Din Evaluering</td>
            <td class="two"><textarea id="evaluering" rows="3" cols="60"> Skriv din evaluering her </textarea></td>
        </tr>
    </table>

    <form oninput="currentScore.value=score.value">
        Evaluer studiet på en skala fra 1 til 10, der 10 er det beste: <input type="range" id="score" name="score" min="0" max="10"> 
        Score: <output name="currentScore" for="score">5</output>
    </form>

    <br>

    <button id="submitReview" onclick="submitReview()">Send inn din evaluering</button>

</body>
</html>