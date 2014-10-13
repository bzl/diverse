

function myFunction(arr) {
	var out = "<tr> <th>Skole</th> <th>Fag</th> <th>Navn</th> <th>Score</th> <th>Vurdering</th>  </tr> ";
	var i;
	for(i = 0; i < arr.length; i++) {
		out += '<a href="' + arr[i].url + '">' + arr[i].display + '</a><br>';
		out += 	"<tr> <th>"+ arr[i].skole +
		"</th> <th>"+arr[i].fag +
		"</th> <th>"+ arr[i].navn +
		"</th> <th>"+ arr[i].score +
		"</th> <th>"+ arr[i].vurdering +
		"</th>  </tr>";
	}
	document.getElementById("resultater").innerHTML = out;
}

window.onload = function(){
	var xmlhttp = new XMLHttpRequest();
	var url = "assets/json/vurderinger.json";
	var author;

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			author = JSON.parse(xmlhttp.responseText);
			myFunction(myArr);
		}
	}
	xmlhttp.open("GET", url, true);
	xmlhttp.send();

}