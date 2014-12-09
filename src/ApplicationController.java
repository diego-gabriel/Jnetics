import java.util.ArrayList;

import javax.swing.JTextField;


public class ApplicationController {
	
	private ApplicationFrame frame;
	private boolean camposValidos, items;
	private ArrayList <Chromosome> remainPopulation;
	private StringBuilder build;
	
	public ApplicationController(){
		frame = new ApplicationFrame(this);	
		camposValidos = true;
		items = true;
	}
	
	public void init(){
		frame.setVisible(true);
	}

	public void validateCapacityQuantity(String capacity, String quantity) {
			if(!capacityValide(capacity) || !quantityValide(quantity)){
					camposValidos = false;
			}
			else{
				if(capacityValide(capacity) && quantityValide(quantity)){
						camposValidos = true;
				}
			}
			validarCampos();
	}
	
	private void validarCampos() {
		if(camposValidos && items){
			frame.setMessage("Datos validos :)");
			frame.enableButtons();
		}else{
			frame.setMessage("Datos no validos");
			frame.disableButtons();
		}
	}

	private boolean capacityValide(String input){
		return isNumberInteger(input) && Integer.parseInt(input) < 10000000 
				&& Integer.parseInt(input) > 0;
	}
	
	private boolean isNumberInteger(String input) {
		boolean res = true;
		if(input == null || input.isEmpty())
			res = false;
		else{
			int i = 0;
			while(i < input.length() && res){
				if(!Character.isDigit(input.charAt(i)))
						res = false;
				i++;
			}
		}
		return res;
	}

	private boolean quantityValide(String input){
		return isNumberInteger(input) && Integer.parseInt(input) <= 100 &&
				Integer.parseInt(input) > 0;
	}
	
	public void validateItems(ArrayList<JTextField> pesosT, ArrayList<JTextField> valoresT){
		boolean todos = true;
		int i = 0;
		while(i < pesosT.size() && todos){
			if(validateItem(pesosT.get(i).getText(), valoresT.get(i).getText())){
				todos = false;
			}
			i++;	
		}
		items = todos;	
		validarCampos();	
	}

	private boolean validateItem(String inputPeso, String inputValor) {
		return (!itemValide(inputPeso) || !itemValide(inputValor));
	}

	private boolean itemValide(String input) {
		return isNumberDouble(input) && input.length() < 7;
	}

	private boolean isNumberDouble(String input) {
		boolean res = true;
		int i = 0;
		if(input == null || input.isEmpty() || input.endsWith(".") || !input.contains("."))
			res = false;
		else{
			i = 0;
			while(i < input.length() && res){
				if(!Character.isDigit(input.charAt(i)) && (input.charAt(i) != '.'))
						res = false;
				i++;
			}
		}
		return res;
	}

	public void startAG(int capacidad, ArrayList<Double> pe, ArrayList<Double> va) {
		KnapsackInitializer initializer = new KnapsackInitializer(pe, va, capacidad);
		Algorithm jnetic = new Algorithm(initializer.generateInitialPopulation(), 100, 0.05, 0.65);
		build = new StringBuilder();
		build.append("init \n");
		jnetic.run(100);
		build.append("fin \n");
		remainPopulation = jnetic.getPopulation();
		mostrarSoluciones();
	}

	private void mostrarSoluciones() {
		for(Chromosome c : remainPopulation){
			if (c instanceof Knapsack){
				Knapsack aSubject = (Knapsack) c;
				build.append(aSubject.toString());
				build.append("\n");
			}
		}
		frame.setTextArea(build.toString());
	}
		
}
