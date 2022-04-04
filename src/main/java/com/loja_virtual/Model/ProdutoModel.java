package com.loja_virtual.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_produto")
public class ProdutoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_produto;
	
	@NotNull(message="codigo do produto cannot be null")
	private Long codigo_produto;
	
	@NotNull(message = "nome cannot be null")
	private String nome;
	
	@NotNull(message="marca cannot be null")
	private String marca;
	
	@NotNull(message="quantidade cannot be null")
	private String quantidade;
	
	@NotNull(message="preco cannot be null")
	private String preco;
	
	@NotNull(message="imagem cannot be null")
	@Lob
	private byte[] imagem_produto;
	
	public Long getCodigo_produto() {
		return codigo_produto;
	}
	public void setCodigo_produto(Long codigo_produto) {
		this.codigo_produto = codigo_produto;
	}
	
	public Long getId_produto() {
		return id_produto;
	}
	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public byte[] getImagem_produto() {
		return imagem_produto;
	}
	public void setImagem_produto(byte[] imagem_produto) {
		this.imagem_produto = imagem_produto;
	}
}
