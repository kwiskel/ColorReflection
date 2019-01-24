package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.arc_degree_1;
import static com.flyingbrowniegames.ballgame.Variables.arc_degree_2;
import static com.flyingbrowniegames.ballgame.Variables.currentCharacter;
import static com.flyingbrowniegames.ballgame.Variables.halfheight;
import static com.flyingbrowniegames.ballgame.Variables.halfloop;
import static com.flyingbrowniegames.ballgame.Variables.halfwidth;
import static com.flyingbrowniegames.ballgame.Variables.id;
import static com.flyingbrowniegames.ballgame.Variables.leftball;
import static com.flyingbrowniegames.ballgame.Variables.rightball;
import static com.flyingbrowniegames.ballgame.Variables.secondleftball;
import static com.flyingbrowniegames.ballgame.Variables.secondrightball;
import static com.flyingbrowniegames.ballgame.Variables.w;


/**
 * Created by kwisk_000 on 2016-04-25.
 */
public class Colours {
    public static void Colors() {
        Color_from_int();
        //System.out.println("coors");
    }

    public static void extreme_color(ArrayList<Integer> a, int i) {
        Variables.left_id = a.get(i);
        Variables.right_id = a.get(i + 1);
        Extreme.wallcolors.add(Variables.left_id);
        Extreme.wallcolors.add(Variables.right_id);
    }

    public static void arc_color(int some_id, String side, int loop) { // change color of arc
        Variables.id = some_id;
        if (Variables.screen == 16 || Variables.screen == 9) {
            if (halfloop < loop) {
                BlindColours.blind_colors(side);
                halfloop++;
            }


        } else {
            if (halfloop < loop) {
                //com.flyingbrowniegames.ballgame.MoveBall.change_direction();
                //MoveBall.change_x();
                Colours.decide_colors(side);
                halfloop++;
            }

        }
        //decide_colors();

    }

    public static void arc_color(int some_id) {
        Variables.id = some_id;
        if (Variables.screen == 16 || Variables.screen == 9) {
            BlindColours.blind_colors();

        } else {
            Colours.decide_colors();
        }
    }

    public static void extreme_Color(int some_id) {
        Variables.id = some_id;
        extreme_Colors();
    }

    public static void left_color() { //change color of left side
        Variables.id = Variables.left_id;
        if (Variables.screen == 16 || Variables.screen == 9) {
            BlindColours.blind_colors();
        } else {
            Colours.decide_colors();

        }
        //decide_colors();
    }

    public static void right_color() { // change color of right side
        Variables.id = Variables.right_id;
        if (Variables.screen == 16 || Variables.screen == 9) {
            BlindColours.blind_colors();
        } else {
            Colours.decide_colors();

        }
        //decide_colors();
    }

