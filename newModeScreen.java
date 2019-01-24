package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.blackStar1;
import static com.flyingbrowniegames.ballgame.Variables.blackStar2;
import static com.flyingbrowniegames.ballgame.Variables.blackStar3;
import static com.flyingbrowniegames.ballgame.Variables.blackStar4;
import static com.flyingbrowniegames.ballgame.Variables.blackStar5;
import static com.flyingbrowniegames.ballgame.Variables.blackStar6;
import static com.flyingbrowniegames.ballgame.Variables.blindCompleted;
import static com.flyingbrowniegames.ballgame.Variables.blindModeIcon;
import static com.flyingbrowniegames.ballgame.Variables.blindName;
import static com.flyingbrowniegames.ballgame.Variables.burstCompleted;
import static com.flyingbrowniegames.ballgame.Variables.burstModeIcon;
import static com.flyingbrowniegames.ballgame.Variables.burstName;
import static com.flyingbrowniegames.ballgame.Variables.classicCompleted;
import static com.flyingbrowniegames.ballgame.Variables.classicModeIcon;
import static com.flyingbrowniegames.ballgame.Variables.classicName;
import static com.flyingbrowniegames.ballgame.Variables.doubleCompleted;
import static com.flyingbrowniegames.ballgame.Variables.doubleModeIcon;
import static com.flyingbrowniegames.ballgame.Variables.doubleName;
import static com.flyingbrowniegames.ballgame.Variables.duoModeIcon;
import static com.flyingbrowniegames.ballgame.Variables.duoName;
import static com.flyingbrowniegames.ballgame.Variables.extremeFlipModeIcon;
import static com.flyingbrowniegames.ballgame.Variables.extremeFlipName;
import static com.flyingbrowniegames.ballgame.Variables.extremeModeIcon;
import static com.flyingbrowniegames.ballgame.Variables.extremeName;
import static com.flyingbrowniegames.ballgame.Variables.goldstar1;
import static com.flyingbrowniegames.ballgame.Variables.goldstar2;
import static com.flyingbrowniegames.ballgame.Variables.goldstar3;
import static com.flyingbrowniegames.ballgame.Variables.goldstar4;
import static com.flyingbrowniegames.ballgame.Variables.goldstar5;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.mirrorCompleted;
import static com.flyingbrowniegames.ballgame.Variables.mirrorModeIcon;
import static com.flyingbrowniegames.ballgame.Variables.mirrorName;
import static com.flyingbrowniegames.ballgame.Variables.region;
import static com.flyingbrowniegames.ballgame.Variables.scoreBox1;
import static com.flyingbrowniegames.ballgame.Variables.w;
import static com.flyingbrowniegames.ballgame.Variables.whiteBox1;
import static com.flyingbrowniegames.ballgame.Variables.whiteBubble1;
import static com.flyingbrowniegames.ballgame.Variables.whiteBubble2;
import static com.flyingbrowniegames.ballgame.Variables.whiteBubble3;
import static com.flyingbrowniegames.ballgame.Variables.whiteBubble4;
import static com.flyingbrowniegames.ballgame.Variables.whiteBubble5;
import static com.flyingbrowniegames.ballgame.Variables.whiteBubble6;
import static com.flyingbrowniegames.ballgame.Variables.whiteBubble7;

/**
 * Created by kyle on 2017-07-05.
 */

public class newModeScreen {


