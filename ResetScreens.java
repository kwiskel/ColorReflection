package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.I18NBundle;

import static com.flyingbrowniegames.ballgame.BallGame.adsController;
import static com.flyingbrowniegames.ballgame.BallGame.elapsedTime;
import static com.flyingbrowniegames.ballgame.BallGame.fives;
import static com.flyingbrowniegames.ballgame.BallGame.games_before;
import static com.flyingbrowniegames.ballgame.BallGame.gametime;
import static com.flyingbrowniegames.ballgame.BallGame.iActivityRequestHandler;
import static com.flyingbrowniegames.ballgame.BallGame.isLoaded;
import static com.flyingbrowniegames.ballgame.BallGame.playServices;
import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.BallGame.startTime;
import static com.flyingbrowniegames.ballgame.BallGame.timerloop;
import static com.flyingbrowniegames.ballgame.Duo.ballposition2;
import static com.flyingbrowniegames.ballgame.Extreme.arcdegrees;
import static com.flyingbrowniegames.ballgame.Extreme.ballpositions;
import static com.flyingbrowniegames.ballgame.Extreme.balls1;
import static com.flyingbrowniegames.ballgame.Variables.*;
import static com.flyingbrowniegames.ballgame.Variables.doubleCurrent;
import static com.flyingbrowniegames.ballgame.Variables.doubleCurrentProgress;

/**
 * Created by kwisk_000 on 2016-04-25.
 */

public class ResetScreens {
    public static int count = 2;
    public static boolean loop = true;

    public static void start_screen_display() {
        resetVariables();
        screen_reset();

    }