    public static void Color_from_int() {//randomly picks colors
        Variables.side_random = Variables.random.nextInt(9) + 1;
        Variables.ball_random = Variables.random.nextInt(9) + 1;
        if (Variables.side_random == Variables.ball_random) {
            Color_from_int();
        } else {
            Variables.side = Variables.random.nextInt(9) + 1;
            if (Variables.direction == 1) {
                Variables.left_id = Variables.side_random;

            } else if (Variables.direction == 2) {
                Variables.right_id = Variables.side_random;
            } else {

            }


            // System.out.println("side_random" + Variables.side_random);
            if (Variables.side != 3 && Variables.side != 6 && Variables.side != 9) {
                if (Variables.direction == 2) {
                    if (Variables.arc_degree_2 == 270) {
                        Variables.arc_right_id = Variables.ball_random;
                        Variables.arc_left_id = Variables.side_random;
                    } else if (Variables.arc_degree_2 == 90) {
                        Variables.arc_right_id = Variables.side_random;
                        Variables.arc_left_id = Variables.ball_random;
                    } else {

                    }
                } else if (Variables.direction == 1) {
                    if (Variables.arc_degree_2 == 270) {
                        Variables.arc_right_id = Variables.side_random;
                        Variables.arc_left_id = Variables.ball_random;
                    } else if (Variables.arc_degree_2 == 90) {
                        Variables.arc_right_id = Variables.ball_random;
                        Variables.arc_left_id = Variables.side_random;
                    } else {

                    }
                } else {

                }
            } else if (Variables.side == 3 || Variables.side == 6 || Variables.side == 9) { //colors will match
                //System.out.println("direction" + direction);
                if (Variables.direction == 2) {
                    if (Variables.arc_degree_2 == 270) {
                        Variables.arc_right_id = Variables.side_random;
                        Variables.arc_left_id = Variables.ball_random;
                    } else if (Variables.arc_degree_2 == 90) {
                        Variables.arc_left_id = Variables.side_random;
                        Variables.arc_right_id = Variables.ball_random;
                    }
                } else if (Variables.direction == 1) {
                    if (Variables.arc_degree_2 == 270) {
                        Variables.arc_left_id = Variables.side_random;
                        Variables.arc_right_id = Variables.ball_random;
                    } else if (Variables.arc_degree_2 == 90) {
                        Variables.arc_right_id = Variables.side_random;
                        Variables.arc_left_id = Variables.ball_random;
                    }
                } else {

                }
            } else {

            }
        }

    }

