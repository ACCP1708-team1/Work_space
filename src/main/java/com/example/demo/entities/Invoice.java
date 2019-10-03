package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	private byte status;

	@Column(name="total_price")
	private double totalPrice;

	//bi-directional many-to-one association to RegisterService
	@OneToOne
	@JoinColumn(name="id_register_service")
	private RegisterService registerService;

	//bi-directional many-to-one association to InvoceDetail
	@OneToMany(mappedBy="invoice")
	private List<InvoiceDetail> invoiceDetails;

	public Invoice() {
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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public RegisterService getRegisterService() {
		return this.registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public List<InvoiceDetail> getInvoceDetails() {
		return this.invoiceDetails;
	}

	public void setInvoceDetails(List<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public InvoiceDetail addInvoceDetail(InvoiceDetail invoiceDetail) {
		getInvoceDetails().add(invoiceDetail);
		invoiceDetail.setInvoce(this);

		return invoiceDetail;
	}

	public InvoiceDetail removeInvoceDetail(InvoiceDetail invoiceDetail) {
		getInvoceDetails().remove(invoiceDetail);
		invoiceDetail.setInvoce(null);

		return invoiceDetail;
	}

}