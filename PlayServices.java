package com.flyingbrowniegames.ballgame;

/**
 * Created by kwisk_000 on 2016-09-05.
 */
public interface PlayServices {
    void signIn();
    void signOut();
    void rateGame();
    void shareIntent(String t);
    void unlockAchievement(int mode, int score, int extreme);
    void submitScore(int mode, int highscore, int balls);
    void showAchievement();
    void showsScore();
    boolean isSignedIn();

}
