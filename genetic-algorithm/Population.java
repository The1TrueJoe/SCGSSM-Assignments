package geneticalgorithm;

import java.util.Random;

public class Population {

    private Individual[] individuals;

    private int population_size;
    private int gene_length;
    private int fittest_score = 0;

    /**
     * Initializes the population
     *
     * @param population_size population size
     * @param gene_length     number of genes
     */

    public Population(int population_size, int gene_length) {
        this.population_size = population_size;
        this.gene_length = gene_length;
        this.individuals = new Individual[population_size];

        for (int i = 0; i < population_size; i++) {
            individuals[i] = new Individual(gene_length);

        }

        findFitnesses();
    }

    public void RandomizePop(int new_population_size) {
        Individual[] individuals_tmp = new Individual[new_population_size];
        Random rng = new Random();

        for (int i = 0; i < individuals_tmp.length; i++) {
            individuals_tmp[i] = individuals[rng.nextInt(individuals.length-1)];
        }

        individuals = individuals_tmp;
    }

    /**
     * @return Most fit individual
     */

    public Individual getMostFit() {
        int max_fit = Integer.MIN_VALUE;
        int max_fit_index = 0;

        for (int i = 0; i < individuals.length; i++) {
            if (max_fit <= individuals[i].getFitness()) {
                max_fit = individuals[i].getFitness();
                max_fit_index = i;

            }
        }

        fittest_score = individuals[max_fit_index].getFitness();

        return individuals[max_fit_index];
    }

    /**
     * @return The second most fit individual
     */

    public Individual getSecondMostFit() {
        int max_fit_1 = 0;
        int max_fit_2 = 0;

        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].getFitness() > individuals[max_fit_1].getFitness()) {
                max_fit_2 = max_fit_1;
                max_fit_1 = i;

            } else if (individuals[i].getFitness() > individuals[max_fit_2].getFitness()) {
                max_fit_2 = i;

            }
        }

        return individuals[max_fit_2];
    }

    /**
     * @return Index of the least fittest individual
     */

    public int getLeastFittestIndex() {
        int min_fit_val = Integer.MAX_VALUE;
        int min_fit_index = 0;

        for (int i = 0; i < individuals.length; i++) {
            if (min_fit_val >= individuals[i].getFitness()) {
                min_fit_val = individuals[i].getFitness();
                min_fit_index = i;

            }
        }

        return min_fit_index;
    }

    /**
     * @return Index of the fittest individual
     */

    public int getFittestIndex() {
        int max_fit = Integer.MIN_VALUE;
        int max_fit_index = 0;

        for (int i = 0; i < individuals.length; i++) {
            if (max_fit <= individuals[i].getFitness()) {
                max_fit = individuals[i].getFitness();
                max_fit_index = i;

            }
        }

        return max_fit_index;
    }

    /**
     * Goes through and calculates the fitnesses of all of the individuals
     */

    public void findFitnesses() {
        for (Individual individual : individuals) {
            individual.findFitness();
        }

        getMostFit();
    }

    public int getPopSize() { return population_size;  }
    public Individual[] getIndividuals() { return individuals; }
    public int getGeneLength() { return gene_length; }
    public int getFittestScore() { return fittest_score; }

    public void setPopSize(int population_size) { this.population_size = population_size; }
    public void setIndividuals(Individual[] individuals) { this.individuals = individuals; }
    public void setGeneLength(int gene_length) { this.gene_length = gene_length; }
    public void setFittestScore(int fittest_score) { this.fittest_score = fittest_score; }

}