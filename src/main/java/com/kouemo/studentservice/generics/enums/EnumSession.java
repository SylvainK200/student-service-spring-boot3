package com.kouemo.studentservice.generics.enums;


public enum EnumSession {
    CONTINUOUS_CONTROL("CONTINUOUS_CONTROL","Continuous control examination"),
    EXAM("EXAM","Principal Exmamination"),
    PROJECT("PROJECT","Project of the course"),
    RATTRAPING("RATTRAPING", "Rattraping when the final rating is not good");
    private String key;
    private String description;

    EnumSession(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }
}
