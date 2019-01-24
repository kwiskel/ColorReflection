package com.flyingbrowniegames.ballgame;


import static com.flyingbrowniegames.ballgame.BallGame.flipSprite;
import static com.flyingbrowniegames.ballgame.Double.ballposition2;
import static com.flyingbrowniegames.ballgame.Extreme.ballpositions;
import static com.flyingbrowniegames.ballgame.Variables.ballposition;
import static com.flyingbrowniegames.ballgame.Variables.blindleftball;
import static com.flyingbrowniegames.ballgame.Variables.blindrightball;
import static com.flyingbrowniegames.ballgame.Variables.burstOccurCount;
import static com.flyingbrowniegames.ballgame.Variables.flipCount;
import static com.flyingbrowniegames.ballgame.Variables.h1;
import static com.flyingbrowniegames.ballgame.Variables.h10;
import static com.flyingbrowniegames.ballgame.Variables.h11;
import static com.flyingbrowniegames.ballgame.Variables.h12;
import static com.flyingbrowniegames.ballgame.Variables.h2;
import static com.flyingbrowniegames.ballgame.Variables.h3;
import static com.flyingbrowniegames.ballgame.Variables.h4;
import static com.flyingbrowniegames.ballgame.Variables.h5;
import static com.flyingbrowniegames.ballgame.Variables.h6;
import static com.flyingbrowniegames.ballgame.Variables.h7;
import static com.flyingbrowniegames.ballgame.Variables.h8;
import static com.flyingbrowniegames.ballgame.Variables.h9;
import static com.flyingbrowniegames.ballgame.Variables.halfloop;
import static com.flyingbrowniegames.ballgame.Variables.leftball;
import static com.flyingbrowniegames.ballgame.Variables.rightball;
import static com.flyingbrowniegames.ballgame.Variables.score;
import static com.flyingbrowniegames.ballgame.Variables.screen;
import static com.flyingbrowniegames.ballgame.Variables.secondleftball;
import static com.flyingbrowniegames.ballgame.Variables.secondrightball;
import static com.flyingbrowniegames.ballgame.Variables.side;
import static com.flyingbrowniegames.ballgame.Variables.sideTap;
import static com.flyingbrowniegames.ballgame.Variables.sideTapScore;
import static com.flyingbrowniegames.ballgame.Variables.speed;
import static com.flyingbrowniegames.ballgame.Variables.times_hit_wall;
import static com.flyingbrowniegames.ballgame.Variables.type;
import static com.flyingbrowniegames.ballgame.Variables.widthspeed;

/**
 * Created by kwisk_000 on 2016-04-25.
 */
public class MoveBall {
    public static int half_way;
    public static int full_way;
    private static int variable_speed;


