/*
 * Copyright (c) 2010 Ecole des Mines de Nantes.
 *
 *      This file is part of Entropy.
 *
 *      Entropy is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU Lesser General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      Entropy is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU Lesser General Public License for more details.
 *
 *      You should have received a copy of the GNU Lesser General Public License
 *      along with Entropy.  If not, see <http://www.gnu.org/licenses/>.
 */

package entropy.vjob;

import java.util.List;

import entropy.configuration.ManagedElement;

/**
 * Specifiy a set composed of other set of elements.
 *
 * @author Fabien Hermenier
 */
public interface VJobMultiSet<T extends ManagedElement> extends VJobElement<T> {

    /**
     * Expand the multiset.
     * All the set in the multiset are expanded
     *
     * @return a list of set of elements
     */
    List<ExplodedSet<T>> expand();

    /**
     * The number of sets in the multiset
     *
     * @return a positive integer
     */
    int size();
}
