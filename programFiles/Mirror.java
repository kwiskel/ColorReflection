package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.flyingbrowniegames.ballgame.BallGame.drawSprite;
import static com.flyingbrowniegames.ballgame.BallGame.elapsedTime;
import static com.flyingbrowniegames.ballgame.BallGame.gametime;
import static com.flyingbrowniegames.ballgame.BallGame.iActivityRequestHandler;
import static com.flyingbrowniegames.ballgame.BallGame.playServices;
import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.BallGame.startTime;
import static com.flyingbrowniegames.ballgame.BallGame.timerloop;
import static com.flyingbrowniegames.ballgame.Variables.achievementBoard;
import static com.flyingbrowniegames.ballgame.Variables.achievementFont;
import static com.flyingbrowniegames.ballgame.Variables.achievementStartTime;
import static com.flyingbrowniegames.ballgame.Variables.achievementTime;
import static com.flyingbrowniegames.ballgame.Variables.arc_degree_1;
import static com.flyingbrowniegames.ballgame.Variables.arc_degree_2;
import static com.flyingbrowniegames.ballgame.Variables.ball;
import static com.flyingbrowniegames.ballgame.Variables.ballposition;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.bounceCount;
import static com.flyingbrowniegames.ballgame.Variables.burstnamme;
import static com.flyingbrowniegames.ballgame.Variables.countone;
import static com.flyingbrowniegames.ballgame.Variables.countthree;
import static com.flyingbrowniegames.ballgame.Variables.counttwo;
import static com.flyingbrowniegames.ballgame.Variables.duopausehome;
import static com.flyingbrowniegames.ballgame.Variables.duopausehowto;
import static com.flyingbrowniegames.ballgame.Variables.duopauseresume;
import static com.flyingbrowniegames.ballgame.Variables.eventLoop;
import static com.flyingbrowniegames.ballgame.Variables.fastforwardButton;
import static com.flyingbrowniegames.ballgame.Variables.glyphLayout;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.halfloop;
import static com.flyingbrowniegames.ballgame.Variables.leftball;
import static com.flyingbrowniegames.ballgame.Variables.mirrorCompleted;
import static com.flyingbrowniegames.ballgame.Variables.mirrorThrough;
import static com.flyingbrowniegames.ballgame.Variables.mirrornamme;
import static com.flyingbrowniegames.ballgame.Variables.pause;
import static com.flyingbrowniegames.ballgame.Variables.pausetime;
import static com.flyingbrowniegames.ballgame.Variables.playerscoreloop;
import static com.flyingbrowniegames.ballgame.Variables.position_x;
import static com.flyingbrowniegames.ballgame.Variables.progressBox;
import static com.flyingbrowniegames.ballgame.Variables.progressFont;
import static com.flyingbrowniegames.ballgame.Variables.progressLayout;
import static com.flyingbrowniegames.ballgame.Variables.randomizeButton;
import static com.flyingbrowniegames.ballgame.Variables.rightball;
import static com.flyingbrowniegames.ballgame.Variables.score;
import static com.flyingbrowniegames.ballgame.Variables.score_string;
import static com.flyingbrowniegames.ballgame.Variables.screen;
import static com.flyingbrowniegames.ballgame.Variables.shouldtime;
import static com.flyingbrowniegames.ballgame.Variables.throughCount;
import static com.flyingbrowniegames.ballgame.Variables.times_hit_wall;
import static com.flyingbrowniegames.ballgame.Variables.type;
import static com.flyingbrowniegames.ballgame.Variables.w;
import static com.flyingbrowniegames.ballgame.Variables.waittime;
import static com.flyingbrowniegames.ballgame.Variables.wasReflected;

/**
 * Created by kwisk_000 on 2016-05-08.
 */
public class Mirror {
    public static int reflect;


