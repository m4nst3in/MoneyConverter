package me.manstein.moneyconverter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class CurrencyConverterUI {

    @FXML
    private TextField amountTextField;

    @FXML
    private ComboBox<String> fromCurrencyComboBox;

    @FXML
    private ComboBox<String> toCurrencyComboBox;

    @FXML
    private Button convertButton;

    @FXML
    private Label resultLabel;

    public void initialize() {
        fromCurrencyComboBox.getItems().addAll(CurrencyCodes.getAllCodes().stream().map(code -> CurrencyNames.getFullName(code) + " (" + code + ")").toArray(String[]::new));
        toCurrencyComboBox.getItems().addAll(CurrencyCodes.getAllCodes().stream().map(code -> CurrencyNames.getFullName(code) + " (" + code + ")").toArray(String[]::new));

        convertButton.setOnAction(event -> convertCurrency());
    }

    private void convertCurrency() {
        String fromCurrencyFullName = fromCurrencyComboBox.getValue();
        String toCurrencyFullName = toCurrencyComboBox.getValue();

        // Verifica se as moedas de origem e destino foram selecionadas
        if (fromCurrencyFullName == null || toCurrencyFullName == null) {
            showAlert(Alert.AlertType.ERROR, "Erro de conversão", "Selecione as moedas de origem e destino antes de converter.");
            return;
        }

        // Verifica se o campo de valor foi preenchido
        String amountText = amountTextField.getText();
        if (amountText.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Erro de conversão", "Digite um valor antes de converter.");
            return;
        }

        double amount = Double.parseDouble(amountText);

        // Exibir o valor digitado antes da conversão
        String inputText = String.format("%.2f", amount) + " " + fromCurrencyFullName;

        String fromCurrencyCode = fromCurrencyFullName.substring(fromCurrencyFullName.lastIndexOf("(") + 1, fromCurrencyFullName.lastIndexOf(")")).trim();
        String toCurrencyCode = toCurrencyFullName.substring(toCurrencyFullName.lastIndexOf("(") + 1, toCurrencyFullName.lastIndexOf(")")).trim();

        double convertedAmount = CurrencyConverter.convertCurrency(fromCurrencyCode, toCurrencyCode, amount);

        // Separando a parte inteira e a parte decimal do valor convertido
        int wholePart = (int) convertedAmount;
        int decimalPart = (int) ((convertedAmount - wholePart) * 100);

        // Formatação do resultado
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        String formattedWholePart = decimalFormat.format(wholePart);

        // Determinando o texto para a parte decimal
        String decimalText = decimalPart > 0 ? " e " + decimalPart + " centavos" : "";

        // Adicionando o nome completo da moeda ao valor convertido
        String resultText = inputText + " equivale a " + formattedWholePart + " " + toCurrencyFullName + decimalText;

        // Exibindo o resultado formatado
        resultLabel.setText(resultText);
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
