package com.flyingbrowniegames.ballgame;


import java.util.Calendar;
import java.util.Date;

import static com.flyingbrowniegames.ballgame.Variables.calendar;
import static com.flyingbrowniegames.ballgame.Variables.specialSale;
import static com.flyingbrowniegames.ballgame.Variables.timeFont;
import static com.flyingbrowniegames.ballgame.Variables.timeLayout;
import static com.flyingbrowniegames.ballgame.Variables.unlockedCharacters;
import static com.flyingbrowniegames.ballgame.Variables.unlockedSpecialCharacters;

/**
 * Created by kyle on 2017-12-02.
 */

public class DateCompare {

    public static void saleDate() {
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        if (day > 27) {
            specialSale = false;
        } else {
            //set glyphLayout
            if (day >= 25) {//less than 3 days left
                if (day == 25) {
                    timeLayout.setText(timeFont, ("2d " + (24 - hour) + "h left"));
                } else if (day == 26) {
                    timeLayout.setText(timeFont, ("1d " + (24 - hour) + "h left"));
                } else {//day = 27;
                    if (hour == 23) {//less than 1 hour left
                        timeLayout.setText(timeFont, (60 - minute) + " left");
                    } else {//more than 1 hour left
                        timeLayout.setText(timeFont, ((24 - hour) + "h " + (60 - minute) + "m left"));
                    }
                }
            } else {//more than 3 days left
                timeLayout.setText(timeFont, (28 - day) + "d left");
            }
        }
    }

    public static void isSale() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);//0 to 11
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (unlockedSpecialCharacters.getString("unlockedSpecialCharacters")
                .substring(unlockedSpecialCharacters.getString("unlockedSpecialCharacters").length() - 1
                        , unlockedSpecialCharacters.getString("unlockedSpecialCharacters").length()).equals("1")) {
            specialSale = false;
        }
        if (year > 2017) {
            specialSale = false;
        } else {//2017
            if (day > 27) {
                specialSale = false;
            } else {//before 27

            }
        }
    }
}
