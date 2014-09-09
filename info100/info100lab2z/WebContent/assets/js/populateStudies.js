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

					var url2 = encodeURI("assets/php/score.php?skole="
							+ valgtSkole + "&studie=" + valgtStudie);
					var poeng;
					$.ajax({
						async: false,
						type: 'GET',
						url: url2,
						success: function(data) {
							poeng = data;
						},
						error: function(){
							poeng = "5";
						}
					});

					var score_text = "Dette studiet har i snitt fått "+poeng+" av 10. Du kan være med på å evaluere det!";


					$("#score").text(score_text);

				}
			});
}

function evaluer() {
	window.location = "evaluer.html?skole=" + $("#first-choice").val()+"&studie="+ $("#second-choice").val();
}
function leggTilNytt() {
	window.location = "leggTilNyttStudie.html?skole=" + $("#first-choice").val();
}