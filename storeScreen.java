package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

import static com.flyingbrowniegames.ballgame.BallGame.isLoaded;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.brownie1;
import static com.flyingbrowniegames.ballgame.Variables.brownie10;
import static com.flyingbrowniegames.ballgame.Variables.brownie100;
import static com.flyingbrowniegames.ballgame.Variables.brownie25;
import static com.flyingbrowniegames.ballgame.Variables.brownie500;
import static com.flyingbrowniegames.ballgame.Variables.exitButton;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.mostPopular;
import static com.flyingbrowniegames.ballgame.Variables.sale1;
import static com.flyingbrowniegames.ballgame.Variables.sale10;
import static com.flyingbrowniegames.ballgame.Variables.sale100;
import static com.flyingbrowniegames.ballgame.Variables.sale25;
import static com.flyingbrowniegames.ballgame.Variables.sale500;
import static com.flyingbrowniegames.ballgame.Variables.saleBanner1;
import static com.flyingbrowniegames.ballgame.Variables.saleBanner2;
import static com.flyingbrowniegames.ballgame.Variables.saleBanner3;
import static com.flyingbrowniegames.ballgame.Variables.saleBanner4;
import static com.flyingbrowniegames.ballgame.Variables.saleBanner5;
import static com.flyingbrowniegames.ballgame.Variables.screenOverlay;
import static com.flyingbrowniegames.ballgame.Variables.storeButton1;
import static com.flyingbrowniegames.ballgame.Variables.storeButton2;
import static com.flyingbrowniegames.ballgame.Variables.storeButton3;
import static com.flyingbrowniegames.ballgame.Variables.storeButton4;
import static com.flyingbrowniegames.ballgame.Variables.storeButton5;
import static com.flyingbrowniegames.ballgame.Variables.storePage;
import static com.flyingbrowniegames.ballgame.Variables.storeTitle;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kyle on 2017-07-22.
 */

public class storeScreen {

    public static void displayStore() {
        batch.begin();
        screenOverlay.setCenter(w / 2, h / 2);
        screenOverlay.draw(batch);
        storePage.setCenter(w / 2, h / 2);
        storePage.draw(batch);
        storeTitle.setCenter(w / 2, (h * 57) / 64);
        storeTitle.draw(batch);
        saleBanner1.setCenter(w / 2, (h * 49) / 64);
        saleBanner1.draw(batch);
        saleBanner2.setCenter(w / 2, (h * 40) / 64);
        saleBanner2.draw(batch);
        saleBanner3.setCenter(w / 2, (h * 31) / 64);
        saleBanner3.draw(batch);
        saleBanner4.setCenter(w / 2, (h * 22) / 64);
        saleBanner4.draw(batch);
        storeButton1.setCenter((w * 25) / 32, (h * 49) / 64);
        storeButton1.draw(batch);
        storeButton2.setCenter((w * 25) / 32, (h * 40) / 64);
        storeButton2.draw(batch);
        storeButton3.setCenter((w * 25) / 32, (h * 31) / 64);
        storeButton3.draw(batch);
        storeButton4.setCenter((w * 25) / 32, (h * 22) / 64);
        storeButton4.draw(batch);
        mostPopular.setCenter(w / 2, (h * 35) / 64);
        mostPopular.draw(batch);
        brownie10.setCenter((w * 11) / 56, (h * 49) / 64);
        brownie10.draw(batch);
        brownie25.setCenter((w * 6) / 28, (h * 40) / 64);
        brownie25.draw(batch);
        brownie100.setCenter((w * 6) / 28, (h * 31) / 64);
        brownie100.draw(batch);
        brownie500.setCenter((w * 6) / 28, (h * 22) / 64);
        brownie500.draw(batch);
        sale10.setCenter((w * 13) / 32, (h * 49) / 64);
        sale10.draw(batch);
        sale25.setCenter((w * 13) / 32, (h * 40) / 64);
        sale25.draw(batch);
        sale100.setCenter((w * 13) / 32, (h * 31) / 64);
        sale100.draw(batch);
        sale500.setCenter((w * 13) / 32, (h * 22) / 64);
        sale500.draw(batch);
        exitButton.setCenter((w * 3) / 28, (h * 57) / 64);
        exitButton.draw(batch);
        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            isLoaded();
            if (BallGame.adsController.isWifiConnected() && BallGame.loaded) {
                saleBanner5.setCenter(w / 2, (h * 13) / 64);
                saleBanner5.draw(batch);
                brownie1.setCenter((w * 11) / 56, (h * 13) / 64);
                brownie1.draw(batch);
                sale1.setCenter((w * 13) / 32, (h * 13) / 64);
                sale1.draw(batch);
                storeButton5.setCenter((w * 25) / 32, (h * 13) / 64);
                storeButton5.draw(batch);
            }
        }
        batch.end();
        if (BallGame.adsController.getRewarded()) {
            achievementActions.addBrownies(20);
            BallGame.adsController.setRewarded(false);
        }
    }
}
