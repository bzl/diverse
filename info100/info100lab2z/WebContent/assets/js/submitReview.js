function submitReview(){

	var valgtStudie = $("#second-choice").text();
	var valgtSkole = $("#first-choice").text();

	var reviewText = $("#evaluering").text();
	var reviewAuthor = $("#evaluer_navn").text();
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
	    	 window.location = "kontakt.html";
	     }
	});
}