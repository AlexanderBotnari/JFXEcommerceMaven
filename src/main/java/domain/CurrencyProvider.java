package domain;

import java.util.HashMap;
import java.util.Map;

public class CurrencyProvider {
	
	@SuppressWarnings("serial")
	private Map<String, Currency> currencies = new HashMap<>() {{
        put("EUR", Currency.baseCurrency);
        put("USD", new Currency("USD", 17.56));
        put("MDL", new Currency("MDL", 20.01));
        put("RUB", new Currency("RUB", 80.46));
        put("RON", new Currency("RON", 4.31));
	}};

    public Currency getCurrency(String code) {
        return currencies.get(code);
    }


    private static class SingletonHolder {
        private static final CurrencyProvider INSTANCE = new CurrencyProvider();
    }

    public static CurrencyProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }
	
}
