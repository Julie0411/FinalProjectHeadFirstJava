package bankAccount;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoneyTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        MoneyTest test = new MoneyTest();

        for (Method m: MoneyTest.class.getDeclaredMethods()){
            String name = m.getName();

            if (name.startsWith("test_")){
                System.out.println("executing " + name);
                m.invoke(test);
            }

        }

    }

    void test_Money_constructor_when_you_dont_set_a_value_for_currency_should_throw_an_illegal_argument_exception() {

        try {
            Money money = new Money(10, null);
            fail();
        } catch (IllegalArgumentException ex) {
            pass();
        }

    }

    void test_add_when_you_try_to_add_two_different_currency_should_throw_an_illegal_argument_exception() {

        Money money1 = new Money(1, Money.Currency.CHF);
        Money money2 = new Money(2, Money.Currency.EUR);

        try {
            money1.add(money2);
            fail();
        } catch (IllegalArgumentException ex) {
            pass();
        }

    }
    void test_add_when_you_give_two_valid_amount_with_the_same_currency_should_return_the_sum() {

        Money initial = new Money(10, Money.Currency.CHF);
        Money toSum = new Money(15, Money.Currency.CHF);
        Money expectedResult = new Money(25, Money.Currency.CHF);

        Money sumOfMoney = initial.add(toSum);
        if (sumOfMoney.equals(expectedResult)) {
            pass();
        } else {
            fail();
        }

    }

    void test_convert_when_you_give_an_initial_currency_should_return_the_final_currency() {

        CurrencyExchange currencyExchange = new CurrencyExchange();

        Money initial = new Money(10, Money.Currency.CHF);
        Money.Currency targetCurrency = Money.Currency.EUR;

        Money initial1 = new Money(15, Money.Currency.EUR);
        Money.Currency targetCurrency1 = Money.Currency.USD;

        Money initial2 = new Money(20, Money.Currency.GBP);
        Money.Currency targetCurrency2 = Money.Currency.CHF;

        Money initial3 = new Money(25, Money.Currency.CHF);
        Money.Currency targetCurrency3 = Money.Currency.CHF;

        currencyExchange.addExchangeRate(Money.Currency.EUR, 1.06);
        currencyExchange.addExchangeRate(Money.Currency.USD, 1.10);
        currencyExchange.addExchangeRate(Money.Currency.GBP, 0.98);

        double convertedMoney = currencyExchange.convert(initial, targetCurrency).getAmount();
        double convertedMoney1 = currencyExchange.convert(initial1, targetCurrency1).getAmount();
        double convertedMoney2 = currencyExchange.convert(initial2, targetCurrency2).getAmount();
        double convertedMoney3 = currencyExchange.convert(initial3, targetCurrency3).getAmount();

        double expectedConvertedMoney = 10 * 1.06;
        double expectedConvertedMoney1 = (15 / 1.06) * 1.10;
        double expectedConvertedMoney2 = 20 / 0.98;
        double expectedConvertedMoney3 = 25.0;

        if (convertedMoney == expectedConvertedMoney) {
            pass();
        } else {
            fail();
        }

        if (convertedMoney1 == expectedConvertedMoney1) {
            pass();
        } else {
            fail();
        }

        if (convertedMoney2 == expectedConvertedMoney2) {
            pass();
        } else {
            fail();
        }

        if (convertedMoney3 == expectedConvertedMoney3) {
            pass();
        } else {
            fail();
        }

    }

    private static void fail(){
        throw new RuntimeException("test failed");
    }
    private static void pass(){
        System.out.println("          test passed");
    }

}
