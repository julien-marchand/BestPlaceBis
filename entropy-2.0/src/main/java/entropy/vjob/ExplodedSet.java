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

import entropy.configuration.ManagedElement;
import entropy.configuration.ManagedElementSet;
import entropy.configuration.SimpleManagedElementSet;

/**
 * A set of elements specified individually.
 *
 * @author Fabien Hermenier
 */
public class ExplodedSet<T extends ManagedElement> extends SimpleManagedElementSet<T> implements VJobSet<T> {

    /**
     * The label of the set. Optionnal
     */
    private String label;

    /**
     * Make an empty set with a label.
     *
     * @param id the label of the set
     */
    public ExplodedSet(String id) {
        label = id;
    }

    /**
     * Make an empty set
     */
    public ExplodedSet() {

    }

    /**
     * Make a set composed of the element of a common set.
     *
     * @param id   the label of the set
     * @param back the set to copy
     */
    public ExplodedSet(String id, ManagedElementSet<T> back) {
        this(id);
        this.addAll(back);
    }

    /**
     * Make a new set composed of the element of a common set.
     *
     * @param back the set to copy
     */
    public ExplodedSet(ManagedElementSet<T> back) {
        this.addAll(back);
    }

    @Override
    public ExplodedSet<T> flatten() {
        return this;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String id) {
        this.label = id;
    }

    @Override
    public String pretty() {
        String lbl = getLabel();
        if (lbl == null) {
            return super.toString();
        }
        return lbl;
    }

    @Override
    public String definition() {
        return super.toString();
    }

    @Override
    public ManagedElementSet<T> getElements() {
        return flatten();
    }


    @Override
    public String toString() {
        if (label != null) {
            return label;
        }
        return definition();
    }


}
