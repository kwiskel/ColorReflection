package com.flyingbrowniegames.ballgame;

import static com.flyingbrowniegames.ballgame.Variables.screen;

/**
 * Created by kwisk_000 on 2016-05-22.
 */

public class ColoursDouble {


    public static void Colors() {

        Color_from_int();
        switch (Variables.mode) {
            case 1:
                // decide_colors();
                break;
            case 2:
                //  decide_colors();
                break;
            case 3:
                //blind_colors();
                break;
        }

    }

    public static void arc_color(int some_id) { // change color of arc
        Variables.id = some_id;
        Colours.decide_colors();
        //decide_colors();
    }

    public static void left_color() { //change color of left side
        if (screen == 18 || screen == 11)
            Variables.id = Double.left_id2;
        if (Variables.mode == 8) {
            Variables.id = Duo.left_id2;
        }
        Colours.decide_colors();
        //decide_colors();
    }

    public static void right_color() { // change color of right side
        if (screen == 18 || screen == 11)
            Variables.id = Double.right_id2;
        if (Variables.mode == 8) {
            Variables.id = Duo.right_id2;
        }
        Colours.decide_colors();
        //decide_colors();
    }

    public static void Color_from_int() {//randomly picks colors
        if (screen == 18) {
            Variables.side_random = Variables.random.nextInt(9) + 1;
            Variables.ball_random = Variables.random.nextInt(9) + 1;
            if (Variables.side_random == Variables.ball_random) {
                Color_from_int();
            } else {
                Variables.side = Variables.random.nextInt(9) + 1;
                if (Double.direction2 == 1) {
                    Double.left_id2 = Variables.side_random;
                } else if (Double.direction2 == 2) {
                    Double.right_id2 = Variables.side_random;
                } else {

                }


                //System.out.println("side_random" + Variables.side_random);
                //System.out.println("side " + Variables.side);
                //System.out.println("durection " + Double.direction2);
                //System.out.println("arcdegree22 " + Double.arc_degree22);
                if (Variables.side != 3 && Variables.side != 6 && Variables.side != 9) {
                    if (Double.direction2 == 2) {
                        if (Double.arc_degree22 == 270) {
                            Double.arc_right_id2 = Variables.ball_random;
                            Double.arc_left_id2 = Variables.side_random;
                        } else if (Double.arc_degree22 == 90) {
                            Double.arc_right_id2 = Variables.side_random;
                            Double.arc_left_id2 = Variables.ball_random;
                        } else {

                        }
                    } else if (Double.direction2 == 1) {
                        if (Double.arc_degree22 == 270) {
                            Double.arc_right_id2 = Variables.side_random;
                            Double.arc_left_id2 = Variables.ball_random;
                        } else if (Double.arc_degree22 == 90) {
                            Double.arc_right_id2 = Variables.ball_random;
                            Double.arc_left_id2 = Variables.side_random;
                        } else {

                        }
                    } else {

                    }
                } else if (Variables.side == 3 || Variables.side == 6 || Variables.side == 9) { //colors will match
                    //System.out.println("direction" + direction);
                    if (Double.direction2 == 2) {
                        if (Double.arc_degree22 == 270) {
                            Double.arc_right_id2 = Variables.side_random;
                            Double.arc_left_id2 = Variables.ball_random;
                        } else if (Double.arc_degree22 == 90) {
                            Double.arc_left_id2 = Variables.side_random;
                            Double.arc_right_id2 = Variables.ball_random;
                        }
                    } else if (Double.direction2 == 1) {
                        if (Double.arc_degree22 == 270) {
                            Double.arc_left_id2 = Variables.side_random;
                            Double.arc_right_id2 = Variables.ball_random;
                        } else if (Double.arc_degree22 == 90) {
                            Double.arc_right_id2 = Variables.side_random;
                            Double.arc_left_id2 = Variables.ball_random;
                        }
                    } else {

                    }
                } else {

                }
            }
        } else if (screen == 21) {
            Variables.side_random = Variables.random.nextInt(9) + 1;
            Variables.ball_random = Variables.random.nextInt(9) + 1;
            if (Variables.side_random == Variables.ball_random) {
                Color_from_int();
            } else {
                Variables.side = Variables.random.nextInt(9) + 1;
                if (Duo.direction2 == 1) {//to the right
                    Duo.left_id2 = Variables.side_random;

                } else if (Duo.direction2 == 2) {//to the left
                    Duo.right_id2 = Variables.side_random;
                } else {

                }


                //  System.out.println("side_random" + Variables.side_random);
                if (Variables.side != 3 && Variables.side != 6 && Variables.side != 9) {
                    if (Duo.direction2 == 2) {
                        if (Duo.arc_degree22 == 270) {
                            Duo.arc_right_id2 = Variables.ball_random;
                            Duo.arc_left_id2 = Variables.side_random;
                        } else if (Duo.arc_degree22 == 90) {
                            Duo.arc_right_id2 = Variables.side_random;
                            Duo.arc_left_id2 = Variables.ball_random;
                        }
                    } else if (Duo.direction2 == 1) {
                        if (Duo.arc_degree22 == 270) {
                            Duo.arc_right_id2 = Variables.side_random;
                            Duo.arc_left_id2 = Variables.ball_random;
                        } else if (Duo.arc_degree22 == 90) {
                            Duo.arc_right_id2 = Variables.ball_random;
                            Duo.arc_left_id2 = Variables.side_random;
                        } else {

                        }
                    } else {

                    }
                } else if (Variables.side == 3 || Variables.side == 6 || Variables.side == 9) { //colors will match
                    //System.out.println("direction" + direction);
                    if (Duo.direction2 == 2) {
                        if (Duo.arc_degree22 == 270) {
                            Duo.arc_right_id2 = Variables.side_random;
                            Duo.arc_left_id2 = Variables.ball_random;
                        } else if (Duo.arc_degree22 == 90) {
                            Duo.arc_left_id2 = Variables.side_random;
                            Duo.arc_right_id2 = Variables.ball_random;
                        }
                    } else if (Duo.direction2 == 1) {
                        if (Duo.arc_degree22 == 270) {
                            Duo.arc_left_id2 = Variables.side_random;
                            Duo.arc_right_id2 = Variables.ball_random;
                        } else if (Duo.arc_degree22 == 90) {
                            Duo.arc_right_id2 = Variables.side_random;
                            Duo.arc_left_id2 = Variables.ball_random;
                        }
                    } else {

                    }
                } else {

                }
            }
        }
    }

}
