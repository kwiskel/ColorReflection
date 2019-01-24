package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import java.util.Calendar;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.*;
import static com.flyingbrowniegames.ballgame.Variables.characterName;
import static com.flyingbrowniegames.ballgame.Variables.characterName;
import static com.flyingbrowniegames.ballgame.Variables.characterName;

/**
 * Created by kwisk_000 on 2016-05-02.
 */
public class MyGestureListener implements GestureDetector.GestureListener {
    public static int oops = 0;


    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }


    @Override
    public boolean tap(float x, float y, int count, int button) {
        if (showUpdate) {
            if (updateCheck.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                showUpdate = false;
                updatePopup = Gdx.app.getPreferences("updatePopup");
                updatePopup.putBoolean("updatePopup", true);
                updatePopup.flush();
            }
        } else if (openAchievement) {
            if (exitButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                openAchievement = false;
            } else if (randomizeButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                achievementActions.randomizeAchievement(modeClicked);
            } else if (fastforwardButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                achievementActions.skipAchievement(modeClicked);
            }
            return false;
        } else if (openStore) {
            if (exitButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                openStore = false;
            } else if (storeButton1.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {//10 brownies for $0.99
                achievementActions.addBrownies(420);
            } else if (storeButton2.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {//25 brownies for $1.99
                achievementActions.addBrownies(1100);
            } else if (storeButton3.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {// 100 brownies for $4.99
                achievementActions.addBrownies(3000);
            } else if (storeButton4.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {// 500 brownies for $19.99
                achievementActions.addBrownies(5200);
            } else if (storeButton5.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                if (BallGame.adsController.isWifiConnected() && BallGame.loaded && Gdx.app.getType() == Application.ApplicationType.Android) {//20 free brownies after watching a video ad
                    BallGame.displayVideoAd();
                } else if (BallGame.adsController.isWifiConnected() && Gdx.app.getType() == Application.ApplicationType.iOS) {//20 free brownies after watching a video ad
                    BallGame.displayIosVideo();
                }
                return false;
            }
        } else if (openShop) {
            if (homesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                openShop = false;
            } else if (Gdx.input.getX() <= (w * 15 / 16) && Gdx.input.getX() >= w / 16) {
                for (int i = 0; i < charactersBought.length; i++) {
                    if ((Gdx.input.getY() >= ((shopY) + (characterShopBar.getBoundingRectangle().getHeight() * i)))
                            && (Gdx.input.getY() <= ((shopY) + ((characterShopBar.getBoundingRectangle().getHeight()) * ((1 + i)))))) {
                        //System.out.println("in y" + i);
                        if (charactersBought[i] == 1) {
                            ShopScreen.changeCharacter(i);
                            break;
                        } else {
                            ShopScreen.purchaseCharacter(i);
                            break;
                        }
                    }
                }
                //System.out.println("in x");
            }
        } else {
            if (Variables.screen == 1) {
                //if (Gdx.app.getType() == Application.ApplicationType.Android) {
                if (moneyBox.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    openStore = true;
                } else if (shopIcon.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    //for (int i = 0; i < charactersBought.length; i++) {
                    //System.out.println(charactersBought[i]);
                    //}
                    shopY = characterShopTitleBar.getBoundingRectangle().getHeight() / 2 + ((h) / 16);
                    if (specialSale) {
                        DateCompare.saleDate();
                    }
                    openShop = true;
                } else if (Variables.leadersprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    //System.out.println("touched leaders");
                    if (blindTypes[blindCurrent.getInteger("blindCurrent")].equalsIgnoreCase("leaderboard")) {
                        //System.out.println("blindleaderboard");
                        achievementActions.completeAchievement(3, blindCurrent.getInteger("blindCurrent"));
                    }
                    if (burstTypes[burstCurrent.getInteger("burstCurrent")].equalsIgnoreCase("leaderboard")) {
                        //System.out.println("burstleaderboard");
                        achievementActions.completeAchievement(4, burstCurrent.getInteger("burstCurrent"));
                    }
                    if (Gdx.app.getType() == Application.ApplicationType.Android) {
                        BallGame.playServices.showsScore();
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                        BallGame.iActivityRequestHandler.showLeaderboardsView();
                        // BallGame.iActivityRequestHandler.loadLeaderboards();
                        // BallGame.iActivityRequestHandler.showLeaderboardsView();
                        //BallGame.iActivityRequestHandler.signIn();
                    }
                } else if ((blackStar1.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar1.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                    openAchievement = true;
                    if (classicCompleted.getInteger("classicCompleted") != 25) {
                        glyphLayout.setText(achievementFont, classicAchievements[classicCurrent.getInteger("classicCurrent")]);
                        percentageLayout.setText(percentageFont, (String.valueOf(((classicCompleted.getInteger("classicCompleted")) * 4))) + "%");
                        progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(classicRequirements, classicCurrent.getInteger("classicCurrent"), classicCumulatives))));
                    } else {
                        glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies \n for every 100 points");
                        progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" +
                                ("100")));
                        type = "finished";
                        percentageLayout.setText(percentageFont, "100%");
                    }
                    modeClicked = 1;
                } else if ((blackStar2.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar2.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                    openAchievement = true;
                    if (mirrorCompleted.getInteger("mirrorCompleted") != 25) {
                        glyphLayout.setText(achievementFont, mirrorAchievements[mirrorCurrent.getInteger("mirrorCurrent")]);
                        percentageLayout.setText(percentageFont, (String.valueOf(((mirrorCompleted.getInteger("mirrorCompleted")) * 4))) + "%");
                        progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(mirrorRequirements, mirrorCurrent.getInteger("mirrorCurrent"), mirrorCumulatives))));
                    } else {
                        glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                        progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" + ("100")));
                        type = "finished";
                        percentageLayout.setText(percentageFont, "100%");
                    }
                    modeClicked = 2;
                } else if ((blackStar3.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar3.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                    openAchievement = true;
                    if (blindCompleted.getInteger("blindCompleted") != 25) {
                        glyphLayout.setText(achievementFont, blindAchievements[blindCurrent.getInteger("blindCurrent")]);
                        percentageLayout.setText(percentageFont, (String.valueOf(((blindCompleted.getInteger("blindCompleted")) * 4))) + "%");
                        progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(blindRequirements, blindCurrent.getInteger("blindCurrent"), blindCumulatives))));
                    } else {
                        glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                        progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" + ("100")));
                        type = "finished";
                        percentageLayout.setText(percentageFont, "100%");
                    }
                    modeClicked = 3;
                } else if ((blackStar4.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar4.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                    openAchievement = true;
                    if (burstCompleted.getInteger("burstCompleted") != 25) {
                        glyphLayout.setText(achievementFont, burstAchievements[burstCurrent.getInteger("burstCurrent")]);
                        percentageLayout.setText(percentageFont, (String.valueOf(((burstCompleted.getInteger("burstCompleted")) * 4))) + "%");
                        progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(burstRequirements, burstCurrent.getInteger("burstCurrent"), burstCumulatives))));
                    } else {
                        glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                        progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("bursrCurrentProgress")) + "/" + ("100")));
                        type = "finished";
                        percentageLayout.setText(percentageFont, "100%");
                    }
                    modeClicked = 4;
                } else if ((blackStar5.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar5.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                    openAchievement = true;
                    if (doubleCompleted.getInteger("doubleCompleted") != 25) {
                        glyphLayout.setText(achievementFont, doubleAchievements[doubleCurrent.getInteger("doubleCurrent")]);
                        percentageLayout.setText(percentageFont, (String.valueOf(((doubleCompleted.getInteger("doubleCompleted")) * 4))) + "%");
                        progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(doubleRequirements, doubleCurrent.getInteger("doubleCurrent"), doubleCumulatives))));
                    } else {
                        glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                        progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" + ("100")));
                        type = "finished";
                        percentageLayout.setText(percentageFont, "100%");
                    }
                    modeClicked = 5;
                } /*else if ((blackStar6.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar6.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                    openAchievement = true;
                    glyphLayout.setText(achievementFont, extremeFlipAchievements[extremeFlipCurrent.getInteger("extremeFlipCurrent")]);
                    percentageLayout.setText(percentageFont, String.valueOf(extremeFlipCompleted.getInteger("extremeFlipCompleted")) + "%");
                    modeClicked = 7;
                }*/ else if (gameModeIcon.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    Variables.screen = 27;
                    modeScreenTime = System.currentTimeMillis();
                    screenLoop = 0;
                    Variables.deltaY = (((10 * h) / 69) - 1);
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                    leftball.setRotation(0);
                    rightball.setRotation(0);
                    Clasiclogo.setRotation(0);
                } else if (setting.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    Variables.screen = 6;
                    screenLoop = 0;
                } else if (Variables.infosprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    Variables.screen = 23;
                    screenLoop = 0;
                } else if (Variables.likesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    //Gdx.net.openURI("https://www.facebook.com/flyingbrowniegame/?ref=nf");
                    openAchievement = true;
                } else if (Variables.ratesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    oops = 1;
                } else {
                    if (classicCompleted.getInteger("classicCompleted") != 25) {
                        glyphLayout.setText(achievementFont, classicAchievements[classicCurrent.getInteger("classicCurrent")]);
                        progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(classicRequirements, classicCurrent.getInteger("classicCurrent"), classicCumulatives))));
                        type = classicTypes[classicCurrent.getInteger("classicCurrent")];
                        achievementIndex = classicCurrent.getInteger("classicCurrent");
                        achievementCumulatives = classicCumulatives;
                    } else {
                        glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                        progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" + ("100")));
                        type = "finished";
                    }
                    Variables.screen = 2;
                    screenLoop = 0;
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                    leftball.setRotation(0);
                    rightball.setRotation(0);
                    restarted = 0;
                    if (Gdx.app.getType() == Application.ApplicationType.Android) {
                        BallGame.adsController.setRewarded(false);
                    }

                }
           /* } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                if (Variables.modelabel.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    Variables.screen = 7;
                     screenLoop = 0;
                    Variables.deltaY = (((10 * h) / 69) - 1);
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                } else if (Variables.setting.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    Variables.screen = 6;
                     screenLoop = 0;
                } else if (Variables.infosprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    Variables.screen = 23;
                     screenLoop = 0;
                } else if (Variables.likesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Gdx.net.openURI("https://www.facebook.com/flyingbrowniegame/?ref=nf");
                } else if (Variables.ratesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    oops = 1;
                } else {
                    Variables.screen = 2;
                     screenLoop = 0;
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                }
            }*/

            } else if (Variables.screen == 2) {
                if (Variables.pause.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && (System.currentTimeMillis() - pausetime > 3000)) {
                    //System.out.println("paused");
                    Variables.paused = true;

                    // Gdx.app.getApplicationListener().pause();
                    // Variables.paused = true;
                } else if (Variables.duopauseresume.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.pausetime = System.currentTimeMillis();
                    Variables.paused = false;
                } else if (Variables.duopausehome.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    ResetScreens.resetVariables();
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                    Variables.paused = false;
                    Others.add_diamonds(0);
                } else if (Variables.duopausehowto.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.screen = 25;
                    screenLoop = 0;
                } else {
                    MoveBall.change_angle(x, y);
                }
            } else if (Variables.screen == 3) {
                if (System.currentTimeMillis() - waittime < 500) {

                } else {
                    if (Variables.replaysprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        switch (mode) {
                            case 1:
                                Variables.screen = 24;//classic
                                if (classicCompleted.getInteger("classicCompleted") != 25) {
                                    glyphLayout.setText(achievementFont, classicAchievements[classicCurrent.getInteger("classicCurrent")]);
                                    progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" +
                                            (achievementActions.setRequirement(classicRequirements, classicCurrent.getInteger("classicCurrent"), classicCumulatives))));
                                } else {
                                    glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                    progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" + ("100")));
                                }
                                screenLoop = 0;
                                break;
                            case 2://mirror
                                Variables.screen = 8;
                                if (mirrorCompleted.getInteger("mirrorCompleted") != 25) {
                                    glyphLayout.setText(achievementFont, mirrorAchievements[mirrorCurrent.getInteger("mirrorCurrent")]);
                                    progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" +
                                            (achievementActions.setRequirement(mirrorRequirements, mirrorCurrent.getInteger("mirrorCurrent"), mirrorCumulatives))));
                                } else {
                                    glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                    progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" + ("100")));
                                }
                                screenLoop = 0;
                                break;
                            case 3://blind
                                Variables.screen = 9;
                                if (blindCompleted.getInteger("blindCompleted") != 25) {
                                    glyphLayout.setText(achievementFont, blindAchievements[blindCurrent.getInteger("blindCurrent")]);
                                    progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" +
                                            (achievementActions.setRequirement(blindRequirements, blindCurrent.getInteger("blindCurrent"), blindCumulatives))));
                                } else {
                                    glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                    progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" + ("100")));
                                }
                                screenLoop = 0;
                                break;
                            case 4://burst
                                Variables.screen = 10;
                                if (burstCompleted.getInteger("burstCompleted") != 25) {
                                    glyphLayout.setText(achievementFont, burstAchievements[burstCurrent.getInteger("burstCurrent")]);
                                    progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" +
                                            (achievementActions.setRequirement(burstRequirements, burstCurrent.getInteger("burstCurrent"), burstCumulatives))));
                                } else {
                                    glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                    progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" + ("100")));
                                }
                                screenLoop = 0;
                                break;
                            case 5://double
                                Variables.screen = 11;
                                if (doubleCompleted.getInteger("doubleCompleted") != 25) {
                                    glyphLayout.setText(achievementFont, doubleAchievements[doubleCurrent.getInteger("doubleCurrent")]);
                                    progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" +
                                            (achievementActions.setRequirement(doubleRequirements, doubleCurrent.getInteger("doubleCurrent"), doubleCumulatives))));
                                } else {
                                    glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                    progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" + ("100")));
                                }
                                screenLoop = 0;
                                break;
                            case 6:
                                Variables.screen = 22;
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
                        ResetScreens.resetVariables();
                        Variables.speed_increase = 10;
                        Variables.times_hit_wall = 0;
                        Variables.highscore_reach = false;
                        restarted = 0;
                        if (Gdx.app.getType() == Application.ApplicationType.Android) {
                            BallGame.adsController.setRewarded(false);
                        }
                    } else if (deathrate.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        oops = 1;
                    } else if (dhsprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {

                        }
                        Variables.screen = 1;
                        screenLoop = 0;
                        mainscoreloop = 0;
                    } else if (Variables.sharesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        String modetext = "";
                        if (type.equalsIgnoreCase("share")) {
                            achievementActions.checkProgress(1);
                        }
                        switch (mode) {
                            case 1:
                                modetext = "classic";
                                break;
                            case 2:
                                modetext = "mirror";
                                break;
                            case 3:
                                modetext = "blind";
                                break;
                            case 4:
                                modetext = "burst";
                                break;
                            case 5:
                                modetext = "double";
                                break;
                            case 6:
                                modetext = "extreme";
                                break;
                            case 7:
                                modetext = "extremeflip";
                                break;
                        }
                        if (Gdx.app.getType() == Application.ApplicationType.Android) {
                            BallGame.playServices.shareIntent("WOW! I just scored " + Variables.score + " in Color Reflections's " + modetext + " game mode! Try to beat my score by playing with me for free: https://play.google.com/store/apps/details?id=com.flyingbrowniegames.ballgame&hl=en");
                        } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                            BallGame.iActivityRequestHandler.share("WOW! I just scored " + Variables.score + " in Color Reflection's " + modetext + " game mode! Try to beat my score by playing with me for free: https://itunes.apple.com/ca/app/colorreflection/id1204997081");
                        }
                    }
                    //if (Gdx.app.getType() == Application.ApplicationType.Android) {
                    if (deathleader.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        //System.out.println(blindAchievements[blindCurrent.getInteger("blindCurrent")]);
                        if (blindTypes[blindCurrent.getInteger("blindCurrent")].equalsIgnoreCase("leaderboard")) {
                            //System.out.println("blindleaderboard");
                            achievementActions.completeAchievement(3, blindCurrent.getInteger("blindCurrent"));
                        }
                        if (burstTypes[burstCurrent.getInteger("burstCurrent")].equalsIgnoreCase("leaderboard")) {
                            //System.out.println("burstleaderboard");
                            achievementActions.completeAchievement(4, burstCurrent.getInteger("burstCurrent"));
                        }
                        if (Gdx.app.getType() == Application.ApplicationType.Android) {
                            BallGame.playServices.showsScore();
                        } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                            // BallGame.iActivityRequestHandler.loadLeaderboards();
                            BallGame.iActivityRequestHandler.showLeaderboardsView();
                            //BallGame.iActivityRequestHandler.signIn();
                        }
                    } else if (setting.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && mode == 8) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {

                        }
                        Variables.screen = 6;
                        screenLoop = 0;
                    } /*
                    else if (heart.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())
                            && BallGame.adsController.isWifiConnected() && BallGame.loaded && restarted == 0 && Gdx.app.getType() == Application.ApplicationType.Android) {//watch video to continue
                        if (BallGame.adsController.isWifiConnected()) {
                            if (mode == 1 || mode == 2 || mode == 3) {
                                if (Gdx.app.getType() == Application.ApplicationType.Android) {
                                    BallGame.displayVideoAd();
                                }
                                //BallGame.adsController.setRewarded(true);
                            }
                        }
                    } */ else {

                    }
                    //}
                }
            } else if (Variables.screen == 6) {//settings screen
                if (Variables.facebook.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Gdx.net.openURI("https://www.facebook.com/flyingbrowniegame/?ref=nf");
                } else if (Variables.instagram.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Gdx.net.openURI("https://www.instagram.com/flyingbrowniegames/?hl=en");
                } else if (Variables.homesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                } else if (Variables.credit_sprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Gdx.net.openURI("http://flyingbrowniegames.com/");
                }
                if (Variables.soundsprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    if (Variables.prefs_sound.getInteger("sound") == 2) {
                        Variables.soundsprite = sprites.get("sound");
                        //Variables.soundsprite.scale((((1) * (w)) / ((6) * (Variables.soundsprite.getWidth()))) - 1);
                        Variables.prefs_sound.clear();
                        Variables.prefs_sound.putInteger("sound", 1);
                        Variables.prefs_sound.flush();
                    } else {
                        Variables.soundsprite = sprites.get(("mute"));
                        //Variables.soundsprite.scale((((1) * (w)) / ((6) * (Variables.soundsprite.getWidth()))) - 1);
                        Variables.prefs_sound.clear();
                        Variables.prefs_sound.putInteger("sound", 2);
                        Variables.prefs_sound.flush();
                    }
                }
                if ((Variables.music.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                    if (Variables.prefs_music.getInteger("music") == 2) {
                        Variables.music = sprites.get(("music"));
                        //Variables.music.scale((((1) * (w)) / ((6) * (Variables.music.getWidth()))) - 1);
                        Variables.prefs_music.clear();
                        Variables.prefs_music.putInteger("music", 1);
                        Variables.prefs_music.flush();
                    } else {
                        Variables.music = sprites.get(("mmute"));
                        //Variables.music.scale((((1) * (w)) / ((6) * (Variables.music.getWidth()))) - 1);
                        Variables.prefs_music.clear();
                        Variables.prefs_music.putInteger("music", 2);
                        Variables.prefs_music.flush();
                    }
                }
                if (Gdx.app.getType() == Application.ApplicationType.Android) {
                    if (signedOut.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && !BallGame.playServices.isSignedIn()) {
                        BallGame.playServices.signIn();
                    } else if (signedIn.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && BallGame.playServices.isSignedIn()) {
                        BallGame.playServices.signOut();
                    }
                }
            } else if (Variables.screen == 7) { //modes screen
                if (Variables.homesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                    //Gdx.input.getX() > (Variables.w - ((Variables.w * 9) / 28)) - ((10 * Variables.w) / 32)
                } else if (Gdx.input.getY() > ((h / 7))) {
                    if (Variables.classicsprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        Variables.screen = 24;
                        screenLoop = 0;
                    } else if (Variables.mirrorsprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        Variables.screen = 8;
                        screenLoop = 0;
                    } else if (Variables.blindsprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        Variables.screen = 9;
                        screenLoop = 0;
                    } else if (Variables.burstsprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        Variables.screen = 10;
                        screenLoop = 0;
                    } else if (Variables.double2sprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        Variables.screen = 11;
                        screenLoop = 0;
                    } else if (Variables.extremesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        Variables.screen = 22;
                        screenLoop = 0;
                    } else if (Variables.extremefsprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        Variables.screen = 13;
                        screenLoop = 0;
                    } else if (Variables.duosprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        Variables.screen = 14;
                        screenLoop = 0;
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (Exception e) {

                }
            } else if (Variables.screen == 8) {//mirror start
                if (randomizeButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    achievementActions.randomizeAchievement(2);
                } else if (fastforwardButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    achievementActions.skipAchievement(2);
                } else {
                    Variables.screen = 15;
                    if (mirrorCompleted.getInteger("mirrorCompleted") != 25) {
                        type = mirrorTypes[mirrorCurrent.getInteger("mirrorCurrent")];
                        achievementIndex = mirrorCurrent.getInteger("mirrorCurrent");
                        achievementCumulatives = mirrorCumulatives;
                    } else {
                        type = "finished";
                    }
                    screenLoop = 0;
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                    restarted = 0;
                    if (Gdx.app.getType() == Application.ApplicationType.Android) {
                        BallGame.adsController.setRewarded(false);
                    }
                }
            } else if (Variables.screen == 9) {//blind start
                if (randomizeButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    achievementActions.randomizeAchievement(3);
                } else if (fastforwardButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    achievementActions.skipAchievement(3);
                } else {
                    if (blindCompleted.getInteger("blindCompleted") != 25) {
                        type = blindTypes[blindCurrent.getInteger("blindCurrent")];
                        achievementIndex = blindCurrent.getInteger("blindCurrent");
                        achievementCumulatives = blindCumulatives;
                    } else {
                        type = "finished";
                    }
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                    Variables.screen = 16;
                    screenLoop = 0;
                    restarted = 0;
                    if (Gdx.app.getType() == Application.ApplicationType.Android) {
                        BallGame.adsController.setRewarded(false);
                    }
                }
            } else if (Variables.screen == 10) {//burst start
                if (randomizeButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    achievementActions.randomizeAchievement(4);
                } else if (fastforwardButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    achievementActions.skipAchievement(4);
                } else {
                    if (burstCompleted.getInteger("burstCompleted") != 25) {
                        type = burstTypes[burstCurrent.getInteger("burstCurrent")];
                        achievementIndex = burstCurrent.getInteger("burstCurrent");
                        achievementCumulatives = burstCumulatives;
                    } else {
                        type = "finished";
                    }
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                    Variables.screen = 17;
                    screenLoop = 0;
                    restarted = 0;
                    if (Gdx.app.getType() == Application.ApplicationType.Android) {
                        BallGame.adsController.setRewarded(false);
                    }
                }
            } else if (Variables.screen == 11) {//double start
                if (randomizeButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    achievementActions.randomizeAchievement(5);
                } else if (fastforwardButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    achievementActions.skipAchievement(5);
                } else {
                    if (doubleCompleted.getInteger("doubleCompleted") != 25) {
                        type = doubleTypes[doubleCurrent.getInteger("doubleCurrent")];
                        achievementIndex = doubleCurrent.getInteger("doubleCurrent");
                        achievementCumulatives = doubleCumulatives;
                    } else {
                        type = "finished";
                    }
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                    Double.arc_degree22 = 270;
                    Double.arc_degree12 = 90;
                    if (secondrightball.isFlipX()) {

                    } else {
                        secondrightball.flip(true, false);
                        secondleftball.flip(false, false);
                    }
                    Variables.screen = 18;
                    screenLoop = 0;
                    restarted = 0;
                    if (Gdx.app.getType() == Application.ApplicationType.Android) {
                        BallGame.adsController.setRewarded(false);
                    }
                }
            } else if (Variables.screen == 12) {
                Variables.screen = 19;
                screenLoop = 0;
                restarted = 0;
                if (Gdx.app.getType() == Application.ApplicationType.Android) {
                    BallGame.adsController.setRewarded(false);
                }
            } else if (Variables.screen == 13) {
                Variables.screen = 20;
                screenLoop = 0;
                restarted = 0;
                if (Gdx.app.getType() == Application.ApplicationType.Android) {
                    BallGame.adsController.setRewarded(false);
                }
            } else if (Variables.screen == 14) {
                if (duoreset.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    duoscore1.clear();
                    duoscore1.flush();
                    Duo.loop = 0;
                    //System.out.println("tapped1");
                } else if (duoreset2.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Duo.loop = 0;
                    duoscore2.clear();
                    duoscore2.flush();
                    //System.out.println("tapped2");
                } else {
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                    Duo.arc_degree12 = 90;
                    Duo.arc_degree22 = 270;
                    Variables.screen = 21;
                    screenLoop = 0;
                    restarted = 0;
                    //deathhome.setOriginCenter();
                    if (Gdx.app.getType() == Application.ApplicationType.Android) {
                        BallGame.adsController.setRewarded(false);
                    }
                }

            } else if (Variables.screen == 15) {
                if (Variables.pause.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && (System.currentTimeMillis() - pausetime > 3000)) {
                    //System.out.println("paused");
                    Variables.paused = true;
                    // Gdx.app.getApplicationListener().pause();
                    // Variables.paused = true;
                } else if (Variables.duopauseresume.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.pausetime = System.currentTimeMillis();
                    Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
                    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                    Variables.paused = false;
                } else if (Variables.duopausehome.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    ResetScreens.resetVariables();
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                    Variables.paused = false;
                    Others.add_diamonds(0);
                } else if (Variables.duopausehowto.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.screen = 25;
                    screenLoop = 0;
                } else {
                    MoveBall.change_angle(x, y);
                }

            } else if (Variables.screen == 16) {
                if (Variables.pause.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && (System.currentTimeMillis() - pausetime > 3000)) {
                    //System.out.println("paused");
                    Variables.paused = true;
                    // Gdx.app.getApplicationListener().pause();
                    // Variables.paused = true;
                } else if (Variables.duopauseresume.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.pausetime = System.currentTimeMillis();
                    Variables.paused = false;
                } else if (Variables.duopausehome.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    ResetScreens.resetVariables();
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                    Variables.paused = false;
                    Others.add_diamonds(0);
                } else if (Variables.duopausehowto.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.screen = 25;
                    screenLoop = 0;
                } else {
                    MoveBall.change_angle(x, y);
                }
            } else if (Variables.screen == 17) {
                if (Variables.pause.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && (System.currentTimeMillis() - pausetime > 3000)) {
                    //System.out.println("paused");
                    Variables.paused = true;
                    // Gdx.app.getApplicationListener().pause();
                    // Variables.paused = true;
                } else if (Variables.duopauseresume.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.pausetime = System.currentTimeMillis();
                    Variables.paused = false;
                } else if (Variables.duopausehome.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    ResetScreens.resetVariables();
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                    Variables.paused = false;
                    Others.add_diamonds(0);
                } else if (Variables.duopausehowto.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.screen = 25;
                    screenLoop = 0;
                } else {
                    MoveBall.change_angle(x, y);
                }
            } else if (Variables.screen == 18) {
                if (Variables.pause.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && (System.currentTimeMillis() - pausetime > 3000)) {
                    //System.out.println("paused");
                    Variables.paused = true;
                    // Gdx.app.getApplicationListener().pause();
                    // Variables.paused = true;
                } else if (Variables.duopauseresume.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.pausetime = System.currentTimeMillis();
                    Variables.paused = false;
                } else if (Variables.duopausehome.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    ResetScreens.resetVariables();
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                    Variables.paused = false;
                    Others.add_diamonds(0);
                } else if (Variables.duopausehowto.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.screen = 25;
                    screenLoop = 0;
                }
          /*  if(x< Variables.w){
                left =true;
            }
            if(x >= Variables.w){
                right =true;
            }
            MoveBall.change_double_angle();
            */
            } else if (Variables.screen == 19) {
                if (Variables.pause.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && (System.currentTimeMillis() - pausetime > 3000)) {
                    //System.out.println("paused");
                    Variables.paused = true;
                    // Gdx.app.getApplicationListener().pause();
                    // Variables.paused = true;
                } else if (Variables.duopauseresume.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.pausetime = System.currentTimeMillis();
                    Variables.paused = false;
                } else if (Variables.duopausehome.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    ResetScreens.resetVariables();
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                    Variables.paused = false;
                    Others.add_diamonds(0);
                } else if (Variables.duopausehowto.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.screen = 25;
                    screenLoop = 0;
                } else if (checkbox.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    if (extremepause.getBoolean("pause") == true) {
                        extremepause.clear();
                        extremepause.putBoolean("pause", false);
                        extremepause.flush();

                    } else {
                        extremepause.clear();
                        extremepause.putBoolean("pause", true);
                        extremepause.flush();
                    }

                }
                //  com.flyingbrowniegames.ballgame.MoveBall.moveextremangle(x,y);
            } else if (Variables.screen == 20) {
                if (Variables.pause.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && (System.currentTimeMillis() - pausetime > 3000)) {
                    //System.out.println("paused");
                    Variables.paused = true;
                    // Gdx.app.getApplicationListener().pause();
                    // Variables.paused = true;
                } else if (Variables.duopauseresume.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.pausetime = System.currentTimeMillis();
                    Variables.paused = false;
                } else if (Variables.duopausehome.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    ResetScreens.resetVariables();
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                    Variables.paused = false;
                    Others.add_diamonds(0);
                } else if (Variables.duopausehowto.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.screen = 25;
                    screenLoop = 0;
                }
                // com.flyingbrowniegames.ballgame.MoveBall.moveextremangle(x,y);
            } else if (Variables.screen == 21) {
                if (paused == false && Variables.pause.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && (System.currentTimeMillis() - pausetime > 3000)) {
                    //System.out.println("paused");
                    Variables.paused = true;
                } else if (Variables.duopauseresume.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.pausetime = System.currentTimeMillis();
                    Variables.paused = false;
                } else if (Variables.duopausehome.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    ResetScreens.resetVariables();
                    Others.add_diamonds(0);
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                    Variables.paused = false;
                } else if (Variables.duopausehowto.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()) && paused == true) {
                    Variables.screen = 25;
                    screenLoop = 0;
                }
            } else if (Variables.screen == 22) {
                if (Variables.normalsprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Variables.screen = 12;
                    screenLoop = 0;
                    Variables.balls = 3;
                } else if (Variables.woesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Variables.screen = 12;
                    screenLoop = 0;
                    Variables.balls = 4;
                } else if (Variables.abysssprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Variables.screen = 12;
                    screenLoop = 0;
                    Variables.balls = 5;
                } else if (Variables.tormentsprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Variables.screen = 12;
                    screenLoop = 0;
                    Variables.balls = 6;
                }
            } else if (Variables.screen == 23) {
                if (Variables.homesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    Variables.screen = 1;
                    screenLoop = 0;
                    mainscoreloop = 0;
                } else if (statscreen.achievements.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    if (Gdx.app.getType() == Application.ApplicationType.Android) {
                        BallGame.playServices.showAchievement();
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                        //BallGame.iActivityRequestHandler.loadAchievements();
                        //BallGame.iActivityRequestHandler.showAchievementsView();
                        //BallGame.iActivityRequestHandler.signIn();
                    }
                } else if (statscreen.leader.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    if (blindTypes[blindCurrent.getInteger("blindCurrent")].equalsIgnoreCase("leaderboard")) {
                        //System.out.println("blindleaderboard");
                        achievementActions.completeAchievement(3, blindCurrent.getInteger("blindCurrent"));
                    }
                    if (burstTypes[burstCurrent.getInteger("burstCurrent")].equalsIgnoreCase("leaderboard")) {
                        //System.out.println("burstleaderboard");
                        achievementActions.completeAchievement(4, burstCurrent.getInteger("burstCurrent"));
                    }
                    if (Gdx.app.getType() == Application.ApplicationType.Android) {
                        BallGame.playServices.showsScore();
                    } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                        //BallGame.iActivityRequestHandler.loadLeaderboards();
                        BallGame.iActivityRequestHandler.showLeaderboardsView();
                        //BallGame.iActivityRequestHandler.signIn();
                    }
                }
            } else if (Variables.screen == 24) {//classic start
                if (randomizeButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    achievementActions.randomizeAchievement(1);
                } else if (fastforwardButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    achievementActions.skipAchievement(1);
                } else {
                    if (classicCompleted.getInteger("classicCompleted") != 25) {
                        type = classicTypes[classicCurrent.getInteger("classicCurrent")];
                        achievementIndex = classicCurrent.getInteger("classicCurrent");
                        achievementCumulatives = classicCumulatives;
                    } else {
                        type = "finished";
                    }
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                    Variables.screen = 2;
                    screenLoop = 0;
                    restarted = 0;
                    if (Gdx.app.getType() == Application.ApplicationType.Android) {
                        BallGame.adsController.setRewarded(false);
                    }
                }
            } else if (Variables.screen == 25 && Variables.paused == false) {
                if (checkButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    //System.out.println("mode" + mode);
                    switch (mode) {
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
//                    case 8:
//                        Variables.screen = 14;
//                        screenLoop = 0;
//                        break;
                    }
                } else if (gotit.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    if (mode == 8) {
                        screen = 14;
                        screenLoop = 0;
                    }
                }
            } else if (Variables.screen == 25 && Variables.paused == true) {
                if (checkButton.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    switch (mode) {
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
//                    case 8:
//                        Variables.screen = 21;
//                        screenLoop = 0;
//                        break;
                    }
                } else if (gotit.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                    screen = 21;
                    screenLoop = 0;
                }
            } else if (screen == 26) {
                MoveBall.change_angle(x, y);
                //System.out.println(leftball.isFlipX() + " leftball");
                //System.out.println(rightball.isFlipX() + " rightball");
                //System.out.println(sprites.get("redhalf").isFlipX() + " redhalf");
                //System.out.println(sprites.get("bluehalf").isFlipX() + " bluehalf");
            } else if (Variables.screen == 27) { //new modes screen
                if (!openAchievement) {
                    if (Variables.homesprite.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                        Variables.screen = 1;
                        screenLoop = 0;
                        mainscoreloop = 0;
                        //Gdx.input.getX() > (Variables.w - ((Variables.w * 9) / 28)) - ((10 * Variables.w) / 32)
                    } else if (Gdx.input.getY() > ((h / 7))) {
                        if ((blackStar1.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar1.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                            openAchievement = true;
                            if (classicCompleted.getInteger("classicCompleted") != 25) {
                                glyphLayout.setText(achievementFont, classicAchievements[classicCurrent.getInteger("classicCurrent")]);
                                percentageLayout.setText(percentageFont, (String.valueOf(((classicCompleted.getInteger("classicCompleted")) * 4))) + "%");
                                progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" +
                                        (achievementActions.setRequirement(classicRequirements, classicCurrent.getInteger("classicCurrent"), classicCumulatives))));
                            } else {
                                glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" + ("100")));
                                percentageLayout.setText(percentageFont, "100%");
                            }
                            modeClicked = 1;
                        } else if ((blackStar2.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar2.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                            openAchievement = true;
                            if (mirrorCompleted.getInteger("mirrorCompleted") != 25) {
                                glyphLayout.setText(achievementFont, mirrorAchievements[mirrorCurrent.getInteger("mirrorCurrent")]);
                                percentageLayout.setText(percentageFont, (String.valueOf(((mirrorCompleted.getInteger("mirrorCompleted")) * 4))) + "%");
                                progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" +
                                        (achievementActions.setRequirement(mirrorRequirements, mirrorCurrent.getInteger("mirrorCurrent"), mirrorCumulatives))));
                            } else {
                                glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" + ("100")));
                                percentageLayout.setText(percentageFont, "100%");
                            }
                            modeClicked = 2;
                        } else if ((blackStar3.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar3.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                            openAchievement = true;
                            if (blindCompleted.getInteger("blindCompleted") != 25) {
                                glyphLayout.setText(achievementFont, blindAchievements[blindCurrent.getInteger("blindCurrent")]);
                                percentageLayout.setText(percentageFont, (String.valueOf(((blindCompleted.getInteger("blindCompleted")) * 4))) + "%");
                                progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" +
                                        (achievementActions.setRequirement(blindRequirements, blindCurrent.getInteger("blindCurrent"), blindCumulatives))));
                            } else {
                                glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" + ("100")));
                                percentageLayout.setText(percentageFont, "100%");
                            }
                            modeClicked = 3;
                        } else if ((blackStar4.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar4.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                            openAchievement = true;
                            if (burstCompleted.getInteger("burstCompleted") != 25) {
                                glyphLayout.setText(achievementFont, burstAchievements[burstCurrent.getInteger("burstCurrent")]);
                                percentageLayout.setText(percentageFont, (String.valueOf(((burstCompleted.getInteger("burstCompleted")) * 4))) + "%");
                                progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" +
                                        (achievementActions.setRequirement(burstRequirements, burstCurrent.getInteger("burstCurrent"), burstCumulatives))));
                            } else {
                                glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" + ("100")));
                                percentageLayout.setText(percentageFont, "100%");
                            }
                            modeClicked = 4;
                        } else if ((blackStar5.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar5.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                            openAchievement = true;
                            if (doubleCompleted.getInteger("doubleCompleted") != 25) {
                                glyphLayout.setText(achievementFont, doubleAchievements[doubleCurrent.getInteger("doubleCurrent")]);
                                percentageLayout.setText(percentageFont, (String.valueOf(((doubleCompleted.getInteger("doubleCompleted")) * 4))) + "%");
                                progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" +
                                        (achievementActions.setRequirement(doubleRequirements, doubleCurrent.getInteger("doubleCurrent"), doubleCumulatives))));
                            } else {
                                glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" + ("100")));
                                percentageLayout.setText(percentageFont, "100%");
                            }
                            modeClicked = 5;
                        }/* else if ((blackStar6.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) || (goldstar6.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY()))) {
                            openAchievement = true;
                            modeClicked = 7;
                        }*/ else if (Variables.classicModeIcon.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                            Variables.screen = 24;
                            if (classicCompleted.getInteger("classicCompleted") != 25) {
                                glyphLayout.setText(achievementFont, classicAchievements[classicCurrent.getInteger("classicCurrent")]);
                                progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" +
                                        (achievementActions.setRequirement(classicRequirements, classicCurrent.getInteger("classicCurrent"), classicCumulatives))));
                            } else {
                                glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" + ("100")));
                            }
                            screenLoop = 0;
                        } else if (Variables.mirrorModeIcon.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                            Variables.screen = 8;
                            if (mirrorCompleted.getInteger("mirrorCompleted") != 25) {
                                glyphLayout.setText(achievementFont, mirrorAchievements[mirrorCurrent.getInteger("mirrorCurrent")]);
                                progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" +
                                        (achievementActions.setRequirement(mirrorRequirements, mirrorCurrent.getInteger("mirrorCurrent"), mirrorCumulatives))));
                            } else {
                                glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" + ("100")));
                            }
                            screenLoop = 0;
                        } else if (Variables.blindModeIcon.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                            Variables.screen = 9;
                            if (blindCompleted.getInteger("blindCompleted") != 25) {
                                glyphLayout.setText(achievementFont, blindAchievements[blindCurrent.getInteger("blindCurrent")]);
                                progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" +
                                        (achievementActions.setRequirement(blindRequirements, blindCurrent.getInteger("blindCurrent"), blindCumulatives))));
                            } else {
                                glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" + ("100")));
                            }
                            screenLoop = 0;
                        } else if (Variables.burstModeIcon.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                            Variables.screen = 10;
                            if (burstCompleted.getInteger("burstCompleted") != 25) {
                                glyphLayout.setText(achievementFont, burstAchievements[burstCurrent.getInteger("burstCurrent")]);
                                progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" +
                                        (achievementActions.setRequirement(burstRequirements, burstCurrent.getInteger("burstCurrent"), burstCumulatives))));
                            } else {
                                glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" + ("100")));
                            }
                            screenLoop = 0;
                        } else if (Variables.doubleModeIcon.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                            Variables.screen = 11;
                            if (doubleCompleted.getInteger("doubleCompleted") != 25) {
                                glyphLayout.setText(achievementFont, doubleAchievements[doubleCurrent.getInteger("doubleCurrent")]);
                                progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" +
                                        (achievementActions.setRequirement(doubleRequirements, doubleCurrent.getInteger("doubleCurrent"), doubleCumulatives))));
                            } else {
                                glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                                progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" + ("100")));
                            }
                            screenLoop = 0;
                        } else if (Variables.extremeModeIcon.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                            Variables.screen = 22;
                            screenLoop = 0;
                        } else if (Variables.extremeFlipModeIcon.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                            Variables.screen = 13;
                            screenLoop = 0;
                        } else if (Variables.duoModeIcon.getBoundingRectangle().contains(Gdx.input.getX(), h - Gdx.input.getY())) {
                            Variables.screen = 14;
                            screenLoop = 0;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }

            }
        }
        return false;


    }


    @Override
    public boolean longPress(float x, float y) {

        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
//        if (Variables.screen == 27 && Variables.deltaY < (10 * h) / 69 && Variables.deltaY > -(600 * h) / 600 && Gdx.input.getY() > Variables.modetitle.getHeight()) {
//            Variables.deltaY += velocityY;
//            //Variables.deltaX += Gdx.input.getDeltaY();
//            if (Variables.deltaY > ((10 * h) / 69) - 1) {
//                Variables.deltaY = ((10 * h) / 69) - 1;
//            } else if (Variables.deltaY < (-(600 * h) / 600) + 1) {
//                Variables.deltaY = (-(600 * h) / 600) + 1;
//            }
//        }
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        if (!openAchievement) {
            if (Variables.screen == 27 && Variables.deltaY < (10 * h) / 69 && Variables.deltaY > -(600 * h) / 600 && Gdx.input.getY() > Variables.modetitle.getHeight()) {
                Variables.deltaY += Gdx.input.getDeltaY();
                Variables.deltaX += Gdx.input.getDeltaY();
                if (Variables.deltaY > ((10 * h) / 69) - 1) {
                    Variables.deltaY = ((10 * h) / 69) - 1;
                } else if (Variables.deltaY < (-(600 * h) / 600) + 1) {
                    Variables.deltaY = (-(600 * h) / 600) + 1;

                }
            }
        }
        if (openShop) {
            int multiple = 9 + (charactersBought.length - 14);
            if (Gdx.input.getY() > 0 && Gdx.input.getY() <= ((h / 2) + (characterShopPage.getBoundingRectangle().getHeight() / 2) - ((1 * characterShopBar.getBoundingRectangle().getHeight()) / 2))) {
                shopY += Gdx.input.getDeltaY();
                if (shopY > (characterShopTitleBar.getBoundingRectangle().getHeight() / 2 + ((h) / 16))) {
                    shopY = characterShopTitleBar.getBoundingRectangle().getHeight() / 2 + ((h) / 16);
                } else if (shopY < (-(multiple * (characterShopBar.getBoundingRectangle().getHeight()))) + (characterShopTitleBar.getBoundingRectangle().getHeight() / 2 + ((h) / 32))) {
                    shopY = (-(multiple * (characterShopBar.getBoundingRectangle().getHeight()))) + (characterShopTitleBar.getBoundingRectangle().getHeight() / 2 + ((h) / 32));
                }
            }
        }

        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        Variables.y = Gdx.input.getDeltaY();
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2
            pointer1, Vector2 pointer2) {
        return false;
    }
}
