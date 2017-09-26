package org.examples.HAS_A_OneToMany;

import java.util.Set;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class Actor {

    private int aId;
    private String name;
    private Set<Movies> movies;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public Set<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movies> movies) {
        this.movies = movies;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