    public static void change_x() { // move the ball left and right

        //System.out.println("moving");
        if (Variables.loopone) {
            decide_speed();
        }
        if (Variables.screen == 17) {
            if ((variable_speed == 1 && Variables.burstcount < 8) || (variable_speed == 2 && Variables.burstcount < 8)) {
                Variables.widthspeed = full_way;
                Variables.burstcount++;
            } else {
                Variables.widthspeed = 2 * full_way;
                Variables.burstcount = 0;
            }
        } else if (Variables.screen == 18) { //double
            Variables.widthspeed = full_way;
        } else if (Variables.screen == 19) {//extreme
            Variables.widthspeed = half_way + (half_way / 2);
        } else {
            Variables.widthspeed = full_way;
        }
        // System.out.println("withspeed" + Variables.widthspeed);
        // System.out.println("speec_divide" + Variables.speed_increase);
        if (Variables.direction == 1) {
            int hits = Variables.times_hit_wall;
            if (hits < Variables.speed_increase) {
                Variables.speed = Variables.widthspeed / 100;
            } else if (hits % Variables.speed_increase == 0 && hits >= Variables.speed_increase) {
                Variables.speed = (Variables.widthspeed / 100) + hits / Variables.speed_increase;
            } else {
                Variables.speed = (Variables.widthspeed / 100) + hits / Variables.speed_increase;
                /*System.out.println("called");
                if (Variables.speed >= 20) {
                    Variables.speed = 20;
                } else {
                    Variables.speed = (Variables.widthspeed / 100) + hits / Variables.speed_increase;
                }*/

            }

            if (Variables.screen == 18) {
                Double.position_x2 -= Variables.speed;
            }
            if (Variables.screen == 21) {
                Duo.position_x2 -= Variables.speed;
            }
            Variables.position_x += Variables.speed;
            //System.out.println("moving1");
            //System.out.println("speed" + speed);
        } else if (Variables.direction == 2) {
            // System.out.println("times" + times_hit_wall);
            // if (Variables.times_hit_wall % Variables.speed_increase == 0 && Variables.times_hit_wall > 0) {
            int hits = Variables.times_hit_wall;
            if (hits < Variables.speed_increase) {
                Variables.speed = Variables.widthspeed / 100;
            } else if (hits % Variables.speed_increase == 0 && hits >= Variables.speed_increase) {
                Variables.speed = (Variables.widthspeed / 100) + hits / Variables.speed_increase;
            } else {
                Variables.speed = (Variables.widthspeed / 100) + hits / Variables.speed_increase;
            }


            //} else {

            //}
            if (Variables.screen == 18) {
                Double.position_x2 += Variables.speed;
            }
            if (Variables.screen == 21) {
                Duo.position_x2 += Variables.speed;
            }
            Variables.position_x -= Variables.speed;
            //System.out.println("moving2");
            //System.out.println("speed" + speed);

        }
        //System.out.println("widthspeed" + widthspeed);
        if ((Variables.speed >= (17 * (widthspeed / 1000))) && score < 100) {
            // System.out.println("set");
            Variables.speed = (17 * (widthspeed / 1000));
        }
        if (score > 100 && score < 200) {
            Variables.speed = (18 * (widthspeed / 1000));
        } else if (score > 200 && score < 300) {
            Variables.speed = (19 * (widthspeed / 1000));
        } else if (score > 300) {
            Variables.speed = (20 * (widthspeed / 1000));
        }
    }

    public static void change_direction() { // change the direction of the ball

        if ((Variables.position_x > Variables.w - (Variables.arc_width + (Variables.w / 100)))) {
            variable_speed = Variables.random.nextInt(3) + 1;
            Variables.times_hit_wall++;
            if (Variables.prefs_sound.getInteger("sound") != 2) {
                Variables.bounce.play(0.5f);
            }

            Variables.direction = 2;
            //halfloop = 0;
            if (Variables.screen == 18) {
                Double.direction2 = 1;
            }
            if (Variables.screen == 21) {
                Duo.direction2 = 1;
            }


        } else if ((Variables.position_x < (Variables.arc_width + (Variables.w / 100)))) {
            Variables.times_hit_wall++;
            variable_speed = Variables.random.nextInt(3) + 1;
            if (Variables.prefs_sound.getInteger("sound") == 0) {
                Variables.bounce.play(0.5f);
            }
            Variables.direction = 1;
            if (Variables.screen == 18) {
                Double.direction2 = 2;
            }
            if (Variables.screen == 21) {
                Duo.direction2 = 2;
            }

        } else {

        }

    }


    public static void decide_speed() {
        int w1 = Variables.w;
        int w2 = Variables.w;
        int one = 0;
        int two = 0;

        while (Variables.loopone) { //subtraction
            if (w1 % 100 == 0) {
                Variables.loopone = false;
            } else {
                w1--;
                one++;
            }

        }
        while (Variables.looptwo) {
            if (w2 % 100 == 0) {
                Variables.looptwo = false;
            } else {
                w2--;
                two++;
            }
        }
        if (two >= one) {

            Variables.widthspeed = w1;

        } else {
            Variables.widthspeed = w2;

        }
        half_way = Variables.widthspeed / 2;
        full_way = Variables.widthspeed;
    }

