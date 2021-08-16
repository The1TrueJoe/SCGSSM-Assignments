package geneticalgorithm;

import java.util.Random;
import java.util.Arrays;

/**
 * The individual within the population
 */

public class Individual {
    private int[] genes;

    private int gene_length;
    private int fitness = 0;

    public Individual(int gene_length) {
        this.gene_length = gene_length;
        this.genes = new int[gene_length];

        Random rng = new Random();

        for (int i = 0; i < genes.length; i++) {
            genes[i] = Math.abs(rng.nextInt() % 2);

        }

        fitness = 0;
    }

    public Individual(int[] genes) {
        this.genes = genes;
        gene_length = genes.length;

    }

    /**
     * Finds the fitness by counting the number of genes that contain a 1
     */

    public void findFitness() {
        fitness = 0;

        for (int gene : genes) {
            if (gene == 1) {
                fitness++;
            }
        }
    }

    public String toString() { return "Genes: {" + Arrays.toString(genes) + "}";  }

    public int getGeneLength() {return gene_length; }
    public int getFitness() { return fitness; }
    public int[] getGenes() { return genes; }

    public void setGeneLength(int gene_length) { this.gene_length = gene_length; }
    public void setFitness(int fitness) { this.fitness = fitness; }
    public void setGenes(int[] genes) { this.genes = genes; }
}

