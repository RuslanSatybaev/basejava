package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        resumeList.add(r);
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return resumeList.get(searchKey);
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        resumeList.set(searchKey, r);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        resumeList.remove((searchKey).intValue());
    }

    @Override
    public void clear() {
        resumeList.clear();
    }

    @Override
    public int size() {
        return resumeList.size();
    }

    @Override
    protected List<Resume> doCopyAll() {
        return resumeList;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (resumeList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}