    public static void screen_reset() {
        Accelerometer.moveBall();
        Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        moneyBox.setCenter(w / 10, (h * 17) / 24);
        moneyBox.draw(batch);
        goldenBrownie.setCenter(w / 20, (h * 17) / 24);
        goldenBrownie.draw(batch);
        shopIcon.setCenter((w * 9) / 10, (h * 17) / 24);
        shopIcon.draw(batch);
        batch.end();
        batch.begin();
        achievementFont.draw(batch, moneyLayout, (w / 10), ((h * 17) / 24) + (moneyLayout.height / 2));
        batch.end();
        Variables.batch.begin();
        Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        Colours.left_color();
        Variables.shapeRenderer.rect(0, h / 3, (Variables.w * 1 / 100), h / 3);
        Colours.right_color();
        Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), h / 3, (Variables.w * 1 / 100), h / 3);
        Variables.shapeRenderer.end();
        Variables.batch.end();
        Variables.batch.begin();
        //drawSprite("reflection", w / 2, (h * 8) / 9);
        //blackStar1.setCenter((w * 1) / 7, (h * 79) / 84);
        if (classicCompleted.getInteger("classicCompleted") == 25) {
            goldstar1.setCenter((w * 1) / 6, h - ((w * 3) / 42) - ((h * 2) / 84));
            goldstar1.draw(batch);
        } else {
            blackStar1.setCenter((w * 1) / 6, h - ((w * 3) / 42) - ((h * 2) / 84));
            blackStar1.draw(batch);
        }
        //goldstar1.setCenter((w * 1) / 7, h - ((w * 3) / 42) - ((h * 2) / 84));
        //goldstar1.draw(batch);
        //blackStar2.setCenter((w * 2) / 7, (h * 80) / 84);
        if (mirrorCompleted.getInteger("mirrorCompleted") == 25) {
            goldstar2.setCenter((w * 2) / 6, h - ((w * 3) / 42) - (h / 84));
            goldstar2.draw(batch);
        } else {
            blackStar2.setCenter((w * 2) / 6, h - ((w * 3) / 42) - (h / 84));
            blackStar2.draw(batch);
        }
        //goldstar2.setCenter((w * 2) / 7, h - ((w * 3) / 42) - (h / 84));
        //goldstar2.draw(batch);
        //blackStar3.setCenter((w * 3) / 7, (h * 81) / 84);
        if (blindCompleted.getInteger("blindCompleted") == 25) {
            goldstar3.setCenter((w * 3) / 6, h - ((w * 3) / 42));
            goldstar3.draw(batch);
        } else {
            blackStar3.setCenter((w * 3) / 6, h - ((w * 3) / 42));
            blackStar3.draw(batch);
        }
        //goldstar3.setCenter((w * 3) / 7, h - ((w * 3) / 42));
        // goldstar3.draw(batch);
        if (burstCompleted.getInteger("burstCompleted") == 25) {
            goldstar4.setCenter((w * 4) / 6, h - ((w * 3) / 42) - (h / 84));
            goldstar4.draw(batch);
        } else {
            blackStar4.setCenter((w * 4) / 6, h - ((w * 3) / 42) - (h / 84));
            blackStar4.draw(batch);
        }
        //goldstar4.setCenter((w * 4) / 7, h - ((w * 3) / 42));
        //goldstar4.draw(batch);
        // blackStar5.setCenter((w * 5) / 7, (h * 80) / 84);
        if (doubleCompleted.getInteger("doubleCompleted") == 25) {
            goldstar5.setCenter((w * 5) / 6, h - ((w * 3) / 42) - ((h * 2) / 84));
            goldstar5.draw(batch);
        } else {
            blackStar5.setCenter((w * 5) / 6, h - ((w * 3) / 42) - ((h * 2) / 84));
            blackStar5.draw(batch);
        }
        //goldstar5.setCenter((w * 5) / 7, h - ((w * 3) / 42) - (h / 84));
        //goldstar5.draw(batch);
        // blackStar6.setCenter((w * 6) / 7, (h * 79) / 84);
        //blackStar6.setCenter((w * 6) / 7, h - ((w * 3) / 42) - ((h * 2) / 84));
        //blackStar6.draw(batch);
        //goldstar6.setCenter((w * 6) / 7, h - ((w * 3) / 42) - ((h * 2) / 84));
        //goldstar6.draw(batch);
        reflection.setCenter(w / 2, (h * 70) / 84);
        reflection.draw(batch);
        Variables.batch.end();
        Variables.batch.begin();
        //drawSprite("play", Variables.w / 2, (h * 9) / 12);
        sprite4.setCenter(Variables.w / 2, (h * 30) / 42); //tap to play
        sprite4.draw(Variables.batch);
        //drawSprite("played", Variables.w / 2, (h / 5) - ((3 * (sprites.get("played").getBoundingRectangle().getHeight())) / 4));
        sprite5.setCenter(Variables.w / 2, (h / 5) - ((3 * sprite5.getBoundingRectangle().getHeight()) / 4)); //games played
        sprite5.draw(Variables.batch);
        //drawSprite("highext", Variables.w / 2, (h / 5) + ((3 * (sprites.get("hightext").getBoundingRectangle().getHeight())) / 4));
        sprite6.setCenter(Variables.w / 2, (h / 5) + ((3 * sprite6.getBoundingRectangle().getHeight()) / 4)); //highscore
        sprite6.draw(Variables.batch);
        //drawSprite("leader", Variables.w / 6, h / 13);
        Variables.leadersprite.setCenter(Variables.w / 6, h / 13);
        Variables.leadersprite.draw(Variables.batch);
        //drawSprite("rate", (2 * Variables.w) / 6, h / 13);
        Variables.ratesprite.setCenter((2 * Variables.w) / 6, h / 13);
        Variables.ratesprite.draw(Variables.batch);
        //drawSprite("like", (3 * Variables.w) / 6, h / 13);
        Variables.likesprite.setCenter((3 * Variables.w) / 6, h / 13);
        Variables.likesprite.draw(Variables.batch);
        //drawSprite("info", (4 * Variables.w) / 6, h / 13);
        Variables.infosprite.setCenter((4 * Variables.w) / 6, h / 13);
        Variables.infosprite.draw(Variables.batch);
        //drawSprite("settings", (5 * Variables.w) / 6, h / 13);
        setting.setCenter((5 * Variables.w) / 6, h / 13);
        setting.draw(Variables.batch);
        //drawSprite("game_modes", Variables.w / 2, h / 3);
        //Variables.modelabel.setCenter(Variables.w / 2, h / 3);
        //Variables.modelabel.draw(Variables.batch);
        gameModeIcon.setCenter(Variables.w / 2, h / 3);
        gameModeIcon.draw(batch);
        //redFireLeft.setCenter(w / 4, h / 3 - (gameModeIcon.getBoundingRectangle().getHeight() / 2));
        //redFireLeft.draw(batch);
        //redFireRight.setCenter((w * 3) / 4, h / 3 - (gameModeIcon.getBoundingRectangle().getHeight() / 2));
        //redFireRight.draw(batch);
        //if (redFireRight.getRotation() >= 45 || redFireRight.getRotation() <= -180) {
        //    fireDirection = fireDirection * -1;
        //}
        //redFireRight.rotate(1 * fireDirection);
        //redFireLeft.rotate(-1 * fireDirection);
        flower1.setCenter(w / 4, h / 3 - (gameModeIcon.getBoundingRectangle().getHeight() / 2));
        flower1.draw(batch);
        flower2.setCenter((w * 3) / 4, h / 3 - (gameModeIcon.getBoundingRectangle().getHeight() / 2));
        flower2.draw(batch);
        Variables.batch.end();
        flower1.rotate(1);
        flower2.rotate(-1);
        if (mainscoreloop == 0) {
            MainScorePrint.setdigitGamesPlayed(String.valueOf(prefs_games.getInteger("games")));
            MainScorePrint.setdigitScore(String.valueOf(prefs_score.getInteger("score")));
        }
        MainScorePrint.printGamesPlayed(String.valueOf(prefs_games.getInteger("games")));
        MainScorePrint.printScore(String.valueOf(prefs_score.getInteger("score")));
        batch.begin();
        //drawSprite("ball", ball_x, ball_y);
        ball.setCenter(ball_x, ball_y);
        ball.draw(batch);
        //batch.end();
        //sprites.get("ball").rotate(1);
        ball.rotate(1);
        //Colours.arc_color(Variables.arc_left_id, "left", 2);
        //batch.setColor(243, 34, 12, 1);

        //leftball.setCenter(position_x - ballposition, h / 2);
        //leftball.draw(batch);
        //rightball.setCenter(position_x + ballposition, h / 2);
        //rightball.draw(batch);
        batch.end();


    }

    public static void death_reset() {
        if (mode != 8)
            com.flyingbrowniegames.ballgame.BallGame.games_elapsed = com.flyingbrowniegames.ballgame.BallGame.games_before + 1;
        adgames = (games_before + 1);
        switch (Variables.mode) {
            case 1:
                Others.check_highscore();
                Variables.prefscore = Variables.prefs_score.getInteger("score");
                if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                    adsController.logEvent("Played Classic Mode");
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                    BallGame.iActivityRequestHandler.logEvent("Played Classic Mode");
                    eventLoop = 1;
                }
                break;
            case 2:
                Others.check_highscore();
                Variables.prefscore = Variables.prefs_score2.getInteger("score");
                if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                    adsController.logEvent("Played Mirror Mode");
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                    BallGame.iActivityRequestHandler.logEvent("Played Mirror Mode");
                    eventLoop = 1;
                }
                break;
            case 3:
                Others.check_highscore();
                Variables.prefscore = Variables.prefs_score3.getInteger("score");
                if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                    adsController.logEvent("Played Blind Mode");
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                    BallGame.iActivityRequestHandler.logEvent("Played Blind Mode");
                    eventLoop = 1;
                }
                break;
            case 4:
                Others.check_highscore();
                Variables.prefscore = Variables.prefs_score4.getInteger("score");
                if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                    adsController.logEvent("Played Burst Mode");
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                    BallGame.iActivityRequestHandler.logEvent("Played Burst Mode");
                    eventLoop = 1;
                }
                break;
            case 5:
                Others.check_highscore();
                Variables.prefscore = Variables.prefs_score5.getInteger("score");
                if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                    adsController.logEvent("Played Double Mode");
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                    BallGame.iActivityRequestHandler.logEvent("Played Double Mode");
                    eventLoop = 1;
                }
                break;
            case 6:
                Others.check_highscore();
                switch (balls1) {
                    case 3:
                        Variables.prefscore = Variables.prefs_score63.getInteger("score");
                        if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                            adsController.logEvent("Played Extreme 3 ball Mode");
                        } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                            BallGame.iActivityRequestHandler.logEvent("Played Extreme 3 ball Mode");
                            eventLoop = 1;
                        }
                        break;
                    case 4:
                        Variables.prefscore = Variables.prefs_score64.getInteger("score");
                        if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                            adsController.logEvent("Played Extreme 4 ball Mode");
                        } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                            BallGame.iActivityRequestHandler.logEvent("Played Extreme 4 ball Mode");
                            eventLoop = 1;
                        }
                        break;
                    case 5:
                        Variables.prefscore = Variables.prefs_score65.getInteger("score");
                        if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                            adsController.logEvent("Played Extreme 5 ball Mode");
                        } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                            BallGame.iActivityRequestHandler.logEvent("Played Extreme 5 ball Mode");
                            eventLoop = 1;
                        }
                        break;
                    case 6:
                        Variables.prefscore = Variables.prefs_score66.getInteger("score");
                        if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                            adsController.logEvent("Played Extreme 6 ball Mode");
                        } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                            BallGame.iActivityRequestHandler.logEvent("Played Extreme 6 ball Mode");
                            eventLoop = 1;
                        }
                        break;
                }
                break;
            case 7:
                Others.check_highscore();
                Variables.prefscore = Variables.prefs_score7.getInteger("score");
                if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                    adsController.logEvent("Played Extreme Flip Mode");
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                    BallGame.iActivityRequestHandler.logEvent("Played Extreme Flip Mode");
                    eventLoop = 1;
                }
                break;

        }
        String text = String.valueOf(Variables.prefscore);
        Others.add_diamonds(1);

        if (Variables.mode == 8) {
            if (Gdx.app.getType() == Application.ApplicationType.Android && eventLoop == 0) {
                adsController.logEvent("Played Duo Mode");
            } else if (Gdx.app.getType() == Application.ApplicationType.iOS && eventLoop == 0) {
                BallGame.iActivityRequestHandler.logEvent("Played Duo Mode");
                eventLoop = 1;
            }
            duogames.clear();
            duogames.putInteger("games", duobefore + 1);
            duogames.flush();
            if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                playServices.unlockAchievement(8, duogames.getInteger("games"), 0);
            } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                iActivityRequestHandler.reportAchievement(8, duogames.getInteger("games"), 0);
            }
            Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            if (Variables.twodead == true && Variables.onedead == false) {//player two dies
                batch.begin();
                duoscore1.clear();
                duoscore1.putInteger("score1", (score1 + 1));
                duoscore1.flush();
                wins.setRotation(180);
                //rotateSprite("wins", 180);
                //drawSprite("wins", Variables.w / 2, (h * 8) / 10);
                wins.setCenter(Variables.w / 2, (h * 8) / 10);
                wins.draw(Variables.batch);
                loses.setRotation(0);
                //rotateSprite("loses", 0);
                //drawSprite("loses", Variables.w / 2, (h * 2) / 10);
                loses.setCenter(Variables.w / 2, (h * 2) / 10);
                loses.draw(batch);
                batch.end();
            } else if (Variables.onedead == true && Variables.twodead == false) { //player one dies
                batch.begin();
                duoscore2.clear();
                duoscore2.putInteger("score2", (score2 + 1));
                duoscore2.flush();
                wins.setRotation(0);
                //rotateSprite("wins", 0);
                //drawSprite("wins", Variables.w / 2, (h * 2) / 10);
                wins.setCenter(Variables.w / 2, (h * 2) / 10);
                wins.draw(Variables.batch);
                //rotateSprite("loses", 180);
                loses.setRotation(180);
                //drawSprite("loses", Variables.w / 2, (h * 8) / 10);
                loses.setCenter(Variables.w / 2, (h * 8) / 10);
                loses.draw(batch);
                batch.end();
            } else if (Variables.onedead && Variables.twodead) { //tie
                batch.begin();
                //drawSprite("tie", Variables.w / 2, (h * 2) / 10);
                Variables.tie.setCenter(Variables.w / 2, (h * 2) / 10);
                Variables.tie.draw(Variables.batch);
                //tie2.setRotation(180);
                tie2.setCenter(w / 2, (h * 8) / 10);
                tie2.draw(batch);
                batch.end();
            }
            batch.begin();
            //drawSprite("replay", (Variables.w / 2), h / 2);
            replaysprite.setCenter((Variables.w / 2), h / 2);
            replaysprite.draw(Variables.batch);
            //drawSprite("dead_home", (1 * Variables.w) / 5, h / 2);
            dhsprite.setCenter((1 * Variables.w) / 5, h / 2);
            dhsprite.draw(Variables.batch);
            //drawSprite("settings", (4 * Variables.w) / 5, h / 2);
            setting.setCenter((4 * Variables.w) / 5, h / 2);
            setting.draw(Variables.batch);
            //sprites.get("settings").rotate(1);
            //sprites.get("replay").rotate(1);
            //sprites.get("sdead_home").rotate(1);
            setting.rotate(1);
            replaysprite.rotate(1);
            dhsprite.rotate(1);
            Variables.batch.end();
        }


        Variables.score_font.setColor(Color.ORANGE);
        if (Variables.mode != 8) {
            Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            //sprites.get("fadedball").setAlpha(0.5f);
            //drawSprite("fadedball", w / 2, (h * 2) / 3);
            fadedball.setAlpha(0.5f);
            fadedball.setCenter(w / 2, (h * 2) / 3);
            fadedball.draw(batch);
            //drawSprite("deathbox", w / 2, (h * 2) / 3);
            deathbox.setCenter(w / 2, (h * 2) / 3);
            deathbox.draw(batch);
            batch.end();
            Variables.batch.begin();

            if (Variables.highscore_reach == true) {
                best_font.setColor(Color.BLACK);
                Variables.score_font.setColor(Color.BLACK);
                //drawSprite("highscore", Variables.w / 2, (h * 6) / 10);
                Variables.sprite9.setCenter(Variables.w / 2, (h * 6) / 10);
                Variables.sprite9.draw(Variables.batch);
                //Variables.score_font.draw(Variables.batch, Variables.score_string, Others.make_substring(Variables.name_font_width, Variables.score_string.length()), (h * 7) / 10);
                DeathScorePrint.print(Variables.score_string);
                //DeathScorePrint.print("1000");

            } else if (Variables.highscore_reach == false) {
                best_font.setColor(Color.BLACK);
                Variables.score_font.setColor(Color.BLACK);
                DeathScorePrint.print2(Variables.score_string, text);

            }
            Variables.batch.end();

            batch.begin();
            //drawSprite("share", (4 * Variables.w) / 5, h / 9);
            Variables.sharesprite.setCenter((4 * Variables.w) / 5, h / 9);
            Variables.sharesprite.draw(Variables.batch);
            //drawSprite("leader2", (2 * Variables.w) / 5, h / 9);
            deathleader.setCenter((2 * Variables.w) / 5, h / 9);
            deathleader.draw(Variables.batch);
            //drawSprite("drate", (3 * Variables.w) / 5, h / 9);
            deathrate.setCenter((3 * Variables.w) / 5, h / 9);
            deathrate.draw(Variables.batch);
            //drawSprite("dead_home", (1 * Variables.w) / 5, h / 9);
            dhsprite.setCenter((1 * Variables.w) / 5, h / 9);
            dhsprite.draw(Variables.batch);
            //if ((mode == 1 || mode == 2 || mode == 3) && Gdx.app.getType() == Application.ApplicationType.Android) {
            //isLoaded();
            //if (BallGame.adsController.isWifiConnected() && BallGame.loaded && restarted == 0) {
            //drawSprite("replay", (Variables.w / 3), (h * 7) / 24);
            //replaysprite.setCenter((Variables.w / 3), (h * 7) / 24);
            //replaysprite.draw(Variables.batch);
            //replaysprite.rotate(0.5f);
            //sprites.get("replay").rotate(0.5f);
            // drawSprite("heart", ((Variables.w * 2) / 3), (h * 7) / 24);
            //heart.setCenter(((Variables.w * 2) / 3), (h * 7) / 24);
            //heart.draw(batch);
            //sprites.get("heart").rotate(-1);
            //heart.rotate(-1);
            //} else {
            //drawSprite("replay", (Variables.w / 2), (h * 7) / 24);
            //replaysprite.setCenter((Variables.w / 2), (h * 7) / 24);
            //replaysprite.draw(Variables.batch);
            //sprites.get("replay").rotate(0.5f);
            //replaysprite.rotate(0.5f);
            // }
            // if (BallGame.adsController.getRewarded()) {
            //System.out.println("true");
            // achievementActions.addBrownies(20);//reward brownies
            //ContinueGame.returnToPlayScreen();
            //BallGame.adsController.setRewarded(false);

            //}

            //} else {
            //drawSprite("replay", (Variables.w / 2), (h * 7) / 24);
            replaysprite.setCenter((Variables.w / 2), (h * 7) / 24);
            replaysprite.draw(Variables.batch);
            //sprites.get("replay").rotate(0.5f);
            replaysprite.rotate(0.5f);
            // }
            //}
            //sprites.get("pause").setAlpha(1f);
            pause.setAlpha(1f);
            batch.end();
            if (timerloop == 1) {
                if (type.equalsIgnoreCase("time")) {
                    achievementTime += (System.currentTimeMillis() - achievementStartTime);
                }
                gametime += System.currentTimeMillis() - startTime;
                long timeplayed = Variables.prefs_time.getLong("time");
                elapsedTime = gametime / 1000;
                Variables.prefs_time.clear();
                Variables.prefs_time.putLong("time", timeplayed + elapsedTime);
                Variables.prefs_time.flush();
                gametime = 0;
                //Test for games played achievement
                achievementActions.deathProgress();
                achievementActions.resetVariables();
                timerloop = 0;

            }

        }
    }

    public static void resetVariables() {
        //rotateSprite("duopausehowto", 0);
        duopausehowto.setRotation(0);
        //rotateSprite("duopausehome", 0);
        duopausehome.setRotation(0);
        //rotateSprite("duopauseresume", 0);
        duopauseresume.setRotation(0);
        //rotateSprite("play", 0);
        sprite4.setRotation(0);
        //rotateSprite("settings", 0);
        setting.setRotation(0);
        //rotateSprite("replay", 0);
        replaysprite.setRotation(0);
        //rotateSprite("dead_home", 0);
        dhsprite.setRotation(0);
        Variables.onedead = false;
        Variables.twodead = false;
        Variables.arc_left_id = 5;
        Variables.arc_right_id = 1;
        Variables.left_id = 5;
        Variables.right_id = 1;
        Variables.score = 0;
        Variables.paused = false;
        Variables.cycle = 1;
        Variables.position_x = Variables.w / 2;
        Double.position_x2 = Variables.w / 2;
        Double.arc_degree12 = 90;
        Double.arc_degree22 = 270;
        Double.arc_left_id2 = 6;
        Double.arc_right_id2 = 7;
        Double.left_id2 = 6;
        Double.right_id2 = 7;
        Duo.position_x2 = Variables.w / 2;
        Duo.arc_degree12 = 90;
        Duo.arc_degree22 = 270;
        Duo.arc_left_id2 = 6;
        Duo.arc_right_id2 = 7;
        Duo.left_id2 = 6;
        Duo.right_id2 = 7;
        Variables.direction = 1;
        Double.direction2 = 2;
        Duo.direction2 = 2;
        arcdegrees.clear();
        com.flyingbrowniegames.ballgame.Extreme.wallcolors.clear();
        com.flyingbrowniegames.ballgame.Extreme.colours.clear();
        com.flyingbrowniegames.ballgame.Extreme.positions.clear();
        Extreme.ballpositions.clear();
        com.flyingbrowniegames.ballgame.Extreme.loop = 0;
        rightball.setFlip(true, false);
        leftball.setFlip(false, false);
        secondleftball.setFlip(false, false);
        secondrightball.setFlip(true, false);
        blindrightball.setFlip(true, false);
        blindleftball.setFlip(false, false);
        ballposition = w / 22;
        ballposition2 = w / 22;
        Double.ballposition2 = w / 22;
        halfloop = 0;
        playerscoreloop = 0;
        mirrorThrough = false;
        secondrightball.setRotation(0);
        secondleftball.setRotation(0);


    }
}
