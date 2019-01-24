package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.prefs_score;
import static com.flyingbrowniegames.ballgame.Variables.prefs_score2;
import static com.flyingbrowniegames.ballgame.Variables.prefs_score3;
import static com.flyingbrowniegames.ballgame.Variables.prefs_score4;
import static com.flyingbrowniegames.ballgame.Variables.prefs_score5;
import static com.flyingbrowniegames.ballgame.Variables.prefs_score7;
import static com.flyingbrowniegames.ballgame.Variables.w;
import static com.flyingbrowniegames.ballgame.Variables.yloop;

/**
 * Created by kyle on 2017-01-21.
 */

public class ModeScorePrint {
    private static Sprite number1;
    private static Sprite number2;
    private static Sprite number3;
    private static Sprite number4;
    private static Sprite number5;
    private static Sprite number6;
    private static Sprite number7;
    private static Sprite number8;
    private static Sprite number9;
    private static Sprite number10;
    private static Sprite number11;
    private static Sprite number12;
    private static Sprite number13;
    private static Sprite number14;
    private static Sprite number15;
    private static Sprite number16;
    private static Sprite number17;
    private static Sprite number18;
    private static Sprite number19;
    private static Sprite number20;
    public static ArrayList<String> scores = new ArrayList<String>();


    public static void print() {
        if (!yloop) {
            ModeScorePrint.scores.clear();
            SetArray(String.valueOf(prefs_score.getInteger("score")), 3);   //classic
            SetArray(String.valueOf(prefs_score2.getInteger("score")), 3);   //mirror
            SetArray(String.valueOf(prefs_score3.getInteger("score")), 3);   //blind
            SetArray(String.valueOf(prefs_score4.getInteger("score")), 3);   //burst
            SetArray(String.valueOf(prefs_score5.getInteger("score")), 4);   //double
            SetArray(String.valueOf(prefs_score7.getInteger("score")), 4);   //extremeflip
            number1 = new Sprite(sprites.get(Numbers.yprint(scores.get(0))));
            number2 = new Sprite(sprites.get(Numbers.yprint(scores.get(1))));
            number3 = new Sprite(sprites.get(Numbers.yprint(scores.get(2))));
            number4 = new Sprite(sprites.get(Numbers.yprint(scores.get(3))));
            number5 = new Sprite(sprites.get(Numbers.yprint(scores.get(4))));
            number6 = new Sprite(sprites.get(Numbers.yprint(scores.get(5))));
            number7 = new Sprite(sprites.get(Numbers.yprint(scores.get(6))));
            number8 = new Sprite(sprites.get(Numbers.yprint(scores.get(7))));
            number9 = new Sprite(sprites.get(Numbers.yprint(scores.get(8))));
            number10 = new Sprite(sprites.get(Numbers.yprint(scores.get(9))));
            number11 = new Sprite(sprites.get(Numbers.yprint(scores.get(10))));
            number12 = new Sprite(sprites.get(Numbers.yprint(scores.get(11))));
            number13 = sprites.get(Numbers.yprint(scores.get(12)));
            number14 = sprites.get(Numbers.yprint(scores.get(13)));
            number15 = sprites.get(Numbers.yprint(scores.get(14)));
            number16 = sprites.get(Numbers.yprint(scores.get(15)));
            number17 = sprites.get(Numbers.yprint(scores.get(16)));
            number18 = sprites.get(Numbers.yprint(scores.get(17)));
            number19 = sprites.get(Numbers.yprint(scores.get(18)));
            number20 = sprites.get(Numbers.yprint(scores.get(19)));
            number1.setSize(w / 11, h / 19);
            number2.setSize(w / 11, h / 19);
            number3.setSize(w / 11, h / 19);
            number4.setSize(w / 11, h / 19);
            number5.setSize(w / 11, h / 19);
            number6.setSize(w / 11, h / 19);
            number7.setSize(w / 11, h / 19);
            number8.setSize(w / 11, h / 19);
            number9.setSize(w / 11, h / 19);
            number10.setSize(w / 11, h / 19);
            number11.setSize(w / 11, h / 19);
            number12.setSize(w / 11, h / 19);
            number13.setSize((w * 11) / 168, h / 20);
            number14.setSize((w * 11) / 168, h / 20);
            number15.setSize((w * 11) / 168, h / 20);
            number16.setSize((w * 11) / 168, h / 20);
            number17.setSize((w * 11) / 168, h / 20);
            number18.setSize((w * 11) / 168, h / 20);
            number19.setSize((w * 11) / 168, h / 20);
            number20.setSize((w * 11) / 168, h / 20);
            yloop = true;
        } else {

        }

        number1.setCenter((w * 4) / 5 - ((w * 16) / 168), Variables.h / 2 + (8 * Variables.h / 24) - Variables.deltaY);
        number1.draw(batch);
        number2.setCenter((w * 4) / 5, Variables.h / 2 + (8 * Variables.h / 24) - Variables.deltaY);
        number2.draw(batch);
        number3.setCenter((w * 4) / 5 + ((w * 16) / 168), Variables.h / 2 + (8 * Variables.h / 24) - Variables.deltaY);
        number3.draw(batch);
        number4.setCenter((w * 4) / 5 - ((w * 16) / 168), Variables.h / 2 + (2 * Variables.h / 24) - Variables.deltaY);
        number4.draw(batch);
        number5.setCenter((w * 4) / 5, Variables.h / 2 + (2 * Variables.h / 24) - Variables.deltaY);
        number5.draw(batch);
        number6.setCenter((w * 4) / 5 + ((w * 16) / 168), Variables.h / 2 + (2 * Variables.h / 24) - Variables.deltaY);
        number6.draw(batch);
        number7.setCenter((w * 4) / 5 - ((w * 16) / 168), Variables.h / 2 - (4 * Variables.h / 24) - Variables.deltaY);
        number7.draw(batch);
        number8.setCenter((w * 4) / 5, Variables.h / 2 - (4 * Variables.h / 24) - Variables.deltaY);
        number8.draw(batch);
        number9.setCenter((w * 4) / 5 + ((w * 16) / 168), Variables.h / 2 - (4 * Variables.h / 24) - Variables.deltaY);
        number9.draw(batch);
        number10.setCenter((w * 4) / 5 - ((w * 16) / 168), Variables.h / 2 - (10 * Variables.h / 24) - Variables.deltaY);
        number10.draw(batch);
        number11.setCenter((w * 4) / 5, Variables.h / 2 - (10 * Variables.h / 24) - Variables.deltaY);
        number11.draw(batch);
        number12.setCenter((w * 4) / 5 + ((w * 16) / 168), Variables.h / 2 - (10 * Variables.h / 24) - Variables.deltaY);
        number12.draw(batch);
        number13.setCenter((w * 4) / 5 - (((w * 11) / 336)) - ((w * 11) / 168), Variables.h / 2 - (16 * Variables.h / 24) - Variables.deltaY);
        number13.draw(batch);
        number14.setCenter((w * 4) / 5 - (((w * 11) / 336)), Variables.h / 2 - (16 * Variables.h / 24) - Variables.deltaY);
        number14.draw(batch);
        number15.setCenter((w * 4) / 5 + (((w * 11) / 336)), Variables.h / 2 - (16 * Variables.h / 24) - Variables.deltaY);
        number15.draw(batch);
        number16.setCenter((w * 4) / 5 + (((w * 11) / 336)) + ((w * 11) / 168), Variables.h / 2 - (16 * Variables.h / 24) - Variables.deltaY);
        number16.draw(batch);
        number17.setCenter((w * 4) / 5 - (((w * 11) / 336)) - ((w * 11) / 168), Variables.h / 2 - (28 * Variables.h / 24) - Variables.deltaY);
        number17.draw(batch);
        number18.setCenter((w * 4) / 5 - (((w * 11) / 336)), Variables.h / 2 - (28 * Variables.h / 24) - Variables.deltaY);
        number18.draw(batch);
        number19.setCenter((w * 4) / 5 + (((w * 11) / 336)), Variables.h / 2 - (28 * Variables.h / 24) - Variables.deltaY);
        number19.draw(batch);
        number20.setCenter((w * 4) / 5 + (((w * 11) / 336)) + ((w * 11) / 168), Variables.h / 2 - (28 * Variables.h / 24) - Variables.deltaY);
        number20.draw(batch);

    }

    public static void SetArray(String s, int l) {

        int length = s.length();
        if (length == l) {

        } else {
            addzeros(l - length);
        }
        for (int i = 0; i < s.length(); i++) {
            scores.add(s.substring(i, i + 1));
        }
    }

    public static void addzeros(int z) {
        for (int i = 0; i < z; i++) {
            scores.add("0");
        }
    }
}
