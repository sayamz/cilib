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
package net.sourceforge.cilib.pso.moo.guideupdatestrategies;

import net.sourceforge.cilib.entity.EntityType;
import net.sourceforge.cilib.entity.Particle;
import net.sourceforge.cilib.type.types.container.Vector;

/**
 * <p>
 * This the standard {@link GuideUpdateStrategy} in that it always updates the
 * given particle's guide.
 * </p>
 *
 * @author Wiehann Matthysen
 */
public class StandardGuideUpdateStrategy implements GuideUpdateStrategy {

    private static final long serialVersionUID = 8789840282089215758L;

    public StandardGuideUpdateStrategy() {
    }

    public StandardGuideUpdateStrategy(StandardGuideUpdateStrategy copy) {
    }

    @Override
    public StandardGuideUpdateStrategy getClone() {
        return new StandardGuideUpdateStrategy(this);
    }

    @Override
    public void updateGuide(Particle particle, EntityType.Particle.Guide guideType, Vector newGuide) {
        particle.getProperties().put(guideType, newGuide);
    }
}
