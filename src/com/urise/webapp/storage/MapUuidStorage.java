package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
    Map<String, Resume> resumeMap = new LinkedHashMap<>();

    @Override
    protected void doSave(Resume r, String uuid) {
        resumeMap.put(uuid, r);
    }

    @Override
    protected Resume doGet(String uuid) {
        return resumeMap.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        resumeMap.put(uuid, r);
    }

    @Override
    protected void doDelete(String uuid) {
        resumeMap.remove(uuid);
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
    protected boolean isExist(String uuid) {
        return resumeMap.containsKey(uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }
}
