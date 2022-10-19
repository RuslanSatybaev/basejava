package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME1 = new Resume(UUID_1, "Name1");
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME2 = new Resume(UUID_2, "Name2");
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME3 = new Resume(UUID_3, "Name3");
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME4 = new Resume(UUID_4, "Name4");
    protected Storage storage;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }


    @Test
    public void save() {
        storage.save(RESUME4);
        assertSize(4);
        assertEquals(RESUME4, storage.get(UUID_4));
    }

    @Test
    public void get() {
        Resume resume = storage.get("uuid1");
        assertEquals("uuid1", resume.getUuid());
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1, "New name");
        storage.update(newResume);
        assertTrue(newResume == storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_3);
        assertSize(2);
        storage.get(UUID_3);
    }

    @Test
    public void getAll() {
        List<Resume> allSorted = storage.getAllSorted();
        assertEquals(3, allSorted.size());
        assertEquals(allSorted, Arrays.asList(RESUME1, RESUME2, RESUME3));
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.get("qwert");
    }


    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("qwert");
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME2);
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}