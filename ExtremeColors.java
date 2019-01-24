package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Extreme.balls1;
import static com.flyingbrowniegames.ballgame.Variables.currentCharacter;
import static com.flyingbrowniegames.ballgame.Variables.h1;
import static com.flyingbrowniegames.ballgame.Variables.h10;
import static com.flyingbrowniegames.ballgame.Variables.h11;
import static com.flyingbrowniegames.ballgame.Variables.h12;
import static com.flyingbrowniegames.ballgame.Variables.h2;
import static com.flyingbrowniegames.ballgame.Variables.h3;
import static com.flyingbrowniegames.ballgame.Variables.h4;
import static com.flyingbrowniegames.ballgame.Variables.h5;
import static com.flyingbrowniegames.ballgame.Variables.h6;
import static com.flyingbrowniegames.ballgame.Variables.h7;
import static com.flyingbrowniegames.ballgame.Variables.h8;
import static com.flyingbrowniegames.ballgame.Variables.h9;
import static com.flyingbrowniegames.ballgame.Variables.halfheight;
import static com.flyingbrowniegames.ballgame.Variables.halfwidth;
import static com.flyingbrowniegames.ballgame.Variables.screen;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kyle on 2017-02-26.
 */

public class ExtremeColors {

    public static void arc_color(int id, int half) {
        boolean flipped1 = false;
        boolean flipped2 = false;
        boolean flipped3 = false;
        boolean flipped4 = false;
        boolean flipped5 = false;
        boolean flipped6 = false;
        boolean flipped7 = false;
        boolean flipped8 = false;
        boolean flipped9 = false;
        boolean flipped10 = false;
        boolean flipped11 = false;
        boolean flipped12 = false;
        String texture = "";
        Color color = new Color(0, 0, 0, 1);
        switch (id) {
            case 1:
                texture = "redhalf";
                color = new Color(243 / 255f, 34 / 255f, 12 / 255f, 1);
                break;
            case 2:
                texture = "pinkhalf";
                color = new Color(232 / 255f, 29 / 255f, 129 / 255f, 1);
                break;
            case 3:
                texture = "purplehalf";
                color = new Color(200 / 255f, 71 / 255f, 243 / 255f, 1);
                break;
            case 4:
                texture = "cyanhalf";
                color = new Color(39 / 255f, 231 / 255f, 238 / 255f, 1);
                break;
            case 5:
                texture = "bluehalf";
                color = new Color(32 / 255f, 87 / 255f, 245 / 255f, 1);
                break;
            case 6:
                texture = "lgreenhalf";
                color = new Color(79 / 255f, 216 / 255f, 19 / 255f, 1);
                break;
            case 7:
                texture = "dpurplehalf";
                color = new Color(90 / 255f, 13 / 255f, 195 / 255f, 1);
                break;
            case 8:
                texture = "dgreenhalf";
                color = new Color(20 / 255f, 145 / 255f, 7 / 255f, 1);
                break;
            case 9:
                texture = "yellowhalf";
                color = new Color(242 / 255f, 218 / 255f, 16 / 255f, 1);
                break;
            case 10:
                texture = "orangehalf";
                color = new Color(244 / 255f, 167 / 255f, 33 / 255f, 1);
                break;
        }
        if (screen == 18 || screen == 19 || screen == 20) {

            flipped1 = h1.isFlipX();
            flipped2 = h2.isFlipX();
            flipped3 = h3.isFlipX();
            flipped4 = h4.isFlipX();
            if (balls1 > 2) {
                flipped5 = h5.isFlipX();
                flipped6 = h6.isFlipX();
            }
            if (balls1 > 3) {
                flipped7 = h7.isFlipX();
                flipped8 = h8.isFlipX();
            }
            if (balls1 > 4) {
                flipped9 = h9.isFlipX();
                flipped10 = h10.isFlipX();
            }
            if (balls1 == 6) {
                flipped11 = h11.isFlipX();
                flipped12 = h12.isFlipX();
            }

        }


        switch (half) {
            case 1:
                //h1 = new Sprite(sprites.get(texture));
                //h1.setSize(halfwidth, halfheight);
                h1 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h1.setColor(color);
                //h1.scale((((1) * (w)) / ((11) * (h1.getWidth()))) - 1);
                break;
            case 2:
//                h2 = new Sprite(sprites.get(texture));
//                h2.setSize(halfwidth, halfheight);
                h2 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h2.setColor(color);
                //h2.scale((((1) * (w)) / ((11) * (h2.getWidth()))) - 1);
                break;
            case 3:
//                h3 = new Sprite(sprites.get(texture));
//                h3.setSize(halfwidth, halfheight);
                h3 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h3.setColor(color);
                //h3.scale((((1) * (w)) / ((11) * (h3.getWidth()))) - 1);
                break;
            case 4:
//                h4 = new Sprite(sprites.get(texture));
//                h4.setSize(halfwidth, halfheight);
                h4 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h4.setColor(color);
                //h4.scale((((1) * (w)) / ((11) * (h4.getWidth()))) - 1);
                break;
            case 5:
//                h5 = new Sprite(sprites.get(texture));
//                h5.setSize(halfwidth, halfheight);
                h5 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h5.setColor(color);
                //h5.scale((((1) * (w)) / ((11) * (h5.getWidth()))) - 1);
                break;
            case 6:
//                h6 = new Sprite(sprites.get(texture));
//                h6.setSize(halfwidth, halfheight);
                h6 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h6.setColor(color);
                //h6.scale((((1) * (w)) / ((11) * (h6.getWidth()))) - 1);
                break;
            case 7:
//                h7 = new Sprite(sprites.get(texture));
//                h7.setSize(halfwidth, halfheight);
                h7 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h7.setColor(color);
                //h7.scale((((1) * (w)) / ((11) * (h7.getWidth()))) - 1);
                break;
            case 8:
//                h8 = new Sprite(sprites.get(texture));
//                h8.setSize(halfwidth, halfheight);
                h8 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h8.setColor(color);
                //h8.scale((((1) * (w)) / ((11) * (h8.getWidth()))) - 1);
                break;
            case 9:
//                h9 = new Sprite(sprites.get(texture));
//                h9.setSize(halfwidth, halfheight);
                h9 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h9.setColor(color);
                //h9.scale((((1) * (w)) / ((11) * (h9.getWidth()))) - 1);

                break;
            case 10:
//                h10 = new Sprite(sprites.get(texture));
//                h10.setSize(halfwidth, halfheight);
                h10 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h10.setColor(color);
                //h10.scale((((1) * (w)) / ((11) * (h10.getWidth()))) - 1);
                break;
            case 11:
//                h11 = new Sprite(sprites.get(texture));
//                h11.setSize(halfwidth, halfheight);
                h11 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h11.setColor(color);
                //h11.scale((((1) * (w)) / ((11) * (h11.getWidth()))) - 1);
                break;
            case 12:
//                h12 = new Sprite(sprites.get(texture));
//                h12.setSize(halfwidth, halfheight);
                h12 = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                h12.setColor(color);
                //h12.scale((((1) * (w)) / ((11) * (h12.getWidth()))) - 1);

                break;
        }


        if (flipped1 && half == 1) {
            h1.flip(true, false);
        }
        if (flipped2 && half == 2) {
            h2.flip(true, false);
        }
        if (flipped3 && half == 3) {
            h3.flip(true, false);
        }
        if (flipped4 && half == 4) {
            h4.flip(true, false);
        }
        if (flipped5 && half == 5) {
            h5.flip(true, false);
        }
        if (flipped6 && half == 6) {
            h6.flip(true, false);
        }
        if (flipped7 && half == 7) {
            h7.flip(true, false);
        }
        if (flipped8 && half == 8) {
            h8.flip(true, false);
        }
        if (flipped9 && half == 9) {
            h9.flip(true, false);
        }
        if (flipped10 && half == 10) {
            h10.flip(true, false);
        }
        if (flipped11 && half == 11) {
            h11.flip(true, false);
        }
        if (flipped12 && half == 12) {
            h12.flip(true, false);
        }

    }
}
