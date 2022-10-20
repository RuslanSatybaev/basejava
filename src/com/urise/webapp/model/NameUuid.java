package com.urise.webapp.model;

import java.util.Objects;
import java.util.UUID;

public class NameUuid implements Comparable<NameUuid>  {
    
    private final String fullName;

    // Unique identifier
    private final String uuid;

    public NameUuid(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public NameUuid(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String setFullName(String name) {
        return name;
    }



    @Override
    public String toString() {
        return "NameUuid{" +
                "fullName='" + fullName + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameUuid nameUuid = (NameUuid) o;

        if (!fullName.equals(nameUuid.fullName)) return false;
        return uuid.equals(nameUuid.uuid);
    }

    @Override
    public int hashCode() {
        int result = fullName.hashCode();
        result = 31 * result + uuid.hashCode();
        return result;
    }

    @Override
    public int compareTo(NameUuid o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }
}
