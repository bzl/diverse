function settSkoleOgStudie(){
	var skole;
	var studie;

	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i=0;i<vars.length;i++) {
		var pair = vars[i].split("=");
		if(pair[0] == "skole"){
			skole = decodeURI(pair[1]);
		} else if(pair[0] == "studie"){
			studie = decodeURI(pair[1]);
		}
	}

	if(typeof skole === 'undefined') {
		//essentially do nothing
	} else {
		$("#first-choice").empty();
		$("#first-choice")
		.append(
				"<option selected value=" + skole + ">" + skole + "</option>");
	}
	if(typeof studie === 'undefined') {
		//essentially do nothing
	} else {
		$("#second-choice").empty();
		$("#second-choice")
		.append(
				"<option selected value=" + studie + ">" + studie + "</option>");
	}
}