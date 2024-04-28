package br.oficina.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.oficina.model.AgendamentoServico;
import br.oficina.model.Cliente;
import br.oficina.model.ServicoPrestado;
import br.oficina.repository.AgendamentoServicoRepository;
import br.oficina.repository.ClienteRepository;
import br.oficina.repository.ServicoPrestadoRepository;

@Controller
@RequestMapping("/servico")
public class ServicoController {
	
	//@Autowired
	//private CarroRepository carroRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
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
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "buscar")
	public ModelAndView buscarCliente(@ModelAttribute("nome") final String nome) {
		
		Optional<Cliente> clientePesquisado = clienteRepository.findByNome(nome);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("clientePesquisado",clientePesquisado.get());
		
		System.out.println("CLIENTE ENCONTRADO " + clientePesquisado.get());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "salvar")
	public ModelAndView salvar(@ModelAttribute("agendamentoServico") final AgendamentoServico agendamento) {
		
		agendamentoRepository.save(agendamento);
		
		ModelAndView mv = new ModelAndView("agendarServico");
		mv.addObject("mensagem","Serviço agendado com sucesso");
		
		return mv;
	} 
}
