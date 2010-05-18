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
package net.sourceforge.cilib.controlparameter;

import java.io.Serializable;

import net.sourceforge.cilib.util.Cloneable;

/**
 * A {@linkplain net.sourceforge.cilib.controlparameter.ControlParameter control parameter} is a
 * parameter that is used within most {@linkplain net.sourceforge.cilib.algorithm.Algorithm algorithm}
 * types. These parameters are updatable and can be changed over time, if required.
 *
 * @author Gary Pampara
 * @author Andries Engelbrecht
 */
public interface ControlParameter extends Cloneable, Serializable {

    /**
     * Clone the current object such that a comparison of the clone and original object will yield
     * two separate, but duplicate objects.
     * @return The cloned <tt>ControlParameter</tt>
     */
    ControlParameter getClone();

    /**
     * Get the value of the represented parameter.
     * @return The value of the represented parameter.
     */
    double getParameter();

    /**
     * Get the parameter value based on the provided <code>min</code> and <code>max</code>.
     * @param min The minimum value to use in getting the parameter value
     * @param max The maximum value to use in getting the parameter value
     * @return The value of the represented parameter.
     */
    double getParameter(double min, double max);

    /**
     * Set the value of the represented parameter.
     * @param value The value to be used.
     */
    void setParameter(double value);

    /**
     * Update the required and needed parameters contained within this
     * {@linkplain net.sourceforge.cilib.controlparameter.ControlParameter parameter}.
     */
    void updateParameter();
}
