package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.gamesdigit1;
import static com.flyingbrowniegames.ballgame.Variables.gamesdigit2;
import static com.flyingbrowniegames.ballgame.Variables.gamesdigit3;
import static com.flyingbrowniegames.ballgame.Variables.gamesdigit4;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.highscore;
import static com.flyingbrowniegames.ballgame.Variables.mainscoreloop;
import static com.flyingbrowniegames.ballgame.Variables.scoredigit1;
import static com.flyingbrowniegames.ballgame.Variables.scoredigit2;
import static com.flyingbrowniegames.ballgame.Variables.scoredigit3;
import static com.flyingbrowniegames.ballgame.Variables.sprite5;
import static com.flyingbrowniegames.ballgame.Variables.sprite9;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kyle on 2017-02-26.
 */

public class MainScorePrint {

    public static void setdigitScore(String score) {
        ArrayList<String> scoredigits = new ArrayList<String>();
        for (int i = 0; i < score.length(); i++) {
            scoredigits.add(score.substring(i, i + 1));
        }
        switch (score.length()) {
            case 1:
                scoredigit1 = sprites.get(Numbers.print(scoredigits.get(0)));
                scoredigit1.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //scoredigit1.scale((((1) * (w)) / ((25) * (scoredigit1.getWidth()))) - 1);
                break;
            case 2:
                scoredigit1 = sprites.get(((Numbers.print(scoredigits.get(0)))));
                scoredigit1.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //scoredigit1.scale((((1) * (w)) / ((25) * (scoredigit1.getWidth()))) - 1);
                scoredigit2 = sprites.get(((Numbers.print(scoredigits.get(1)))));
                scoredigit2.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //scoredigit2.scale((((1) * (w)) / ((25) * (scoredigit2.getWidth()))) - 1);
                break;
            case 3:
                scoredigit1 = sprites.get(((Numbers.print(scoredigits.get(0)))));
                scoredigit1.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //scoredigit1.scale((((1) * (w)) / ((25) * (scoredigit1.getWidth()))) - 1);
                scoredigit2 = sprites.get(((Numbers.print(scoredigits.get(1)))));
                scoredigit2.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //scoredigit2.scale((((1) * (w)) / ((25) * (scoredigit2.getWidth()))) - 1);
                scoredigit3 = sprites.get(((Numbers.print(scoredigits.get(2)))));
                scoredigit3.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //scoredigit3.scale((((1) * (w)) / ((25) * (scoredigit3.getWidth()))) - 1);
                break;

        }
        mainscoreloop = 1;
    }

    public static void setdigitGamesPlayed(String games) {
        ArrayList<String> gamesdigits = new ArrayList<String>();
        for (int i = 0; i < games.length(); i++) {
            gamesdigits.add(games.substring(i, i + 1));
        }
        switch (games.length()) {
            case 1:
                gamesdigit1 = sprites.get(((Numbers.print(gamesdigits.get(0)))));
                gamesdigit1.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //gamesdigit1.scale((((w)) / ((25) * (gamesdigit1.getWidth()) - 1)));
                break;
            case 2:
                gamesdigit1 = sprites.get(((Numbers.print(gamesdigits.get(0)))));
                gamesdigit1.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //gamesdigit1.scale((((w)) / ((25) * (gamesdigit1.getWidth()))) - 1);
                gamesdigit2 = sprites.get(((Numbers.print(gamesdigits.get(1)))));
                gamesdigit2.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //gamesdigit2.scale((((w)) / ((25) * (gamesdigit2.getWidth()))) - 1);
                break;
            case 3:
                gamesdigit1 = sprites.get(((Numbers.print(gamesdigits.get(0)))));
                gamesdigit1.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //gamesdigit1.scale((((w)) / ((25) * (gamesdigit1.getWidth()))) - 1);
                gamesdigit2 = sprites.get(((Numbers.print(gamesdigits.get(1)))));
                gamesdigit2.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //gamesdigit2.scale((((w)) / ((25) * (gamesdigit2.getWidth()))) - 1);
                gamesdigit3 = sprites.get(((Numbers.print(gamesdigits.get(2)))));
                gamesdigit3.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //gamesdigit3.scale((((w)) / ((25) * (gamesdigit3.getWidth()))) - 1);
                break;
            case 4:
                gamesdigit1 = sprites.get(((Numbers.print(gamesdigits.get(0)))));
                gamesdigit1.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //gamesdigit1.scale((((1) * (w)) / ((25) * (gamesdigit1.getWidth()))) - 1);
                gamesdigit2 = sprites.get(((Numbers.print(gamesdigits.get(1)))));
                gamesdigit2.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //gamesdigit2.scale((((1) * (w)) / ((25) * (gamesdigit2.getWidth()))) - 1);
                gamesdigit3 = sprites.get(((Numbers.print(gamesdigits.get(2)))));
                gamesdigit3.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //gamesdigit3.scale((((1) * (w)) / ((25) * (gamesdigit3.getWidth()))) - 1);
                gamesdigit4 = sprites.get(((Numbers.print(gamesdigits.get(3)))));
                gamesdigit4.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
                //gamesdigit4.scale((((1) * (w)) / ((25) * (gamesdigit4.getWidth()))) - 1);
                break;
            case 5:
                gamesdigit1 = sprites.get(((Numbers.print("9"))));
                gamesdigit1.setSize(w / 25, sprite5.getHeight());
               // gamesdigit1.scale((((1) * (w)) / ((25) * (gamesdigit1.getWidth()))) - 1);
                gamesdigit2 = sprites.get(((Numbers.print("9"))));
                gamesdigit2.setSize(w / 25, sprite5.getHeight());
                //gamesdigit2.scale((((1) * (w)) / ((25) * (gamesdigit2.getWidth()))) - 1);
                gamesdigit3 = sprites.get(((Numbers.print("9"))));
                gamesdigit3.setSize(w / 25, sprite5.getHeight());
                //gamesdigit3.scale((((1) * (w)) / ((25) * (gamesdigit3.getWidth()))) - 1);
                gamesdigit4 = sprites.get(((Numbers.print("9"))));
                gamesdigit4.setSize(w / 25, sprite5.getHeight());
                //gamesdigit4.scale((((1) * (w)) / ((25) * (gamesdigit4.getWidth()))) - 1);
                break;
        }
    }


