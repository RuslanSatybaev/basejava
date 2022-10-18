package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    public static final int STORAGE_LIMIT = 20;
    public Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void insertElement(Resume r, int index);

    protected abstract Integer getSearchKey(String uuid);

    protected abstract void fillDeletedElement(Integer index);

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Resume r, Integer index) {
        storage[index] = r;
    }

    @Override
    protected boolean isExist(Integer index) {
        return (index) >= 0;
    }

    @Override
    protected void doDelete(Integer index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume doGet(Integer index) {
        return storage[(index)];
    }

    @Override
    protected void doSave(Resume r, Integer index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, index);
            size++;
        }
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getSearchKey(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }
}