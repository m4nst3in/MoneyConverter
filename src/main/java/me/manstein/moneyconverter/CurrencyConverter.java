package me.manstein.moneyconverter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    public static double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        try {
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + fromCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response);
            StringBuilder responseBody = new StringBuilder();
            while (scanner.hasNextLine()) {
                responseBody.append(scanner.nextLine());
            }
            scanner.close();

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(responseBody.toString());
            JSONObject rates = (JSONObject) jsonObject.get("rates");
            Double exchangeRate = (Double) rates.get(toCurrency);

            return amount * exchangeRate;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
