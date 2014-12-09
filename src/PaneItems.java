
import javax.swing.*;



public class PaneItems extends JPanel{
	
	public PaneItems(){
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
			JTextField peso = new JTextField();
			peso.setBounds(x + 15, y, 50, 25);
			add(peso);
			JTextField valor = new JTextField();
			valor.setBounds(x + 75, y, 50, 25);
			add(valor);
			y += 30;
		}
	}
}
