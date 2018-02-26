import java.util.Arrays;

//This "Application" class acts as a driver
public class Application {
	public static void main(String[] args) {
		Population population = new Population(GeneticAlgorithm.POPULATION_SIZE).initPopulation();
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
		System.out.println("--------------------------------------------------");
		System.out.println("Gene # 0 " + " | Fittest gene fitness: " + population.getGenes()[0].getFitness() );
		printPopulation(population, "Target Gene: " + Arrays.toString(GeneticAlgorithm.TARGET_GENE));
		int generationNumber = 0;
		while(population.getGenes()[0].getFitness() < GeneticAlgorithm.TARGET_GENE.length && generationNumber <= 10000) {
			++generationNumber;
			System.out.println("\n--------------------------------------------------");
			population = geneticAlgorithm.evolve(population);	//run the evolutionary process
			population.sortGenesByFitness();
			System.out.println("Generation # " + generationNumber + " | Fittest gene fitness: "  + population.getGenes()[0].getFitness() );
			printPopulation(population, "Target Gene: " + Arrays.toString(GeneticAlgorithm.TARGET_GENE));
		}
	}
	
	public static void printPopulation(Population population, String heading) {
		System.out.println(heading);
		System.out.println("--------------------------------------------------");
		System.out.println("Output of this genetic algorithm:");
		for (int x = 0; x < population.getGenes().length; ++x) {
			System.out.println("Gene # " + x + "  : " + Arrays.toString(population.getGenes()[x].getUnits()) + " | Fitness: " + population.getGenes()[x].getFitness() );
		}
	}
}
