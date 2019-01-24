package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kyle on 2017-07-21.
 */

public class readFiles {

    public static ArrayList<String> readTextFile(String file) {
        //FileHandle handle = Gdx.files.internal(file);
        ArrayList<String> temp = new ArrayList<String>();
        try {
            FileHandle handle = Gdx.files.internal(file);
            System.out.println(handle.read().available());
            while(handle.read().available() == 1){
                temp.add(handle.readString());
            }
            //Scanner scanner = new Scanner(handle);
           // while ((scanner.hasNextLine())) {
              //  temp.add(scanner.nextLine());
            //}
            //scanner.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return temp;
    }
}
