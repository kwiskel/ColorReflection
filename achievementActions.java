package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.actions.IntAction;

import static com.flyingbrowniegames.ballgame.BallGame.startTime;
import static com.flyingbrowniegames.ballgame.MoveBall.full_way;
import static com.flyingbrowniegames.ballgame.Variables.achievementBanner;
import static com.flyingbrowniegames.ballgame.Variables.achievementCumulatives;
import static com.flyingbrowniegames.ballgame.Variables.achievementFont;
import static com.flyingbrowniegames.ballgame.Variables.achievementIndex;
import static com.flyingbrowniegames.ballgame.Variables.achievementLayout;
import static com.flyingbrowniegames.ballgame.Variables.achievementStars;
import static com.flyingbrowniegames.ballgame.Variables.achievementStartTime;
import static com.flyingbrowniegames.ballgame.Variables.achievementTime;
import static com.flyingbrowniegames.ballgame.Variables.achievementUnlocked;
import static com.flyingbrowniegames.ballgame.Variables.bannerDropTime;
import static com.flyingbrowniegames.ballgame.Variables.bannerY;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.blindAchievements;
import static com.flyingbrowniegames.ballgame.Variables.blindColourCount;
import static com.flyingbrowniegames.ballgame.Variables.blindCompleted;
import static com.flyingbrowniegames.ballgame.Variables.blindCumulatives;
import static com.flyingbrowniegames.ballgame.Variables.blindCurrent;
import static com.flyingbrowniegames.ballgame.Variables.blindCurrentProgress;
import static com.flyingbrowniegames.ballgame.Variables.blindOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.blindProgress;
import static com.flyingbrowniegames.ballgame.Variables.blindRequirements;
import static com.flyingbrowniegames.ballgame.Variables.blindSkipped;
import static com.flyingbrowniegames.ballgame.Variables.blindTypes;
import static com.flyingbrowniegames.ballgame.Variables.bounceCount;
import static com.flyingbrowniegames.ballgame.Variables.burstAchievements;
import static com.flyingbrowniegames.ballgame.Variables.burstColourCount;
import static com.flyingbrowniegames.ballgame.Variables.burstCompleted;
import static com.flyingbrowniegames.ballgame.Variables.burstCumulatives;
import static com.flyingbrowniegames.ballgame.Variables.burstCurrent;
import static com.flyingbrowniegames.ballgame.Variables.burstCurrentProgress;
import static com.flyingbrowniegames.ballgame.Variables.burstOccurCount;
import static com.flyingbrowniegames.ballgame.Variables.burstOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.burstProgress;
import static com.flyingbrowniegames.ballgame.Variables.burstRequirements;
import static com.flyingbrowniegames.ballgame.Variables.burstScoreCount;
import static com.flyingbrowniegames.ballgame.Variables.burstSkipped;
import static com.flyingbrowniegames.ballgame.Variables.burstTypes;
import static com.flyingbrowniegames.ballgame.Variables.classicAchievements;
import static com.flyingbrowniegames.ballgame.Variables.classicCompleted;
import static com.flyingbrowniegames.ballgame.Variables.classicCumulatives;
import static com.flyingbrowniegames.ballgame.Variables.classicCurrent;
import static com.flyingbrowniegames.ballgame.Variables.classicCurrentProgress;
import static com.flyingbrowniegames.ballgame.Variables.classicOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.classicProgress;
import static com.flyingbrowniegames.ballgame.Variables.classicRequirements;
import static com.flyingbrowniegames.ballgame.Variables.classicSkipped;
import static com.flyingbrowniegames.ballgame.Variables.classicTypes;
import static com.flyingbrowniegames.ballgame.Variables.doubleAchievements;
import static com.flyingbrowniegames.ballgame.Variables.doubleColour;
import static com.flyingbrowniegames.ballgame.Variables.doubleColour2;
import static com.flyingbrowniegames.ballgame.Variables.doubleCompleted;
import static com.flyingbrowniegames.ballgame.Variables.doubleCumulatives;
import static com.flyingbrowniegames.ballgame.Variables.doubleCurrent;
import static com.flyingbrowniegames.ballgame.Variables.doubleCurrentProgress;
import static com.flyingbrowniegames.ballgame.Variables.doubleDie;
import static com.flyingbrowniegames.ballgame.Variables.doubleOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.doubleProgress;
import static com.flyingbrowniegames.ballgame.Variables.doubleRequirements;
import static com.flyingbrowniegames.ballgame.Variables.doubleSkipped;
import static com.flyingbrowniegames.ballgame.Variables.doubleTypes;
import static com.flyingbrowniegames.ballgame.Variables.extremeFlipCompleted;
import static com.flyingbrowniegames.ballgame.Variables.extremeFlipCurrent;
import static com.flyingbrowniegames.ballgame.Variables.extremeFlipOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.extremeFlipProgress;
import static com.flyingbrowniegames.ballgame.Variables.finishedScore;
import static com.flyingbrowniegames.ballgame.Variables.flipCount;
import static com.flyingbrowniegames.ballgame.Variables.glyphLayout;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.matchCount;
import static com.flyingbrowniegames.ballgame.Variables.mirrorAchievements;
import static com.flyingbrowniegames.ballgame.Variables.mirrorCompleted;
import static com.flyingbrowniegames.ballgame.Variables.mirrorCumulatives;
import static com.flyingbrowniegames.ballgame.Variables.mirrorCurrent;
import static com.flyingbrowniegames.ballgame.Variables.mirrorCurrentProgress;
import static com.flyingbrowniegames.ballgame.Variables.mirrorOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.mirrorProgress;
import static com.flyingbrowniegames.ballgame.Variables.mirrorRequirements;
import static com.flyingbrowniegames.ballgame.Variables.mirrorSkipped;
import static com.flyingbrowniegames.ballgame.Variables.mirrorTypes;
import static com.flyingbrowniegames.ballgame.Variables.mode;
import static com.flyingbrowniegames.ballgame.Variables.moneyLayout;
import static com.flyingbrowniegames.ballgame.Variables.percentageFont;
import static com.flyingbrowniegames.ballgame.Variables.percentageLayout;
import static com.flyingbrowniegames.ballgame.Variables.progressFont;
import static com.flyingbrowniegames.ballgame.Variables.progressLayout;
import static com.flyingbrowniegames.ballgame.Variables.random;
import static com.flyingbrowniegames.ballgame.Variables.score;
import static com.flyingbrowniegames.ballgame.Variables.showBanner;
import static com.flyingbrowniegames.ballgame.Variables.sideTap;
import static com.flyingbrowniegames.ballgame.Variables.sideTapScore;
import static com.flyingbrowniegames.ballgame.Variables.throughCount;
import static com.flyingbrowniegames.ballgame.Variables.type;
import static com.flyingbrowniegames.ballgame.Variables.userBrownies;
import static com.flyingbrowniegames.ballgame.BallGame.elapsedTime;
import static com.flyingbrowniegames.ballgame.Variables.w;
import static com.flyingbrowniegames.ballgame.Variables.wasReflected;
import static com.flyingbrowniegames.ballgame.Variables.widthspeed;

