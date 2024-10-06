package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {

    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        String msg = "job IDs should be different";
        Job job1 = new Job();
        Job job2 = new Job();
        boolean conditional = (job1.equals(job2));
        assertNotEquals(msg, conditional);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String msg = "job Constructor should set all the parameters";
        Job job3 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //Instance check
        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);

        //Value check
        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        String msg = "job should have unique ids";
        Job job4 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        boolean conditional = (job4.equals(job5));
        assertFalse(msg, conditional);
    }

    // Task 5: Use TDD to Build The toString Method

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String msg = "job string should start and end with new line ";
        Job job6 = new Job("Space Dev 6", new Employer("MacroNet"),
                new Location("Jupyter"), new PositionType("Senior Dev"), new CoreCompetency("Sentience"));

        boolean conditionalStart = (job6.toString().startsWith(System.lineSeparator()));
        boolean conditionalEnd = (job6.toString().endsWith(System.lineSeparator()));

        assertTrue(msg, conditionalStart);
        assertTrue(msg, conditionalEnd);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String msg = "job string should contain the correct label and data ";
        Job job7 = new Job("Space Dev 7", new Employer("MacroNet"),
                new Location("Jupyter"), new PositionType("Senior Dev"), new CoreCompetency("Sentience"));

        String idText = String.valueOf(job7.getId());
        String jobText = System.lineSeparator() +
                "ID: " + idText + System.lineSeparator() +
                "Name: Space Dev 7" + System.lineSeparator() +
                "Employer: MacroNet" + System.lineSeparator() +
                "Location: Jupyter" + System.lineSeparator() +
                "Position Type: Senior Dev" + System.lineSeparator() +
                "Core Competency: Sentience" + System.lineSeparator();

        boolean conditional = (job7.toString().equals(jobText));
        assertTrue(msg, conditional);
    }

    public void testToStringHandlesEmptyField() {
        String msg = "job string should handle empty field ";
        Job job8 = new Job();
        String jobText = "OOPS !This job does not seem to exist.";

        boolean conditional = (job8.toString().equals(jobText));
        assertTrue(msg, conditional);
    }
}
