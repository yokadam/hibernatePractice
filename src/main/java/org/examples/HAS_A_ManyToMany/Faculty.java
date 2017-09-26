package org.examples.HAS_A_ManyToMany;

import java.util.Set;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class Faculty {

    private int fid;
    private String fname;
    private Set<Course> courses;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