    public static void screenDisplay() {
        Gdx.gl.glClearColor(32 / 255f, 32 / 255f, 32 / 255f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
//        whiteBubble1.setCenter((w * 6) / 42 - (w / 84), h / 2 + (6 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble1.draw(batch);
//        whiteBubble1.setCenter((w * 36) / 42 + (w / 84), h / 2 + (6 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble1.draw(batch);
//        whiteBubble2.setCenter((w * 6) / 42 - (w / 84), h / 2 - Variables.deltaY + (h / 192));
//        whiteBubble2.draw(batch);
//        whiteBubble2.setCenter((w * 36) / 42 + (w / 84), h / 2 - Variables.deltaY + (h / 192));
//        whiteBubble2.draw(batch);
//        whiteBubble3.setCenter((w * 6) / 42 - (w / 84), h / 2 - (6 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble3.draw(batch);
//        whiteBubble3.setCenter((w * 36) / 42 + (w / 84), h / 2 - (6 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble3.draw(batch);
//        whiteBubble4.setCenter((w * 6) / 42 - (w / 84), h / 2 - (12 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble4.draw(batch);
//        whiteBubble4.setCenter((w * 36) / 42 + (w / 84), h / 2 - (12 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble4.draw(batch);
//        whiteBubble5.setCenter((w * 6) / 42 - (w / 84), h / 2 - (18 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble5.draw(batch);
//        whiteBubble5.setCenter((w * 36) / 42 + (w / 84), h / 2 - (18 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble5.draw(batch);
//        whiteBubble6.setCenter((w * 6) / 42 - (w / 84), h / 2 - (24 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble6.draw(batch);
//        whiteBubble6.setCenter((w * 36) / 42 + (w / 84), h / 2 - (24 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble6.draw(batch);
//        whiteBubble7.setCenter((w * 6) / 42 - (w / 84), h / 2 - (30 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble7.draw(batch);
//        whiteBubble7.setCenter((w * 36) / 42 + (w / 84), h / 2 - (30 * h / 24) - Variables.deltaY + (h / 192));
//        whiteBubble7.draw(batch);
        batch.end();
        batch.begin();
        classicModeIcon.setCenter(w / 2, h / 2 + (9 * h / 24) - Variables.deltaY);
        classicModeIcon.draw(batch);
        mirrorModeIcon.setCenter(w / 2, h / 2 + (3 * h / 24) - Variables.deltaY);
        mirrorModeIcon.draw(batch);
        blindModeIcon.setCenter(w / 2, h / 2 - (3 * h / 24) - Variables.deltaY);
        blindModeIcon.draw(batch);
        burstModeIcon.setCenter(w / 2, h / 2 - (9 * h / 24) - Variables.deltaY);
        burstModeIcon.draw(batch);
        doubleModeIcon.setCenter(w / 2, h / 2 - (15 * h / 24) - Variables.deltaY);
        doubleModeIcon.draw(batch);
        extremeModeIcon.setCenter(w / 2, h / 2 - (21 * h / 24) - Variables.deltaY);
        extremeModeIcon.draw(batch);
        extremeFlipModeIcon.setCenter(w / 2, h / 2 - (27 * h / 24) - Variables.deltaY);
        extremeFlipModeIcon.draw(batch);
        duoModeIcon.setCenter(w / 2, h / 2 - (33 * h / 24) - Variables.deltaY);
        duoModeIcon.draw(batch);
        batch.end();
        batch.begin();
        classicName.setCenter((w * 17) / 42, h / 2 + (8 * h / 24) - Variables.deltaY);
        classicName.draw(batch);
        mirrorName.setCenter((w * 17) / 42, h / 2 + (2 * h / 24) - Variables.deltaY);
        mirrorName.draw(batch);
        blindName.setCenter((w * 17) / 42, h / 2 - (4 * h / 24) - Variables.deltaY);
        blindName.draw(batch);
        burstName.setCenter((w * 17) / 42, h / 2 - (10 * h / 24) - Variables.deltaY);
        burstName.draw(batch);
        doubleName.setCenter((w * 17) / 42, h / 2 - (16 * h / 24) - Variables.deltaY);
        doubleName.draw(batch);
        extremeName.setCenter((w * 17) / 42, h / 2 - (22 * h / 24) - Variables.deltaY);
        extremeName.draw(batch);
        extremeFlipName.setCenter((w * 17) / 42, h / 2 - (28 * h / 24) - Variables.deltaY);
        extremeFlipName.draw(batch);
        duoName.setCenter((w * 17) / 42, h / 2 - (34 * h / 24) - Variables.deltaY);
        duoName.draw(batch);
        batch.end();
        batch.begin();
        scoreBox1.setCenter((w * 4) / 5, h / 2 + (8 * h / 24) - Variables.deltaY);
        scoreBox1.draw(batch);
        scoreBox1.setCenter((w * 4) / 5, h / 2 + (2 * h / 24) - Variables.deltaY);
        scoreBox1.draw(batch);
        scoreBox1.setCenter((w * 4) / 5, h / 2 - (4 * h / 24) - Variables.deltaY);
        scoreBox1.draw(batch);
        scoreBox1.setCenter((w * 4) / 5, h / 2 - (10 * h / 24) - Variables.deltaY);
        scoreBox1.draw(batch);
        scoreBox1.setCenter((w * 4) / 5, h / 2 - (16 * h / 24) - Variables.deltaY);
        scoreBox1.draw(batch);
//      scoreBox1.setCenter((w * 4) / 5, Variables.h / 2 - (22 * Variables.h / 24) - Variables.deltaY);
//     scoreBox1.draw(batch);
        scoreBox1.setCenter((w * 4) / 5, h / 2 - (28 * h / 24) - Variables.deltaY);
        scoreBox1.draw(batch);
//        scoreBox1.setCenter((w * 4) / 5, Variables.h / 2 - (33 * Variables.h / 24) - Variables.deltaY);
//        scoreBox1.draw(batch);
        whiteBox1.setCenter((w * 5) / 42, h / 2 + (8 * h / 24) - Variables.deltaY);
        whiteBox1.draw(batch);
        whiteBox1.setCenter((w * 5) / 42, h / 2 + (2 * h / 24) - Variables.deltaY);
        whiteBox1.draw(batch);
        whiteBox1.setCenter((w * 5) / 42, h / 2 - (4 * h / 24) - Variables.deltaY);
        whiteBox1.draw(batch);
        whiteBox1.setCenter((w * 5) / 42, h / 2 - (10 * h / 24) - Variables.deltaY);
        whiteBox1.draw(batch);
        whiteBox1.setCenter((w * 5) / 42, h / 2 - (16 * h / 24) - Variables.deltaY);
        whiteBox1.draw(batch);
        whiteBox1.setCenter((w * 5) / 42, h / 2 - (22 * h / 24) - Variables.deltaY);
        whiteBox1.draw(batch);
        whiteBox1.setCenter((w * 5) / 42, h / 2 - (28 * h / 24) - Variables.deltaY);
        whiteBox1.draw(batch);
        whiteBox1.setCenter((w * 5) / 42, h / 2 - (34 * h / 24) - Variables.deltaY);
        whiteBox1.draw(batch);
        batch.end();
        batch.begin();
        if (classicCompleted.getInteger("classicCompleted") == 25) {
            goldstar1.setCenter(w / 2, h / 2 + (21 * h / 48) - Variables.deltaY);
            goldstar1.draw(batch);
        } else {
            blackStar1.setCenter(w / 2, h / 2 + (21 * h / 48) - Variables.deltaY);
            blackStar1.draw(batch);
        }
        if (mirrorCompleted.getInteger("mirrorCompleted") == 25) {
            goldstar2.setCenter(w / 2, h / 2 + (9 * h / 48) - Variables.deltaY);
            goldstar2.draw(batch);
        } else {
            blackStar2.setCenter(w / 2, h / 2 + (9 * h / 48) - Variables.deltaY);
            blackStar2.draw(batch);
        }
        if (blindCompleted.getInteger("blindCompleted") == 25) {
            goldstar3.setCenter(w / 2, h / 2 - (3 * h / 48) - Variables.deltaY);
            goldstar3.draw(batch);
        } else {
            blackStar3.setCenter(w / 2, h / 2 - (3 * h / 48) - Variables.deltaY);
            blackStar3.draw(batch);
        }
        if (burstCompleted.getInteger("burstCompleted") == 25) {
            goldstar4.setCenter(w / 2, h / 2 - (15 * h / 48) - Variables.deltaY);
            goldstar4.draw(batch);
        } else {
            blackStar4.setCenter(w / 2, h / 2 - (15 * h / 48) - Variables.deltaY);
            blackStar4.draw(batch);
        }
        if (doubleCompleted.getInteger("doubleCompleted") == 25) {
            goldstar5.setCenter(w / 2, h / 2 - (27 * h / 48) - Variables.deltaY);
            goldstar5.draw(batch);
        } else {
            blackStar5.setCenter(w / 2, h / 2 - (27 * h / 48) - Variables.deltaY);
            blackStar5.draw(batch);
        }
        //blackStar6.setCenter(w / 2, h / 2 - (51 * h / 48) - Variables.deltaY);
        //blackStar6.draw(batch);
        batch.end();
        batch.begin();
        ModeScorePrint.print();
        batch.end();
        Animations.classicIconAnimation();
        Animations.mirrorIconAnimation();
        Animations.blindIconAnimation();
        Animations.burstIconAnimation();
        Animations.doubleIconAnimation();
        Animations.extremeIconAnimation();
        Animations.extremeFlipIconAnimation();
        Animations.duoIconAnimation();
        batch.begin();
        Variables.modetitle.setCenter(Variables.modetitle.getWidth() / 2, h - (h / 14));
        Variables.modetitle.draw(batch);
        Variables.homesprite.setCenter(w / 11, (h * 30) / 32);
        Variables.homesprite.draw(batch);
        batch.end();
    }


}
