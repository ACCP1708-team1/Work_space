package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.InvoiceDetail;
import com.example.demo.repository.InvoiceDetailRepository;

public class InvoiceDetailModel implements ModelInteface<InvoiceDetail>{
	@Autowired
	private InvoiceDetailRepository invoiceRepository;
	@Override
	public List<InvoiceDetail> findAll() {
		// TODO Auto-generated method stub
		return (List<InvoiceDetail>) invoiceRepository.findAll();
	}

	@Override
	public InvoiceDetail findById(int id) {
		// TODO Auto-generated method stub
		return invoiceRepository.findById(id).get();
	}

	@Override
	public InvoiceDetail save(InvoiceDetail k) {
		// TODO Auto-generated method stub
		return invoiceRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		invoiceRepository.deleteById(id);
	}

}
