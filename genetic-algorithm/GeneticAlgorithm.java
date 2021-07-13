package geneticalgorithm;

import java.util.Arrays;
import java.util.Random;

public class GeneticAlgorithm {

    private Population population;

    private Individual most_fit;
    private Individual second_most_fit;

    private int generation_count;
    private static int gene_count;
    private static int individual_count;

    public GeneticAlgorithm() {
        this.population = new Population(individual_count, gene_count);
        this.generation_count = 0;
    }

    public GeneticAlgorithm(Population population) {
        this.population = population;
        this.generation_count = 0;

        gene_count = population.getGeneLength();
        individual_count = population.getPopSize();
    }

    public static void main(String[] args) {
        Random rng = new Random();

        int gene_count = 10;
        int individual_count = 500;

        GeneticAlgorithm genetic_algorithm = new GeneticAlgorithm(new Population(individual_count, gene_count));

        System.out.println("Population: " + genetic_algorithm.population.getPopSize() + " individual(s)");
        System.out.println("\nGeneration: " + genetic_algorithm.generation_count + " Fittest: " + genetic_algorithm.population.getFittestScore());

        showGeneticPool(genetic_algorithm.population.getIndividuals());

        while (genetic_algorithm.population.getFittestScore() < gene_count) {
            genetic_algorithm.generation_count++;

            genetic_algorithm.Selection();
            genetic_algorithm.Crossover();

            if (rng.nextInt() % 7 < 5) { genetic_algorithm.Mutate(); }

            genetic_algorithm.addFittestOffspring();
            genetic_algorithm.population.findFitnesses();

            System.out.println("\nGeneration: " + genetic_algorithm.generation_count + " Fittest score: " + genetic_algorithm.population.getFittestScore());

            showGeneticPool(genetic_algorithm.population.getIndividuals());

            double multiplier = (individual_count * Double.parseDouble(rng.nextInt(2) + "." + rng.nextInt(9)));
            multiplier = multiplier > 1 ? multiplier : 1.0;
            individual_count = (int) ((individual_count * multiplier) - (individual_count));
            genetic_algorithm.population.RandomizePop(individual_count);
            if (individual_count <= 1) { System.out.println("Population Failed"); System.exit(0); }
        }

        System.out.println("\nSolution Generation: " + genetic_algorithm.generation_count);
        System.out.println("Index of Perfect Individual: " + genetic_algorithm.population.getFittestIndex());
        System.out.println("Fitness: " + genetic_algorithm.population.getFittestScore());

        System.out.print("Genes: " + Arrays.toString(genetic_algorithm.population.getMostFit().getGenes()));

        System.out.println();

    }

    private void Selection() {
        most_fit = population.getMostFit();
        second_most_fit = population.getSecondMostFit();

    }

    private void Crossover() {
        Random rng = new Random();

        int cross_over_point = rng.nextInt(gene_count);

        for (int i = 0; i < cross_over_point; i++) {
            int tmp = most_fit.getGenes()[i];

            most_fit.getGenes()[i] = second_most_fit.getGenes()[i];
            second_most_fit.getGenes()[i] = tmp;

        }

    }

    private void Mutate() {
        Random rng = new Random();

        int mutation_point = rng.nextInt(gene_count);

        if (most_fit.getGenes()[mutation_point] == 0) {
            most_fit.getGenes()[mutation_point] = 1;

        } else {
            most_fit.getGenes()[mutation_point] = 0;

        }

        mutation_point = rng.nextInt(gene_count);

        if (second_most_fit.getGenes()[mutation_point] == 0) {
            second_most_fit.getGenes()[mutation_point] = 1;
        } else {
            second_most_fit.getGenes()[mutation_point] = 0;
        }
    }

    private Individual getFittest() {
        if (most_fit.getFitness() > second_most_fit.getFitness()) {
            return most_fit;

        } else {
            return second_most_fit;

        }

    }

    private void addFittestOffspring() {
        most_fit.findFitness();
        second_most_fit.findFitness();

        int least_fittest_index = population.getLeastFittestIndex();

        //Replace least fittest individual from most fittest offspring
        population.getIndividuals()[least_fittest_index] = getFittest();
    }

    static void showGeneticPool(Individual[] individuals) {
        System.out.println("Genetic Pool");
        int increment = 0;

        for (Individual individual : individuals) {
            System.out.println("Individual " + (increment+1) + ":  " + individual.toString());
            increment++;

        }

        System.out.println("-------------------------");
    }
}

