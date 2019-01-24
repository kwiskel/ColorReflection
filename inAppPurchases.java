package com.flyingbrowniegames.ballgame;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by kyle on 2017-12-02.
 */

public interface inAppPurchases {
    //void onBillingClientSetupFinished();
    //void onConsumerFinished(String token, @BillingResponse int result);
    //void onPurchasesUpdated(List<Purchase> purchases);
    //void onServiceConnected(@BillingResponse int resultCode);
    void purchaseBrownies(String sku);
}
