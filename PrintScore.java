package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.duoscore1;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.dnumber1;
import static com.flyingbrowniegames.ballgame.Variables.playerscoreloop;
import static com.flyingbrowniegames.ballgame.Variables.scoredigit1;
import static com.flyingbrowniegames.ballgame.Variables.scoredigit2;
import static com.flyingbrowniegames.ballgame.Variables.scoredigit3;
import static com.flyingbrowniegames.ballgame.Variables.scoredigit4;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kyle on 2017-02-25.
 */

public class PrintScore {


    public static void setDigitScore(String score) {
        ArrayList<String> playerscore = new ArrayList<String>();
        for (int i = 0; i < score.length(); i++) {
            playerscore.add(score.substring(i, i + 1));
        }

        switch (playerscore.size()) {
            case 1:
                scoredigit1 = sprites.get(((Numbers.print(playerscore.get(0)))));
                scoredigit1.setSize(w / 13, h / 20);
                break;
            case 2:
                scoredigit1 = sprites.get(((Numbers.print(playerscore.get(0)))));
                scoredigit1.setSize(w / 13, h / 20);
                scoredigit2 = sprites.get(((Numbers.print(playerscore.get(1)))));
                scoredigit2.setSize(w / 13, h / 20);
                break;
            case 3:
                scoredigit1 = sprites.get(((Numbers.print(playerscore.get(0)))));
                scoredigit1.setSize(w / 13, h / 20);
                scoredigit2 = sprites.get(((Numbers.print(playerscore.get(1)))));
                scoredigit2.setSize(w / 13, h / 20);
                scoredigit3 = sprites.get(((Numbers.print(playerscore.get(2)))));
                scoredigit3.setSize(w / 13, h / 20);
                break;
            case 4:
                scoredigit1 = sprites.get(((Numbers.print(playerscore.get(0)))));
                scoredigit1.setSize(w / 13, h / 20);
                scoredigit2 = sprites.get(((Numbers.print(playerscore.get(1)))));
                scoredigit2.setSize(w / 13, h / 20);
                scoredigit3 = sprites.get(((Numbers.print(playerscore.get(2)))));
                scoredigit3.setSize(w / 13, h / 20);
                scoredigit4 = sprites.get(((Numbers.print(playerscore.get(3)))));
                scoredigit4.setSize(w / 13, h / 20);
                break;
        }
        playerscoreloop = 1;
    }

    public static void printScore(String score) {
        switch (score.length()) {
            case 1:
                batch.begin();
                scoredigit1.setCenter(w / 2, (h * 9) / 10);
                scoredigit1.draw(batch);
                batch.end();
                break;
            case 2:
                batch.begin();
                scoredigit1.setCenter(w / 2 - (w / 26), (h * 9) / 10);
                scoredigit1.draw(batch);
                scoredigit2.setCenter(w / 2 + (w / 26), (h * 9) / 10);
                scoredigit2.draw(batch);
                batch.end();
                break;
            case 3:
                batch.begin();
                scoredigit1.setCenter(w / 2 - (w / 13), (h * 9) / 10);
                scoredigit1.draw(batch);
                scoredigit2.setCenter(w / 2, (h * 9) / 10);
                scoredigit2.draw(batch);
                scoredigit3.setCenter(w / 2 + (w / 13), (h * 9) / 10);
                scoredigit3.draw(batch);
                batch.end();
                break;
            case 4:
                batch.begin();
                scoredigit1.setCenter(w / 2 - ((3 * (w / 13)) / 2), (h * 9) / 10);
                scoredigit1.draw(batch);
                scoredigit2.setCenter(w / 2 - (w / 26), (h * 9) / 10);
                scoredigit2.draw(batch);
                scoredigit3.setCenter(w / 2 + (w / 26), (h * 9) / 10);
                scoredigit3.draw(batch);
                scoredigit4.setCenter(w / 2 + ((3 * (w / 13)) / 2), (h * 9) / 10);
                scoredigit4.draw(batch);
                batch.end();
                break;
        }
    }
}
