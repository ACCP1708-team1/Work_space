package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicer database table.
 * 
 */
@Entity
@NamedQuery(name="Servicer.findAll", query="SELECT s FROM Servicer s")
public class Servicer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String avatar;

	private int description;

	private byte status;

	private String title;

	//bi-directional many-to-one association to InvoiceDetail
	@OneToMany(mappedBy="servicer")
	private List<InvoiceDetail> invoiceDetails;

	//bi-directional many-to-one association to ServicePhoto
	@OneToMany(mappedBy="servicer")
	private List<ServicePhoto> servicePhotos;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;

	public Servicer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getDescription() {
		return this.description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<InvoiceDetail> getInvoiceDetails() {
		return this.invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public InvoiceDetail addInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().add(invoiceDetail);
		invoiceDetail.setServicer(this);

		return invoiceDetail;
	}

	public InvoiceDetail removeInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().remove(invoiceDetail);
		invoiceDetail.setServicer(null);

		return invoiceDetail;
	}

	public List<ServicePhoto> getServicePhotos() {
		return this.servicePhotos;
	}

	public void setServicePhotos(List<ServicePhoto> servicePhotos) {
		this.servicePhotos = servicePhotos;
	}

	public ServicePhoto addServicePhoto(ServicePhoto servicePhoto) {
		getServicePhotos().add(servicePhoto);
		servicePhoto.setServicer(this);

		return servicePhoto;
	}

	public ServicePhoto removeServicePhoto(ServicePhoto servicePhoto) {
		getServicePhotos().remove(servicePhoto);
		servicePhoto.setServicer(null);

		return servicePhoto;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}