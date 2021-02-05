package com.ramesh.service;

import java.util.List;

import com.ramesh.model.Contact;

public interface ContactService {
	public String getNameById(Integer Id);
	public List<String> getAllConactsNames();
	public Contact getContactById(Integer id);

}
