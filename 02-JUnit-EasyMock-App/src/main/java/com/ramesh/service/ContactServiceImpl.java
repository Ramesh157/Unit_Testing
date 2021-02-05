package com.ramesh.service;

import java.util.List;

import com.ramesh.dao.ContactDao;
import com.ramesh.exception.NoDataFoundException;
import com.ramesh.model.Contact;

public class ContactServiceImpl implements ContactService {

	private ContactDao contactDao;

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public String getNameById(Integer Id) {
		String name = contactDao.findNameById(Id);
		String formattedName = name.toUpperCase();
		return formattedName;
	}

	public List<String> getAllConactsNames() {
		List<String> names = contactDao.findNames();
		if (names!= null && names.size()>0) {
			return names;
		}

		return null;
	}

	public Contact getContactById(Integer id) {
		Contact contact = contactDao.findById(id);

		if (contact == null) {
 			throw new NoDataFoundException("No Data Found");
		}
		return contact;
	}

}
