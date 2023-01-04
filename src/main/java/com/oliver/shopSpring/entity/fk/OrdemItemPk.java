package com.oliver.shopSpring.entity.fk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.oliver.shopSpring.entity.OrderEntity;
import com.oliver.shopSpring.entity.ProductEntity;

@Embeddable
public class OrdemItemPk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//chaves compostas 
	@ManyToOne
	@JoinColumn(name = "ORDEM_ID")
	private OrderEntity ordem;
	
	@ManyToOne
	@JoinColumn(name = "ORDEM_ID")
	private ProductEntity produto;
	
	
	public OrderEntity getOrdem() {
		return ordem;
	}
	public void setOrdem(OrderEntity ordem) {
		this.ordem = ordem;
	}
	public ProductEntity getProduto() {
		return produto;
	}
	public void setProduto(ProductEntity produto) {
		this.produto = produto;
	}
	
	

}
