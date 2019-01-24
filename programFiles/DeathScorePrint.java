package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.flyingbrowniegames.ballgame.BallGame.drawSprite;
import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.bestWidth;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kyle on 2017-01-23.
 */

public class DeathScorePrint {
    public static Sprite number1;
    public static Sprite number2;
    public static Sprite number3;
    public static Sprite number4;
    public static Sprite number5;
    public static Sprite number6;
    public static Sprite number7;
    public static Sprite number8;
    public static boolean dloop = true;

    public static void print(String s) { //highscore reach
        if (dloop == true) {
            switch (s.length()) {
                case 1:
                    number1 = sprites.get((Numbers.dprint(s.substring(0, 1))));
                    number1.setSize(w / 17, h / 25);
                    break;
                case 2:
                    number1 = sprites.get((Numbers.dprint(s.substring(0, 1))));
                    number2 = sprites.get((Numbers.dprint(s.substring(1))));
                    number1.setSize(w / 17, h / 25);
                    number2.setSize(w / 17, h / 25);
                    break;
                case 3:
                    number1 = sprites.get((Numbers.dprint(s.substring(0, 1))));
                    number2 = sprites.get((Numbers.dprint(s.substring(1, 2))));
                    number3 = sprites.get((Numbers.dprint(s.substring(2, 3))));
                    number1.setSize(w / 17, h / 25);
                    number2.setSize(w / 17, h / 25);
                    number3.setSize(w / 17, h / 25);
                    break;
                case 4:
                    number1 = sprites.get((Numbers.dprint(s.substring(0, 1))));
                    number2 = sprites.get((Numbers.dprint(s.substring(1, 2))));
                    number3 = sprites.get((Numbers.dprint(s.substring(2, 3))));
                    number4 = sprites.get((Numbers.dprint(s.substring(3, 4))));
                    number1.setSize(w / 17, h / 25);
                    number2.setSize(w / 17, h / 25);
                    number3.setSize(w / 17, h / 25);
                    number4.setSize(w / 17, h / 25);
                    break;
            }
            dloop = false;
        }
        switch (s.length()) {
            case 1:
                number1.setCenter(w / 2, (h * 7) / 10);
                number1.draw(batch);
                break;
            case 2:
                number1.setCenter((w / 2) - (w / 34), (h * 7) / 10);
                number1.draw(batch);
                number2.setCenter((w / 2) + (w / 34), (h * 7) / 10);
                number2.draw(batch);
                break;
            case 3:
                number1.setCenter((w / 2) - (w / 17), (h * 7) / 10);
                number1.draw(batch);
                number2.setCenter(w / 2, (h * 7) / 10);
                number2.draw(batch);
                number3.setCenter((w / 2) + (w / 17), (h * 7) / 10);
                number3.draw(batch);
                break;
            case 4:
                number1.setCenter((w / 2) - ((3 * (w / 17)) / 2), (h * 7) / 10);
                number1.draw(batch);
                number2.setCenter((w / 2) - (w / 34), (h * 7) / 10);
                number2.draw(batch);
                number3.setCenter((w / 2) + (w / 34), (h * 7) / 10);
                number3.draw(batch);
                number4.setCenter((w / 2) + ((3 * (w / 17)) / 2), (h * 7) / 10);
                number4.draw(batch);
                break;
        }
    }

