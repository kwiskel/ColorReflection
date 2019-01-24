package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.allNames;
import static com.flyingbrowniegames.ballgame.Variables.ball;
import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.blindleftball;
import static com.flyingbrowniegames.ballgame.Variables.blindrightball;
import static com.flyingbrowniegames.ballgame.Variables.characterIndex;
import static com.flyingbrowniegames.ballgame.Variables.characterPricing;
import static com.flyingbrowniegames.ballgame.Variables.characterPricings;
import static com.flyingbrowniegames.ballgame.Variables.characterShopBar;
import static com.flyingbrowniegames.ballgame.Variables.characterShopNotUsing1;
import static com.flyingbrowniegames.ballgame.Variables.characterShopPage;
import static com.flyingbrowniegames.ballgame.Variables.characterShopTitle;
import static com.flyingbrowniegames.ballgame.Variables.characterShopTitleBar;
import static com.flyingbrowniegames.ballgame.Variables.characterShopUsing;
import static com.flyingbrowniegames.ballgame.Variables.charactersBought;
import static com.flyingbrowniegames.ballgame.Variables.classicDisplay;
import static com.flyingbrowniegames.ballgame.Variables.classicQuote;
import static com.flyingbrowniegames.ballgame.Variables.currentCharacter;
import static com.flyingbrowniegames.ballgame.Variables.flowerDisplay;
import static com.flyingbrowniegames.ballgame.Variables.flowerQuote;
import static com.flyingbrowniegames.ballgame.Variables.goldenBrownie;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.homesprite;
import static com.flyingbrowniegames.ballgame.Variables.leftball;
import static com.flyingbrowniegames.ballgame.Variables.pricingFont;
import static com.flyingbrowniegames.ballgame.Variables.rightball;
import static com.flyingbrowniegames.ballgame.Variables.screenOverlay;
import static com.flyingbrowniegames.ballgame.Variables.secondleftball;
import static com.flyingbrowniegames.ballgame.Variables.secondrightball;
import static com.flyingbrowniegames.ballgame.Variables.shopY;
import static com.flyingbrowniegames.ballgame.Variables.specialCount;
import static com.flyingbrowniegames.ballgame.Variables.specialSale;
import static com.flyingbrowniegames.ballgame.Variables.specialTitle;
import static com.flyingbrowniegames.ballgame.Variables.timeBar;
import static com.flyingbrowniegames.ballgame.Variables.timeFont;
import static com.flyingbrowniegames.ballgame.Variables.timeLayout;
import static com.flyingbrowniegames.ballgame.Variables.unlockedCharacters;
import static com.flyingbrowniegames.ballgame.Variables.unlockedSpecialCharacters;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kyle on 2017-11-19.
 */

public class ShopScreen {

