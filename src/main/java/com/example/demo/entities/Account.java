package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_account")
	private int idAccount;

	private String address;

	private String avatar;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;

	private String email;

	private String facebook;

	private String fullname;

	private String password;

	private String phone;

	private byte sex;

	private byte status;

	private String username;

	//bi-directional many-to-one association to AccountRole
	@ManyToOne
	@JoinColumn(name="id_account_role")
	private AccountRole accountRole;

	//bi-directional many-to-one association to CustomerReport
	@OneToMany(mappedBy="account")
	private List<CustomerReport> customerReports;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="account")
	private List<Invoice> invoices;

	public Account() {
	}

	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte getSex() {
		return this.sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AccountRole getAccountRole() {
		return this.accountRole;
	}

	public void setAccountRole(AccountRole accountRole) {
		this.accountRole = accountRole;
	}

	public List<CustomerReport> getCustomerReports() {
		return this.customerReports;
	}

	public void setCustomerReports(List<CustomerReport> customerReports) {
		this.customerReports = customerReports;
	}

	public CustomerReport addCustomerReport(CustomerReport customerReport) {
		getCustomerReports().add(customerReport);
		customerReport.setAccount(this);

		return customerReport;
	}

	public CustomerReport removeCustomerReport(CustomerReport customerReport) {
		getCustomerReports().remove(customerReport);
		customerReport.setAccount(null);

		return customerReport;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setAccount(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setAccount(null);

		return invoice;
	}

}