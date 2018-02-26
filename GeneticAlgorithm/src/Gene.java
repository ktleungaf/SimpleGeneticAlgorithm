import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

//A gene represents a candidate's solution
public class Gene {
	// private double[] units;
	private int[] units;

	private int fitness = 0;

	private boolean isFitnessChanged = true;

	public Gene(int length) {
		units = new int[length];
		// units = new double[length];
	}

	public Gene initGene() {
		// try(
		// Scanner scanner = new Scanner(new File("training-set.csv"))
		// ){
		// ;
		// scanner.useDelimiter(",");
		// while(scanner.hasNext()){
		//
		// System.out.print(scanner.next()+"|");
		// }
		// scanner.close();
		// }

		for (int x = 0; x < units.length; x++) {
			if (Math.random() >= 0.5) {
				units[x] = 1;
			} else {
				units[x] = 0;
			}
		}

		return this;
	}

	public int[] getUnits() {
		isFitnessChanged = true;
		return units;
	}

	public int getFitness() {
		if (isFitnessChanged) { // recalculate the fitness value is the fitness is changed
			fitness = calculateFitness();
			isFitnessChanged = false;
		}
		return fitness;
	}

	public int calculateFitness() {
		int geneFitness = 0;
		for (int x = 0; x < units.length; ++x) {
			if (units[x] == GeneticAlgorithm.TARGET_GENE[x]) {
				++geneFitness;
			}
		}
		return geneFitness; // Each time if we have a match, return the geneFitness
	}

	@Override
	public String toString() {
		return Arrays.toString(this.units);
	}
}
