package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.greencurve;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.purplecurve;
import static com.flyingbrowniegames.ballgame.Variables.redcurve;
import static com.flyingbrowniegames.ballgame.Variables.start;
import static com.flyingbrowniegames.ballgame.Variables.statsHeight;
import static com.flyingbrowniegames.ballgame.Variables.statsWidth;
import static com.flyingbrowniegames.ballgame.Variables.statstitle;
import static com.flyingbrowniegames.ballgame.Variables.w;
import static com.flyingbrowniegames.ballgame.Variables.yellowcurve;

/**
 * Created by kwisk_000 on 2016-07-03.
 */
public class statscreen {
    public static Sprite leader = sprites.get((("leader2")));

    private static boolean loop = true;
    public static Sprite achievements = sprites.get((("achievements2")));

    public static void setScreen() {
        if (loop == true) {
            leader.scale((((1) * (w)) / ((5) * (leader.getWidth()))) - 1);
            loop = false;
            achievements.scale((((1) * (w)) / ((5) * (achievements.getWidth()))) - 1);
        }
        Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Variables.batch.begin();
        //Variables.statspage.setCenter(Variables.w / 2, (Variables.h * 4) / 6);
        //Variables.statspage.draw(Variables.batch);
        //drawSprite("playerstats", w / 2, (h * 11) / 12);
        statstitle.setCenter(w / 2, (h * 11) / 12);
        statstitle.draw(batch);
        //drawSprite("greencurve", w / 2, (h * 45) / 56);
        greencurve.setCenter(w / 2, (h * 45) / 56);
        greencurve.draw(batch);
        //drawSprite("redcurve", w / 2, (h * 75) / 112);
        redcurve.setCenter(w / 2, (h * 75) / 112);
        redcurve.draw(batch);
        //drawSprite("purplecurve", w / 2, (h * 60) / 112);
        purplecurve.setCenter(w / 2, (h * 60) / 112);
        purplecurve.draw(batch);
        //drawSprite("yellowcurve", w / 2, (h * 91) / 224);
        yellowcurve.setCenter(w / 2, (h * 91) / 224);
        yellowcurve.draw(batch);
        //drawSprite("home_button", w / 11, (h * 30) / 32);
        Variables.homesprite.setCenter(w / 11, (h * 30) / 32);
        Variables.homesprite.draw(Variables.batch);
        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            achievements.setCenter(w * 2 / 3, h * 2 / 10);
            achievements.draw(Variables.batch);
        }
        leader.setCenter(w / 3, h * 2 / 10);
        leader.draw(Variables.batch);
        //}
        Variables.batch.end();
        Variables.batch.begin();
        Variables.stats_font.setColor(Color.BLUE);
        Variables.stats_font.draw(Variables.batch, String.valueOf(Variables.prefs_games.getInteger("games")), (statsWidth * 4) / 6, h - ((statsHeight * 7) / 24));
        long mins = Variables.prefs_time.getLong("time") / 60;
        if (mins >= 60) {
            int hours = 0;
            while (mins >= 60) {
                mins -= 60;
                hours += 1;
            }
            if (hours > 999) {
                hours = 999;
                mins = 59;
            }
            Variables.stats_font.draw(Variables.batch, String.valueOf(hours + "H " + mins + "M"), (statsWidth * 3) / 6, h - ((statsHeight * 12) / 24));
        } else {
            Variables.stats_font.draw(Variables.batch, String.valueOf(Variables.prefs_time.getLong("time") / 60 + " M"), (statsWidth * 4) / 6, h - ((statsHeight * 12) / 24));

        }
        Variables.stats_font.draw(Variables.batch, String.valueOf(Variables.prefs_wallhit.getInteger("wallhit")), (statsWidth * 4) / 6, h - ((statsHeight * 17) / 24));
        Variables.stats_font.draw(Variables.batch, String.valueOf(Variables.prefs_score.getInteger("score")), (statsHeight * 4) / 6, h - ((statsHeight * 22) / 24));
        Variables.batch.end();
    }
}
