package com.eduardoprogramador.common;

/*
* Copyright 2021. Eduardo Programador
*
* This library contains some routines for basic tasks
* and good methods for string validation,
* and it can be initiated with a basic constructor.
*
* All rights reserved.
*
* */

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Jobs {

    /*
    * This method makes string validation.
    * You must provide the following params:
    *
    * minWidth: the minimum length acceptable from a form.
    * maxWidth: the maximum length acceptable from a form.
    * allowedChars: A string contains the acceptable characters to validate. Eg. "abcdef"
    * str: The string to be tested.
    *
    * If the string testes satisfy the validation,
    * the method returns true; false, otherwise.
    * */
    public static boolean limitChars(int minWidth, int maxWidth, String allowedChars, String str) {

        boolean goOn = false;

        allowedChars = allowedChars.toLowerCase();
        str = str.toLowerCase();

        int strSize = str.length();
        if(strSize < minWidth || strSize > maxWidth) {
            return false;
        } else {

            for (int i = 0; i < str.length(); i++) {

                char c = str.charAt(i); //e

                for (int j = 0; j < allowedChars.length(); j++) {

                    char z = allowedChars.charAt(j); //b
                    goOn = (c == z);
                    if(goOn)
                        break;
                }

            }

            return goOn;
        }
    }


    /*
    * Prompts the user with a Information Dialog with customized contents.
    * */
    public static void displayDialog(String title,String header,String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,content, ButtonType.CLOSE);
        alert.setContentText(content);
        alert.setHeaderText(header);
        alert.setTitle(title);
        alert.show();
    }

    /*
    * Returns the path ofthe file that the user has be chosen to save some archive.
    * The methods works only with JavaFX.
    *
    * Params:
    *
    * stage: the current window wurring the JavaFX Thread.
    * title: the title of the dialog box window
    * description: the description shown to the user.
    * formats: A list of string containing the file extensions accepted: Eg: new String[]{*.pdf,*.exe}
    * */
    public static String getFile(Stage stage, String title, String description, String[] formats) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(description,formats);
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showSaveDialog(stage);
        if(file != null)
            return file.getPath();
        else
            return "";
    }
}
