package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;
import static com.flyingbrowniegames.ballgame.Variables.blindleftball;
import static com.flyingbrowniegames.ballgame.Variables.blindrightball;
import static com.flyingbrowniegames.ballgame.Variables.currentCharacter;
import static com.flyingbrowniegames.ballgame.Variables.halfheight;
import static com.flyingbrowniegames.ballgame.Variables.halfwidth;
import static com.flyingbrowniegames.ballgame.Variables.leftball;
import static com.flyingbrowniegames.ballgame.Variables.rightball;
import static com.flyingbrowniegames.ballgame.Variables.w;


/**
 * Created by kwisk_000 on 2016-09-04.
 */


public class BlindColours {
    private static int blind_random;
    private static int other_side;

    public static void Color_from_int() {//randomly picks colors
        blind_random = Variables.random.nextInt(10) + 1;
        other_side = blind_random + 10;
        Variables.side = Variables.random.nextInt(10) + 1;
        if (Variables.direction == 1) {
            Variables.left_id = blind_random;

        } else if (Variables.direction == 2) {
            Variables.right_id = blind_random;
        } else {

        }

        if (Variables.side != 3 && Variables.side != 6 && Variables.side != 9) {
            if (Variables.direction == 2) {
                if (Variables.arc_degree_2 == 270) {
                    Variables.arc_right_id = other_side;
                    Variables.arc_left_id = blind_random;
                } else if (Variables.arc_degree_2 == 90) {
                    Variables.arc_right_id = blind_random;
                    Variables.arc_left_id = other_side;
                } else {

                }
            } else if (Variables.direction == 1) {
                if (Variables.arc_degree_2 == 270) {
                    Variables.arc_right_id = blind_random;
                    Variables.arc_left_id = other_side;
                } else if (Variables.arc_degree_2 == 90) {
                    Variables.arc_right_id = other_side;
                    Variables.arc_left_id = blind_random;
                } else {

                }
            } else {

            }
        } else if (Variables.side == 3 || Variables.side == 6 || Variables.side == 9) { //colors will match
            if (Variables.direction == 2) {
                if (Variables.arc_degree_2 == 270) {
                    Variables.arc_right_id = blind_random;
                    Variables.arc_left_id = other_side;
                } else if (Variables.arc_degree_2 == 90) {
                    Variables.arc_left_id = blind_random;
                    Variables.arc_right_id = other_side;
                }
            } else if (Variables.direction == 1) {
                if (Variables.arc_degree_2 == 270) {
                    Variables.arc_left_id = blind_random;
                    Variables.arc_right_id = other_side;
                } else if (Variables.arc_degree_2 == 90) {
                    Variables.arc_right_id = blind_random;
                    Variables.arc_left_id = other_side;
                }
            } else {

            }
        } else {

        }


    }

    public static void blind_colors() {
        switch (Variables.id) {
            case 1:
                Variables.shapeRenderer.setColor(240 / 255f, 130 / 255f, 101 / 255f, 0);
                break;
            case 2:
                Variables.shapeRenderer.setColor(245 / 255f, 239 / 255f, 74 / 255f, 0);
                break;
            case 3:
                Variables.shapeRenderer.setColor(172 / 255f, 125 / 255f, 236 / 255f, 0);//purple
                break;
            case 4:
                Variables.shapeRenderer.setColor(243 / 255f, 91 / 255f, 163 / 255f, 0);  //pink
                break;
            case 5:
                Variables.shapeRenderer.setColor(246 / 255f, 168 / 255f, 168 / 255f, 0); //pink
                break;
            case 6:
                Variables.shapeRenderer.setColor(184 / 255f, 244 / 255f, 157 / 255f, 0);//green
                break;
            case 7:
                Variables.shapeRenderer.setColor(94 / 255f, 79 / 255f, 240 / 255f, 0); //purple
                break;
            case 8:
                Variables.shapeRenderer.setColor(95 / 255f, 188 / 255f, 227 / 255f, 0);
                break;
            case 9:
                Variables.shapeRenderer.setColor(89 / 255f, 211 / 255f, 201 / 255f, 0);
                break;
            case 10:
                Variables.shapeRenderer.setColor(129 / 255f, 226 / 255f, 110 / 255f, 0);
                break;
            case 11:
                Variables.shapeRenderer.setColor(240 / 255f, 111 / 255f, 101 / 255f, 0);
                break;
            case 12:
                Variables.shapeRenderer.setColor(245 / 255f, 223 / 255f, 74 / 255f, 0);
                break;
            case 13:
                Variables.shapeRenderer.setColor(190 / 255f, 150 / 255f, 246 / 255f, 0);
                break;
            case 14:
                Variables.shapeRenderer.setColor(236 / 255f, 125 / 255f, 177 / 255f, 0);
                break;
            case 15:
                Variables.shapeRenderer.setColor(245 / 255f, 148 / 255f, 148 / 255f, 0);
                break;
            case 16:
                Variables.shapeRenderer.setColor(215 / 255f, 240 / 255f, 98 / 255f, 0);
                break;
            case 17:
                Variables.shapeRenderer.setColor(157 / 255f, 95 / 255f, 227 / 255f, 0);
                break;
            case 18:
                Variables.shapeRenderer.setColor(76 / 255f, 160 / 255f, 195 / 255f, 0);
                break;
            case 19:
                Variables.shapeRenderer.setColor(89 / 255f, 201 / 255f, 211 / 255f, 0);
                break;
            case 20:
                Variables.shapeRenderer.setColor(134 / 255f, 220 / 255f, 117 / 255f, 0);
                break;
        }
    }

