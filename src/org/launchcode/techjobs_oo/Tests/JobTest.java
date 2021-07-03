package org.launchcode.techjobs_oo.Tests;

import org.launchcode.techjobs_oo.*;
import org.junit.*;

import static org.junit.Assert.*;

public class JobTest {
    //Declare the job objects
    private Job j1, j2, j3, j4, j5;

    @Before
    public void createJobObjects() {
        //Instantiate the job objects
         j1 = new Job();
         j2 = new Job("Product Manager", new Employer("Boeing"), new Location(""), new PositionType(""), new CoreCompetency(""));
         j3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         j4 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        //first job should be given id of 1
        //second job should be given id of 2
        //subtract ID of job 2 from ID of job 1
        assertEquals(1, j2.getId() - j1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product Tester", j3.getName());
        assertEquals("ACME", j3.getEmployer().getValue());
        assertEquals("Desert", j3.getLocation().getValue());
        assertEquals("Quality control", j3.getPositionType().getValue());
        assertEquals("Persistence", j3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(j3.equals(j4));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLineChar() {
        char firstChar = j3.toString().charAt(0);
        char lastChar = j3.toString().charAt(j3.toString().length()-1);
        assertTrue(firstChar == lastChar);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String output = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n", j3.getId(), j3.getName(), j3.getEmployer(), j3.getLocation(),
                j3.getPositionType(), j3.getCoreCompetency());
        assertEquals(output, j3.toString());
    }

    @Test
    public void testToStringHandlingOfEmptyField() {
        String output = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: Data not available\n" +
                        "Position Type: Data not available\n" +
                        "Core Competency: Data not available\n", j2.getId(), j2.getName(), j2.getEmployer());
        assertEquals(output, j2.toString());
    }
}

