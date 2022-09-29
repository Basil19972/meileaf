package com.example.jwt.core.security.config;

public enum Roles {
    USER("a05d3a73-5f6a-4cb3-ac13-a493163515a4"),
    ADMIN("8383b369-3f33-4b39-97dd-ddf172b39e45"),
    DEV("4d0f7301-c123-4189-9636-066531275bf4");

    private String uuid;

    Roles(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
