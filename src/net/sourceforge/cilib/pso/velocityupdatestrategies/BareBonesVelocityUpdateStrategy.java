/*
 * BareBonesVelocityUpdate.java
 * 
 * Created on Jul 26, 2004
 *
 * Copyright (C) 2004 - CIRG@UP 
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science 
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package net.sourceforge.cilib.pso.velocityupdatestrategies;

import net.sourceforge.cilib.controlparameterupdatestrategies.ControlParameterUpdateStrategy;
import net.sourceforge.cilib.math.random.RandomNumber;
import net.sourceforge.cilib.pso.parameterupdatestrategies.AccelerationUpdateStrategy;
import net.sourceforge.cilib.pso.particle.Particle;
import net.sourceforge.cilib.type.types.Vector;

/**
 *  The <tt>VelocityUpdateStrategy</tt> strategy for the Bare Bones PSO as
 *  defined by Kennedy.
 * 
 *  TODO: get the required references
 * 
 *  @author Gary Pampara
 *  @author Andries Engelbrecht
 */
public class BareBonesVelocityUpdateStrategy implements VelocityUpdateStrategy {
	
	private RandomNumber randomNumber;
	private ControlParameterUpdateStrategy cognitive;
	private ControlParameterUpdateStrategy social;
	

	public BareBonesVelocityUpdateStrategy() {
		randomNumber = new RandomNumber();
		
		cognitive = new AccelerationUpdateStrategy();
		social = new AccelerationUpdateStrategy();
		
		cognitive.setParameter(1.496180);
		social.setParameter(1.496180);
	}
	
	
	public BareBonesVelocityUpdateStrategy(BareBonesVelocityUpdateStrategy copy) {
		this();
		
		cognitive.setParameter(copy.cognitive.getParameter());
		social.setParameter(copy.social.getParameter());
	}
	
	
	public BareBonesVelocityUpdateStrategy clone() {
		return new BareBonesVelocityUpdateStrategy(this);
	}
	
	
	public void updateVelocity(Particle particle) {
		Vector personalBestPosition = (Vector) particle.getBestPosition();
		Vector nBestPosition = (Vector) particle.getNeighbourhoodBest().getBestPosition();
		Vector velocity = (Vector) particle.getVelocity();

		for (int i = 0; i < particle.getDimension(); ++i) {
			double tmp1 = cognitive.getParameter();
			double tmp2 = social.getParameter();
			
        	double sigma = Math.abs(personalBestPosition.getReal(i) - nBestPosition.getReal(i));
        	double mean = (tmp1*personalBestPosition.getReal(i) + tmp2*nBestPosition.getReal(i)) / (tmp1+tmp2);
			
			velocity.setReal(i, randomNumber.getGaussian(mean, sigma));
        }
	}


	public void updateControlParameters() {
		// TODO Auto-generated method stub
		
	}
	
}
