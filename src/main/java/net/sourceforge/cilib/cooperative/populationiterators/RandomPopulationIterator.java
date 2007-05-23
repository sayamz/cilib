package net.sourceforge.cilib.cooperative.populationiterators;

import java.util.List;

import net.sourceforge.cilib.algorithm.Algorithm;
import net.sourceforge.cilib.algorithm.population.PopulationBasedAlgorithm;
import net.sourceforge.cilib.cooperative.ParticipatingAlgorithm;
import net.sourceforge.cilib.math.random.RandomNumber;

/**
 * TODO test this class
 * @author Theuns Cloete
 */
public class RandomPopulationIterator implements PopulationIterator {
	List<PopulationBasedAlgorithm> populations = null;
	RandomNumber random = null;
	int iterations = 0;

	public RandomPopulationIterator() {
		random = new RandomNumber();
		iterations = 0;
	}
	
	public RandomPopulationIterator(RandomPopulationIterator rhs) {
		populations = rhs.populations;
		random = new RandomNumber();
		iterations = rhs.iterations;
	}

	public RandomPopulationIterator clone() {
		return new RandomPopulationIterator(this);
	}

	public boolean hasNext() {
		return iterations < populations.size();
	}

	@SuppressWarnings("unchecked")
	public Algorithm next() {
		Algorithm population = null;
		do {
			population = populations.get((int)random.getUniform(0, populations.size()));
		} while(((ParticipatingAlgorithm)population).participated());

		iterations++;
		return population;
	}

	public void remove() {
		throw new UnsupportedOperationException("Removal of a ParticipatingAlgorithm from a CooperativeOptimisationAlgorithm is not supported");
	}

	public void setPopulations(List<PopulationBasedAlgorithm> p) {
		populations = p;
	}

	public void add(Algorithm o) {
		// TODO Auto-generated method stub
		
	}

	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Algorithm previous() {
		// TODO Auto-generated method stub
		return null;
	}

	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void set(Algorithm o) {
		// TODO Auto-generated method stub
		
	}
}