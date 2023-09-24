package com.conversor.service;

import java.math.BigDecimal;

public class ConversionTemperaturas {
	
	public BigDecimal conversion(String selectedOption, BigDecimal value) {
		if(selectedOption.equals("Grados Celsius a Grados Fahrenheit")) {
			return CelsiusToFahrenheit(value);
		}
		if(selectedOption.equals("Grados Celsius a Kelvin")) {
			return CelsiusToKelvin(value);
		}
		if(selectedOption.equals("Grados Fahrenheit a Grados Celsius")) {
			return fahrenheitToCelsius(value);
		}
		if(selectedOption.equals("Grados Fahrenheit a Kelvin")) {
			return fahrenheitToKelvin(value);
		}
		if(selectedOption.equals("Kelvin a Grados Celsius")) {
			return kelvinToCelsius(value);
		}
		if(selectedOption.equals("Kelvin a Grados Fahrenheit")) {
			return kelvinToFahrenheit(value);
		}
		return new BigDecimal(-110000);
	}
	
	public BigDecimal CelsiusToFahrenheit(BigDecimal value) {
		//Minimum temperature possible: Absolute zero
		BigDecimal temp = new BigDecimal("-273.15");
		if(value.compareTo(temp) == -1) {
			temp = new BigDecimal("-9999");
			return temp;
		}
		// Formula
		//(value °C × 9/5) + 32 = result °F
		temp = new BigDecimal("1.8");
		value = value.multiply(temp);
		temp = new BigDecimal("32");
		return value.add(temp);
	}
	
	public BigDecimal CelsiusToKelvin(BigDecimal value) {
		//Minimum temperature possible: Absolute zero
		BigDecimal temp = new BigDecimal("-273.15");
		if(value.compareTo(temp) == -1) {
			temp = new BigDecimal("-9999");
			return temp;
		}
		// Formula
		// value °C + 273.15 = result K
		temp = new BigDecimal("273.15");
		return value.add(temp);
	}
	
	public BigDecimal fahrenheitToCelsius(BigDecimal value) {
		//Minimum temperature possible: Absolute zero
		BigDecimal temp = new BigDecimal("-459.67");
		if(value.compareTo(temp) == -1) {
			temp = new BigDecimal("-9999");
			return temp;
		}
		// Formula
		// (value °F − 32) × 5/9 = result °C
		temp = new BigDecimal("32");
		value = value.subtract(temp);
		temp = new BigDecimal("0.555555555556");
		return value = value.multiply(temp);
	}
	
	public BigDecimal fahrenheitToKelvin(BigDecimal value) {
		//Minimum temperature possible: Absolute zero
		BigDecimal temp = new BigDecimal("-459.67");
		if(value.compareTo(temp) == -1) {
			temp = new BigDecimal("-9999");
			return temp;
		}
		// Formula
		// (value °F − 32) × 5/9 + 273.15 = result K
		temp = new BigDecimal("32");
		value = value.subtract(temp);
		temp = new BigDecimal("0.555555555556");
		value = value.multiply(temp);
		temp = new BigDecimal("273.15");
		return value.add(temp);
	}
	
	public BigDecimal kelvinToCelsius(BigDecimal value) {
		//Minimum temperature possible: Absolute zero
		BigDecimal temp = new BigDecimal("0");
		if(value.compareTo(temp) == -1) {
			temp = new BigDecimal("-9999");
			return temp;
		}
		// Formula
		// value K − 273.15 = result °C
		temp = new BigDecimal("273.15");
		return value.subtract(temp);
		
	}
	
	public BigDecimal kelvinToFahrenheit(BigDecimal value) {
		//Minimum temperature possible: Absolute zero
		BigDecimal temp = new BigDecimal("0");
		if(value.compareTo(temp) == -1) {
			temp = new BigDecimal("-9999");
			return temp;
		}
		// Formula
		// (value K − 273.15) × 9/5 + 32 = result °F
		temp = new BigDecimal("273.15");
		value = value.subtract(temp);
		temp = new BigDecimal("1.8");
		value = value.multiply(temp);
		temp = new BigDecimal("32");
		return value.add(temp);
		
	}
}
