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
package net.sourceforge.cilib.algorithm;

/**
 * This exception is thrown whenever an algorithm is run without being properly initialised.
 *
 * @author  Edwin Peer
 */
public class InitialisationException extends java.lang.RuntimeException {
    private static final long serialVersionUID = -4744059625194428458L;

    /**
     * Creates a new instance of <code>InitialisationException</code> without detail message.
     */
    public InitialisationException() {
    }


    /**
     * Constructs an instance of <code>InitialisationException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InitialisationException(String msg) {
        super(msg);
    }
}
