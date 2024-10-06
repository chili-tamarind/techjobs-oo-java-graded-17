package org.launchcode.techjobs.oo;

import javax.swing.text.Position;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;
    private boolean defaultConstructor;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
        defaultConstructor = true;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
        defaultConstructor = false;
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() { return id; }
    public static int getNextId() { return nextId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Employer getEmployer() { return employer; }
    public void setEmployer(Employer employer) { this.employer = employer; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public PositionType getPositionType() { return positionType; }
    public void setPositionType(PositionType positionType) { this.positionType = positionType; }

    public CoreCompetency getCoreCompetency() { return coreCompetency; }
    public void setCoreCompetency(CoreCompetency coreCompetency) { this.coreCompetency = coreCompetency;}

    public boolean isDefaultConstructor() { return defaultConstructor; }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        String jobText;
        String emptyText = "Data not available";

        String idText = String.valueOf(getId());
        String nameText = (getName().isEmpty()) ? emptyText : getName();
        String employerText = (getEmployer().getValue().isEmpty()) ? emptyText : getEmployer().getValue();
        String locationText = (getLocation().getValue().isEmpty()) ? emptyText : getLocation().getValue();
        String positionText = (getPositionType().getValue().isEmpty()) ? emptyText : getPositionType().getValue();
        String competencyText = (getCoreCompetency().getValue().isEmpty()) ? emptyText : getCoreCompetency().getValue();

        if (defaultConstructor) {
            jobText = "OOPS! This job does not seem to exist.";
        }
        else {
            jobText = System.lineSeparator() +
                    "ID: " + idText + System.lineSeparator() +
                    "Name: " + nameText + System.lineSeparator() +
                    "Employer: " + employerText + System.lineSeparator() +
                    "Location: " + locationText + System.lineSeparator() +
                    "Position Type: " + positionText + System.lineSeparator() +
                    "Core Competency: " + competencyText + System.lineSeparator() ;
        }

        return jobText;
    }
}
