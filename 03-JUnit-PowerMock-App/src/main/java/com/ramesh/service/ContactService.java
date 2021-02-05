package com.ramesh.service;

import java.util.List;

import com.ramesh.model.Contact;

public interface ContactService {

	public Long getContactNumByName(String name);

	public List<Contact> getAllContacts();

	public List<Contact> getInActiveRecords();

	public boolean insertContact(Contact c);

}