    public static void decide_colors(String s) {
        boolean flippedR1 = rightball.isFlipX();
        boolean flippedL1 = leftball.isFlipX();
        boolean flippedR2 = secondrightball.isFlipX();
        boolean flippedL2 = secondleftball.isFlipX();

//        sprites.get("redhalf").setFlip(false, false);
//        sprites.get("purplehalf").setFlip(false, false);
//        sprites.get("cyanhalf").setFlip(false, false);
//        sprites.get("lgreenhalf").setFlip(false, false);
//        sprites.get("bluehalf").setFlip(false, false);
//        sprites.get("dpurplehalf").setFlip(false, false);
//        sprites.get("dgreenhalf").setFlip(false, false);
//        sprites.get("yellowhalf").setFlip(false, false);
//        sprites.get("orangehalf").setFlip(false, false);


        switch (Variables.id) {
            case 1: //redhalf
                if (s.equalsIgnoreCase("left")) {
                    //leftball = new Sprite(sprites.get("redhalf"));
                    //leftball.setSize(halfwidth, halfheight);
                    leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    leftball.setColor(243/255f, 34/255f, 12/255f, 1);
                    //leftball.scale((((1) * (w)) / ((11) * (leftball.getWidth()))) - 1);
                    //leftball = sprites.get("redhalf");
                } else if (s.equalsIgnoreCase("right")) {
                    //rightball = new Sprite(sprites.get("redhalf"));
                    //rightball = sprites.get("redhalf");
                    //rightball.setSize(halfwidth, halfheight);
                    rightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    rightball.setColor(243/255f, 34/255f, 12/255f, 1);
                    //rightball.scale((((1) * (w)) / ((11) * (rightball.getWidth()))) - 1);
                } else if (s.equalsIgnoreCase("left2")) {
                    //secondleftball = new Sprite(sprites.get("redhalf"));
                    //secondleftball.setSize(halfwidth, halfheight);
                    secondleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondleftball.setColor(243/255f, 34/255f, 12/255f, 1);
                } else if (s.equalsIgnoreCase("right2")) {
                    //secondrightball = new Sprite(sprites.get("redhalf"));
                    //secondrightball.setSize(halfwidth, halfheight);
                    secondrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondrightball.setColor(243/255f, 34/255f, 12/255f, 1);
                }

                break;
            /*case 2: //pinkhalf

                if (s.equalsIgnoreCase("left")) {
                    //leftball = sprites.get((("pinkhalf.png")));
                    //leftball = new Sprite(pink);
                    leftball = new Sprite(red);
                    leftball.setSize(halfwidth, halfheight);
                } else if (s.equalsIgnoreCase("right")) {
                    //rightball = sprites.get((("pinkhalf.png")));
                    //rightball = new Sprite(pink);
                    rightball = new Sprite(red);
                    rightball.setSize(halfwidth, halfheight);

                } else if (s.equalsIgnoreCase("left2")) {
                    //leftball = sprites.get((("redhalf.png")));
                    // secondleftball = new Sprite(pink);
                    secondleftball = new Sprite(red);
                    secondleftball.setSize(halfwidth, halfheight);
                } else if (s.equalsIgnoreCase("right2")) {
                    //rightball = sprites.get((("redhalf.png")));
                    // secondrightball = new Sprite(pink);
                    secondrightball = new Sprite(red);
                    secondrightball.setSize(halfwidth, halfheight);
                    //Texture texture = new Texture(Gdx.files.internal("redhalf.png"));


                }

                break;*/
            case 2: //purplehalf
                if (s.equalsIgnoreCase("left")) {
                    //leftball = new Sprite(sprites.get("purplehalf"));
                    //leftball.setSize(halfwidth, halfheight);
                    leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    leftball.setColor(200/255f, 71/255f, 243/255f, 1);
                } else if (s.equalsIgnoreCase("right")) {
                    //rightball = new Sprite(sprites.get("purplehalf"));
                    //rightball.setSize(halfwidth, halfheight);
                    rightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    rightball.setColor(200/255f, 71/255f, 243/255f, 1);
                } else if (s.equalsIgnoreCase("left2")) {
                    //secondleftball = new Sprite(sprites.get("purplehalf"));
                    //secondleftball.setSize(halfwidth, halfheight);
                    secondleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondleftball.setColor(200/255f, 71/255f, 243/255f, 1);
                } else if (s.equalsIgnoreCase("right2")) {
                    //secondrightball = new Sprite(sprites.get("purplehalf"));
                    //secondrightball.setSize(halfwidth, halfheight);
                    secondrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondrightball.setColor(200/255f, 71/255f, 243/255f, 1);
                }


                break;
            case 3: //cyanhalf

                if (s.equalsIgnoreCase("left")) {
                    //leftball = new Sprite(sprites.get("cyanhalf"));
                    //leftball.setSize(halfwidth, halfheight);
                    leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    leftball.setColor(39/255f, 231/255f, 238/255f, 1);
                } else if (s.equalsIgnoreCase("right")) {
                    //rightball = new Sprite(sprites.get("cyanhalf"));
                    //rightball.setSize(halfwidth, halfheight);
                    rightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    rightball.setColor(39/255f, 231/255f, 238/255f, 1);
                } else if (s.equalsIgnoreCase("left2")) {
                    //secondleftball = new Sprite(sprites.get("cyanhalf"));
                    //secondleftball.setSize(halfwidth, halfheight);
                    secondleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondleftball.setColor(39/255f, 231/255f, 238/255f, 1);
                } else if (s.equalsIgnoreCase("right2")) {
                    //secondrightball = new Sprite(sprites.get("cyanhalf"));
                    //secondrightball.setSize(halfwidth, halfheight);
                    secondrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondrightball.setColor(39/255f, 231/255f, 238/255f, 1);
                }

                break;
            case 4:  //lgreenhalf

                if (s.equalsIgnoreCase("left")) {
                    //leftball = new Sprite(sprites.get("lgreenhalf"));
                    //leftball.setSize(halfwidth, halfheight);
                    leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    leftball.setColor(79/255f, 216/255f, 19/255f, 1);
                } else if (s.equalsIgnoreCase("right")) {
                    //rightball = new Sprite(sprites.get("lgreenhalf"));
                    //rightball.setSize(halfwidth, halfheight);
                    rightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    rightball.setColor(79/255f, 216/255f, 19/255f, 1);
                } else if (s.equalsIgnoreCase("left2")) {
                    //secondleftball = new Sprite(sprites.get("lgreenhalf"));
                    //secondleftball.setSize(halfwidth, halfheight);
                    secondleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondleftball.setColor(79/255f, 216/255f, 19/255f, 1);
                } else if (s.equalsIgnoreCase("right2")) {
                    //secondrightball = new Sprite(sprites.get("lgreenhalf"));
                    //secondrightball.setSize(halfwidth, halfheight);
                    secondrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondrightball.setColor(79/255f, 216/255f, 19/255f, 1);
                }
                break;
            case 5://bluehalf

                if (s.equalsIgnoreCase("left")) {
                    //leftball = new Sprite(sprites.get("bluehalf"));
                    //leftball.setSize(halfwidth, halfheight);
                    leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    leftball.setColor(32/255f, 87/255f, 245/255f, 1);
                } else if (s.equalsIgnoreCase("right")) {
                    //rightball = new Sprite(sprites.get("bluehalf"));
                    //rightball.setSize(halfwidth, halfheight);
                    rightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    rightball.setColor(32/255f, 87/255f, 245/255f, 1);
                } else if (s.equalsIgnoreCase("left2")) {
                    //secondleftball = new Sprite(sprites.get("bluehalf"));
                    //secondleftball.setSize(halfwidth, halfheight);
                    secondleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondleftball.setColor(32/255f, 87/255f, 245/255f, 1);
                } else if (s.equalsIgnoreCase("right2")) {
                    //secondrightball = new Sprite(sprites.get("bluehalf"));
                    //secondrightball.setSize(halfwidth, halfheight);
                    secondrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondrightball.setColor(32/255f, 87/255f, 245/255f, 1);
                }

                break;
            case 6: //dpurplehalf

                if (s.equalsIgnoreCase("left")) {
                    //leftball = new Sprite(sprites.get("dpurplehalf"));
                    //leftball.setSize(halfwidth, halfheight);
                    leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    leftball.setColor(90/255f, 13/255f, 195/255f, 1);
                } else if (s.equalsIgnoreCase("right")) {
                    //rightball = new Sprite(sprites.get("dpurplehalf"));
                    //rightball.setSize(halfwidth, halfheight);
                    rightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    rightball.setColor(90/255f, 13/255f, 195/255f, 1);
                } else if (s.equalsIgnoreCase("left2")) {
                    //secondleftball = new Sprite(sprites.get("dpurplehalf"));
                    //secondleftball.setSize(halfwidth, halfheight);
                    secondleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondleftball.setColor(90/255f, 13/255f, 195/255f, 1);
                } else if (s.equalsIgnoreCase("right2")) {
                    //secondrightball = new Sprite(sprites.get("dpurplehalf"));
                    //secondrightball.setSize(halfwidth, halfheight);
                    secondrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondrightball.setColor(90/255f, 13/255f, 195/255f, 1);
                }


                break;
            case 7: //dgreenhalf

                if (s.equalsIgnoreCase("left")) {
                    //leftball = new Sprite(sprites.get("dgreenhalf"));
                    //leftball.setSize(halfwidth, halfheight);
                    leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    leftball.setColor(20/255f, 145/255f, 7/255f, 1);
                } else if (s.equalsIgnoreCase("right")) {
                    //rightball = new Sprite(sprites.get("dgreenhalf"));
                    //rightball.setSize(halfwidth, halfheight);
                    rightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    rightball.setColor(20/255f, 145/255f, 7/255f, 1);
                } else if (s.equalsIgnoreCase("left2")) {
                    //secondleftball = new Sprite(sprites.get("dgreenhalf"));
                    //secondleftball.setSize(halfwidth, halfheight);
                    secondleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondleftball.setColor(20/255f, 145/255f, 7/255f, 1);
                } else if (s.equalsIgnoreCase("right2")) {
                    //secondrightball = new Sprite(sprites.get("dgreenhalf"));
                    //secondrightball.setSize(halfwidth, halfheight);
                    secondrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondrightball.setColor(20/255f, 145/255f, 7/255f, 1);
                }


                break;
            case 8: //yellowhalf

                if (s.equalsIgnoreCase("left")) {
                    //leftball = new Sprite(sprites.get("yellowhalf"));
                    //leftball.setSize(halfwidth, halfheight);
                    leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    leftball.setColor(242/255f, 218/255f, 16/255f, 1);
                } else if (s.equalsIgnoreCase("right")) {
                    //rightball = new Sprite(sprites.get("yellowhalf"));
                    //rightball.setSize(halfwidth, halfheight);
                    rightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    rightball.setColor(242/255f, 218/255f, 16/255f, 1);
                } else if (s.equalsIgnoreCase("left2")) {
                    //secondleftball = new Sprite(sprites.get("yellowhalf"));
                    //secondleftball.setSize(halfwidth, halfheight);
                    secondleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondleftball.setColor(242/255f, 218/255f, 16/255f, 1);
                } else if (s.equalsIgnoreCase("right2")) {
                    //secondrightball = new Sprite(sprites.get("yellowhalf"));
                    //secondrightball.setSize(halfwidth, halfheight);
                    secondrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondrightball.setColor(242/255f, 218/255f, 16/255f, 1);
                }


                break;
            case 9: //orangehalf
                if (s.equalsIgnoreCase("left")) {
                    //leftball = new Sprite(sprites.get("orangehalf"));
                    //leftball.setSize(halfwidth, halfheight);
                    leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    leftball.setColor(244/255f, 167/255f, 33/255f, 1);
                } else if (s.equalsIgnoreCase("right")) {
                    //rightball = new Sprite(sprites.get("orangehalf"));
                    //rightball.setSize(halfwidth, halfheight);
                    rightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    rightball.setColor(244/255f, 167/255f, 33/255f, 1);
                } else if (s.equalsIgnoreCase("left2")) {
                    //secondleftball = new Sprite(sprites.get("orangehalf"));
                    //secondleftball.setSize(halfwidth, halfheight);
                    secondleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondleftball.setColor(244/255f, 167/255f, 33/255f, 1);
                } else if (s.equalsIgnoreCase("right2")) {
                    //secondrightball = new Sprite(sprites.get("orangehalf"));
                    //secondrightball.setSize(halfwidth, halfheight);
                    secondrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    secondrightball.setColor(244/255f, 167/255f, 33/255f, 1);
                }


                break;
            case 11:
                Variables.shapeRenderer.setColor(Color.FIREBRICK);
                break;
            case 12:
                Variables.shapeRenderer.setColor(Color.CYAN);
                break;
            case 13:
                Variables.shapeRenderer.setColor(Color.GOLD);
                break;
            case 14:
                Variables.shapeRenderer.setColor(Color.LIME);
                break;
            case 15:
                Variables.shapeRenderer.setColor(Color.SALMON);
                break;
            case 16:
                Variables.shapeRenderer.setColor(Color.TAN);
                break;
            case 17:
                Variables.shapeRenderer.setColor(Color.PURPLE);
                break;
        }
        if (flippedR1 && s.equalsIgnoreCase("right")) {//if it's supposed to be flipped
            rightball.flip(true, false);
        }
        //rightball.scale((((1) * (w)) / ((11) * (rightball.getWidth()))) - 1);

        if (flippedL1 && s.equalsIgnoreCase("left")) {
            leftball.flip(true, false);
        }
        //leftball.scale((((1) * (w)) / ((11) * (leftball.getWidth()))) - 1);

        if (flippedR2 && s.equalsIgnoreCase("right2")) {
            secondrightball.flip(true, false);
        }
        //secondrightball.scale((((1) * (w)) / ((11) * (secondrightball.getWidth()))) - 1);

        if (flippedL2 && s.equalsIgnoreCase("left2")) {
            secondleftball.flip(true, false);
        }
        //secondleftball.scale((((1) * (w)) / ((11) * (secondrightball.getWidth()))) - 1);

    }

