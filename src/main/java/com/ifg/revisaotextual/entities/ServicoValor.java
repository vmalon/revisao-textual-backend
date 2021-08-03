package com.ifg.revisaotextual.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ifg.revisaotextual.enums.CobrancaEnum;


@Entity
public class ServicoValor implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer id_servico;
	
	
	private CobrancaEnum forma_pagamento;
	private Double valor;

	// Construtor
	public ServicoValor(Integer id, String formaPagamento, Double valor) {
		super();
		this.id_servico = id;
		this.forma_pagamento = CobrancaEnum.verificacaoId(formaPagamento);
		this.valor = valor;
	}

	// Sobrecarga de construtor
	public ServicoValor(String formaPagamento, Double valor) {
		super();
		this.forma_pagamento = CobrancaEnum.verificacaoId(formaPagamento);
		this.valor = valor;
	}

	public ServicoValor() {
		super();
	}
	
	public CobrancaEnum getFormaPagamento() {
		return forma_pagamento;
	}

	public void setFormaPagamento(CobrancaEnum formaPagamento) {
		this.forma_pagamento = formaPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdServico() {
		return id_servico;
	}

	public void setIdServico(Integer idServico) {
		this.id_servico = idServico;
	}

}