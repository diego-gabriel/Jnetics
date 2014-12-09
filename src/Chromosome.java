
public interface Chromosome extends Comparable<Chromosome>{
	public void mutate();
	public double eval();
	public Chromosome join(Chromosome aCouple);
}
