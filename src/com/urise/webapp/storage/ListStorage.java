package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> resumeList = new ArrayList<>();

    @Override
    public void clear() {
        resumeList.clear();
        size = 0;
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            return null;
        }
        return resumeList.get(index);
    }

    @Override
    public Resume[] getAll() {
        return resumeList.toArray(new Resume[size]);
    }

    @Override
    protected void deleteElement(int index) {
        resumeList.remove(index);
    }

    @Override
    protected void insertElement(Resume r, int index) {
        resumeList.add(r);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume resume = findResume(uuid, resumeList);
        return resumeList.indexOf(resume);
    }

    private static Resume findResume(String uuid, List<Resume> ResumeList) {
        for (Resume resume : ResumeList) {
            if (resume.getUuid().equals(uuid)) {
                return resume;
            }
        }
        return null;
    }
}
