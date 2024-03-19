package me.manstein.moneyconverter;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyNames {

    static final Map<String, String> currencyNames = new TreeMap<>();

    static {
        currencyNames.put("AED", "Dirham dos Emirados Árabes Unidos");
        currencyNames.put("ARS", "Peso argentino");
        currencyNames.put("AUD", "Dólar australiano");
        currencyNames.put("BDT", "Taka de Bangladesh");
        currencyNames.put("BRL", "Real brasileiro");
        currencyNames.put("CAD", "Dólar canadense");
        currencyNames.put("CHF", "Franco suíço");
        currencyNames.put("CLP", "Peso chileno");
        currencyNames.put("CNY", "Renminbi chinês");
        currencyNames.put("COP", "Peso colombiano");
        currencyNames.put("CZK", "Coroa tcheca");
        currencyNames.put("DKK", "Coroa dinamarquesa");
        currencyNames.put("EGP", "Libra egípcia");
        currencyNames.put("EUR", "Euro");
        currencyNames.put("GBP", "Libra esterlina");
        currencyNames.put("HKD", "Dólar de Hong Kong");
        currencyNames.put("HUF", "Forint húngaro");
        currencyNames.put("IDR", "Rupia indonésia");
        currencyNames.put("ILS", "Novo shekel israelense");
        currencyNames.put("INR", "Rupia indiana");
        currencyNames.put("IQD", "Dinar iraquiano");
        currencyNames.put("JPY", "Iene japonês");
        currencyNames.put("KRW", "Won sul-coreano");
        currencyNames.put("KWD", "Dinar kuwaitiano");
        currencyNames.put("MXN", "Peso mexicano");
        currencyNames.put("MYR", "Ringgit malaio");
        currencyNames.put("NGN", "Naira nigeriano");
        currencyNames.put("NOK", "Coroa norueguesa");
        currencyNames.put("NZD", "Dólar neozelandês");
        currencyNames.put("PEN", "Sol peruano");
        currencyNames.put("PHP", "Peso filipino");
        currencyNames.put("PLN", "Złoty polonês");
        currencyNames.put("QAR", "Rial do Qatar");
        currencyNames.put("RON", "Leu romeno");
        currencyNames.put("RUB", "Rublo russo");
        currencyNames.put("SAR", "Rial saudita");
        currencyNames.put("SEK", "Coroa sueca");
        currencyNames.put("SGD", "Dólar de Singapura");
        currencyNames.put("THB", "Baht tailandês");
        currencyNames.put("TRY", "Lira turca");
        currencyNames.put("UAH", "Hryvnia ucraniano");
        currencyNames.put("USD", "Dólar americano");
        currencyNames.put("VND", "Dong vietnamita");
        currencyNames.put("ZAR", "Rand sul-africano");
    }

    public static String getFullName(String currencyCode) {
        return currencyNames.get(currencyCode);
    }
}
