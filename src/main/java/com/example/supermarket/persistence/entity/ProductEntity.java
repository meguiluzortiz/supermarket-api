package com.example.supermarket.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer productId;

	@Column(name = "nombre")
	private String name;

	@Column(name = "id_categoria")
	private Integer categoryId;

	@Column(name = "codigo_barras")
	private String barcode;

	@Column(name = "precio_venta")
	private Double price;

	@Column(name = "cantidad_stock")
	private Integer stock;

	@Column(name = "estado")
	private Boolean active;

	@ManyToOne
	@JoinColumn(name = "id_categoria", insertable = false, updatable = false)
	private CategoryEntity category;

}
