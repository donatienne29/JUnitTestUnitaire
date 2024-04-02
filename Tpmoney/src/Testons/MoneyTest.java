package Testons;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoneyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleAdd() {
		Money m12CHF = new Money(12, "CHF"); // création de données
		Money m14CHF = new Money(14, "CHF");
		Money expected = new Money(26, "CHF");
		IMoney result = m12CHF.add(m14CHF); // exécution de la méthode testée
		assertTrue(expected.equals(result)); // comparaison
		}
	@Before
	public void testEquals() {
		Money m12CHF= new Money(12, "CHF");
		Money m14CHF= new Money(14, "CHF");
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(!m12CHF.equals(m14CHF));
	}
	
	

}
