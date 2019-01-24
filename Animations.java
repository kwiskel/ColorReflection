package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.BallGame.startTime;
import static com.flyingbrowniegames.ballgame.Variables.Clasiclogo;
import static com.flyingbrowniegames.ballgame.Variables.animationMirror;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.blackBoard;
import static com.flyingbrowniegames.ballgame.Variables.blindBall;
import static com.flyingbrowniegames.ballgame.Variables.blindCane;
import static com.flyingbrowniegames.ballgame.Variables.blindMan;
import static com.flyingbrowniegames.ballgame.Variables.blueArrow;
import static com.flyingbrowniegames.ballgame.Variables.blueWall;
import static com.flyingbrowniegames.ballgame.Variables.boxHeight;
import static com.flyingbrowniegames.ballgame.Variables.boxWidth;
import static com.flyingbrowniegames.ballgame.Variables.burstBall;
import static com.flyingbrowniegames.ballgame.Variables.burstCloud1;
import static com.flyingbrowniegames.ballgame.Variables.burstCloud2;
import static com.flyingbrowniegames.ballgame.Variables.burstLines;
import static com.flyingbrowniegames.ballgame.Variables.direction;
import static com.flyingbrowniegames.ballgame.Variables.doubleBall1;
import static com.flyingbrowniegames.ballgame.Variables.doubleBall2;
import static com.flyingbrowniegames.ballgame.Variables.doubleBall3;
import static com.flyingbrowniegames.ballgame.Variables.duoBar;
import static com.flyingbrowniegames.ballgame.Variables.extremeFlipBall;
import static com.flyingbrowniegames.ballgame.Variables.extremeTachometer;
import static com.flyingbrowniegames.ballgame.Variables.mirrorBall;
import static com.flyingbrowniegames.ballgame.Variables.modeScreenTime;
import static com.flyingbrowniegames.ballgame.Variables.redWall;
import static com.flyingbrowniegames.ballgame.Variables.sprite4;
import static com.flyingbrowniegames.ballgame.Variables.stickman1;
import static com.flyingbrowniegames.ballgame.Variables.stickman2;
import static com.flyingbrowniegames.ballgame.Variables.versus;
import static com.flyingbrowniegames.ballgame.Variables.w;
import static com.flyingbrowniegames.ballgame.Variables.whiteBox1;

/**
 * Created by kyle on 2017-07-07.
 */

public class Animations {

    public static float leftX = ((w * 5) / 42) - (boxWidth / 2);
    public static float righX = ((w * 5) / 42) + (boxWidth / 2);
    public static float topY;
    public static float bottomY;
    public static float stickPosition1 = (w / 21) + (boxWidth / 3);
    public static float stickPosition2 = (w / 21) + ((boxWidth * 2) / 3);
    public static String stickDirection = "out";
    public static float mirrorPosition = (w / 21) + (boxWidth / 2);
    public static String mirrorDirection = "right";
    public static float blindAlpha = 1;
    public static String blindDirection = "down";
    public static String caneDirection = "right";
    public static float caneAngle = 0;
    public static float burstPosition1 = (w / 21) + ((boxWidth * 9) / 21);
    public static float burstPosition2 = (w / 21) + ((boxWidth * 10) / 21);
    public static float doublePosition1 = (w / 21) + (boxWidth / 2);
    public static float doublePosition2 = (w / 21) + (boxWidth / 2);
    public static float doubleAlpha1 = 1;
    public static float doubleAlpha2 = 0;
    public static float doubleAlpha3 = 0;
    public static String doubleDirection1 = "left";
    public static float arrowAngle = 0;
    public static String arrowDirection = "right";
    public static String extremeFlip = "top";
    public static long extremeNewTime = 0;

