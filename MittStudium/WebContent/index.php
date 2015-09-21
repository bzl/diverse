<!DOCTYPE html>
<html>
<head>
<?php
echo 	'<meta charset="utf-8">' .
		'<title>Mitt Studium</title>' .
		'<link rel="stylesheet" href="assets/css/stylesheet.css" type="text/css" media="screen, print, projection, tv"/>' .
		'<link rel="stylesheet" href="assets/css/mobile.css" type="text/css" media="handheld" />' .
		'<script type="text/javascript" src="assets/js/navigation.js"></script>' .
		'<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>';
?>
</head>
<body>

	<header>
		<a class="logo" onclick="main()"><img class="logo" style="align: ceter" src="assets/pictures/logo.png"></a>
		<nav>
			<ul id="menu">
			<?php
			$array = array(	'<li><button onclick="plass()">Finn din undervisningsplass</button></li>',
							'<li><button onclick="leggTilNytt()">Registrer et nytt studie</button></li>',
							'<li><button onclick="evaluer()">Evaluer et Studium</button></li>',
							'<li><button onclick="snitt()">Statistikk for studier</button></li>',
							'<li><form style="width: 100%">
							<input type="search" name="siteSearch" placeholder="Søk på denne siden..." style="border: 1px solid; width: 80%;">
							</form></li>');
							
			foreach ($array as $navigationElement) {
            	echo $navigationElement;
          	}
			?>
			
			
				
				
				
				
				
			</ul>
		</nav>
	</header>

	<div class=content>
		<iframe id="contentFrame" name="content" class="mainFrame" src="main.php" onload="resizeMe()">This site primarily works
			because of Iframes, and it looks like your web browser is having a hard time comprehending the idea of "iframes"</iframe>
	</div>

	<footer>
		<p align="center">
			Created by <span id="author"> </span>, 
			<button type="button" onclick="showGitHub()">Skift navn:</button><a id="GitHub"
				href="https://github.com/bzl/skolen/tree/master/info100/info100lab2z">GitHub</a>
		</p>
	</footer>

</body>
</html>