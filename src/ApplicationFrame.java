
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ApplicationFrame extends JFrame{
	
	private ApplicationController controller;
	private JPanel pane;
	private JButton start, stop, llenarItems;
	private JLabel nCapacidad, nCantidad, mensaje, nPeso, nValor;
	private JTextField capacidad, cantidad;
	private PaneItems itemsPane;
	private JTextArea consola;
	private JScrollPane scrollConsola;
	
	public ApplicationFrame(ApplicationController controller){
		setTitle("Knapsack AG");
		setSize(420, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		this.controller = controller;
		pane = new JPanel();
		itemsPane = new PaneItems(controller);
		nCapacidad = new JLabel("Capacidad:");
		nCantidad = new JLabel("Cantidad:");
		nPeso = new JLabel("Peso");
		nValor = new JLabel("Valor");
		mensaje = new JLabel("Los datos deben ser positivos.");
		capacidad = new JTextField("1");
		cantidad = new JTextField("1");
		start = new JButton("Start");
		stop = new JButton("Stop");
		llenarItems = new JButton("Llenar Datos");
		consola = new JTextArea();
		consola.setEditable(false);
		scrollConsola = new JScrollPane(consola);
		
		pane.setLayout(null);
		setContentPane(pane);
		
		addFocusListeners();
		addActionListeners();
		
		nCapacidad.setBounds(10, 40, 70, 25);
		nCantidad.setBounds(10, 70, 70, 25);
		nPeso.setBounds(100, 100, 80, 25);
		nValor.setBounds(180, 100, 80, 25);
		mensaje.setBounds(10, 10, 370, 25);
		capacidad.setBounds(90, 40, 70, 25);
		cantidad.setBounds(90, 70, 70, 25);
		start.setBounds(310, 40, 70, 25);
		stop.setBounds(310, 70, 70, 25);
		llenarItems.setBounds(180, 70, 110, 25);
		itemsPane.setBounds(10, 130, 250, 160);
		scrollConsola.setBounds(10, 310, 390, 150);
		
		pane.add(itemsPane);
		pane.add(nCapacidad);
		pane.add(nCantidad);
		pane.add(nPeso);
		pane.add(nValor);
		pane.add(mensaje);
		pane.add(capacidad);
		pane.add(cantidad);
		pane.add(start);
		pane.add(stop);
		pane.add(llenarItems);
		pane.add(scrollConsola);
	}
	
	private void addFocusListeners() {
		capacidad.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				String capacity = capacidad.getText();
				String quantity = cantidad.getText();
				controller.validateCapacityQuantity(capacity, quantity);
			}

			@Override
			public void focusGained(FocusEvent arg0) {	
			}
		});
		
		cantidad.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				String capacity = capacidad.getText();
				String quantity = cantidad.getText();
				controller.validateCapacityQuantity(capacity, quantity);
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {	
			}
		});
		
	}
	
	public void enableButtons() {
		start.setEnabled(true);
		stop.setEnabled(true);
		llenarItems.setEnabled(true);
	}

	public void disableButtons() {
		start.setEnabled(false);
		stop.setEnabled(false);
		llenarItems.setEnabled(false);
		
	}

	private void addActionListeners() {
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int n = Integer.parseInt(capacidad.getText());
				controller.startAG(n, itemsPane.getPesos(), itemsPane.getValores());
			}
		});
		
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("stop");
				
			}
		});
		
		llenarItems.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int n = Integer.parseInt(cantidad.getText());
				itemsPane.init(n);
				pane.updateUI();
				pane.repaint();
			}
		});
		
	}

	public void setMessage(String string) {
		mensaje.setText(string);
	}

	public void setTextArea(String string) {
		consola.setText(string);
	}
}
