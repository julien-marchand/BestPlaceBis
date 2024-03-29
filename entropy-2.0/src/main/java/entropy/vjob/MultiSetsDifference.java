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

import java.util.LinkedList;
import java.util.List;

import entropy.configuration.DefaultManagedElement;

/**
 * A composed multiset to perform the difference between two multisets.
 *
 * @author Fabien Hermenier
 */
public class MultiSetsDifference<T extends DefaultManagedElement> extends ComposedMultiSet<T> {

    /**
     * Make a labeled difference between two multi sets.
     *
     * @param lbl the label of the resulting multi set
     * @param h   the first multi set.
     * @param t   the second multi set
     */
    public MultiSetsDifference(String lbl, VJobMultiSet<T> h, VJobMultiSet<T> t) {
        super(lbl, h, t);
    }

    /**
     * Make a new difference between two multi sets.
     *
     * @param h the first multi set.
     * @param t the second multi set
     */
    public MultiSetsDifference(VJobMultiSet<T> h, VJobMultiSet<T> t) {
        super(h, t);
    }

    @Override
    public String operator() {
        return " - ";
    }

    @Override
    public List<ExplodedSet<T>> expand() {
        List<ExplodedSet<T>> res = new LinkedList<ExplodedSet<T>>();
        res.addAll(first().expand());
        res.removeAll(second().expand());
        return res;
    }

    @Override
    public int size() {
        return expand().size();
    }
}
