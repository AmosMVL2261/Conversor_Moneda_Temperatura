package com.conversor.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.conversor.service.ConversionTemperaturas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import javax.swing.Action;

public class ConversorTemperaturasUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputField;
	private JTextField resultadoField;
	private final Action action = new ConvertirAction();
	private final Action regresar = new RegresarAction();
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperaturasUI frame = new ConversorTemperaturasUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConversorTemperaturasUI() {
		setTitle("Conversor de Temperaturas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona el tipo de conversión", SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 24, 416, 32);
		contentPane.add(lblNewLabel);
		
		inputField = new JTextField();
		inputField.setBounds(29, 109, 242, 25);
		contentPane.add(inputField);
		inputField.setColumns(10);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setAction(regresar);
		btnNewButton.setBounds(304, 233, 99, 25);
		contentPane.add(btnNewButton);
		
		
		String[] options = {
				"Grados Celsius a Grados Fahrenheit",
				"Grados Celsius a Kelvin",
				"Grados Fahrenheit a Grados Celsius",
				"Grados Fahrenheit a Kelvin",
				"Kelvin a Grados Celsius",
				"Kelvin a Grados Fahrenheit"
		};
		comboBox = new JComboBox<String>(options);
		comboBox.setBounds(68, 64, 303, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado: ");
		lblNewLabel_1.setBounds(29, 161, 131, 22);
		contentPane.add(lblNewLabel_1);
		
		resultadoField = new JTextField();
		resultadoField.setBounds(29, 187, 374, 25);
		contentPane.add(resultadoField);
		resultadoField.setColumns(10);
		
		JButton btnRegresar = new JButton();
		btnRegresar.setAction(action);
		btnRegresar.setBounds(286, 109, 117, 25);
		contentPane.add(btnRegresar);
	}


	private class RegresarAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public RegresarAction() {
			putValue(NAME, "Regresar");
			putValue(SHORT_DESCRIPTION, "Regresar al menu principal");
		}
		public void actionPerformed(ActionEvent e) {
			MainMenu main = new MainMenu();
			main.start();
			dispose();
		}
	}
	private class ConvertirAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ConvertirAction() {
			putValue(NAME, "Convertir");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String input = inputField.getText();
			// Check if the input is valid
			String regex = "-?[0-9]+(.[0-9]+)?";
			if(!input.matches(regex)) {
				JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
				return;
			}
			ConversionTemperaturas ct = new ConversionTemperaturas();
			BigDecimal result = ct.conversion(comboBox.getSelectedItem().toString(), new BigDecimal(input));
			if(result.compareTo(new BigDecimal("-9999"))==0) {
				JOptionPane.showMessageDialog(null, "La temperatura ingresada esta por debajo del cero absoluto");
				return;
			}
			resultadoField.setText(result.toString());
		}
	}
}
