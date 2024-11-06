
$(document).ready(function(){
    $('input.timepicker').timepicker({
        timeFormat: 'HH:mm',
        minTime: '11:45', // 11:45:00 AM
        maxHour: 20,
        maxMinutes: 30,
        startTime: new Date(0,0,0,15,0,0), // 3:00:00 PM - noon
        interval: 15 // 15 minutes
    });
});


$(function() {
	$('[rel="tooltip"]').tooltip();
		
	$('.js-atualizar-combobox-modelo').on('change', function(event) {
		event.preventDefault();
		
		var botaoReceber = $(event.currentTarget);
		var urlReceber = botaoReceber.attr('href');
		
		var response = $.ajax({
			url: urlReceber,
			type:'GET'
		});
		
		response.done(function(e){
			
		});
		
		response.fail(function(e){
			console.log(e);
			
		});
				
	});
});
