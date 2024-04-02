package Testons;

import java.util.Objects;
import java.util.Vector;

class MoneyBag implements IMoney {
    private Vector<Money> fMonies = new Vector<>();

    public MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
    }

    public MoneyBag(Money[] bag) {
        for (Money m : bag)
            appendMoney(m);
    }

    public MoneyBag(MoneyBag bag) {
        fMonies.addAll(bag.fMonies);
    }

    public MoneyBag(Money money) {
        appendMoney(money);
    }

    private void appendMoney(Money m) {
        if (fMonies.isEmpty()) {
            fMonies.add(m);
        } else {
            int i = 0;
            while (i < fMonies.size() && !fMonies.get(i).currency().equals(m.currency()))
                i++;

            if (i >= fMonies.size()) {
                fMonies.add(m);
            } else {
                fMonies.set(i, new Money(fMonies.get(i).amount() + m.amount(), m.currency()));
            }
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(fMonies);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MoneyBag other = (MoneyBag) obj;
        return Objects.equals(fMonies, other.fMonies);
    }

    @Override
    public IMoney add(IMoney aMoney) {
        return aMoney.addMoneyBag(this);
    }

    @Override
    public MoneyBag addMoneyBag(MoneyBag mb) {
        MoneyBag result = new MoneyBag(this);
        result.fMonies.addAll(mb.fMonies);
        return (MoneyBag) simplify(result);
    }


    private IMoney simplify(MoneyBag bag) {
        if (bag.fMonies.size() == 1) {
            return bag.fMonies.get(0);
        }
        return bag;
    }

    @Override
    public IMoney addMoney(Money money) {
        MoneyBag result = new MoneyBag(this);
        result.appendMoney(money); 
        return result;
    }


}
