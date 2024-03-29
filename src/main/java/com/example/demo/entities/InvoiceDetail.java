package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invoice_detail database table.
 * 
 */
@Entity
@Table(name="invoice_detail")
@NamedQuery(name="InvoiceDetail.findAll", query="SELECT i FROM InvoiceDetail i")
public class InvoiceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="paid_money")
	private double paidMoney;

	private byte status;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	@JoinColumn(name="id_invoice")
	private Invoice invoice;

	//bi-directional many-to-one association to Servicer
	@ManyToOne
	@JoinColumn(name="id_service")
	private Servicer servicer;

	public InvoiceDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPaidMoney() {
		return this.paidMoney;
	}

	public void setPaidMoney(double paidMoney) {
		this.paidMoney = paidMoney;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Servicer getServicer() {
		return this.servicer;
	}

	public void setServicer(Servicer servicer) {
		this.servicer = servicer;
	}

}