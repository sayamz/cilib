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
package net.sourceforge.cilib.math.random;

import net.sourceforge.cilib.math.Maths;

/**
 *
 * @author Gary Pampara
 *
 */
public final class DiscreteRandomNumber {

    /**
     * Default constructor hidden - this is a utility class.
     */
    private DiscreteRandomNumber() {
    }

    /**
     * Get the value of the Poisson distribution given a specific point and
     * specific lambda value.
     * @param x The point to calculate the distribution value from.
     * @param lambda The value of lambda.
     * @return The value at point {@code x}.
     */
    public static double getPoisson(int x, int lambda) {
        double numerator = Math.pow(Math.E, -lambda) * Math.pow(lambda, x);
        double denominator = Maths.factorial(x);
        return numerator / denominator;
    }

    /**
     * Get the value of the Binomial distribution at point {@code x}, given the values
     * for {@code p} and {@code n}.
     * @param x The point to calculate the distribution value from.
     * @param p The value of {@code p}.
     * @param n The value of {@code n}.
     * @return The value of the binomial distribution.
     */
    public static double getBinomial(int x, int p, int n) {
        return Maths.combination(n, x) * Math.pow(p, x) * Math.pow((1-p), (n-x));
    }

}