/**
 * Created by kyle on 2017-07-18.
 */

public class achievementActions {

    public static void randomizeAchievement(int mode) {
        if (spendBrownies(25)) {
            switch (mode) {
                case 1: //classic
                    if (classicCompleted.getInteger("classicCompleted") == 24) {

                    } else {
                        randomAchievement(classicProgress, classicSkipped, "classicSkipped", classicCurrent, "classicCurrent");
                        glyphLayout.setText(achievementFont, classicAchievements[classicCurrent.getInteger("classicCurrent")]);
                        progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(classicRequirements, classicCurrent.getInteger("classicCurrent"), classicCumulatives))));
                    }
                    break;
                case 2: //mirror
                    if (mirrorCompleted.getInteger("mirrorCompleted") == 24) {

                    } else {
                        randomAchievement(mirrorProgress, mirrorSkipped, "mirrorSkipped", mirrorCurrent, "mirrorCurrent");
                        glyphLayout.setText(achievementFont, mirrorAchievements[mirrorCurrent.getInteger("mirrorCurrent")]);
                        progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(mirrorRequirements, mirrorCurrent.getInteger("mirrorCurrent"), mirrorCumulatives))));
                    }
                    break;
                case 3: //blind
                    if (blindCompleted.getInteger("blindCompleted") == 24) {

                    } else {
                        randomAchievement(blindProgress, blindSkipped, "blindSkipped", blindCurrent, "blindCurrent");
                        glyphLayout.setText(achievementFont, blindAchievements[blindCurrent.getInteger("blindCurrent")]);
                        progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(blindRequirements, blindCurrent.getInteger("blindCurrent"), blindCumulatives))));
                    }
                    break;
                case 4://burst
                    if (burstCompleted.getInteger("burstCompleted") == 24) {

                    } else {
                        randomAchievement(burstProgress, burstSkipped, "burstSkipped", burstCurrent, "burstCurrent");
                        glyphLayout.setText(achievementFont, burstAchievements[burstCurrent.getInteger("burstCurrent")]);
                        progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(burstRequirements, burstCurrent.getInteger("burstCurrent"), burstCumulatives))));
                    }
                    break;
                case 5: //double
                    if (doubleCompleted.getInteger("doubleCompleted") == 24) {

                    } else {
                        randomAchievement(doubleProgress, doubleSkipped, "doubleSkipped", doubleCurrent, "doubleCurrent");
                        glyphLayout.setText(achievementFont, doubleAchievements[doubleCurrent.getInteger("doubleCurrent")]);
                        progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" +
                                (achievementActions.setRequirement(doubleRequirements, doubleCurrent.getInteger("doubleCurrent"), doubleCumulatives))));
                    }
                    break;
                case 7: //extremeFlip
                    break;
            }
        } else {//user does not have enough brownies to spend

        }
    }

    public static void randomAchievement(int[] completed, Preferences skipped, String skippedId, Preferences current, String currentId) {//select a new achievemnt randomly
        String easyLeft = "";
        String mediumLeft = "";
        String hardLeft = "";
        int newA = 0;
        int oldA = current.getInteger(currentId);
        for (int i = 0; i < 25; i++) {
            if (i <= 9) {//easy range
                if (i != skipped.getInteger(skippedId) && i != current.getInteger(currentId) && completed[i] == 0) {
                    easyLeft += String.valueOf(i);
                }
            } else if (i <= 19 && i > 9) {//medium range
                if (i != skipped.getInteger(skippedId) && i != current.getInteger(currentId) && completed[i] == 0) {
                    mediumLeft += String.valueOf(i - 10);
                }
            } else {//hard range
                if (i != skipped.getInteger(skippedId) && i != current.getInteger(currentId) && completed[i] == 0) {
                    hardLeft += String.valueOf(i - 20);
                }
            }
        }
        //System.out.println(mediumLeft + "medium");
        if (easyLeft.length() == 0 && mediumLeft.length() == 0 && hardLeft.length() == 0) {
            newA = skipped.getInteger(skippedId);
        } else if (easyLeft.length() + (mediumLeft.length()) == 1) {
            if (easyLeft.length() == 1) {//easy achievement
                newA = Integer.parseInt(easyLeft);
            } else {//medium achievement
                newA = Integer.parseInt(mediumLeft) + 10;
            }

        } else if (easyLeft.length() + (mediumLeft.length()) > 1) {
            int randomized = random.nextInt((easyLeft.length() + (mediumLeft.length()) - 1));
            //System.out.println("random" + randomized);
            if (randomized >= easyLeft.length()) {//medium achivement was selected
                newA = 10 + Integer.parseInt(mediumLeft.substring(randomized - (easyLeft.length()), randomized - easyLeft.length() + 1));
            } else {//easy achievement was selected
                newA = Integer.parseInt(easyLeft.substring(randomized, randomized + 1));
            }
        } else {//no uncompleted achievements in easy or medium
            if (hardLeft.length() == 1) {//only 1 hard achievement left
                newA = 20 + Integer.parseInt(hardLeft);
            } else {//more than 1 hard achievement uncompleted
                int randomized = random.nextInt(hardLeft.length() - 1);
                newA = 20 + Integer.parseInt(hardLeft.substring(randomized, randomized + 1));
            }
        }
        //System.out.println(oldA + "oldA");
        //System.out.println(newA + "newA");
        skipped.clear();
        skipped.putInteger(skippedId, oldA);
        skipped.flush();
        current.clear();
        current.putInteger(currentId, newA);
        current.flush();
    }

    public static void skipAchievement(int mode) {
        if (spendBrownies(110)) {
            switch (mode) {
                case 1: //classic
                    completeAchievement(1, classicCurrent.getInteger("classicCurrent"));
                    break;
                case 2: //mirror
                    completeAchievement(2, mirrorCurrent.getInteger("mirrorCurrent"));
                    break;
                case 3: //blind
                    completeAchievement(3, blindCurrent.getInteger("blindCurrent"));
                    break;
                case 4://burst
                    completeAchievement(4, burstCurrent.getInteger("burstCurrent"));
                    break;
                case 5: //double
                    completeAchievement(5, doubleCurrent.getInteger("doubleCurrent"));
                    break;
                case 7: //extremeFlip
                    completeAchievement(7, extremeFlipCurrent.getInteger("extremeFlipCurrent"));
                    break;
            }
        } else {//user does not have enough brownies to spend

        }
    }

    public static boolean spendBrownies(int amount) {//user spends brownies
        int current = userBrownies.getInteger("brownies");
        if (current - amount >= 0) {//user has sufficient currency to spend
            if (amount == 110) {
                current -= 150;
            } else {
                current -= amount;
            }
            userBrownies.clear();
            userBrownies.putInteger("brownies", current);
            userBrownies.flush();
            moneyLayout.setText(achievementFont, String.valueOf(userBrownies.getInteger("brownies")));
            return true;
        }
        return false;

    }

    public static void addBrownies(int amount) {//add brownies to user's currency
        int current = userBrownies.getInteger("brownies");
        current += amount;
        userBrownies.clear();
        userBrownies.putInteger("brownies", current);
        userBrownies.flush();
        moneyLayout.setText(achievementFont, String.valueOf(userBrownies.getInteger("brownies")));
    }

    public static void completeAchievement(int mode, int index) {
        addBrownies(40);
        switch (mode) {
            case 1:
                classicProgress[index] = 1;
                achievementLayout.setText(achievementFont, classicAchievements[classicCurrent.getInteger("classicCurrent")]);
                writeCompletion(classicProgress, classicOverallProgress, "classicOverall", classicCompleted, "classicCompleted");
                if (classicCompleted.getInteger("classicCompleted") != 25) {
                    nextAchievement(classicProgress, classicSkipped, "classicSkipped", index, classicCurrent, "classicCurrent");
                    glyphLayout.setText(achievementFont, classicAchievements[classicCurrent.getInteger("classicCurrent")]);
                    classicCurrentProgress.clear();
                    classicCurrentProgress.putInteger("classicCurrentProgress", 0);
                    classicCurrentProgress.flush();
                    progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" +
                            (achievementActions.setRequirement(classicRequirements, classicCurrent.getInteger("classicCurrent"), classicCumulatives))));
                    if (classicTypes[classicCurrent.getInteger("classicCurrent")].equalsIgnoreCase("time")) {
                        achievementStartTime = System.currentTimeMillis();
                    }
                    type = classicTypes[classicCurrent.getInteger("classicCurrent")];
                    achievementIndex = classicCurrent.getInteger("classicCurrent");
                    achievementCumulatives = classicCumulatives;
                } else {
                    classicCurrentProgress.clear();
                    classicCurrentProgress.putInteger("classicCurrentProgress", 0);
                    classicCurrentProgress.flush();
                    classicCurrent.putInteger("classicCurrent", 25);
                    glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                    progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" + ("100")));
                    type = "finished";
                }
                percentageLayout.setText(percentageFont, (String.valueOf(((classicCompleted.getInteger("classicCompleted")) * 4))) + "%");
                break;
            case 2:
                mirrorProgress[index] = 1;
                if (mirrorCompleted.getInteger("mirrorCompleted") == 25) {
                    achievementLayout.setText(achievementFont, "Scored 100 points!");
                } else {
                    achievementLayout.setText(achievementFont, mirrorAchievements[mirrorCurrent.getInteger("mirrorCurrent")]);
                }
                if (mirrorCompleted.getInteger("mirrorCompleted") != 25) {
                    writeCompletion(mirrorProgress, mirrorOverallProgress, "mirrorOverall", mirrorCompleted, "mirrorCompleted");
                }
                if (mirrorCompleted.getInteger("mirrorCompleted") != 25) {
                    nextAchievement(mirrorProgress, mirrorSkipped, "mirrorSkipped", index, mirrorCurrent, "mirrorCurrent");
                    glyphLayout.setText(achievementFont, mirrorAchievements[mirrorCurrent.getInteger("mirrorCurrent")]);
                    mirrorCurrentProgress.clear();
                    mirrorCurrentProgress.putInteger("mirrorCurrentProgress", 0);
                    mirrorCurrentProgress.flush();
                    mirrorCurrentProgress.clear();
                    progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" +
                            (achievementActions.setRequirement(mirrorRequirements, mirrorCurrent.getInteger("mirrorCurrent"), mirrorCumulatives))));
                    if (mirrorTypes[mirrorCurrent.getInteger("mirrorCurrent")].equalsIgnoreCase("time")) {
                        achievementStartTime = System.currentTimeMillis();
                    }
                    type = mirrorTypes[mirrorCurrent.getInteger("mirrorCurrent")];
                    achievementIndex = mirrorCurrent.getInteger("mirrorCurrent");
                    achievementCumulatives = mirrorCumulatives;
                } else {
                    mirrorCurrentProgress.clear();
                    mirrorCurrentProgress.putInteger("mirrorCurrentProgress", 0);
                    mirrorCurrentProgress.flush();
                    mirrorCurrent.putInteger("mirrorCurrent", 25);
                    glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                    progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" + ("100")));
                    type = "finished";
                }
                percentageLayout.setText(percentageFont, (String.valueOf(((mirrorCompleted.getInteger("mirrorCompleted")) * 4))) + "%");
                break;
            case 3:
                blindProgress[index] = 1;
                if (blindCompleted.getInteger("blindCompleted") == 25) {
                    achievementLayout.setText(achievementFont, "Scored 100 points!");
                } else {
                    achievementLayout.setText(achievementFont, blindAchievements[blindCurrent.getInteger("blindCurrent")]);
                }
                if (blindCompleted.getInteger("blindCompleted") != 25) {
                    writeCompletion(blindProgress, blindOverallProgress, "blindOverall", blindCompleted, "blindCompleted");
                }
                if (blindCompleted.getInteger("blindCompleted") != 25) {
                    nextAchievement(blindProgress, blindSkipped, "blindSkipped", index, blindCurrent, "blindCurrent");
                    glyphLayout.setText(achievementFont, blindAchievements[blindCurrent.getInteger("blindCurrent")]);
                    blindCurrentProgress.clear();
                    blindCurrentProgress.putInteger("blindCurrentProgress", 0);
                    blindCurrentProgress.flush();
                    progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" +
                            (achievementActions.setRequirement(blindRequirements, blindCurrent.getInteger("blindCurrent"), blindCumulatives))));
                    if (blindTypes[blindCurrent.getInteger("blindCurrent")].equalsIgnoreCase("time")) {
                        achievementStartTime = System.currentTimeMillis();
                    }
                    type = blindTypes[blindCurrent.getInteger("blindCurrent")];
                    achievementIndex = blindCurrent.getInteger("blindCurrent");
                    achievementCumulatives = blindCumulatives;
                } else {
                    blindCurrentProgress.clear();
                    blindCurrentProgress.putInteger("blindCurrentProgress", 0);
                    blindCurrentProgress.flush();
                    blindCurrent.putInteger("blindCurrent", 25);
                    glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
                    progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" + ("100")));
                    type = "finished";
                }
                percentageLayout.setText(percentageFont, (String.valueOf(((blindCompleted.getInteger("blindCompleted")) * 4))) + "%");
                break;
            case 4:
                burstProgress[index] = 1;
                if (burstCompleted.getInteger("burstCompleted") == 25) {
                    achievementLayout.setText(achievementFont, "Scored 100 points!");
                } else {
                    achievementLayout.setText(achievementFont, burstAchievements[burstCurrent.getInteger("burstCurrent")]);
                }
                if (burstCompleted.getInteger("burstCompleted") != 25) {
                    writeCompletion(burstProgress, burstOverallProgress, "burstOverall", burstCompleted, "burstCompleted");
                }
                if (burstCompleted.getInteger("burstCompleted") != 25) {
                    nextAchievement(burstProgress, burstSkipped, "burstSkipped", index, burstCurrent, "burstCurrent");
                    glyphLayout.setText(achievementFont, burstAchievements[burstCurrent.getInteger("burstCurrent")]);
                    burstCurrentProgress.clear();
                    burstCurrentProgress.putInteger("burstCurrentProgress", 0);
                    burstCurrentProgress.flush();
                    progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" +
                            (achievementActions.setRequirement(burstRequirements, burstCurrent.getInteger("burstCurrent"), burstCumulatives))));
                    if (burstTypes[burstCurrent.getInteger("burstCurrent")].equalsIgnoreCase("time")) {
                        achievementStartTime = System.currentTimeMillis();
                    }
                    type = burstTypes[burstCurrent.getInteger("burstCurrent")];
                    achievementIndex = burstCurrent.getInteger("burstCurrent");
                    achievementCumulatives = burstCumulatives;
                } else {
                    burstCurrentProgress.clear();
                    burstCurrentProgress.putInteger("burstCurrentProgress", 0);
                    burstCurrentProgress.flush();
                    burstCurrent.putInteger("burstCurrent", 25);
                    glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies \n for every 100 points");
                    progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" + ("100")));
                    type = "finished";
                }
                percentageLayout.setText(percentageFont, (String.valueOf(((burstCompleted.getInteger("burstCompleted")) * 4))) + "%");
                break;
            case 5:
                doubleProgress[index] = 1;
                if (doubleCompleted.getInteger("doubleCompleted") == 25) {
                    achievementLayout.setText(achievementFont, "Scored 100 points!");
                } else {
                    achievementLayout.setText(achievementFont, doubleAchievements[doubleCurrent.getInteger("doubleCurrent")]);
                }
                if (doubleCompleted.getInteger("doubleCompleted") != 25) {
                    writeCompletion(doubleProgress, doubleOverallProgress, "doubleOverall", doubleCompleted, "doubleCompleted");
                }
                if (doubleCompleted.getInteger("doubleCompleted") != 25) {
                    nextAchievement(doubleProgress, doubleSkipped, "doubleSkipped", index, doubleCurrent, "doubleCurrent");
                    glyphLayout.setText(achievementFont, doubleAchievements[doubleCurrent.getInteger("doubleCurrent")]);
                    doubleCurrentProgress.clear();
                    doubleCurrentProgress.putInteger("doubleCurrentProgress", 0);
                    doubleCurrentProgress.flush();
                    progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" +
                            (achievementActions.setRequirement(doubleRequirements, doubleCurrent.getInteger("doubleCurrent"), doubleCumulatives))));
                    if (doubleTypes[doubleCurrent.getInteger("doubleCurrent")].equalsIgnoreCase("time")) {
                        achievementStartTime = System.currentTimeMillis();
                    }
                    type = doubleTypes[doubleCurrent.getInteger("doubleCurrent")];
                    achievementIndex = doubleCurrent.getInteger("doubleCurrent");
                    achievementCumulatives = doubleCumulatives;
                } else {
                    doubleCurrentProgress.clear();
                    doubleCurrentProgress.putInteger("doubleCurrentProgress", 0);
                    doubleCurrentProgress.flush();
                    doubleCurrent.putInteger("doubleCurrent", 25);
                    glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies \n for every 100 points");
                    progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" + ("100")));
                    type = "finished";
                }
                percentageLayout.setText(percentageFont, (String.valueOf(((doubleCompleted.getInteger("doubleCompleted")) * 4))) + "%");
                break;
            case 7:
                extremeFlipProgress[index] = 1;
                writeCompletion(extremeFlipProgress, extremeFlipOverallProgress, "extremeFlipOverall", extremeFlipCompleted, "extremeFlipCompleted");
                if (classicCompleted.getInteger("classicCompleted") != 25) {
                    nextAchievement(classicProgress, classicSkipped, "classicSkipped", index, classicCurrent, "classicCurrent");
                }
                break;
        }
        showBanner = true;
        bannerDropTime = System.currentTimeMillis();
    }

    public static void completeFinished(int mode, int adder) {
        int current;
        switch (mode) {
            case 1:
                current = classicCurrentProgress.getInteger("classicCurrentProgress");
                classicCurrentProgress.clear();
                classicCurrentProgress.putInteger("classicCurrentProgress", (adder + current) - 100);
                classicCurrentProgress.flush();
                progressLayout.setText(progressFont, String.valueOf((classicCurrentProgress.getInteger("classicCurrentProgress")) + "/" + ("100")));
                break;
            case 2:
                current = mirrorCurrentProgress.getInteger("mirrorCurrentProgress");
                mirrorCurrentProgress.clear();
                mirrorCurrentProgress.putInteger("mirrorCurrentProgress", (adder + current) - 100);
                mirrorCurrentProgress.flush();
                progressLayout.setText(progressFont, String.valueOf((mirrorCurrentProgress.getInteger("mirrorCurrentProgress")) + "/" + ("100")));
                break;
            case 3:
                current = blindCurrentProgress.getInteger("blindCurrentProgress");
                blindCurrentProgress.clear();
                blindCurrentProgress.putInteger("blindCurrentProgress", (adder + current) - 100);
                blindCurrentProgress.flush();
                progressLayout.setText(progressFont, String.valueOf((blindCurrentProgress.getInteger("blindCurrentProgress")) + "/" + ("100")));
                break;
            case 4:
                current = burstCurrentProgress.getInteger("burstCurrentProgress");
                burstCurrentProgress.clear();
                burstCurrentProgress.putInteger("burstCurrentProgress", (adder + current) - 100);
                burstCurrentProgress.flush();
                progressLayout.setText(progressFont, String.valueOf((burstCurrentProgress.getInteger("burstCurrentProgress")) + "/" + ("100")));
                break;
            case 5:
                current = doubleCurrentProgress.getInteger("doubleCurrentProgress");
                doubleCurrentProgress.clear();
                doubleCurrentProgress.putInteger("doubleCurrentProgress", (adder + current) - 100);
                doubleCurrentProgress.flush();
                progressLayout.setText(progressFont, String.valueOf((doubleCurrentProgress.getInteger("doubleCurrentProgress")) + "/" + ("100")));
                break;
        }
        finishedScore = 0;
        glyphLayout.setText(achievementFont, "\nAchievements Complete! \n Collect Brownies for \n every 100 points");
        addBrownies(20);
        achievementLayout.setText(achievementFont, "Scored 100 points!");
        showBanner = true;
        bannerDropTime = System.currentTimeMillis();
    }

    public static void writeCompletion(int[] arr, Preferences progress, String id, Preferences completed, String id2) {
        progress.clear();
        String s = "";
        for (int i = 0; i < 25; i++) {
            s += arr[i];
        }
        progress.putString(id, s);
        progress.flush();
        //System.out.println(progress.getString(id));
        int c = completed.getInteger(id2);
        completed.clear();
        c++;
        completed.putInteger(id2, c);
        completed.flush();

    }

    public static void nextAchievement(int[] arr, Preferences skipped, String id, int justCompleted, Preferences current, String id2) {
        int nextPossible = -1;
        for (int i = 0; i < justCompleted; i++) {//loops up to the completed achievement for any uncompleted achivements (0s)
            if (arr[i] == 0 && skipped.getInteger(id) != i) {//there is an uncompleted achievement before
                nextPossible = i;
                break;
            } else {//keep looping

            }
        }
        if (nextPossible == -1) {//if there was no uncompleted achivements before the completed
            for (int i = justCompleted + 1; i < 25; i++) {//loop from completed until end for any uncompleted ahcievements
                if (arr[i] == 0 && skipped.getInteger(id) != i) {
                    nextPossible = i;
                    break;
                } else {//keep looping

                }
            }
        }
        if (nextPossible == -1) {
            nextPossible = skipped.getInteger(id);//only skipped achievement left to complete
        }
        current.clear();
        current.putInteger(id2, nextPossible);
        current.flush();


    }

    public static void displayAchievement(int mode) {//display acheivement on mode screen
        switch (mode) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 7:
                break;
        }
    }

    public static int setRequirement(int[] requirements, int current, int[] cumulative) {
        int requirement = 0;
        if (cumulative[current] == 0 || cumulative[current] == -1 || cumulative[current] == 1) {
            requirement = requirements[current];
        } else {
            requirement = Math.abs(cumulative[current]);
        }
        return requirement;
    }

    public static int getRequirements() {
        int requirement = 0;
        switch (mode) {
            case 1:
                requirement = classicRequirements[achievementIndex];
                break;
            case 2:
                requirement = mirrorRequirements[achievementIndex];
                break;
            case 3:
                requirement = blindRequirements[achievementIndex];
                break;
            case 4:
                requirement = burstRequirements[achievementIndex];
                break;
            case 5:
                requirement = doubleRequirements[achievementIndex];
                break;
        }
        return requirement;
    }

    public static void setProgress(long value) {
        switch (mode) {
            case 1:
                classicCurrentProgress.clear();
                classicCurrentProgress.putInteger("classicCurrentProgress", Integer.parseInt(Long.toString(value)));
                classicCurrentProgress.flush();
                break;
            case 2:
                mirrorCurrentProgress.clear();
                mirrorCurrentProgress.putInteger("mirrorCurrentProgress", Integer.parseInt(Long.toString(value)));
                mirrorCurrentProgress.flush();
                break;
            case 3:
                blindCurrentProgress.clear();
                blindCurrentProgress.putInteger("blindCurrentProgress", Integer.parseInt(Long.toString(value)));
                blindCurrentProgress.flush();
                break;
            case 4:
                burstCurrentProgress.clear();
                burstCurrentProgress.putInteger("burstCurrentProgress", Integer.parseInt(Long.toString(value)));
                burstCurrentProgress.flush();
                break;
            case 5:
                doubleCurrentProgress.clear();
                doubleCurrentProgress.putInteger("doubleCurrentProgress", Integer.parseInt(Long.toString(value)));
                doubleCurrentProgress.flush();
                break;
        }
    }


    public static void deathProgress() {
        long adder = 0;
        long current;
        //System.out.println(type + " " + achievementIndex);
        if (type.equalsIgnoreCase("games")) {
            adder = 1;
        } else if (type.equalsIgnoreCase("score")) {// 48 - reach a certain score
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = finishedScore;
            } else if (achievementCumulatives[achievementIndex] < -1) {//straight games
                if (finishedScore >= getRequirements()) {
                    adder = 1;
                } else {
                    setProgress(0);
                }
            } else if (achievementCumulatives[achievementIndex] > 1) {//separate games
                if (finishedScore >= getRequirements()) {
                    adder = 1;
                }
            } else if (achievementCumulatives[achievementIndex] == -1) {//exact score
                if (finishedScore == getRequirements()) {
                    adder = finishedScore;
                }
            }
        } else if (type.equalsIgnoreCase("time")) {// 13 - play a certain amount of time
            if (achievementCumulatives[achievementIndex] == 1) {//cumulative
                //System.out.println(classicCurrentProgress.getInteger("classicCurrentProgress"));
                adder = (achievementTime / 1000);
                //System.out.println("adder" + adder);
            } else if (achievementCumulatives[achievementIndex] < -1) {//straight games
                if ((achievementTime / 1000) >= getRequirements()) {
                    adder = 1;
                } else {
                    setProgress(0);
                }
            }
        } else if (type.equalsIgnoreCase("flip")) {// 12 - flip the ball a certain amount of times
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = flipCount;
            }
        } else if (type.equalsIgnoreCase("through")) {// 4 - pass through the mirror a certain amount of time ** Mirror mode only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = throughCount;
            } else if (achievementCumulatives[achievementIndex] == 0) {//one game at least
                if (throughCount >= getRequirements()) {
                    adder = throughCount;
                } else {
                    setProgress(0);
                    adder = 0;
                }

            } else if (achievementCumulatives[achievementIndex] == -1) {//exactly
                if (throughCount == getRequirements()) {
                    adder = throughCount;
                } else {
                    setProgress(0);
                    adder = 0;
                }
            }
        } else if (type.equalsIgnoreCase("bounce")) {// 4 - reflect off the mirror a certain amount of time ** Mirror mode only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = bounceCount;
            }
        } else if (type.equalsIgnoreCase("match")) {// 1 - correctly match a reflected ball ** Mirror mode only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = matchCount;
            }
        } else if (type.equalsIgnoreCase("yellow")) {// 1 - Correctly match the yellow colour ** Blind Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = blindColourCount;
            }
        } else if (type.equalsIgnoreCase("pink")) {// 1 - Correctly match the purple colour ** Blind Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = blindColourCount;
            }
        } else if (type.equalsIgnoreCase("burstscore")) {// 3 - score a certain amount of points with burst speed ** Burst Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = burstScoreCount;
            }
        } else if (type.equalsIgnoreCase("burst")) {// 1 - get burst speed a certain amount of times ** Burst Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = burstOccurCount;
            }
        } else if (type.equalsIgnoreCase("burstdie")) {// 2 - die with speed burst
            if (widthspeed == 2 * full_way) {
                adder = 1;
            }
        } else if (type.equalsIgnoreCase("blue")) {// 1 - Correctly match the blue colour ** Burst Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = burstColourCount;
            }
        } else if (type.equalsIgnoreCase("lightgreen")) {// 1 - Correctly match the red colour ** Burst Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = burstColourCount;
            }
        } else if (type.equalsIgnoreCase("burstflip")) {// 1 - flip the ball a certain amount of times with burst speed ** Burst Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = flipCount;
            }
        } else if (type.equalsIgnoreCase("topflip")) {// 1 - Flip the top ball a certain amount of times ** Double Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = flipCount;
            }
        } else if (type.equalsIgnoreCase("righttap")) {// 1 - Reach a certain score only tapping the right side ** Double Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                if (sideTap) {
                    adder = sideTapScore;
                }
            }
        } else if (type.equalsIgnoreCase("lefttap")) {// 1 - Reach a certain score only tapping the left side ** Double Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                if (sideTap) {
                    adder = sideTapScore;
                }
            }
        } else if (type.equalsIgnoreCase("bottomflip")) {// 2 - Flip the bottom ball a certain amount of times ** Double Mode Only **
            if (achievementCumulatives[achievementIndex] == 1) {
                adder = flipCount;
            }
        } else if (type.equalsIgnoreCase("bottomdie")) {// 1 - Die with the bottom ball ** Double Mode Only **
            adder = doubleDie;
        } else if (type.equalsIgnoreCase("topdie")) {// 1 - Die with the top ball ** Double Mode Only **
            adder = doubleDie;
        } else if (type.equalsIgnoreCase("finished")) {
            adder = finishedScore;
            //System.out.println("adder" + adder);
        }
        switch (mode) {
            case 1:
                current = classicCurrentProgress.getInteger("classicCurrentProgress");
                //System.out.println(current + "current");
                current += adder;
                //System.out.println("current" + current);
                classicCurrentProgress.clear();
                classicCurrentProgress.putInteger("classicCurrentProgress", Integer.parseInt(String.valueOf(current)));
                classicCurrentProgress.flush();
                if (classicCompleted.getInteger("classicCompleted") != 25) {
                    achievementActions.checkProgress(current);
                } else {
                    if (current >= 100) {
                        completeFinished(1, 0);
                    }
                }
                //System.out.println(classicCurrentProgress.getInteger("classicCurrentProgress"));
                break;
            case 2:
                current = mirrorCurrentProgress.getInteger("mirrorCurrentProgress");
                current += adder;
                mirrorCurrentProgress.clear();
                mirrorCurrentProgress.putInteger("mirrorCurrentProgress", Integer.parseInt(String.valueOf(current)));
                mirrorCurrentProgress.flush();
                if (mirrorCompleted.getInteger("mirrorCompleted") != 25) {
                    achievementActions.checkProgress(current);
                } else {
                    if (current >= 100) {
                        completeFinished(2, 0);
                    }
                }
                break;
            case 3:
                current = blindCurrentProgress.getInteger("blindCurrentProgress");
                current += adder;
                blindCurrentProgress.clear();
                blindCurrentProgress.putInteger("blindCurrentProgress", Integer.parseInt(String.valueOf(current)));
                blindCurrentProgress.flush();
                if (blindCompleted.getInteger("blindCompleted") != 25) {
                    achievementActions.checkProgress(current);
                } else {
                    if (current >= 100) {
                        completeFinished(3, 0);
                    }
                }
                break;
            case 4:
                current = burstCurrentProgress.getInteger("burstCurrentProgress");
                current += adder;
                burstCurrentProgress.clear();
                burstCurrentProgress.putInteger("burstCurrentProgress", Integer.parseInt(String.valueOf(current)));
                burstCurrentProgress.flush();
                if (burstCompleted.getInteger("burstCompleted") != 25) {
                    achievementActions.checkProgress(current);
                } else {
                    if (current >= 100) {
                        completeFinished(4, 0);
                    }
                }
                break;
            case 5:
                current = doubleCurrentProgress.getInteger("doubleCurrentProgress");
                current += adder;
                doubleCurrentProgress.clear();
                doubleCurrentProgress.putInteger("doubleCurrentProgress", Integer.parseInt(String.valueOf(current)));
                doubleCurrentProgress.flush();
                if (doubleCompleted.getInteger("doubleCompleted") != 25) {
                    achievementActions.checkProgress(current);
                } else {
                    if (current >= 100) {
                        completeFinished(5, 0);
                    }
                }
                break;
        }

    }

    public static void achievementProgress() {
        long adder = 0;
        int current = 0;
        if (type.equalsIgnoreCase("score")) {// 48 - reach a certain score
            if (achievementCumulatives[achievementIndex] == 1 || achievementCumulatives[achievementIndex] == 0) {
                adder = finishedScore;
            } else if (achievementCumulatives[achievementIndex] < -1) {//straight games
                if (finishedScore >= getRequirements()) {
                    adder = 1;
                }
            } else if (achievementCumulatives[achievementIndex] > 1) {//separate games
                if (finishedScore > getRequirements()) {
                    adder = 1;
                }
            }

        } else if (type.equalsIgnoreCase("time")) {// 13 - play a certain amount of time
            if (achievementCumulatives[achievementIndex] == 1 || achievementCumulatives[achievementIndex] == 0) {//cumulative
                adder = Integer.parseInt(String.valueOf((((System.currentTimeMillis() - achievementStartTime)) + achievementTime) / 1000));
            } else if (achievementCumulatives[achievementIndex] < -1) {//straight games
                if ((((System.currentTimeMillis() - achievementStartTime) + achievementTime) / 1000) >= getRequirements()) {
                    adder = 1;
                }
            }
        } else if (type.equalsIgnoreCase("flip")) {// 12 - flip the ball a certain amount of times
            adder = flipCount;
        } else if (type.equalsIgnoreCase("through")) {// 4 - pass through the mirror a certain amount of time ** Mirror mode only **
            if (achievementCumulatives[achievementIndex] == 1 || achievementCumulatives[achievementIndex] == 0) {
                adder = throughCount;
            } else if (achievementCumulatives[achievementIndex] == -1) {
                adder = 0;
            }
        } else if (type.equalsIgnoreCase("bounce")) {// 4 - reflect off the mirror a certain amount of time ** Mirror mode only **
            adder = bounceCount;
        } else if (type.equalsIgnoreCase("match")) {// 1 - correctly match a reflected ball ** Mirror mode only **
            adder = matchCount;
        } else if (type.equalsIgnoreCase("yellow")) {// 1 - Correctly match the yellow colour ** Blind Mode Only **
            adder = blindColourCount;
        } else if (type.equalsIgnoreCase("pink")) {// 1 - Correctly match the purple colour ** Blind Mode Only **
            adder = blindColourCount;
        } else if (type.equalsIgnoreCase("burstscore")) {// 3 - score a certain amount of points with burst speed ** Burst Mode Only **
            adder = burstScoreCount;
        } else if (type.equalsIgnoreCase("burst")) {// 1 - get burst speed a certain amount of times ** Burst Mode Only **
            adder = burstOccurCount;
        } else if (type.equalsIgnoreCase("blue")) {// 1 - Correctly match the blue colour ** Burst Mode Only **
            adder = burstColourCount;
        } else if (type.equalsIgnoreCase("lightgreen")) {// 1 - Correctly match the light green colour ** Burst Mode Only **
            adder = burstColourCount;
        } else if (type.equalsIgnoreCase("burstflip")) {// 1 - flip the ball a certain amount of times with burst speed ** Burst Mode Only **
            adder = flipCount;
        } else if (type.equalsIgnoreCase("topflip")) {// 1 - Flip the top ball a certain amount of times ** Double Mode Only **
            adder = flipCount;
        } else if (type.equalsIgnoreCase("righttap")) {// 1 - Reach a certain score only tapping the right side ** Double Mode Only **
            if (sideTap) {
                adder = sideTapScore;
            } else {
                adder = 0;
            }
        } else if (type.equalsIgnoreCase("lefttap")) {// 1 - Reach a certain score only tapping the left side ** Double Mode Only **
            if (sideTap) {
                adder = sideTapScore;
            } else {
                adder = 0;
            }
        } else if (type.equalsIgnoreCase("bottomflip")) {// 2 - Flip the bottom ball a certain amount of times ** Double Mode Only **
            adder = flipCount;
        } else if (type.equalsIgnoreCase("finished")) {
            adder = finishedScore;
            //System.out.println("playadder" + adder);
        } else if (type.equalsIgnoreCase("flipwall")) {
            adder = flipCount;
        }

        switch (mode) {
            case 1:
                if (!type.equalsIgnoreCase("finished")) {
                    checkProgress(adder + classicCurrentProgress.getInteger("classicCurrentProgress"));
                } else {
                    if (adder + classicCurrentProgress.getInteger("classicCurrentProgress") >= 100) {
                        completeFinished(1, Integer.parseInt(String.valueOf(adder)));
                    }
                }

                break;
            case 2:
                if (!type.equalsIgnoreCase("finished")) {
                    checkProgress(adder + mirrorCurrentProgress.getInteger("mirrorCurrentProgress"));
                } else {
                    if (adder + mirrorCurrentProgress.getInteger("mirrorCurrentProgress") >= 100) {
                        completeFinished(2, Integer.parseInt(String.valueOf(adder)));
                    }
                }
                break;
            case 3:
                if (!type.equalsIgnoreCase("finished")) {
                    checkProgress(adder + blindCurrentProgress.getInteger("blindCurrentProgress"));
                } else {
                    if (adder + blindCurrentProgress.getInteger("blindCurrentProgress") >= 100) {
                        completeFinished(3, Integer.parseInt(String.valueOf(adder)));
                    }
                }
                break;
            case 4:
                if (!type.equalsIgnoreCase("finished")) {
                    checkProgress(adder + burstCurrentProgress.getInteger("burstCurrentProgress"));
                } else {
                    if (adder + burstCurrentProgress.getInteger("burstCurrentProgress") >= 100) {
                        completeFinished(4, Integer.parseInt(String.valueOf(adder)));
                    }
                }
                break;
            case 5:
                if (!type.equalsIgnoreCase("finished")) {
                    checkProgress(adder + doubleCurrentProgress.getInteger("doubleCurrentProgress"));
                } else {
                    if (adder + doubleCurrentProgress.getInteger("doubleCurrentProgress") >= 100) {
                        completeFinished(5, Integer.parseInt(String.valueOf(adder)));
                    }
                }
                break;
        }

    }


    public static boolean checkProgress(long value) {//check if achievement is completed
        boolean completed = false;
        switch (mode) {
            case 1:
                if (value >= (setRequirement(classicRequirements,
                        classicCurrent.getInteger("classicCurrent"), classicCumulatives))) {
                    achievementActions.resetVariables();
                    completed = true;
                }
                break;
            case 2:
                if (value >= (setRequirement(mirrorRequirements,
                        mirrorCurrent.getInteger("mirrorCurrent"), mirrorCumulatives))) {
                    achievementActions.resetVariables();
                    completed = true;
                }
                break;
            case 3:
                if (value >= (setRequirement(blindRequirements,
                        blindCurrent.getInteger("blindCurrent"), blindCumulatives))) {
                    achievementActions.resetVariables();
                    completed = true;
                }
                break;
            case 4:
                if (value >= (setRequirement(burstRequirements,
                        burstCurrent.getInteger("burstCurrent"), burstCumulatives))) {
                    achievementActions.resetVariables();
                    completed = true;
                }
                break;
            case 5:
                if (value >= (setRequirement(doubleRequirements,
                        doubleCurrent.getInteger("doubleCurrent"), doubleCumulatives))) {
                    achievementActions.resetVariables();
                    completed = true;
                }
                break;
        }
        if (completed) {
            completeAchievement(mode, achievementIndex);
            //display popdown banner
        }
        return completed;
    }

    public static void resetVariables() {
        achievementTime = 0;
        bounceCount = 0;
        throughCount = 0;
        burstScoreCount = 0;
        burstOccurCount = 0;
        flipCount = 0;
        blindColourCount = 0;
        burstColourCount = 0;
        sideTap = true;
        doubleDie = 0;
        matchCount = 0;
        //score = 0;
        finishedScore = 0;
        wasReflected = false;
        doubleColour2 = 0;
        doubleColour = 0;
        sideTapScore = 0;
    }

    public static void bannerDown() {
        if (bannerY < achievementBanner.getBoundingRectangle().getHeight()) {
            for (int i = 0; i < 10; i++) {
                if (bannerY < achievementBanner.getBoundingRectangle().getHeight()) {
                    bannerY += 1;
                } else {
                    bannerY = achievementBanner.getBoundingRectangle().getHeight();
                    break;
                }
            }
        }

    }

    public static void bannerDisplay() {
        //System.out.println((System.currentTimeMillis() - bannerDropTime)/1000);
        if (((System.currentTimeMillis() - bannerDropTime) / 1000) < 5) {
            bannerDown();
        } else {
            bannerUp();
        }
        batch.begin();
        achievementBanner.setCenter(w / 2, h + (achievementBanner.getBoundingRectangle().getHeight() / 2) - bannerY);
        achievementBanner.draw(batch);
        achievementUnlocked.setCenter(w / 2, h + ((3 * (achievementBanner.getBoundingRectangle().getHeight())) / 4) - bannerY);
        achievementUnlocked.draw(batch);
        achievementStars.setCenter(w / 2, h - bannerY);
        achievementStars.draw(batch);
        achievementFont.draw(batch, achievementLayout, (w - achievementLayout.width) / 2, h + (achievementBanner.getBoundingRectangle().getHeight() / 2) + (achievementLayout.height / 2) - bannerY);
        batch.end();
    }

    public static void bannerUp() {
        if (bannerY > 0) {
            for (int i = 0; i < 10; i++) {
                if (bannerY > 0) {
                    bannerY -= 1;
                } else {
                    bannerY = 0;
                    break;
                }
            }
        } else {
            showBanner = false;
        }
    }

    public static void finishedAchievements() {

    }

}
