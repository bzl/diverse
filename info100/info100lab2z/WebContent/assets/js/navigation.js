window.onload = function(){
	showAuthor();
};

function main(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "main.php";
}

function plass(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "plass.php";

}


function kontakt(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "kontakt.php";
	
}

function snitt(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "snitt.php";
	
}

function evaluer(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "evaluer.php";
}

function leggTilNytt(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "leggTilNyttStudie.php";
}


function resizeMe(){
	//console.log("ping");
	
	contentX = document.getElementById('contentFrame');
	contentX.style.height = "auto";
    var newheight = contentX.contentWindow.document.body.scrollHeight;
    
    if (newheight < 350){
    	newheight = 350;
    }

    contentX.style.height= (newheight) + "px";
}

var gitHubCaps = false;
function showGitHub() {
	if(gitHubCaps){
		document.getElementById("GitHub").innerHTML = "GitHub";
		gitHubCaps = false;
	} else {
		document.getElementById("GitHub").innerHTML = "github";
		gitHubCaps = true;
	}
}

function showAuthor(){
	
	var xmlhttp = new XMLHttpRequest();
	var url = "assets/json/author.json";
	var author;

	xmlhttp.onreadystatechange = function() {
	    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
	        author = JSON.parse(xmlhttp.responseText);
	        document.getElementById("author").innerHTML = author.firstName + " " + author.lastName;
	    }
	}
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
}