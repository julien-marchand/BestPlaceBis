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
package entropy.execution.driver;

import org.testng.Assert;
import org.testng.annotations.Test;

import entropy.PropertiesHelper;
import entropy.TestHelper;
import entropy.configuration.DefaultNode;
import entropy.plan.action.Startup;

/**
 * Unit tests for the SSHDriver.
 *
 * @author Fabien Hermenier
 */
@Test(groups = {"unit"})
public class TestSSHDriver {

    /**
     * Base for the resources path.
     */
    public static final String RESOURCES_BASE = "src/test/resources/entropy/execution/driver/TestSSHDriver.";

    /**
     * Basic test for gets*.
     */
    public void testGets() {
        try {
            PropertiesHelper props = TestHelper.readEntropyProperties(RESOURCES_BASE + "testGets.txt");
            MockSSHDriver m = new MockSSHDriver(new Startup(new DefaultNode("N1", 1, 2, 3)), props);
            Assert.assertEquals(m.getUsername(), "toto");
            Assert.assertEquals(m.getIdentityFile(), "myKey");
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }

    /**
     * Test gets* without a username.
     */
    public void testGetsWithoutUsername() {
        try {
            PropertiesHelper props = TestHelper.readEntropyProperties(RESOURCES_BASE + "testGetsWithoutUsername.txt");
            MockSSHDriver m = new MockSSHDriver(new Startup(new DefaultNode("N1", 1, 2, 3)), props);
            Assert.assertEquals(m.getUsername(), System.getProperty("user.name"));
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }

    /**
     * Test with default properties.
     */
    public void testWithDefaultProperties() {
        try {
            PropertiesHelper props = TestHelper.readDefaultEntropyProperties();
            MockSSHDriver m = new MockSSHDriver(new Startup(new DefaultNode("N1", 1, 2, 3)), props);
            Assert.assertEquals(m.getUsername(), "root");
            Assert.assertEquals(m.getIdentityFile(), "config/privateKey");
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }

    /**
     * Dummy test to prevent a NullPointerException.
     */
    public void testToString() {
        try {
            PropertiesHelper props = TestHelper.readDefaultEntropyProperties();
            MockSSHDriver m = new MockSSHDriver(new Startup(new DefaultNode("N1", 1, 2, 3)), props);
            Assert.assertNotNull(m.toString());
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
