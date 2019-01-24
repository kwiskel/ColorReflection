package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import java.io.IOException;
import java.util.ArrayList;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.achievementBoard;
import static com.flyingbrowniegames.ballgame.Variables.achievementFont;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.blindCompleted;
import static com.flyingbrowniegames.ballgame.Variables.blindOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.blindnamme;
import static com.flyingbrowniegames.ballgame.Variables.burstCompleted;
import static com.flyingbrowniegames.ballgame.Variables.burstOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.burstnamme;
import static com.flyingbrowniegames.ballgame.Variables.classicAchievements;
import static com.flyingbrowniegames.ballgame.Variables.classicCompleted;
import static com.flyingbrowniegames.ballgame.Variables.classicCurrent;
import static com.flyingbrowniegames.ballgame.Variables.classicOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.classicnamme;
import static com.flyingbrowniegames.ballgame.Variables.doubleCompleted;
import static com.flyingbrowniegames.ballgame.Variables.doubleOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.doublenamme;
import static com.flyingbrowniegames.ballgame.Variables.exitButton;
import static com.flyingbrowniegames.ballgame.Variables.extremeFlipCompleted;
import static com.flyingbrowniegames.ballgame.Variables.extremeflipname;
import static com.flyingbrowniegames.ballgame.Variables.fastforwardButton;
import static com.flyingbrowniegames.ballgame.Variables.glyphLayout;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.mirrorAchievements;
import static com.flyingbrowniegames.ballgame.Variables.mirrorCompleted;
import static com.flyingbrowniegames.ballgame.Variables.mirrorCurrent;
import static com.flyingbrowniegames.ballgame.Variables.mirrorOverallProgress;
import static com.flyingbrowniegames.ballgame.Variables.mirrornamme;
import static com.flyingbrowniegames.ballgame.Variables.modeClicked;
import static com.flyingbrowniegames.ballgame.Variables.namesprite;
import static com.flyingbrowniegames.ballgame.Variables.percentageFont;
import static com.flyingbrowniegames.ballgame.Variables.percentageLayout;
import static com.flyingbrowniegames.ballgame.Variables.popupScreen;
import static com.flyingbrowniegames.ballgame.Variables.progressBox;
import static com.flyingbrowniegames.ballgame.Variables.progressCircle;
import static com.flyingbrowniegames.ballgame.Variables.progressFont;
import static com.flyingbrowniegames.ballgame.Variables.progressLayout;
import static com.flyingbrowniegames.ballgame.Variables.progressText;
import static com.flyingbrowniegames.ballgame.Variables.randomizeButton;
import static com.flyingbrowniegames.ballgame.Variables.reflection;
import static com.flyingbrowniegames.ballgame.Variables.screenOverlay;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kyle on 2017-07-05.
 */

public class achievementScreen {

    public static void displayScreen() {
        batch.begin();
        screenOverlay.setCenter(w / 2, h / 2);
        screenOverlay.draw(batch);
        popupScreen.setCenter(w / 2, h / 2);
        popupScreen.draw(batch);
        modeDisplay();
        // mirrornamme.setCenter(w / 2, (h * 6) / 8);
        // mirrornamme.draw(batch);
        batch.end();

    }

