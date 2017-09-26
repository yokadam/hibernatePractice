package org.examples.IS_A_REALTIONSHIP.model;

/**
 * Created by yogesh.kadam on 03.09.17.
 */
public class SoftwareCompanyEmployee extends CompanyEmployee {

    private String tools;

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public SoftwareCompanyEmployee(String tools) {
        this.tools = tools;
    }

    public SoftwareCompanyEmployee(String name, String email, int salary, String tools) {
        super(name, email, salary);
        this.tools = tools;
    }
}
