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
package net.sourceforge.cilib.pso.particle;

/**
 *
 * @author Edwin Peer
 * @author Gary Pampara
 * @modified Daniel Lowes
 */
public class CoherenceParticle extends StandardParticle {
    private static final long serialVersionUID = 7558011414998829458L;

    /** Creates a new instance of StandardParticle. */
    public CoherenceParticle() {
        super();
    }


    /**
     * Copy Constructor.
     * @param copy
     */
    public CoherenceParticle(CoherenceParticle copy) {
        super(copy);
    }

    /**
     *
     */
    public CoherenceParticle getClone() {
           return new CoherenceParticle(this);
    }


}
