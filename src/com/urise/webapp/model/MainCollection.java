package com.urise.webapp.model;

import java.util.*;

public class MainCollection {
    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME3 = new Resume(UUID_3);

    public static void main(String[] args) {
        List<Resume> collection = new ArrayList<>();
        collection.add(RESUME1);
        collection.add(RESUME2);
        collection.add(RESUME3);

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume resume = iterator.next();
            System.out.println(resume);
            if (resume.getUuid().equals(UUID_3)) {
                iterator.remove();
            }
        }

/*        for (int i = 0; i < collection.size(); i++) {
            Resume resume = collection.get(i);
            if (resume.getUuid().equals(UUID_2)){
                collection.remove(resume);
            }
        }*/
        System.out.println(collection);

        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, RESUME1);
        map.put(UUID_2, RESUME2);
        map.put(UUID_3, RESUME3);

        //Bad solution
        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }
        //Good solution
        System.out.println("/**********/");
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
