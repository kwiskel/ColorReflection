package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

import java.lang.Double;
import java.util.ArrayList;
import java.util.Random;

import static com.flyingbrowniegames.ballgame.BallGame.drawSprite;
import static com.flyingbrowniegames.ballgame.BallGame.elapsedTime;
import static com.flyingbrowniegames.ballgame.BallGame.gametime;
import static com.flyingbrowniegames.ballgame.BallGame.iActivityRequestHandler;
import static com.flyingbrowniegames.ballgame.BallGame.playServices;
import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.BallGame.startTime;
import static com.flyingbrowniegames.ballgame.BallGame.timerloop;
import static com.flyingbrowniegames.ballgame.MoveBall.half_way;
import static com.flyingbrowniegames.ballgame.Variables.abysssprite;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.checkbox;
import static com.flyingbrowniegames.ballgame.Variables.checkmark;
import static com.flyingbrowniegames.ballgame.Variables.checktext1;
import static com.flyingbrowniegames.ballgame.Variables.countone;
import static com.flyingbrowniegames.ballgame.Variables.countthree;
import static com.flyingbrowniegames.ballgame.Variables.counttwo;
import static com.flyingbrowniegames.ballgame.Variables.duopausehome;
import static com.flyingbrowniegames.ballgame.Variables.duopausehowto;
import static com.flyingbrowniegames.ballgame.Variables.duopauseresume;
import static com.flyingbrowniegames.ballgame.Variables.eventLoop;
import static com.flyingbrowniegames.ballgame.Variables.extremepause;
import static com.flyingbrowniegames.ballgame.Variables.h;
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
import static com.flyingbrowniegames.ballgame.Variables.mode;
import static com.flyingbrowniegames.ballgame.Variables.normalsprite;
import static com.flyingbrowniegames.ballgame.Variables.pause;
import static com.flyingbrowniegames.ballgame.Variables.pausetime;
import static com.flyingbrowniegames.ballgame.Variables.playerscoreloop;
import static com.flyingbrowniegames.ballgame.Variables.score;
import static com.flyingbrowniegames.ballgame.Variables.score_string;
import static com.flyingbrowniegames.ballgame.Variables.screen;
import static com.flyingbrowniegames.ballgame.Variables.shouldtime;
import static com.flyingbrowniegames.ballgame.Variables.tormentsprite;
import static com.flyingbrowniegames.ballgame.Variables.w;
import static com.flyingbrowniegames.ballgame.Variables.waittime;
import static com.flyingbrowniegames.ballgame.Variables.woesprite;

/**
 * Created by kwisk_000 on 2016-05-08.
 */
public class Extreme {
    public static int balls;//amount of extreme balls
    public static ArrayList<java.lang.Double> positions = new ArrayList<Double>();
    public static int loop = 0;
    public static ArrayList<Integer> colours = new ArrayList<Integer>();
    public static ArrayList<Integer> arcdegrees = new ArrayList<Integer>();
    public static ArrayList<Integer> wallcolors = new ArrayList<Integer>();
    public static Random random = new Random();
    public static int balls1;
    public static int random1;
    public static int random2;
    public static ArrayList<Integer> ballpositions = new ArrayList<Integer>();


    public static void set_mode_screen() {
        Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Variables.mode = 6;
        Variables.batch.begin();
        //drawSprite("normal", Variables.w / 2, (15 * Variables.h) / 20);
        normalsprite.setCenter(Variables.w / 2, (15 * Variables.h) / 20);
        normalsprite.draw(Variables.batch);
        //drawSprite("woe", Variables.w / 2, (11 * Variables.h) / 20);
        woesprite.setCenter(Variables.w / 2, (11 * Variables.h) / 20);
        woesprite.draw(Variables.batch);
        //drawSprite("abyss", Variables.w / 2, (7 * Variables.h) / 20);
        abysssprite.setCenter(Variables.w / 2, (7 * Variables.h) / 20);
        abysssprite.draw(Variables.batch);
        //drawSprite("torment", Variables.w / 2, (3 * Variables.h) / 20);
        tormentsprite.setCenter(Variables.w / 2, (3 * Variables.h) / 20);
        tormentsprite.draw(Variables.batch);
        //drawSprite("extreme_name", Variables.w / 2, (Variables.h * 8) / 9);
        Variables.namesprite.setCenter(Variables.w / 2, (Variables.h * 8) / 9);
        Variables.namesprite.draw(Variables.batch);
        Variables.batch.end();
    }

