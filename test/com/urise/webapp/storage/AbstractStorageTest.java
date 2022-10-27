package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

    protected static final File STORAGE_DIR = new File("C:\\Users\\Руслан\\OneDrive\\" +
            "online_course\\javaops\\projects\\basejava\\io_storage");

    private static final String UUID_1 = "uuid1";
    private static final Resume R1;
    private static final String UUID_2 = "uuid2";
    private static final Resume R2;
    private static final String UUID_3 = "uuid3";
    private static final Resume R3;
    private static final String UUID_4 = "uuid4";
    private static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.addContacts(ContactType.MAIL,"mail1@ya.ru");
        R1.addContacts(ContactType.PHONE,"1111");

        R1.addSections(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSections(SectionType.PERSONAL, new TextSection("Personal data"));
        R1.addSections(SectionType.ACHIEVEMENT, new ListSection("Achievement11", "Achievement12", "Achievement13"));
        R1.addSections(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL","JavaScript"));
        R1.addSections(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organizations","http:Organization11.ru",
                                new Organization.Position(2005, Month.JANUARY,"position2","content2"))));
    }

    protected Storage storage;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void save() {
        storage.save(R4);
        assertSize(4);
        assertEquals(R4, storage.get(UUID_4));
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
        assertEquals(newResume, storage.get(UUID_1));
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
        assertEquals(allSorted, Arrays.asList(R1, R2, R3));
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
        storage.save(R2);
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}