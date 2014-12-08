
public interface Chromosome extends Comparable<Chromosome>{
	public void mutate();
	public int eval();
	public Chromosome join(Chromosome aCouple);
}
