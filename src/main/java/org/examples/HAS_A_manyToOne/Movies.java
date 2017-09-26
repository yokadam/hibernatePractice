package org.examples.HAS_A_manyToOne;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class Movies {

    private int mId;
    private String name;
    private Actor actor;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
