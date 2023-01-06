package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                ListStorageTest.class,
                MapResumeStorageTest.class,
                MapUuidStorageTest.class,
                ObjectFileStorageTest.class,

                SortedArrayStorageTest.class,
                XMLPathStorageTest.class
        }
)
public class AllStorageTest {
}
