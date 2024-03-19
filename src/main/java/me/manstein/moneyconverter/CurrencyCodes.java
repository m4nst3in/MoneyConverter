package me.manstein.moneyconverter;

import java.util.List;
import java.util.stream.Collectors;

public class CurrencyCodes {

    public static List<String> getAllCodes() {
        return CurrencyNames.currencyNames.keySet().stream().sorted().collect(Collectors.toList());
    }
}

