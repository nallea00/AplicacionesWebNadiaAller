package es.unileon.ulebank.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OfficeTests {

	private Office office;

	@Before
	public void setUp() throws Exception {
		office = new Office(null, null, 0, 0, null, null);
	}

	@Test
	public void testSetAndGetName() {
		String testName = "padreIsla";
		assertNull(office.getName());
		office.setName(testName);
		assertEquals(testName, office.getName());
	}

	@Test
	public void testSetAndGetStreet() {
		String testStreet = "juanNuevo";
		assertNull(office.getStreet());
		office.setStreet(testStreet);
		assertEquals(testStreet, office.getStreet());
	}

	@Test
	public void testSetAndGetZip() {
		int testZip = 24009;
		office.setZip(testZip);
		assertEquals(testZip, office.getZip());
	}

	@Test
	public void testSetAndGetPhone() {
		int testPhone = 987568974;
		office.setPhone(testPhone);
		assertEquals(testPhone, office.getPhone(), 0);
	}
}
