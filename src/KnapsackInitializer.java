import java.util.ArrayList;


public class KnapsackInitializer {
	
	private ArrayList<Integer> pesos;
	private ArrayList<Integer> values;
	private int capacity;
	
	public KnapsackInitializer(ArrayList<Integer> pesos, ArrayList<Integer> values, int capacity){
		this.pesos = pesos;
		this.values = values;
		this.capacity = capacity;
	}
	
	public ArrayList<Chromosome> generateInitialPopulation(){
		
		ArrayList <Chromosome> initialPopulation;
		initialPopulation = new ArrayList<Chromosome>();
		
		initialPopulation.add(generateWithGensValue(false));

		initialPopulation.add(generateWithGensValue(true));
		
		return initialPopulation;
	}
	
	private Knapsack generateWithGensValue(boolean value){
		ArrayList <Boolean> gens = new ArrayList<Boolean>();
		
		for (int i = 0; i < pesos.size(); i++){
			gens.add(value);
		}
		return new Knapsack(gens, pesos, values, capacity);
	}

}
