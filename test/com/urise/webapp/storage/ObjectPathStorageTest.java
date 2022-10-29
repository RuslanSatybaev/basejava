package com.urise.webapp.storage;

public class ObjectPathStorageTest extends AbstractStorageTest {

    public ObjectPathStorageTest() {
        super(new ObjectPathStorage(PATHNAME));
    }
}