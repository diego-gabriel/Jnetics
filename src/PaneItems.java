
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;



public class PaneItems extends JPanel{
	
	private ApplicationController controller;
	private ArrayList<JTextField> pesos;
	private ArrayList<JTextField> valores;
	
	public PaneItems(ApplicationController controller){
		this.controller = controller;
		pesos = new ArrayList<>();
		valores = new ArrayList<>();
		setLayout(null);
	}
	
	public void init(int n){
		removeAll();
		JLabel nPeso = new JLabel("Peso");
		JLabel nValor = new JLabel("Valor");
		nPeso.setBounds(25, 10, 80, 25);
		nValor.setBounds(85, 10, 80, 25);
		
		add(nPeso);
		add(nValor);
		
		int x = 10, y = 40;
		for(int i = 0; i < n; i++){
			JLabel label = new JLabel("" + (i + 1));
			label.setBounds(x, y, 10, 25);
			add(label);
			JTextField peso = new JTextField("1.0");
			peso.setBounds(x + 15, y, 50, 25);
			add(peso);
			pesos.add(peso);
			JTextField valor = new JTextField("1.0");
			valor.setBounds(x + 75, y, 50, 25);
			add(valor);
			valores.add(valor);
			addFocusListener(peso, valor);
			y += 30;
		}
	}

	private void addFocusListener(final JTextField peso, final JTextField valor) {
		peso.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String inputPeso = peso.getText();
				String inputValor = valor.getText();
				controller.validateItems(pesos, valores);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		valor.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String inputPeso = peso.getText();
				String inputValor = valor.getText();
				controller.validateItems(pesos, valores);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
	}

	public ArrayList<Double> getPesos() {
		ArrayList<Double> res = new ArrayList<>();
		for(JTextField texto: pesos){
			res.add(Double.parseDouble(texto.getText()));
		}
		return res;
	}
	
	public ArrayList<Double> getValores() {
		ArrayList<Double> res = new ArrayList<>();
		for(JTextField texto: valores){
			res.add(Double.parseDouble(texto.getText()));
		}
		return res;
	}
}
