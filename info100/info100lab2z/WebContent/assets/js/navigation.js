function main(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "main.html";
}

function plass(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "plass2.html"; // TEMPORARILY SET TO plass2

}

function studium(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "studium.html";

}

function bruker(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "bruker.html";
	
}

function kontakt(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "kontakt.html";
	
}

function evaluer(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "evaluer.html";
}

function leggTilNytt(){
	contentX = document.getElementById('contentFrame');
	contentX.src = "leggTilNyttStudie.html";
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