//https://www.youtube.com/watch?v=UcVJsV-tqlo
public class GeneticAlgorithm {
	public static final int POPULATION_SIZE = 8;
	public static final int[] TARGET_GENE = { 1, 1, 0, 1, 0, 0, 1, 1, 1, 0 }; // this represents the solution
	public static final int NUMBER_OF_ELITE_GENES = 1;
	public Population evolve(Population population) {
		return mutatePopulation(crossoverPopulation(population));
	}
	
	private Population crossoverPopulation(Population population) {	//crossover operator
		return population;
	}
	
	private Population mutatePopulation(Population population) {	//mutator operator
		return population;
	}
}
