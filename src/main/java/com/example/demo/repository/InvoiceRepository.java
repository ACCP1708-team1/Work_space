package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{

	@Override
	@Query("from Invoice where id=:id and status=1")
	Optional<Invoice> findById(@Param("id") Integer id);

	@Override
	@Query("from Invoice where status=1")
	Iterable<Invoice> findAll();
	@Query("from Invoice i where account.id=:id_account and i.status =1")
	public List<Invoice> findAllByUser(@Param("id_account") int id_account);

	@Query(nativeQuery = true,value = "select *from Invoice i inner join Pay p on i.id=pay.id_invoice inner join invoiceDetail d i.id=d.id_invoice where i.id_account=:id_account and status =1 and (Select sum(paidMoney)form InvoiceDetail where id==i.id)<=(Select sum(money)form Pay where id==i.id)")
	public List<Invoice> findAllForUserComplete(@Param("id_account") int id_account);
	@Query(nativeQuery = true,value = "select *from Invoice i inner join Pay p on i.id=pay.id_invoice inner join invoiceDetail d i.id=d.id_invoice where i.id_account=:id_account and status =1 and i.end_date < getDate() and (Select sum(paidMoney)form InvoiceDetail where id==i.id)>(Select sum(money)form Pay where id==i.id)")
	public List<Invoice> findAllForUserExpired(@Param("id_account") int id_account);
	@Query(nativeQuery = true,value = "select *from Invoice i inner join Pay p on i.id=pay.id_invoice inner join invoiceDetail d i.id=d.id_invoice where i.id_account=:id_account and status =1 and i.end_date > getDate()  and (Select sum(paidMoney)form InvoiceDetail where id==i.id)>(Select sum(money)form Pay where id==i.id)")
	public List<Invoice> findAllForUserPaying(@Param("id_account") int id_account);
}
