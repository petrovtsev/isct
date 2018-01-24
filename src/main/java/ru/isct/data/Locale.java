package ru.isct.data;

/**
 * Created by ppetrovt on 21.01.2018.
 */
public enum Locale {

    RU("ru"),
    EN("en");

    private String name;

    Locale(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
