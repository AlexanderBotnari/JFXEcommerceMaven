package domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@AllArgsConstructor
@Getter
@Setter
public class Money implements Serializable{

	private static CurrencyProvider currencyProvider = new CurrencyProvider();
	
	private Currency currency;
	private Float  amount;
	
	public Money(Float amount) {
        this.amount = amount;
        this.currency = Currency.baseCurrency;
    }


    public Money(String currencyCode, Float amount) {
        this.currency = currencyProvider.getCurrency(currencyCode);
        this.amount = amount;
    }
   
    public Money toCurrency(String code) {
    	Currency c = currencyProvider.getCurrency(code);

        if (currency.getCode().equals("EUR"))
            return new Money(c.getCode(), amount * (float) c.getRate());
        else
            return new Money(currency,amount  * (float)c.getRate());
    }
	
	@Override
	public String toString() {
		return "Currency '"+currency+"'" + ", amount : " + amount;
	}

}
