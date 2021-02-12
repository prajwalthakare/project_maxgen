package com.java.entity;// default package
// Generated 11 Feb, 2021 7:51:03 PM by Hibernate Tools 5.2.3.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Addcard generated by hbm2java
 */
@Entity
@Table(name = "addcard", catalog = "medical_stock")
public class Addcard implements java.io.Serializable {

	private Integer id;
	private String medname;
	private String quantity;
	private String prize;

	public Addcard() {
	}

	public Addcard(String medname, String quantity, String prize) {
		this.medname = medname;
		this.quantity = quantity;
		this.prize = prize;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "Medname")
	public String getMedname() {
		return this.medname;
	}

	public void setMedname(String medname) {
		this.medname = medname;
	}
	@Column(name = "Quantity")
	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Column(name = "Prize")
	public String getPrize() {
		return this.prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

}
