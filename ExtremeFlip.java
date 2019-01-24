package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import static com.flyingbrowniegames.ballgame.BallGame.drawSprite;
import static com.flyingbrowniegames.ballgame.Variables.achievementBoard;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.duopausehome;
import static com.flyingbrowniegames.ballgame.Variables.duopausehowto;
import static com.flyingbrowniegames.ballgame.Variables.duopauseresume;
import static com.flyingbrowniegames.ballgame.Variables.extremeflipname;
import static com.flyingbrowniegames.ballgame.Variables.fastforwardButton;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.pause;
import static com.flyingbrowniegames.ballgame.Variables.pausetime;
import static com.flyingbrowniegames.ballgame.Variables.randomizeButton;
import static com.flyingbrowniegames.ballgame.Variables.shouldtime;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kwisk_000 on 2016-05-08.
 */
public class ExtremeFlip {
    public static void set_screen() {
        Variables.mode = 7;
        Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        extremeflipname.setCenter(Variables.w / 2, (Variables.h / 2));
        extremeflipname.draw(batch);
        //drawSprite("extremeflip_name", Variables.w / 2, (Variables.h / 2));
        batch.end();
        batch.begin();
        //drawSprite("play", Variables.w / 2, (Variables.h * 5) / 12);
        Variables.sprite4.setCenter(Variables.w / 2, (Variables.h * 5) / 12);
        Variables.sprite4.draw(Variables.batch);
        batch.end();
        Extreme.set_screen(2);
//        batch.begin();
//        achievementBoard.setCenter(w / 2, ((h * 24) / 48));
//        achievementBoard.draw(batch);
//        randomizeButton.setCenter(w / 3, (h * 10) / 24);
//        randomizeButton.draw(batch);
//        fastforwardButton.setCenter((w * 2) / 3, (h * 10) / 24);
//        fastforwardButton.draw(batch);
//        batch.end();

    }

    public static void play_screen() {
        Variables.speed_increase = 2;
        BallGame.games_before = BallGame.games_elapsed;
        if (Variables.paused == true) { // pause the game
            shouldtime = false;
            Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            duopausehowto.setCenter((w * 3) / 4, h / 2);
            duopausehowto.draw(batch);
            duopausehome.setCenter(w / 4, h / 2);
            duopausehome.draw(batch);
            duopauseresume.setCenter(w / 2, h / 2);
            duopauseresume.draw(batch);
            //drawSprite("duopausehowto", (w * 3) / 4, h / 2);
            //drawSprite("duopausehome", w / 4, h / 2);
            //drawSprite("duopauseresume", w / 2, h / 2);
            batch.end();

        } else if (Variables.paused == false) {// resume the game
            Extreme.play_screen();
            batch.begin();
            if (System.currentTimeMillis() - pausetime < 3000) {

            } else {
                //drawSprite("pause", w / 10, (h * 9) / 10);
                pause.setCenter(w / 10, (h * 9) / 10);
                pause.draw(batch);
            }
            batch.end();
        }
    }
}
