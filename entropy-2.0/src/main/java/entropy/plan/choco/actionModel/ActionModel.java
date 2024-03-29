/*
 * Copyright (c) Fabien Hermenier
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
package entropy.plan.choco.actionModel;

import choco.kernel.solver.variables.integer.IntDomainVar;
import entropy.configuration.Configuration;
import entropy.plan.action.Action;
import entropy.plan.choco.ReconfigurationProblem;
import entropy.plan.choco.actionModel.slice.ConsumingSlice;
import entropy.plan.choco.actionModel.slice.DemandingSlice;

/**
 * An abstract time bounded action.
 *
 * @author Fabien Hermenier
 */
public abstract class ActionModel {

    /**
     * The duration of the action.
     */
    protected IntDomainVar duration;

    protected ConsumingSlice cSlice = null;

    protected DemandingSlice dSlice = null;


    /**
     * Get the start moment of the action.
     *
     * @return the moment the action starts
     */
    public abstract IntDomainVar start();

    /**
     * Get the end moment of the action.
     *
     * @return the moment the action ends
     */
    public abstract IntDomainVar end();

    /**
     * Get the action for the plan defined during the solving process.
     *
     * @param solver the solver
     * @return an Action. May be null the it does not generate any action for the DefaultTimedReconfigurationPlan
     */
    public abstract Action getDefinedAction(ReconfigurationProblem solver);

    /**
     * Put the result of applying this solved action into a configuration.
     *
     * @param solver the solver to get the solution
     * @param cfg    the configuration to populate
     * @return true if the action modify the configuration
     */
	public abstract boolean putResult(ReconfigurationProblem solver, Configuration cfg);

    /**
     * Get the global cost of an action.
     *
     * @return the moment the action ends.
     */
    public IntDomainVar getGlobalCost() {
        return end();
    }

    /**
     * Get the duration of the action.
     *
     * @return a variable
     */
    public IntDomainVar getDuration() {
        return duration;
    }

    /**
     * Get the consuming slice associated to the action.
     *
     * @return a slice. May be null
     */
    public ConsumingSlice getConsumingSlice() {
        return cSlice;
    }

    /**
     * Get the demanding slice associated to the action.
     *
     * @return a slice. May be null
     */
    public DemandingSlice getDemandingSlice() {
        return dSlice;
    }
}
