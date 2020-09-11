package com.example.supermarket.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PurchaseItemPK implements Serializable {

	private static final long serialVersionUID = -4305118565617089209L;

	@Column(name = "id_compra")
	private Integer purchaseId;

	@Column(name = "id_producto")
	private Integer productId;

}
