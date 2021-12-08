package org.generation.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_produto;
	
	@NotBlank (message = "O campo categoria nao pode estar vazio.")
	@Size(min = 3, max = 100, message = "O campo categoria deve conter no minimo 10 caracteres.")
	private String nome;
	
	@NotNull (message = "O campo preco nao pode estar vazio.")
	private double preco;
	
	@NotBlank (message = "O campo marca nao pode estar vazio.")
	@Size(min = 3, max = 100, message = "O campo categoria deve conter no minimo 10 caracteres.")
	private String marca;
	
	@NotBlank (message = "O campo tipoUso nao pode estar vazio.")
	@Size(min = 3, max = 100, message = "O campo tipoUso deve conter no minimo 10 caracteres.")
	private String tipoUso;
	
	//criando fk para relacionar com a tabela categoria
	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private Categoria categoria;
	

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipoUso() {
		return tipoUso;
	}

	public void setTipoUso(String tipoUso) {
		this.tipoUso = tipoUso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
