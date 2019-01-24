package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.signedIn;
import static com.flyingbrowniegames.ballgame.Variables.signedOut;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kwisk_000 on 2016-04-25.
 */
public class SettingsScreen extends ApplicationAdapter {
    public static void setScreen() {
        Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Variables.batch.begin();
        if (Gdx.app.getType() == Application.ApplicationType.iOS) {
            //drawSprite("sondsprite", w / 3, (h * 3) / 4);
            Variables.soundsprite.setCenter(w / 3, (h * 3) / 4);
            Variables.soundsprite.draw(Variables.batch);
            Variables.music.setCenter((w * 2) / 3, (h * 3) / 4);
            Variables.music.draw(Variables.batch);
            //drawSprite("kyle_credits", w / 2, h / 6);
            Variables.credit_sprite.setCenter(w / 2, h / 6);
            Variables.credit_sprite.draw(Variables.batch);
            //Variables.noads.setCenter(Variables.w / 2, (Variables.h * 5) / 8);
            // Variables.noads.draw(Variables.batch);
            //drawSprite("facebook", w / 3, h / 2);
            Variables.facebook.setCenter(w / 3, h / 2);
            Variables.facebook.draw(Variables.batch);
            //drawSprite("instagram", (w * 2) / 3, h / 2);
            Variables.instagram.setCenter((w * 2) / 3, h / 2);
            Variables.instagram.draw(Variables.batch);
        } else if (Gdx.app.getType() == Application.ApplicationType.Android) {
            Variables.soundsprite.setCenter(w / 4, (h * 3) / 4);
            Variables.soundsprite.draw(Variables.batch);
            Variables.music.setCenter((w * 3) / 4, (h * 3) / 4);
            Variables.music.draw(Variables.batch);
            //drawSprite("kyle_credits", w / 2, h / 6);
            Variables.credit_sprite.setCenter(w / 2, h / 6);
            Variables.credit_sprite.draw(Variables.batch);
            //Variables.noads.setCenter(Variables.w / 2, (Variables.h * 5) / 8);
            // Variables.noads.draw(Variables.batch);
            //drawSprite("facebook", w / 4, h / 2);
            Variables.facebook.setCenter(w / 4, h / 2);
            Variables.facebook.draw(Variables.batch);
            //drawSprite("instagram", (w * 3) / 4, h / 2);
            Variables.instagram.setCenter((w * 3) / 4, h / 2);
            Variables.instagram.draw(Variables.batch);
            if (BallGame.playServices.isSignedIn()) {
                //drawSprite("signedin", w / 2, ((h * 2) / 3) - (sprites.get("signedin").getBoundingRectangle().getHeight() / 3));
                signedIn.setCenter(w / 2, ((h * 2) / 3) - (signedIn.getBoundingRectangle().getHeight() / 3));
                signedIn.draw(batch);
            } else if (!BallGame.playServices.isSignedIn()) {
                //rawSprite("signedout", w / 2, ((h * 2) / 3) - (sprites.get("signedout").getBoundingRectangle().getHeight() / 3));
                signedOut.setCenter(w / 2, ((h * 2) / 3) - (signedIn.getBoundingRectangle().getHeight() / 3));
                signedOut.draw(batch);
            } else {

            }

        }
        // Variables.backsprite.setCenter(Variables.w / 34, Variables.h - 60);
        //Variables.backsprite.draw(Variables.batch);\
        //drawSprite("settingstitle", (sprites.get("settingstitle").getBoundingRectangle().getWidth()) / 2, h - (h / 14));
        Variables.settingstitle.setCenter(Variables.settingstitle.getWidth() / 2, h - (h / 14));
        Variables.settingstitle.draw(Variables.batch);
        //drawSprite("home_button", w / 11, (h * 30) / 32);
        Variables.homesprite.setCenter(w / 11, (h * 30) / 32);
        Variables.homesprite.draw(Variables.batch);

        Variables.batch.end();
    }
}
