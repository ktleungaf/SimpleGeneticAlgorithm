// Stop at 21:59 on https://www.youtube.com/watch?v=UcVJsV-tqlo
public class GeneticAlgorithm {
	public static final int POPULATION_SIZE = 8;
	public static final int[] TARGET_GENE = { 1, 1, 0, 1, 0, 0, 1, 1, 1, 0 }; // this represents the solution (hardcode as an example)
	public static final int NUMBER_OF_ELITE_GENES = 1;	//This variable has the purpose that this constant will NOT be subject to crossover or mutation from one generation to the next.
	public static final int TOURNAMENT_SELECTION_SIZE = 4;	//used for gene crossover and selection
	public Population evolve(Population population) {
		return mutatePopulation(crossoverPopulation(population));
	}
	
	private Population crossoverPopulation(Population population) {	//crossover operator
		Population crossoverPopulation = new Population(population.getGenes().length);
		//exclude those "elite" genes from crossover
		for(int x = 0; x < NUMBER_OF_ELITE_GENES; ++x){
			crossoverPopulation.getGenes()[x] = population.getGenes()[x];
		}
		for(int x = NUMBER_OF_ELITE_GENES; x < population.getGenes().length; ++x){	//loop through all genes in the population given as the input argument excluding those 'elite' one
			//select 2 genes from tournament population to pick up 2 genes with highest fitness values
			Gene gene1 = selectTournamentPopulation(population).getGenes()[0];
			Gene gene2 = selectTournamentPopulation(population).getGenes()[0];
			crossoverPopulation.getGenes()[x] = crossoverGene(gene1, gene2);	//put the resulting gene into the population
		}		
		return crossoverPopulation;
	}
	
	private Population mutatePopulation(Population population) {	//mutator operator
		Population mutatePopulation = new Population(population.getGenes().length);
		//exclude those "elite" genes from being mutated
		for(int x = 0; x < NUMBER_OF_ELITE_GENES; ++x){
			mutatePopulation.getGenes()[x] = population.getGenes()[x];
		}
		return mutatePopulation;
	}
	
	private Population selectTournamentPopulation(Population population) {	
		//In tournament selection, a number of genes are selected randomly. And from those, the one with higher fitness value is chosen here
		Population tournamentPopulation = new Population(TOURNAMENT_SELECTION_SIZE);
		for(int x = 0; x < NUMBER_OF_ELITE_GENES; ++x){	//This for-loop picks up a number of genes randomly 
			tournamentPopulation.getGenes()[x] = population.getGenes()[(int)(Math.random() * population.getGenes().length)];
		}
		tournamentPopulation.sortGenesByFitness();
		return tournamentPopulation;
	}
	
	private Gene crossoverGene(Gene gene1, Gene gene2){	//This method does a random gene selection from each one of the parent genes.
		Gene crossoverGene = new Gene(TARGET_GENE.length);
		//This for-loop will do random gene selection
		for (int x = 0; x < gene1.getUnits().length; x++) {
			if (Math.random() >= 0.5) {	//0.5 acts as a thresold
				crossoverGene.getUnits()[x] = gene1.getUnits()[x];
			} else {
				crossoverGene.getUnits()[x] = gene2.getUnits()[x];
			}
		}
		return crossoverGene;
	}
	
	private Gene mutateGene(Gene gene){	
		//Apply randomness to the gene from the input parameter before returning it
		
	}
	
}
