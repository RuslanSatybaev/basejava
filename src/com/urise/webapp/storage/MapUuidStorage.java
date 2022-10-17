package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {
    Map<String, Resume> resumeMap = new LinkedHashMap<>();
    List<String> keyList = new ArrayList<>();


    @Override
    protected void doSave(Resume r, Object searchKey) {
        resumeMap.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        for (Map.Entry<String, Resume> entry : resumeMap.entrySet()) {
            String key = entry.getKey();
            String s = keyList.get((Integer) searchKey);
            if (key.equals(s)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        resumeMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        for (Map.Entry<String, Resume> entry : resumeMap.entrySet()) {
            String key = entry.getKey();
            String s = keyList.get((Integer) searchKey);
            if (key.equals(s)) {
                resumeMap.remove(key);
            }
        }
    }

    @Override
    public void clear() {
        resumeMap.clear();
    }


    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>(resumeMap.values());
        return list;
    }

    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (Map.Entry<String, Resume> entry : resumeMap.entrySet()) {
            String key = entry.getKey();
            if (key.equals(uuid)) {
                keyList.add(key);
                return keyList.indexOf(uuid);
            }
        }
        return null;
    }
}
