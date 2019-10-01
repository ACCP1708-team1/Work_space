package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="category_name")
	private String categoryName;

	private byte status;

	private String title;
	private String avatar;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//bi-directional many-to-one association to Servicer
	@OneToMany(mappedBy="category")
	private List<Servicer> servicers;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Category() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public List<Servicer> getServicers() {
		return this.servicers;
	}

	public void setServicers(List<Servicer> servicers) {
		this.servicers = servicers;
	}

	public Servicer addServicer(Servicer servicer) {
		getServicers().add(servicer);
		servicer.setCategory(this);

		return servicer;
	}

	public Servicer removeServicer(Servicer servicer) {
		getServicers().remove(servicer);
		servicer.setCategory(null);

		return servicer;
	}

}