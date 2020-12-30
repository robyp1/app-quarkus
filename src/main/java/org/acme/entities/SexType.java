package org.acme.entities;

public enum SexType {
    M("Maschio"),
    F("Femmina");

    private final String type;

    SexType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
