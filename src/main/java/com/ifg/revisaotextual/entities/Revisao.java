package com.ifg.revisaotextual.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Revisao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	private String caracteristicas;
	
	
	@ManyToMany 
	@JoinTable( name="servico_valor",
				joinColumns = @JoinColumn(name="id_servico"),
				inverseJoinColumns = @JoinColumn(name="id")
				)
	private List<ServicoValor> servicoValores = new ArrayList<>();

	public Revisao(Integer id, String descricao, String caracteristicas) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.caracteristicas = caracteristicas;
	}

	public Revisao() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public List<ServicoValor> getServicoValores() {
		return servicoValores;
	}

	public void setServicoValores(List<ServicoValor> servicoValores) {
		this.servicoValores = servicoValores;
	}
}
