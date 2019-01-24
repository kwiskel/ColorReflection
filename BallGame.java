package com.flyingbrowniegames.ballgame;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.flyingbrowniegames.ballgame.Variables.*;


public class BallGame extends ApplicationAdapter {
    public static TextureAtlas textureAtlas;
    public static AdsController adsController;
    public static PlayServices playServices;
    public static IActivityRequestHandler iActivityRequestHandler;
    public static boolean play;
    public static long startTime;
    public static boolean loaded;
    public static long elapsedTime;
    public static long playerTime;
    public static int games_before;
    public static int games_elapsed;
    public static long five_mins_time;
    public static int fives;
    public static long gametime;
    public static int timerloop;
    public static MyInputProcessor inputProcessor = new MyInputProcessor();
    public static InputMultiplexer inputMultiplexer = new InputMultiplexer();
    public static HashMap<String, Sprite> sprites = new HashMap<String, Sprite>();
    public static long openedTime;
    public static Animation loadingCircle;
    AssetManager manager = new AssetManager();
    public static float stateTime;


    public BallGame(AdsController adsController, PlayServices playServices) {
        BallGame.adsController = adsController;
        BallGame.playServices = playServices;
    }

    public BallGame(IActivityRequestHandler iActivityRequestHandler) {
        BallGame.iActivityRequestHandler = iActivityRequestHandler;
    }


    @Override
    public void create() {
        firstVariables();
        openedTime = System.currentTimeMillis();
        inputMultiplexer.addProcessor(Variables.g);
        inputMultiplexer.addProcessor(inputProcessor);
        Gdx.input.setInputProcessor(inputMultiplexer);
        play = true;
        playerTime = Variables.prefs_time.getLong("time");
        timerloop = 0;
        gametime = 0;
        fives = 1;
        loaded = false;
        textureAtlas = new TextureAtlas(Gdx.files.internal("loadingSprites.txt"));
        Array<TextureAtlas.AtlasRegion> regions = textureAtlas.getRegions();
        loadingCircle = new Animation(0.033f, regions, Animation.PlayMode.LOOP);
        manager.load("texturesSheet-hd.txt", TextureAtlas.class);
        manager.load("modeScreenTextures.txt", TextureAtlas.class);
        manager.load("circularProgressTextures.txt", TextureAtlas.class);
        stateTime = 0f;
        //if (Gdx.app.getType() == Application.ApplicationType.iOS) {
            //iActivityRequestHandler.signIN();
            //iActivityRequestHandler.initializeAnalytics();
        //}


    }

    private void addSprites() {
        Array<TextureAtlas.AtlasRegion> regions = textureAtlas.getRegions();
        for (TextureAtlas.AtlasRegion region : regions) {
            Sprite sprite = textureAtlas.createSprite(region.name);
            sprites.put(region.name, sprite);
        }
    }

    public static void drawSprite(String name, float x, float y) {
        Sprite sprite = sprites.get(name);
        sprite.setPosition(x, y);
        //sprite.draw(batch);
    }

    public static void rotateSprite(String name, float degrees) {
        sprites.get(name).setRotation(degrees);
    }

    public static void flipSprite(String name, boolean X, boolean Y) {
        sprites.get(name).flip(X, Y);
    }

    @Override
    public void dispose() {
        manager.dispose();
        Variables.batch.dispose();
        Variables.score_font.dispose();
        Variables.stats_font.dispose();
        Variables.highscore_font.dispose();
        Variables.progressFont.dispose();
        Variables.bounce.dispose();
        Variables.death.dispose();
        textureAtlas.dispose();
        Variables.musicsound.dispose();
        achievementFont.dispose();
        percentageFont.dispose();
        manager.dispose();

    }

