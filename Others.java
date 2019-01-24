package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;

import static com.flyingbrowniegames.ballgame.BallGame.iActivityRequestHandler;
import static com.flyingbrowniegames.ballgame.BallGame.playServices;
import static com.flyingbrowniegames.ballgame.Double.arc_left_id2;
import static com.flyingbrowniegames.ballgame.Double.arc_right_id2;
import static com.flyingbrowniegames.ballgame.MoveBall.full_way;
import static com.flyingbrowniegames.ballgame.Variables.achievementIndex;
import static com.flyingbrowniegames.ballgame.Variables.arc_left_id;
import static com.flyingbrowniegames.ballgame.Variables.arc_right_id;
import static com.flyingbrowniegames.ballgame.Variables.blindAchievements;
import static com.flyingbrowniegames.ballgame.Variables.blindColourCount;
import static com.flyingbrowniegames.ballgame.Variables.blindCurrent;
import static com.flyingbrowniegames.ballgame.Variables.blindTypes;
import static com.flyingbrowniegames.ballgame.Variables.burstAchievements;
import static com.flyingbrowniegames.ballgame.Variables.burstColourCount;
import static com.flyingbrowniegames.ballgame.Variables.burstCurrent;
import static com.flyingbrowniegames.ballgame.Variables.burstOccurCount;
import static com.flyingbrowniegames.ballgame.Variables.burstScoreCount;
import static com.flyingbrowniegames.ballgame.Variables.burstTypes;
import static com.flyingbrowniegames.ballgame.Variables.direction;
import static com.flyingbrowniegames.ballgame.Variables.doubleAchievements;
import static com.flyingbrowniegames.ballgame.Variables.doubleColour;
import static com.flyingbrowniegames.ballgame.Variables.doubleColour2;
import static com.flyingbrowniegames.ballgame.Variables.doubleCurrent;
import static com.flyingbrowniegames.ballgame.Variables.doubleDie;
import static com.flyingbrowniegames.ballgame.Variables.doubleTypes;
import static com.flyingbrowniegames.ballgame.Variables.eventLoop;
import static com.flyingbrowniegames.ballgame.Variables.finishedScore;
import static com.flyingbrowniegames.ballgame.Variables.flipCount;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.halfloop;
import static com.flyingbrowniegames.ballgame.Variables.left_id;
import static com.flyingbrowniegames.ballgame.Variables.matchCount;
import static com.flyingbrowniegames.ballgame.Variables.mirrorCurrent;
import static com.flyingbrowniegames.ballgame.Variables.mirrorThrough;
import static com.flyingbrowniegames.ballgame.Variables.mode;
import static com.flyingbrowniegames.ballgame.Variables.playerscoreloop;
import static com.flyingbrowniegames.ballgame.Variables.position_x;
import static com.flyingbrowniegames.ballgame.Variables.prefs_games;
import static com.flyingbrowniegames.ballgame.Variables.prefs_wallhit;
import static com.flyingbrowniegames.ballgame.Variables.restarted;
import static com.flyingbrowniegames.ballgame.Variables.score;
import static com.flyingbrowniegames.ballgame.Variables.screen;
import static com.flyingbrowniegames.ballgame.Variables.type;
import static com.flyingbrowniegames.ballgame.Variables.waittime;
import static com.flyingbrowniegames.ballgame.Variables.wasReflected;
import static com.flyingbrowniegames.ballgame.Variables.widthspeed;

/**
 * Created by kwisk_000 on 2016-04-25.
 */
public class Others {
    public static int make_substring(int space_width, int word_length) {
        int width = (Variables.w - (word_length * space_width)) / 2;
        return width;
    }


