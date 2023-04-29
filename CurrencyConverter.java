import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JLabel amountLabel, fromLabel, toLabel, resultLabel;
    private JTextField amountField, resultField;
    private JComboBox<String> fromComboBox, toComboBox;
    private JButton convertButton;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        amountLabel = new JLabel("Amount:");
        add(amountLabel);
        amountField = new JTextField();
        add(amountField);

        fromLabel = new JLabel("Convert from:");
        add(fromLabel);
        String[] currencies = { "USD", "INR", "EUR" };
        fromComboBox = new JComboBox<>(currencies);
        add(fromComboBox);

        toLabel = new JLabel("Convert to:");
        add(toLabel);
        toComboBox = new JComboBox<>(currencies);
        add(toComboBox);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        add(convertButton);

        resultLabel = new JLabel("Result:");
        add(resultLabel);
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double amount = Double.parseDouble(amountField.getText());
        String fromCurrency = fromComboBox.getSelectedItem().toString();
        String toCurrency = toComboBox.getSelectedItem().toString();
        double rate = 0;

        switch (fromCurrency) {
            case "USD":
                switch (toCurrency) {
                    case "USD":
                        rate = 1;
                        break;
                    case "INR":
                        rate = 81.72;
                        break;
                    case "EUR":
                        rate = 0.91;
                        break;
                }
                break;
            case "INR":
                switch (toCurrency) {
                    case "USD":
                        rate = 0.012;
                        break;
                    case "INR":
                        rate = 1;
                        break;
                    case "EUR":
                        rate = 0.011;
                        break;
                }
                break;
            case "EUR":
                switch (toCurrency) {
                    case "USD":
                        rate = 1.10;
                        break;
                    case "INR":
                        rate = 90.08;
                        break;
                    case "EUR":
                        rate = 1;
                        break;
                }
                break;
        }

        double result = amount * rate;
        resultField.setText(String.format("%.2f %s", result, toCurrency));
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