    public static void displayShop() {
        batch.begin();
        screenOverlay.setCenter(w / 2, h / 2);
        screenOverlay.draw(batch);
        characterShopPage.setCenter(w / 2, h / 2);
        characterShopPage.draw(batch);
        //classic

        drawPricing();

        //classicDisplay.setCenter(w / 4,
        // (h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - (characterShopBar.getBoundingRectangle().getHeight() / 2));
        // classicDisplay.draw(batch);
        //classicQuote.setCenter((w / 2) - (w / 32) + (characterShopBar.getBoundingRectangle().getWidth() / 2) - classicQuote.getBoundingRectangle().getWidth() / 2,
        //(h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - (characterShopBar.getBoundingRectangle().getHeight() / 2));
        //classicQuote.draw(batch);
        if (specialSale) {
            timeBar.setCenter((w * 2) / 4,
                    (h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - (timeBar.getBoundingRectangle().getHeight() / 2));
            timeBar.draw(batch);
            specialTitle.setCenter((w * 2) / 4,
                    (h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2));
            specialTitle.draw(batch);
            timeFont.draw(batch, timeLayout, (w * 2) / 4 - (timeLayout.width / 2),
                    (h / 2) - shopY + (timeLayout.height / 2) + (characterShopPage.getBoundingRectangle().getHeight() / 2) - (timeBar.getBoundingRectangle().getHeight() / 2));
        }
        //flower
        //flowerDisplay.setCenter(w / 4,
        //(h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - ((3 * characterShopBar.getBoundingRectangle().getHeight()) / 2));
        //flowerDisplay.draw(batch);
        //flowerQuote.setCenter((w / 2) - (w / 32) + (characterShopBar.getBoundingRectangle().getWidth() / 2) - classicQuote.getBoundingRectangle().getWidth() / 2,
        //(h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - ((3 * characterShopBar.getBoundingRectangle().getHeight()) / 2));
        //flowerQuote.draw(batch);
        //

        //using current box

        characterShopTitleBar.setCenter(w / 2,
                (h / 2) + (characterShopPage.getBoundingRectangle().getHeight() / 2) - (characterShopTitleBar.getBoundingRectangle().getHeight() / 2));
        characterShopTitleBar.draw(batch);
        characterShopTitle.setCenter(w / 2,
                (h / 2) + (characterShopPage.getBoundingRectangle().getHeight() / 2) - (characterShopTitleBar.getBoundingRectangle().getHeight() / 2));
        characterShopTitle.draw(batch);
        homesprite.setCenter(w / 11, (h / 2) + (characterShopPage.getBoundingRectangle().getHeight() / 2) - (characterShopTitleBar.getBoundingRectangle().getHeight() / 2));
        homesprite.draw(batch);
        batch.end();
    }


    public static void drawPricing() {//draw pricing for characters that are not yet purchased
        for (int i = 0; i < charactersBought.length; i++) {
            characterShopBar.setCenter(w / 2,
                    (h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - ((((2 * i) + 1) * characterShopBar.getBoundingRectangle().getHeight()) / 2));
            characterShopBar.draw(batch);
            if (charactersBought[i] == 0) {
                if (specialSale) {
                    if (i == 0) {
                        characterPricing.setText(pricingFont, "400");
                    } else {
                        characterPricing.setText(pricingFont, String.valueOf(characterPricings[i - 1]));
                    }
                } else {
                    characterPricing.setText(pricingFont, String.valueOf(characterPricings[i - specialCount]));
                }
                pricingFont.draw(batch, characterPricing, w / 2 - (characterPricing.width / 2),
                        (h / 2) - shopY + (characterPricing.height / 2) + (characterShopPage.getBoundingRectangle().getHeight() / 2) - ((((2 * i) + 1) * characterShopBar.getBoundingRectangle().getHeight()) / 2));

                goldenBrownie.setCenter(w / 2 + characterPricing.width / 2 + goldenBrownie.getBoundingRectangle().getWidth(),
                        (h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - ((((2 * i) + 1) * characterShopBar.getBoundingRectangle().getHeight()) / 2));
                goldenBrownie.draw(batch);
            } else {
                characterShopNotUsing1.setCenter(w / 4,
                        (h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - ((((2 * i) + 1) * characterShopBar.getBoundingRectangle().getHeight()) / 2));
                characterShopNotUsing1.draw(batch);
                if (characterIndex.getInteger("characterIndex") == i) {
                    characterShopUsing.setCenter(w / 4,
                            (h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - (((((2 * characterIndex.getInteger("characterIndex")) + 1)) * characterShopBar.getBoundingRectangle().getHeight()) / 2));
                    characterShopUsing.draw(batch);
                }
                //display character icon
                sprites.get(allNames.get(i)).setCenter(w / 4,
                        (h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - ((((2 * i) + 1) * characterShopBar.getBoundingRectangle().getHeight()) / 2));
                sprites.get(allNames.get(i)).draw(batch);
                sprites.get(allNames.get(i) + "Title").setCenter((w * 21) / 32,
                        (h / 2) - shopY + (characterShopPage.getBoundingRectangle().getHeight() / 2) - ((((2 * i) + 1) * characterShopBar.getBoundingRectangle().getHeight()) / 2));
                sprites.get(allNames.get(i) + "Title").draw(batch);
            }
        }

    }

    public static void purchaseCharacter(int index) {
        if (index == 0 && specialSale) {//buys special characters
            if (achievementActions.spendBrownies(400)) {//check to make sure user has sufficient brownies
                charactersBought[0] = 1;
                String unlocked = unlockedSpecialCharacters.getString("unlockedSpecialCharacters");
                int[] temporary = new int[unlocked.length()];
                for (int i = 0; i < unlocked.length(); i++) {
                    temporary[i] = Integer.parseInt(unlocked.substring(i, i + 1));
                }
                temporary[temporary.length - 1] = 1;
                unlocked = "";
                for (int j = 0; j < temporary.length; j++) {
                    unlocked += String.valueOf(temporary[j]);
                }
                unlockedSpecialCharacters.clear();
                unlockedSpecialCharacters.putString("unlockedSpecialCharacters", unlocked);
                unlockedSpecialCharacters.flush();
                specialSale = false;
                changeCharacter(0);
            } else {

            }
        } else {//not buying special character
            if (achievementActions.spendBrownies(characterPricings[index - 1])) {//check to make sure user have sufficient brownies
                charactersBought[index] = 1;
                String unlocked = unlockedCharacters.getString("unlockedCharacters");
                int[] temporary = new int[unlocked.length()];
                for (int i = 0; i < unlocked.length(); i++) {
                    temporary[i] = Integer.parseInt(unlocked.substring(i, i + 1));
                }
                int specialCount = 0;
                if (specialSale) {
                    specialCount++;
                }
                for (int i = 0; i < unlockedSpecialCharacters.getString("unlockedSpecialCharacters").length(); i++) {
                    if (unlockedSpecialCharacters.getString("unlockedSpecialCharacters").substring(i, i + 1).equals("1")) {
                        specialCount++;
                    }
                }
                temporary[index - specialCount] = 1;
                unlocked = "";
                for (int j = 0; j < temporary.length; j++) {
                    unlocked += String.valueOf(temporary[j]);
                }
                unlockedCharacters.clear();
                unlockedCharacters.putString("unlockedCharacters", unlocked);
                unlockedCharacters.flush();
                changeCharacter(index);
            }
        }
    }

    public static void changeCharacter(int index) {
        ball.setRotation(0);
        currentCharacter.clear();
        currentCharacter.putString("currentCharacter", allNames.get(index));
        currentCharacter.flush();
        characterIndex.clear();
        characterIndex.putInteger("characterIndex", index);
        characterIndex.flush();
        ball = sprites.get(allNames.get(index));
        leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
        leftball.setColor(32 / 255f, 87 / 255f, 245 / 255f, 1);//blue
        rightball = new Sprite(sprites.get(((currentCharacter.getString("currentCharacter") + "Half"))));
        rightball.setColor(243 / 255f, 34 / 255f, 12 / 255f, 1);//red
        rightball.setFlip(true, false);
        blindleftball = new Sprite(sprites.get(((currentCharacter.getString("currentCharacter") + "Half"))));
        blindleftball.setColor(184, 244, 157, 1);//blindsix
        blindrightball = new Sprite(sprites.get(((currentCharacter.getString("currentCharacter") + "Half"))));
        blindrightball.setColor(215, 240, 98, 1);//blindsixteen
        blindrightball.flip(true, false);
        secondleftball = new Sprite(sprites.get(((currentCharacter.getString("currentCharacter") + "Half"))));
        secondleftball.setColor(new Color(243, 34, 12, 1));//red
        secondrightball = new Sprite(sprites.get(((currentCharacter.getString("currentCharacter") + "Half"))));
        secondrightball.setColor(new Color(32, 87, 245, 1));//blue
        secondrightball.flip(true, false);

        //System.out.println("not bought");
    }
}