    public static void change_angle(float x, float y) { // change starting angle of arc
        //  System.out.println("soize" + MyGestureListener.touches.size());
        if (Variables.paused == false && (System.currentTimeMillis() - Variables.pausetime > 3000)) {
            if (Variables.arc_degree_1 == 90) {
                Variables.arc_degree_1 = 270;
                Variables.arc_degree_2 = 90;
            } else if (Variables.arc_degree_1 == 270) {
                Variables.arc_degree_1 = 90;
                Variables.arc_degree_2 = 270;
            } else {

            }
            if (screen == 16) {
                //flipSprite("blindrightball", true, false);
                //flipSprite("blindleftball", true, false);
                blindrightball.flip(true, false);
                blindleftball.flip(true, false);
                ballposition = ballposition * -1;
            } else {
                //flipSprite("rightball", true, false);
                //flipSprite("leftball", true, false);
                rightball.flip(true, false);
                leftball.flip(true, false);
                ballposition = ballposition * -1;
            }
        }
        if (type.equalsIgnoreCase("burstflip")) {
            if (widthspeed == (2 * full_way)) {
                flipCount++;
            }
        } else if (type.equalsIgnoreCase("flip")) {
            flipCount++;
        } else if (type.equalsIgnoreCase("flipwall")) {
            flipCount++;
        }

    }

    public static void change_double_angle() {
        if (Variables.screen == 18) {
            if (MyInputProcessor.right == true && MyInputProcessor.left == false) {
                //right side tap
                if (type.equalsIgnoreCase("lefttap")) {
                    sideTap = false;
                }
                if (type.equalsIgnoreCase("righttap")) {
                    sideTapScore+=2;
                }
                if (Variables.position_x >= Variables.w / 2) {
                    if (Variables.arc_degree_1 == 90) {
                        Variables.arc_degree_1 = 270;
                        Variables.arc_degree_2 = 90;

                    } else if (Variables.arc_degree_1 == 270) {
                        Variables.arc_degree_1 = 90;
                        Variables.arc_degree_2 = 270;

                    }
                    //flipSprite("rightball", true, false);
                    //flipSprite("leftball", true, false);
                    rightball.flip(true, false);
                    leftball.flip(true, false);
                    ballposition = ballposition * -1;
                    if (type.equalsIgnoreCase("bottomflip")) {
                        flipCount++;
                    }
                } else {
                    if (Double.arc_degree12 == 90) {
                        Double.arc_degree22 = 90;
                        Double.arc_degree12 = 270;


                    } else if (Double.arc_degree12 == 270) {
                        Double.arc_degree22 = 270;
                        Double.arc_degree12 = 90;


                    }
                    //flipSprite("secondrightball", true, false);
                    //flipSprite("secondleftball", true, false);
                    secondrightball.flip(true, false);
                    secondleftball.flip(true, false);
                    ballposition2 = ballposition2 * -1;
                    if (type.equalsIgnoreCase("topflip")) {
                        flipCount++;
                    }
                }
            } else if (MyInputProcessor.left == true && MyInputProcessor.right == false) {
                if (type.equalsIgnoreCase("righttap")) {
                    sideTap = false;
                }
                if (type.equalsIgnoreCase("lefttap")) {
                    sideTapScore+=2;
                }
                if (Variables.position_x < Variables.w / 2) {
                    if (Variables.arc_degree_1 == 90) {
                        Variables.arc_degree_1 = 270;
                        Variables.arc_degree_2 = 90;

                    } else if (Variables.arc_degree_1 == 270) {
                        Variables.arc_degree_1 = 90;
                        Variables.arc_degree_2 = 270;

                    }
                    //flipSprite("rightball", true, false);
                    //flipSprite("leftball", true, false);
                    rightball.flip(true, false);
                    leftball.flip(true, false);
                    if (type.equalsIgnoreCase("bottomflip")) {
                        flipCount++;
                    }
                    ballposition = ballposition * -1;
                } else {
                    if (Double.arc_degree12 == 90) {
                        Double.arc_degree22 = 90;
                        Double.arc_degree12 = 270;

                    } else if (Double.arc_degree12 == 270) {
                        Double.arc_degree22 = 270;
                        Double.arc_degree12 = 90;
                    }
                    //flipSprite("secondrightball", true, false);
                    //flipSprite("secondleftball", true, false);
                    secondrightball.flip(true, false);
                    secondleftball.flip(true, false);
                    ballposition2 = ballposition2 * -1;
                    if (type.equalsIgnoreCase("topflip")) {
                        flipCount++;
                    }
                }
            } else if (MyInputProcessor.right == true && MyInputProcessor.left == true) {
                if (type.equalsIgnoreCase("righttap") || type.equalsIgnoreCase("lefttap")) {
                    sideTap = false;
                }
                if (Variables.arc_degree_1 == 90) {
                    Variables.arc_degree_1 = 270;
                    Variables.arc_degree_2 = 90;
                } else if (Variables.arc_degree_1 == 270) {
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                }
                if (Double.arc_degree12 == 90) {
                    Double.arc_degree22 = 90;
                    Double.arc_degree12 = 270;
                } else if (Double.arc_degree12 == 270) {
                    Double.arc_degree22 = 270;
                    Double.arc_degree12 = 90;


                }
                //flipSprite("rightball", true, false);
                //flipSprite("leftball", true, false);
                //flipSprite("secondrightball", true, false);
                //flipSprite("secondleftball", true, false);
                rightball.flip(true, false);
                leftball.flip(true, false);
                secondrightball.flip(true, false);
                secondleftball.flip(true, false);
                ballposition = ballposition * -1;
                ballposition2 = ballposition2 * -1;
                if (type.equalsIgnoreCase("topflip") || type.equalsIgnoreCase("bottomflip")) {
                    flipCount++;
                }

            }

        }
        MyInputProcessor.left = false;
        MyInputProcessor.right = false;
        if (type.equalsIgnoreCase("flip")) {
            flipCount++;
        }
    }

