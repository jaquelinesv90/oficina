package br.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.model.AgendamentoServico;
import br.oficina.model.Cliente;
import br.oficina.model.ServicoPrestado;
import br.oficina.repository.AgendamentoServicoRepository;
import br.oficina.repository.ServicoPrestadoRepository;
import br.oficina.service.AgendamentoServicoService;
import br.oficina.service.ClienteService;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoServicoController {
	
	@Autowired
	AgendamentoServicoService agendamentoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ServicoPrestadoRepository servicoRepository;
	
	@Autowired
	private AgendamentoServicoRepository agendamentoRepository;
	
	
	@RequestMapping("/novo")
	public ModelAndView novoServico() {
		
		List<ServicoPrestado> todosServicos = servicoRepository.findAll();
		ModelAndView mv = new ModelAndView("agendarServico");
		mv.addObject("listaServicos", todosServicos);
				
		return mv;
	}
	
	
	@RequestMapping
	public ModelAndView pesquisarCliente(@RequestParam(defaultValue = "%")String nome) {
		
		List<Cliente> clientes = clienteService.findByNomeContaining(nome);
		
		ModelAndView mv = new ModelAndView("agendarServico");
		mv.addObject("clientePesquisado",clientes);
		
		return mv;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET) 
	public String adicionarClienteAoServico(@PathVariable Long id) {
		Cliente cliente = new Cliente();
		cliente = clienteService.findById(id);
		
		AgendamentoServico servico = new AgendamentoServico();
		servico.setCliente(cliente);
				
		return "redirect:/agendamento";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "salvar")
	public ModelAndView salvar(@ModelAttribute("agendamentoServico") final AgendamentoServico agendamento) {
		
		agendamentoRepository.save(agendamento);
		
		ModelAndView mv = new ModelAndView("agendarServico");
		mv.addObject("mensagem","Serviço agendado com sucesso");
		
		return mv;
	} 
	
	@RequestMapping(value = "/pesquisarAgendamento") 
	public ModelAndView abrirPaginaPesquisaAgendamento() {
		
		List<AgendamentoServico> todosAgendamentos = agendamentoService.findAll();
		
		ModelAndView mv = new ModelAndView("pesquisarAgendamento");
		mv.addObject("listaClientes",todosAgendamentos);
		
		return mv;
	}	
}
