package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.io.IOException;

import static com.flyingbrowniegames.ballgame.BallGame.elapsedTime;
import static com.flyingbrowniegames.ballgame.BallGame.gametime;
import static com.flyingbrowniegames.ballgame.BallGame.iActivityRequestHandler;
import static com.flyingbrowniegames.ballgame.BallGame.playServices;
import static com.flyingbrowniegames.ballgame.BallGame.startTime;
import static com.flyingbrowniegames.ballgame.BallGame.timerloop;
import static com.flyingbrowniegames.ballgame.DeathScorePrint.dloop;
import static com.flyingbrowniegames.ballgame.Others.check_hit;
import static com.flyingbrowniegames.ballgame.Variables.achievementBoard;
import static com.flyingbrowniegames.ballgame.Variables.achievementFont;
import static com.flyingbrowniegames.ballgame.Variables.achievementStartTime;
import static com.flyingbrowniegames.ballgame.Variables.achievementTime;
import static com.flyingbrowniegames.ballgame.Variables.arc_degree_1;
import static com.flyingbrowniegames.ballgame.Variables.arc_degree_2;
import static com.flyingbrowniegames.ballgame.Variables.ball;
import static com.flyingbrowniegames.ballgame.Variables.ballposition;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.classicCompleted;
import static com.flyingbrowniegames.ballgame.Variables.companyLogo;
import static com.flyingbrowniegames.ballgame.Variables.companyName;
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
import static com.flyingbrowniegames.ballgame.Variables.leftball;
import static com.flyingbrowniegames.ballgame.Variables.mode;
import static com.flyingbrowniegames.ballgame.Variables.openAchievement;
import static com.flyingbrowniegames.ballgame.Variables.openShop;
import static com.flyingbrowniegames.ballgame.Variables.openStore;
import static com.flyingbrowniegames.ballgame.Variables.pause;
import static com.flyingbrowniegames.ballgame.Variables.pausetime;
import static com.flyingbrowniegames.ballgame.Variables.playerscoreloop;
import static com.flyingbrowniegames.ballgame.Variables.position_x;
import static com.flyingbrowniegames.ballgame.Variables.progressBox;
import static com.flyingbrowniegames.ballgame.Variables.progressFont;
import static com.flyingbrowniegames.ballgame.Variables.progressLayout;
import static com.flyingbrowniegames.ballgame.Variables.randomizeButton;
import static com.flyingbrowniegames.ballgame.Variables.reflection;
import static com.flyingbrowniegames.ballgame.Variables.rightball;
import static com.flyingbrowniegames.ballgame.Variables.score;
import static com.flyingbrowniegames.ballgame.Variables.score_string;
import static com.flyingbrowniegames.ballgame.Variables.screen;
import static com.flyingbrowniegames.ballgame.Variables.screenLoop;
import static com.flyingbrowniegames.ballgame.Variables.showBanner;
import static com.flyingbrowniegames.ballgame.Variables.tutorial1;
import static com.flyingbrowniegames.ballgame.Variables.tutorial2;
import static com.flyingbrowniegames.ballgame.Variables.tutorial3;
import static com.flyingbrowniegames.ballgame.Variables.tutorial4;
import static com.flyingbrowniegames.ballgame.Variables.tutorial5;
import static com.flyingbrowniegames.ballgame.Variables.tutorial6;
import static com.flyingbrowniegames.ballgame.Variables.tutorial7;
import static com.flyingbrowniegames.ballgame.Variables.tutorial8;
import static com.flyingbrowniegames.ballgame.Variables.type;
import static com.flyingbrowniegames.ballgame.Variables.w;
import static com.flyingbrowniegames.ballgame.Variables.waittime;
import static com.flyingbrowniegames.ballgame.Variables.yloop;
import static com.flyingbrowniegames.ballgame.Variables.zero_to_one;

/**
 * Created by kwisk_000 on 2016-04-25.
 */
public class SwitchScreens {
    public static int twotoone = 0;

