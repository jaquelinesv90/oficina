package br.oficina.models;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalTimeConverter;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.oficina.enumeradores.StatusPagamento;
import br.oficina.enumeradores.StatusServico;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name= "AGENDAMENTO_SERVICO")
public class AgendamentoServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_agendamento_servico")
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name ="data_servico")
	private Date data;
	
	@Column(name="horario")
	@Convert(converter = LocalTimeConverter.class)
	private LocalTime horario;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status_servico")
	private StatusServico statusServico;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status_pagamento")
	private StatusPagamento statusPagamento;
	
	@Column(name="preco_cobrado", precision = 19, scale = 2)
	private BigDecimal precoCobrado;
	
	@Transient
	private String precoCobradoAux;
	
	@OneToOne
	@JoinColumn(name="fk_forma_pagamento")
	private FormaPagamento formaPagamento;
	
	private boolean lembrete;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="fk_proprietario")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="fk_servico_prestado")
	private ServicoPrestado servicoPrestado;
	
	@OneToOne
	@JoinColumn(name = "fk_mecanico")
	private Mecanico mecanico;
	
	public AgendamentoServico() {}
	
	public AgendamentoServico(Date data,LocalTime horario, BigDecimal precoCobrado,
			Cliente proprietario,ServicoPrestado servicoPrestado) {
		this.data = data;
		this.horario = horario;
		this.precoCobrado = precoCobrado;
		this.cliente = proprietario;
		this.servicoPrestado = servicoPrestado;
	}
	
	public boolean isFeito() {
		return StatusServico.FEITO.equals(this.statusServico);
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

	public ServicoPrestado getServicoPrestado() {
		return servicoPrestado;
	}

	public void setServicoPrestado(ServicoPrestado servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public StatusServico getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(StatusServico statusServico) {
		this.statusServico = statusServico;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public BigDecimal getPrecoCobrado() {
		return precoCobrado;
	}

	public void setPrecoCobrado(BigDecimal precoCobrado) {
		this.precoCobrado = precoCobrado;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public boolean isLembrete() {
		return lembrete;
	}

	public void setLembrete(boolean lembrete) {
		this.lembrete = lembrete;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public String getPrecoCobradoAux() {
		return precoCobradoAux;
	}

	public void setPrecoCobradoAux(String precoCobradoAux) {
		this.precoCobradoAux = precoCobradoAux;
	}
	
}