    public static void print2(String s, String b) { //highscore not reached
        bestWidth = sprites.get("best").getBoundingRectangle().getWidth();
        if (dloop == true) {
            switch (s.length()) {
                case 1:
                    number1 = sprites.get(Numbers.dprint(s.substring(0, 1)));
                    number1.setSize(w / 13, h / 20);
                    break;
                case 2:
                    number1 = sprites.get(Numbers.dprint(s.substring(0, 1)));
                    number2 = sprites.get(Numbers.dprint(s.substring(1)));
                    number1.setSize(w / 13, h / 20);
                    number2.setSize(w / 13, h / 20);
                    break;
                case 3:
                    number1 = sprites.get(Numbers.dprint(s.substring(0, 1)));
                    number2 = sprites.get(Numbers.dprint(s.substring(1, 2)));
                    number3 = sprites.get(Numbers.dprint(s.substring(2, 3)));
                    number1.setSize(w / 13, h / 20);
                    number2.setSize(w / 13, h / 20);
                    number3.setSize(w / 13, h / 20);
                    break;
                case 4:
                    number1 = sprites.get(Numbers.dprint(s.substring(0, 1)));
                    number2 = sprites.get(Numbers.dprint(s.substring(1, 2)));
                    number3 = sprites.get(Numbers.dprint(s.substring(2, 3)));
                    number4 = sprites.get(Numbers.dprint(s.substring(3, 4)));
                    number1.setSize(w / 13, h / 20);
                    number2.setSize(w / 13, h / 20);
                    number3.setSize(w / 13, h / 20);
                    number4.setSize(w / 13, h / 20);
                    break;
            }
            switch (b.length()) {
                case 1:
                    number5 = sprites.get(Numbers.dprint(b.substring(0, 1)));
                    number5.setSize(w / 17, h / 25);
                    break;
                case 2:
                    number5 = sprites.get(Numbers.dprint(b.substring(0, 1)));
                    number6 = sprites.get(Numbers.dprint(b.substring(1)));
                    number5.setSize(w / 17, h / 25);
                    number6.setSize(w / 17, h / 25);
                    break;
                case 3:
                    number5 = sprites.get(Numbers.dprint(b.substring(0, 1)));
                    number6 = sprites.get(Numbers.dprint(b.substring(1, 2)));
                    number7 = sprites.get(Numbers.dprint(b.substring(2, 3)));
                    number5.setSize(w / 17, h / 25);
                    number6.setSize(w / 17, h / 25);
                    number7.setSize(w / 17, h / 25);
                    break;
                case 4:
                    number5 = sprites.get(Numbers.dprint(b.substring(0, 1)));
                    number6 = sprites.get(Numbers.dprint(b.substring(1, 2)));
                    number7 = sprites.get(Numbers.dprint(b.substring(2, 3)));
                    number8 = sprites.get(Numbers.dprint(b.substring(3, 4)));
                    number5.setSize(w / 17, h / 25);
                    number6.setSize(w / 17, h / 25);
                    number7.setSize(w / 17, h / 25);
                    number8.setSize(w / 17, h / 25);
                    break;
            }
            dloop = false;
        }
        switch (s.length()) {
            case 1:
                number1.setCenter(w / 2, (h * 7) / 10);
                number1.draw(batch);
                break;
            case 2:
                number1.setCenter((w / 2) - (w / 26), (h * 7) / 10);
                number1.draw(batch);
                number2.setCenter((w / 2) + (w / 26), (h * 7) / 10);
                number2.draw(batch);
                break;
            case 3:
                number1.setCenter((w / 2) - (w / 13), (h * 7) / 10);
                number1.draw(batch);
                number2.setCenter(w / 2, (h * 7) / 10);
                number2.draw(batch);
                number3.setCenter((w / 2) + (w / 13), (h * 7) / 10);
                number3.draw(batch);
                break;
            case 4:
                number1.setCenter((w / 2) - ((3 * (w / 13)) / 2), (h * 7) / 10);
                number1.draw(batch);
                number2.setCenter((w / 2) - (w / 26), (h * 7) / 10);
                number2.draw(batch);
                number3.setCenter((w / 2) + (w / 26), (h * 7) / 10);
                number3.draw(batch);
                number4.setCenter((w / 2) + ((3 * (w / 13)) / 2), (h * 7) / 10);
                number4.draw(batch);
                break;
        }
        switch (b.length()) {
            case 1:
                number5.setCenter(w / 2 + (w / 34) + (bestWidth / 2), (h * 6) / 10);
                number5.draw(batch);
                //drawSprite("best", Variables.w / 2 - (w / 34), (h * 6) / 10);
                Variables.sprite8.setCenter(Variables.w / 2 - (w / 34), (h * 6) / 10);
                Variables.sprite8.draw(Variables.batch);
                break;
            case 2:
                number5.setCenter((w / 2) + (bestWidth / 2) - (w / 34), (h * 6) / 10);
                number5.draw(batch);
                number6.setCenter((w / 2) + (bestWidth / 2) + (w / 34), (h * 6) / 10);
                number6.draw(batch);
                //drawSprite("best", Variables.w / 2 - (w / 17), (h * 6) / 10);
                Variables.sprite8.setCenter(Variables.w / 2 - (w / 17), (h * 6) / 10);
                Variables.sprite8.draw(Variables.batch);
                break;
            case 3:
                number5.setCenter((w / 2) + (bestWidth / 2), (h * 6) / 10);
                number5.draw(batch);
                number6.setCenter(w / 2 + (bestWidth / 2) + (w / 17), (h * 6) / 10);
                number6.draw(batch);
                number7.setCenter((w / 2) + (bestWidth / 2) + (w / 17) + (w / 17), (h * 6) / 10);
                number7.draw(batch);
                //drawSprite("best", Variables.w / 2 - ((3 * (w / 34))), (h * 6) / 10);
                Variables.sprite8.setCenter(Variables.w / 2 - ((3 * (w / 34))), (h * 6) / 10);
                Variables.sprite8.draw(Variables.batch);
                break;
            case 4:
                number5.setCenter((w / 2) + (bestWidth / 2) - (w / 34), (h * 6) / 10);
                number5.draw(batch);
                number6.setCenter((w / 2) + (bestWidth / 2) + (w / 34), (h * 6) / 10);
                number6.draw(batch);
                number7.setCenter((w / 2) + (w / 17) + (bestWidth / 2) + (w / 34), (h * 6) / 10);
                number7.draw(batch);
                number8.setCenter((w / 2) + (2 * (w / 17)) + (bestWidth / 2) + (w / 34), (h * 6) / 10);
                number8.draw(batch);
                //drawSprite("best", Variables.w / 2 - (2 * (w / 17)), (h * 6) / 10);
                Variables.sprite8.setCenter(Variables.w / 2 - (2 * (w / 17)), (h * 6) / 10);
                Variables.sprite8.draw(Variables.batch);
                break;
        }
    }
}
