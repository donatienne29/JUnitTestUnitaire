package Testons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class MoneyBagTest {
    private Money f12CHF, f14CHF, f7USD, f21USD;
    private MoneyBag fMB1, fMB2;
	@Before
	public void setUp() {
	f12CHF= new Money(12, "CHF");
	f14CHF= new Money(14, "CHF");
	f7USD= new Money( 7, "USD");
	f21USD= new Money(21, "USD");
	fMB1= new MoneyBag(f12CHF, f7USD);
	fMB2= new MoneyBag(f14CHF, f21USD);
	}
	@Test
	public void testBagEquals() {
	assertTrue(!fMB1.equals(null)); 
	assertEquals(fMB1, fMB1); 
	assertTrue(!fMB1.equals(f12CHF)); 
	assertTrue(!f12CHF.equals(fMB1)); 
	assertTrue(!fMB1.equals(fMB2));
	}
	
	@Test
	public void testMixedSimpleAdd() {
	
	// [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
	Money bag[] = { f12CHF, f7USD };
	MoneyBag expected = new MoneyBag(bag);
	assertEquals(expected, f12CHF.add(f7USD));
	}
	
	@Test
	public void testBagSimpleAdd() {
	    // {[12 CHF][7 USD]} + [14 CHF] == {[12 CHF][7 USD][14 CHF]}
	    MoneyBag moneyBag = new MoneyBag(f12CHF, f7USD);
	    MoneyBag expected = new MoneyBag(new Money[] {f12CHF, f7USD, f14CHF});
	    assertEquals(expected, moneyBag.add(f14CHF));
	}

	@Test
	public void testSimpleBagAdd() {
	  
	    MoneyBag moneyBag = new MoneyBag(f7USD, f14CHF);
	    MoneyBag expected = new MoneyBag(new Money[] {f12CHF, f7USD, f14CHF});
	    assertEquals(expected, f12CHF.add(moneyBag));
	}

	@Test
	public void testBagBagAdd() {
	
	    MoneyBag bag1 = new MoneyBag(f12CHF, f7USD);
	    MoneyBag bag2 = new MoneyBag(f14CHF, f21USD);
	    MoneyBag expected = new MoneyBag(new Money[] {f12CHF, f7USD, f14CHF, f21USD});
	    assertEquals(expected, bag1.add(bag2));
	}
	
	@Test
	public void testSimplification() {
	    // ajouter -12 CHF à un MoneyBag contenant 7 USD et 12 CHF résulte en un MoneyBag avec uniquement 7 USD
	    Money negCHF = new Money(-12, "CHF");
	    MoneyBag bag = new MoneyBag(f7USD, f12CHF);
	    Money expected = new Money(7, "USD");
	    IMoney result = bag.add(negCHF);
	    assertEquals(expected, result);
	}

}