    public static void change_duo_angle() {
        if (Variables.screen == 21) {
            if (MyInputProcessor.lower == true && MyInputProcessor.upper == false) { //lower ball
                if (Variables.arc_degree_1 == 270) {
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                } else if (Variables.arc_degree_1 == 90) {
                    Variables.arc_degree_1 = 270;
                    Variables.arc_degree_2 = 90;
                }
                //flipSprite("rightball", true, false);
                //flipSprite("leftball", true, false);
                rightball.flip(true, false);
                leftball.flip(true, false);
                ballposition = ballposition * -1;
            } else if (MyInputProcessor.upper == true && MyInputProcessor.lower == false) {
                if (Duo.arc_degree22 == 270) {
                    Duo.arc_degree22 = 90;
                    Duo.arc_degree12 = 270;
                } else if (Duo.arc_degree22 == 90) {
                    Duo.arc_degree22 = 270;
                    Duo.arc_degree12 = 90;
                }
                //flipSprite("secondrightball", true, false);
                //flipSprite("secondleftball", true, false);
                secondrightball.flip(true, false);
                secondleftball.flip(true, false);
                Duo.ballposition2 = Duo.ballposition2 * -1;
            } else if (MyInputProcessor.lower == true && MyInputProcessor.upper == true) {
                if (Duo.arc_degree22 == 270) {
                    Duo.arc_degree22 = 90;
                    Duo.arc_degree12 = 270;
                } else if (Duo.arc_degree22 == 90) {
                    Duo.arc_degree22 = 270;
                    Duo.arc_degree12 = 90;
                }
                if (Variables.arc_degree_1 == 270) {
                    Variables.arc_degree_1 = 90;
                    Variables.arc_degree_2 = 270;
                } else if (Variables.arc_degree_1 == 90) {
                    Variables.arc_degree_1 = 270;
                    Variables.arc_degree_2 = 90;
                }
                //flipSprite("rightball", true, false);
                //flipSprite("leftball", true, false);
                //flipSprite("secondrightball", true, false);
                //flipSprite("secondleftball", true, false);
                rightball.flip(true, false);
                leftball.flip(true, false);
                secondrightball.flip(true, false);
                secondleftball.flip(true, false);
                ballposition = ballposition * -1;
                Duo.ballposition2 = Duo.ballposition2 * -1;
            }

        }
        MyInputProcessor.upper = false;
        MyInputProcessor.lower = false;

    }

