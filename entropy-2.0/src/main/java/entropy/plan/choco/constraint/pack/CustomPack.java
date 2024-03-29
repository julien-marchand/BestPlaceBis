/*
 * Copyright (c) 2010 Ecole des Mines de Nantes and Fabien Hermenier
 *
 * This file is part of Entropy.
 *
 * Entropy is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Entropy is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Entropy.  If not, see <http://www.gnu.org/licenses/>.
 */

package entropy.plan.choco.constraint.pack;

import choco.kernel.memory.IStateBitSet;

/**
 * Interface to get remaining space on a no.
 */
public interface CustomPack {

    /**
     * Get the remaining space on a bin.
     *
     * @param bin the bin
     * @return the current free space
     */
    int getRemainingSpace(int bin);

    IStateBitSet getCandidates(int bin);
}