    public static void decide_colors() {
        switch (Variables.id) {
            case 1:
                Variables.shapeRenderer.setColor(243 / 255f, 34 / 255f, 12 / 255f, 0); //red
                break;
            /*case 2:
                //Variables.shapeRenderer.setColor(232 / 255f, 29 / 255f, 139 / 255f, 0); //pink
                Variables.shapeRenderer.setColor(243 / 255f, 34 / 255f, 12 / 255f, 0); //red
                break;*/
            case 2:
                Variables.shapeRenderer.setColor(200 / 255f, 71 / 255f, 243 / 255f, 0); //purple
                break;
            case 3:
                Variables.shapeRenderer.setColor(39 / 255f, 231 / 255f, 238 / 255f, 0); //cyan
                break;
            case 4:
                Variables.shapeRenderer.setColor(79 / 255f, 216 / 255f, 19 / 255f, 0); //lightgreen
                break;
            case 5:
                Variables.shapeRenderer.setColor(32 / 255f, 87 / 255f, 245 / 255f, 0); //blue
                break;
            case 6:
                Variables.shapeRenderer.setColor(90 / 255f, 13 / 255f, 195 / 255f, 0); //dark purple
                break;
            case 7:
                Variables.shapeRenderer.setColor(20 / 255f, 145 / 255f, 7 / 255f, 0); //dark green
                break;
            case 8:
                Variables.shapeRenderer.setColor(242 / 255f, 218 / 255f, 16 / 255f, 0); //yellow
                break;
            case 9:
                Variables.shapeRenderer.setColor(244 / 255f, 167 / 255f, 33 / 255f, 0); //orange
                break;
            case 11:
                Variables.shapeRenderer.setColor(Color.FIREBRICK);
                break;
            case 12:
                Variables.shapeRenderer.setColor(Color.CYAN);
                break;
            case 13:
                Variables.shapeRenderer.setColor(Color.GOLD);
                break;
            case 14:
                Variables.shapeRenderer.setColor(Color.LIME);
                break;
            case 15:
                Variables.shapeRenderer.setColor(Color.SALMON);
                break;
            case 16:
                Variables.shapeRenderer.setColor(Color.TAN);
                break;
            case 17:
                Variables.shapeRenderer.setColor(Color.PURPLE);
                break;
        }
    }


