package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.flyingbrowniegames.ballgame.BallGame.elapsedTime;
import static com.flyingbrowniegames.ballgame.BallGame.gametime;
import static com.flyingbrowniegames.ballgame.BallGame.iActivityRequestHandler;
import static com.flyingbrowniegames.ballgame.BallGame.playServices;
import static com.flyingbrowniegames.ballgame.BallGame.startTime;
import static com.flyingbrowniegames.ballgame.BallGame.timerloop;
import static com.flyingbrowniegames.ballgame.Others.check_hit;
import static com.flyingbrowniegames.ballgame.Others.make_substring;
import static com.flyingbrowniegames.ballgame.Variables.*;

/**
 * Created by kwisk_000 on 2016-05-08.
 */

public class Double {
    //public static Sprite namesprite = sprites.get((("double_name.png")));
    public static int position_x2 = Variables.w / 2;
    public static int arc_degree12 = 90;
    public static int arc_degree22 = 270;
    public static int arc_left_id2 = 6;
    public static int arc_right_id2 = 7;
    public static int right_id2 = 6;
    public static int left_id2 = 7;
    public static int direction2;
    public static int ballposition2 = w / 22;

    public static void set_screen() {
        Variables.speed_increase = 5;
        Variables.mode = 5;
        Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
        Variables.batch.begin();
        Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_left_id);
        //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 3, Variables.arc_width, Variables.arc_degree_1, 180);
        //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_right_id);
        //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 3, Variables.arc_width, Variables.arc_degree_2, 180);
        com.flyingbrowniegames.ballgame.Colours.left_color();
        Variables.shapeRenderer.rect(0, Variables.h / 4, (Variables.w * 1 / 100), Variables.h / 4);
        com.flyingbrowniegames.ballgame.Colours.right_color();
        Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 4, (Variables.w * 1 / 100) + 20, Variables.h / 4);
        Variables.shapeRenderer.end();
        Variables.score_font.setColor(Color.WHITE);
        Variables.score_font.draw(Variables.batch, Variables.score_string, make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 9) / 10);
        Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);//upper ball
        //com.flyingbrowniegames.ballgame.ColoursDouble.arc_color(arc_left_id2);
        //Variables.shapeRenderer.arc(position_x2, (2 * Variables.h) / 3, Variables.arc_width, arc_degree12, 180);
        //com.flyingbrowniegames.ballgame.ColoursDouble.arc_color(arc_right_id2);
        //Variables.shapeRenderer.arc(position_x2, (2 * Variables.h) / 3, Variables.arc_width, arc_degree22, 180);
        com.flyingbrowniegames.ballgame.ColoursDouble.left_color();
        Variables.shapeRenderer.rect(0, Variables.h / 2, (Variables.w * 1 / 100), Variables.h / 4);
        com.flyingbrowniegames.ballgame.ColoursDouble.right_color();
        Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 2, (Variables.w * 1 / 100) + 20, Variables.h / 4);
        Variables.shapeRenderer.end();
        Variables.batch.end();
        Variables.batch.begin();
        doublenamme.setCenter(Variables.w / 2, (Variables.h * 8) / 9);
        doublenamme.draw(Variables.batch);
        Variables.sprite4.setCenter(Variables.w / 2, (Variables.h * 5) / 6);
        Variables.sprite4.draw(Variables.batch);
        Variables.batch.end();
        batch.begin();
        //ball.setCenter(w / 2, (h * 3) / 8);
        //ball.draw(batch);
        //ball2.setCenter(w / 2, (h * 5) / 8);
        //ball2.draw(batch);
        Colours.arc_color(Variables.arc_left_id, "left", 4);
        leftball.setCenter(position_x - ballposition, (h * 3) / 8);
        leftball.draw(batch);
        Colours.arc_color(Variables.arc_right_id, "right", 4);
        rightball.setCenter(position_x + ballposition, (h * 3) / 8);
        rightball.draw(batch);
        batch.end();
        batch.begin();
        Colours.arc_color(arc_left_id2, "left2", 4);
        secondleftball.setCenter(position_x2 - ballposition2, (h * 5) / 8);
        secondleftball.draw(batch);
        Colours.arc_color(arc_right_id2, "right2", 4);
        secondrightball.setCenter(position_x2 + ballposition2, (h * 5) / 8);
        secondrightball.draw(batch);
        batch.end();
        //ball.rotate(1);
        //ball2.rotate(1);
        batch.begin();
        if (doubleCompleted.getInteger("doubleCompleted") != 25) {
            achievementBoard.setCenter(w / 2, ((h * 7) / 48));
            achievementBoard.draw(batch);
            if (doubleCompleted.getInteger("doubleCompleted") == 24) {
                fastforwardButton.setCenter((w * 1) / 2, ((h * 7) / 48) - (achievementBoard.getBoundingRectangle().getHeight() / 2));
                fastforwardButton.draw(batch);
            } else {
                randomizeButton.setCenter(w / 3, ((h * 7) / 48) - (achievementBoard.getBoundingRectangle().getHeight() / 2));
                randomizeButton.draw(batch);
                fastforwardButton.setCenter((w * 2) / 3, ((h * 7) / 48) - (achievementBoard.getBoundingRectangle().getHeight() / 2));
                fastforwardButton.draw(batch);
            }
            achievementFont.draw(batch, glyphLayout, (w - glyphLayout.width) / 2, (((h * 8) / 48)) + (glyphLayout.height / 2));
            progressBox.setCenter(w / 2, ((h * 7) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) + (progressBox.getBoundingRectangle().getHeight() / 2));
            progressBox.draw(batch);
            progressFont.draw(batch, progressLayout, (w / 2) - (progressLayout.width / 2),
                    (((h * 7) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) +
                            (progressBox.getBoundingRectangle().getHeight() / 2)) + (progressLayout.height / 2));
        } else {
            achievementBoard.setCenter(w / 2, ((h * 7) / 48));
            achievementBoard.draw(batch);
            achievementFont.draw(batch, glyphLayout, (w - glyphLayout.width) / 2, (((h * 8) / 48)) + (glyphLayout.height / 2));
            progressBox.setCenter(w / 2, ((h * 7) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) + (progressBox.getBoundingRectangle().getHeight() / 2));
            progressBox.draw(batch);
            progressFont.draw(batch, progressLayout, (w / 2) - (progressLayout.width / 2),
                    (((h * 7) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) +
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
            //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
            batch.begin();
            duopausehowto.setCenter((w * 3) / 4, h / 2);
            duopausehowto.draw(batch);
            duopausehome.setCenter(w / 4, h / 2);
            duopausehome.draw(batch);
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
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_left_id);
                //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 3, Variables.arc_width, Variables.arc_degree_1, 180);
                //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_right_id);
                //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 3, Variables.arc_width, Variables.arc_degree_2, 180);
                com.flyingbrowniegames.ballgame.Colours.left_color();
                Variables.shapeRenderer.rect(0, Variables.h / 4, (Variables.w * 1 / 100), Variables.h / 4);
                com.flyingbrowniegames.ballgame.Colours.right_color();
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 4, (Variables.w * 1 / 100) + 20, Variables.h / 4);
                Variables.shapeRenderer.end();
                Variables.score_font.setColor(Color.WHITE);
                Variables.score_font.draw(Variables.batch, Variables.score_string, make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 9) / 10);
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);//upper ball
                //com.flyingbrowniegames.ballgame.ColoursDouble.arc_color(arc_left_id2);
                //Variables.shapeRenderer.arc(position_x2, (2 * Variables.h) / 3, Variables.arc_width, arc_degree12, 180);
                //com.flyingbrowniegames.ballgame.ColoursDouble.arc_color(arc_right_id2);
                //Variables.shapeRenderer.arc(position_x2, (2 * Variables.h) / 3, Variables.arc_width, arc_degree22, 180);
                com.flyingbrowniegames.ballgame.ColoursDouble.left_color();
                Variables.shapeRenderer.rect(0, Variables.h / 2, (Variables.w * 1 / 100), Variables.h / 4);
                com.flyingbrowniegames.ballgame.ColoursDouble.right_color();
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 2, (Variables.w * 1 / 100) + 20, Variables.h / 4);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                Colours.arc_color(Variables.arc_left_id, "left", 4);
                leftball.setCenter(position_x - ballposition, (h * 3) / 8);
                leftball.draw(batch);
                Colours.arc_color(Variables.arc_right_id, "right", 4);
                rightball.setCenter(position_x + ballposition, (h * 3) / 8);
                rightball.draw(batch);
                batch.end();
                batch.begin();
                Colours.arc_color(arc_left_id2, "left2", 4);
                secondleftball.setCenter(position_x2 - ballposition2, (h * 5) / 8);
                secondleftball.draw(batch);
                Colours.arc_color(arc_right_id2, "right2", 4);
                secondrightball.setCenter(position_x2 + ballposition2, (h * 5) / 8);
                secondrightball.draw(batch);
                batch.end();
                batch.begin();
                if (System.currentTimeMillis() - pausetime <= 1000) {
                    countthree.setCenter(w / 2, h / 2);
                    countthree.draw(batch);
                } else if ((System.currentTimeMillis() - pausetime > 1000) && (System.currentTimeMillis() - pausetime <= 2000)) {
                    counttwo.setCenter(w / 2, h / 2);
                    counttwo.draw(batch);
                } else {
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
                com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_left_id);
                //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 3, Variables.arc_width, Variables.arc_degree_1, 180);
                //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_right_id);
                //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 3, Variables.arc_width, Variables.arc_degree_2, 180);
                com.flyingbrowniegames.ballgame.Colours.left_color();
                Variables.shapeRenderer.rect(0, Variables.h / 4, (Variables.w * 1 / 100), Variables.h / 4);
                com.flyingbrowniegames.ballgame.Colours.right_color();
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 4, (Variables.w * 1 / 100) + 20, Variables.h / 4);
                Variables.shapeRenderer.end();
                Variables.score_font.setColor(Color.WHITE);
                Variables.score_font.draw(Variables.batch, Variables.score_string, make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 9) / 10);
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);//upper ball
                //com.flyingbrowniegames.ballgame.ColoursDouble.arc_color(arc_left_id2);
                //Variables.shapeRenderer.arc(position_x2, (2 * Variables.h) / 3, Variables.arc_width, arc_degree12, 180);
                //com.flyingbrowniegames.ballgame.ColoursDouble.arc_color(arc_right_id2);
                //Variables.shapeRenderer.arc(position_x2, (2 * Variables.h) / 3, Variables.arc_width, arc_degree22, 180);
                com.flyingbrowniegames.ballgame.ColoursDouble.left_color();
                Variables.shapeRenderer.rect(0, Variables.h / 2, (Variables.w * 1 / 100), Variables.h / 4);
                com.flyingbrowniegames.ballgame.ColoursDouble.right_color();
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 2, (Variables.w * 1 / 100) + 20, Variables.h / 4);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                //Variables.batch.begin();
                //Variables.score_font.setColor(Color.WHITE);
                //Variables.score_font.draw(Variables.batch, Variables.score_string, make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 9) / 10);
                //Variables.batch.end();
                if (playerscoreloop == 0) {
                    PrintScore.setDigitScore(score_string);
                }
                PrintScore.printScore(score_string);
                batch.begin();
                pause.setCenter(w / 10, (h * 9) / 10);
                pause.draw(batch);
                batch.end();
                batch.begin();
                Colours.arc_color(Variables.arc_left_id, "left", 4);
                leftball.setCenter(position_x - ballposition, (h * 3) / 8);
                leftball.draw(batch);
                Colours.arc_color(Variables.arc_right_id, "right", 4);
                rightball.setCenter(position_x + ballposition, (h * 3) / 8);
                rightball.draw(batch);
                batch.end();
                batch.begin();
                Colours.arc_color(arc_left_id2, "left2", 4);
                secondleftball.setCenter(position_x2 - ballposition2, (h * 5) / 8);
                secondleftball.draw(batch);
                Colours.arc_color(arc_right_id2, "right2", 4);
                secondrightball.setCenter(position_x2 + ballposition2, (h * 5) / 8);
                secondrightball.draw(batch);
                batch.end();
                int score_before = Variables.score;
                finishedBefore = finishedScore;
                com.flyingbrowniegames.ballgame.MoveBall.change_direction(); // change ball direction
                com.flyingbrowniegames.ballgame.MoveBall.change_x(); //move ball
                check_hit(); // check to see if colours match when ball contacts wall and add score
                if (type.equalsIgnoreCase("colourmatch")) {
                    if (doubleColour == 0) {

                    } else {
                        if (doubleColour2 == 0) {

                        } else {
                            System.out.println("doubleColour" + doubleColour);
                            System.out.println("doubleColour2" + doubleColour2);
                            System.out.println("arc_right_id" + arc_right_id);
                            System.out.println("arc_left_id" + arc_left_id);
                            System.out.println("arc_left_id2" + arc_left_id2);
                            System.out.println("arc_right_id2" + arc_right_id2);


                            if (doubleColour == doubleColour2) {
                                achievementActions.completeAchievement(5, doubleCurrent.getInteger("doubleCurrent"));
                            } else {
                                doubleColour = 0;
                                doubleColour2 = 0;
                            }
                        }
                    }
                }
                int score_after = Variables.score;
                if (score_after - score_before == 2) {
                    if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                        playServices.unlockAchievement(5, score_after, 0);
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                        iActivityRequestHandler.reportAchievement(5, score_after, 0);
                    }
                    if (score == 1000) {
                        screen = 3;
                        waittime = System.currentTimeMillis();
                        eventLoop = 0;
                    }
//                    com.flyingbrowniegames.ballgame.Colours.Colors();
//                    com.flyingbrowniegames.ballgame.ColoursDouble.Colors();
                } else {
                    Variables.score = score_before;
                    if (type.equalsIgnoreCase("finished") || type.equalsIgnoreCase("score")) {
                        finishedScore = finishedBefore;
                    }
                }
                // System.out.println("arc_left_id: " + arc_left_id2 + " left_id2 " + left_id2);
                //System.out.println("arc_right_id " + arc_right_id2 + " rightid2 " + right_id2);
                achievementActions.achievementProgress();
            }
        }
    }


}
