package com.flyingbrowniegames.ballgame;

import static com.flyingbrowniegames.ballgame.BallGame.flipSprite;
import static com.flyingbrowniegames.ballgame.Variables.arc_degree_1;
import static com.flyingbrowniegames.ballgame.Variables.ballposition;
import static com.flyingbrowniegames.ballgame.Variables.blindleftball;
import static com.flyingbrowniegames.ballgame.Variables.blindrightball;
import static com.flyingbrowniegames.ballgame.Variables.direction;
import static com.flyingbrowniegames.ballgame.Variables.leftball;
import static com.flyingbrowniegames.ballgame.Variables.mode;
import static com.flyingbrowniegames.ballgame.Variables.pausetime;
import static com.flyingbrowniegames.ballgame.Variables.restarted;
import static com.flyingbrowniegames.ballgame.Variables.rightball;
import static com.flyingbrowniegames.ballgame.Variables.screen;

/**
 * Created by kyle on 2017-04-25.
 */

public class ContinueGame {

    public static void returnToPlayScreen() {
        restarted = 1;
        //System.out.println("arcdegree1 " + arc_degree_1 + "flippedx " + rightball.isFlipX());
        switch (mode) {
            case 1://classic mode
                screen = 2;
                if (Variables.arc_degree_1 == 90) {
                    Variables.arc_degree_1 = 270;
                    Variables.arc_degree_2 = 90;
                } else if (Variables.arc_degree_1 == 270) {
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                } else {

                }
                //flipSprite("rightball", true, false);
                //flipSprite("leftball", true, false);
                rightball.flip(true, false);
                leftball.flip(true, false);
                ballposition = ballposition * -1;
                pausetime = System.currentTimeMillis();
                break;
            case 2: //mirror mode
                screen = 15;
                if (Variables.arc_degree_1 == 90) {
                    Variables.arc_degree_1 = 270;
                    Variables.arc_degree_2 = 90;
                } else if (Variables.arc_degree_1 == 270) {
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                } else {

                }
                rightball.flip(true, false);
                leftball.flip(true, false);
                //flipSprite("rightball", true, false);
                //flipSprite("leftball", true, false);
                ballposition = ballposition * -1;
                pausetime = System.currentTimeMillis();
                break;
            case 3: //blind mode
                screen = 16;
                if (Variables.arc_degree_1 == 90) {
                    Variables.arc_degree_1 = 270;
                    Variables.arc_degree_2 = 90;
                } else if (Variables.arc_degree_1 == 270) {
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                } else {

                }
                blindrightball.flip(true, false);
                blindleftball.flip(true, false);
                //flipSprite("blindrightball", true, false);
                //flipSprite("blindleftball", true, false);
                ballposition = ballposition * -1;
                pausetime = System.currentTimeMillis();
                break;
        }
    }
}
