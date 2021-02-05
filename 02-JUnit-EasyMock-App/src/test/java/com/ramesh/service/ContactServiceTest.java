package com.ramesh.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ramesh.dao.ContactDao;
import com.ramesh.exception.NoDataFoundException;
import com.ramesh.model.Contact;

public class ContactServiceTest {

	private static ContactServiceImpl service = null;

	@BeforeClass
	public static void inIt() {
		// crating proxy
		ContactDao daoProxy = EasyMock.createMock(ContactDao.class);

		// setting behavior for dao method1
		EasyMock.expect(daoProxy.findNameById(101)).andReturn("Ramesh");
		EasyMock.expect(daoProxy.findNameById(102)).andReturn("Ramesh Software Engineer");

		// setting behavior for dao method 2
		List<String> names = new ArrayList();
		names.add("Mahesh");
		names.add("Suraj");
		names.add("Mangesh");

		EasyMock.expect(daoProxy.findNames()).andReturn(names);
		EasyMock.expect(daoProxy.findNames()).andReturn(null);

		// setting behavior for dao method 3
		Contact c = new Contact();
		c.setContactId(101);
		c.setContactName("Ramesh Airtel");
		c.setContactNumber(862383215);

		EasyMock.expect(daoProxy.findById(101)).andReturn(c);
		EasyMock.expect(daoProxy.findById(201)).andReturn(null);

		// Saving proxy behaviour
		EasyMock.replay(daoProxy);

		// Saving proxy behaviour
		service = new ContactServiceImpl();

		// Injecting proxy obj in target(SI)
		service.setContactDao(daoProxy);
	}

	@Test

	public void testGetNameById_01() {

		String name = service.getNameById(101);
		assertNotNull(name);

	}

	@Test
	
	public void testGetAllContactNames_01() {

		List<String> contactNames = service.getAllConactsNames();

		assertNotNull(contactNames);

	}
	
@Test
	
	public void testGetAllContactNames_02() {

		List<String> contactNames = service.getAllConactsNames();

		assertNull(contactNames);

	}

	@Test
	
	public void testGetContactById_01() {

		Contact contact = service.getContactById(101);
		assertNotNull(contact);

	}
	@Test(expected=NoDataFoundException.class)
	public void testGetContactById_02() {
		service.getContactById(201);
	}

}