    public static void moveextremangle() {
        int where = 0;
        int orientation = 90;
        int position = 0;

        if (MyInputProcessor.first) {
            if (Extreme.arcdegrees.get(0) == 90) {
                Extreme.arcdegrees.remove(0);
                Extreme.arcdegrees.add(0, 270);
                Extreme.arcdegrees.remove(1);
                Extreme.arcdegrees.add(1, 90);

            } else if (Extreme.arcdegrees.get(0) == 270) {
                Extreme.arcdegrees.remove(0);
                Extreme.arcdegrees.add(0, 90);
                Extreme.arcdegrees.remove(1);
                Extreme.arcdegrees.add(1, 270);
            }
            position = -1 * ballpositions.get(0);
            ballpositions.remove(0);
            ballpositions.add(0, position);
            position = -1 * ballpositions.get(1);
            ballpositions.remove(1);
            ballpositions.add(1, position);
            //flipSprite("h1", true, false);
            //flipSprite("h2", true, false);
            h1.flip(true, false);
            h2.flip(true, false);
        }
        if (MyInputProcessor.second) {
            if (Extreme.arcdegrees.get(2) == 90) {
                Extreme.arcdegrees.remove(2);
                Extreme.arcdegrees.add(2, 270);
                Extreme.arcdegrees.remove(3);
                Extreme.arcdegrees.add(3, 90);

            } else if (Extreme.arcdegrees.get(2) == 270) {
                Extreme.arcdegrees.remove(2);
                Extreme.arcdegrees.add(2, 90);
                Extreme.arcdegrees.remove(3);
                Extreme.arcdegrees.add(3, 270);
            }
            position = -1 * ballpositions.get(2);
            ballpositions.remove(2);
            ballpositions.add(2, position);
            position = -1 * ballpositions.get(3);
            ballpositions.remove(3);
            ballpositions.add(3, position);
            //flipSprite("h3", true, false);
            //flipSprite("h4", true, false);
            h3.flip(true, false);
            h4.flip(true, false);
        }
        if (MyInputProcessor.third) {
            if (Extreme.arcdegrees.get(4) == 90) {
                Extreme.arcdegrees.remove(4);
                Extreme.arcdegrees.add(4, 270);
                Extreme.arcdegrees.remove(5);
                Extreme.arcdegrees.add(5, 90);

            } else if (Extreme.arcdegrees.get(4) == 270) {
                Extreme.arcdegrees.remove(4);
                Extreme.arcdegrees.add(4, 90);
                Extreme.arcdegrees.remove(5);
                Extreme.arcdegrees.add(5, 270);
            }
            position = -1 * ballpositions.get(4);
            ballpositions.remove(4);
            ballpositions.add(4, position);
            position = -1 * ballpositions.get(5);
            ballpositions.remove(5);
            ballpositions.add(5, position);
            //flipSprite("h5", true, false);
            //flipSprite("h6", true, false);
            h5.flip(true, false);
            h6.flip(true, false);
        }
        if (MyInputProcessor.fourth) {
            if (Extreme.arcdegrees.get(6) == 90) {
                Extreme.arcdegrees.remove(6);
                Extreme.arcdegrees.add(6, 270);
                Extreme.arcdegrees.remove(7);
                Extreme.arcdegrees.add(7, 90);

            } else if (Extreme.arcdegrees.get(6) == 270) {
                Extreme.arcdegrees.remove(6);
                Extreme.arcdegrees.add(6, 90);
                Extreme.arcdegrees.remove(7);
                Extreme.arcdegrees.add(7, 270);
            }
            position = -1 * ballpositions.get(6);
            ballpositions.remove(6);
            ballpositions.add(6, position);
            position = -1 * ballpositions.get(7);
            ballpositions.remove(7);
            ballpositions.add(7, position);
            //flipSprite("h7", true, false);
            //flipSprite("h8", true, false);
            h7.flip(true, false);
            h8.flip(true, false);
        }
        if (MyInputProcessor.fifth) {
            if (Extreme.arcdegrees.get(8) == 90) {
                Extreme.arcdegrees.remove(8);
                Extreme.arcdegrees.add(8, 270);
                Extreme.arcdegrees.remove(9);
                Extreme.arcdegrees.add(9, 90);

            } else if (Extreme.arcdegrees.get(8) == 270) {
                Extreme.arcdegrees.remove(8);
                Extreme.arcdegrees.add(8, 90);
                Extreme.arcdegrees.remove(9);
                Extreme.arcdegrees.add(9, 270);
            }
            position = -1 * ballpositions.get(8);
            ballpositions.remove(8);
            ballpositions.add(8, position);
            position = -1 * ballpositions.get(9);
            ballpositions.remove(9);
            ballpositions.add(9, position);
            //flipSprite("h9", true, false);
            //flipSprite("h10", true, false);
            h9.flip(true, false);
            h10.flip(true, false);
        }
        if (MyInputProcessor.sixth) {
            if (Extreme.arcdegrees.get(10) == 90) {
                Extreme.arcdegrees.remove(10);
                Extreme.arcdegrees.add(10, 270);
                Extreme.arcdegrees.remove(11);
                Extreme.arcdegrees.add(11, 90);

            } else if (Extreme.arcdegrees.get(10) == 270) {
                Extreme.arcdegrees.remove(10);
                Extreme.arcdegrees.add(10, 90);
                Extreme.arcdegrees.remove(11);
                Extreme.arcdegrees.add(11, 270);
            }
            position = -1 * ballpositions.get(10);
            ballpositions.remove(10);
            ballpositions.add(10, position);
            position = -1 * ballpositions.get(11);
            ballpositions.remove(11);
            ballpositions.add(11, position);
            //flipSprite("h11", true, false);
            //flipSprite("h12", true, false);
            h11.flip(true, false);
            h12.flip(true, false);
        }
       /* switch (Extreme.balls1) {
            case 3:

                if (((Variables.h - y) < Variables.h) && ((Variables.h - y) >= ((2 * Variables.h) / 3))) {
                    if (Extreme.arcdegrees.get(0) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(0) == 270) {
                        orientation = 270;
                    }
                    where = 0;
                } else if (((Variables.h - y) < ((2 * Variables.h) / 3)) && ((Variables.h - y) >= ((Variables.h) / 3))) {
                    if (Extreme.arcdegrees.get(2) == 90) {
                        orientation = 90;

                    } else if (Extreme.arcdegrees.get(2) == 270) {
                        orientation = 270;
                    }
                    where = 2;
                } else if (((Variables.h - y) < ((1 * Variables.h) / 3)) && ((Variables.h - y) >= 0)) {
                    if (Extreme.arcdegrees.get(4) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(4) == 270) {
                        orientation = 270;
                    }
                    where = 4;
                }
                if (Variables.screen == 19) {
                    if (orientation == 90) {
                        Extreme.arcdegrees.remove(where);
                        Extreme.arcdegrees.add(where, 270);
                        Extreme.arcdegrees.remove(where + 1);
                        Extreme.arcdegrees.add(where + 1, 90);
                    } else {
                        Extreme.arcdegrees.remove(where);
                        Extreme.arcdegrees.add(where, 90);
                        Extreme.arcdegrees.remove(where + 1);
                        Extreme.arcdegrees.add(where + 1, 270);
                    }
                }
                break;
            case 4:
                if (((Variables.h - y) < Variables.h) && ((Variables.h - y) >= ((3 * Variables.h) / 4))) {
                    if (Extreme.arcdegrees.get(0) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(0) == 270) {
                        orientation = 270;
                    }
                    where = 0;
                } else if (((Variables.h - y) < ((3 * Variables.h) / 4)) && ((Variables.h - y) >= ((2 * Variables.h) / 4))) {
                    if (Extreme.arcdegrees.get(2) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(2) == 270) {
                        orientation = 270;
                    }
                    where = 2;
                } else if (((Variables.h - y) < ((2 * Variables.h) / 4)) && ((Variables.h - y) >= ((Variables.h) / 4))) {
                    if (Extreme.arcdegrees.get(4) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(4) == 270) {
                        orientation = 270;
                    }
                    where = 4;
                } else if (((Variables.h - y) < ((Variables.h) / 4)) && ((Variables.h - y) >= 0)) {
                    if (Extreme.arcdegrees.get(6) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(6) == 270) {
                        orientation = 270;
                    }
                    where = 6;
                }
                if (Variables.screen == 19) {
                    if (orientation == 90) {
                        Extreme.arcdegrees.remove(where);
                        Extreme.arcdegrees.add(where, 270);
                        Extreme.arcdegrees.remove(where + 1);
                        Extreme.arcdegrees.add(where + 1, 90);
                    } else {
                        Extreme.arcdegrees.remove(where);
                        Extreme.arcdegrees.add(where, 90);
                        Extreme.arcdegrees.remove(where + 1);
                        Extreme.arcdegrees.add(where + 1, 270);
                    }
                }
                break;
            case 5:
                if (((Variables.h - y) < Variables.h) && ((Variables.h - y) >= ((4 * Variables.h) / 5))) {
                    if (Extreme.arcdegrees.get(0) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(0) == 270) {
                        orientation = 270;
                    }
                    where = 0;
                } else if (((Variables.h - y) < ((4 * Variables.h) / 5)) && ((Variables.h - y) >= ((3 * Variables.h) / 5))) {
                    if (Extreme.arcdegrees.get(2) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(2) == 270) {
                        orientation = 270;
                    }
                    where = 2;
                } else if (((Variables.h - y) < ((3 * Variables.h) / 5)) && ((Variables.h - y) >= ((2 * Variables.h) / 5))) {
                    if (Extreme.arcdegrees.get(4) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(4) == 270) {
                        orientation = 270;
                    }
                    where = 4;
                } else if (((Variables.h - y) < ((2 * Variables.h) / 5)) && ((Variables.h - y) >= ((Variables.h) / 5))) {
                    if (Extreme.arcdegrees.get(6) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(6) == 270) {
                        orientation = 270;
                    }
                    where = 6;
                } else if (((Variables.h - y) < ((1 * Variables.h) / 5)) && ((Variables.h - y) >= 0)) {
                    if (Extreme.arcdegrees.get(8) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(8) == 270) {
                        orientation = 270;
                    }
                    where = 8;
                }
                if (Variables.screen == 19) {
                    if (orientation == 90) {
                        Extreme.arcdegrees.remove(where);
                        Extreme.arcdegrees.add(where, 270);
                        Extreme.arcdegrees.remove(where + 1);
                        Extreme.arcdegrees.add(where + 1, 90);
                    } else {
                        Extreme.arcdegrees.remove(where);
                        Extreme.arcdegrees.add(where, 90);
                        Extreme.arcdegrees.remove(where + 1);
                        Extreme.arcdegrees.add(where + 1, 270);
                    }
                }
                break;
            case 6:
                if (((Variables.h - y) < Variables.h) && ((Variables.h - y) >= ((5 * Variables.h) / 6))) {
                    if (Extreme.arcdegrees.get(0) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(0) == 270) {
                        orientation = 270;
                    }
                    where = 0;
                } else if (((Variables.h - y) < ((5 * Variables.h) / 6)) && ((Variables.h - y) >= ((4 * Variables.h) / 6))) {
                    if (Extreme.arcdegrees.get(2) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(2) == 270) {
                        orientation = 270;
                    }
                    where = 2;
                } else if (((Variables.h - y) < ((4 * Variables.h) / 6)) && ((Variables.h - y) >= ((3 * Variables.h) / 6))) {
                    if (Extreme.arcdegrees.get(4) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(4) == 270) {
                        orientation = 270;
                    }
                    where = 4;
                } else if (((Variables.h - y) < ((3 * Variables.h) / 6)) && ((Variables.h - y) >= ((2 * Variables.h) / 6))) {
                    if (Extreme.arcdegrees.get(6) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(6) == 270) {
                        orientation = 270;
                    }
                    where = 6;
                } else if (((Variables.h - y) < ((2 * Variables.h) / 6)) && ((Variables.h - y) >= ((1 * Variables.h) / 6))) {
                    if (Extreme.arcdegrees.get(8) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(8) == 270) {
                        orientation = 270;
                    }
                    where = 8;
                } else if (((Variables.h - y) < ((1 * Variables.h) / 6)) && ((Variables.h - y) >= 0)) {
                    if (Extreme.arcdegrees.get(10) == 90) {
                        orientation = 90;
                    } else if (Extreme.arcdegrees.get(10) == 270) {
                        orientation = 270;
                    }
                    where = 10;
                }
                if (Variables.screen == 19) {
                    if (orientation == 90) {
                        Extreme.arcdegrees.remove(where);
                        Extreme.arcdegrees.add(where, 270);
                        Extreme.arcdegrees.remove(where + 1);
                        Extreme.arcdegrees.add(where + 1, 90);
                    } else {
                        Extreme.arcdegrees.remove(where);
                        Extreme.arcdegrees.add(where, 90);
                        Extreme.arcdegrees.remove(where + 1);
                        Extreme.arcdegrees.add(where + 1, 270);
                    }
                }

                break;

        }
        */
        MyInputProcessor.first = false;
        MyInputProcessor.second = false;
        MyInputProcessor.third = false;
        MyInputProcessor.fourth = false;
        MyInputProcessor.fifth = false;
        MyInputProcessor.sixth = false;
    }

