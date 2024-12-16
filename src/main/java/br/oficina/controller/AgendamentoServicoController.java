package br.oficina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.filter.PesquisaClienteFilter;
import br.oficina.model.AgendamentoServico;
import br.oficina.model.Cliente;
import br.oficina.model.FormaPagamento;
import br.oficina.model.ServicoPrestado;
import br.oficina.repository.AgendamentoServicoRepository;
import br.oficina.repository.ServicoPrestadoRepository;
import br.oficina.service.AgendamentoServicoService;
import br.oficina.service.ClienteService;
import br.oficina.service.FormaPagamentoService;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoServicoController {
	
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ServicoPrestadoRepository servicoRepository;
	
	@Autowired
	private AgendamentoServicoRepository agendamentoRepository;
	
	@Autowired
	private AgendamentoServicoService agendamentoServicoService;
	
	@Autowired
	private FormaPagamentoService formaPagamentoService;
	
	public static final String AGENDAR_SERVICO = "agendarServico";
	
	
	@RequestMapping("/novo")
	public ModelAndView novoServico() {
		
		List<ServicoPrestado> todosServicos = servicoRepository.findAll();
		List<FormaPagamento> formasDePagamento = formaPagamentoService.findAll();
		
		ModelAndView mv = new ModelAndView(AGENDAR_SERVICO);
		
		mv.addObject("listaServicos", todosServicos);
		mv.addObject("listaPagamentos", formasDePagamento);
				
		return mv;
	}
	
	//modal - na hora de agendar um servico
	@RequestMapping(method=RequestMethod.GET,value="/pesquisa") 
	public ModelAndView pesquisarCliente(@RequestParam(defaultValue="%") @ModelAttribute("nome") PesquisaClienteFilter filtro) {
		String nome = filtro.getNome() == null ? "%" : filtro.getNome();
		
		List<Cliente> clientes = clienteService.findByNomeContaining(nome);
			
		ModelAndView mv = new ModelAndView();
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
		
		ModelAndView mv = new ModelAndView(AGENDAR_SERVICO);
		mv.addObject("mensagem","Serviço agendado com sucesso");
		
		return mv;
	} 
	
	@RequestMapping(value = "/pesquisarAgendamento") 
	public ModelAndView abrirPaginaPesquisaAgendamento() {
		
		List<AgendamentoServico> todosAgendamentos = agendamentoServicoService.findAll();
		
		ModelAndView mv = new ModelAndView("pesquisarAgendamento");
		mv.addObject("listaAgendamentos",todosAgendamentos);
		
		return mv;
	}	
	
	@RequestMapping(method=RequestMethod.GET) 
	public ModelAndView pesquisar(@ModelAttribute("filtro") PesquisaClienteFilter nome) {
		List<AgendamentoServico> todosAgendamentos = agendamentoServicoService.pesquisar(nome.getNome());
		ModelAndView mv = new ModelAndView("pesquisarAgendamento");
		mv.addObject("listaAgendamentos",todosAgendamentos);
		
		return mv;
	}
	
	@RequestMapping(value="/{idAgendamento}/feito", method = RequestMethod.PUT)
	public @ResponseBody String marcarServicoComoFeito(@PathVariable Long idAgendamento) {
		return agendamentoServicoService.marcarServicoComoFeito(idAgendamento);
	}
	
	
	@RequestMapping("/{idAgendamento}")
	public ModelAndView editar(@PathVariable Long id) {
		AgendamentoServico agendamento = agendamentoServicoService.getOne(id);
		ModelAndView mv = new ModelAndView(AGENDAR_SERVICO);
		mv.addObject("clientePesquisado",agendamento);
		return mv;
	}
	
	@RequestMapping(value="{idAgendamento}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long idAgendamento) {
		agendamentoServicoService.excluir(idAgendamento);
		
		return "redirect:/index";
	}
}
