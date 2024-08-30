package bankAccount;

import java.util.HashMap;
import java.util.Map;

class CurrencyExchange {

    private Map<Money.Currency, Double> exchangeRates;

    CurrencyExchange() {
        exchangeRates = new HashMap<>();
    }

    CurrencyExchange addExchangeRate(Money.Currency referenceCurrency, double exchangeRate) {
        exchangeRates.put(referenceCurrency, exchangeRate);
        return this;
    }

    Money convertedMoney = null;
    Money convert(Money money, Money.Currency targetCurrency) {
        if (money.getCurrency() == targetCurrency) { // same currency, nothing to convert
            convertedMoney = money.clone();
        } else if (money.getCurrency() == Money.Currency.CHF) { // from franc to any: find the exchenge rate in the map and multiply the amount
            double amountInTargetCurrency = fromCHFto(money.getAmount(), targetCurrency);
            convertedMoney = new Money(amountInTargetCurrency, targetCurrency);
        } else if (targetCurrency == Money.Currency.CHF) { // from any to franc: find the exchange rate and divide the amount
            double amountInCHF = toCHF(money.getAmount(), money.getCurrency());
            convertedMoney = new Money(amountInCHF, targetCurrency);
        } else { // from any to any:...
            double amountChf = toCHF(money.getAmount(), money.getCurrency());
            convertedMoney = new Money(fromCHFto(amountChf, targetCurrency), targetCurrency);
        }
        return convertedMoney;
    }

    private double toCHF(double amount, Money.Currency currency) {
        return amount / exchangeRates.get(currency);

    }

    private double fromCHFto(double amount, Money.Currency targetCurrency){
        return amount * exchangeRates.get(targetCurrency);
    }
}