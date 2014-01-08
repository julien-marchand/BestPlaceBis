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
package entropy.plan.action;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import entropy.configuration.Configuration;
import entropy.configuration.DefaultNode;
import entropy.configuration.DefaultVirtualMachine;
import entropy.configuration.Node;
import entropy.configuration.VirtualMachine;
import entropy.execution.TimedExecutionGraph;
import entropy.plan.parser.TimedReconfigurationPlanSerializer;
import entropy.plan.visualization.PlanVisualizer;

/**
 * Unit tests for VirtualMachineAction.
 *
 * @author Fabien Hermenier
 */
@Test(groups = {"unit"})
public class TestVirtualMachineAction {

    /**
     * A simple implementation, just for tests.
     *
     * @author Fabien Hermenier
     */
    class MockVirtualMachineAction extends VirtualMachineAction {

        public MockVirtualMachineAction(VirtualMachine v, Node n) {
            super(v, n);
        }

        @Override
		public boolean apply(Configuration c) {
            return false;
        }

        @Override
        public boolean isCompatibleWith(Configuration src) {
            return false;
        }


        @Override
		public boolean isCompatibleWith(Configuration c, Configuration d) {
            return false;
        }

        public void undo(Configuration c) {
        }

        @Override
        public boolean insertIntoGraph(TimedExecutionGraph g) {
            return false;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void injectToVisualizer(PlanVisualizer vis) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void serialize(TimedReconfigurationPlanSerializer s) throws IOException {
            throw new UnsupportedOperationException();
        }

    }

    /**
     * Test the accessors.
     */
    public void testGets() {
        DefaultVirtualMachine vm1 = new DefaultVirtualMachine("vm1", 1, 2, 3);
        DefaultNode n1 = new DefaultNode("n1", 2, 3, 4);
        MockVirtualMachineAction m = new MockVirtualMachineAction(vm1, n1);
        Assert.assertEquals(m.getVirtualMachine(), vm1);
        Assert.assertEquals(m.getHost(), n1);
    }
}