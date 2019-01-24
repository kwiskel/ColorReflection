package com.flyingbrowniegames.ballgame;

/**
 * Created by kwisk_000 on 2016-04-24.
 */
public interface AdsController {
    boolean isWifiConnected();
    void showBannerAd();
    void hideBannerAd();
    void showInterstitialAd(Runnable then);
    void rateapp();
    void logEvent(String name);
    void screenView(String n);
    void showVideoAd(Runnable then);
    boolean getRewarded();
    void setRewarded(boolean b);
    void isLoaded(Runnable then);
}
