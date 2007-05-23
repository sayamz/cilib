/*
 * NastyBenchmark.java
 *
 * Created on January 12, 2003, 2:48 PM
 *
 * 
 * Copyright (C) 2003 - 2006 
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
 *   
 */

package net.sourceforge.cilib.functions.continuous;

import net.sourceforge.cilib.functions.ContinuousFunction;
import net.sourceforge.cilib.type.types.Vector;


/**
 *
 * @author  Edwin Peer
 */
public class NastyBenchmark extends ContinuousFunction {
	private static final long serialVersionUID = 6848836780892359015L;

	public NastyBenchmark() {
        setDomain("R(-500, 500)^30");
    }
    
    public Object getMinimum() {
        return new Double(0);
    }
    
    public double evaluate(Vector x) {
        double tmp = 0;
        for (int i = 0; i < getDimension(); ++i) {
        	double factor = (x.getReal(i) - (i + 1));
        	tmp += factor * factor;
        }
        return tmp;
    }
    
}