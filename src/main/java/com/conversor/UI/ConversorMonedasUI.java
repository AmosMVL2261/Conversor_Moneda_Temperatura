package com.conversor.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.conversor.service.ConversionMonedas;

import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import javax.swing.Action;

public class ConversorMonedasUI extends JFrame {

	private JPanel contentPane;
	private JTextField inputField;
	private JTextField resultadoField;
	private final Action regresar = new RegresarAction();
	private final Action action = new ConvertirAction();
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorMonedasUI frame = new ConversorMonedasUI();
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
	public ConversorMonedasUI() {
		setTitle("Conversor de divisas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseLaCantidad = new JLabel("Ingrese la cantidad de dinero que deseas convertir:", SwingConstants.CENTER);
		lblIngreseLaCantidad.setBounds(12, 12, 416, 32);
		contentPane.add(lblIngreseLaCantidad);
		
		inputField = new JTextField();
		inputField.setBounds(22, 111, 247, 25);
		contentPane.add(inputField);
		inputField.setColumns(10);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setAction(action);
		btnNewButton.setBounds(281, 111, 130, 25);
		contentPane.add(btnNewButton);
		
		
		String[] options = {
				"Convertir de Peso mexicano a Dólar",
				"Convertir de Peso mexicano a Euros",
				"Convertir de Peso mexicano a Libras Esterlinas",
				"Convertir de Peso mexicano a Yen Japonés",
				"Convertir de Peso mexicano a Won sul-coreano",
				"Convertir de Dólar a Peso mexicano",
				"Convertir de Euros a Peso mexicano",
				"Convertir de Libras Esterlinas a Peso mexicano",
				"Convertir de Yen Japonés a Peso mexicano",
				"Convertir de Won sul-coreano a Peso mexicano"
		};
		comboBox = new JComboBox(options);
		comboBox.setSize(600, 100);
		comboBox.setBounds(22, 56, 389, 24);
		contentPane.add(comboBox);
		
		resultadoField = new JTextField();
		resultadoField.setBounds(22, 186, 389, 25);
		contentPane.add(resultadoField);
		resultadoField.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(22, 160, 89, 25);
		contentPane.add(lblResultado);
		
		JButton btnRegresar = new JButton();
		btnRegresar.setAction(regresar);
		btnRegresar.setBounds(312, 233, 99, 25);
		contentPane.add(btnRegresar);
	}
	private class RegresarAction extends AbstractAction {
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
		public ConvertirAction() {
			putValue(NAME, "Convertir");
			putValue(SHORT_DESCRIPTION, "Realiza la conversión");
		}
		public void actionPerformed(ActionEvent e) {
			String input = inputField.getText();
			// Check if the input is valid
			String regex = "-?[0-9]+(.[0-9]+)?";
			if(!input.matches(regex)) {
				JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
				return;
			}
			ConversionMonedas cm = new ConversionMonedas();
			BigDecimal result = cm.convertir(comboBox.getSelectedItem().toString(), new BigDecimal(input));
			resultadoField.setText(result.toString());
		}
	}
}
