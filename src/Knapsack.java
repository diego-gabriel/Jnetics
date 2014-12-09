import java.util.ArrayList;


public class Knapsack implements Chromosome{

	private ArrayList <Boolean> gens;
	private ArrayList <Integer> weightList;
	private ArrayList <Integer> valueList;
	private int capacity;
	
	public Knapsack(ArrayList<Boolean> gens, ArrayList<Integer> weightList,  
			ArrayList<Integer> valueList, int capacity){
		this.gens = gens;
		this.weightList = weightList;
		this.valueList = valueList;
		this.capacity = capacity;
	}
	
	@Override
	public int compareTo(Chromosome aSubject) {
		int res = 1;
		if (eval() < aSubject.eval())
			res = -1;
		else
			if (eval() == aSubject.eval())
				res = 0;
		
		return res;
	}

	@Override
	public void mutate() {
		int position = (int) (Math.random() * gens.size());
		gens.set(position, !gens.get(position));
	}

	@Override
	public int eval() {
		int totalWeight = calculateWeight();
		int totalValue = calculateValue();
		
		if (totalWeight > capacity)
			totalValue = capacity - totalWeight;
		return totalValue;
	}
	
	private int calculateWeight(){
		int totalWeight = 0;	
		
		for (int i = 0; i < gens.size(); i++){
			if (gens.get(i)){
				totalWeight += weightList.get(i);
			}
		}
		return totalWeight;
	}
	
	private int calculateValue(){
		int totalValue = 0;	
		
		for (int i = 0; i < gens.size(); i++){
			if (gens.get(i)){
				totalValue += valueList.get(i);
			}
		}
		return totalValue;
	}
	
	public boolean getGen(int i){
		return gens.get(i);
	}

	@Override
	public Chromosome join(Chromosome couple) {
		
		Knapsack son = null;
		
		if (couple instanceof Knapsack){
		
			Knapsack aCouple = (Knapsack)couple; 
			
			ArrayList<Boolean> genConfiguration;
			genConfiguration = new ArrayList<Boolean>();
			
			int k = (int)(Math.random() * (gens.size()-1)) +1;
			
			for (int i = 0; i < k; i++)
				genConfiguration.add(gens.get(i));
			for (int i = k; i < gens.size(); i++){
				genConfiguration.add(aCouple.getGen(i));
			}
			
			son = new Knapsack(genConfiguration, weightList, valueList, capacity);
		}
		return son;
	}
	
	@Override
	public String toString(){
		String res = "";
		
		res = "total Weight = " + calculateWeight() + " | total Value = " + calculateValue() + "\n-------------------------------------------------";
		
		return res;
	}
	

}
