package com.flyingbrowniegames.ballgame;

/**
 * Created by kwisk_000 on 2016-12-03.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.blindinstruction;
import static com.flyingbrowniegames.ballgame.Variables.blindtutorialball;
import static com.flyingbrowniegames.ballgame.Variables.burstinstruction;
import static com.flyingbrowniegames.ballgame.Variables.checkButton;
import static com.flyingbrowniegames.ballgame.Variables.classicinstruction;
import static com.flyingbrowniegames.ballgame.Variables.dividersprite;
import static com.flyingbrowniegames.ballgame.Variables.doubleinstruction1;
import static com.flyingbrowniegames.ballgame.Variables.doubleinstruction2;
import static com.flyingbrowniegames.ballgame.Variables.doubleline;
import static com.flyingbrowniegames.ballgame.Variables.doubletutoriaball;
import static com.flyingbrowniegames.ballgame.Variables.duoinstruction1;
import static com.flyingbrowniegames.ballgame.Variables.duoinstruction2;
import static com.flyingbrowniegames.ballgame.Variables.extremeflipinstruction1;
import static com.flyingbrowniegames.ballgame.Variables.extremeflipinstruction2;
import static com.flyingbrowniegames.ballgame.Variables.extremeinstruction;
import static com.flyingbrowniegames.ballgame.Variables.fingertap;
import static com.flyingbrowniegames.ballgame.Variables.fingertap2;
import static com.flyingbrowniegames.ballgame.Variables.gotit;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.mirrorinstruction;
import static com.flyingbrowniegames.ballgame.Variables.mode;
import static com.flyingbrowniegames.ballgame.Variables.shapeRenderer;
import static com.flyingbrowniegames.ballgame.Variables.tutorial1;
import static com.flyingbrowniegames.ballgame.Variables.tutorial2;
import static com.flyingbrowniegames.ballgame.Variables.tutorial3;
import static com.flyingbrowniegames.ballgame.Variables.tutorial4;
import static com.flyingbrowniegames.ballgame.Variables.tutorial5;
import static com.flyingbrowniegames.ballgame.Variables.tutorial6;
import static com.flyingbrowniegames.ballgame.Variables.tutorial7;
import static com.flyingbrowniegames.ballgame.Variables.tutorial8;
import static com.flyingbrowniegames.ballgame.Variables.tutorialball;
import static com.flyingbrowniegames.ballgame.Variables.tutorialtitle;
import static com.flyingbrowniegames.ballgame.Variables.w;

public class TutorialScreen {
    public static void screen() {
        Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Variables.arc_degree_2 = 270;
        Variables.arc_degree_1 = 90;
        switch (mode) {
            case 1: //classic
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(0, (3 * h) / 14, w, (h * 8) / 14);
                shapeRenderer.setColor(Color.RED);
                //Variables.shapeRenderer.arc(w / 3, (h * 7) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 5) / 14, (Variables.w * 1 / 100) + 20, (h * 4) / 14);
                shapeRenderer.setColor(Color.BLUE);
                //Variables.shapeRenderer.arc(w / 3, (h * 7) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 5) / 14, (Variables.w * 1 / 100), (h * 4) / 14);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                tutorialtitle.setCenter(w / 2, Variables.h - (Variables.h / 13));
                tutorialtitle.draw(batch);
//                gotit.setRotation(0);
//                gotit.setCenter(w / 2, h / 10);
//                gotit.draw(batch);
                checkButton.setCenter(w / 2, h / 9);
                checkButton.draw(batch);
                fingertap.setCenter((w * 4) / 5, (h * 3) / 7);
                fingertap.setRotation(30);
                fingertap.draw(batch);
                classicinstruction.setCenter((w * 3) / 7, (h * 9) / 14);
                classicinstruction.draw(batch);
                if (tutorial1.getInteger("1") != 1) {
                    tutorial1.putInteger("1", 1);
                    tutorial1.flush();
                }
                batch.end();
                batch.begin();
                tutorialball.setCenter(w / 3, (h * 7) / 14);
                tutorialball.draw(batch);
                batch.end();

                break;
            case 2: //mirror
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(0, (3 * h) / 14, w, (h * 8) / 14);
                shapeRenderer.setColor(Color.RED);
                //Variables.shapeRenderer.arc(w / 4, (h * 7) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 5) / 14, (Variables.w * 1 / 100) + 20, (h * 4) / 14);
                shapeRenderer.setColor(Color.BLUE);
                //Variables.shapeRenderer.arc(w / 4, (h * 7) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 5) / 14, (Variables.w * 1 / 100), (h * 4) / 14);
                //shapeRenderer.setColor(50 / 255f, 54 / 255f, 51 / 255f, 0);
                // shapeRenderer.ellipse((w*5)/12, h / 3, w / 6, h / 3);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                Variables.gmirror.setCenter(Variables.w / 2, Variables.h / 2);
                Variables.gmirror.draw(Variables.batch);
                tutorialtitle.setCenter(w / 2, Variables.h - (Variables.h / 14));
                tutorialtitle.draw(batch);
//                gotit.setRotation(0);
//                gotit.setCenter(w / 2, h / 10);
//                gotit.draw(batch);
                checkButton.setCenter(w / 2, h / 10);
                checkButton.draw(batch);
                fingertap.setRotation(30);
                fingertap.setCenter((w * 4) / 5, (h * 3) / 7);
                fingertap.draw(batch);
                if (tutorial2.getInteger("2") != 1) {
                    tutorial2.putInteger("2", 1);
                    tutorial2.flush();
                }
                classicinstruction.setCenter((w * 3) / 7, (h * 10) / 14);
                mirrorinstruction.setCenter((w * 3) / 7, (h * 4) / 14);
                classicinstruction.draw(batch);
                mirrorinstruction.draw(batch);

                batch.end();
                batch.begin();
                tutorialball.setCenter(w / 4, (h * 7) / 14);
                tutorialball.draw(batch);
                batch.end();
                break;
            case 3: //blind
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(0, (3 * h) / 14, w, (h * 8) / 14);
                shapeRenderer.setColor(172 / 255f, 125 / 255f, 236 / 255f, 0);
                //Variables.shapeRenderer.arc(w / 3, (h * 7) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 5) / 14, (Variables.w * 1 / 100) + 20, (h * 4) / 14);
                shapeRenderer.setColor(94 / 255f, 79 / 255f, 240 / 255f, 0);
                // Variables.shapeRenderer.arc(w / 3, (h * 7) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 5) / 14, (Variables.w * 1 / 100), (h * 4) / 14);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                tutorialtitle.setCenter(w / 2, Variables.h - (Variables.h / 14));
                tutorialtitle.draw(batch);
//                gotit.setRotation(0);
//                gotit.setCenter(w / 2, h / 10);
//                gotit.draw(batch);
                checkButton.setCenter(w / 2, h / 10);
                checkButton.draw(batch);
                fingertap.setCenter((w * 4) / 5, (h * 3) / 7);
                fingertap.setRotation(30);
                fingertap.draw(batch);
                if (tutorial3.getInteger("3") != 1) {
                    tutorial3.putInteger("3", 1);
                    tutorial3.flush();
                }
                classicinstruction.setCenter((w * 3) / 7, (h * 10) / 14);
                classicinstruction.draw(batch);
                blindinstruction.setCenter((w * 4) / 7, (h * 9) / 14);
                blindinstruction.draw(batch);
                batch.end();
                batch.begin();
                blindtutorialball.setCenter(w / 3, (h * 7) / 14);
                blindtutorialball.draw(batch);
                batch.end();
                break;
            case 4://burst
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(0, (3 * h) / 14, w, (h * 8) / 14);
                shapeRenderer.setColor(Color.RED);
                // Variables.shapeRenderer.arc(w / 3, (h * 7) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 5) / 14, (Variables.w * 1 / 100) + 20, (h * 4) / 14);
                shapeRenderer.setColor(Color.BLUE);
                //Variables.shapeRenderer.arc(w / 3, (h * 7) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 5) / 14, (Variables.w * 1 / 100), (h * 4) / 14);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                tutorialtitle.setCenter(w / 2, Variables.h - (Variables.h / 14));
                tutorialtitle.draw(batch);
//                gotit.setRotation(0);
//                gotit.setCenter(w / 2, h / 10);
//                gotit.draw(batch);
                checkButton.setCenter(w / 2, h / 10);
                checkButton.draw(batch);
                fingertap.setCenter((w * 4) / 5, (h * 3) / 7);
                fingertap.setRotation(30);
                fingertap.draw(batch);
                if (tutorial4.getInteger("4") != 1) {
                    tutorial4.putInteger("4", 1);
                    tutorial4.flush();
                }
                classicinstruction.setCenter((w * 3) / 7, (h * 10) / 14);
                classicinstruction.draw(batch);
                burstinstruction.setCenter((w * 4) / 7, (h * 9) / 14);
                burstinstruction.draw(batch);
                batch.end();
                batch.begin();
                tutorialball.setCenter(w / 3, (h * 7) / 14);
                tutorialball.draw(batch);
                batch.end();

                break;
            case 5: //double
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(0, (3 * h) / 14, w, (h * 8) / 14);
                shapeRenderer.setColor(Color.RED);
                //Variables.shapeRenderer.arc((w * 3) / 4, (h * 9) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 7) / 14, (Variables.w * 1 / 100) + 20, (h * 4) / 14);
                shapeRenderer.setColor(Color.BLUE);
                //Variables.shapeRenderer.arc((w * 3) / 4, (h * 9) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 7) / 14, (Variables.w * 1 / 100), (h * 4) / 14);
                shapeRenderer.setColor(90 / 255f, 13 / 255f, 195 / 255f, 0); //dark purple
                //Variables.shapeRenderer.arc((w) / 4, (h * 5) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 3) / 14, (Variables.w * 1 / 100) + 20, (h * 4) / 14);
                shapeRenderer.setColor(243 / 255f, 178 / 255f, 66 / 255f, 0); //orange
                //Variables.shapeRenderer.arc((w) / 4, (h * 5) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 3) / 14, (Variables.w * 1 / 100), (h * 4) / 14);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                tutorialtitle.setCenter(w / 2, Variables.h - (Variables.h / 14));
                tutorialtitle.draw(batch);
//                gotit.setRotation(0);
//                gotit.setCenter(w / 2, h / 11);
//                gotit.draw(batch);
                checkButton.setCenter(w / 2, h / 11);
                checkButton.draw(batch);
                fingertap.setCenter((w * 4) / 5, (h * 7) / 14);
                fingertap.setRotation(30);
                fingertap.draw(batch);
                doubleinstruction1.setCenter(w / 4, (h * 7) / 14);
                doubleinstruction1.draw(batch);
                doubleinstruction2.setCenter((w * 3) / 4, (h * 5) / 14);
                doubleinstruction2.draw(batch);
                doubleline.setCenter(w / 2, (h * 7) / 14);
                doubleline.draw(batch);
                if (tutorial5.getInteger("5") != 1) {
                    tutorial5.putInteger("5", 1);
                    tutorial5.flush();
                }
                batch.end();
                batch.begin();
                tutorialball.setCenter((w * 3) / 4, (h * 9) / 14);
                tutorialball.draw(batch);
                doubletutoriaball.setCenter((w) / 4, (h * 5) / 14);
                doubletutoriaball.draw(batch);
                batch.end();

                break;
            case 6: //extreme
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(0, (3 * h) / 14, w, (h * 8) / 14);
                shapeRenderer.setColor(Color.RED);
                shapeRenderer.setColor(Color.RED);
                //Variables.shapeRenderer.arc(w / 3, (h * 7) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 5) / 14, (Variables.w * 1 / 100) + 20, (h * 4) / 14);
                shapeRenderer.setColor(Color.BLUE);
                //Variables.shapeRenderer.arc(w / 3, (h * 7) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 5) / 14, (Variables.w * 1 / 100), (h * 4) / 14);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                tutorialtitle.setCenter(w / 2, Variables.h - (Variables.h / 14));
                tutorialtitle.draw(batch);
//                gotit.setRotation(0);
//                gotit.setCenter(w / 2, h / 10);
//                gotit.draw(batch);
                checkButton.setCenter(w / 2, h / 10);
                checkButton.draw(batch);
                fingertap.setCenter((w * 4) / 5, (h * 3) / 7);
                fingertap.setRotation(30);
                fingertap.draw(batch);
                if (tutorial6.getInteger("6") != 1) {
                    tutorial6.putInteger("6", 1);
                    tutorial6.flush();
                }
                extremeinstruction.setCenter((w * 4) / 7, (h * 9) / 14);
                extremeinstruction.draw(batch);
                batch.end();
                batch.begin();
                tutorialball.setCenter(w / 3, (h * 7) / 14);
                tutorialball.draw(batch);
                batch.end();
                break;
            case 7: //extremeflip
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(0, (3 * h) / 14, w, (h * 8) / 14);
                shapeRenderer.setColor(Color.RED);
                //Variables.shapeRenderer.arc((w * 3) / 4, (h * 10) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 9) / 14, (Variables.w * 1 / 100) + 20, (h * 2) / 14);
                shapeRenderer.setColor(Color.BLUE);
                //Variables.shapeRenderer.arc((w * 3) / 4, (h * 10) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 9) / 14, (Variables.w * 1 / 100), (h * 2) / 14);
                shapeRenderer.setColor(90 / 255f, 13 / 255f, 195 / 255f, 0); //dark purple
                //Variables.shapeRenderer.arc((w) / 4, (h * 4) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 3) / 14, (Variables.w * 1 / 100) + 20, (h * 2) / 14);
                shapeRenderer.setColor(243 / 255f, 178 / 255f, 66 / 255f, 0); //orange
                //Variables.shapeRenderer.arc((w) / 4, (h * 4) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 3) / 14, (Variables.w * 1 / 100), (h * 2) / 14);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                tutorialtitle.setCenter(w / 2, Variables.h - (Variables.h / 14));
                tutorialtitle.draw(batch);
                //gotit.setRotation(0);
                //gotit.setCenter(w / 2, h / 11);
                //gotit.draw(batch);
                checkButton.setCenter(w / 2, h / 11);
                checkButton.draw(batch);
                fingertap.setRotation(30);
                fingertap.setCenter((w * 4) / 5, (h * 5) / 14);
                fingertap.draw(batch);
                dividersprite.setCenter(w / 2, h / 2);
                dividersprite.draw(batch);
                extremeflipinstruction1.setCenter((w * 5) / 12, (h * 8) / 14);
                extremeflipinstruction1.draw(batch);
                extremeflipinstruction2.setCenter(w / 3, (h * 6) / 14);
                extremeflipinstruction2.draw(batch);
                if (tutorial7.getInteger("7") != 1) {
                    tutorial7.putInteger("7", 1);
                    tutorial7.flush();
                }
                batch.end();
                batch.begin();
                tutorialball.setCenter((w * 3) / 4, (h * 10) / 14);
                tutorialball.draw(batch);
                doubletutoriaball.setCenter((w) / 4, (h * 4) / 14);
                doubletutoriaball.draw(batch);
                batch.end();
                break;
            case 8: //duo
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(0, 0, w, h);
                shapeRenderer.setColor(Color.RED);
                //Variables.shapeRenderer.arc((w * 3) / 4, (h * 10) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 8) / 14, (Variables.w * 1 / 100) + 20, (h * 4) / 14);
                shapeRenderer.setColor(Color.BLUE);
                //Variables.shapeRenderer.arc((w * 3) / 4, (h * 10) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 8) / 14, (Variables.w * 1 / 100), (h * 4) / 14);
                shapeRenderer.setColor(90 / 255f, 13 / 255f, 195 / 255f, 0); //dark purple
                //Variables.shapeRenderer.arc((w) / 4, (h * 4) / 14, Variables.arc_width, Variables.arc_degree_1, 180);
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (h * 2) / 14, (Variables.w * 1 / 100) + 20, (h * 4) / 14);
                shapeRenderer.setColor(243 / 255f, 178 / 255f, 66 / 255f, 0); //orange
                //Variables.shapeRenderer.arc((w) / 4, (h * 4) / 14, Variables.arc_width, Variables.arc_degree_2, 180);
                Variables.shapeRenderer.rect(0, (h * 2) / 14, (Variables.w * 1 / 100), (h * 4) / 14);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                gotit.setCenter(w / 2, h / 2);
                gotit.draw(batch);
                gotit.rotate(1);
                fingertap.setCenter((w * 4) / 5, (h * 2) / 14);
                fingertap.setRotation(30);
                fingertap.draw(batch);
                fingertap2.setCenter((w) / 5, (h * 12) / 14);
                fingertap2.setRotation(210);
                fingertap2.draw(batch);
                if (tutorial8.getInteger("8") != 1) {
                    tutorial8.putInteger("8", 1);
                    tutorial8.flush();
                }
                //duostruction1.setRotation(180);
                duoinstruction1.setCenter((w * 2) / 3, (h * 12) / 14);
                duoinstruction1.draw(batch);
                duoinstruction2.setCenter(w / 3, (h * 2) / 14);
                duoinstruction2.draw(batch);
                batch.end();
                batch.begin();
                tutorialball.setCenter((w * 3) / 4, (h * 10) / 14);
                tutorialball.draw(batch);
                doubletutoriaball.setCenter((w) / 4, (h * 4) / 14);
                doubletutoriaball.draw(batch);
                batch.end();
                break;

        }


    }
}