    public static void add_diamonds(int n) {
        if (Variables.loop < 1) {
            if (n == 1) {
                //System.out.println("looped");
                Variables.rounds_played = Variables.prefs_games.getInteger("games");
                Variables.rounds_played++;
                if (prefs_games.getInteger("games") == 999999) {

                } else {
                    prefs_games.clear();
                    Variables.prefs_games.putInteger("games", Variables.rounds_played);
                    Variables.prefs_games.flush();
                }
                if (prefs_wallhit.getInteger("wallhit") == 999999) {

                } else {
                    Variables.total_wallhit = Variables.prefs_wallhit.getInteger("wallhit");
                    Variables.total_wallhit += Variables.times_hit_wall;
                    Variables.prefs_wallhit.putInteger("wallhit", Variables.total_wallhit);
                    Variables.prefs_wallhit.flush();
                }
            } else {

            }
            Variables.loop = 1;
            if (Variables.prefs_sound.getInteger("sound") != 2) {
                Variables.death.play();
            }

         /* if (adsController.isWifiConnected()) {
                //adsController.showBannerAd();
                adsController.showInterstitialAd(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Interstital app closed");
                        ///Gdx.app.exit();
                    }
                });
            } else {
                System.out.println("Interstital ad not loaded");

            }*/


        }
    }