    public static void classicIconAnimation() {//mode screen classic logo animation
        topY = (Variables.h / 2 + (8 * Variables.h / 24) - Variables.deltaY) + (boxHeight / 2);
        bottomY = (Variables.h / 2 + (8 * Variables.h / 24) - Variables.deltaY) - (boxHeight / 2);
        batch.begin();
        blueWall.setCenter((w / 21) + ((boxWidth * 2) / 9) - (w / 94), (topY + bottomY) / 2);
        blueWall.draw(batch);
        redWall.setCenter((w / 21) + ((boxWidth * 7) / 9) + (w / 94), (topY + bottomY) / 2);
        redWall.draw(batch);
        Clasiclogo.setCenter(((leftX + righX) / 2), (topY + bottomY) / 2);
        Clasiclogo.draw(batch);
        batch.end();
        Clasiclogo.rotate(1);
    }

    public static void mirrorIconAnimation() {//mode screen mirror logo animation
        topY = (Variables.h / 2 + (2 * Variables.h / 24) - Variables.deltaY) + (boxHeight / 2);
        bottomY = (Variables.h / 2 + (2 * Variables.h / 24) - Variables.deltaY) - (boxHeight / 2);
        batch.begin();
        animationMirror.setCenter((w / 21) + ((boxWidth * 7) / 9) + (w / 94), (topY + bottomY) / 2);
        animationMirror.draw(batch);
        mirrorBall.setCenter(mirrorPosition, (topY + bottomY) / 2);
        mirrorBall.draw(batch);
        batch.end();
        if (mirrorDirection.equalsIgnoreCase("right")) {
            if (mirrorPosition >= (w / 21) + ((boxWidth * 7) / 9) - (boxWidth / 8) - (boxWidth / 16)) {
                mirrorPosition = ((w / 21) + ((boxWidth * 7) / 9) - (boxWidth / 8) - (boxWidth / 16));
                mirrorDirection = "left";
            } else {
                mirrorPosition += 1;
            }
        } else {
            if (mirrorPosition <= (w / 21) + (boxWidth / 8)) {
                mirrorPosition = (w / 21) + (boxWidth / 8);
                mirrorDirection = "right";
            } else {
                mirrorPosition -= 1;
            }
        }
    }

    public static void blindIconAnimation() {//mode screen blind logo animation
        topY = (Variables.h / 2 - (4 * Variables.h / 24) - Variables.deltaY) + (boxHeight / 2);
        bottomY = (Variables.h / 2 - (4 * Variables.h / 24) - Variables.deltaY) - (boxHeight / 2);
        batch.begin();
        blindBall.setAlpha(blindAlpha);
        blindBall.setCenter((w / 21) + (boxWidth / 2), (bottomY) + ((boxHeight * 18) / 24));
        blindBall.draw(batch);
        blindMan.setCenter((w / 21) + (boxWidth / 2), bottomY + (boxHeight / 3));
        blindMan.draw(batch);
        blindCane.setRotation(caneAngle);
        blindCane.setCenter((w / 21) + ((boxWidth) / 4), bottomY + (boxHeight / 4));
        blindCane.draw(batch);
        batch.end();
        if (blindDirection.equalsIgnoreCase("down")) {
            if (blindAlpha == 0) {
                blindDirection = "up";
            } else {
                blindAlpha -= 0.01;
            }
        } else if (blindDirection.equalsIgnoreCase("up")) {
            if (blindAlpha == 1) {
                blindDirection = "down";
            } else {
                blindAlpha += 0.01;
            }
        }
      /*  if (caneDirection.equalsIgnoreCase("right")) {
            if (caneAngle >= 1) {
                caneDirection = "left";
            } else {
                caneAngle += 0.2;
            }
        } else if (caneDirection.equalsIgnoreCase("left")) {
            if (caneAngle <= -1) {
                caneDirection = "right";
            } else {
                caneAngle -= 0.2;
            }
        }*/
    }

