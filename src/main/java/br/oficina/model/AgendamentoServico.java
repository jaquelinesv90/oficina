package br.oficina.model;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "AGENDAMENTO_SERVICO")
public class AgendamentoServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_agendamento_servico",updatable = false, nullable = false)
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	private LocalTime horario;
	
	@Column(name="preco_cobrado")
	private String precoCobrado;
	
	@ManyToOne
	@JoinColumn(name="fk_servico")
	private ServicoPrestado servico;
	
	@ManyToOne
	@JoinColumn(name="fk_proprietario")
	private Proprietario proprietario;
	
	@ManyToOne
	@JoinColumn(name="fk_servico_prestado")
	private ServicoPrestado servicoPrestado;
	
	
	public AgendamentoServico() {}
	
	public AgendamentoServico(Date data,LocalTime horario, String precoCobrado,
			ServicoPrestado servico,Proprietario proprietario,ServicoPrestado servicoPrestado) {
		this.data = data;
		this.horario = horario;
		this.precoCobrado = precoCobrado;
		this.servico = servico;
		this.proprietario = proprietario;
		this.servicoPrestado = servicoPrestado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public ServicoPrestado getServico() {
		return servico;
	}

	public void setServico(ServicoPrestado servico) {
		this.servico = servico;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public ServicoPrestado getServicoPrestado() {
		return servicoPrestado;
	}

	public void setServicoPrestado(ServicoPrestado servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}

	public String getPrecoCobrado() {
		return precoCobrado;
	}

	public void setPrecoCobrado(String precoCobrado) {
		this.precoCobrado = precoCobrado;
	}
}
