package org.examples.HAS_A_ManyToMany;

import java.util.Set;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class Course {

    private int cid;
    private String cname;
    private Set<Faculty> faculties;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }
}
