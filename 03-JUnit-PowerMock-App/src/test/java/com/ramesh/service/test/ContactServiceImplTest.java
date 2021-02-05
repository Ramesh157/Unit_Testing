package com.ramesh.service.test;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.ramesh.dao.ContactDao;
import com.ramesh.service.ContactServiceImpl;

public class ContactServiceImplTest {

	@Test
	public void testGetContactNumByName() {

		ContactServiceImpl service = new ContactServiceImpl();

		ContactDao daoMock = PowerMockito.mock(ContactDao.class);

		System.out.println(daoMock.getClass().getName());
		
		PowerMockito.when(daoMock.findContactNumByName("Ramesh"));
		
		service.setDao(daoMock);
		
		Long num = service.getContactNumByName("Ramesh");
		
		assertNull(num);

	}

}
