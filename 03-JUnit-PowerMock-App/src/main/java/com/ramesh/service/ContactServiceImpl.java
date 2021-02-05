package com.ramesh.service;

import java.util.List;

import com.ramesh.dao.ContactDao;
import com.ramesh.model.Contact;
import com.ramesh.util.EmailUtils;

public class ContactServiceImpl implements ContactService {
	private ContactDao dao;
	
	private EmailUtils emailUtils;
	

	

	public void setDao(ContactDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Long getContactNumByName(String name) {
	Long numbar  =	dao.findContactNumByName(name);
		return numbar;
	}

	@Override
	public List<Contact> getAllContacts() {
		 List<Contact> cotacts=dao.findAll();
		return cotacts;
	}

	

	@Override
	public List<Contact> getInActiveRecords() {
		List<Contact> contacts=dao.findInActiveRecords();
		return contacts;
	}

	@Override
	public boolean insertContact(Contact c) {
	 boolean isSaved=  dao.saveContact(c);
	 boolean isSent=false;
	 if(isSaved) {
		 isSent= emailUtils.sendEmail(c.getContactEmail());
	 }
	 
		return false;
	}

	

}
