package com.eduardoprogramador.common;

/*
* Copyright 2021. Eduardo Programador
*
* This class contains methods
* for read from and write to file,
* providing easy interfaces that the user
* must implement to handle the process of the job.
* The class can be initiated with a default constructor.
*
* All rights reserved.
*
* */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class InOut {
    /*
    * Internal variable that controls the end of the job.
    * */
    private boolean stop;

    /*
    * Read the contents of a File,
    * providing an interface that the end user must implement.
    *
    * Params:
    *
    * path: The full path of the file.
    * parser: An interface that will hold the contents of the file (line by line)
    * */
    public void readFromPath(String path, Parser parser) throws EngineFailHandler {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if(!stop)
                    parser.contentsOfFile(line);
                else
                    break;
            }

            bufferedReader.close();
            fileInputStream.close();

        } catch (Exception ex) {
            throw new EngineFailHandler("Problems with opening the file");
        }
    }

    /*
    * Stops the read process
    * */
    public void noMoreRead() {
        stop = true;
    }

    /*
    * Write contents to a file.
    *
    * Params:
    *
    * path: the full path of the file.
    * content: A string that will be merge onto the file.
    *
    * Note: If the path given by the user doest not exist,
    * a new file will be created.
    * */
    public void writeToPath(String path, String content) throws EngineFailHandler {
        try {
            File file = new File(path);
            if(!file.exists())
                file.createNewFile();

            Files.write(Paths.get(path),content.getBytes(), StandardOpenOption.APPEND);

        } catch (Exception ex) {
            throw new EngineFailHandler("Problems with writing to the file");
        }
    }

    /*
    * An interface that handles the reading process
    * from a given file.
    * The method of this interface
    * contains a string in its param
    * containing the current line of the file.
    * */
    public static interface Parser {
        public void contentsOfFile(String line);
    }

}