    public static void extreme_Colors() {
        switch (Variables.id) {
            case 1:
                Variables.shapeRenderer.setColor(243 / 255f, 34 / 255f, 12 / 255f, 0); //red
                break;
            case 2:
                Variables.shapeRenderer.setColor(232 / 255f, 29 / 255f, 139 / 255f, 0); //pink
                break;
            case 3:
                Variables.shapeRenderer.setColor(200 / 255f, 71 / 255f, 243 / 255f, 0); //purple
                break;
            case 4:
                Variables.shapeRenderer.setColor(39 / 255f, 231 / 255f, 238 / 255f, 0); //cyan
                break;
            case 5:
                Variables.shapeRenderer.setColor(32 / 255f, 87 / 255f, 245 / 255f, 0); //blue
                break;
            case 6:
                Variables.shapeRenderer.setColor(79 / 255f, 216 / 255f, 19 / 255f, 0); //lightgreen
                break;
            case 7:
                Variables.shapeRenderer.setColor(90 / 255f, 13 / 255f, 195 / 255f, 0); //dark purple
                break;
            case 8:
                Variables.shapeRenderer.setColor(20 / 255f, 145 / 255f, 7 / 255f, 0); //dark green
                break;
            case 9:
                Variables.shapeRenderer.setColor(242 / 255f, 218 / 255f, 16 / 255f, 0); //yellow
                break;
            case 10:
                Variables.shapeRenderer.setColor(244 / 255f, 167 / 255f, 33 / 255f, 0); //orange
                break;
        }
    }
}
