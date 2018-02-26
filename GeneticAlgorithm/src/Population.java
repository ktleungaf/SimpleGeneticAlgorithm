import java.util.Arrays;

//A "Population" class represents a population of genes.
public class Population {
	private Gene[] genes;

	public Population(int length) {
		genes = new Gene[length];
	}

	public Population initPopulation() {
		for (int x = 0; x < genes.length; ++x) {
			genes[x] = new Gene(GeneticAlgorithm.TARGET_GENE.length).initGene();
		}
		sortGenesByFitness();
		return this;
	}

	public Gene[] getGenes() {
		return genes;
	}

	public void sortGenesByFitness() {
		Arrays.sort(genes, (gene1, gene2) -> {
			int flag = 0;
			if (gene1.getFitness() > gene2.getFitness()) {
				flag = -1;
			} else if (gene1.getFitness() < gene2.getFitness()) {
				flag = -1;
			}
			return flag;
		});

	}
}
