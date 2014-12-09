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
		
		ArrayList <Chromosome> remainPopulation;
		KnapsackInitializer initializer = new KnapsackInitializer(pesos, values, capacity);
		
		Algorithm jnetic = new Algorithm(initializer.generateInitialPopulation(), 100, 0.05, 0.65);
		System.out.println("init");
		jnetic.run(100);
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
