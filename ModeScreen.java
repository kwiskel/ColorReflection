package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;


import static com.flyingbrowniegames.ballgame.BallGame.drawSprite;
import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.batch;

/**
 * Created by kwisk_000 on 2016-05-01.
 */
public class ModeScreen {
    public static void setScreen() {
        /*Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        Variables.shapeRenderer.end();
        //drawSprite("classic", (Variables.w - ((Variables.w * 9) / 28)), (Variables.h / 2 + (5 * Variables.h / 12) - Variables.deltaY));
        Variables.classicsprite.setCenter(Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 + (5 * Variables.h / 12) - Variables.deltaY);
         Variables.classicsprite.draw(batch);
        //drawSprite("mirror", Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 + (3 * Variables.h / 12) - Variables.deltaY);
        Variables.mirrorsprite.setCenter(Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 + (3 * Variables.h / 12) - Variables.deltaY);
        Variables.mirrorsprite.draw(batch);
        //drawSprite("color_blind", Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 + (1 * Variables.h / 12) - Variables.deltaY);
        Variables.blindsprite.setCenter(Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 + (1 * Variables.h / 12) - Variables.deltaY);
         Variables.blindsprite.draw(batch);
        //drawSprite("burst", Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 - (1 * Variables.h / 12) - Variables.deltaY);
        Variables.burstsprite.setCenter(Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 - (1 * Variables.h / 12) - Variables.deltaY);
         Variables.burstsprite.draw(batch);
        //drawSprite("double", Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 - (3 * Variables.h / 12) - Variables.deltaY);
        Variables.double2sprite.setCenter(Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 - (3 * Variables.h / 12) - Variables.deltaY);
        Variables.double2sprite.draw(batch);
        //drawSprite("extreme", Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 - (5 * Variables.h / 12) - Variables.deltaY);
         Variables.extremesprite.setCenter(Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 - (5 * Variables.h / 12) - Variables.deltaY);
        Variables.extremesprite.draw(batch);
        //drawSprite("extremeflip", Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 - (7 * Variables.h / 12) - Variables.deltaY);
        Variables.extremefsprite.setCenter(Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 - (7 * Variables.h / 12) - Variables.deltaY);
        Variables.extremefsprite.draw(batch);
        //drawSprite("duo", Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 - (9 * Variables.h / 12) - Variables.deltaY);
        Variables.duosprite.setCenter(Variables.w - ((Variables.w * 9) / 28), Variables.h / 2 - (9 * Variables.h / 12) - Variables.deltaY);
        Variables.duosprite.draw(batch);
        batch.end();
        batch.begin();
        ModeScorePrint.print();
        batch.end();
        batch.begin();
        // String zeros = "000";
        //String zeros2 ="0000";
        //Variables.best_score_font.draw(Variables.batch, zeros.substring(0, 3 - (String.valueOf(Variables.prefs_score.getInteger("score")).length())) + String.valueOf(Variables.prefs_score.getInteger("score")), Variables.w / 36, Variables.h / 2 + (5 * Variables.h / 12) - Variables.deltaY + (Variables.h / 32));
        //Variables.best_score_font.draw(Variables.batch, zeros.substring(0, 3 - (String.valueOf(Variables.prefs_score2.getInteger("score")).length())) + String.valueOf(Variables.prefs_score2.getInteger("score")), Variables.w / 36, Variables.h / 2 + (3 * Variables.h / 12) - Variables.deltaY + (Variables.h / 32));
        //Variables.best_score_font.draw(Variables.batch, zeros.substring(0, 3 - (String.valueOf(Variables.prefs_score3.getInteger("score")).length())) + String.valueOf(Variables.prefs_score3.getInteger("score")), Variables.w / 36, Variables.h / 2 + (1 * Variables.h / 12) - Variables.deltaY + (Variables.h / 32));
        //Variables.best_score_font.draw(Variables.batch, zeros.substring(0, 3 - (String.valueOf(Variables.prefs_score4.getInteger("score")).length())) + String.valueOf(Variables.prefs_score4.getInteger("score")), Variables.w / 36, Variables.h / 2 - (1 * Variables.h / 12) - Variables.deltaY + (Variables.h / 32));
        //double
        //Variables.best_score_font.draw(Variables.batch, zeros2.substring(0, 3 - (String.valueOf(Variables.prefs_score5.getInteger("score")).length())) + String.valueOf(Variables.prefs_score5.getInteger("score")), Variables.w / 36, Variables.h / 2 - (3 * Variables.h / 12) - Variables.deltaY + (Variables.h / 32));
        // Variables.best_score_font.draw(Variables.batch, zeros.substring(0, 3 - (String.valueOf(Variables.prefs_score6.getInteger("score")).length())) + String.valueOf(Variables.prefs_score6.getInteger("score")), Variables.w / 36, Variables.h / 2 - (5 * Variables.h / 12) - Variables.deltaY + (Variables.h / 32));
        //extremeflip
        //Variables.best_score_font.draw(Variables.batch, zeros2.substring(0, 3 - (String.valueOf(Variables.prefs_score7.getInteger("score")).length())) + String.valueOf(Variables.prefs_score7.getInteger("score")), Variables.w / 36, Variables.h / 2 - (7 * Variables.h / 12) - Variables.deltaY + (Variables.h / 32));
        //  Variables.best_score_font.draw(Variables.batch, zeros.substring(0, 3 - (String.valueOf(Variables.prefs_score8.getInteger("score")).length())) + String.valueOf(Variables.prefs_score8.getInteger("score")), Variables.w / 36, Variables.h / 2 - (9 * Variables.h / 12) - Variables.deltaY + (Variables.h / 32));
        //drawSprite("modetitle", (sprites.get("modetitle").getBoundingRectangle().getWidth()) / 2, Variables.h - (Variables.h / 14));
        Variables.modetitle.setCenter(Variables.modetitle.getWidth() / 2, Variables.h - (Variables.h / 14));
        Variables.modetitle.draw(batch);
        //drawSprite("home_button", Variables.w / 11, (Variables.h * 30) / 32);
        Variables.homesprite.setCenter(Variables.w / 11, (Variables.h * 30) / 32);
        Variables.homesprite.draw(batch);
        batch.end();*/

    }
}
