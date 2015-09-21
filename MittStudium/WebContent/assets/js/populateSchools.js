function initializeSchools(){
	var content;
    $.get('assets/php/skoler.php', function(data) {
        content = data;
        $('#first-choice').append(content);
    });
}