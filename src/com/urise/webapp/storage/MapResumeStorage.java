package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    Map<String, Resume> resumeMap = new LinkedHashMap<>();

    @Override
    protected void doSave(Resume r, Resume resume) {
        resumeMap.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        resumeMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Resume resume) {
        resumeMap.remove((resume).getUuid());
    }

    @Override
    public void clear() {
        resumeMap.clear();
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(resumeMap.values());
    }

    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return resumeMap.get(uuid);
    }
}
