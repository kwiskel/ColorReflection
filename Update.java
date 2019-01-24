package com.flyingbrowniegames.ballgame;

import static com.flyingbrowniegames.ballgame.Variables.batch;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.screenOverlay;
import static com.flyingbrowniegames.ballgame.Variables.updateBoard;
import static com.flyingbrowniegames.ballgame.Variables.updateBrownie;
import static com.flyingbrowniegames.ballgame.Variables.updateCheck;
import static com.flyingbrowniegames.ballgame.Variables.updateTitle;
import static com.flyingbrowniegames.ballgame.Variables.updates;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kyle on 2017-11-17.
 */

public class Update {

    public static void updatePopUp() {
        batch.begin();
        screenOverlay.setCenter(w / 2, h / 2);
        screenOverlay.draw(batch);
        updateBoard.setCenter(w / 2, h / 2);
        updateBoard.draw(batch);
        updateTitle.setCenter(w / 2, h / 2 + (updateBoard.getBoundingRectangle().getHeight() / 2));
        updateTitle.draw(batch);
        updates.setCenter(w / 2, h / 2);
        updates.draw(batch);
        updateCheck.setCenter(w / 2, h / 2 - (updateBoard.getBoundingRectangle().getHeight() / 2));
        updateCheck.draw(batch);
        //updateBrownie.setCenter((w * 3) / 16, h / 2);
        //updateBrownie.draw(batch);
        batch.end();
    }
}
