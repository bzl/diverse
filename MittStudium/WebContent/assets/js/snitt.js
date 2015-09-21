$( document ).ready(function() {
	var content;
	 $.get('assets/php/snitt.php', function(data) {
	        content = data;
	        $('#snittTabell').html(content);
	    });
});