    public static void set_screen(int balls) {
        while (loop == 0) {
            balls1 = balls;
            arcdegrees.add(90);
            arcdegrees.add(270);
            arcdegrees.add(90);
            arcdegrees.add(270);
            arcdegrees.add(90);
            arcdegrees.add(270);
            arcdegrees.add(90);
            arcdegrees.add(270);
            arcdegrees.add(90);
            arcdegrees.add(270);
            arcdegrees.add(90);
            arcdegrees.add(270);
            MoveBall.decide_speed();
            fill_ArrayList(balls);

        }
        if (mode != 7) {
            Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }
        extreme_set(balls);

    }

    public static void play_screen() {
        Variables.speed_increase = balls1;
        //System.out.println("speed incread" + Variables.speed_increase);
        BallGame.games_before = BallGame.games_elapsed;
        if (Variables.paused == true) { // pause the game
            if (timerloop == 1) {
                gametime += System.currentTimeMillis() - startTime;
                long timeplayed = Variables.prefs_time.getLong("time");
                elapsedTime = gametime / 1000;
                Variables.prefs_time.clear();
                Variables.prefs_time.putLong("time", timeplayed + elapsedTime);
                Variables.prefs_time.flush();
                timerloop = 0;
                gametime = 0;
            }
            if (Variables.mode != 7) {
                Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                batch.begin();
                //drawSprite("duopausehowto", (w * 3) / 4, h / 2);
                duopausehowto.setCenter((w * 3) / 4, h / 2);
                duopausehowto.draw(batch);
                //drawSprite("duopausehome", w / 4, h / 2);
                duopausehome.setCenter(w / 4, h / 2);
                duopausehome.draw(batch);
                //drawSprite("duopauseresume", w / 2, h / 2);
                duopauseresume.setCenter(w / 2, h / 2);
                duopauseresume.draw(batch);
                batch.end();
                batch.begin();
                //drawSprite("checkbox", w / 5, h / 4);
                checkbox.setCenter(w / 5, h / 4);
                checkbox.draw(batch);
                //drawSprite("extremepause", (w) / 2, h / 4);
                checktext1.setCenter((w) / 2, h / 4);
                checktext1.draw(batch);
                if (extremepause.getBoolean("pause") == false) {
                    //drawSprite("checkmark", w / 5, h / 4);
                    checkmark.setCenter(w / 5, h / 4);
                    checkmark.draw(batch);
                    //draw checkmark
                } else {

                }
                batch.end();
            }
        } else if (Variables.paused == false) {// resume the game
            if (System.currentTimeMillis() - pausetime < 3000) {
                Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                extreme_play(balls1);
                //Variables.batch.begin();
                //Variables.score_font.setColor(Color.WHITE);
                //Variables.score_font.draw(Variables.batch, Variables.score_string, Others.make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 19) / 20);
                //Variables.batch.end();
                if (playerscoreloop == 0) {
                    PrintScore.setDigitScore(score_string);
                }
                PrintScore.printScore(score_string);
                batch.begin();
                if (System.currentTimeMillis() - pausetime <= 1000) {
                    //drawSprite("three", w / 2, h / 2);
                    countthree.setCenter(w / 2, h / 2);
                    countthree.draw(batch);
                } else if ((System.currentTimeMillis() - pausetime > 1000) && (System.currentTimeMillis() - pausetime <= 2000)) {
                    //drawSprite("two", w / 2, h / 2);
                    counttwo.setCenter(w / 2, h / 2);
                    counttwo.draw(batch);
                } else {
                    //drawSprite("one", w / 2, h / 2);
                    countone.setCenter(w / 2, h / 2);
                    countone.draw(batch);
                }
                batch.end();
            } else {
                if (timerloop == 0) {
                    startTime = System.currentTimeMillis();
                    timerloop = 1;
                }
                Variables.loop = 0;
                Variables.zero_to_three = 0;
                Variables.score_string = "" + Variables.score;
                Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                extreme_play(balls1);
                if (mode != 7) {
                    if (extremepause.getBoolean("pause") == false) {
                        //sprites.get("pause").setAlpha(1f);
                        pause.setAlpha(1f);
                    } else {
                        //sprites.get("pause").setAlpha(0f);
                        pause.setAlpha(0f);
                    }
                    batch.begin();
                    //drawSprite("pause", w / 10, (h * 39) / 40);
                    pause.setCenter(w / 10, (h * 39) / 40);
                    pause.draw(batch);
                    batch.end();
                }
                //System.out.println("pause: " + extremepause.getBoolean("pause"));
                //Variables.batch.begin();
                //Variables.score_font.setColor(Color.WHITE);
                //Variables.score_font.draw(Variables.batch, Variables.score_string, Others.make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 19) / 20);
                //Variables.batch.end();
                if (playerscoreloop == 0) {
                    //System.out.println("called");
                    PrintScore.setDigitScore(score_string);
                }
                PrintScore.printScore(score_string);
                int score_before = Variables.score;
                //MoveBall.change_direction(); // change ball direction
                change_direction();
                move_balls();
                // MoveBall.change_x(); //move ball
                check_hit(); // check to see if colours match when ball contacts wall and add score
                int score_after = Variables.score;

                if (score_after - score_before == balls1) {
                    if (mode == 7) {
                        if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                            playServices.unlockAchievement(7, score_after, 0);
                        } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                            iActivityRequestHandler.reportAchievement(7, score_after, 0);
                        }
                    } else {
                        if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                            playServices.unlockAchievement(6, score_after, balls - 2);
                        } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                            iActivityRequestHandler.reportAchievement(6, score_after, balls - 2);
                        }
                    }
                    if (balls1 == 2) {
                        if (score == 1000) {
                            screen = 3;
                            eventLoop = 0;
                        }
                    } else if (balls1 == 3) {
                        if (score == 999) {
                            screen = 3;
                            eventLoop = 0;
                        }
                    } else if (balls1 == 4) {
                        if (score == 1000) {
                            screen = 3;
                            eventLoop = 0;
                        }
                    } else if (balls1 == 5) {
                        if (score == 1000) {
                            screen = 3;
                            eventLoop = 0;
                        }
                    } else if (balls1 == 6) {
                        if (score == 1050) {
                            screen = 3;
                            eventLoop = 0;
                        }
                    }
                    color_from_int();

                } else {
                    Variables.score = score_before;
                }

            }
        }
    }

    public static void extreme_set(int balls) {
        int lines = balls;

        Variables.batch.begin();
        Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        switch (balls1) {
            case 2:
                ExtremeColors.arc_color(colours.get(0), 1);
                h1.setFlip(false, false);
                h1.setCenter(positions.get(0).floatValue() - ballpositions.get(0).floatValue(), positions.get(1).floatValue());
                h1.draw(batch);
                ExtremeColors.arc_color(colours.get(1), 2);
                h2.setFlip(true, false);
                h2.setCenter(positions.get(0).floatValue() + ballpositions.get(0).floatValue(), positions.get(1).floatValue());
                h2.draw(batch);
                ExtremeColors.arc_color(colours.get(2), 3);
                h3.setFlip(false, false);
                h3.setCenter(positions.get(0).floatValue() - ballpositions.get(2).floatValue(), positions.get(3).floatValue());
                h3.draw(batch);
                ExtremeColors.arc_color(colours.get(3), 4);
                h4.setFlip(true, false);
                h4.setCenter(positions.get(0).floatValue() + ballpositions.get(2).floatValue(), positions.get(3).floatValue());
                h4.draw(batch);
                break;
            case 3:
                ExtremeColors.arc_color(colours.get(0), 1);
                h1.setFlip(false, false);
                h1.setCenter(positions.get(0).floatValue() - ballpositions.get(0).floatValue(), positions.get(1).floatValue());
                h1.draw(batch);
                ExtremeColors.arc_color(colours.get(1), 2);
                h2.setFlip(true, false);
                h2.setCenter(positions.get(0).floatValue() + ballpositions.get(0).floatValue(), positions.get(1).floatValue());
                h2.draw(batch);
                ExtremeColors.arc_color(colours.get(2), 3);
                h3.setFlip(false, false);
                h3.setCenter(positions.get(0).floatValue() - ballpositions.get(2).floatValue(), positions.get(3).floatValue());
                h3.draw(batch);
                ExtremeColors.arc_color(colours.get(3), 4);
                h4.setFlip(true, false);
                h4.setCenter(positions.get(0).floatValue() + ballpositions.get(2).floatValue(), positions.get(3).floatValue());
                h4.draw(batch);
                ExtremeColors.arc_color(colours.get(4), 5);
                h5.setFlip(false, false);
                h5.setCenter(positions.get(0).floatValue() - ballpositions.get(4).floatValue(), positions.get(5).floatValue());
                h5.draw(batch);
                ExtremeColors.arc_color(colours.get(5), 6);
                h6.setFlip(true, false);
                h6.setCenter(positions.get(0).floatValue() + ballpositions.get(4).floatValue(), positions.get(5).floatValue());
                h6.draw(batch);
                break;
            case 4:
                ExtremeColors.arc_color(colours.get(0), 1);
                h1.setFlip(false, false);
                h1.setCenter(positions.get(0).floatValue() - ballpositions.get(0).floatValue(), positions.get(1).floatValue());
                h1.draw(batch);
                ExtremeColors.arc_color(colours.get(1), 2);
                h2.setFlip(true, false);
                h2.setCenter(positions.get(0).floatValue() + ballpositions.get(0).floatValue(), positions.get(1).floatValue());
                h2.draw(batch);
                ExtremeColors.arc_color(colours.get(2), 3);
                h3.setFlip(false, false);
                h3.setCenter(positions.get(0).floatValue() - ballpositions.get(2).floatValue(), positions.get(3).floatValue());
                h3.draw(batch);
                ExtremeColors.arc_color(colours.get(3), 4);
                h4.setFlip(true, false);
                h4.setCenter(positions.get(0).floatValue() + ballpositions.get(2).floatValue(), positions.get(3).floatValue());
                h4.draw(batch);
                ExtremeColors.arc_color(colours.get(4), 5);
                h5.setFlip(false, false);
                h5.setCenter(positions.get(0).floatValue() - ballpositions.get(4).floatValue(), positions.get(5).floatValue());
                h5.draw(batch);
                ExtremeColors.arc_color(colours.get(5), 6);
                h6.setFlip(true, false);
                h6.setCenter(positions.get(0).floatValue() + ballpositions.get(4).floatValue(), positions.get(5).floatValue());
                h6.draw(batch);
                ExtremeColors.arc_color(colours.get(6), 7);
                h7.setFlip(false, false);
                h7.setCenter(positions.get(0).floatValue() - ballpositions.get(6).floatValue(), positions.get(7).floatValue());
                h7.draw(batch);
                ExtremeColors.arc_color(colours.get(7), 8);
                h8.setFlip(true, false);
                h8.setCenter(positions.get(0).floatValue() + ballpositions.get(6).floatValue(), positions.get(7).floatValue());
                h8.draw(batch);
                break;
            case 5:
                ExtremeColors.arc_color(colours.get(0), 1);
                h1.setFlip(false, false);
                h1.setCenter(positions.get(0).floatValue() - ballpositions.get(0).floatValue(), positions.get(1).floatValue());
                h1.draw(batch);
                ExtremeColors.arc_color(colours.get(1), 2);
                h2.setFlip(true, false);
                h2.setCenter(positions.get(0).floatValue() + ballpositions.get(0).floatValue(), positions.get(1).floatValue());
                h2.draw(batch);
                ExtremeColors.arc_color(colours.get(2), 3);
                h3.setFlip(false, false);
                h3.setCenter(positions.get(0).floatValue() - ballpositions.get(2).floatValue(), positions.get(3).floatValue());
                h3.draw(batch);
                ExtremeColors.arc_color(colours.get(3), 4);
                h4.setFlip(true, false);
                h4.setCenter(positions.get(0).floatValue() + ballpositions.get(2).floatValue(), positions.get(3).floatValue());
                h4.draw(batch);
                ExtremeColors.arc_color(colours.get(4), 5);
                h5.setFlip(false, false);
                h5.setCenter(positions.get(0).floatValue() - ballpositions.get(4).floatValue(), positions.get(5).floatValue());
                h5.draw(batch);
                ExtremeColors.arc_color(colours.get(5), 6);
                h6.setFlip(true, false);
                h6.setCenter(positions.get(0).floatValue() + ballpositions.get(4).floatValue(), positions.get(5).floatValue());
                h6.draw(batch);
                ExtremeColors.arc_color(colours.get(6), 7);
                h7.setFlip(false, false);
                h7.setCenter(positions.get(0).floatValue() - ballpositions.get(6).floatValue(), positions.get(7).floatValue());
                h7.draw(batch);
                ExtremeColors.arc_color(colours.get(7), 8);
                h8.setFlip(true, false);
                h8.setCenter(positions.get(0).floatValue() + ballpositions.get(6).floatValue(), positions.get(7).floatValue());
                h8.draw(batch);
                ExtremeColors.arc_color(colours.get(8), 9);
                h9.setFlip(false, false);
                h9.setCenter(positions.get(0).floatValue() - ballpositions.get(8).floatValue(), positions.get(9).floatValue());
                h9.draw(batch);
                ExtremeColors.arc_color(colours.get(9), 10);
                h10.setFlip(true, false);
                h10.setCenter(positions.get(0).floatValue() + ballpositions.get(8).floatValue(), positions.get(9).floatValue());
                h10.draw(batch);
                break;
            case 6:
                ExtremeColors.arc_color(colours.get(0), 1);
                h1.setFlip(false, false);
                h1.setCenter(positions.get(0).floatValue() - ballpositions.get(0).floatValue(), positions.get(1).floatValue());
                h1.draw(batch);
                ExtremeColors.arc_color(colours.get(1), 2);
                h2.setFlip(true, false);
                h2.setCenter(positions.get(0).floatValue() + ballpositions.get(0).floatValue(), positions.get(1).floatValue());
                h2.draw(batch);
                ExtremeColors.arc_color(colours.get(2), 3);
                h3.setFlip(false, false);
                h3.setCenter(positions.get(0).floatValue() - ballpositions.get(2).floatValue(), positions.get(3).floatValue());
                h3.draw(batch);
                ExtremeColors.arc_color(colours.get(3), 4);
                h4.setFlip(true, false);
                h4.setCenter(positions.get(0).floatValue() + ballpositions.get(2).floatValue(), positions.get(3).floatValue());
                h4.draw(batch);
                ExtremeColors.arc_color(colours.get(4), 5);
                h5.setFlip(false, false);
                h5.setCenter(positions.get(0).floatValue() - ballpositions.get(4).floatValue(), positions.get(5).floatValue());
                h5.draw(batch);
                ExtremeColors.arc_color(colours.get(5), 6);
                h6.setFlip(true, false);
                h6.setCenter(positions.get(0).floatValue() + ballpositions.get(4).floatValue(), positions.get(5).floatValue());
                h6.draw(batch);
                ExtremeColors.arc_color(colours.get(6), 7);
                h7.setFlip(false, false);
                h7.setCenter(positions.get(0).floatValue() - ballpositions.get(6).floatValue(), positions.get(7).floatValue());
                h7.draw(batch);
                ExtremeColors.arc_color(colours.get(7), 8);
                h8.setFlip(true, false);
                h8.setCenter(positions.get(0).floatValue() + ballpositions.get(6).floatValue(), positions.get(7).floatValue());
                h8.draw(batch);
                ExtremeColors.arc_color(colours.get(8), 9);
                h9.setFlip(false, false);
                h9.setCenter(positions.get(0).floatValue() - ballpositions.get(8).floatValue(), positions.get(9).floatValue());
                h9.draw(batch);
                ExtremeColors.arc_color(colours.get(9), 10);
                h10.setFlip(true, false);
                h10.setCenter(positions.get(0).floatValue() + ballpositions.get(8).floatValue(), positions.get(9).floatValue());
                h10.draw(batch);
                ExtremeColors.arc_color(colours.get(10), 11);
                h11.setFlip(false, false);
                h11.setCenter(positions.get(0).floatValue() - ballpositions.get(10).floatValue(), positions.get(11).floatValue());
                h11.draw(batch);
                ExtremeColors.arc_color(colours.get(11), 12);
                h12.setFlip(true, false);
                h12.setCenter(positions.get(0).floatValue() + ballpositions.get(10).floatValue(), positions.get(11).floatValue());
                h12.draw(batch);
                break;
        }
        batch.end();
        batch.begin();
        for (int i = 0; i < positions.size(); i += 2) {
            //Colours.extreme_Color(colours.get(i));
            //Variables.shapeRenderer.arc(positions.get(i).floatValue(), positions.get(i + 1).floatValue(), Variables.arc_width, arcdegrees.get(i), 180);
            //Colours.extreme_Color(colours.get(i + 1));
            // Variables.shapeRenderer.arc(positions.get(i).floatValue(), positions.get(i + 1).floatValue(), Variables.arc_width, arcdegrees.get(i + 1), 180);
            //Colours.extreme_color(colours, i);
            //Colours.left_color();
            Colours.extreme_Color(wallcolors.get(i));
            Variables.shapeRenderer.rect(0, ((lines - 1) * Variables.h) / balls, (Variables.w * 1 / 100), Variables.h / balls);
            //Colours.right_color();
            Colours.extreme_Color(wallcolors.get(i + 1));
            Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), ((lines - 1) * Variables.h) / balls, (Variables.w * 1 / 100) + 20, Variables.h / balls);
            lines--;
        }
        Variables.shapeRenderer.end();
        Variables.batch.end();

    }


    public static void extreme_play(int balls) {
        int lines = balls;
        batch.begin();
        if (balls1 == 2 || balls1 == 3 || balls1 == 4 || balls1 == 5 || balls1 == 6) {
            ExtremeColors.arc_color(colours.get(0), 1);
            h1.setCenter(positions.get(0).floatValue() - ballpositions.get(0).floatValue(), positions.get(1).floatValue());
            h1.draw(batch);
            ExtremeColors.arc_color(colours.get(1), 2);
            h2.setCenter(positions.get(0).floatValue() + ballpositions.get(0).floatValue(), positions.get(1).floatValue());
            h2.draw(batch);
            ExtremeColors.arc_color(colours.get(2), 3);
            h3.setCenter(positions.get(0).floatValue() - ballpositions.get(2).floatValue(), positions.get(3).floatValue());
            h3.draw(batch);
            ExtremeColors.arc_color(colours.get(3), 4);
            h4.setCenter(positions.get(0).floatValue() + ballpositions.get(2).floatValue(), positions.get(3).floatValue());
            h4.draw(batch);
            if (balls1 == 3 || balls1 == 4 || balls1 == 5 || balls1 == 6) {
                ExtremeColors.arc_color(colours.get(4), 5);
                h5.setCenter(positions.get(0).floatValue() - ballpositions.get(4).floatValue(), positions.get(5).floatValue());
                h5.draw(batch);
                ExtremeColors.arc_color(colours.get(5), 6);
                h6.setCenter(positions.get(0).floatValue() + ballpositions.get(4).floatValue(), positions.get(5).floatValue());
                h6.draw(batch);
                if (balls1 == 4 || balls1 == 5 || balls1 == 6) {
                    ExtremeColors.arc_color(colours.get(6), 7);
                    h7.setCenter(positions.get(0).floatValue() - ballpositions.get(6).floatValue(), positions.get(7).floatValue());
                    h7.draw(batch);
                    ExtremeColors.arc_color(colours.get(7), 8);
                    h8.setCenter(positions.get(0).floatValue() + ballpositions.get(6).floatValue(), positions.get(7).floatValue());
                    h8.draw(batch);
                    if (balls1 == 5 || balls1 == 6) {
                        ExtremeColors.arc_color(colours.get(8), 9);
                        h9.setCenter(positions.get(0).floatValue() - ballpositions.get(8).floatValue(), positions.get(9).floatValue());
                        h9.draw(batch);
                        ExtremeColors.arc_color(colours.get(9), 10);
                        h10.setCenter(positions.get(0).floatValue() + ballpositions.get(8).floatValue(), positions.get(9).floatValue());
                        h10.draw(batch);
                        if (balls1 == 6) {
                            ExtremeColors.arc_color(colours.get(10), 11);
                            h11.setCenter(positions.get(0).floatValue() - ballpositions.get(10).floatValue(), positions.get(11).floatValue());
                            h11.draw(batch);
                            ExtremeColors.arc_color(colours.get(11), 12);
                            h12.setCenter(positions.get(0).floatValue() + ballpositions.get(10).floatValue(), positions.get(11).floatValue());
                            h12.draw(batch);
                        }
                    }
                }
            }
        }

        batch.end();
        Variables.batch.begin();
        Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < positions.size(); i += 2) {
            // System.out.println("i2" + i);
            //Colours.extreme_Color(colours.get(i));
            //Variables.shapeRenderer.arc(positions.get(i).floatValue(), positions.get(i + 1).floatValue(), Variables.arc_width, arcdegrees.get(i), 180);
            //Colours.extreme_Color(colours.get(i + 1));
            //Variables.shapeRenderer.arc(positions.get(i).floatValue(), positions.get(i + 1).floatValue(), Variables.arc_width, arcdegrees.get(i + 1), 180);
            //Colours.extreme_color(colours, i);
            Colours.extreme_Color(wallcolors.get(i));
            // System.out.println("balls " + balls);
            Variables.shapeRenderer.rect(0, ((lines - 1) * Variables.h) / balls, (Variables.w * 1 / 100), Variables.h / balls);
            Colours.extreme_Color(wallcolors.get(i + 1));
            Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), ((lines - 1) * Variables.h) / balls, (Variables.w * 1 / 100) + 20, Variables.h / balls);
            lines--;
        }
        Variables.shapeRenderer.end();
        Variables.batch.end();
        Variables.batch.begin();
        int lo = balls1 - 1;
        for (int i = 0; i < balls1 - 1; i++) {
            //drawSprite("divider", Variables.w / 2, (lo * Variables.h) / balls1);
            Variables.dividersprite.setCenter(Variables.w / 2, (lo * Variables.h) / balls1);
            Variables.dividersprite.draw(Variables.batch);
            lo--;
        }
        Variables.batch.end();
    }

    public static void fill_ArrayList(int balls) {

        for (int i = 0; i < (2 * balls); i += 2) {
            random();
            colours.add(random1);
            wallcolors.add(random1);
            colours.add(random2);
            wallcolors.add(random2);
            ballpositions.add(w / 22);
            ballpositions.add(w / 22);
        }
        int ypos = (2 * balls) - 1;
        for (int i = 0; i < (2 * balls); i++) {
            if (positions.size() % 2 == 0) {
                positions.add(Variables.w / 2.00);
            } else {
                positions.add((Variables.h * ypos) / (2 * balls) + 0.00);
                ypos -= 2;
            }

        }
        loop++;
    }

    public static void random() {
        random1 = random.nextInt(10) + 1;
        random2 = random.nextInt(10) + 1;
        if (random2 == random1) {
            random();
        }
    }

    public static void move_balls() {
        if (Variables.loopone) {
            MoveBall.decide_speed();
        }
        if (Variables.mode != 7) {
            Variables.widthspeed = half_way;
        } else {
            Variables.widthspeed = half_way + (half_way / 2);
        }
        if (Variables.direction == 1) {
            int hits = Variables.times_hit_wall;
            if (hits < Variables.speed_increase) {
                Variables.speed = Variables.widthspeed / 100;
            } else if (hits % Variables.speed_increase == 0 && hits >= Variables.speed_increase) {
                Variables.speed = (Variables.widthspeed / 100) + hits / Variables.speed_increase;
            } else {
                if (Variables.speed == 15) {
                    Variables.speed = 15;
                } else {
                    Variables.speed = (Variables.widthspeed / 100) + hits / Variables.speed_increase;
                }

            }
        } else if (Variables.direction == 2) {
            if (Variables.times_hit_wall % Variables.speed_increase == 0 && Variables.times_hit_wall > 0) {
                int hits = Variables.times_hit_wall;
                if (hits < Variables.speed_increase) {
                    Variables.speed = Variables.widthspeed / 100;
                } else if (hits % Variables.speed_increase == 0 && hits >= Variables.speed_increase) {
                    if (Variables.speed == 15) {
                        Variables.speed = 15;
                    } else {
                        Variables.speed = (Variables.widthspeed / 100) + hits / Variables.speed_increase;
                    }

                } else {

                }

            } else {

            }

        }

        double n = 1;
        for (int i = 0; i < positions.size(); i += 2) {
            double p = positions.get(i);
            positions.remove(i);
            if (Variables.direction == 1) {
                n = p + Variables.speed;
                Variables.position_x += Variables.speed;
            } else if (Variables.direction == 2) {
                n = p - Variables.speed;
                Variables.position_x -= Variables.speed;
            }
            positions.add(i, n);
        }
    }

    public static void change_direction() {
        if (positions.get(0) > Variables.w - (Variables.arc_width + (Variables.w / 100))) {
            Variables.times_hit_wall++;
            if (Variables.prefs_sound.getInteger("sound") == 0) {
                Variables.bounce.play(1.0f);
            }
            Variables.direction = 2;
        } else if (positions.get(0) < (Variables.arc_width + (Variables.w / 100))) {
            Variables.times_hit_wall++;
            if (Variables.prefs_sound.getInteger("sound") == 0) {
                Variables.bounce.play(1.0f);
            }
            Variables.direction = 1;
        } else {

        }
    }

    public static void check_hit() {
        int scorep = 0;
        if (positions.get(0) > Variables.w - (Variables.arc_width + (Variables.w / 100))) {//right side
            for (int i = 0; i < 2 * balls1; i += 2) {
                if (arcdegrees.get(i) == 90) {
                    if (colours.get(i + 1) == wallcolors.get(i + 1)) {
                        scorep++;
                    } else {
                        Variables.screen = 3;
                        waittime = System.currentTimeMillis();
                        Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                        eventLoop = 0;
                    }
                } else if (arcdegrees.get(i) == 270) {
                    if (colours.get(i) == wallcolors.get(i + 1)) {
                        scorep++;
                    } else {
                        Variables.screen = 3;
                        waittime = System.currentTimeMillis();
                        Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                        eventLoop = 0;
                    }
                }
            }
        } else if (positions.get(0) < (Variables.arc_width + (Variables.w / 100))) {
            for (int i = 0; i < 2 * balls1; i += 2) {
                if (arcdegrees.get(i) == 90) {
                    if (colours.get(i) == wallcolors.get(i)) {
                        scorep++;
                    } else {
                        Variables.screen = 3;
                        waittime = System.currentTimeMillis();
                        Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                        eventLoop = 0;
                    }
                } else if (arcdegrees.get(i) == 270) {
                    if (colours.get(i + 1) == wallcolors.get(i)) {
                        scorep++;
                    } else {
                        Variables.screen = 3;
                        waittime = System.currentTimeMillis();
                        Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                        eventLoop = 0;
                    }
                }
            }
        }
        if (scorep == balls1) {
            Variables.score += balls1;
            playerscoreloop = 0;
        }
    }

    public static void color_from_int() {
        for (int i = 0; i < 2 * balls1; i += 2) {
            random_colours();

            Variables.side = Variables.random.nextInt(10) + 1;
            if (Variables.direction == 1) {
                //Variables.left_id = Variables.side_random;
                wallcolors.remove(i);
                wallcolors.add(i, Variables.side_random);
            } else if (Variables.direction == 2) {
                //Variables.right_id = Variables.side_random;
                wallcolors.remove(i + 1);
                wallcolors.add(i + 1, Variables.side_random);
            } else {

            }
            // System.out.println("side_random" + Variables.side_random);
            if (Variables.side != 3 && Variables.side != 6 && Variables.side != 9) {
                if (Variables.direction == 2) {
                    if (arcdegrees.get(i + 1) == 270) {
                        colours.remove(i + 1);
                        colours.add(i + 1, Variables.ball_random);
                        colours.remove(i);
                        colours.add(i, Variables.side_random);
                        // Variables.arc_right_id = Variables.ball_random;
                        //Variables.arc_left_id = Variables.side_random;
                    } else if (arcdegrees.get(i + 1) == 90) {
                        colours.remove(i + 1);
                        colours.add(i + 1, Variables.side_random);
                        colours.remove(i);
                        colours.add(i, Variables.ball_random);
                        //Variables.arc_right_id = Variables.side_random;
                        // Variables.arc_left_id = Variables.ball_random;
                    } else {

                    }
                } else if (Variables.direction == 1) {
                    if (arcdegrees.get(i + 1) == 270) {
                        colours.remove(i + 1);
                        colours.add(i + 1, Variables.side_random);
                        colours.remove(i);
                        colours.add(i, Variables.ball_random);
                        //Variables.arc_right_id = Variables.side_random;
                        // Variables.arc_left_id = Variables.ball_random;
                    } else if (arcdegrees.get(i + 1) == 90) {
                        colours.remove(i + 1);
                        colours.add(i + 1, Variables.ball_random);
                        colours.remove(i);
                        colours.add(i, Variables.side_random);
                        //Variables.arc_right_id = Variables.ball_random;
                        //Variables.arc_left_id = Variables.side_random;
                    } else {

                    }
                } else {

                }
            } else if (Variables.side == 3 || Variables.side == 6 || Variables.side == 9) { //colors will match
                //System.out.println("direction" + direction);
                if (Variables.direction == 2) {
                    if (arcdegrees.get(i + 1) == 270) {
                        colours.remove(i + 1);
                        colours.add(i + 1, Variables.side_random);
                        colours.remove(i);
                        colours.add(i, Variables.ball_random);
                        //Variables.arc_right_id = Variables.side_random;
                        // Variables.arc_left_id = Variables.ball_random;
                    } else if (arcdegrees.get(i + 1) == 90) {
                        colours.remove(i + 1);
                        colours.add(i + 1, Variables.ball_random);
                        colours.remove(i);
                        colours.add(i, Variables.side_random);
                        //Variables.arc_left_id = Variables.side_random;
                        // Variables.arc_right_id = Variables.ball_random;
                    }
                } else if (Variables.direction == 1) {
                    if (arcdegrees.get(i + 1) == 270) {
                        colours.remove(i + 1);
                        colours.add(i + 1, Variables.ball_random);
                        colours.remove(i);
                        colours.add(i, Variables.side_random);
                        //Variables.arc_left_id = Variables.side_random;
                        //Variables.arc_right_id = Variables.ball_random;
                    } else if (arcdegrees.get(i + 1) == 90) {
                        colours.remove(i + 1);
                        colours.add(i + 1, Variables.side_random);
                        colours.remove(i);
                        colours.add(i, Variables.ball_random);
                        //Variables.arc_right_id = Variables.side_random;
                        // Variables.arc_left_id = Variables.ball_random;
                    }
                } else {

                }
            } else {

            }
        }

    }

    public static void random_colours() {
        Variables.side_random = Variables.random.nextInt(10) + 1;
        Variables.ball_random = Variables.random.nextInt(10) + 1;
        if (Variables.ball_random == Variables.side_random) {
            random_colours();
        }
    }
}
