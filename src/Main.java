import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> pesos, values;
		pesos = new ArrayList<Integer>();
		values = new ArrayList<Integer>();
		int n;
		int capacity;
		Scanner scan = new Scanner(System.in);
		capacity = scan.nextInt();
		n = scan.nextInt();
		
		for (int i = 0; i < n; i++){
			int a, b;
			a = scan.nextInt();
			b = scan.nextInt();
			
			pesos.add(a);
			values.add(b);
		}
		
		ArrayList <Chromosome> initialPopulation, remainPopulation;
		initialPopulation = new ArrayList<Chromosome>();
		ArrayList <Boolean> gens = new ArrayList<Boolean>();
		
		for (int i = 0; i < n; i++){
			gens.add(false);
		}
		initialPopulation.add(new Knapsack(gens, pesos, values, capacity));

		gens = new ArrayList<Boolean>();
		
		for (int i = 0; i < n; i++){
			gens.add(true);
		}
		
		initialPopulation.add(new Knapsack(gens, pesos, values, capacity));
		
		Algorithm jnetic = new Algorithm(initialPopulation, 100, 0.05, 0.65);
		System.out.println("init");
		jnetic.run();
		System.out.println("fin");
		remainPopulation = jnetic.getPopulation();
		
		for(Chromosome c : remainPopulation){
			if (c instanceof Knapsack){
				Knapsack aSubject = (Knapsack) c;
				System.out.println(aSubject.toString());
			}
		}
	}

}

/*
 * 
60
5
15 20
35 10
26 17
23 14
5 27
 * */
