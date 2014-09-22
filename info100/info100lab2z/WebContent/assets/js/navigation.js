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