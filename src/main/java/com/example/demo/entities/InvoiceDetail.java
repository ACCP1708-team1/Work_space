package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="paid_money")
	private double paidMoney;

	private byte status;

	//bi-directional many-to-one association to Invoce
	@ManyToOne
	@JoinColumn(name="id_invoice")
	private Invoice invoice;

	public InvoiceDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public Invoice getInvoce() {
		return this.invoice;
	}

	public void setInvoce(Invoice invoice) {
		this.invoice = invoice;
	}

}