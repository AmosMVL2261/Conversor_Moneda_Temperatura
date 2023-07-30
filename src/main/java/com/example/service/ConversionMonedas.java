package com.example.service;

import java.math.BigDecimal;

public class ConversionMonedas {
	
	public BigDecimal convertir(String selectedOption, BigDecimal value) {
		// Última actualización: 30 jul 2023, 22:31 UTC
		if(selectedOption.equals("Convertir de Peso mexicano a Dólar")) {
			return pesoToDolar(value);
		}
		if(selectedOption.equals("Convertir de Peso mexicano a Euros")) {
			return pesoToEuro(value);
		}
		if(selectedOption.equals("Convertir de Peso mexicano a Libras Esterlinas")) {
			return pesoToLibra(value);
		}
		if(selectedOption.equals("Convertir de Peso mexicano a Yen Japonés")) {
			return pesoToYen(value);
		}
		if(selectedOption.equals("Convertir de Peso mexicano a Won sul-coreano")) {
			return pesoToWon(value);
		}
		if(selectedOption.equals("Convertir de Dólar a Peso mexicano")) {
			return dolarToPeso(value);
		}
		if(selectedOption.equals("Convertir de Euros a Peso mexicano")) {
			return euroToPeso(value);
		}
		if(selectedOption.equals("Convertir de Libras Esterlinas a Peso mexicano")) {
			return libraToPeso(value);
		}
		if(selectedOption.equals("Convertir de Yen Japonés a Peso mexicano")) {
			return yenToPeso(value);
		}
		if(selectedOption.equals("Convertir de Won sul-coreano a Peso mexicano")) {
			return wonToPeso(value);
		}
		return null;
	}
	
	public BigDecimal pesoToDolar(BigDecimal value) {
		BigDecimal equivalent = new BigDecimal("0.059902453");
		return value.multiply(equivalent);
	}
	
	public BigDecimal pesoToEuro(BigDecimal value) {
		BigDecimal equivalent = new BigDecimal("0.054334964");
		return value.multiply(equivalent);
	}
	
	public BigDecimal pesoToLibra(BigDecimal value) {
		BigDecimal equivalent = new BigDecimal("0.046600466");
		return value.multiply(equivalent);
	}
	
	public BigDecimal pesoToYen(BigDecimal value) {
		BigDecimal equivalent = new BigDecimal("8.4437207");
		return value.multiply(equivalent);
	}
	
	public BigDecimal pesoToWon(BigDecimal value) {
		BigDecimal equivalent = new BigDecimal("76.267644");
		return value.multiply(equivalent);
	}
	
	public BigDecimal dolarToPeso(BigDecimal value) {
		BigDecimal equivalent = new BigDecimal("16.689015");
		return value.multiply(equivalent);
	}
	
	public BigDecimal euroToPeso(BigDecimal value) {
		BigDecimal equivalent = new BigDecimal("18.399139");
		return value.multiply(equivalent);
	}
	
	public BigDecimal libraToPeso(BigDecimal value) {
		BigDecimal equivalent = new BigDecimal("21,449447");
		return value.multiply(equivalent);
	}
	
	public BigDecimal yenToPeso(BigDecimal value) {
		BigDecimal equivalent = new BigDecimal("0.11846082");
		return value.multiply(equivalent);
	}
	
	public BigDecimal wonToPeso(BigDecimal value) {
		BigDecimal equivalent = new BigDecimal("0.013106244");
		return value.multiply(equivalent);
	}
}