    @Override
    public void render() {
        if (screen == 0) {
            Gdx.gl.glClearColor(0 / 255f, 0 / 255f, 0 / 255f, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            stateTime += Gdx.graphics.getDeltaTime();
            batch.begin();
            companyLogo.setCenter(logoX, (Gdx.graphics.getHeight() * 2) / 3);
            companyLogo.draw(batch);
            batch.end();
            batch.begin();
            TextureRegion currentFrame = loadingCircle.getKeyFrame(stateTime, true);
            Sprite frame = new Sprite(currentFrame);
            frame.scale((Gdx.graphics.getWidth() / (3 * frame.getWidth())) - 1);
            frame.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 5);
            frame.draw(batch);
            // batch.draw(currentFrame, (Gdx.graphics.getWidth() / 2) - currentFrame.getRegionWidth() / 2, Gdx.graphics.getHeight() / 5);
            batch.end();
            if (logoX < Gdx.graphics.getWidth() / 2) {
                if (logoX + 10 > (Gdx.graphics.getWidth() / 2)) {
                    logoX = Gdx.graphics.getWidth() / 2;
                } else {
                    logoX += 10;
                }
            }


            //System.out.println(manager.update());
            if (manager.update()) {
                textureAtlas = manager.get("texturesSheet-hd.txt");
                addSprites();
                //manager.load("modeScreenTextures.txt", TextureAtlas.class);
                textureAtlas = manager.get("modeScreenTextures.txt");
                addSprites();
                textureAtlas = manager.get("circularProgressTextures.txt");
                addSprites();
                Variables.createVariables();
                screen = 1;
            }

        } else {
            // System.out.println(classicCompleted.getInteger("classicCompleted"));
            //System.out.println(classicTypes[classicCurrent.getInteger("classicCurrent")]);
            // System.out.println();
            //System.out.println(iOSUploadScore.getInteger("uploaded") + " uploaded");
            //System.out.println("speed " + speed);

            if (iOSUploadScore.getInteger("uploaded") != 1 && Gdx.app.getType() == Application.ApplicationType.iOS) {
                iActivityRequestHandler.reportScore("01", prefs_score.getInteger("My Preferences"));
                iActivityRequestHandler.reportScore("02", prefs_score2.getInteger("Preferences2"));
                iActivityRequestHandler.reportScore("03", prefs_score3.getInteger("references"));
                iActivityRequestHandler.reportScore("04", prefs_score4.getInteger("y Preferences"));
                iActivityRequestHandler.reportScore("05", prefs_score5.getInteger("eferences"));
                iActivityRequestHandler.reportScore("06", prefs_score63.getInteger("ferences"));
                iActivityRequestHandler.reportScore("07", prefs_score64.getInteger("fferences"));
                iActivityRequestHandler.reportScore("08", prefs_score65.getInteger("ffferences"));
                iActivityRequestHandler.reportScore("09", prefs_score66.getInteger("fffferences"));
                iActivityRequestHandler.reportScore("10", prefs_score7.getInteger("erences"));
                iOSUploadScore.clear();
                iOSUploadScore.putInteger("uploaded", 1);
                iOSUploadScore.flush();
            }
            // System.out.println("pause: " + extremepause.getBoolean("pause"));
            if (Gdx.app.getType() == Application.ApplicationType.Android) {
                if (Variables.screen == 1 && !openAchievement && !openStore && !openShop) {
                    Gdx.input.setCatchBackKey(false);
                } else {
                    Gdx.input.setCatchBackKey(true);
                }
            }
            // System.out.println("Increas" + Variables.speed_increase);
            //System.out.println("speed " + Variables.speed);

            if (MyGestureListener.oops == 1) {
                if (classicTypes[classicCurrent.getInteger("classicCurrent")].equalsIgnoreCase("rate")) {
                    //System.out.println("rate");
                    achievementActions.completeAchievement(1, classicCurrent.getInteger("classicCurrent"));
                }
                if (Gdx.app.getType() == Application.ApplicationType.Android) {
                    adsController.rateapp();
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                    Gdx.net.openURI("https://itunes.apple.com/ca/app/colorreflection/id1204997081");
                }
                MyGestureListener.oops = 0;
            }
            if (Variables.prefs_music.getInteger("music") != 2) {
                Variables.musicsound.play();
                Variables.musicsound.setVolume(0.5f);
            } else {
                Variables.musicsound.stop();
            }
            // System.out.println("music" + Variables.prefs_music.getInteger("music"));
            five_mins_time = ((System.currentTimeMillis() - start) / 60000);
            if (adgames == 6 && five_mins_time < 5) {
                if (Gdx.app.getType() == Application.ApplicationType.Android) {
                    display_ad();
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                    iActivityRequestHandler.showInterstitial();
                }
                games_elapsed = 0;
                games_before = 0;
                start = System.currentTimeMillis();
                fives++;
            } else if (adgames < 6 && five_mins_time >= 5 && (Variables.screen == 3 || Variables.screen == 1)) {
                if (Gdx.app.getType() == Application.ApplicationType.Android) {
                    display_ad();
                } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                    iActivityRequestHandler.showInterstitial();
                }
                games_elapsed = 0;
                games_before = 0;
                start = System.currentTimeMillis();
                fives++;
            } else {

            }
            SwitchScreens.switchScreens();
            if (showBanner) {
                achievementActions.bannerDisplay();
            }
            if (!updatePopup.getBoolean("updatePopup")) {
                showUpdate = true;
                Update.updatePopUp();
                updatePopup.clear();
                updatePopup.putBoolean("updatePopup", true);

            }
            //System.out.println("brownies" + userBrownies.getInteger("brownies"));
            // System.out.println(rightball.isFlipX() + " rightball");
            // System.out.println(leftball.isFlipX() + " leftball");
            //System.out.println(classicOverallProgress.getString("classicOverall"));
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    public void display_ad() {
        if (adsController.isWifiConnected()) {
            //System.out.print("called");
            //adsController.showBannerAd();
            adsController.showInterstitialAd(new Runnable() {
                @Override
                public void run() {
                    //System.out.println("Interstital app closed");
                    ///Gdx.app.exit();
                }
            });
        } else {
            //System.out.println("Interstital ad not loaded");

        }
    }

    public static void displayVideoAd() {
        adsController.showVideoAd(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public static void displayIosVideo() {
        iActivityRequestHandler.showVideo();
    }

    public static void isLoaded() {
        adsController.isLoaded(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


}

