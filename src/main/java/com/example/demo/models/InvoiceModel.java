package com.example.demo.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Invoice;
import com.example.demo.repository.InvoiceRepository;

public class InvoiceModel implements ModelInteface<Invoice>{
	@Autowired
	private InvoiceRepository invoiceRepository;
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

}
