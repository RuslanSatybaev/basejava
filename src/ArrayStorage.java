import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10];
    Resume car = new Resume();
    int size = 0;
    int index = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        storage[index] = r;
        index++;
        size++;
    }

    Resume get(String uuid) {
        for (Resume value : storage) {
            if (value != null && value.uuid.equals(uuid)) {
                car = value;
                break;
            } else {
                car = null;
            }
        }
        return car;
    }

    void delete(String uuid) {
        for (Resume value : storage) {
            if (value.uuid.equals(uuid)) {
                index = findIndex(value);
                storage[index] = null;
                break;
            }
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        int size = 0;
        for (Resume s : ArrayStorage.this.storage) {
            if (s != null) {
                resumes[size] = s;
                size++;
            }
        }
        return resumes;
    }

    int size() {
        return size;
    }

    private int findIndex(Resume car) {
        int index = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(car)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
