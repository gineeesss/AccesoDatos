package com.dam2.extraescolar.model.dao;

/**
 *
 * @author JAVIER
 */
public class ExceptionDataBase extends Exception {

    final static int DB_VERSION_EXCEPTION = 1;

    public ExceptionDataBase(String msg) {
        super(msg);
    }
}
