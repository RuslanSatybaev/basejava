package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public interface Storage {

    void clear();

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    default Resume[] getAll() {
        int STORAGE_LIMIT = 20;
        Resume[] storage = new Resume[STORAGE_LIMIT];
        int size = 0;
        return Arrays.copyOfRange(storage, 0, size);
    }

    List<Resume> getAllSorted(); // sorted by fullName

    int size();
}
