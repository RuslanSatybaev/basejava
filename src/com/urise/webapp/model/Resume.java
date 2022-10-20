package com.urise.webapp.model;

/**
 * Initial resume class
 */
public class Resume {

    private final NameUuid nameUuid;

    public Resume(String uuid1, String name1) {
        this.nameUuid = new NameUuid(uuid1, name1);
    }

    public Resume(String name) {
        this.nameUuid = new NameUuid(name);
    }

    public String getUuid() {
        return nameUuid.getUuid();
    }
}
