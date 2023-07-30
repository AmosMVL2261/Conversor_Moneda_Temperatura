package com.conversor.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private final Action action = new MoneyAction();
	private final Action action_1 = new TemperatureAction();

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblA = new JLabel("Seleccione una opcion de conversión", SwingConstants.CENTER);
		lblA.setBounds(78, 12, 300, 36);
		contentPane.add(lblA);
		
		JButton btnB_1 = new JButton();
		btnB_1.setAction(action_1);
		btnB_1.setBounds(78, 165, 300, 60);
		btnB_1.setMinimumSize(new Dimension(300, 60));
		btnB_1.setMaximumSize(new Dimension(300, 60));
		btnB_1.setPreferredSize(new Dimension(300, 60));
		contentPane.add(btnB_1);
		
		JButton btnB = new JButton();
		btnB.setAction(action);
		btnB.setBounds(78, 69, 300, 60);
		btnB.setMaximumSize(new Dimension(300, 60));
		btnB.setMinimumSize(new Dimension(300, 60));
		btnB.setPreferredSize(new Dimension(300, 60));
		contentPane.add(btnB);
	}

	private class MoneyAction extends AbstractAction {
		public MoneyAction() {
			putValue(NAME, "Conversor de Moneda");
			putValue(SHORT_DESCRIPTION, "Create the money conversor window");
		}
		public void actionPerformed(ActionEvent e) {
			ConversorMonedasUI monedas = new ConversorMonedasUI();
			monedas.start();
			dispose();
		}
	}
	private class TemperatureAction extends AbstractAction {
		public TemperatureAction() {
			putValue(NAME, "Conversor de temperatura");
			putValue(SHORT_DESCRIPTION, "Create the temperatures conversor window");
		}
		public void actionPerformed(ActionEvent e) {
			ConversorTemperaturasUI monedas = new ConversorTemperaturasUI();
			monedas.start();
			dispose();
		}
	}
}
