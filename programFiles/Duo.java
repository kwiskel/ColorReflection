package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

import static com.flyingbrowniegames.ballgame.BallGame.drawSprite;
import static com.flyingbrowniegames.ballgame.BallGame.rotateSprite;
import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Others.check_hit;
import static com.flyingbrowniegames.ballgame.Others.duohit;
import static com.flyingbrowniegames.ballgame.Others.make_substring;
import static com.flyingbrowniegames.ballgame.Variables.arc_degree_1;
import static com.flyingbrowniegames.ballgame.Variables.arc_degree_2;
import static com.flyingbrowniegames.ballgame.Variables.ball;
import static com.flyingbrowniegames.ballgame.Variables.ball2;
import static com.flyingbrowniegames.ballgame.Variables.ballposition;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.countone;
import static com.flyingbrowniegames.ballgame.Variables.countthree;
import static com.flyingbrowniegames.ballgame.Variables.counttwo;
import static com.flyingbrowniegames.ballgame.Variables.duobefore;
import static com.flyingbrowniegames.ballgame.Variables.duogames;
import static com.flyingbrowniegames.ballgame.Variables.duopausehome;
import static com.flyingbrowniegames.ballgame.Variables.duopausehowto;
import static com.flyingbrowniegames.ballgame.Variables.duopauseresume;
import static com.flyingbrowniegames.ballgame.Variables.duoreset;
import static com.flyingbrowniegames.ballgame.Variables.duoreset2;
import static com.flyingbrowniegames.ballgame.Variables.duoscore1;
import static com.flyingbrowniegames.ballgame.Variables.duoscore2;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.dnumber1;
import static com.flyingbrowniegames.ballgame.Variables.dnumber2;
import static com.flyingbrowniegames.ballgame.Variables.dnumber3;
import static com.flyingbrowniegames.ballgame.Variables.dnumber4;
import static com.flyingbrowniegames.ballgame.Variables.leftball;
import static com.flyingbrowniegames.ballgame.Variables.namesprite;
import static com.flyingbrowniegames.ballgame.Variables.p1sprite;
import static com.flyingbrowniegames.ballgame.Variables.pause;
import static com.flyingbrowniegames.ballgame.Variables.pausetime;
import static com.flyingbrowniegames.ballgame.Variables.position_x;
import static com.flyingbrowniegames.ballgame.Variables.rightball;
import static com.flyingbrowniegames.ballgame.Variables.score1;
import static com.flyingbrowniegames.ballgame.Variables.score2;
import static com.flyingbrowniegames.ballgame.Variables.score_font;
import static com.flyingbrowniegames.ballgame.Variables.secondleftball;
import static com.flyingbrowniegames.ballgame.Variables.secondrightball;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kwisk_000 on 2016-05-08.
 */
public class Duo {
    public static int position_x2 = Variables.w / 2;
    public static int arc_degree12 = 90;
    public static int arc_degree22 = 270;
    public static int arc_left_id2 = 6;
    public static int arc_right_id2 = 7;
    public static int right_id2 = 6;
    public static int left_id2 = 7;
    public static int direction2;
    public static int loop = 0;
    public static int ballposition2 = w / 22;