    public static void blind_colors(String s) {

        //System.out.println("setting colours");
        boolean flippedR = blindrightball.isFlipX();
        boolean flippedL = blindleftball.isFlipX();
        switch (Variables.id) {
            case 1:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindone"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(240 / 255f, 130 / 255f, 101 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindone"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(240 / 255f, 130 / 255f, 101 / 255f, 1);
                }

                break;
            case 2:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindtwo"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(245 / 255f, 239 / 255f, 74 / 255f, 1);
                } else {
                    //blindrightball = new Sprite(sprites.get("blindtwo"));
                    //blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(245 / 255f, 239 / 255f, 74 / 255f, 1);
                }

                break;
            case 3:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindthree"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(172 / 255f, 125 / 255f, 236 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindthree"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(172 / 255f, 125 / 255f, 236 / 255f, 1);
                }


                break;
            case 4:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindfour"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(243 / 255f, 91 / 255f, 163 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindfour"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(243 / 255f, 91 / 255f, 163 / 255f, 1);
                }


                break;
            case 5:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindfive"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(246 / 255f, 168 / 255f, 168 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindfive"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(246 / 255f, 168 / 255f, 168 / 255f, 1);
                }


                break;
            case 6:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindsix"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(184 / 255f, 244 / 255f, 157 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindsix"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(184 / 255f, 244 / 255f, 157 / 255f, 1);
                }


                break;
            case 7:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindseven"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(94 / 255f, 79 / 255f, 240 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindseven"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(94 / 255f, 79 / 255f, 240 / 255f, 1);
                }


                break;
            case 8:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindeight"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(95 / 255f, 188 / 255f, 227 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindeight"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(95 / 255f, 188 / 255f, 227 / 255f, 1);
                }


                break;
            case 9:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindnine"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(89 / 255f, 211 / 255f, 201 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindnine"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(89 / 255f, 211 / 255f, 201 / 255f, 1);
                }


                break;
            case 10:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindten"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(129 / 255f, 226 / 255f, 110 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindten"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(129 / 255f, 226 / 255f, 110 / 255f, 1);
                }
                break;
            case 11:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindeleven"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(240 / 255f, 111 / 255f, 101 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindeleven"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(240 / 255f, 111 / 255f, 101 / 255f, 1);
                }
                break;
            case 12:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindtwelve"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(245 / 255f, 223 / 255f, 74 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindtwelve"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(245 / 255f, 223 / 255f, 74 / 255f, 1);
                }
                break;
            case 13:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindthirteen"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(190 / 255f, 150 / 255f, 246 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindthirteen"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(190 / 255f, 150 / 255f, 246 / 255f, 1);
                }
                break;
            case 14:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindfourteen"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(236 / 255f, 125 / 255f, 177 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindfourteen"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(236 / 255f, 125 / 255f, 177 / 255f, 1);
                }
                break;
            case 15:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindfifteen"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(245 / 255f, 148 / 255f, 148 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindfifteen"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(245 / 255f, 148 / 255f, 148 / 255f, 1);
                }
                break;
            case 16:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindsixteen"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(215 / 255f, 240 / 255f, 98 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindsixteen"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(215 / 255f, 240 / 255f, 98 / 255f, 1);
                }
                break;
            case 17:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindseventeen"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(157 / 255f, 95 / 255f, 227 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindseventeen"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(157 / 255f, 95 / 255f, 227 / 255f, 1);
                }
                break;
            case 18:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindeightteen"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(76 / 255f, 160 / 255f, 195 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindeigtteen"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(76 / 255f, 160 / 255f, 195 / 255f, 1);
                }
                break;
            case 19:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindnineteen"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(89 / 255f, 201 / 255f, 211 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindnineteen"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(89 / 255f, 201 / 255f, 211 / 255f, 1);
                }
                break;
            case 20:
                if (s.equalsIgnoreCase("left")) {
//                    blindleftball = new Sprite(sprites.get("blindtwenty"));
//                    blindleftball.setSize(halfwidth, halfheight);
                    blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindleftball.setColor(134 / 255f, 220 / 255f, 117 / 255f, 1);

                } else {
//                    blindrightball = new Sprite(sprites.get("blindtwenty"));
//                    blindrightball.setSize(halfwidth, halfheight);
                    blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
                    blindrightball.setColor(134 / 255f, 220 / 255f, 117 / 255f, 1);
                }
                break;
        }
        if (flippedR && s.equalsIgnoreCase("right")) {
            blindrightball.flip(true, false);
            //System.out.println("flipped");
        }
        if (flippedL && s.equalsIgnoreCase("left")) {
            blindleftball.flip(true, false);
        }
        //blindleftball.scale((((1) * (w)) / ((11) * (blindleftball.getWidth()))) - 1);
        //blindrightball.scale((((1) * (w)) / ((11) * (blindrightball.getWidth()))) - 1);
    }
}