    public static void modeDisplay() {
        switch (modeClicked) {
            case 1: //Classic
                achievementBoard.setCenter(w / 2, ((h * 13) / 48));
                achievementBoard.draw(batch);
                progressBox.setCenter(w / 2, ((h * 13) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) + (progressBox.getBoundingRectangle().getHeight() / 2));
                progressBox.draw(batch);
                progressFont.draw(batch, progressLayout, (w / 2) - (progressLayout.width / 2),
                        (((h * 13) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) +
                                (progressBox.getBoundingRectangle().getHeight() / 2)) + (progressLayout.height / 2));
                if (classicCompleted.getInteger("classicCompleted") != 25) {
                    if (classicCompleted.getInteger("classicCompleted") == 24) {
                        fastforwardButton.setCenter(w / 2, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        fastforwardButton.draw(batch);
                    } else {
                        randomizeButton.setCenter(w / 3, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        randomizeButton.draw(batch);
                        fastforwardButton.setCenter((w * 2) / 3, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        fastforwardButton.draw(batch);
                    }

                }
                achievementFont.draw(batch, glyphLayout, (w - glyphLayout.width) / 2, (((h * 14) / 48)) + (glyphLayout.height / 2));
                exitButton.setCenter(w / 8, (h * 27) / 32);
                exitButton.draw(batch);
                classicnamme.setCenter(w / 2, (h * 6) / 8);
                classicnamme.draw(batch);
                displayPercentage((classicCompleted.getInteger("classicCompleted") * 4));
                break;
            case 2: //Mirror
                achievementBoard.setCenter(w / 2, ((h * 13) / 48));
                achievementBoard.draw(batch);
                progressBox.setCenter(w / 2, ((h * 13) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) + (progressBox.getBoundingRectangle().getHeight() / 2));
                progressBox.draw(batch);
                progressFont.draw(batch, progressLayout, (w / 2) - (progressLayout.width / 2),
                        (((h * 13) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) +
                                (progressBox.getBoundingRectangle().getHeight() / 2)) + (progressLayout.height / 2));
                if (mirrorCompleted.getInteger("mirrorCompleted") != 25) {
                    if (mirrorCompleted.getInteger("mirrorCompleted") == 24) {
                        fastforwardButton.setCenter(w / 2, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        fastforwardButton.draw(batch);
                    } else {
                        randomizeButton.setCenter(w / 3, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        randomizeButton.draw(batch);
                        fastforwardButton.setCenter((w * 2) / 3, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        fastforwardButton.draw(batch);
                    }
                }
                achievementFont.draw(batch, glyphLayout, (w - glyphLayout.width) / 2, (((h * 14) / 48)) + (glyphLayout.height / 2));
                exitButton.setCenter(w / 8, (h * 27) / 32);
                exitButton.draw(batch);
                mirrornamme.setCenter(w / 2, (h * 6) / 8);
                mirrornamme.draw(batch);
                displayPercentage(mirrorCompleted.getInteger("mirrorCompleted") * 4);
                break;
            case 3: //Blind
                achievementBoard.setCenter(w / 2, ((h * 13) / 48));
                achievementBoard.draw(batch);
                progressBox.setCenter(w / 2, ((h * 13) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) + (progressBox.getBoundingRectangle().getHeight() / 2));
                progressBox.draw(batch);
                progressFont.draw(batch, progressLayout, (w / 2) - (progressLayout.width / 2),
                        (((h * 13) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) +
                                (progressBox.getBoundingRectangle().getHeight() / 2)) + (progressLayout.height / 2));
                if (blindCompleted.getInteger("blindCompleted") != 25) {
                    if (blindCompleted.getInteger("blindCompleted") == 24) {
                        fastforwardButton.setCenter(w / 2, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        fastforwardButton.draw(batch);
                    } else {
                        randomizeButton.setCenter(w / 3, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        randomizeButton.draw(batch);
                        fastforwardButton.setCenter((w * 2) / 3, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        fastforwardButton.draw(batch);
                    }
                }
                achievementFont.draw(batch, glyphLayout, (w - glyphLayout.width) / 2, (((h * 14) / 48)) + (glyphLayout.height / 2));
                exitButton.setCenter(w / 8, (h * 27) / 32);
                exitButton.draw(batch);
                blindnamme.setCenter(w / 2, (h * 6) / 8);
                blindnamme.draw(batch);
                displayPercentage(blindCompleted.getInteger("blindCompleted") * 4);
                break;
            case 4://Burst
                achievementBoard.setCenter(w / 2, ((h * 13) / 48));
                achievementBoard.draw(batch);
                progressBox.setCenter(w / 2, ((h * 13) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) + (progressBox.getBoundingRectangle().getHeight() / 2));
                progressBox.draw(batch);
                progressFont.draw(batch, progressLayout, (w / 2) - (progressLayout.width / 2),
                        (((h * 13) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) +
                                (progressBox.getBoundingRectangle().getHeight() / 2)) + (progressLayout.height / 2));
                if (burstCompleted.getInteger("burstCompleted") != 25) {
                    if (burstCompleted.getInteger("burstCompleted") == 24) {
                        fastforwardButton.setCenter(w / 2, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        fastforwardButton.draw(batch);
                    } else {
                        randomizeButton.setCenter(w / 3, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        randomizeButton.draw(batch);
                        fastforwardButton.setCenter((w * 2) / 3, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        fastforwardButton.draw(batch);
                    }
                }
                achievementFont.draw(batch, glyphLayout, (w - glyphLayout.width) / 2, (((h * 14) / 48)) + (glyphLayout.height / 2));
                exitButton.setCenter(w / 8, (h * 27) / 32);
                exitButton.draw(batch);
                burstnamme.setCenter(w / 2, (h * 6) / 8);
                burstnamme.draw(batch);
                displayPercentage(burstCompleted.getInteger("burstCompleted") * 4);
                break;
            case 5://Double
                achievementBoard.setCenter(w / 2, ((h * 13) / 48));
                achievementBoard.draw(batch);
                progressBox.setCenter(w / 2, ((h * 13) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) + (progressBox.getBoundingRectangle().getHeight() / 2));
                progressBox.draw(batch);
                progressFont.draw(batch, progressLayout, (w / 2) - (progressLayout.width / 2),
                        (((h * 13) / 48) + (achievementBoard.getBoundingRectangle().getHeight() / 2) +
                                (progressBox.getBoundingRectangle().getHeight() / 2)) + (progressLayout.height / 2));
                if (doubleCompleted.getInteger("doubleCompleted") != 25) {
                    if (doubleCompleted.getInteger("doubleCompleted") == 24) {
                        fastforwardButton.setCenter(w / 2, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        fastforwardButton.draw(batch);
                    } else {
                        randomizeButton.setCenter(w / 3, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        randomizeButton.draw(batch);
                        fastforwardButton.setCenter((w * 2) / 3, ((h * 13) / 48) - (achievementBoard.getBoundingRectangle().getHeight()) / 2);
                        fastforwardButton.draw(batch);
                    }
                }
                achievementFont.draw(batch, glyphLayout, (w - glyphLayout.width) / 2, (((h * 14) / 48)) + (glyphLayout.height / 2));
                exitButton.setCenter(w / 8, (h * 27) / 32);
                exitButton.draw(batch);
                doublenamme.setCenter(w / 2, (h * 6) / 8);
                doublenamme.draw(batch);
                displayPercentage(doubleCompleted.getInteger("doubleCompleted") * 4);
            /*case 7://Extreme Flip
                extremeflipname.setCenter(w / 2, (h * 6) / 8);
                extremeflipname.draw(batch);
                displayPercentage(extremeFlipCompleted.getInteger("extremeFlipCompleted"));
                achievementFont.draw(batch, glyphLayout, (w - glyphLayout.width) / 2, (((h * 14) / 48)) + (glyphLayout.height / 2));
                break;*/
        }
    }

    public static void displayPercentage(int percent) {
        //System.out.println(percent);
        //System.out.println("percent" + percent);
//        if ((percent / 4) == 25) {
//            sprites.get("circularProgress" + String.valueOf(percent)).setCenter(w / 2, h / 2);
//            sprites.get("circularProgress" + String.valueOf(percent)).draw(batch);
//            percentageFont.draw(batch, percentageLayout, (w / 2) - (percentageLayout.width / 2), (h / 2) + (percentageLayout.height / 2));
//        }

        sprites.get("circularProgress" + String.valueOf(percent)).setCenter(w / 2, (h * 13 / 24));
        sprites.get("circularProgress" + String.valueOf(percent)).draw(batch);
        percentageFont.draw(batch, percentageLayout, (w / 2) - (percentageLayout.width / 2), (h * 13 / 24) + (percentageLayout.height / 2));

    }

}
