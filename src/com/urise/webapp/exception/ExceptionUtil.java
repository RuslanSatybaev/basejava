package com.urise.webapp.exception;

import org.postgresql.util.PSQLException;

import java.sql.SQLException;

public class ExceptionUtil extends RuntimeException {
    private ExceptionUtil(Exception e) {
    }

    public static ExistStorageException convertException(SQLException e) {
        if (e instanceof PSQLException) {
            if (e.getSQLState().equals("23505")) {
                return new ExistStorageException(null);
            }
        }
        throw new StorageException(e);
    }
}
