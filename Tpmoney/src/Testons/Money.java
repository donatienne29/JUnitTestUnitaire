package Testons;

import java.util.Objects;

class Money implements IMoney{
	private int fAmount;
	private String fCurrency;
	public IMoney add2(IMoney mb) {
		return ((IMoney) mb).addMoney(this);
		}
	public Money(int amount, String currency) {
	fAmount = amount;
	fCurrency = currency;
	}
	public int amount() {
	return fAmount;
	}
	public String currency() {
	return fCurrency;
	}
	
	public IMoney add(Money m) {
		if (m.currency().equals(currency()))
		return new Money(amount() + m.amount(), currency());
		return new MoneyBag(this, m);
		}
	@Override
	public int hashCode() {
		return Objects.hash(fAmount, fCurrency);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return fAmount == other.fAmount && Objects.equals(fCurrency, other.fCurrency);
	}
	@Override
	public IMoney add(IMoney aMoney) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public IMoney addMoney(Money money) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IMoney addMoneyBag(MoneyBag moneyBag) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
