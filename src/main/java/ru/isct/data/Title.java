package ru.isct.data;

/**
 * Created by ppetrovt on 11.01.2018.
 */
public enum Title {

    MR("Mr."),
    MS("Ms."),
    MRS("Mrs."),
    MX("Mx."),
    DR("Dr."),
    PROF("Prof.");

    private String name;

    Title(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
