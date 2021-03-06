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

/**
 * A {@linkplain net.sourceforge.cilib.controlparameter.ControlParameter control parameter}
 * that is defined to return a proportional value.
 */
public class ProportionalControlParameter implements ControlParameter {

    private static final long serialVersionUID = 8415953407107514281L;
    private double proportion;

    /**
     * Create a new {@code ProportionalControlParameter} instance. The default proportion
     * value is defined to be 0.1 (10%).
     */
    public ProportionalControlParameter() {
        this.proportion = 0.1;
    }

    public ProportionalControlParameter(double proportion) {
        this.proportion = proportion;
    }

    public ProportionalControlParameter(ProportionalControlParameter copy) {
        this.proportion = copy.proportion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProportionalControlParameter getClone() {
        return new ProportionalControlParameter(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getParameter() {
        return this.proportion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getParameter(double min, double max) {
        double diff = max - min;
        return this.proportion * diff;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setParameter(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("The proportion must be positive");
        }

        this.proportion = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateParameter() {
    }
}
