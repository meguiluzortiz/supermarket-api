package com.example.supermarket.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class ClientEntity {

	@Id
	@Column(name = "id")
	private String clientId;

	@Column(name = "nombre")
	private String name;
	@Column(name = "apellidos")
	private String lastname;
	@Column(name = "celular")
	private Long phoneNumber;
	@Column(name = "direccion")
	private String address;

	@Column(name = "correo_electronico")
	private String email;

	@OneToMany(mappedBy = "client")
	private List<PurchaseEntity> purchases;

}
