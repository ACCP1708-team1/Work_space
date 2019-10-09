package com.example.demo.models;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Faq;
import com.example.demo.repository.FaqRepository;

@Service
public class FaqModel implements ModelInteface<Faq> {
	private FaqRepository faqRepository;

	@Override
	public List<Faq> findAll() {
		// TODO Auto-generated method stub
		return (List<Faq>) faqRepository.findAll();
	}

	@Override
	public Faq findById(int id) {
		// TODO Auto-generated method stub
		return faqRepository.findById(id).get();
	}

	@Override
	public Faq save(Faq k) {
		// TODO Auto-generated method stub
		return faqRepository.save(k);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		faqRepository.deleteById(id);
	}

}
