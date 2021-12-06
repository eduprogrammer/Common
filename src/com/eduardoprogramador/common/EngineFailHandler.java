package com.eduardoprogramador.common;

/*
* Copyright 2021. Eduardo Programador
*
* This class handles some exceptions
* that may be occurred in a job.
*
* All rights reserved.
*
* */

public class EngineFailHandler extends Exception {

    /*
    * Throws an exception with an warning message
    * that can be handled at the console side.
    * */
    public EngineFailHandler(String msg) {
        super(msg);
    }

}
