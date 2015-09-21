function submitReview(){

	var valgtStudie = $("#second-choice").val();
	var valgtSkole = $("#first-choice").val();

	var reviewText = $("#evaluering").val();
	var reviewAuthor = $("#evaluer_navn").val();
	var review = "\"" + reviewText + "\" - " + reviewAuthor;
	
	var score = $("#score").val();

	var url = encodeURI("assets/php/leggTilEvaluering.php?skole=" + valgtSkole + "&studie=" + valgtStudie + "&review=" + review + "&score=" + score);
	var content;
	
	$.ajax({
	     async: false,
	     type: 'GET',
	     url: url,
	     success: function(data) {
	    	 content = data;
	    	 window.location = "kontakt.php";
	     }
	});
}