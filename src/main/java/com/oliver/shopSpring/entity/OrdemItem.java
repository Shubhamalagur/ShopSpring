package com.oliver.shopSpring.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oliver.shopSpring.entity.fk.OrdemItemPk;

@Entity
@Table(name = "TB_ORDEM_ITEM")
public class OrdemItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//id composto 
	@EmbeddedId
	private OrdemItemPk idPk;
	
	private Integer quantidade;
	private Double preco;
	
	

	public OrdemItem() {
		super();
	}

	public OrdemItem(OrderEntity ordem, ProductEntity produto , Integer quantidade, Double preco) {
		//
		idPk = new OrdemItemPk();//
		idPk.setOrdem(ordem);
		idPk.setProduto(produto);
		
		this.quantidade = quantidade;
		this.preco = preco;
	}

	//
	@JsonIgnore
	public OrderEntity getOrdem() {
		return idPk.getOrdem();
	}
	public void setOrdem(OrderEntity ordem) {
		 idPk.setOrdem(ordem);
	}
	
	//
	public ProductEntity getProduto() {
		return idPk.getProduto();
	}
	public void setProduto(ProductEntity produto) {
		 idPk.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPk == null) ? 0 : idPk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemItem other = (OrdemItem) obj;
		if (idPk == null) {
			if (other.idPk != null)
				return false;
		} else if (!idPk.equals(other.idPk))
			return false;
		return true;
	}
	
	
	
	

}
