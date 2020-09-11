package com.example.supermarket.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compras")
public class PurchaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private Integer purchaseId;

	@Column(name = "id_cliente")
	private String clientId;

	@Column(name = "fecha")
	private LocalDateTime date;

	@Column(name = "medio_pago")
	private String paymentMethod;

	@Column(name = "comentario")
	private String comment;

	@Column(name = "estado")
	private String state;

	@ManyToOne
	@JoinColumn(name = "id_cliente", insertable = false, updatable = false)
	private ClientEntity client;

	@OneToMany(mappedBy = "purchase", cascade = {CascadeType.ALL})
	private List<PurchaseItemEntity> items;

}
