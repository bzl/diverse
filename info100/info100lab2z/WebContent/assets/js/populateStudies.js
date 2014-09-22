$( document ).ready(function() {
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

				if (valgtStudie == "leggTilNytt") {
					leggTilNytt();
				}

			});
});

function evaluer() {
	window.location = "evaluer.php?skole=" + $("#first-choice").val()+"&studie="+ $("#second-choice").val();
}
function leggTilNytt() {
	window.location = "leggTilNyttStudie.php?skole=" + $("#first-choice").val();
}