    public static void burstIconAnimation() {//mode screen burst logo animation
        topY = (Variables.h / 2 - (10 * Variables.h / 24) - Variables.deltaY) + (boxHeight / 2);
        bottomY = (Variables.h / 2 - (10 * Variables.h / 24) - Variables.deltaY) - (boxHeight / 2);
        batch.begin();
        burstBall.setCenter(((boxWidth * 2) / 3) + (w / 21), (topY + bottomY) / 2);
        burstBall.draw(batch);
        burstLines.setCenter(boxWidth / 2 + (w / 21), bottomY + boxHeight / 4);
        burstLines.draw(batch);
        burstCloud1.setCenter(burstPosition1, bottomY + boxHeight / 2);
        burstCloud1.draw(batch);
        burstCloud2.setCenter(burstPosition2, bottomY + boxHeight / 3);
        burstCloud2.draw(batch);
        if (burstPosition1 < ((w / 21) + ((boxWidth) / 21))) {
            burstCloud1.setAlpha(1);
            burstPosition1 = (w / 21 + ((boxWidth * 9) / 21));
        } else if (burstPosition1 < ((w / 21) + ((boxWidth * 2) / 21))) {
            burstCloud1.setAlpha(0);
        }
        burstPosition1 -= 1;
        if (burstPosition2 < ((w / 21) + ((boxWidth * 2) / 21))) {
            burstCloud2.setAlpha(1);
            burstPosition2 = ((w / 21 + ((boxWidth * 10) / 21)));
        } else if (burstPosition2 < (w / 21) + ((boxWidth * 3) / 21)) {
            burstCloud2.setAlpha(0);
        }
        burstPosition2 -= 1;
        batch.end();
    }

    public static void doubleIconAnimation() {//mode screen double logo animation
        topY = (Variables.h / 2 - (16 * Variables.h / 24) - Variables.deltaY) + (boxHeight / 2);
        bottomY = (Variables.h / 2 - (16 * Variables.h / 24) - Variables.deltaY) - (boxHeight / 2);
        batch.begin();
        doubleBall1.setAlpha(doubleAlpha1);
        doubleBall2.setAlpha(doubleAlpha2);
        doubleBall3.setAlpha(doubleAlpha3);
        doubleBall1.setCenter((w / 21) + boxWidth / 2, (bottomY + topY) / 2);
        doubleBall1.draw(batch);
        doubleBall2.setCenter(doublePosition1, (bottomY + topY) / 2);
        doubleBall2.draw(batch);
        doubleBall3.setCenter(doublePosition2, (bottomY + topY) / 2);
        doubleBall3.draw(batch);
        if (doubleDirection1.equalsIgnoreCase("left")) {
            if (doublePosition1 <= (w / 21) + (boxWidth / 6)) {
                doublePosition1 = (w / 21) + (boxWidth / 6);
                doublePosition2 = (w / 21) + ((boxWidth * 5) / 6);
                doubleDirection1 = "right";
            } else {
                doublePosition1 -= 1;
                doublePosition2 += 1;
                doubleAlpha1 -= 0.01;
                doubleAlpha2 += 0.01;
                doubleAlpha3 += 0.01;
            }
        } else if (doubleDirection1.equalsIgnoreCase("right")) {
            if (doublePosition1 >= (w / 21) + (boxWidth / 2)) {
                doublePosition1 = (w / 21) + (boxWidth / 2);
                doublePosition2 = (w / 21) + (boxWidth / 2);
                doubleDirection1 = "left";
            } else {
                doublePosition1 += 1;
                doublePosition2 -= 1;
                doubleAlpha1 += 0.01;
                doubleAlpha2 -= 0.01;
                doubleAlpha3 -= 0.01;
            }
        }
        batch.end();
    }

