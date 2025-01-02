
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


$('#confirmacaoExclusaoModalAgendamento').on('show.bs.modal',function(event){
	var buttonExcluir = $(event.relatedTarget);
	
	var codigo = buttonExcluir.data('codigo');
	var nomeCliente = buttonExcluir.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.attr('action');
	
	if(!action.endsWith('/')){
		action +='/';
	}
	form.attr('action',action + codigo);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o <strong>' + nomeCliente + '</strong>?');
});


$('#confirmacaoExclusaoModalCliente').on('show.bs.modal',function(event){
	var buttonExcluir = $(event.relatedTarget);
	
	var codigo = buttonExcluir.data('codigo');
	var nomeCliente = buttonExcluir.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.attr('action');
	
	if(!action.endsWith('/')){
		action +='/';
	}
	form.attr('action',action + codigo);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o <strong>' + nomeCliente + '</strong>?');
});

$(function() {
	
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({thousands:'', decimal:'.', allowZero:true });
	
		
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
						
			$('[data-role=' + codigoAgendamento + ']').html('<span class="badge text-bg-success">' + e + '</span>');
			
			botaoFeito.hide();
		});
		
		response.fail(function(e){
			console.log(e);
			alert('Erro ao atualizar o status do servico');
		});
	});
	
	
	$('.js-preenche-combo-modelo-por-marca').on('change', function(event) {
	
		 var marcaId = $(this).val();
		 var s = '<option value=' + -1 + '>Selecione</option>';
		 
		 $.ajax({
			type:'GET',
		 	url : '/cliente/' + marcaId + '/pesquisaModelo',
		 	success : function(result) {
					var result = JSON.parse(result);
					 
					for (var i = 0; i < result.length; i++) {
		        	  s += '<option value="' + result["id"] + '">'+ result[i].nome + '</option>';
		        	}
		        	$('#modelos').html(s);
			  }
		});
	});
	
});