    public static void moveextremeflipangle() {
        int position = 0;
        if (MyInputProcessor.upper == true && MyInputProcessor.lower == false) { //lower
            if (Extreme.arcdegrees.get(2) == 90) {
                Extreme.arcdegrees.remove(2);
                Extreme.arcdegrees.add(2, 270);
                Extreme.arcdegrees.remove(2 + 1);
                Extreme.arcdegrees.add(2 + 1, 90);
            } else if (Extreme.arcdegrees.get(2) == 270) {
                Extreme.arcdegrees.remove(2);
                Extreme.arcdegrees.add(2, 90);
                Extreme.arcdegrees.remove(2 + 1);
                Extreme.arcdegrees.add(2 + 1, 270);
            }
            position = -1 * ballpositions.get(2);
            ballpositions.remove(2);
            ballpositions.add(2, position);
            position = -1 * ballpositions.get(3);
            ballpositions.remove(3);
            ballpositions.add(3, position);
            //flipSprite("h3", true, false);
            //flipSprite("h4", true, false);
            h3.flip(true, false);
            h4.flip(true, false);
        } else if (MyInputProcessor.upper == false && MyInputProcessor.lower == true) { //upper
            if (Extreme.arcdegrees.get(0) == 90) {
                Extreme.arcdegrees.remove(0);
                Extreme.arcdegrees.add(0, 270);
                Extreme.arcdegrees.remove(0 + 1);
                Extreme.arcdegrees.add(0 + 1, 90);
            } else if (Extreme.arcdegrees.get(0) == 270) {
                Extreme.arcdegrees.remove(0);
                Extreme.arcdegrees.add(0, 90);
                Extreme.arcdegrees.remove(0 + 1);
                Extreme.arcdegrees.add(0 + 1, 270);
            }
            position = -1 * ballpositions.get(0);
            ballpositions.remove(0);
            ballpositions.add(0, position);
            position = -1 * ballpositions.get(1);
            ballpositions.remove(1);
            ballpositions.add(1, position);
            //flipSprite("h1", true, false);
            //flipSprite("h2", true, false);
            h1.flip(true, false);
            h2.flip(true, false);
        } else if (MyInputProcessor.upper == true && MyInputProcessor.lower == true) {
            if (Extreme.arcdegrees.get(0) == 90) {
                Extreme.arcdegrees.remove(0);
                Extreme.arcdegrees.add(0, 270);
                Extreme.arcdegrees.remove(0 + 1);
                Extreme.arcdegrees.add(0 + 1, 90);
            } else if (Extreme.arcdegrees.get(0) == 270) {
                Extreme.arcdegrees.remove(0);
                Extreme.arcdegrees.add(0, 90);
                Extreme.arcdegrees.remove(0 + 1);
                Extreme.arcdegrees.add(0 + 1, 270);
            }
            if (Extreme.arcdegrees.get(2) == 90) {
                Extreme.arcdegrees.remove(2);
                Extreme.arcdegrees.add(2, 270);
                Extreme.arcdegrees.remove(2 + 1);
                Extreme.arcdegrees.add(2 + 1, 90);
            } else if (Extreme.arcdegrees.get(2) == 270) {
                Extreme.arcdegrees.remove(2);
                Extreme.arcdegrees.add(2, 90);
                Extreme.arcdegrees.remove(2 + 1);
                Extreme.arcdegrees.add(2 + 1, 270);
            }
            position = -1 * ballpositions.get(0);
            ballpositions.remove(0);
            ballpositions.add(0, position);
            position = -1 * ballpositions.get(1);
            ballpositions.remove(1);
            ballpositions.add(1, position);
            //flipSprite("h1", true, false);
            //flipSprite("h2", true, false);
            h1.flip(true, false);
            h2.flip(true, false);
            position = -1 * ballpositions.get(2);
            ballpositions.remove(2);
            ballpositions.add(2, position);
            position = -1 * ballpositions.get(3);
            ballpositions.remove(3);
            ballpositions.add(3, position);
            //flipSprite("h3", true, false);
            //flipSprite("h4", true, false);
            h3.flip(true, false);
            h4.flip(true, false);
        }
        MyInputProcessor.lower = false;
        MyInputProcessor.upper = false;
    }

}
