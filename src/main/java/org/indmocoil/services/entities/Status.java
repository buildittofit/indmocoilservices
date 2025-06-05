package org.indmocoil.services.entities;

public enum Status {
    DRAFT("Draft"),
    PUBLISH("Publish"),
    ARCHIVE("Archive");

    private String status;

    Status(String status) {
        this.status = status;
    }
}
