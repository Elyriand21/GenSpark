package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;

public class Phone {
    private String mob;

    @Autowired
    public Phone() {
    }

    @Autowired
    public Phone(String mob) {
        this.mob = mob;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "mob='" + mob + '\'' +
                '}';
    }
}
