function initializeStudies(){
	$("#first-choice")
	.change(
			function() {
				$("#evalueringer").empty();

				var valgtSkole = $("#first-choice").val();
				var url = encodeURI("assets/php/studier.php?skole="
						+ valgtSkole);
				var content;
				$
				.get(
						url,
						function(data) {
							content = data;

							$("#second-choice").empty();
							$("#second-choice")
							.append(
									"<option selected value=\"base\">Velg en utdanning</option>");
							$('#second-choice').append(
									content);
							$("#second-choice")
							.append(
							"<option value=\"leggTilNytt\">Finner ikke min utdanning</option>");
						});

			});

	$("#second-choice")
	.change(
			function() {
				var valgtStudie = $("#second-choice").val();
				var valgtSkole = $("#first-choice").val();

				if (valgtStudie == "leggTilNytt") {
					leggTilNytt();
				} else {

					$("#evalueringer").empty();
					$("#evalueringer")
					.append(
					"<a class=\"lenke\" onclick=\"evaluer()\" ><li> Trykk her for å legge til en evaluering av dette studiet </li></a>");

					var url = encodeURI("assets/php/evalueringer.php?skole="
							+ valgtSkole + "&studie=" + valgtStudie);
					var content;
					$.get(url, function(data) {
						content = data;
						$('#evalueringer').prepend(content);
					});

				}
			});
}

function evaluer() {
	window.location = "evaluer.html";
}
function leggTilNytt() {
	window.location = "leggTilNyttStudie.html";
}