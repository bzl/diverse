function submitReview(){

    
    var valgtStudie = $("#second-choice").val();
                var valgtSkole = $("#first-choice").val();
                
                var reviewText = $("#evaluering").val();
                var reviewAuthor = $("#evaluer_navn").val();
                var review = "\"" + reviewText + "\" - " + reviewAuthor;
    
    var url = encodeURI("assets/php/submitReview.php?skole=" + valgtSkole + "&studie=" + valgtStudie + "&review" + review);
                    var content;
                    $.get(url, function(data) {
                        content = data;
                        $('#evalueringer').prepend(content);
                    });
}