//package com.urise.webapp.storage;
//
//import com.urise.webapp.model.Resume;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class MapStorage extends AbstractStorage {
//    Map<String, Resume> resumeMap = new HashMap<>();
//
//    @Override
//    protected void deleteElement(int index) {
//        resumeMap.remove(index);
//    }
//
//
//    @Override
//    protected void insertElement(Resume r, int index) {
//        resumeMap.put(r.getUuid(), r);
//    }
//
//    @Override
//    protected int getSearchKey(String uuid) {
//        if (resumeMap.containsKey(uuid)) {
//            return 1;
//        }
//        return -1;
//    }
//
//    @Override
//    public void clear() {
//        resumeMap.clear();
//    }
//
//    @Override
//    public void update(Resume r) {
//
//    }
//
//    @Override
//    public Resume get(String uuid) {
//        return resumeMap.get(uuid);
//    }
//
//    @Override
//    public void delete(String uuid) {
//        resumeMap.remove(uuid);
//    }
//
//    @Override
//    public Resume[] getAll() {
//        Resume[] resumes;
//        List<Resume> values = new ArrayList<>(resumeMap.values());
//        resumes = values.toArray(new Resume[resumeMap.size()]);
//        return resumes;
//    }
//
//    @Override
//    public int size() {
//        return resumeMap.size();
//    }
//}
