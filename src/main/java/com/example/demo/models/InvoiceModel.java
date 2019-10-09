package com.example.demo.models;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Account;
import com.example.demo.entities.Invoice;
import com.example.demo.entities.InvoiceDetail;
import com.example.demo.entities.Servicer;
import com.example.demo.repository.InvoiceRepository;
@Component
public class InvoiceModel implements ModelInteface<Invoice>{
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private ServiceModel serviceModel;
	@Autowired
	private AccountModel accountModel;
	@Autowired
	InvoiceDetailModel invoiceDetailModel;
	@Override
	public List<Invoice> findAll() {
		// TODO Auto-generated method stub
		return (List<Invoice>) invoiceRepository.findAll();
	}

	@Override
	public Invoice findById(int id) {
		// TODO Auto-generated method stub
		return invoiceRepository.findById(id).get();
	}

	@Override
	public Invoice save(Invoice k) {
		// TODO Auto-generated method stub
		return invoiceRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		invoiceRepository.deleteById(id);
	}
	public List<Invoice> findAllForUser( int id_account) {
		// TODO Auto-generated method stub
		return (List<Invoice>) invoiceRepository.findAllByUser(id_account);
	}
	public List<Invoice> findExpiredForUser(int id_account) {
		return invoiceRepository.findAllForUserExpired(id_account);
	}
	public List<Invoice> findCompleteForUser(int id_account) {
		return invoiceRepository.findAllForUserComplete(id_account);
	}
	public List<Invoice> findPayingForUser(int id_account) {
		return invoiceRepository.findAllForUserPaying(id_account);
	}
	public Invoice registerService(int idAccount,List<Integer> listIdService,Invoice invoice) {
		Account account=accountModel.findById(idAccount);
		invoice.setAccount(account);
		invoice.setCreateDate(new Date());
		invoice.setStatus((byte) 1);
		invoice=save(invoice);
		for (Integer idService : listIdService) {
			Servicer servicer=serviceModel.findById(idService);
			InvoiceDetail  invoiceDetail=new InvoiceDetail();
			invoiceDetail.setServicer(servicer);
			invoiceDetail.setInvoice(invoice);
			invoiceDetailModel.save(invoiceDetail);
			invoice.addInvoiceDetail(invoiceDetail);
		}
		return invoice;
	}
	public InvoiceModel() {
		super();
	}
	
}