    public static void check_highscore() {
        switch (Variables.mode) {
            case 1:
                Variables.highscore = Variables.prefs_score.getInteger("score");
                if (Variables.score > Variables.highscore) {

                    Variables.highscore_reach = true;
                    Variables.prefs_score.clear();
                    Variables.prefs_score.putInteger("score", Variables.score);
                    Variables.prefs_score.flush();
                    if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                        BallGame.playServices.submitScore(1, score, 0);
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                        iActivityRequestHandler.reportScore("01", score);
                    }
                }
                break;
            case 2:
                Variables.highscore = Variables.prefs_score2.getInteger("score");
                if (Variables.score > Variables.highscore) {
                    Variables.highscore_reach = true;
                    Variables.prefs_score2.clear();
                    Variables.prefs_score2.putInteger("score", Variables.score);
                    Variables.prefs_score2.flush();
                    if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                        BallGame.playServices.submitScore(2, score, 0);
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                        iActivityRequestHandler.reportScore("02", score);
                    }
                }
                break;
            case 3:
                //System.out.println("score" + Variables.score);
                Variables.highscore = Variables.prefs_score3.getInteger("score");
                if (Variables.score > Variables.highscore) {
                    if (blindTypes[blindCurrent.getInteger("blindCurrent")].equalsIgnoreCase("highscore")) {
                        //System.out.println("blindhighscore");
                        achievementActions.completeAchievement(3, blindCurrent.getInteger("blindCurrent"));
                    }
                    //System.out.println("bigger");
                    Variables.highscore_reach = true;
                    Variables.prefs_score3.clear();
                    Variables.prefs_score3.putInteger("score", Variables.score);
                    Variables.prefs_score3.flush();
                    if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                        BallGame.playServices.submitScore(3, score, 0);
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                        iActivityRequestHandler.reportScore("03", score);
                    }
                }
                break;
            case 4:
                Variables.highscore = Variables.prefs_score4.getInteger("score");
                if (Variables.score > Variables.highscore) {
                    if (burstTypes[burstCurrent.getInteger("burstCurrent")].equalsIgnoreCase("highscore")) {
                        //System.out.println("bursthighscore");
                        achievementActions.completeAchievement(4, burstCurrent.getInteger("burstCurrent"));
                    }
                    Variables.highscore_reach = true;
                    Variables.prefs_score4.clear();
                    Variables.prefs_score4.putInteger("score", Variables.score);
                    Variables.prefs_score4.flush();
                    if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                        BallGame.playServices.submitScore(4, score, 0);
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                        iActivityRequestHandler.reportScore("04", score);
                    }
                }
                break;
            case 5:
                Variables.highscore = Variables.prefs_score5.getInteger("score");
                //Variables.prefs_score5.getInteger("score");
                if (Variables.score > Variables.highscore) {
                    //System.out.println("highscore for double");
                    //System.out.println(doubleAchievements[doubleCurrent.getInteger("doubleCurrent")]);
                    if (doubleTypes[doubleCurrent.getInteger("doubleCurrent")].equalsIgnoreCase("highscore")) {
                        //System.out.println("doublehighscore");
                        achievementActions.completeAchievement(5, doubleCurrent.getInteger("doubleCurrent"));
                    }
                    Variables.highscore_reach = true;
                    Variables.prefs_score5.clear();
                    Variables.prefs_score5.putInteger("score", Variables.score);
                    Variables.prefs_score5.flush();
                    if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                        BallGame.playServices.submitScore(5, score, 0);
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                        iActivityRequestHandler.reportScore("05", score);
                    }
                }
                break;
            case 6:
                switch (com.flyingbrowniegames.ballgame.Extreme.balls1) {
                    case 3:
                        Variables.highscore = Variables.prefs_score63.getInteger("score");
                        if (Variables.score > Variables.highscore) {
                            Variables.highscore_reach = true;
                            Variables.prefs_score63.clear();
                            Variables.prefs_score63.putInteger("score", Variables.score);
                            Variables.prefs_score63.flush();
                            if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                                BallGame.playServices.submitScore(6, score, 3);
                            } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                                iActivityRequestHandler.reportScore("06", score);
                            }
                        }
                        break;
                    case 4:
                        Variables.highscore = Variables.prefs_score64.getInteger("score");
                        if (Variables.score > Variables.highscore) {
                            Variables.highscore_reach = true;
                            Variables.prefs_score64.clear();
                            Variables.prefs_score64.putInteger("score", Variables.score);
                            Variables.prefs_score64.flush();
                            if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                                BallGame.playServices.submitScore(6, score, 4);
                            } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                                iActivityRequestHandler.reportScore("07", score);
                            }
                        }
                        break;
                    case 5:
                        Variables.highscore = Variables.prefs_score65.getInteger("score");
                        if (Variables.score > Variables.highscore) {
                            Variables.highscore_reach = true;
                            Variables.prefs_score65.clear();
                            Variables.prefs_score65.putInteger("score", Variables.score);
                            Variables.prefs_score65.flush();
                            if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                                BallGame.playServices.submitScore(6, score, 5);
                            } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                                iActivityRequestHandler.reportScore("08", score);
                            }
                        }
                        break;
                    case 6:
                        Variables.highscore = Variables.prefs_score66.getInteger("score");
                        if (Variables.score > Variables.highscore) {
                            Variables.highscore_reach = true;
                            Variables.prefs_score66.clear();
                            Variables.prefs_score66.putInteger("score", Variables.score);
                            Variables.prefs_score66.flush();
                            if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                                BallGame.playServices.submitScore(6, score, 6);
                            } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                                iActivityRequestHandler.reportScore("09", score);
                            }
                        }
                        break;
                }

                break;
            case 7:
                Variables.highscore = Variables.prefs_score7.getInteger("score");
                if (Variables.score > Variables.highscore) {
                    Variables.highscore_reach = true;
                    Variables.prefs_score7.clear();
                    Variables.prefs_score7.putInteger("score", Variables.score);
                    Variables.prefs_score7.flush();
                    if (Gdx.app.getType() == Application.ApplicationType.Android && playServices.isSignedIn()) {
                        BallGame.playServices.submitScore(7, score, 0);
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS && iActivityRequestHandler.isSignedIn()) {
                        iActivityRequestHandler.reportScore("10", score);
                    }
                }
                break;

        }

    }


    public static void check_hit() {
        if (Variables.position_x > Variables.w - (Variables.arc_width + (Variables.w / 100))) { //right side
            if (type.equalsIgnoreCase("burst")) {
                if (widthspeed == (2 * full_way) && direction == 1) {
                    burstOccurCount++;
                }
            }
            if (Variables.arc_degree_2 == 270) {
                if (Variables.arc_right_id == Variables.right_id) { //arc color matches with right side color
                    Variables.score++;
                    finishedScore++;
                    playerscoreloop = 0;
                    halfloop = 0;
                    if (Variables.screen == 15) {
                        com.flyingbrowniegames.ballgame.Mirror.reflect = Variables.random.nextInt(30);
                        if (type.equalsIgnoreCase("through")) {
                            mirrorThrough = false;
                        }
                        if (wasReflected && type.equalsIgnoreCase("match")) {
                            matchCount++;
                            wasReflected = false;
                        }
                        //  System.out.println("reflect" + Mirror.reflect);
                    } else if (screen == 16) {//blind
                        if (type.equalsIgnoreCase("flipwall")) {
                            if (flipCount >= 10) {
                                achievementActions.completeAchievement(mode, achievementIndex);
                            } else {
                                flipCount = 0;
                            }
                        } else if (type.equalsIgnoreCase("yellow")) {
                            if (arc_right_id == 2 || arc_right_id == 12) {
                                blindColourCount++;
                            }
                        } else if (type.equalsIgnoreCase("pink")) {
                            if (arc_right_id == 4 || arc_right_id == 14) {
                                blindColourCount++;
                            }
                        }
                    } else if (screen == 17) {//burst
                        if (type.equalsIgnoreCase("burstscore")) {
                            if (widthspeed == (2 * full_way)) {
                                burstScoreCount++;
                            }
                        } else if (type.equalsIgnoreCase("blue")) {
                            if (arc_right_id == 5) {
                                burstColourCount++;
                            }
                        } else if (type.equalsIgnoreCase("lightgreen")) {
                            if (arc_right_id == 4) {
                                burstColourCount++;
                            }
                        }
                    } else if (screen == 18 && type.equalsIgnoreCase("colourmatch")) {
                        doubleColour = arc_right_id;
                    }
                    hitReset();
                } else { //dies
                    //Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                    if (type.equalsIgnoreCase("bottomdie")) {
                        doubleDie++;
                    }
                    Variables.twodead = true;
                    if (Variables.screen == 21) {
                        duohit();
                    }
                    Variables.screen = 3;
                    Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                    waittime = System.currentTimeMillis();
                    eventLoop = 0;
                    //System.out.println("dead1");
                }
                ///System.out.println(arc_right_id + " " + Variables.right_id);
            } else if (Variables.arc_degree_2 == 90) {
                if (Variables.arc_left_id == Variables.right_id) { // circle color matches right side color
                    Variables.score++;
                    finishedScore++;
                    playerscoreloop = 0;
                    halfloop = 0;
                    if (Variables.screen == 15) {
                        com.flyingbrowniegames.ballgame.Mirror.reflect = Variables.random.nextInt(30);
                        if (type.equalsIgnoreCase("through")) {
                            mirrorThrough = false;
                        }
                        if (wasReflected && type.equalsIgnoreCase("match")) {
                            matchCount++;
                            wasReflected = false;
                        }
                        //System.out.println("reflect" + Mirror.reflect);
                    } else if (screen == 16) {//blind
                        if (type.equalsIgnoreCase("flipwall")) {
                            if (flipCount >= 10) {
                                achievementActions.completeAchievement(mode, achievementIndex);
                            } else {
                                flipCount = 0;
                            }
                        } else if (type.equalsIgnoreCase("yellow")) {
                            if (arc_left_id == 2 || arc_left_id == 12) {
                                blindColourCount++;
                            }
                        } else if (type.equalsIgnoreCase("pink")) {
                            if (arc_left_id == 4 || arc_left_id == 14) {
                                blindColourCount++;
                            }
                        }
                    } else if (screen == 17) {//burst
                        if (type.equalsIgnoreCase("burstscore")) {
                            if (widthspeed == (2 * full_way)) {
                                burstScoreCount++;
                            }
                        } else if (type.equalsIgnoreCase("blue")) {
                            if (arc_left_id == 5) {
                                burstColourCount++;
                            }
                        } else if (type.equalsIgnoreCase("lightgreen")) {
                            if (arc_left_id == 4) {
                                burstColourCount++;
                            }
                        }
                    } else if (screen == 18 && type.equalsIgnoreCase("colourmatch")) {
                        doubleColour = arc_left_id;
                    }
                    hitReset();
                } else { //dies
                    // Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                    if (type.equalsIgnoreCase("bottomdie")) {
                        doubleDie++;
                    }
                    Variables.twodead = true;
                    if (Variables.screen == 21) {
                        duohit();
                    }
                    Variables.screen = 3;
                    Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                    waittime = System.currentTimeMillis();
                    eventLoop = 0;
                    //System.out.println("dead2");
                }
                //System.out.println(arc_left_id + " " + Variables.right_id);
            } else {

            }
        } else if (Variables.position_x < (Variables.arc_width + (Variables.w / 100))) { //left side
            if (type.equalsIgnoreCase("burst")) {
                if (widthspeed == (2 * full_way) && direction == 2) {
                    burstOccurCount++;
                }
            }
            if (Variables.arc_degree_2 == 270) {
                if (Variables.arc_left_id == Variables.left_id) { //arc color matches with left side color
                    Variables.score++;
                    finishedScore++;
                    playerscoreloop = 0;
                    halfloop = 0;
                    if (Variables.screen == 15) {
                        com.flyingbrowniegames.ballgame.Mirror.reflect = Variables.random.nextInt(30);
                        if (type.equalsIgnoreCase("through")) {
                            mirrorThrough = false;
                        }
                        if (wasReflected && type.equalsIgnoreCase("match")) {
                            matchCount++;
                            wasReflected = false;
                        }
                        // System.out.println("reflect" + Mirror.reflect);
                    } else if (screen == 16) {//blind
                        if (type.equalsIgnoreCase("flipwall")) {
                            if (flipCount >= 10) {
                                achievementActions.completeAchievement(mode, achievementIndex);
                            } else {
                                flipCount = 0;
                            }
                        } else if (type.equalsIgnoreCase("yellow")) {
                            if (arc_left_id == 2 || arc_left_id == 12) {
                                blindColourCount++;
                            }
                        } else if (type.equalsIgnoreCase("pink")) {
                            if (arc_left_id == 4 || arc_left_id == 14) {
                                blindColourCount++;
                            }
                        }
                    } else if (screen == 17) {//burst
                        if (type.equalsIgnoreCase("burstscore")) {
                            if (widthspeed == (2 * full_way)) {
                                burstScoreCount++;
                            }
                        } else if (type.equalsIgnoreCase("blue")) {
                            if (arc_left_id == 5) {
                                burstColourCount++;
                            }
                        } else if (type.equalsIgnoreCase("lightgreen")) {
                            if (arc_left_id == 4) {
                                burstColourCount++;
                            }
                        }
                    } else if (screen == 18 && type.equalsIgnoreCase("colourmatch")) {
                        doubleColour = arc_left_id;
                    }
                    hitReset();
                } else { //dies
                    //Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                    if (type.equalsIgnoreCase("bottomdie")) {
                        doubleDie++;
                    }
                    Variables.twodead = true;
                    if (Variables.screen == 21) {
                        duohit();
                    }
                    Variables.screen = 3;
                    Variables.position_x = (Variables.w * 1 / 100) + Variables.arc_width;
                    waittime = System.currentTimeMillis();
                    eventLoop = 0;
                    //System.out.println("dead3");
                }
                //System.out.println(arc_left_id + " " + left_id);
            } else if (Variables.arc_degree_2 == 90) {
                if (Variables.arc_right_id == Variables.left_id) { // arc color matches left side color
                    Variables.score++;
                    finishedScore++;
                    playerscoreloop = 0;
                    halfloop = 0;
                    if (Variables.screen == 15) {
                        com.flyingbrowniegames.ballgame.Mirror.reflect = Variables.random.nextInt(30);
                        if (type.equalsIgnoreCase("through")) {
                            mirrorThrough = false;
                        }
                        if (wasReflected && type.equalsIgnoreCase("match")) {
                            matchCount++;
                            wasReflected = false;
                        }
                        //   System.out.println("reflect" + Mirror.reflect);
                    } else if (screen == 16) {//blind
                        if (type.equalsIgnoreCase("flipwall")) {
                            if (flipCount >= 10) {
                                achievementActions.completeAchievement(mode, achievementIndex);
                            } else {
                                flipCount = 0;
                            }
                        } else if (type.equalsIgnoreCase("yellow")) {
                            if (arc_right_id == 2 || arc_right_id == 12) {
                                blindColourCount++;
                            }
                        } else if (type.equalsIgnoreCase("pink")) {
                            if (arc_right_id == 4 || arc_right_id == 14) {
                                blindColourCount++;
                            }
                        }
                    } else if (screen == 17) {//burst
                        if (type.equalsIgnoreCase("burstscore")) {
                            if (widthspeed == (2 * full_way)) {
                                burstScoreCount++;
                            }
                        } else if (type.equalsIgnoreCase("blue")) {
                            if (arc_right_id == 5) {
                                burstColourCount++;
                            }
                        } else if (type.equalsIgnoreCase("lightgreen")) {
                            if (arc_right_id == 4) {
                                burstColourCount++;
                            }
                        }
                    } else if (screen == 18 && type.equalsIgnoreCase("colourmatch")) {
                        doubleColour = arc_right_id;
                    }
                    hitReset();
                } else { //dies
                    //Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                    if (type.equalsIgnoreCase("bottomdie")) {
                        doubleDie++;
                    }
                    Variables.twodead = true;
                    if (Variables.screen == 21) {
                        duohit();
                    }
                    Variables.position_x = (Variables.w * 1 / 100) + Variables.arc_width;
                    Variables.screen = 3;
                    waittime = System.currentTimeMillis();
                    eventLoop = 0;
                    //System.out.println("dead4");
                }
                //System.out.println(arc_right_id + " " + left_id);
            } else {

            }
        } else {

        }
        if (Variables.screen == 18) { //upper ball
            //System.out.println("thr");
            if (Double.position_x2 > Variables.w - (Variables.arc_width + (Variables.w / 100))) { //right side
                if (Double.arc_degree22 == 270) {
                    if (arc_right_id2 == Double.right_id2) { //arc color matches with right side color
                        Variables.score++;
                        finishedScore++;
                        playerscoreloop = 0;
                        halfloop = 0;
                        if (type.equalsIgnoreCase("colourmatch")) {
                            //if (arc_right_id2 == doubleColour) {
                            //achievementActions.completeAchievement(5, achievementIndex);
                            //}
                            doubleColour2 = arc_right_id2;
                        }
                        com.flyingbrowniegames.ballgame.Colours.Colors();
                        com.flyingbrowniegames.ballgame.ColoursDouble.Colors();
                        MoveBall.change_direction();
                        Double.position_x2 = Variables.w - (Variables.arc_width + (Variables.w / 100));
                        if (Variables.position_x > Variables.w - (Variables.arc_width + (Variables.w / 100))) {//left side
                            Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                        } else if (Variables.position_x < (Variables.arc_width + (Variables.w / 100))) {//right side
                            position_x = Variables.arc_width + (Variables.w / 100);
                        }
                    } else { //dies
                        if (type.equalsIgnoreCase("topdie")) {
                            doubleDie++;
                        }
                        //Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                        Variables.screen = 3;
                        waittime = System.currentTimeMillis();
                        Double.position_x2 = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                        eventLoop = 0;
                        //System.out.println("dead5");
                    }
                } else if (Double.arc_degree22 == 90) {
                    if (arc_left_id2 == Double.right_id2) { // circle color matches right side color
                        Variables.score++;
                        finishedScore++;
                        playerscoreloop = 0;
                        halfloop = 0;
                        if (type.equalsIgnoreCase("colourmatch")) {
                            //if (arc_left_id2 == doubleColour) {
                            //achievementActions.completeAchievement(5, achievementIndex);
                            //}
                            doubleColour2 = arc_left_id2;
                        }
                        com.flyingbrowniegames.ballgame.Colours.Colors();
                        com.flyingbrowniegames.ballgame.ColoursDouble.Colors();
                        MoveBall.change_direction();
                        Double.position_x2 = Variables.w - (Variables.arc_width + (Variables.w / 100));
                        if (Variables.position_x > Variables.w - (Variables.arc_width + (Variables.w / 100))) {//left side
                            Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                        } else if (Variables.position_x < (Variables.arc_width + (Variables.w / 100))) {//right side
                            position_x = Variables.arc_width + (Variables.w / 100);
                        }
                    } else { //dies
                        // Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                        if (type.equalsIgnoreCase("topdie")) {
                            doubleDie++;
                        }
                        Variables.screen = 3;
                        waittime = System.currentTimeMillis();
                        Double.position_x2 = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                        eventLoop = 0;
                        //System.out.println("dead6");
                    }
                } else {

                }
            } else if (Double.position_x2 < (Variables.arc_width + (Variables.w / 100))) { //left side
                if (Double.arc_degree22 == 270) {
                    if (arc_left_id2 == Double.left_id2) { //arc color matches with left side color
                        Variables.score++;
                        finishedScore++;
                        playerscoreloop = 0;
                        halfloop = 0;
                        if (type.equalsIgnoreCase("colourmatch")) {
                            // if (arc_left_id2 == doubleColour) {
                            // achievementActions.completeAchievement(5, achievementIndex);
                            //}
                            doubleColour2 = arc_left_id2;
                        }
                        com.flyingbrowniegames.ballgame.Colours.Colors();
                        com.flyingbrowniegames.ballgame.ColoursDouble.Colors();
                        MoveBall.change_direction();
                        Double.position_x2 = (Variables.arc_width + (Variables.w / 100));
                        if (Variables.position_x > Variables.w - (Variables.arc_width + (Variables.w / 100))) {//left side
                            Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                        } else if (Variables.position_x < (Variables.arc_width + (Variables.w / 100))) {//right side
                            position_x = Variables.arc_width + (Variables.w / 100);
                        }

                    } else { //dies
                        //Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                        if (type.equalsIgnoreCase("topdie")) {
                            doubleDie++;
                        }
                        Variables.screen = 3;
                        waittime = System.currentTimeMillis();
                        Double.position_x2 = (Variables.w * 1 / 100) + Variables.arc_width;
                        eventLoop = 0;
                        //System.out.println("dead7");
                    }
                } else if (Double.arc_degree22 == 90) {
                    if (arc_right_id2 == Double.left_id2) { // arc color matches left side color
                        Variables.score++;
                        finishedScore++;
                        playerscoreloop = 0;
                        halfloop = 0;
                        if (type.equalsIgnoreCase("colourmatch")) {
                            //if (arc_right_id2 == doubleColour) {
                            // achievementActions.completeAchievement(5, achievementIndex);
                            //}
                            doubleColour2 = arc_right_id2;
                        }
                        com.flyingbrowniegames.ballgame.Colours.Colors();
                        com.flyingbrowniegames.ballgame.ColoursDouble.Colors();
                        MoveBall.change_direction();
                        Double.position_x2 = (Variables.arc_width + (Variables.w / 100));
                        if (Variables.position_x > Variables.w - (Variables.arc_width + (Variables.w / 100))) {//left side
                            Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                        } else if (Variables.position_x < (Variables.arc_width + (Variables.w / 100))) {//right side
                            position_x = Variables.arc_width + (Variables.w / 100);
                        }

                    } else { //dies
                        //Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                        if (type.equalsIgnoreCase("topdie")) {
                            doubleDie++;
                        }
                        Variables.screen = 3;
                        waittime = System.currentTimeMillis();
                        Double.position_x2 = (Variables.w * 1 / 100) + Variables.arc_width;
                        eventLoop = 0;
                        //System.out.println("dead8");
                    }
                } else {

                }
            } else {

            }
        }
        //System.out.println(direction);
    }

    public static void hitReset() {
        switch (mode) {
            case 1: //classic
                com.flyingbrowniegames.ballgame.Colours.Colors();
                MoveBall.change_direction();
                if (Variables.position_x > Variables.w - (Variables.arc_width + (Variables.w / 100))) {//left side
                    Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                } else if (Variables.position_x < (Variables.arc_width + (Variables.w / 100))) {//right side
                    position_x = Variables.arc_width + (Variables.w / 100);
                }
                break;
            case 2: //mirror
                com.flyingbrowniegames.ballgame.Colours.Colors();
                MoveBall.change_direction();
                if (Variables.position_x > Variables.w - (Variables.arc_width + (Variables.w / 100))) {//left side
                    Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                } else if (Variables.position_x < (Variables.arc_width + (Variables.w / 100))) {//right side
                    position_x = Variables.arc_width + (Variables.w / 100);
                }
                break;
            case 3: //blind
                com.flyingbrowniegames.ballgame.BlindColours.Color_from_int();
                MoveBall.change_direction();
                if (Variables.position_x > Variables.w - (Variables.arc_width + (Variables.w / 100))) {//left side
                    Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                } else if (Variables.position_x < (Variables.arc_width + (Variables.w / 100))) {//right side
                    position_x = Variables.arc_width + (Variables.w / 100);
                }
                break;
            case 4: //burst
                com.flyingbrowniegames.ballgame.Colours.Colors();
                MoveBall.change_direction();
                if (Variables.position_x > Variables.w - (Variables.arc_width + (Variables.w / 100))) {//left side
                    Variables.position_x = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                } else if (Variables.position_x < (Variables.arc_width + (Variables.w / 100))) {//right side
                    position_x = Variables.arc_width + (Variables.w / 100);
                }
                break;

        }

    }

    public static void duohit() {
        if (Duo.position_x2 > Variables.w - (Variables.arc_width + (Variables.w / 100))) { //right side
            if (Duo.arc_degree22 == 270) {
                if (Duo.arc_right_id2 == Duo.right_id2) { //arc color matches with right side color

                } else { //dies
                    //Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                    Variables.screen = 3;
                    waittime = System.currentTimeMillis();
                    Duo.position_x2 = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                    Variables.onedead = true;
                    eventLoop = 0;
                }
            } else if (Duo.arc_degree22 == 90) {
                if (Duo.arc_left_id2 == Duo.right_id2) { // circle color matches right side color

                } else { //dies
                    // Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                    Variables.screen = 3;
                    waittime = System.currentTimeMillis();
                    Variables.onedead = true;
                    Duo.position_x2 = Variables.w - (Variables.w * 1 / 100) - Variables.arc_width;
                    eventLoop = 0;
                }
            } else {

            }
        } else if (Duo.position_x2 < (Variables.arc_width + (Variables.w / 100))) { //left side
            if (Duo.arc_degree22 == 270) {
                if (Duo.arc_left_id2 == Duo.left_id2) { //arc color matches with left side color

                } else { //dies
                    //Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                    Variables.screen = 3;
                    waittime = System.currentTimeMillis();
                    Variables.onedead = true;
                    Duo.position_x2 = (Variables.w * 1 / 100) + Variables.arc_width;
                    eventLoop = 0;

                }
            } else if (Duo.arc_degree22 == 90) {
                if (Duo.arc_right_id2 == Duo.left_id2) { // arc color matches left side colo

                } else { //dies
                    //Variables.prefscore = Variables.prefs_score.getInteger("highscore");
                    Variables.screen = 3;
                    waittime = System.currentTimeMillis();
                    Variables.onedead = true;
                    Duo.position_x2 = (Variables.w * 1 / 100) + Variables.arc_width;
                    eventLoop = 0;
                }
            } else {

            }
        }

    }
}
