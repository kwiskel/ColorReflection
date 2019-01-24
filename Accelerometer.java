package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import static com.flyingbrowniegames.ballgame.Variables.ball_x;
import static com.flyingbrowniegames.ballgame.Variables.ball_y;
import static com.flyingbrowniegames.ballgame.Variables.h;
import static com.flyingbrowniegames.ballgame.Variables.w;

/**
 * Created by kyle on 2017-02-25.
 */

public class Accelerometer {

    public static boolean checkPhone() { //checks if device has an accelerometer
        return Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer); //returns accelerometer status
    }

    public static Input.Orientation checkRotation() { //checks the rotation of the accelerometer
        Input.Orientation orientation = Gdx.input.getNativeOrientation();
        return orientation;
    }

    public static void moveBall() { //moves Ball based on accelerometer
        boolean available = checkPhone(); //checks if accelerometer is avalable
        if (available) { //if the device has an accelerometer
            Input.Orientation orientation = checkRotation();
            float accelX = Gdx.input.getAccelerometerX();
            float accelY = Gdx.input.getAccelerometerY();
            float accelZ = Gdx.input.getAccelerometerZ();
            move(accelX, accelY, accelZ);
        } else if (!available) { //if the device phone does not have an accelerometer

        }
    }

    public static void move(float accelX, float accelY, float accelZ) {
        //System.out.println("accelX: " + accelX + " accelY: " + accelY + " accelZ: " + accelZ);
        if (accelX < -2) { //moves right
            if (ball_x < w - (w / 11)) {
                ball_x -= (5 * accelX);
            } else {

            }
        } else if (accelX > 2) { //moves left
            if (ball_x > (w / 11)) {
                ball_x -= (5 * accelX);
            }
        } else {

        }
        if (accelY < -2) { //moves up
            if (ball_y < (h / 2) + ((2 * w) / 11)) {
                ball_y -= (6 * accelY);
            }
        } else if (accelY > 2) { //moves down
            if (ball_y > (h / 2) - (w / 11)) {
                ball_y -= (5 * accelY);
            } else {
                //ball_y = ((h/2) - (w/11));
            }
        }


    }
}
