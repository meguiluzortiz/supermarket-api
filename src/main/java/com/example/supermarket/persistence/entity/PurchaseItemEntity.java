package com.example.supermarket.persistence.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class PurchaseItemEntity {
	@EmbeddedId
	private PurchaseItemPK purchaseItemId;

	@Column(name = "cantidad")
	private Integer quantity;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "estado")
	private Boolean active;

	@ManyToOne
	@MapsId("purchaseId")
	@JoinColumn(name = "id_compra", insertable = false, updatable = false)
	private PurchaseEntity purchase;

	@ManyToOne
	@JoinColumn(name = "id_producto", insertable = false, updatable = false)
	private ProductEntity product;

}
