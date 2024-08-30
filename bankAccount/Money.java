package bankAccount;

import java.util.Objects;

public class Money {

    private double amount;
    private Currency currency;

    public Money(double amount, Currency currency) {
        if (currency == null) throw new IllegalArgumentException("Currency can't be null!");
        this.amount = amount;
        this.currency = currency;
    }

    public enum Currency {
        CHF,
        EUR,
        USD,
        GBP
    }

    public Money add(Money money) {
        if (this.currency != money.currency) throw new IllegalArgumentException("You can't sum two different currency!");
        double newAmount = this.amount + money.amount;
        return new Money(newAmount, currency);
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public double getAmount(){
        return amount;
    }

    public Money clone(){
        return  new Money(this.amount,this.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

}
