package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class Currency {
	private String name;
	private String shortName;
	private HashMap<String, Double> exchangeValues = new HashMap<String, Double>();
	
	// "Currency" Constructor
	public Currency(String nameValue, String shortNameValue) {
		this.name = nameValue;
		this.shortName = shortNameValue;
	}
	
	// Getter for name
	public String getName() {
		return this.name;
	}
	
	// Setter for name
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter for shortName
	public String getShortName() {
		return this.shortName;
	}
	
	// Setter for shortName
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	// Getter for exchangeValues
	public HashMap<String, Double> getExchangeValues() {
		return this.exchangeValues;
	}
	
	// Setter for exchangeValues
	public void setExchangeValues(String key, Double value) {
		this.exchangeValues.put(key, value);
	}
	
	// Set default values for a currency
	public void defaultValues() {
		String currency = this.name;
		
		switch (currency) {	
			case "US Dollar":
				this.exchangeValues.put("USD", 1.00);
				this.exchangeValues.put("EUR", 0.84);
				this.exchangeValues.put("GBP", 0.72);
				this.exchangeValues.put("CHF", 0.91);
				this.exchangeValues.put("INR", 74.29);
				this.exchangeValues.put("JPY", 109.52);
				this.exchangeValues.put("NZD", 1.43);
				this.exchangeValues.put("AUD", 1.35);
				break;
			case "Euro":
				this.exchangeValues.put("USD", 1.19);
				this.exchangeValues.put("EUR", 1.00);
				this.exchangeValues.put("GBP", 0.85);
				this.exchangeValues.put("CHF", 1.08);
				this.exchangeValues.put("INR", 88.72);
				this.exchangeValues.put("JPY", 130.14);
				this.exchangeValues.put("NZD", 1.70);
				this.exchangeValues.put("AUD", 1.61);
				break;
			case "British Pound":
				this.exchangeValues.put("USD", 1.40);
				this.exchangeValues.put("EUR", 1.17);
				this.exchangeValues.put("GBP", 1.00);
				this.exchangeValues.put("CHF", 1.27);
				this.exchangeValues.put("INR", 103.67);
				this.exchangeValues.put("JPY", 152.84);
				this.exchangeValues.put("NZD", 1.99);
				this.exchangeValues.put("AUD", 1.89);
				break;
			case "Swiss Franc":
				this.exchangeValues.put("USD", 1.10);
				this.exchangeValues.put("EUR", 0.93);
				this.exchangeValues.put("GBP", 0.79);
				this.exchangeValues.put("CHF", 1.00);
				this.exchangeValues.put("INR", 81.92);
				this.exchangeValues.put("JPY", 120.49);
				this.exchangeValues.put("NZD", 1.57);
				this.exchangeValues.put("AUD", 1.49);
				break;
			case "Indian Rupee":
				this.exchangeValues.put("USD", 0.013);
				this.exchangeValues.put("EUR", 0.011);
				this.exchangeValues.put("GBP", 0.0096);
				this.exchangeValues.put("CHF", 0.012);
				this.exchangeValues.put("INR", 1.00);
				this.exchangeValues.put("JPY", 1.47);
				this.exchangeValues.put("NZD", 0.019);
				this.exchangeValues.put("AUD", 0.018);
				break;
			case "Japanese Yen":
				this.exchangeValues.put("USD", 0.0091);
				this.exchangeValues.put("EUR", 0.0077);
				this.exchangeValues.put("GBP", 0.0065);
				this.exchangeValues.put("CHF", 0.0083);
				this.exchangeValues.put("INR", 0.68);
				this.exchangeValues.put("JPY", 1.000);
				this.exchangeValues.put("NZD", 0.013);
				this.exchangeValues.put("AUD", 0.012);
				break;
			case "New Zealand Dollar":
				this.exchangeValues.put("USD", 0.70);
				this.exchangeValues.put("EUR", 0.59);
				this.exchangeValues.put("GBP", 0.50);
				this.exchangeValues.put("CHF", 0.63);
				this.exchangeValues.put("INR", 52.03);
				this.exchangeValues.put("JPY", 76.70);
				this.exchangeValues.put("NZD", 1.00);
				this.exchangeValues.put("AUD", 0.93);
				break;
				
			case "Australian Dollar":
				this.exchangeValues.put("USD", 0.74);
				this.exchangeValues.put("EUR", 0.62);
				this.exchangeValues.put("GBP", 0.53);
				this.exchangeValues.put("CHF", 0.67);
				this.exchangeValues.put("INR", 59.94);
				this.exchangeValues.put("JPY", 80.95);
				this.exchangeValues.put("NZD", 1.06);
				this.exchangeValues.put("AUD", 1.00);	
		}
	}
	
	// Initialize currencies
	public static ArrayList<Currency> init() {
		ArrayList<Currency> currencies = new ArrayList<Currency>();
				
		currencies.add( new Currency("US Dollar", "USD") );
		currencies.add( new Currency("Euro", "EUR") );
		currencies.add( new Currency("British Pound", "GBP") );
		currencies.add( new Currency("Swiss Franc", "CHF") );
		currencies.add( new Currency("Indian Rupee", "INR") );
		currencies.add( new Currency("Japanese Yen", "JPY") );
		currencies.add( new Currency("New Zealand Dollar", "NZD") );
		currencies.add( new Currency("Australian Dollar", "AUD") );
		
		for (Integer i =0; i < currencies.size(); i++) {
			currencies.get(i).defaultValues();
		}		
		
		return currencies;
	}
	
	// Convert a currency to another
	public static Double convert(Double amount, Double exchangeValue) {
		Double price;
		price = amount * exchangeValue;
		price = Math.round(price * 100d) / 100d;
		
		return price;
	}
}