    public static void set_screen() {
        Variables.speed_increase = 5;
        //Variables.speed_increase = 2;
        Variables.mode = 8;
        Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Variables.batch.begin();
        Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_left_id);
        //Variables.shapeRenderer.arc(Variables.position_x, (Variables.h) / 4, Variables.arc_width, Variables.arc_degree_1, 180);
        //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_right_id);
        //Variables.shapeRenderer.arc(Variables.position_x, (Variables.h) / 4, Variables.arc_width, Variables.arc_degree_2, 180);
        com.flyingbrowniegames.ballgame.Colours.left_color();
        Variables.shapeRenderer.rect(0, 0, (Variables.w * 1 / 100), (Variables.h * 8) / 20);
        com.flyingbrowniegames.ballgame.Colours.right_color();
        Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), 0, (Variables.w * 1 / 100) + 20, (Variables.h * 8) / 20);
        Variables.shapeRenderer.end();
        Variables.score_font.setColor(Color.WHITE);
        Variables.score_font.draw(Variables.batch, Variables.score_string, make_substring(Variables.name_font_width, Variables.score_string.length()), (Variables.h * 9) / 10);
        Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);//upper ball
        //com.flyingbrowniegames.ballgame.Colours.arc_color(arc_left_id2);
        //Variables.shapeRenderer.arc(position_x2, (3 * Variables.h) / 4, Variables.arc_width, arc_degree12, 180);
        //com.flyingbrowniegames.ballgame.Colours.arc_color(arc_right_id2);
        //Variables.shapeRenderer.arc(position_x2, (3 * Variables.h) / 4, Variables.arc_width, arc_degree22, 180);
        com.flyingbrowniegames.ballgame.ColoursDouble.left_color();
        Variables.shapeRenderer.rect(0, (Variables.h * 12) / 20, (Variables.w * 1 / 100), (Variables.h * 8) / 20);
        com.flyingbrowniegames.ballgame.ColoursDouble.right_color();
        Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (Variables.h * 12) / 20, (Variables.w * 1 / 100) + 20, (Variables.h * 8) / 20);
        Variables.shapeRenderer.end();
        Variables.batch.end();
        Variables.batch.begin();
        //namesprite.setCenter(w / 2, (Variables.h ) / 2);
        //namesprite.draw(batch);
        Variables.sprite4.setCenter(Variables.w / 2, (Variables.h) / 2);
        Variables.sprite4.draw(Variables.batch);
        Variables.sprite4.rotate(1);
        Variables.p2sprite.setRotation(180);
        Variables.p2sprite.setCenter(Variables.w / 2, (Variables.h * 9) / 10);
        Variables.p2sprite.draw(Variables.batch);
        p1sprite.setRotation(180);
        p1sprite.setCenter(Variables.w / 2, (Variables.h * 1) / 10);
        p1sprite.draw(Variables.batch);
        Variables.batch.end();
        batch.begin();
        Variables.greensquare.setCenter(w / 10, (h * 13) / 20);
        Variables.greensquare.draw(batch);
        Variables.redsquare.setCenter((w * 9) / 10, (h * 7) / 20);
        Variables.redsquare.draw(batch);
        //duoreset.setOriginCenter();
        duoreset.setRotation(180);
        duoreset.setCenter((w / 5), (h * 12) / 20);
        duoreset.draw(batch);
        //duoreset2.setCenter(100,100);
        batch.end();
        batch.begin();
        duoreset2.setCenter(((w * 32) / 40), (h * 8) / 20);
        duoreset2.draw(batch);
        batch.end();
        batch.begin();
        Colours.arc_color(Variables.arc_left_id, "left", 4);
        leftball.setCenter(position_x - ballposition, h / 5);
        leftball.draw(batch);
        Colours.arc_color(Variables.arc_right_id, "right", 4);
        rightball.setCenter(position_x + ballposition, h / 5);
        rightball.draw(batch);
        Colours.arc_color(arc_left_id2, "left2", 4);
        //secondleftball.setFlip(true, false);
        //secondrightball.setFlip(false, false);
        //secondleftball.setRotation(180);
        secondleftball.setCenter(position_x2 - ballposition2, (h * 4) / 5);
        secondleftball.draw(batch);
        Colours.arc_color(arc_right_id2, "right2", 4);
        //secondrightball.setRotation(180);
        secondrightball.setCenter(position_x2 + ballposition2, (h * 4) / 5);
        secondrightball.draw(batch);
        //ball.setCenter(w / 2, h / 5);
        //ball.draw(batch);
        //ball2.setCenter(w / 2, (h * 4) / 5);
        //ball2.draw(batch);
        batch.end();
        //ball.rotate(1);
        //ball2.rotate(1);
        //batch.begin();
        score_font.setColor(Color.WHITE);
        String score11 = String.valueOf(duoscore1.getInteger("score1"));
        String score22 = String.valueOf(duoscore2.getInteger("score2"));
        if (loop == 0) { //assign new textures to Sprites (score changed)
            ArrayList<String> score1 = new ArrayList<String>();
            ArrayList<String> score2 = new ArrayList<String>();
            for (int i = 0; i < score11.length(); i++) {
                score1.add(score11.substring(i, i + 1));
            }
            for (int i = 0; i < score22.length(); i++) {
                score2.add(score22.substring(i, i + 1));
            }
            if (score11.length() == 1) {
                dnumber1 = sprites.get(((Numbers.print2(String.valueOf(duoscore1.getInteger("score1"))))));
                //dnumber1.setRotation(180);
                dnumber1.setSize(w / 17, h / 25);
            } else if (score11.length() == 2) {
                dnumber1 = sprites.get(((Numbers.print2(String.valueOf(String.valueOf(score1.get(0)))))));
                //dnumber1.setRotation(180);
                dnumber1.setSize(w / 17, h / 25);
                dnumber2 = sprites.get(((Numbers.print2(String.valueOf(String.valueOf(score1.get(1)))))));
                //dnumber2.setRotation(180);
                dnumber2.setSize(w / 17, h / 25);
            } else {
                dnumber1 = sprites.get((("uduonine.png")));
                dnumber1.setSize(w / 17, h / 25);
                // dnumber1.setRotation(180);
                dnumber2 = sprites.get((("uduonine.png")));
                dnumber2.setSize(w / 17, h / 25);
                // dnumber1.setRotation(180);
            }
            if (score22.length() == 1) {
                dnumber3 = sprites.get(((Numbers.print(String.valueOf(duoscore2.getInteger("score2"))))));
                dnumber3.setSize(w / 17, h / 25);
            } else if (score22.length() == 2) {
                dnumber3 = sprites.get(((Numbers.print(String.valueOf(String.valueOf(score2.get(0)))))));
                dnumber3.setSize(w / 17, h / 25);
                dnumber4 = sprites.get(((Numbers.print(String.valueOf(String.valueOf(score2.get(1)))))));
                dnumber4.setSize(w / 17, h / 25);
            } else {
                dnumber3 = sprites.get((("duonine.png")));
                dnumber3.setSize(w / 17, h / 25);
                dnumber4 = sprites.get((("duonine.png")));
                dnumber4.setSize(w / 17, h / 25);
            }
            loop = 1;
        } else {

        }

        if (score11.length() == 1) {
            //duo_tally_font.draw(batch, String.valueOf(duoscore1.getInteger("score1")), (w) / 10, (h * 26) / 40);
            batch.begin();
            dnumber1.setCenter((w * 21) / 160, (h * 27) / 40);
            dnumber1.draw(batch);
            batch.end();
        } else if (score11.length() == 2) {
            // duo_tally_font.draw(batch, score1.get(1), (w) / 40, (h * 13) / 20);
            batch.begin();
            dnumber1.setCenter((w * 21) / 160, (h * 27) / 40);
            dnumber1.draw(batch);
            dnumber2.setCenter((w) / 20, (h * 25) / 40);
            dnumber2.draw(batch);
            batch.end();
            //duo_tally_font.draw(batch, score1.get(0), (w) / 10, (h * 26) / 40);

        } else {
            //duo_tally_font.draw(batch, "9", (w) / 40, (h * 13) / 20);
            //duo_tally_font.draw(batch, "9", (w) / 10, (h * 26) / 40);
            batch.begin();
            dnumber1.setCenter((w * 21) / 160, (h * 27) / 40);
            dnumber1.draw(batch);
            dnumber2.setCenter((w) / 20, (h * 25) / 40);
            dnumber2.draw(batch);
            batch.end();

        }
        if (score22.length() == 1) {
            // score_font.draw(batch, String.valueOf(duoscore2.getInteger("score2")), (w * 33) / 40, (h * 7) / 20);
            batch.begin();
            dnumber3.setCenter((w * 34) / 40, (h * 13) / 40);
            dnumber3.draw(batch);
            batch.end();

        } else if (score22.length() == 2) {
            //score_font.draw(batch, score2.get(0), (w * 33) / 40, (h * 7) / 20);
            //score_font.draw(batch, score2.get(1), (w * 36) / 40, (h * 15) / 40);
            batch.begin();
            dnumber3.setCenter((w * 34) / 40, (h * 13) / 40);
            dnumber3.draw(batch);
            dnumber4.setCenter((w * 75) / 80, (h * 29) / 80);
            dnumber4.draw(batch);
            batch.end();

        } else {
            //score_font.draw(batch, "9", (w * 33) / 40, (h * 7) / 20);
            //score_font.draw(batch, "9", (w * 36) / 40, (h * 15) / 40);
            batch.begin();
            dnumber3.setCenter((w * 34) / 40, (h * 13) / 40);
            dnumber3.draw(batch);
            dnumber4.setCenter((w * 75) / 80, (h * 29) / 80);
            dnumber4.draw(batch);
            batch.end();

        }
        //batch.end();

    }

    public static void play_screen() {
        loop = 0;
        duobefore = duogames.getInteger("games");
        score1 = duoscore1.getInteger("score1");
        score2 = duoscore2.getInteger("score2");
        Variables.speed_increase = 2;
        BallGame.games_before = BallGame.games_elapsed;
        if (Variables.paused == true) { // pause the game
            Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            duopausehowto.setCenter((w * 3) / 4, h / 2);
            duopausehowto.draw(batch);
            duopausehowto.rotate(1);
            duopausehome.setCenter(w / 4, h / 2);
            duopausehome.draw(batch);
            duopausehome.rotate(1);
            duopauseresume.setCenter(w / 2, h / 2);
            duopauseresume.draw(batch);
            duopauseresume.rotate(1);
            batch.end();
            /*batch.begin();
            checkbox.setCenter(w / 3, h / 3);
            checkbox.draw(batch);
            checkbox2.setCenter(w / 3, h / 6);
            checkbox2.draw(batch);
            checktext1.setCenter((w * 2) / 3, h / 3);
            checktext1.draw(batch);
            checktext2.setCenter((w * 2) / 3, h / 6);
            checktext2.draw(batch);
            batch.end();*/
        } else if (Variables.paused == false) {// resume the game
            if (System.currentTimeMillis() - pausetime < 3000) {
                Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_left_id);
                //Variables.shapeRenderer.arc(Variables.position_x, (Variables.h) / 4, Variables.arc_width, Variables.arc_degree_1, 180);
                //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_right_id);
                //Variables.shapeRenderer.arc(Variables.position_x, (Variables.h) / 4, Variables.arc_width, Variables.arc_degree_2, 180);
                com.flyingbrowniegames.ballgame.Colours.left_color();
                Variables.shapeRenderer.rect(0, 0, (Variables.w * 1 / 100), (Variables.h * 8) / 20);
                com.flyingbrowniegames.ballgame.Colours.right_color();
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), 0, (Variables.w * 1 / 100) + 20, (Variables.h * 8) / 20);
                Variables.shapeRenderer.end();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);//upper ball
                // com.flyingbrowniegames.ballgame.Colours.arc_color(arc_left_id2);
                //Variables.shapeRenderer.arc(position_x2, (3 * Variables.h) / 4, Variables.arc_width, arc_degree12, 180);
                //com.flyingbrowniegames.ballgame.Colours.arc_color(arc_right_id2);
                //Variables.shapeRenderer.arc(position_x2, (3 * Variables.h) / 4, Variables.arc_width, arc_degree22, 180);
                com.flyingbrowniegames.ballgame.ColoursDouble.left_color();
                Variables.shapeRenderer.rect(0, (Variables.h * 12) / 20, (Variables.w * 1 / 100), (Variables.h * 8) / 20);
                com.flyingbrowniegames.ballgame.ColoursDouble.right_color();
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (Variables.h * 12) / 20, (Variables.w * 1 / 100) + 20, (Variables.h * 8) / 20);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                Variables.batch.begin();
                //Variables.score_font.setColor(Color.WHITE);
                //Variables.score_font.draw(Variables.batch, Variables.score_string, make_substring(Variables.name_font_width, Variables.score_string.length()), Variables.h / 2);
                Variables.batch.end();
                batch.begin();
                Colours.arc_color(Variables.arc_left_id, "left", 4);
                leftball.setCenter(position_x - ballposition, h / 5);
                leftball.draw(batch);
                Colours.arc_color(Variables.arc_right_id, "right", 4);
                rightball.setCenter(position_x + ballposition, h / 5);
                rightball.draw(batch);
                batch.end();
                batch.begin();
                Colours.arc_color(arc_left_id2, "left2", 4);
                //secondleftball.setRotation(180);
                secondleftball.setCenter(position_x2 - ballposition2, (h * 4) / 5);
                secondleftball.draw(batch);
                Colours.arc_color(arc_right_id2, "right2", 4);
                //secondrightball.setRotation(180);
                secondrightball.setCenter(position_x2 + ballposition2, (h * 4) / 5);
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
                duopausehowto.setRotation(0);
                duopausehome.setRotation(0);
                duopauseresume.setRotation(0);
                Variables.loop = 0;
                Variables.zero_to_three = 0;
                Variables.score_string = "" + Variables.score;
                Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                Variables.batch.begin();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_left_id);
                //Variables.shapeRenderer.arc(Variables.position_x, (Variables.h) / 4, Variables.arc_width, Variables.arc_degree_1, 180);
                //com.flyingbrowniegames.ballgame.Colours.arc_color(Variables.arc_right_id);
                //Variables.shapeRenderer.arc(Variables.position_x, (Variables.h) / 4, Variables.arc_width, Variables.arc_degree_2, 180);
                com.flyingbrowniegames.ballgame.Colours.left_color();
                Variables.shapeRenderer.rect(0, 0, (Variables.w * 1 / 100), (Variables.h * 8) / 20);
                com.flyingbrowniegames.ballgame.Colours.right_color();
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), 0, (Variables.w * 1 / 100) + 20, (Variables.h * 8) / 20);
                Variables.shapeRenderer.end();
                Variables.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);//upper ball
                //com.flyingbrowniegames.ballgame.Colours.arc_color(arc_left_id2);
                //Variables.shapeRenderer.arc(position_x2, (3 * Variables.h) / 4, Variables.arc_width, arc_degree12, 180);
                //com.flyingbrowniegames.ballgame.Colours.arc_color(arc_right_id2);
                //Variables.shapeRenderer.arc(position_x2, (3 * Variables.h) / 4, Variables.arc_width, arc_degree22, 180);
                com.flyingbrowniegames.ballgame.ColoursDouble.left_color();
                Variables.shapeRenderer.rect(0, (Variables.h * 12) / 20, (Variables.w * 1 / 100), (Variables.h * 8) / 20);
                com.flyingbrowniegames.ballgame.ColoursDouble.right_color();
                Variables.shapeRenderer.rect(Variables.w - (Variables.w * 1 / 100), (Variables.h * 12) / 20, (Variables.w * 1 / 100) + 20, (Variables.h * 8) / 20);
                Variables.shapeRenderer.end();
                Variables.batch.end();
                batch.begin();
                Colours.arc_color(Variables.arc_left_id, "left", 4);
                leftball.setCenter(position_x - ballposition, h / 5);
                leftball.draw(batch);
                Colours.arc_color(Variables.arc_right_id, "right", 4);
                rightball.setCenter(position_x + ballposition, h / 5);
                rightball.draw(batch);
                batch.end();
                batch.begin();
                Colours.arc_color(arc_left_id2, "left2", 4);
                secondleftball.setCenter(position_x2 - ballposition2, (h * 4) / 5);
                secondleftball.draw(batch);
                Colours.arc_color(arc_right_id2, "right2", 4);
                secondrightball.setCenter(position_x2 + ballposition2, (h * 4) / 5);
                secondrightball.draw(batch);
                batch.end();
                //Variables.batch.begin();
                //Variables.score_font.setColor(Color.WHITE);
                //Variables.score_font.draw(Variables.batch, Variables.score_string, make_substring(Variables.name_font_width, Variables.score_string.length()), Variables.h / 2);
                //;Variables.batch.end();
                batch.begin();
                pause.setCenter(w / 2, h / 2);
                pause.draw(batch);
                batch.end();
                int score_before = Variables.score;
                com.flyingbrowniegames.ballgame.MoveBall.change_direction(); // change ball direction
                com.flyingbrowniegames.ballgame.MoveBall.change_x(); //move ball
                check_hit();// check to see if colours match when ball contacts wall and add score
                duohit();
                int score_after = Variables.score;
                if (score_after - score_before == 1) {
                    com.flyingbrowniegames.ballgame.ColoursDouble.Color_from_int();
                    com.flyingbrowniegames.ballgame.Colours.Colors();
                }
            }
        }

    }
}