    public static void switchScreens() {
        switch (Variables.screen) {
            case 0: // "loading screen" with logo
                Gdx.gl.glClearColor(0, 0, 0, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                screen_switcher();
                break;
            case 1: //main screen
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Main Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Main Screen");
                    screenLoop = 1;
                }
                //rotateSprite("sprite4", 0);
                Variables.sprite4.setRotation(0);
                Variables.speed_increase = 10;
                Variables.times_hit_wall = 0;
                Variables.highscore_reach = false;
                com.flyingbrowniegames.ballgame.ResetScreens.start_screen_display();
                arc_degree_1++;
                arc_degree_2++;

                break;
            case 2: //classic game screen
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Classic Mode Play Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Classic Mode Play Screen");
                    screenLoop = 1;
                }
                Variables.mode = 1;
                if (tutorial1.getInteger("1") == 0) {
                    screen = 25;
                } else {
                    Variables.speed_increase = 5;
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
                        //leftball.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                        //rightball.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                        batch.begin();
                        // drawSprite("duopausehowto", (w * 3) / 4, h / 2);
                        //drawSprite("duopausehome", w / 4, h / 2);
                        //drawSprite("duopauseresume", w / 2, h / 2);
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
                            //leftball.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                            //rightball.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                            // batch.begin();
                            //Variables.score_font.setColor(Color.WHITE);
                            // Variables.score_font.draw(Variables.batch, Variables.score_string, Others.make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 9) / 10);
                            //batch.end();
                            if (playerscoreloop == 0) {
                                PrintScore.setDigitScore(score_string);
                            }
                            PrintScore.printScore(score_string);
                            batch.begin();
                            Colours.arc_color(Variables.arc_left_id, "left", 2);
                            //drawSprite("leftball", position_x - ballposition, h / 2);
                            leftball.setCenter(position_x - ballposition, h / 2);
                            leftball.draw(batch);
                            Colours.arc_color(Variables.arc_right_id, "right", 2);
                            //drawSprite("rightball", position_x + ballposition, h / 2);
                            rightball.setCenter(position_x + ballposition, h / 2);
                            rightball.draw(batch);
                            batch.end();
                            //BallSprites.drawSprite();
                            batch.begin();
                            Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                            // Colours.arc_color(Variables.arc_left_id);
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
                            if (System.currentTimeMillis() - pausetime <= 1000) {
                                // drawSprite("countthree", w / 2, h / 2);
                                countthree.setCenter(w / 2, h / 2);
                                countthree.draw(batch);
                            } else if ((System.currentTimeMillis() - pausetime > 1000) && (System.currentTimeMillis() - pausetime <= 2000)) {
                                //drawSprite("counttwo", w / 2, h / 2);
                                counttwo.setCenter(w / 2, h / 2);
                                counttwo.draw(batch);
                            } else {
                                //drawSprite("countone", w / 2, h / 2);
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
                            //leftball.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                            //rightball.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                            Variables.batch.begin();
                            Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                            //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_left_id);
                            // Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 2, Variables.arc_width, Variables.arc_degree_1, 180);
                            // com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_right_id);
                            //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 2, Variables.arc_width, Variables.arc_degree_2, 180);
                            com.flyingbrowniegames.ballgame.Colours.left_color();
                            Variables.shapeRenderer.rect(0, Variables.h / 3, (Variables.w * 1 / 100), Variables.h / 3);
                            com.flyingbrowniegames.ballgame.Colours.right_color();
                            Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 3, (Variables.w * 1 / 100) + 20, Variables.h / 3);
                            Variables.shapeRenderer.end();
                            Variables.batch.end();
                            batch.begin();
                            Colours.arc_color(Variables.arc_left_id, "left", 2);
                            //drawSprite("leftball", position_x - ballposition, h / 2);
                            leftball.setCenter(position_x - ballposition, h / 2);
                            leftball.draw(batch);
                            //com.flyingbrowniegames.ballgame.MoveBall.change_x(); //move ball
                            Colours.arc_color(Variables.arc_right_id, "right", 2);
                            //drawSprite("rightball", position_x + ballposition, h / 2);
                            rightball.setCenter(position_x + ballposition, h / 2);
                            //System.out.println(arc_right_id + " arc-right-id");
                            //System.out.println("rightflipped: " + rightball.isFlipX());
                            rightball.draw(batch);
                            batch.end();
                            // Variables.batch.begin();
                            //Variables.score_font.setColor(Color.WHITE);
                            //Variables.score_font.draw(Variables.batch, Variables.score_string, make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 9) / 10);
                            //Variables.batch.end();
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
                            com.flyingbrowniegames.ballgame.MoveBall.change_direction(); // change ball direction
                            com.flyingbrowniegames.ballgame.MoveBall.change_x(); //move ball
                            check_hit(); // check to see if colours match when ball contacts wall and add score
                            int score_after = Variables.score;

                            if (score_after - score_before == 1) {
                                if (score == 999) {
                                    screen = 3;
                                    waittime = System.currentTimeMillis();
                                    eventLoop = 0;
                                }
                                //com.flyingbrowniegames.ballgame.Colours.Colors();
                                if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                                    playServices.unlockAchievement(1, score_after, 0);
                                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                                    iActivityRequestHandler.reportAchievement(1, score_after, 0);
                                }
                            }
                            achievementActions.achievementProgress();

                        }
                    }
                }

                break;
            case 3: //Death screen
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Death Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Death Screen");
                    screenLoop = 1;
                }
                com.flyingbrowniegames.ballgame.ResetScreens.death_reset();
                if (Variables.zero_to_three <= 50) {
                    Variables.zero_to_three++;
                    //System.out.println(Variables.zero_to_three);
                } else if (Variables.zero_to_three > 50) {
                    com.flyingbrowniegames.ballgame.ResetScreens.death_reset();
                    //rotateSprite("ball", 0);
                    ball.setRotation(0);

                }
                //achievementActions.achievementProgress();
                break;

            case 6: //settings screen
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Settings Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Settings Screen");
                    screenLoop = 1;
                }
                SettingsScreen.setScreen();

                break;
            case 7: //games modes screen
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Game Modes Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Game Modes Screen");
                    screenLoop = 1;
                }
                com.flyingbrowniegames.ballgame.ModeScreen.setScreen();
                break;
            case 8: //mode 2 : mirror start
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Mirror Mode Start Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Mirror Mode Start Screen");
                    screenLoop = 1;
                }
                Variables.mode = 2;
                Variables.speed_increase = 20;
                if (tutorial2.getInteger("2") == 0) {
                    screen = 25;
                } else {
                    com.flyingbrowniegames.ballgame.Mirror.set_screen();
                }
                break;
            case 9: //mode 3: color blind
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Blind Mode Start Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Blind Mode Start Screen");
                    screenLoop = 1;
                }
                Variables.mode = 3;
                Variables.speed_increase = 5;
                if (tutorial3.getInteger("3") == 0) {
                    screen = 25;
                } else {
                    Blind.set_screen();
                }
                break;
            case 10: //mode 4: burst start
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Burst Mode Start Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Burst Mode Start Screen");
                    screenLoop = 1;
                }
                Variables.mode = 4;
                if (tutorial4.getInteger("4") == 0) {
                    screen = 25;
                } else {
                    com.flyingbrowniegames.ballgame.Burst.set_screen();
                }
                break;
            case 11: // mode 5 :double start'
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Double Mode Start Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Double Mode Start Screen");
                    screenLoop = 1;
                }
                Variables.mode = 5;
                Variables.speed_increase = 7;
                if (tutorial5.getInteger("5") == 0) {
                    screen = 25;
                } else {
                    Double.set_screen();
                }
                break;
            case 12: // mode 6: extreme start
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Extreme Mode Start Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Extreme Mode Start Screen");
                    screenLoop = 1;
                }
                Variables.mode = 6;
                if (tutorial6.getInteger("6") == 0) {
                    screen = 25;
                } else {
                    com.flyingbrowniegames.ballgame.Extreme.set_screen(Variables.balls);
                }
                break;
            case 13: //mode 7: extreme flip start
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Extreme Flip Start Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Extreme Flip Start Screen");
                    screenLoop = 1;
                }
                Variables.mode = 7;
                if (tutorial7.getInteger("7") == 0) {
                    screen = 25;
                } else {
                    com.flyingbrowniegames.ballgame.ExtremeFlip.set_screen();
                }
                break;
            case 14: // mode 8: duo(2 player) start
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Duo Mode Start Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Duo Mode Start Screen");
                    screenLoop = 1;
                }
                Variables.mode = 8;
                if (tutorial8.getInteger("8") == 0) {
                    screen = 25;
                } else {
                    Duo.set_screen();
                }
                break;
            case 15: //mode 2: play
                // Variables.speed_increase =20;
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Mirror Mode Play Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Mirror Mode Play Screen");
                    screenLoop = 1;
                }
                com.flyingbrowniegames.ballgame.Mirror.play_screen();
                break;
            case 16: //mode 3:play
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Blind Mode Play Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Blind Mode Play Screen");
                    screenLoop = 1;
                }
                Blind.play_screen();
                break;
            case 17: //mode 4 : play
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Burst Mode Play Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Burst Mode Play Screen");
                    screenLoop = 1;
                }
                com.flyingbrowniegames.ballgame.Burst.play_screen();
                break;
            case 18: //mode 5: play
                // Variables.speed_increase =5;
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Double Mode Play Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Double Mode Play Screen");
                    screenLoop = 1;
                }
                Double.play_screen();
                break;
            case 19: //mode 6: play
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Extreme Mode Play Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Extreme Mode Play Screen");
                    screenLoop = 1;
                }
                com.flyingbrowniegames.ballgame.Extreme.play_screen();
                break;
            case 20: //mode 7: play
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Extreme Flip Play Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Extreme Flip Play Screen");
                    screenLoop = 1;
                }
                com.flyingbrowniegames.ballgame.ExtremeFlip.play_screen();
                break;
            case 21: //mode 8: play
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Duo Mode Play Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Duo Mode PLay Screen");
                    screenLoop = 1;
                }
                Duo.play_screen();
                break;
            case 22: //Extreme mode screen
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Extreme Mode Selection Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Extreme Mode Selection Screen");
                    screenLoop = 1;
                }
                com.flyingbrowniegames.ballgame.Extreme.set_mode_screen();
                break;
            case 23://stats screen
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Stats Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Stats Screen");
                    screenLoop = 1;
                }
                statscreen.setScreen();
                break;
            case 24://classic start screen mode 1
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Classic Mode Start Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Classic Mode Start Screen");
                    screenLoop = 1;
                }
                Variables.mode = 1;
                if (tutorial1.getInteger("1") == 0) {
                    screen = 25;
                } else {
                    Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
                    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                    Variables.batch.begin();
                    Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                    //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_left_id);
                    //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 2, Variables.arc_width, Variables.arc_degree_1, 180);
                    //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_right_id);
                    //Variables.shapeRenderer.arc(Variables.position_x, Variables.h / 2, Variables.arc_width, Variables.arc_degree_2, 180);
                    com.flyingbrowniegames.ballgame.Colours.left_color();
                    Variables.shapeRenderer.rect(0, Variables.h / 3, (Variables.w * 1 / 100), Variables.h / 3);
                    com.flyingbrowniegames.ballgame.Colours.right_color();
                    Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), Variables.h / 3, (Variables.w * 1 / 100) + 20, Variables.h / 3);
                    Variables.shapeRenderer.end();
                    Variables.batch.end();
                    Variables.batch.begin();
                    //drawSprite("reflection", w / 2, (h * 8) / 9);
                    //drawSprite("sprite4", Variables.w / 2, (Variables.h * 9) / 12);
                    //Variables.game_name.setCenter(Variables.w / 2, (Variables.h * 8) / 9);
                    //Variables.game_name.draw(Variables.batch);
                    reflection.setCenter(w / 2, (h * 8) / 9);
                    reflection.draw(batch);
                    Variables.sprite4.setCenter(Variables.w / 2, (Variables.h * 9) / 12);
                    Variables.sprite4.draw(Variables.batch);
                    //arc_degree_1++;
                    //arc_degree_2++;
                    Variables.batch.end();
                    /*batch.begin();
                    Colours.arc_color(Variables.arc_left_id, "left");
                    leftball.setCenter(position_x - ballposition, h / 2);
                    leftball.draw(batch);
                    Colours.arc_color(Variables.arc_right_id, "right");
                    rightball.setCenter(position_x + ballposition, h / 2);
                    rightball.draw(batch);
                    batch.end();*/
                    batch.begin();
                    //drawSprite("ball", w / 2, h / 2);
                    ball.setCenter(w / 2, h / 2);
                    ball.draw(batch);
                    batch.end();
                    //rotateSprite("ball", 0);
                    ball.rotate(1);
                    batch.begin();
                    if (classicCompleted.getInteger("classicCompleted") != 25) {
                        achievementBoard.setCenter(w / 2, ((h * 9) / 48));
                        achievementBoard.draw(batch);
                        if (classicCompleted.getInteger("classicCompleted") == 24) {
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
                break;
            case 25: //tutorial screen
                if (Gdx.app.getType() == Application.ApplicationType.Android && screenLoop == 0) {
                    BallGame.adsController.screenView("Tutorial Screen");
                    screenLoop = 1;
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && screenLoop == 0) {
                    BallGame.iActivityRequestHandler.screenView("Tutorial Screen");
                    screenLoop = 1;
                }
                TutorialScreen.screen();
                break;
            case 26: //test ball flip screen
                Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                batch.begin();
                Colours.arc_color(Variables.arc_left_id, "left", 2);
                //drawSprite("leftball", position_x - ballposition, h / 2);
                leftball.setCenter(position_x - ballposition, h / 2);
                leftball.draw(batch);
                //com.flyingbrowniegames.ballgame.MoveBall.change_x(); //move ball
                Colours.arc_color(Variables.arc_right_id, "right", 2);
                //drawSprite("rightball", position_x + ballposition, h / 2);
                rightball.setCenter(position_x + ballposition, h / 2);
                //System.out.println(arc_right_id + " arc-right-id");
                //System.out.println("rightflipped: " + rightball.isFlipX());
                rightball.draw(batch);
                batch.end();
                break;
            case 27: //new mode screen
                newModeScreen.screenDisplay();
                break;
            default:
                break;
        }
        if (screen != 7) {
            yloop = false;
        }
        if (screen != 3) {
            dloop = true;
        }
        if (openAchievement) {
            achievementScreen.displayScreen();
        }
        if (openStore) {
            storeScreen.displayStore();
        }
        if (openShop) {
            ShopScreen.displayShop();
        }
    }

    public static void screen_switcher() {
        switch (Variables.screen) {
            case 0:
                if (Variables.zero_to_one > 100) {
                    if (twotoone > 100) {
                        Variables.screen = 1;
                    } else {
                        Variables.batch.begin();
                        //drawSprite("logo", w / 2, h / 2);
                        companyLogo.setCenter(Variables.w / 2, Variables.h / 2);
                        companyLogo.draw(Variables.batch);
                        Variables.batch.end();
                        twotoone++;

                    }
                } else {
                    batch.begin();
                    companyName.setCenter(Variables.w / 2, Variables.h / 2);
                    companyName.draw(Variables.batch);
                    //("companyname", w / 2, h / 2);
                    batch.end();
                    zero_to_one++;
                }
                break;
            case 1:
                com.flyingbrowniegames.ballgame.ResetScreens.resetVariables();
                Variables.screen = 2;
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    public static void displayLogo() {


    }

    public static void displayName() {
        //Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //BallGame.batch.begin();
        //companyName.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        //companyName.draw(BallGame.batch);
        //BallGame.batch.end();
    }


}
