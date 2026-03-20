
$(document).ready(function(){
	Datepicker.locales.pt = {
         days: ["Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"],
         daysShort: ["Seg", "Ter", "Quar", "Quin", "Sex", "Sab", "Dom"],
         daysMin: ["Se", "Te", "Qu", "Qui","Se", "Sa","Do"],
         months: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outobro", "Novembro", "Dezembro"],
         monthsShort: ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"],
         today: "Hoje",
         clear: "Limpar",
         titleFormat: "MM y"
    };
		
	const inputE1 = document.querySelector('.datepicker_input');
	const datepicker = new Datepicker(inputE1,{
		'format': 'dd/mm/yyyy',
		'language': 'pt',
		'todayHighlight': true,
		'daysOfWeekDisabled': [6]
	});
});

	function copiarChavePix(){
		let textoCopiado = document.getElementById("chaveCopiaCola");
		textoCopiado.select();
		textoCopiado.setSelectionRange(0,99999);
		
		document.execCommand("copy");
	}
	
	//cadastro QRCode - ao selecionar campo 'tipo'
	function aplicarMascara() {
	    setTimeout(function() {
	        const select = document.getElementById("tipoChavePix");
	        if (!select) {
	            console.log("Select ainda não existe");
	            return;
	        }
	        const valor = parseInt(select.value) || 0;
	        console.log("Valor selecionado:", valor);

			const descricaoChavePix = document.getElementById("descricaoChavePix");
	        //const $input = $('.descricaoChavePix');
			
			$(descricaoChavePix).val('').unmask(); 
			
	        switch (valor) { 
	            case 2: $(descricaoChavePix).mask("00.000.000/0000-00", { reverse: true}); break;
	            case 3: $(descricaoChavePix).mask("000.000.000-00", { reverse: true }); break;
	            case 4: $(descricaoChavePix).unmask(); break;
	            case 5: $(descricaoChavePix).mask('(00)00000-0000', { reverse: true }); break;
	            default: $(descricaoChavePix).unmask();
	        }
			$(descricaoChavePix).trigger('descricaoChavePix')
	        console.log("Máscara aplicada!");
	    }, 500);  // 500ms geralmente basta, aumente para 1000 se precisar
	}

	
	function pesquisarUsuarioModal(){
		
		var nome = $('#nomePesquisa').val();
		
		if(nome != null){
			
		 $.ajax({
			type:'GET',
		 	url : "pesquisa",
		 	data : "nomePesquisa=" + nome,
		 	success : function(response) {
				$('#tabelaResultados > tbody > tr').remove();
				
				for(var i = 0; i < response.length; i++){
					
					$('#tabelaResultados > tbody').append('<tr class="text-center"><td>' + response[i].id + '</td><td>'+ response[i].nome +'</td><td><a class="btn btn-link btn-xs" title="Adicionar" rel="tooltip" data-placement="top"  onclick="adicionarClientePesqModalNoFormulario('+response[i].id +')" > <i class="bi bi-plus-circle-fill ws-color-gray"></i></a></td></tr>');
				}		
			  }
		}).fail(function(jqXHR,textStatus, errorThrown){
			
			console.log("Erro ao pesquisar usuario");
			console.log("text status " + jqXHR.responseText);
			console.log("text errorThrown " + jqXHR.status);
			
			// Cria uma div dinamicamente
			    const divMensagem = $('<div></div>') // Cria a div com jQuery
			        .text('Cliente não encontrado!') // Define o texto
			        .addClass('alert alert-danger') // Adiciona uma classe para estilização
			
			    // Adiciona a div a um elemento com ID 'mensagem' (ou outro container)
			    $('#mensagem').append(divMensagem);
			
		});
		}
	};
	
	//funcao na modal de pesquisar cliente
	function adicionarClientePesqModalNoFormulario(id){
		
		 $.ajax({
			type:'GET',
		 	url : "pesquisaPorId",
		 	data : "id=" + id,
		 	success : function(response) {
				
				$("#nome").val(response.nome);
				$("#id").val(response.id);
				$("#pesquisaClienteModal").modal('hide');
				console.log("nome + id "+response.nome + response.id);
			  }
		}).fail(function(xhr,status,errorThrown){
			console.log("Erro ao buscar usuario por id "+xhr.responseText + status + errorThrown);
	});
   }
   
   function limparCamposAoFecharModal(){
		 
		 let mensagem = document.getElementById("mensagem");
		 mensagem.innerText="";
		 
		 $('#nomePesquisa').val('');
   }
   
   // mascaras de telefone e celular
   function mask(o, f) {
		  setTimeout(function() {
		    var v = mphone(o.value);
		    if (v != o.value) {
		      o.value = v;
		    }
		  }, 1);
	}
	

   function mphone(v) {
		  var r = v.replace(/\D/g, "");
		  r = r.replace(/^0/, "");
		  if (r.length > 10) {
		    r = r.replace(/^(\d\d)(\d{5})(\d{4}).*/, "($1) $2-$3");
		  } else if (r.length > 5) {
		    r = r.replace(/^(\d\d)(\d{4})(\d{0,4}).*/, "($1) $2-$3");
		  } else if (r.length > 2) {
		    r = r.replace(/^(\d\d)(\d{0,5})/, "($1) $2");
		  } else {
		    r = r.replace(/^(\d*)/, "($1");
		  }
		  return r;
	}
    
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
	$('.js-currency').maskMoney({prefix:'R$' ,thousands:'', decimal:'.', allowZero:true });
	
		
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
		 	success : function(response) {
					 
					for (var i = 0; i < response.length; i++) {
				     $('#modelos').attr("disabled",false);	
				     
		        	  s += '<option value="' +  + response[i].id  + '">'+ response[i].nome + '</option>';
		        	  
		        	}
		        	$('#modelos').html(s);
			  }
		});
	});
	
	
	$('.js-preenche-combo-servicoPrestado-por-tipoServico').on('change', function(event) {
		
		 var tipoServicoId = $(this).val();
		 var s = '<option value=' + -1 + '>Selecione</option>';
		 
		 $.ajax({
			type:'GET',
		 	url : '/agendamento/' + tipoServicoId + '/pesquisaServico',
		 	success : function(response) {
					 
					for (var i = 0; i < response.length; i++) {
				     $('#servicos').attr("disabled",false);	
				     
		        	  s += '<option value="' +  + response[i].id  + '">'+ response[i].descricao + '</option>';
		        	  
		        	}
		        	$('#servicos').html(s);
			  }
		});
	});
	
});
