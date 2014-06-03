package es.unileon.ulebank.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OfficeTests {

    private Office office;

    @Before
    public void setUp() throws Exception {
        office = new Office();
    }
    
    @Test
    public void testSetAndGetId() {
        String testIdBien = "0001";
        assertNull(office.getId());
        office.setId(testIdBien);
        assertEquals(testIdBien, office.getId());
    }
    
    @Test
    public void testSetAndGetName() {
        String testName = "nombre";
        assertNull(office.getName());
        office.setName(testName);
        assertEquals(testName, office.getName());
    }
    
    @Test
    public void testSetAndGetStreet() {
        String testStreet = "street";
        assertNull(office.getStreet());
        office.setStreet(testStreet);
        assertEquals(testStreet, office.getStreet());
    }
    
    @Test
    public void testSetAndGetZip() {
        int testZip = 24080;
        assertEquals(office.getZip(), 0);
        office.setZip(testZip);
        assertEquals(testZip, office.getZip(), 0);
    }
    
    @Test
    public void testSetAndGetPhone() {
        int testPhone = 987987987;
        assertEquals(office.getPhone(), 0);
        office.setPhone(testPhone);
        assertEquals(testPhone, office.getPhone(), 0);
    }
    
}