    public static void set_screen() {
        Variables.speed_increase = 5;
        Variables.mode = 2;
        Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Variables.batch.begin();
        Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //Colours.arc_color(Variables.arc_left_id);
        //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 2, Variables.arc_width, Variables.arc_degree_1, 180);
        //Colours.arc_color(Variables.arc_right_id);
        //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 2, Variables.arc_width, Variables.arc_degree_2, 180);
        Colours.left_color();
        Variables.shapeRenderer.rect(0, Variables.h / 3, (Variables.w * 1 / 100), Variables.h / 3);
        Colours.right_color();
        Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 3, (Variables.w * 1 / 100) + 20, Variables.h / 3);
        Variables.shapeRenderer.end();
        Variables.batch.end();
        Variables.batch.begin();
        mirrornamme.setCenter(Variables.w / 2, (Variables.h * 8) / 9);
        mirrornamme.draw(Variables.batch);
        Variables.sprite4.setCenter(Variables.w / 2, (Variables.h * 5) / 6);
        Variables.sprite4.draw(Variables.batch);
        Variables.batch.end();
        batch.begin();
        ball.setCenter(w / 2, h / 2);
        ball.draw(batch);
        ball.rotate(1);
        //drawSprite("mirror_name", Variables.w / 2, (Variables.h * 8) / 9);
        //drawSprite("play", Variables.w / 2, (Variables.h * 5) / 6);
        Variables.batch.end();
        batch.begin();
        if (mirrorCompleted.getInteger("mirrorCompleted") != 25) {
            achievementBoard.setCenter(w / 2, ((h * 9) / 48));
            achievementBoard.draw(batch);
            if (mirrorCompleted.getInteger("mirrorCompleted") == 24) {
                fastforwardButton.setCenter((w * 1) / 2, ((h * 9) / 48) - (achievementBoard.getBoundingRectangle().getHeight() / 2));
                fastforwardButton.draw(batch);
            } else {
                randomizeButton.setCenter(w / 3, ((h * 9) / 48) - (achievementBoard.getBoundingRectangle().getHeight() / 2));
                randomizeButton.draw(batch);
                fastforwardButton.setCenter((w * 2) / 3, ((h * 9) / 48) - (achievementBoard.getBoundingRectangle().getHeight() / 2));
                fastforwardButton.draw(batch);
            }
            achievementFont.draw(batch, glyphLayout, (w - glyphLayout.width) / 2, (((h * 10) / 48)) + (glyphLayout.height / 2));
            progressBox.setCenter(w / 2, ((h * 9) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) + (progressBox.getBoundingRectangle().getHeight() / 2));
            progressBox.draw(batch);
            progressFont.draw(batch, progressLayout, (w / 2) - (progressLayout.width / 2),
                    (((h * 9) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) +
                            (progressBox.getBoundingRectangle().getHeight() / 2)) + (progressLayout.height / 2));
        } else {
            achievementBoard.setCenter(w / 2, ((h * 9) / 48));
            achievementBoard.draw(batch);
            achievementFont.draw(batch, glyphLayout, (w - glyphLayout.width) / 2, (((h * 10) / 48)) + (glyphLayout.height / 2));
            progressBox.setCenter(w / 2, ((h * 9) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) + (progressBox.getBoundingRectangle().getHeight() / 2));
            progressBox.draw(batch);
            progressFont.draw(batch, progressLayout, (w / 2) - (progressLayout.width / 2),
                    (((h * 9) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) +
                            (progressBox.getBoundingRectangle().getHeight() / 2)) + (progressLayout.height / 2));
        }
        batch.end();
    }

    public static void play_screen() {
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
                if (type.equalsIgnoreCase("time")) {
                    achievementTime += System.currentTimeMillis() - startTime;
                }
            }
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
        } else if (Variables.paused == false) {// resume the game
            if (System.currentTimeMillis() - pausetime < 3000) {
                Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                //batch.begin();
                //Variables.score_font.setColor(Color.WHITE);
                //Variables.score_font.draw(Variables.batch, Variables.score_string, Others.make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 9) / 10);
                //batch.end();
                if (playerscoreloop == 0) {
                    PrintScore.setDigitScore(score_string);
                }
                PrintScore.printScore(score_string);
                batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                //Colours.arc_color(Variables.arc_left_id);
                //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 2, Variables.arc_width, Variables.arc_degree_1, 180);
                //Colours.arc_color(Variables.arc_right_id);
                //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 2, Variables.arc_width, Variables.arc_degree_2, 180);
                Colours.left_color();
                Variables.shapeRenderer.rect(0, Variables.h / 3, (Variables.w * 1 / 100), Variables.h / 3);
                Colours.right_color();
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 3, (Variables.w * 1 / 100) + 20, Variables.h / 3);
                Variables.shapeRenderer.end();
                batch.end();
                batch.begin();
                Colours.arc_color(Variables.arc_left_id, "left", 2);
                leftball.setCenter(position_x - ballposition, h / 2);
                leftball.draw(batch);
                Colours.arc_color(Variables.arc_right_id, "right", 2);
                rightball.setCenter(position_x + ballposition, h / 2);
                rightball.draw(batch);
                batch.end();

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
                    if (type.equalsIgnoreCase("time")) {
                        achievementStartTime = System.currentTimeMillis();
                    }
                    timerloop = 1;
                }
                Variables.loop = 0;
                Variables.zero_to_three = 0;
                Variables.score_string = "" + Variables.score;
                Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                //Colours.arc_color(Variables.arc_left_id);
                //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 2, Variables.arc_width, Variables.arc_degree_1, 180);
                //Colours.arc_color(Variables.arc_right_id);
                //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 2, Variables.arc_width, Variables.arc_degree_2, 180);
                Colours.left_color();
                Variables.shapeRenderer.rect(0, Variables.h / 3, (Variables.w * 1 / 100), Variables.h / 3);
                Colours.right_color();
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 3, (Variables.w * 1 / 100) + 20, Variables.h / 3);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                Colours.arc_color(Variables.arc_left_id, "left", 2);
                leftball.setCenter(position_x - ballposition, h / 2);
                leftball.draw(batch);
                Colours.arc_color(Variables.arc_right_id, "right", 2);
                rightball.setCenter(position_x + ballposition, h / 2);
                rightball.draw(batch);
                batch.end();
                Variables.batch.begin();
                if (Variables.times_hit_wall == 0) {

                } else {
                    //drawSprite("gmirror", w / 2, h / 2);
                    Variables.gmirror.setCenter(Variables.w / 2, Variables.h / 2);
                    Variables.gmirror.draw(Variables.batch);
                }
                System.out.println(times_hit_wall);
                //Variables.score_font.setColor(Color.WHITE);
                //Variables.score_font.draw(Variables.batch, Variables.score_string, Others.make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 9) / 10);
                Variables.batch.end();
                if (playerscoreloop == 0) {
                    PrintScore.setDigitScore(score_string);
                }
                PrintScore.printScore(score_string);
                batch.begin();
                //drawSprite("pause", w / 10, (h * 9) / 10);
                pause.setCenter(w / 10, (h * 9) / 10);
                pause.draw(batch);
                batch.end();
                int score_before = Variables.score;
                halfway(reflect, Variables.w);
                MoveBall.change_direction(); // change ball direction
                MoveBall.change_x(); //move ball
                Others.check_hit(); // check to see if colours match when ball contacts wall and add score
                int score_after = Variables.score;
                if (score_after - score_before == 1) {
                    if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                        playServices.unlockAchievement(2, score_after, 0);
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                        iActivityRequestHandler.reportAchievement(2, score_after, 0);
                    }
                    if (score == 999) {
                        screen = 3;
                        waittime = System.currentTimeMillis();
                        eventLoop = 0;
                    }
                    //Colours.Colors();
                }
                achievementActions.achievementProgress();
            }
        }
    }

    public static void halfway(int r, int w) {
        if (Variables.direction == 2) {
            if (Variables.position_x > w / 2 && Variables.position_x < w / 2 + Variables.arc_width) {
                if (r <= 20) {
                    if (!mirrorThrough && type.equalsIgnoreCase("through")) {
                        throughCount++;
                        mirrorThrough = true;
                    }
                } else if (r > 20) {//reflected by mirror
                    Variables.position_x = w / 2 + Variables.arc_width;
                    Colours.Colors();
                    Variables.direction = 1;
                    halfloop = 0;
                    if (type.equalsIgnoreCase("bounce")) {
                        bounceCount++;
                    }
                    if (type.equalsIgnoreCase("match")) {
                        wasReflected = true;
                    }
                }
            }
        } else if (Variables.direction == 1) {
            if (Variables.position_x < w / 2 && Variables.position_x > w / 2 - Variables.arc_width) {
                if (r <= 20) {
                    if (!mirrorThrough && type.equalsIgnoreCase("through")) {
                        throughCount++;
                        mirrorThrough = true;
                    }
                } else if (r > 20) {//reflected by mirror
                    Variables.position_x = w / 2 - Variables.arc_width;
                    Colours.Colors();
                    Variables.direction = 2;
                    halfloop = 0;
                    if (type.equalsIgnoreCase("bounce")) {
                        bounceCount++;
                    }
                    if (type.equalsIgnoreCase("match")) {
                        wasReflected = true;
                    }

                }
            } else {

            }
        }
    }
}