    public static void printScore(String score) {
        float hightextHeight = sprites.get("hightext").getBoundingRectangle().getHeight();
        switch (score.length()) {
            case 1:
                batch.begin();
                scoredigit1.setCenter(w / 2 + (w / 8) + (w / 25), (h / 5) + (hightextHeight));
                scoredigit1.draw(batch);
                batch.end();
                break;
            case 2:
                batch.begin();
                scoredigit1.setCenter(w / 2 + (w / 8) + (w / 25), (h / 5) + (hightextHeight));
                scoredigit1.draw(batch);
                scoredigit2.setCenter(w / 2 + (w / 8) + (2 * (w / 25)), (h / 5) + ((hightextHeight)));
                scoredigit2.draw(batch);
                batch.end();
                break;
            case 3:
                batch.begin();
                scoredigit1.setCenter(w / 2 + (w / 8) + (w / 25), (h / 5) + ((hightextHeight)));
                scoredigit1.draw(batch);
                scoredigit2.setCenter(w / 2 + (w / 8) + (2 * (w / 25)), (h / 5) + ((hightextHeight)));
                scoredigit2.draw(batch);
                scoredigit3.setCenter(w / 2 + (w / 8) + (3 * (w / 25)), (h / 5) + ((hightextHeight)));
                scoredigit3.draw(batch);
                batch.end();
                break;
        }


    }

    public static void printGamesPlayed(String games) {
        float playedHeight = sprites.get("played").getBoundingRectangle().getHeight();

        switch (games.length()) {
            case 1:
                batch.begin();
                gamesdigit1.setCenter(w / 2 + (w / 8) + (w / 25), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit1.draw(batch);
                batch.end();
                break;
            case 2:
                batch.begin();
                gamesdigit1.setCenter(w / 2 + (w / 8) + (w / 25), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit1.draw(batch);
                gamesdigit2.setCenter(w / 2 + (w / 8) + (2 * (w / 25)), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit2.draw(batch);
                batch.end();
                break;
            case 3:
                batch.begin();
                gamesdigit1.setCenter(w / 2 + (w / 8) + (w / 25), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit1.draw(batch);
                gamesdigit2.setCenter(w / 2 + (w / 8) + (2 * (w / 25)), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit2.draw(batch);
                gamesdigit3.setCenter(w / 2 + (w / 8) + (3 * (w / 25)), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit3.draw(batch);
                batch.end();
                break;
            case 4:
                batch.begin();
                gamesdigit1.setCenter(w / 2 + (w / 8) + (w / 25), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit1.draw(batch);
                gamesdigit2.setCenter(w / 2 + (w / 8) + (2 * (w / 25)), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit2.draw(batch);
                gamesdigit3.setCenter(w / 2 + (w / 8) + (3 * (w / 25)), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit3.draw(batch);
                gamesdigit4.setCenter(w / 2 + (w / 8) + (4 * (w / 25)), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit4.draw(batch);
                batch.end();
                break;
            case 5:
                batch.begin();
                gamesdigit1.setCenter(w / 2 + (w / 8) + (w / 25), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit1.draw(batch);
                gamesdigit2.setCenter(w / 2 + (w / 8) + (2 * (w / 25)), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit2.draw(batch);
                gamesdigit3.setCenter(w / 2 + (w / 8) + (3 * (w / 25)), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit3.draw(batch);
                gamesdigit4.setCenter(w / 2 + (w / 8) + (4 * (w / 25)), (h / 5) - ((3 * (playedHeight)) / 4));
                gamesdigit4.draw(batch);
                batch.end();
                break;
        }

    }
}