    public static void extremeIconAnimation() {//mode screen extreme logo animation
        topY = (Variables.h / 2 - (22 * Variables.h / 24) - Variables.deltaY) + (boxHeight / 2);
        bottomY = (Variables.h / 2 - (22 * Variables.h / 24) - Variables.deltaY) - (boxHeight / 2);
        batch.begin();
        blueArrow.setRotation(arrowAngle);
        blueArrow.setCenter((w / 21) + (boxWidth / 2), (topY + bottomY) / 2);
        blueArrow.draw(batch);
        extremeTachometer.setCenter((w / 21) + (boxWidth / 2), (bottomY) + ((boxHeight * 2) / 3));
        extremeTachometer.draw(batch);
        batch.end();
        if (arrowDirection.equalsIgnoreCase("right")) {
            if (arrowAngle <= -70) {
                arrowDirection = "left";
            } else {
                arrowAngle--;
            }
        } else if (arrowDirection.equalsIgnoreCase("left")) {
            if (arrowAngle >= 0) {
                arrowDirection = "right";
            } else {
                arrowAngle++;
            }
        }
    }

    public static void extremeFlipIconAnimation() {//mode screen extremeflip logo animation
        extremeNewTime = System.currentTimeMillis() - modeScreenTime;
        topY = (Variables.h / 2 - (28 * Variables.h / 24) - Variables.deltaY) + (boxHeight / 2);
        bottomY = (Variables.h / 2 - (28 * Variables.h / 24) - Variables.deltaY) - (boxHeight / 2);
        batch.begin();
        if (extremeFlip.equalsIgnoreCase("top")) {
            if (extremeNewTime >= 500) {
                extremeFlip = "bottom";
                extremeNewTime = 0;
                modeScreenTime = System.currentTimeMillis();
            } else {
                extremeFlipBall.setCenter((w / 21) + (boxWidth / 2), ((bottomY) + ((boxHeight * 4) / 5)));
                extremeFlipBall.draw(batch);
            }
        } else if (extremeFlip.equalsIgnoreCase("bottom")) {
            if (extremeNewTime >= 500) {
                extremeFlip = "top";
                extremeNewTime = 0;
                modeScreenTime = System.currentTimeMillis();
            } else {
                extremeFlipBall.setCenter((w / 21) + (boxWidth / 2), ((bottomY) + ((boxHeight * 1) / 5)));
                extremeFlipBall.draw(batch);
            }
        }

        blackBoard.setCenter((w / 21) + (boxWidth / 2), ((bottomY) + ((boxHeight) / 2)));
        blackBoard.draw(batch);
        batch.end();

    }

    public static void duoIconAnimation() {//mode screen duo logo animation
        topY = (Variables.h / 2 - (34 * Variables.h / 24) - Variables.deltaY) + (boxHeight / 2);
        bottomY = (Variables.h / 2 - (34 * Variables.h / 24) - Variables.deltaY) - (boxHeight / 2);
        batch.begin();
        duoBar.setCenter(((leftX + righX) / 2), bottomY + (boxHeight / 8));
        duoBar.draw(batch);
        stickman1.setCenter(stickPosition1, (topY + bottomY) / 2);
        stickman1.draw(batch);
        stickman2.setCenter(stickPosition2, (topY + bottomY) / 2);
        stickman2.draw(batch);
        versus.setCenter(((leftX + righX) / 2), topY - (boxHeight / 8));
        versus.draw(batch);
        batch.end();
        if (stickDirection.equalsIgnoreCase("out")) {//moving out from center
            if (stickPosition1 <= leftX + (w / 96)) {
                stickPosition1 = leftX + (w / 96);
                stickPosition2 = righX - (w / 96);
                stickDirection = "in";
            } else {
                stickPosition2 += 1;
                stickPosition1 -= 1;
            }
        } else {//moving into center
            if (stickPosition1 >= ((leftX + righX) / 2) - (w / 96)) {
                stickPosition1 = ((leftX + righX) / 2) - (w / 96);
                stickPosition2 = ((leftX + righX) / 2) + (w / 96);
                stickDirection = "out";
            } else {
                stickPosition2 -= 1;
                stickPosition1 += 1;
            }
        }
    }
}
