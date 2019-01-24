package com.flyingbrowniegames.ballgame;

/**
 * Created by kyle on 2017-01-08.
 */

public interface IActivityRequestHandler {
    void showInterstitial();

    void share(String t);

    void rateapp();

    void signIn();

    void loadAchievements();

    void loadLeaderboards();

    void showLeaderboardsView();

    void showAchievementsView();

    void reportScore(String indentifier, int score);

    void reportAchievement(int mode, int score, int extreme);

    void logEvent(String name);

    void screenView(String n);

    void signIN();

    boolean isSignedIn();

    void signOut();

    void initializeAnalytics();

    void showVideo();

}
