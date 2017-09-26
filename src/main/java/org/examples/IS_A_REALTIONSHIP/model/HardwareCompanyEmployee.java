package org.examples.IS_A_REALTIONSHIP.model;

/**
 * Created by yogesh.kadam on 03.09.17.
 */
public class HardwareCompanyEmployee extends CompanyEmployee {

    private int workingHours;

    public HardwareCompanyEmployee(int workingHours) {
        this.workingHours = workingHours;
    }

    public HardwareCompanyEmployee(String name, String email, int salary, int workingHours) {
        super(name, email, salary);
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
}
