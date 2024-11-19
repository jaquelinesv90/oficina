
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


$('#confirmacaoExclusaoModal').on('show.bs.modal',function(event){
	
	var buttonExcluir = $(event.relatedTarget);
	
	var codigoAgendamento = buttonExcluir.data('codigo');
	var nomeCliente = buttonExcluir.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.attr('action');
	if(!action.endsWith('/')){
		action +='/';
	}
	form.attr('action',action + codigoAgendamento);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o <strong>' + nomeCliente + '</strong>?');
});

$(function() {
	$('.js-servico-feito').on('click', function(event){
		event.preventDefault();
		
		var botaoFeito = $(event.currentTarget);
		var urlFeito = botaoFeito.attr('href');
		
		var response = $.ajax({
			url: urlFeito,
			type:'PUT'
		});
			
		response.done(function(e) {
			var codigoAgendamento = botaoFeito.data('codigo');
						
			$('[data-role=' + codigoAgendamento + ']').html('<span class="label label-success">' + e + '</span>');
			
			botaoFeito.hide();
		});
		
		response.fail(function(e){
			console.log(e);
			alert('Erro ao atualizar o status do servico');
		});
		
	});
	
	
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
