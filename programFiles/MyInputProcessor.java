package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.Clasiclogo;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.mainscoreloop;
import static com.flyingbrowniegames.ballgame.Variables.modeScreenTime;
import static com.flyingbrowniegames.ballgame.Variables.openAchievement;
import static com.flyingbrowniegames.ballgame.Variables.openShop;
import static com.flyingbrowniegames.ballgame.Variables.openStore;
import static com.flyingbrowniegames.ballgame.Variables.paused;
import static com.flyingbrowniegames.ballgame.Variables.pausetime;
import static com.flyingbrowniegames.ballgame.Variables.screen;
import static com.flyingbrowniegames.ballgame.Variables.screenLoop;
import static com.flyingbrowniegames.ballgame.Variables.w;
import static com.flyingbrowniegames.ballgame.Variables.y;

/**
 * Created by kwisk_000 on 2016-10-02.
 */
public class MyInputProcessor implements InputProcessor {
    public static ArrayList<Integer> extremetouches = new ArrayList<Integer>();
    public static boolean first = false;
    public static boolean second = false;
    public static boolean third = false;
    public static boolean fourth = false;
    public static boolean fifth = false;
    public static boolean sixth = false;
    public static boolean upper = false;
    public static boolean lower = false;
    public static boolean left = false;
    public static boolean right = false;


    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.BACK) {
            if (openAchievement) {
                openAchievement = false;
                return false;
            }
            if (openStore) {
                openStore = false;
                return false;
            }
            if (openShop) {
                openShop = false;
                return false;
            }
            if (Variables.screen == 1 || Variables.screen == 0) {
                Gdx.app.exit();

            } else if (Variables.screen == 2 || (screen >= 15 && screen <= 21)) {
                if (Variables.paused == true) {
                    paused = false;
                    pausetime = System.currentTimeMillis();
                } else {
                    Variables.paused = true;
                }
            } else if (screen == 19) {
                Variables.screen = 22;
                screenLoop = 0;
            } else if (Variables.screen == 6 || screen == 7 || screen == 23) {
                Variables.screen = 1;
                screenLoop = 0;
                mainscoreloop = 0;
            } else if (Variables.screen == 25 && Variables.paused == false) {
                switch (Variables.mode) {
                    case 1:
                        Variables.screen = 24;
                        screenLoop = 0;
                        break;
                    case 2:
                        Variables.screen = 8;
                        screenLoop = 0;
                        break;
                    case 3:
                        Variables.screen = 9;
                        screenLoop = 0;
                        break;
                    case 4:
                        Variables.screen = 10;
                        screenLoop = 0;
                        break;
                    case 5:
                        Variables.screen = 11;
                        screenLoop = 0;
                        break;
                    case 6:
                        Variables.screen = 12;
                        screenLoop = 0;
                        break;
                    case 7:
                        Variables.screen = 13;
                        screenLoop = 0;
                        break;
                    case 8:
                        Variables.screen = 14;
                        screenLoop = 0;
                        break;
                }
            } else if (Variables.screen == 25 && Variables.paused == true) {
                switch (Variables.mode) {
                    case 1:
                        Variables.screen = 2;
                        screenLoop = 0;
                        break;
                    case 2:
                        Variables.screen = 15;
                        screenLoop = 0;
                        break;
                    case 3:
                        Variables.screen = 16;
                        screenLoop = 0;
                        break;
                    case 4:
                        Variables.screen = 17;
                        screenLoop = 0;
                        break;
                    case 5:
                        Variables.screen = 18;
                        screenLoop = 0;
                        break;
                    case 6:
                        Variables.screen = 19;
                        screenLoop = 0;
                        break;
                    case 7:
                        Variables.screen = 20;
                        screenLoop = 0;
                        break;
                    case 8:
                        Variables.screen = 21;
                        screenLoop = 0;
                        break;
                }
            } else if (Variables.screen == 27) {
                Variables.screen = 1;
            } else {
                ResetScreens.resetVariables();
                screen = 27;
                screenLoop = 0;
                Clasiclogo.setRotation(0);
                modeScreenTime = System.currentTimeMillis();
            }

        }
        return false;

    }

    @Override
    public boolean keyUp(int keycode) {

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (screen == 18 && paused == false && (System.currentTimeMillis() - pausetime > 3000)) {//double
            if (sprites.get("pause").getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {

            } else {
                if (screenX < Variables.w / 2) {
                    //System.out.println("left");
                    left = true;
                }
                if (screenX >= Variables.w / 2) {
                    right = true;
                    //System.out.println("right");
                }
                MoveBall.change_double_angle();
            }
        } else if (screen == 19 && paused == false && (System.currentTimeMillis() - pausetime > 3000)) {//extreme play
            if (sprites.get("pause").getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {

            } else {
                y = screenY;
                switch (Extreme.balls1) {
                    case 3:
                        //System.out.println("three");
                        if (((Variables.h - y) < ((1 * Variables.h) / 3)) && ((Variables.h - y) >= 0)) { //bottom 1/3
                            third = true;
                            //System.out.println("third");

                        }
                        if (((Variables.h - y) < ((2 * Variables.h) / 3)) && ((Variables.h - y) >= ((Variables.h) / 3))) { //middle 1/3
                            second = true;
                            //System.out.println("second");
                        }
                        if (((Variables.h - y) < Variables.h) && ((Variables.h - y) >= ((2 * Variables.h) / 3))) { //top 1/3
                            first = true;
                            //System.out.println("first");
                        }

                        break;
                    case 4:
                        if (((Variables.h - y) < ((Variables.h) / 4)) && ((Variables.h - y) >= 0)) { //bottom 1/4
                            fourth = true;
                        }
                        if (((Variables.h - y) < ((2 * Variables.h) / 4)) && ((Variables.h - y) >= ((Variables.h) / 4))) { //2nd from bottom 1/4
                            third = true;
                        }
                        if (((Variables.h - y) < ((3 * Variables.h) / 4)) && ((Variables.h - y) >= ((2 * Variables.h) / 4))) { //3rd from bottom 1/4
                            second = true;
                        }
                        if (((Variables.h - y) < Variables.h) && ((Variables.h - y) >= ((3 * Variables.h) / 4))) { //top 1/4
                            first = true;
                        }
                        break;
                    case 5:
                        if (((Variables.h - y) < ((1 * Variables.h) / 5)) && ((Variables.h - y) >= 0)) { //bottom 1/5
                            fifth = true;
                        }
                        if (((Variables.h - y) < ((2 * Variables.h) / 5)) && ((Variables.h - y) >= ((Variables.h) / 5))) { //2nd from bottom 1/5
                            fourth = true;
                        }
                        if (((Variables.h - y) < ((3 * Variables.h) / 5)) && ((Variables.h - y) >= ((2 * Variables.h) / 5))) { //3rd from bottom 1/5
                            third = true;
                        }
                        if (((Variables.h - y) < ((4 * Variables.h) / 5)) && ((Variables.h - y) >= ((3 * Variables.h) / 5))) { // 2nd from top 1/5
                            second = true;
                        }
                        if (((Variables.h - y) < Variables.h) && ((Variables.h - y) >= ((4 * Variables.h) / 5))) { //top 1/5
                            first = true;
                        }
                        break;
                    case 6:
                        if (((Variables.h - y) < ((1 * Variables.h) / 6)) && ((Variables.h - y) >= 0)) { //bottom 1/6
                            sixth = true;
                        }
                        if (((Variables.h - y) < ((2 * Variables.h) / 6)) && ((Variables.h - y) >= ((1 * Variables.h) / 6))) { //2/6
                            fifth = true;
                        }
                        if (((Variables.h - y) < ((3 * Variables.h) / 6)) && ((Variables.h - y) >= ((2 * Variables.h) / 6))) { //3/6
                            fourth = true;
                        }
                        if (((Variables.h - y) < ((4 * Variables.h) / 6)) && ((Variables.h - y) >= ((3 * Variables.h) / 6))) { // 4/6
                            third = true;
                        }
                        if (((Variables.h - y) < ((5 * Variables.h) / 6)) && ((Variables.h - y) >= ((4 * Variables.h) / 6))) { //5/6
                            second = true;
                        }
                        if (((Variables.h - y) < Variables.h) && ((Variables.h - y) >= ((5 * Variables.h) / 6))) { //top 1/6
                            first = true;
                        }
                        break;
                }
                MoveBall.moveextremangle();
            }
        } else if (screen == 20 && paused == false && (System.currentTimeMillis() - pausetime > 3000)) { //extreme flip
            if (sprites.get("pause").getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {

            } else {
                if (screenY < h / 2) {
                    //System.out.println("upper");
                    upper = true;
                }
                if (screenY > h / 2) {
                    //System.out.println("lower");
                    lower = true;
                }
                com.flyingbrowniegames.ballgame.MoveBall.moveextremeflipangle();
            }
        } else if (Variables.screen == 21 && paused == false && (System.currentTimeMillis() - pausetime > 3000)) { //duo
            if (sprites.get("pause").getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {

            } else {
                if (screenY < h / 2) {
                    // player1 = pointer;
                    //System.out.println("upper");
                    upper = true;
                }
                if (screenY > h / 2) {
                    //player2 = pointer;
                    // System.out.println("lower");
                    lower = true;
                }
                MoveBall.change_duo_angle();
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
