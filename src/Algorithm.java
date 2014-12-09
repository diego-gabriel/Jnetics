import java.util.ArrayList;
import java.util.Collections;


public class Algorithm {
	private ArrayList<Chromosome> population;
	private int maxPopulation;
	private double mutationProbability;
	private double mateProbability;
	
	public Algorithm(ArrayList <Chromosome> initialPopulation, int maxPopulation,
			double mutationProbability, double mateProbability){
		this.population = initialPopulation;
		this.maxPopulation = maxPopulation;
		this.mutationProbability = mutationProbability;
		this.mateProbability = mateProbability;
	}
	
	public void run(int nOfIterations){
		int i = 0;
		while (i < nOfIterations){
			i++;
			ArrayList <Chromosome> newPopulation;
			newPopulation = new ArrayList<Chromosome>();
			
			for (Chromosome aSubject : population){
				if (isTimeToMutate())
					aSubject.mutate();
				else
				{	
					for(Chromosome aCouple : population){

						if (isTimeToMate() && aCouple != aSubject){
							Chromosome aNewSubject = aSubject.join(aCouple);
							if (aCouple.eval() < aNewSubject.eval()
								|| aSubject.eval() < aNewSubject.eval()){
								newPopulation.add(aNewSubject);
							}
							
						}
					}
				}
			}
			
			population.addAll(newPopulation);
			
			if (population.size() > maxPopulation)
				purgePopulation();
		}
	}
	
	private void purgePopulation(){
		Collections.sort(population);
		while(population.size() > maxPopulation){
			population.remove(0);
		}
	}
	
	private boolean isTimeToMutate(){
		return Math.random() <= mutationProbability;
	}
	
	private boolean isTimeToMate(){
		return Math.random() <= mateProbability;
	}
	
	public ArrayList<Chromosome> getPopulation(){
		return population;
	}
}