/**
 * Computational Intelligence Library (CIlib)
 * Copyright (C) 2003 - 2010
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, see <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.cilib.pso.positionupdatestrategies;

import net.sourceforge.cilib.entity.EntityType;
import net.sourceforge.cilib.entity.Particle;
import net.sourceforge.cilib.problem.MinimisationFitness;
import net.sourceforge.cilib.pso.particle.StandardParticle;
import net.sourceforge.cilib.type.types.Real;
import net.sourceforge.cilib.type.types.container.Vector;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;


/**
 *
 * @author gpampara
 */
public class StandardPersonalBestUpdateStrategyTest {

    /**
     * If a particle's current fitness is "more fit" than the current best
     * fitness, then the best fitness should equal the current fitness and the
     * best position should be updated to the current position.
     */
    @Test
    public void updatePersonalBest() {
        Particle particle = new StandardParticle();

        particle.getProperties().put(EntityType.FITNESS, new MinimisationFitness(200.0));
        particle.getProperties().put(EntityType.Particle.BEST_FITNESS, new MinimisationFitness(300.0));
        particle.getProperties().put(EntityType.CANDIDATE_SOLUTION, new Vector(1, new Real(0.0)));

        StandardPersonalBestUpdateStrategy strategy = new StandardPersonalBestUpdateStrategy();
        strategy.updatePersonalBest(particle);

        Assert.assertThat(particle.getBestFitness(), is(particle.getFitness()));
        Assert.assertThat(particle.getBestPosition(), is(particle.getPosition()));
    }

    /**
     * If a particle's current fitness is "less fit" than the current best
     * fitness, then the best fitness should <b>not be</b> equal the current fitness and the
     * best position should <b>not be</b> updated to the current position.
     */
    @Test
    public void updatePersonalBestFails() {
        Particle particle = new StandardParticle();

        particle.getProperties().put(EntityType.FITNESS, new MinimisationFitness(200.0));
        particle.getProperties().put(EntityType.Particle.BEST_FITNESS, new MinimisationFitness(100.0));
        particle.getProperties().put(EntityType.CANDIDATE_SOLUTION, new Vector(1, new Real(0.0)));

        StandardPersonalBestUpdateStrategy strategy = new StandardPersonalBestUpdateStrategy();
        strategy.updatePersonalBest(particle);

        Assert.assertThat(particle.getBestFitness(), is(not(particle.getFitness())));
        Assert.assertThat(particle.getBestPosition(), is(not(particle.getPosition())));
    }

}