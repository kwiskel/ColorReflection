package com.flyingbrowniegames.ballgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Matrix4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import static com.flyingbrowniegames.ballgame.BallGame.sprites;

/**
 * Created by kwisk_000 on 2016-04-25.
 */
public class Variables {
    //public static ArrayList<String>hello =new ArrayList<String>();
    // public static Json json =new Json();
    //booleans
    public static boolean loopone;
    public static boolean looptwo;
    public static boolean paused; //pause the game
    public static boolean highscore_reach;

    //achievement arrayList
    public static String[] classicAchievements = {"Play 5 Games", "Reach a score of 20", "Play 120 seconds", "Share your score", "Reach a score of 30", "Flip the ball a \n total of 100 times",
            "Rate us on \n the Play Store", "Reach a score of 40", "Flip the ball \n 30 times in one game", "Get a score of \n exactly 25", "Reach a score of 50", "Play 300 seconds \n cumulative time",
            "Hit the wall a \n total of 100 times", "Flip the ball \n 60 times in one game", "Reach a score of 70", "Flip the ball a \n total of 300 times", "Play 10 games", "Reach a score of 20 \n in five separate games", "Play 30 seconds \n before dying",
            "Get a score of \n exactly 45", "Reach a score of 80", "Hit the wall a \n total of 500 times", "Reach a score of 100", "Flip the ball \n 100 times in one game", "Score 40 or higher \n in five straight games"};
    public static String[] classicTypes = {"games", "score", "time", "share", "score", "flip", "rate", "score", "flip", "score",
            "score", "time", "score", "flip", "score", "flip", "games", "score", "time", "score", "score", "score", "score", "flip", "score", "finished"};
    public static int[] classicRequirements = {5, 20, 120, 1, 30, 100, 1, 40, 30, 25, 50, 300, 100, 60, 70, 300, 10, 20, 30, 45, 80, 500, 100, 100, 40};
    public static int[] classicCumulatives = {1, 0, 1, 0, 0, 1, 0, 0, 0, -1, 0, 1, 1, 0, 0, 1, 1, 5, 0, -1, 0, 1, 0, 0, -5};
    public static int[] classicProgress = new int[25];
    public static String[] mirrorAchievements = {"Play 7 games", "Pass through the \n mirror 20 times", "Bounce off the \n mirror 10 times", "Play a total \n of 80 seconds", "Die 10 times", "Flip the ball \n a total of 100 times",
            "Reach a score 20", "Bounce off the mirror \n 5 times in one game", "Pass through the mirror \n exactly 3 times in 1 game", "Score exactly 23", "Hit the wall \n a total of 75 times", "Die 8 times",
            "Play 25 seconds \n before dying", "Reach a score of 30", "Pass through the mirror \n a total of 30 times", "Reach a score of 30 \n in three straight games", "Bounce off the mirror \n a total of 20 times",
            "Reach a score of 40", "Reach a cumulative \n score of 200", "Correctly match a \n reflected ball 10 times", "Reach a score of 50",
            "Pass through the mirror \n 28 times in one game", "Reach a score of 20 \n in 4 straight games", "Bounce off the mirror \n exactly 11 times in one game", "Flip the ball 70 \n times in one game"};
    public static String[] mirrorTypes = {"games", "through", "bounce", "time", "games", "flip", "score", "bounce", "through", "score", "score", "games", "time", "score", "through", "score", "bounce",
            "score", "score", "match", "score", "through", "score", "bounce", "flip", "finished"};
    public static int[] mirrorRequirements = {7, 20, 10, 80, 10, 100, 20, 5, 3, 23, 75, 8, 25, 30, 30, 30, 20, 40, 200, 10, 50, 28, 20, 11, 70};
    public static int[] mirrorCumulatives = {1, 1, 1, 1, 1, 1, 0, 0, -1, -1, 1, 1, 0, 0, 1, -3, 1, 0, 1, 1, 0, 0, -4, -1, 0};
    public static int[] mirrorProgress = new int[25];
    public static String[] blindAchievements = {"Play 5 games", "Hit the wall a \n total of 50 times", "Reach a score of 10", "Die 10 times", "Score 100 times",
            "Reach a score of 5 \n in 5 straight games", "Reach a score of 10 \n in 10 separate games", "Share you score", "Check the leaderboards", "Play 20 seconds \n before dying",
            "Reach a score of 15", "Play 180 seconds", "Flip the ball a \n total of 400 times", "Reach a score of 25", "Score 20 in \n 7 separate games", "Get a score \n of exactly 17",
            "Flip the ball 8 times \n before hitting a wall", "Correctly match the \n pink colour 10 times", "Correctly match the \n yellow colour 5 times", "Reach a score of 50",
            "Beat your highscore", "Reach a score of 60", "Get a score \n of exactly 41", "Die 15 times", "Score 40 or higher \n in 3 straight games"};
    public static String[] blindTypes = {"games", "score", "score", "games", "score", "score", "score", "share", "leaderboard", "time", "score", "time", "flip",
            "score", "score", "score", "flipwall", "pink", "yellow", "score", "highscore", "score", "score", "games", "score", "finished"};
    public static int[] blindRequirements = {5, 50, 10, 10, 100, 5, 10, 1, 1, 20, 15, 180, 400, 25, 20, 17, 8, 10, 5, 50, 1, 60, 41, 15, 40};
    public static int[] blindCumulatives = {1, 1, 0, 1, 1, -5, 10, 0, 0, 0, 0, 1, 1, 0, 7, -1, 0, 1, 1, 0, 0, 0, 0, 1, -3};
    public static int[] blindProgress = new int[25];
    public static String[] burstAchievements = {"Play 6 games", "Reach a score of 10", "Hit the wall a \n total of 65 times", "Flip the ball \n 200 times", "Play 90 seconds",
            "Score 10 points \n with burst speed", "Die 5 times \n with burst speed", "Get burst speed \n 15 times",
            "Reach a score of 20", "Match the blue \n colour 5 times", "Flip the ball 50 \n times with burst speed",
            "Score 20 points \n with burst speed", "Flip the ball 40 \n times in one game", "Play 210 seconds", "Play 2 games",
            "Die 12 times \n with burst speed", "Score 125 points", "Score exactly 22", "Beat your highscore", "Check your ranking \n in the leaderboards",
            "Score 20 points \n in 8 straight games", "Score 30 points \n with burst speed", "Match the light green \n colour 15 times",
            "Score 50 points", "Score 40 points \n in 2 separate games"};
    public static String[] burstTypes = {"games", "score", "score", "flip", "time", "burstscore", "burstdie", "burst",
            "score", "blue", "burstflip", "burstscore", "flip", "time", "games", "burstdie", "score", "score", "highscore",
            "leaderboard", "score", "burstscore", "lightgreen", "score", "score", "finished"};
    public static int[] burstRequirements = {6, 10, 65, 200, 90, 10, 5, 15, 20, 5, 50, 20, 40, 210, 2, 12, 125, 22, 1, 1, 20, 30, 15, 50, 40};
    public static int[] burstCumulatives = {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, -1, 0, 0, -8, 1, 1, 0, 2};
    public static int[] burstProgress = new int[25];
    public static String[] doubleAchievements = {"Play 9 games", "Reach a score of 20", "Flip the top \n ball 50 times", "Flip any ball \n 100 times", "Die 5 times by incorrectly \n matching the bottom ball",
            "Reach a score of 40", "Play 3 straight games \n lasting 15 seconds", "Play for 120 seconds", "Reach a score of 6 \n only tapping the right side",
            "Reach a score of 60", "Beat your highscore", "Flip the bottom ball \n 20 times in one game", "Reach a score of 100",
            "Die 7 times by incorrectly \n matching the top ball", "Flip the bottom \n ball 300 times", "Score exactly 52", "Flip any ball 70 \n times in one game", "Score 160 times",
            "Play 15 seconds \n before dying", "Correctly match the \n same colour with both balls", "Score 10 points \n only tapping the left side",
            "Reach a score of 140", "Score 40 points \n in 3 straight games", "Play 40 seconds \n before dying", "Score 500 times"};
    public static String[] doubleTypes = {"games", "score", "topflip", "flip", "bottomdie", "score", "time", "time", "righttap", "score", "highscore", "bottomflip", "score",
            "topdie", "bottomflip", "score", "flip", "score", "time", "colourmatch", "lefttap", "score", "score", "time", "score", "finished"};
    public static int[] doubleRequirements = {9, 20, 50, 100, 5, 40, 15, 120, 6, 60, 1, 20, 100, 7, 300, 52, 70, 160, 15, 1, 10, 140, 40, 40, 500};
    public static int[] doubleCumulatives = {1, 0, 1, 1, 1, 0, -3, 1, 0, 0, 0, 0, 0, 1, 1, -1, 0, 1, 0, 0, 0, 0, -3, 0, 1};
    public static int[] doubleProgress = new int[25];
    public static String[] extremeFlipAchievements = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    public static String[] extremeFlipTypes = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    public static int[] extremeFlipRequirements = {};
    public static int[] extremeFlipCumulatives = {};
    public static int[] extremeFlipProgress = new int[25];

    public static int[] characterPricings;
    public static String[] specialCharacters = {"reindeer"};


    //Preferences
    public static Preferences prefs_games;
    public static Preferences prefs_wallhit;
    public static Preferences prefs_sound;
    public static Preferences prefs_score;
    public static Preferences prefs_score2;
    public static Preferences prefs_score3;
    public static Preferences prefs_score4;
    public static Preferences prefs_score5;
    public static Preferences prefs_score63;
    public static Preferences prefs_score64;
    public static Preferences prefs_score65;
    public static Preferences prefs_score66;
    public static Preferences prefs_score7;
    public static Preferences prefs_score8;
    public static Preferences prefs_time;
    public static Preferences prefs_music;
    public static Preferences prefs_ads;
    public static Preferences tutorial1;
    public static Preferences tutorial2;
    public static Preferences tutorial3;
    public static Preferences tutorial4;
    public static Preferences tutorial5;
    public static Preferences tutorial6;
    public static Preferences tutorial7;
    public static Preferences tutorial8;
    public static Preferences duoscore1;
    public static Preferences duoscore2;
    public static Preferences extremepause;
    public static Preferences duogames;
    public static Preferences iOSUploadScore;
    public static Preferences prefs;
    public static Preferences userBrownies;
    public static Preferences firstTime;
    public static Preferences unlockedCharacters;
    public static Preferences unlockedSpecialCharacters;
    public static Preferences currentCharacter;

    //achievement preferences
    public static Preferences classicOverallProgress;
    public static Preferences classicCurrentProgress;
    public static Preferences mirrorOverallProgress;
    public static Preferences mirrorCurrentProgress;
    public static Preferences blindOverallProgress;
    public static Preferences blindCurrentProgress;
    public static Preferences burstOverallProgress;
    public static Preferences burstCurrentProgress;
    public static Preferences doubleOverallProgress;
    public static Preferences doubleCurrentProgress;
    public static Preferences extremeFlipOverallProgress;
    public static Preferences extremeFlipCurrentProgress;
    public static Preferences classicCompleted;
    public static Preferences mirrorCompleted;
    public static Preferences blindCompleted;
    public static Preferences burstCompleted;
    public static Preferences doubleCompleted;
    public static Preferences extremeFlipCompleted;
    public static Preferences classicCurrent;
    public static Preferences mirrorCurrent;
    public static Preferences blindCurrent;
    public static Preferences burstCurrent;
    public static Preferences doubleCurrent;
    public static Preferences extremeFlipCurrent;
    public static Preferences classicSkipped;
    public static Preferences mirrorSkipped;
    public static Preferences blindSkipped;
    public static Preferences burstSkipped;
    public static Preferences doubleSkipped;
    public static Preferences classicGames;
    public static Preferences mirrorGames;
    public static Preferences blindGames;
    public static Preferences burstGames;
    public static Preferences doubleGames;
    public static Preferences updatePopup;
    public static Preferences characterIndex;


    public static Sprite dnumber1;
    public static Sprite dnumber2;
    public static Sprite dnumber3;
    public static Sprite dnumber4;
    public static Sprite duoreset;
    public static Sprite duoreset2;
    public static Sprite scoredigit1; //mains screen highscore digits
    public static Sprite scoredigit2;
    public static Sprite scoredigit3;
    public static Sprite scoredigit4;
    public static Sprite soundsprite;
    public static Sprite music;
    public static Sprite h1; //extreme mode sprites;
    public static Sprite h2; //extreme mode sprites;
    public static Sprite h3; //extreme mode sprites;
    public static Sprite h4; //extreme mode sprites;
    public static Sprite h5; //extreme mode sprites;
    public static Sprite h6; //extreme mode sprites;
    public static Sprite h7; //extreme mode sprites;
    public static Sprite h8; //extreme mode sprites;
    public static Sprite h9; //extreme mode sprites;
    public static Sprite h10; //extreme mode sprites;
    public static Sprite h11; //extreme mode sprites;
    public static Sprite h12; //extreme mode sprites;
    public static Sprite tie2;
    public static Sprite gamesdigit1; //main screen games played digits
    public static Sprite gamesdigit2;
    public static Sprite gamesdigit3;
    public static Sprite gamesdigit4;
    public static Sprite game_name;
    public static Sprite sprite4;
    public static Sprite sprite5;
    public static Sprite sprite6;
    public static Sprite sprite7;
    public static Sprite sprite8;
    public static Sprite sprite9;
    public static Sprite setting;
    public static Sprite infosprite;
    public static Sprite leadersprite;
    public static Sprite deathleader;
    public static Sprite likesprite;
    public static Sprite instagram;
    public static Sprite facebook;
    public static Sprite noads;
    public static Sprite modelabel;
    public static Sprite homesprite;
    public static Sprite modetitle;
    public static Sprite classicsprite;
    public static Sprite mirrorsprite;
    public static Sprite double2sprite;
    public static Sprite extremesprite;
    public static Sprite extremefsprite;
    public static Sprite duosprite;
    public static Sprite burstsprite;
    public static Sprite gmirror;
    public static Sprite credit_sprite;
    public static Sprite blindsprite;
    public static Sprite replaysprite;
    public static Sprite sharesprite;
    public static Sprite dividersprite;
    public static Sprite doublenamme;
    public static Sprite burstnamme;
    public static Sprite mirrornamme;
    public static Sprite blindnamme;
    public static Sprite extremeflipname;
    public static Sprite settingstitle;
    public static Sprite ratesprite;
    public static Sprite deathrate;
    public static Sprite dhsprite;
    public static Sprite deathhome;
    public static Texture name;
    public static Sprite namesprite;
    public static Sprite nnamesprite;
    public static Sprite wnamesprite;
    public static Sprite anamesprite;
    public static Sprite tnamesprite;
    public static Sprite p1sprite;
    public static Sprite p2sprite;
    public static Sprite statspage;
    public static Sprite wins;
    public static Sprite loses;
    public static Sprite tie;
    public static Sprite normalsprite;
    public static Sprite woesprite;
    public static Sprite abysssprite;
    public static Sprite tormentsprite;
    public static Sprite companyname;
    public static Sprite pause;
    public static Sprite classictutorial;
    public static Sprite mirrortutorial;
    public static Sprite blindtutorial;
    public static Sprite bursttutorial;
    public static Sprite doubletutorial;
    public static Sprite extremetutorial;
    public static Sprite extremefliptutorial;
    public static Sprite duotutorial;
    public static Sprite gotit;
    public static Sprite tutorialtitle;
    public static Sprite fingertap;
    public static Sprite fingertap2;
    public static Sprite classicinstruction;
    public static Sprite mirrorinstruction;
    public static Sprite burstinstruction;
    public static Sprite blindinstruction;
    public static Sprite doubleinstruction1;
    public static Sprite doubleinstruction2;
    public static Sprite extremeinstruction;
    public static Sprite extremeflipinstruction1;
    public static Sprite extremeflipinstruction2;
    public static Sprite duoinstruction1;
    public static Sprite duoinstruction2;
    public static Sprite doubleline;
    public static Sprite pausehome;
    public static Sprite pauseresume;
    public static Sprite pausehowto;
    public static Sprite duopausehome;
    public static Sprite duopauseresume;
    public static Sprite duopausehowto;
    public static Sprite countone;
    public static Sprite counttwo;
    public static Sprite countthree;
    public static Sprite duosetting;
    public static Sprite redsquare;
    public static Sprite greensquare;
    public static Sprite fadedball;
    public static Sprite deathbox;
    public static Sprite checkbox;
    public static Sprite checkbox2;
    public static Sprite checktext1;
    public static Sprite checktext2;
    public static Sprite checkmark;
    public static Sprite statstitle;
    public static Sprite greencurve;
    public static Sprite redcurve;
    public static Sprite purplecurve;
    public static Sprite yellowcurve;
    public static Sprite leftball; //left half ball
    public static Sprite rightball; //right half ball
    public static Sprite blindleftball; //left hall ball for blind mode
    public static Sprite blindrightball; //right half ball for blind mode
    public static Sprite secondleftball; //second left ball for modes
    public static Sprite secondrightball; //second right ball for modes;
    public static Sprite reflection; //game title
    public static Sprite ball; //ball for main screen
    public static Sprite ball2; //ball for other game modes
    public static Sprite blindball; //ball for blind set screen
    public static Sprite signedIn; //game services signed in icon
    public static Sprite signedOut; //game services signed out icon
    public static Sprite tutorialball; //blue and red tutorial ball
    public static Sprite blindtutorialball; //tutorial ball for blind mode
    public static Sprite doubletutoriaball; //secondtutorialball
    public static Sprite heart; // watch 30 second video to resume
    public static Sprite companyLogo;
    public static Sprite companyName;
    public static Sprite exitButton;
    public static Sprite progressCircle;
    public static Sprite randomizeButton;
    public static Sprite fastforwardButton;
    public static Sprite progressText;
    public static Sprite popupScreen;
    public static Sprite achievementBoard;
    public static Sprite progressBox;
    public static Sprite screenOverlay;
    public static Sprite classicModeIcon;
    public static Sprite mirrorModeIcon;
    public static Sprite blindModeIcon;
    public static Sprite burstModeIcon;
    public static Sprite doubleModeIcon;
    public static Sprite extremeModeIcon;
    public static Sprite extremeFlipModeIcon;
    public static Sprite duoModeIcon;
    public static Sprite classicName;
    public static Sprite mirrorName;
    public static Sprite blindName;
    public static Sprite burstName;
    public static Sprite doubleName;
    public static Sprite extremeName;
    public static Sprite extremeFlipName;
    public static Sprite duoName;
    public static Sprite scoreBox1;
    public static Sprite whiteBox1;
    public static Sprite blackStar1;
    public static Sprite blackStar2;
    public static Sprite blackStar3;
    public static Sprite blackStar4;
    public static Sprite blackStar5;
    public static Sprite blackStar6;
    public static Sprite goldstar1;
    public static Sprite goldstar2;
    public static Sprite goldstar3;
    public static Sprite goldstar4;
    public static Sprite goldstar5;
    public static Sprite goldstar6;
    public static Sprite whiteBubble1;
    public static Sprite whiteBubble2;
    public static Sprite whiteBubble3;
    public static Sprite whiteBubble4;
    public static Sprite whiteBubble5;
    public static Sprite whiteBubble6;
    public static Sprite whiteBubble7;
    // animation Sprites
    public static Sprite blueWall;
    public static Sprite redWall;
    public static Sprite burstBall;
    public static Sprite Clasiclogo;
    public static Sprite duoBar;
    public static Sprite animationMirror;
    public static Sprite mirrorBall;
    public static Sprite stickman1;
    public static Sprite stickman2;
    public static Sprite versus;
    public static Sprite classicnamme;
    public static Sprite gameModeIcon;
    public static Sprite redFireLeft;
    public static Sprite redFireRight;
    public static Sprite goldenBrownie;
    public static Sprite moneyBox;
    public static Sprite checkButton;
    public static Sprite flower1;
    public static Sprite flower2;
    public static Sprite burstLines;
    public static Sprite burstCloud1;
    public static Sprite burstCloud2;
    public static Sprite doubleBall1;
    public static Sprite doubleBall2;
    public static Sprite doubleBall3;
    public static Sprite blackBoard;
    public static Sprite extremeFlipBall;
    public static Sprite blindBall;
    public static Sprite blindCane;
    public static Sprite blindMan;
    public static Sprite blueArrow;
    public static Sprite extremeTachometer;

    //store popup
    public static Sprite storePage;
    public static Sprite storeTitle;
    public static Sprite storeButton1;
    public static Sprite storeButton2;
    public static Sprite storeButton3;
    public static Sprite storeButton4;
    public static Sprite storeButton5;
    public static Sprite saleBanner1;
    public static Sprite saleBanner2;
    public static Sprite saleBanner3;
    public static Sprite saleBanner4;
    public static Sprite saleBanner5;
    public static Sprite sale1;
    public static Sprite sale10;
    public static Sprite sale25;
    public static Sprite sale100;
    public static Sprite sale500;
    public static Sprite mostPopular;
    public static Sprite brownie1;
    public static Sprite brownie10;
    public static Sprite brownie25;
    public static Sprite brownie100;
    public static Sprite brownie500;
    public static Sprite achievementBanner;
    public static Sprite achievementStars;
    public static Sprite achievementUnlocked;
    public static Sprite tv;

    //updatePopup
    public static Sprite updateBoard;
    public static Sprite updates;
    public static Sprite updateCheck;
    public static Sprite updateTitle;
    public static Sprite updateStar;
    public static Sprite updateBrownie;

    //charactershop
    public static Calendar calendar;
    public static float shopY;
    public static boolean openShop;
    public static Sprite shopIcon;
    public static Sprite characterShopPage;
    public static Sprite characterShopBar;
    public static Sprite characterShopTitle;
    public static Sprite characterShopNotUsing1;
    public static Sprite characterShopUsing;
    public static Sprite characterShopTitleBar;
    public static Sprite classicDisplay;
    public static Sprite flowerDisplay;
    public static Sprite timeBar;
    public static Sprite specialTitle;
    public static Sprite butterflyDisplay;
    public static Sprite arrowDisplay;
    public static Sprite crownDisplay;
    public static Sprite personDisplay;
    public static Sprite heartDisplay;
    public static Sprite volleyballDisplay;
    public static Sprite soccerballDisplay;
    public static Sprite weightDisplay;
    public static Sprite catDisplay;
    public static Sprite burgerDisplay;
    public static Sprite smileyDisplay;
    public static Sprite dogPawDisplay;
    public static Sprite deerDisplay;
    public static Sprite gingerbreadDisplay;
    public static Sprite classicQuote;
    public static Sprite flowerQuote;
    public static Sprite butterflyQuote;
    public static Sprite arrowQuote;
    public static Sprite crownQuote;
    public static Sprite personQuote;
    public static Sprite heartQuote;
    public static Sprite volleyballQuote;
    public static Sprite soccerballQuote;
    public static Sprite weightQuote;
    public static Sprite catQuote;
    public static Sprite burgerQuote;
    public static Sprite smileyQuote;
    public static Sprite dogPawQuote;
    public static Sprite deerQuote;
    public static Sprite gingerQuote;

    //StartScreen characters
    public static Sprite flowerStart;
    public static Sprite butterflyStart;
    public static Sprite arrowStart;
    public static Sprite crownStart;
    public static Sprite personStart;
    public static Sprite heartStart;
    public static Sprite volleyballStart;
    public static Sprite soccerballStart;
    public static Sprite weightStart;
    public static Sprite catStart;
    public static Sprite burgerStart;
    public static Sprite smileyStart;
    public static Sprite dogPawStart;
    public static Sprite deerStart;
    public static Sprite gingerbreadStart;


    //Integers

    public static int direction; //direction of ball movement ,1 = right, 2  = left
    public static int times_hit_wall;
    public static int widthspeed;//speed dependent on the width of the phone
    public static int speed;//speed of the ball
    public static int position_x; //position of the ball on the x_axis
    public static int side_random;
    public static int ball_random;
    public static int arc_left_id; //int representing color of circle
    public static int arc_right_id; // int representing color of arc
    public static int left_id; //int representing color of left side
    public static int right_id; //int representing color of right side
    public static int id;
    public static int arc_degree_1;
    public static int arc_degree_2;
    public static int side;
    public static int w, h; //width and height of phone
    public static int x, y;  //coordinates of touch
    public static int screen;
    public static int zero_to_one;
    public static int cycle; //cycle of the game
    public static int score;
    public static int highscore;
    public static int diamonds;
    public static int rounds_played;
    public static int total_wallhit;
    public static int prefscore;
    public static int zero_to_three;
    public static int loop;
    public static int name_font_width;
    public static int highscore_font_width;
    public static int touch_font_width;
    public static int arc_width;
    public static int deltaX;
    public static int deltaY;
    public static int mode;
    public static int speed_increase;
    public static int balls;
    public static int burstcount;
    public static int score1;
    public static int score2;
    public static boolean onedead;
    public static boolean twodead;
    public static boolean shouldtime;
    public static boolean yloop;
    public static int duobefore;
    public static float halfheight;
    public static float halfwidth;
    public static int halfloop; //loop to assign new texture to player's ball
    public static int ballposition;
    public static int playerscoreloop; // loop to assign new texture to player's score
    public static int mainscoreloop; //loop to assign new textures to main screen gamesplayed + highscore
    public static int ball_x; //home screen ball's x coordinate
    public static int ball_y; //home screen ball's y coordinate
    public static int eventLoop; // loop to submit firebase event
    public static int screenLoop; //loop to submit new screenview
    public static int statsWidth;
    public static int statsHeight;
    public static float logoX;
    public static float logoY;
    public static int modeClicked;
    //achievement Variables
    public static int requirement;
    public static int flipCount;
    public static int throughCount;
    public static int bounceCount;
    public static int achievementIndex;
    public static int matchCount;
    public static boolean wasReflected;
    public static int blindColourCount;
    public static int burstColourCount;
    public static int burstScoreCount;
    public static int burstOccurCount;
    public static boolean sideTap;
    public static int doubleDie;
    public static int doubleColour;
    public static int doubleColour2;
    public static int[] achievementCumulatives;
    public static long achievementTime;
    public static long achievementStartTime;
    public static long bannerDropTime;
    public static float bannerY;
    public static boolean showBanner;
    public static GlyphLayout achievementLayout;
    public static boolean showUpdate;
    public static int specialCount;
    public static Texture ballTexture;
    public static boolean mirrorThrough;
    public static int finishedScore;
    public static int sideTapScore;
    public static int finishedBefore;


    //Font
    public static BitmapFont score_font;
    public static BitmapFont stats_font;
    public static BitmapFont highscore_font;
    public static BitmapFont best_font;
    public static BitmapFont writing_font;
    public static BitmapFont best_score_font;
    public static BitmapFont progressFont;
    public static BitmapFont duo_tally_font;
    public static BitmapFont achievementFont;
    public static BitmapFont percentageFont;
    public static BitmapFont pricingFont;
    public static BitmapFont timeFont;
    public static Matrix4 mx4Font = new Matrix4();
    public static SpriteBatch spriteFont;


    //Strings
    public static String score_string;
    public static String title;
    public static String type;

    //Others
    public static ShapeRenderer shapeRenderer;
    public static Random random;
    public static Sound bounce;
    public static Music death;
    public static Music musicsound;
    public static SpriteBatch batch;
    public static Sprite logo;
    public static MyGestureListener gesutre = new MyGestureListener();
    public static GestureDetector g = new GestureDetector(gesutre);

    //long
    public static long modeScreenTime;
    public static long pausetime;
    public static long start;
    public static long waittime;// pauses screen after death
    public static int adgames;
    public static int restarted; //if player alreayd restarted once
    public static float bestWidth;
    public static Texture chain;
    public static Texture blackstar;
    public static Texture goldstar;
    public static TextureRegion[] region = new TextureRegion[2];
    public static boolean openAchievement;
    public static boolean openStore;
    public static float boxWidth;
    public static float boxHeight;
    public static int fireDirection;
    public static GlyphLayout glyphLayout;
    public static GlyphLayout percentageLayout;
    public static GlyphLayout moneyLayout;
    public static GlyphLayout homeScoreLayout;
    public static GlyphLayout homeGamesLayout;
    public static GlyphLayout progressLayout;
    public static GlyphLayout characterPricing;
    public static GlyphLayout timeLayout;
    public static int[] charactersBought;
    public static boolean specialSale;
    public static String[] characterName;
    public static ArrayList<String> allNames;

    //public static boolean loaded;//if video ad is loaded
    public static int[] classicValues;


    public static void createVariables() {
        //Scaling
        glyphLayout = new GlyphLayout();
        percentageLayout = new GlyphLayout();
        moneyLayout = new GlyphLayout();
        homeScoreLayout = new GlyphLayout();
        homeGamesLayout = new GlyphLayout();
        progressLayout = new GlyphLayout();
        achievementLayout = new GlyphLayout();
        characterPricing = new GlyphLayout();
        timeLayout = new GlyphLayout();
        start = System.currentTimeMillis();
        adgames = 0;
        loopone = true;
        paused = false;
        highscore_reach = true;
        mirrorThrough = false;
        doubleColour = 0;
        doubleColour2 = 0;
        sideTapScore = 0;
        finishedBefore = 0;

        // blind1 = new Texture(Gdx.files.internal("blindone"));
        //Preferences
        characterIndex = Gdx.app.getPreferences("characterIndex");
        unlockedCharacters = Gdx.app.getPreferences("unlockedCharacters");
        unlockedSpecialCharacters = Gdx.app.getPreferences("unlockedSpecialCharacters");
        currentCharacter = Gdx.app.getPreferences("currentCharacter");
        classicGames = Gdx.app.getPreferences("classicGames");
        mirrorGames = Gdx.app.getPreferences("mirrorGames");
        blindGames = Gdx.app.getPreferences("blindGames");
        burstGames = Gdx.app.getPreferences("burstGames");
        doubleGames = Gdx.app.getPreferences("doubleGames");
        prefs_score = Gdx.app.getPreferences("My Preferences");
        prefs_games = Gdx.app.getPreferences("Preferences");
        prefs_wallhit = Gdx.app.getPreferences("IPreferences");
        prefs_sound = Gdx.app.getPreferences("SPreferences");
        prefs_score2 = Gdx.app.getPreferences("Preferences2");
        prefs_score3 = Gdx.app.getPreferences("references");
        prefs_score4 = Gdx.app.getPreferences("y Preferences");
        prefs_score5 = Gdx.app.getPreferences("eferences");
        prefs_score63 = Gdx.app.getPreferences("ferences"); //extreme normal
        prefs_score64 = Gdx.app.getPreferences("fferences"); //extreme woe
        prefs_score65 = Gdx.app.getPreferences("ffferences"); //extreme abyss
        prefs_score66 = Gdx.app.getPreferences("fffferences"); //extreme torment
        prefs_score7 = Gdx.app.getPreferences("erences");
        prefs_score8 = Gdx.app.getPreferences("rences");
        //blind2 = new Texture(Gdx.files.internal("blindtwo"));
        prefs_music = Gdx.app.getPreferences("music1");
        prefs_ads = Gdx.app.getPreferences("a");
        tutorial1 = Gdx.app.getPreferences("1");
        tutorial2 = Gdx.app.getPreferences("2");
        tutorial3 = Gdx.app.getPreferences("3");
        tutorial4 = Gdx.app.getPreferences("4");
        tutorial5 = Gdx.app.getPreferences("5");
        tutorial6 = Gdx.app.getPreferences("6");
        tutorial7 = Gdx.app.getPreferences("7");
        //blind3 = new Texture(Gdx.files.internal("blindthree"));
        tutorial8 = Gdx.app.getPreferences("8");
        duoscore1 = Gdx.app.getPreferences("score1");
        duoscore2 = Gdx.app.getPreferences("score2");
        extremepause = Gdx.app.getPreferences("pause");
        duogames = Gdx.app.getPreferences("games");
        iOSUploadScore = Gdx.app.getPreferences("uploaded");
        prefs = Gdx.app.getPreferences("classicValues");
        userBrownies = Gdx.app.getPreferences("brownies");
        classicCompleted = Gdx.app.getPreferences("classicCompleted");
        mirrorCompleted = Gdx.app.getPreferences("mirrorCompleted");
        blindCompleted = Gdx.app.getPreferences("blindCompleted");
        burstCompleted = Gdx.app.getPreferences("burstCompleted");
        doubleCompleted = Gdx.app.getPreferences("doubleCompleted");
        extremeFlipCompleted = Gdx.app.getPreferences("extremeFlipCompleted");
        classicOverallProgress = Gdx.app.getPreferences("classicOverall");
        classicCurrentProgress = Gdx.app.getPreferences("classicCurrentProgress");
        mirrorOverallProgress = Gdx.app.getPreferences("mirrorOverall");
        mirrorCurrentProgress = Gdx.app.getPreferences("mirrorCurrentProgress");
        blindOverallProgress = Gdx.app.getPreferences("blindOverall");
        blindCurrentProgress = Gdx.app.getPreferences("blindCurrentProgress");
        burstOverallProgress = Gdx.app.getPreferences("burstOverall");
        burstCurrentProgress = Gdx.app.getPreferences("burstCurrentProgress");
        doubleOverallProgress = Gdx.app.getPreferences("doubleOverall");
        doubleCurrentProgress = Gdx.app.getPreferences("doubleCurrentProgress");
        extremeFlipOverallProgress = Gdx.app.getPreferences("extremeFlipOverall");
        extremeFlipCurrentProgress = Gdx.app.getPreferences("extremeFlipCurrentProgress");
        classicCurrent = Gdx.app.getPreferences("classicCurrent");
        mirrorCurrent = Gdx.app.getPreferences("mirrorCurrent");
        blindCurrent = Gdx.app.getPreferences("blindCurrent");
        burstCurrent = Gdx.app.getPreferences("burstCurrent");
        doubleCurrent = Gdx.app.getPreferences("doubleCurrent");
        extremeFlipCurrent = Gdx.app.getPreferences("extremeFlipCurrent");
        classicSkipped = Gdx.app.getPreferences("classicSkipped");
        mirrorSkipped = Gdx.app.getPreferences("mirrorSkipped");
        blindSkipped = Gdx.app.getPreferences("blindSkipped");
        burstSkipped = Gdx.app.getPreferences("burstSkipped");
        doubleSkipped = Gdx.app.getPreferences("doubleSkipped");
        firstTime = Gdx.app.getPreferences("firstTime");
        updatePopup = Gdx.app.getPreferences("updatePopup");
        if (!firstTime.getBoolean("firstTime")) {//firstTime opening app
            //System.out.println("in first");
            userBrownies.clear();
            userBrownies.putInteger("brownies", 10);
            userBrownies.flush();
            classicOverallProgress.putString("classicOverall", "0000000000000000000000000");
            classicOverallProgress.flush();
            mirrorOverallProgress.putString("mirrorOverall", "0000000000000000000000000");
            mirrorOverallProgress.flush();
            blindOverallProgress.putString("blindOverall", "0000000000000000000000000");
            blindOverallProgress.flush();
            burstOverallProgress.putString("burstOverall", "0000000000000000000000000");
            burstOverallProgress.flush();
            doubleOverallProgress.putString("doubleOverall", "0000000000000000000000000");
            doubleOverallProgress.flush();
            extremeFlipOverallProgress.putString("extremeFlipOverall", "0000000000000000000000000");
            extremeFlipOverallProgress.flush();
            unlockedCharacters.putString("unlockedCharacters", "10000000000000");
            unlockedCharacters.flush();
            currentCharacter.putString("currentCharacter", "classicBall");
            currentCharacter.flush();
            characterIndex.putInteger("characterIndex", 1);
            characterIndex.flush();
            unlockedSpecialCharacters.putString("unlockedSpecialCharacters", "0");
            unlockedSpecialCharacters.flush();
            firstTime.clear();
            firstTime.putBoolean("firstTime", true);
            firstTime.flush();
        }
        //System.out.println(classicOverallProgress.getString("classicOverall"));
        for (int i = 0; i < 25; i++) {
            classicProgress[i] = Integer.parseInt(classicOverallProgress.getString("classicOverall").substring(i, i + 1));
            mirrorProgress[i] = Integer.parseInt(mirrorOverallProgress.getString("mirrorOverall").substring(i, i + 1));
            blindProgress[i] = Integer.parseInt(blindOverallProgress.getString("blindOverall").substring(i, i + 1));
            burstProgress[i] = Integer.parseInt(burstOverallProgress.getString("burstOverall").substring(i, i + 1));
            doubleProgress[i] = Integer.parseInt(doubleOverallProgress.getString("doubleOverall").substring(i, i + 1));
            extremeFlipProgress[i] = Integer.parseInt(extremeFlipOverallProgress.getString("extremeFlipOverall").substring(i, i + 1));
        }
        //blind4 = new Texture(Gdx.files.internal("blindfour"));


        //Integers
        requirement = 0;
        position_x = w / 2;
        direction = 1;
        arc_left_id = 5;
        arc_right_id = 1;
        left_id = 5;
        right_id = 1;
        arc_degree_2 = 270;
        arc_degree_1 = 90;
        w = Gdx.graphics.getWidth();
        //blind5 = new Texture(Gdx.files.internal("blindfive"));
        h = Gdx.graphics.getHeight();
        name_font_width = 30;
        highscore_font_width = 10;
        touch_font_width = 8;
        cycle = 1;
        score = 0;
        zero_to_one = 0;
        screen = 0;
        zero_to_three = 0;
        loop = 0;
        playerscoreloop = 0;
        mainscoreloop = 0;
        halfloop = 0;
        arc_width = w / 11;
        //blind6 = new Texture(Gdx.files.internal("blindsix"));
        deltaX = 0;
        deltaY = 0;
        mode = 0;
        speed_increase = 10;
        balls = 0;
        burstcount = 0;
        shouldtime = false;
        score1 = 0;
        score2 = 0;
        duobefore = 0;
        ballposition = w / 22;
        ball_x = w / 2;
        ball_y = h / 2;
        eventLoop = 0;
        screenLoop = 0;
        statsWidth = w;
        statsHeight = (h * 2) / 3;
        bestWidth = 0;
        //achievement Variables
        flipCount = 0;
        throughCount = 0;
        bounceCount = 0;
        type = "";
        achievementIndex = 0;
        matchCount = 0;
        wasReflected = false;
        sideTap = true;
        showBanner = false;
        showUpdate = false;
        finishedScore = 0;

        //blind7 = new Texture(Gdx.files.internal("blindseven"));

        //Sprites
        sprites.get("sound").scale((((1) * (w)) / ((6) * (sprites.get("sound").getWidth()))) - 1);
        sprites.get("mute").scale((((1) * (w)) / ((6) * (sprites.get("mute").getWidth()))) - 1);
        sprites.get("music").scale((((1) * (w)) / ((6) * (sprites.get("music").getWidth()))) - 1);
        sprites.get("mmute").scale((((1) * (w)) / ((6) * (sprites.get("mmute").getWidth()))) - 1);
        if (prefs_sound.getInteger("sound") == 2) {
            soundsprite = sprites.get(("mute"));
        } else {
            soundsprite = sprites.get((("sound")));
        }
        if (prefs_music.getInteger("music") == 2) {
            music = sprites.get((("mmute")));
        } else {
            music = sprites.get((("music")));
        }//
        tie2 = new Sprite(sprites.get((("tie"))));
        tie2.scale((((w)) / ((2) * (tie2.getWidth()))) - 1);
        tie2.setRotation(180);
        checktext1 = sprites.get((("extremepause")));
        checktext1.scale((((w)) / ((2) * (checktext1.getWidth()))) - 1);
        checktext2 = sprites.get((("duopause")));
        checktext2.scale((((w)) / ((4) * (checktext2.getWidth()))) - 1);
        checkbox = sprites.get((("checkbox")));
        checkbox.scale((((w)) / ((20) * (checkbox.getWidth()))) - 1);
        checkmark = sprites.get((("checkmark")));
        checkmark.scale((((w)) / ((20) * (checkmark.getWidth()))) - 1);
        fadedball = sprites.get((("fadedball")));
        fadedball.scale((((w)) / ((fadedball.getWidth()))) - 1);
        deathbox = sprites.get((("deathbox")));
        deathbox.scale((((2) * (w)) / ((3) * (deathbox.getWidth()))) - 1);
        redsquare = sprites.get((("redsquare")));
        redsquare.scale((((1) * (w)) / ((5) * (redsquare.getWidth()))) - 1);
        greensquare = sprites.get((("greensquare")));
        greensquare.scale((((1) * (w)) / ((5) * (greensquare.getWidth()))) - 1);
        countone = sprites.get((("one")));
        counttwo = sprites.get((("two")));
        countthree = sprites.get((("three")));
        countone.scale((((h)) / ((4) * (countone.getHeight()))) - 1);
        counttwo.scale((((h)) / ((4) * (counttwo.getHeight()))) - 1);
        countthree.scale((((h)) / ((4) * (countthree.getHeight()))) - 1);
        gotit = sprites.get((("gotit")));
        gotit.scale((((w)) / ((2) * (gotit.getWidth()))) - 1);
        pause = sprites.get((("pause")));
        pause.scale((((1) * (w)) / ((9) * (pause.getWidth()))) - 1);
        companyname = sprites.get((("companyname2")));
        companyname.scale((((3) * (w)) / ((3) * (companyname.getWidth()))) - 1);
        wins = sprites.get((("wins")));
        wins.scale((((w)) / ((2) * (wins.getWidth()))) - 1);
        loses = sprites.get((("loses")));
        loses.scale((((w)) / ((2) * (loses.getWidth()))) - 1);
        tie = new Sprite(sprites.get((("tie"))));
        tie.scale((((w)) / ((2) * (tie.getWidth()))) - 1);
        //statspage = sprites.get((("stats")));
        //statspage.setSize(w, h * 2 / 3);
        namesprite = sprites.get((("extreme_name")));
        nnamesprite = sprites.get((("normal_name")));
        wnamesprite = sprites.get((("woe_name")));
        anamesprite = sprites.get((("abyss_name")));
        tnamesprite = sprites.get((("torment_name")));
        logo = sprites.get((("logo")));
        logo.scale((((2) * (w)) / ((3) * (logo.getWidth()))) - 1);
        game_name = sprites.get((("game_name")));
        game_name.scale((((2) * (w)) / ((3) * (game_name.getWidth()))) - 1);
        sprite4 = sprites.get((("play")));
        sprite4.scale((((w)) / ((4) * (sprite4.getWidth()))) - 1);
        sprite5 = sprites.get((("played")));
        sprite5.scale((((w)) / ((4) * (sprite5.getWidth()))) - 1);
        sprite5.setOriginCenter();
        sprite6 = sprites.get((("hightext")));
        sprite6.scale((((1) * (w)) / ((4) * (sprite6.getWidth()))) - 1);
        sprite7 = sprites.get((("touch")));
        sprite7.scale((((1) * (w)) / ((5 / 2) * (sprite7.getWidth()))) - 1);
        sprite8 = sprites.get((("best")));
        sprite8.scale((((1) * (w)) / ((5) * (sprite8.getWidth()))) - 1);
        sprite9 = sprites.get((("highscore")));
        sprite9.scale((((1) * (w)) / ((2) * (sprite9.getWidth()))) - 1);
        infosprite = sprites.get((("info")));
        infosprite.scale((((1) * (w)) / ((7) * (infosprite.getWidth()))) - 1);
        noads = sprites.get((("noads")));
        noads.scale((((1) * (w)) / ((6) * (noads.getWidth()))) - 1);
        //soundsprite.scale((((1) * (w)) / ((6) * (soundsprite.getWidth()))) - 1);
        facebook = sprites.get((("facebook")));
        facebook.scale((((1) * (w)) / ((6) * (facebook.getWidth()))) - 1);
        instagram = sprites.get((("instagram")));
        instagram.scale((((1) * (w)) / ((6) * (instagram.getWidth()))) - 1);
        //music.scale((((1) * (w)) / ((6) * (music.getWidth()))) - 1);
        sprites.get("settings").scale((((1) * (w)) / ((7) * (sprites.get("settings").getWidth()))) - 1);
        setting = sprites.get((("settings")));
        setting.setOriginCenter();
        setting.rotate(180);
        //setting.scale((w / (6 * setting.getWidth())) - 1);
        leadersprite = new Sprite(sprites.get((("leader"))));
        leadersprite.scale((((1) * (w)) / ((7) * (leadersprite.getWidth()))) - 1);
        likesprite = sprites.get((("like")));
        likesprite.scale((((1) * (w)) / ((7) * (likesprite.getWidth()))) - 1);
        ratesprite = sprites.get((("rate")));
        ratesprite.scale((((1) * (w)) / ((7) * (ratesprite.getWidth()))) - 1);
        dhsprite = sprites.get((("dead_home")));
        //dhsprite.scale((((1) * (w)) / ((7) * (dhsprite.getWidth()))) - 1);
        dhsprite.setSize(w / 6, w / 6);
        dhsprite.setOriginCenter();
        deathrate = sprites.get((("drate")));
        deathrate.scale((((1) * (w)) / ((6) * (deathrate.getWidth()))) - 1);
        // deathhome = sprites.get((("dead_home")));
        //deathhome.scale((((1) * (w)) / ((6) * (deathhome.getWidth()))) - 1);
        //deathhome.setSize(w / 6, w / 6);
        deathleader = new Sprite(sprites.get((("leader"))));
        deathleader.scale((((1) * (w)) / ((6) * (deathleader.getWidth()))) - 1);
        //classicsprite = sprites.get((("classic")));
        //mirrorsprite = sprites.get((("mirror")));
        //double2sprite = sprites.get((("double")));
        //extremesprite = sprites.get((("extreme")));
        //extremefsprite = sprites.get((("extremeflip")));
        //blindsprite = sprites.get((("color_blind")));
        //duosprite = sprites.get((("duo")));
        //burstsprite = sprites.get((("burst")));
        //classicsprite.setScale((((4) * (w)) / ((7) * (classicsprite.getWidth()))));
        //mirrorsprite.setScale((((4) * (w)) / ((7) * (mirrorsprite.getWidth()))));
        //double2sprite.setScale((((4) * (w)) / ((7) * (double2sprite.getWidth()))));
        //extremesprite.setScale((((4) * (w)) / ((7) * (extremesprite.getWidth()))));
        //extremefsprite.setScale((((4) * (w)) / ((7) * (extremefsprite.getWidth()))));
        //duosprite.setScale((((4) * (w)) / ((7) * (duosprite.getWidth()))));
        //burstsprite.setScale((((4) * (w)) / ((7) * (burstsprite.getWidth()))));
        //blindsprite.setScale((((4) * (w)) / ((7) * (blindsprite.getWidth()))));
        homesprite = sprites.get((("home_button")));
        homesprite.scale((((1) * (w)) / ((8) * (homesprite.getWidth()))) - 1);
        modelabel = sprites.get((("game_modes")));
        modelabel.scale((w / (2 * (modelabel.getWidth()))) - 1);
        modetitle = sprites.get((("modetitle")));
        modetitle.setSize((Variables.w), (Variables.h) / 7);
        settingstitle = sprites.get((("settingstitle")));
        settingstitle.setSize((Variables.w), (Variables.h) / 7);
        tutorialtitle = sprites.get((("howto2")));
        tutorialtitle.setSize((Variables.w * 11) / 12, (Variables.h * 7) / 52);
        statstitle = sprites.get((("playerstats")));
        statstitle.setSize((Variables.w), (Variables.h) / 6);
        greencurve = sprites.get((("greencurve")));
        greencurve.setSize((Variables.w), (Variables.h) / 5);
        redcurve = sprites.get((("redcurve")));
        redcurve.setSize((Variables.w), (Variables.h) / 5);
        purplecurve = sprites.get((("purplecurve")));
        purplecurve.setSize((Variables.w), (Variables.h) / 5);
        yellowcurve = sprites.get((("yellowcurve")));
        yellowcurve.setSize((Variables.w), (Variables.h) / 5);
        credit_sprite = sprites.get((("kyle_credits")));
        credit_sprite.setSize((3 * w) / 4, h / 4);
        gmirror = sprites.get((("gold_mirror")));
        gmirror.setSize(w / 50, h / 3);
        replaysprite = sprites.get((("replay")));
        replaysprite.scale((w / (5 * (replaysprite.getWidth()))) - 1);
        replaysprite.setOriginCenter();
        //heart = sprites.get((("heartReplay")));
        //heart.scale((w / (5 * (heart.getWidth()))) - 1);
        //heart.setOriginCenter();
        dividersprite = sprites.get((("divider")));
        dividersprite.setSize((2 * w) / 3, h / 40);
        mirrornamme = sprites.get((("mirror_name")));
        burstnamme = sprites.get((("burst_name")));
        blindnamme = sprites.get((("blind_name")));
        doublenamme = sprites.get((("double_name")));
        extremeflipname = sprites.get((("extremeflip_name")));
        mirrornamme.scale((((2) * (w)) / ((3) * (mirrornamme.getWidth()))) - 1);
        burstnamme.scale((((2) * (w)) / ((3) * (burstnamme.getWidth()))) - 1);
        blindnamme.scale((((2) * (w)) / ((3) * (blindnamme.getWidth()))) - 1);
        doublenamme.scale((((2) * (w)) / ((3) * (doublenamme.getWidth()))) - 1);
        extremeflipname.scale((((2) * (w)) / ((3) * (extremeflipname.getWidth()))) - 1);
        namesprite.scale((((2) * (w)) / ((3) * (namesprite.getWidth()))) - 1);
        sharesprite = sprites.get((("share")));
        sharesprite.scale((((1) * (w)) / ((6) * (sharesprite.getWidth()))) - 1);
        tnamesprite.scale((((2) * (w)) / ((3) * (tnamesprite.getWidth()))) - 1);
        nnamesprite.scale((((2) * (w)) / ((3) * (nnamesprite.getWidth()))) - 1);
        wnamesprite.scale((((2) * (w)) / ((3) * (wnamesprite.getWidth()))) - 1);
        anamesprite.scale((((2) * (w)) / ((3) * (anamesprite.getWidth()))) - 1);
        p1sprite = sprites.get("player1");
        p2sprite = sprites.get("player2");
        p1sprite.scale((((1) * (w)) / ((3) * (p1sprite.getWidth()))) - 1);
        p2sprite.scale((((1) * (w)) / ((3) * (p2sprite.getWidth()))) - 1);
        normalsprite = sprites.get((("normal")));
        woesprite = sprites.get((("woe")));
        abysssprite = sprites.get((("abyss")));
        tormentsprite = sprites.get((("torment")));
        normalsprite.scale((((3) * (w)) / ((4) * (normalsprite.getWidth()))) - 1);
        woesprite.scale((((3) * (w)) / ((4) * (woesprite.getWidth()))) - 1);
        abysssprite.scale((((3) * (w)) / ((4) * (abysssprite.getWidth()))) - 1);
        tormentsprite.scale((((3) * (w)) / ((4) * (tormentsprite.getWidth()))) - 1);
        fingertap = sprites.get((("fingertap")));
        fingertap.scale((((1) * (w)) / ((6) * (fingertap.getWidth()))) - 1);
        fingertap2 = sprites.get((("fingertap")));
        fingertap2.scale((((1) * (w)) / ((6) * (fingertap2.getWidth()))) - 1);
        classicinstruction = sprites.get(("classicinstruction1"));
        mirrorinstruction = sprites.get(("mirrorinstruction2"));
        burstinstruction = sprites.get(("burstinstruction2"));
        blindinstruction = sprites.get(("blindinstruction2"));
        doubleinstruction1 = sprites.get(("doubleinstruction1"));
        doubleinstruction2 = sprites.get(("doubleinstruction2"));
        extremeinstruction = sprites.get(("extremeinstruction1"));
        extremeflipinstruction1 = sprites.get(("extremeflipinstruction1"));
        extremeflipinstruction2 = sprites.get(("extremeflipinstruction2"));
        duoinstruction1 = new Sprite(sprites.get(("duoinstruction2")));
        duoinstruction2 = new Sprite(sprites.get(("duoinstruction2")));
        classicinstruction.scale((((3) * (w)) / ((7) * (classicinstruction.getWidth()))) - 1);
        mirrorinstruction.scale((((5) * (w)) / ((7) * (mirrorinstruction.getWidth()))) - 1);
        burstinstruction.scale((((4) * (w)) / ((7) * (burstinstruction.getWidth()))) - 1);
        blindinstruction.scale((((4) * (w)) / ((7) * (blindinstruction.getWidth()))) - 1);
        doubleinstruction1.scale((((3) * (w)) / ((7) * (doubleinstruction1.getWidth()))) - 1);
        doubleinstruction2.scale((((3) * (w)) / ((7) * (doubleinstruction2.getWidth()))) - 1);
        extremeinstruction.scale((((5) * (w)) / ((7) * (extremeinstruction.getWidth()))) - 1);
        extremeflipinstruction1.scale((((5) * (w)) / ((7) * (extremeflipinstruction1.getWidth()))) - 1);
        extremeflipinstruction2.scale((((3) * (w)) / ((7) * (extremeflipinstruction2.getWidth()))) - 1);
        duoinstruction1.scale((((4) * (w)) / ((7) * (duoinstruction1.getWidth()))) - 1);
        duoinstruction2.scale((((4) * (w)) / ((7) * (duoinstruction2.getWidth()))) - 1);
        duoinstruction1.setRotation(180);
        doubleline = sprites.get("doubleline");
        doubleline.setSize((((h * 8) / 14) / doubleline.getHeight()) * doubleline.getWidth(), (h * 8) / 14);
        duopausehome = sprites.get("duopausehome");
        duopauseresume = sprites.get("duopauseresume");
        duopausehowto = sprites.get("duopausehowto");
        duopauseresume.scale((((1) * (w)) / ((4) * (duopauseresume.getWidth()))) - 1);
        duopausehowto.scale((((1) * (w)) / ((5) * (duopausehowto.getWidth()))) - 1);
        duopausehome.scale((((1) * (w)) / ((5) * (duopausehome.getWidth()))) - 1);
        halfwidth = w / 11;
        halfheight = 2 * halfwidth;

        /*leftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
        leftball.setColor(new Color(32, 87, 245, 1));//blue
        rightball = new Sprite(sprites.get(((currentCharacter.getString("currentCharacter") + "Half"))));
        rightball.setColor(new Color(243, 34, 12, 1));//red
        rightball.flip(true, false);
        blindleftball = new Sprite(sprites.get(((currentCharacter.getString("currentCharacter") + "Half"))));
        blindleftball.setColor(184, 244, 157, 1);//blindsix
        blindrightball = new Sprite(sprites.get(((currentCharacter.getString("currentCharacter") + "Half"))));
        blindrightball.setColor(215, 240, 98, 1);//blindsixteen
        secondleftball = new Sprite(sprites.get(((currentCharacter.getString("currentCharacter") + "Half"))));
        secondleftball.setColor(new Color(243, 34, 12, 1));//red
        secondrightball = new Sprite(sprites.get(((currentCharacter.getString("currentCharacter") + "Half"))));
        secondrightball.setColor(new Color(32, 87, 245, 1));//blue*/

        //ball = sprites.get(currentCharacter.getString("currentCharacter"));

        //blindball = sprites.get((("blindball")));
        //blindball.setSize((w * 2) / 11, (w * 2) / 11);
        //blindball.setOriginCenter();
        reflection = sprites.get((("reflection")));
        reflection.scale((((4) * (w)) / ((5) * (reflection.getWidth()))) - 1);
        signedIn = sprites.get((("signedin")));
        signedOut = sprites.get((("signedout")));
        signedIn.scale((((1) * (w)) / ((3) * (signedIn.getWidth()))) - 1);
        signedOut.scale((((1) * (w)) / ((3) * (signedOut.getWidth()))) - 1);
        tutorialball = sprites.get((("tutorialball")));
        blindtutorialball = sprites.get((("blindtutorialball")));
        doubletutoriaball = sprites.get((("doubletutorialball")));
        tutorialball.setSize((2 * w) / 11, (2 * w) / 11);
        blindtutorialball.setSize((2 * w) / 11, (2 * w) / 11);
        doubletutoriaball.setSize((2 * w) / 11, (2 * w) / 11);
        gamesdigit1 = sprites.get("duozero");
        gamesdigit1.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
        //gamesdigit1.scale((((1) * (w)) / ((11) * (gamesdigit1.getWidth()))) - 1);
        gamesdigit2 = sprites.get("duozero");
        gamesdigit2.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
        //gamesdigit2.scale((((1) * (w)) / ((11) * (gamesdigit2.getWidth()))) - 1);
        gamesdigit3 = sprites.get("duozero");
        gamesdigit3.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
        //gamesdigit3.scale((((1) * (w)) / ((11) * (gamesdigit3.getWidth()))) - 1);
        gamesdigit4 = sprites.get("duozero");
        gamesdigit4.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
        //gamesdigit4.scale((((1) * (w)) / ((11) * (gamesdigit4.getWidth()))) - 1);
        dnumber1 = sprites.get("duozero");
        //dnumber1.scale((((1) * (w)) / ((11) * (dnumber1.getWidth()))) - 1);
        //dnumber1.setRotation(180);
        dnumber2 = sprites.get("duozero");
        // dnumber2.scale((((1) * (w)) / ((11) * (dnumber2.getWidth()))) - 1);
        //dnumber2.setRotation(180);
        dnumber3 = sprites.get(("duozero"));
        //dnumber3.scale((((1) * (w)) / ((11) * (dnumber3.getWidth()))) - 1);
        dnumber4 = sprites.get(("duozero"));
        //dnumber4.scale((((1) * (w)) / ((11) * (dnumber4.getWidth()))) - 1);
        sprites.get("duoreset").scale((w / (12 * (sprites.get("duoreset").getWidth()))) - 1);
        duoreset = sprites.get((("duoreset")));
        duoreset.setOriginCenter();
        duoreset2 = new Sprite((sprites.get("duoreset")));
        duoreset2.setOriginCenter();
        scoredigit1 = sprites.get(("duozero"));
        scoredigit1.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
        //scoredigit1.scale((((1) * (w)) / ((11) * (scoredigit1.getWidth()))) - 1);
        scoredigit2 = sprites.get(("duozero"));
        scoredigit2.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
        //scoredigit2.scale((((1) * (w)) / ((11) * (scoredigit2.getWidth()))) - 1);
        scoredigit3 = sprites.get(("duozero"));
        scoredigit3.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
        //scoredigit3.scale((((1) * (w)) / ((11) * (scoredigit3.getWidth()))) - 1);
        scoredigit4 = sprites.get(("duozero"));
        scoredigit4.setSize(w / 25, sprite9.getBoundingRectangle().getHeight());
        //scoredigit4.scale((((1) * (w)) / ((11) * (scoredigit4.getWidth()))) - 1);
        classicModeIcon = sprites.get("classicModeIcon");
        classicModeIcon.scale((((20) * (w)) / ((21) * (classicModeIcon.getWidth()))) - 1);
        mirrorModeIcon = sprites.get("mirrorModeIcon");
        mirrorModeIcon.scale((((20) * (w)) / ((21) * (mirrorModeIcon.getWidth()))) - 1);
        blindModeIcon = sprites.get("blindModeIcon");
        blindModeIcon.scale((((20) * (w)) / ((21) * (blindModeIcon.getWidth()))) - 1);
        burstModeIcon = sprites.get("burstModeIcon");
        burstModeIcon.scale((((20) * (w)) / ((21) * (burstModeIcon.getWidth()))) - 1);
        doubleModeIcon = sprites.get("doubleModeIcon");
        doubleModeIcon.scale((((20) * (w)) / ((21) * (doubleModeIcon.getWidth()))) - 1);
        extremeModeIcon = sprites.get("extremeModeIcon");
        extremeModeIcon.scale((((20) * (w)) / ((21) * (extremeModeIcon.getWidth()))) - 1);
        extremeFlipModeIcon = sprites.get("extremeflipModeIcon");
        extremeFlipModeIcon.scale((((20) * (w)) / ((21) * (extremeFlipModeIcon.getWidth()))) - 1);
        duoModeIcon = sprites.get("duoModeIcon");
        duoModeIcon.scale((((20) * (w)) / ((21) * (duoModeIcon.getWidth()))) - 1);
        classicName = sprites.get("classicName");
        mirrorName = sprites.get("mirrorName");
        blindName = sprites.get("blindName");
        burstName = sprites.get("burstName");
        doubleName = sprites.get("doubleName");
        extremeName = sprites.get("extremeName");
        extremeFlipName = sprites.get("extremeFlipName");
        duoName = sprites.get("duoName");
        classicName.scale((((8) * (w)) / ((21) * (classicName.getWidth()))) - 1);
        mirrorName.scale((((8) * (w)) / ((21) * (mirrorName.getWidth()))) - 1);
        blindName.scale((((8) * (w)) / ((21) * (blindName.getWidth()))) - 1);
        burstName.scale((((8) * (w)) / ((21) * (burstName.getWidth()))) - 1);
        doubleName.scale((((8) * (w)) / ((21) * (doubleName.getWidth()))) - 1);
        extremeName.scale((((8) * (w)) / ((21) * (extremeName.getWidth()))) - 1);
        extremeFlipName.scale((((8) * (w)) / ((21) * (extremeFlipName.getWidth()))) - 1);
        duoName.scale((((8) * (w)) / ((21) * (duoName.getWidth()))) - 1);
        scoreBox1 = sprites.get("scoreBox1");
        scoreBox1.scale((((13) * (w)) / ((42) * (scoreBox1.getWidth()))) - 1);
        whiteBox1 = sprites.get("whiteBox1");
        whiteBox1.scale((((3) * (w)) / ((21) * (whiteBox1.getWidth()))) - 1);
        whiteBox1.setOriginCenter();
        blackStar1 = sprites.get("blackStar1");
        blackStar1.scale((((6) * (w)) / ((42) * (blackStar1.getWidth()))) - 1);
        blackStar2 = sprites.get("blackStar2");
        blackStar2.scale((((6) * (w)) / ((42) * (blackStar2.getWidth()))) - 1);
        blackStar3 = sprites.get("blackStar3");
        blackStar3.scale((((6) * (w)) / ((42) * (blackStar3.getWidth()))) - 1);
        blackStar4 = sprites.get("blackStar4");
        blackStar4.scale((((6) * (w)) / ((42) * (blackStar4.getWidth()))) - 1);
        blackStar5 = sprites.get("blackStar5");
        blackStar5.scale((((6) * (w)) / ((42) * (blackStar5.getWidth()))) - 1);
        blackStar6 = sprites.get("blackStar6");
        blackStar6.scale((((6) * (w)) / ((42) * (blackStar6.getWidth()))) - 1);
        goldstar1 = sprites.get("goldstar1");
        goldstar1.scale((((6) * (w)) / ((42) * (goldstar1.getWidth()))) - 1);
        goldstar2 = sprites.get("goldstar2");
        goldstar2.scale((((6) * (w)) / ((42) * (goldstar2.getWidth()))) - 1);
        goldstar3 = sprites.get("goldstar3");
        goldstar3.scale((((6) * (w)) / ((42) * (goldstar3.getWidth()))) - 1);
        goldstar4 = sprites.get("goldstar4");
        goldstar4.scale((((6) * (w)) / ((42) * (goldstar4.getWidth()))) - 1);
        goldstar5 = sprites.get("goldstar5");
        goldstar5.scale((((6) * (w)) / ((42) * (goldstar5.getWidth()))) - 1);
        goldstar6 = sprites.get("goldstar6");
        goldstar6.scale((((6) * (w)) / ((42) * (goldstar6.getWidth()))) - 1);
        whiteBubble1 = sprites.get("whiteBubble1");
        whiteBubble1.scale((((1) * (w)) / ((21) * (whiteBubble1.getWidth()))) - 1);
        whiteBubble2 = sprites.get("whiteBubble2");
        whiteBubble2.scale((((1) * (w)) / ((21) * (whiteBubble2.getWidth()))) - 1);
        whiteBubble3 = sprites.get("whiteBubble3");
        whiteBubble3.scale((((1) * (w)) / ((21) * (whiteBubble3.getWidth()))) - 1);
        whiteBubble4 = sprites.get("whiteBubble4");
        whiteBubble4.scale((((1) * (w)) / ((21) * (whiteBubble4.getWidth()))) - 1);
        whiteBubble5 = sprites.get("whiteBubble5");
        whiteBubble5.scale((((1) * (w)) / ((21) * (whiteBubble5.getWidth()))) - 1);
        whiteBubble6 = sprites.get("whiteBubble6");
        whiteBubble6.scale((((1) * (w)) / ((21) * (whiteBubble6.getWidth()))) - 1);
        whiteBubble7 = sprites.get("whiteBubble7");
        whiteBubble7.scale((((1) * (w)) / ((21) * (whiteBubble7.getWidth()))) - 1);
        boxWidth = (w * 3) / 21;
        boxHeight = (w * 3) / 21;
        blueWall = sprites.get("blueWall");
        redWall = sprites.get("redWall");
        burstBall = sprites.get("burstBall");
        Clasiclogo = sprites.get("Clasiclogo");
        duoBar = sprites.get("duoBar");
        animationMirror = sprites.get("animationMirror");
        mirrorBall = sprites.get("mirrorBall");
        stickman1 = sprites.get("stickman1");
        stickman2 = sprites.get("stickman2");
        versus = sprites.get("versus");
        doubleBall1 = new Sprite(sprites.get("doubleBall"));
        doubleBall2 = new Sprite((sprites.get("doubleBall")));
        doubleBall3 = new Sprite((sprites.get("doubleBall")));
        doubleBall1.scale((((1) * (boxWidth)) / ((3) * (doubleBall1.getWidth()))) - 1);
        doubleBall2.scale((((1) * (boxWidth)) / ((3) * (doubleBall2.getWidth()))) - 1);
        doubleBall3.scale((((1) * (boxWidth)) / ((3) * (doubleBall3.getWidth()))) - 1);

        //classic animations
        blueWall.scale((((1) * (boxWidth)) / ((8) * (blueWall.getWidth()))) - 1);
        redWall.scale((((1) * (boxWidth)) / ((8) * (redWall.getWidth()))) - 1);
        Clasiclogo.scale((((1) * (boxWidth)) / ((2) * (Clasiclogo.getWidth()))) - 1);
        //mirror animations
        //animationMirror.scale((((1) * (boxWidth)) / ((8) * (animationMirror.getWidth()))) - 1);
        animationMirror.setSize(boxWidth / 8, (7 * boxHeight) / 8);
        mirrorBall.scale((((1) * (boxWidth)) / ((3) * (mirrorBall.getWidth()))) - 1);
        //blind animations
        blindBall = new Sprite((sprites.get("blindBall")));
        blindCane = new Sprite((sprites.get("blindCane")));
        blindMan = new Sprite((sprites.get("blindMan")));
        blindBall.scale((((1) * (boxWidth)) / ((4) * (blindBall.getWidth()))) - 1);
        blindCane.setSize(boxWidth / 4, (boxHeight) / 3);
        blindMan.scale((((1) * (boxWidth)) / ((3) * (blindMan.getWidth()))) - 1);
        //blindCane.setOrigin(blindCane.getBoundingRectangle().getWidth(), blindCane.getBoundingRectangle().getHeight());
        //burst animations
        burstLines = new Sprite((sprites.get("burstLines")));
        burstCloud1 = new Sprite((sprites.get("burstCloud1")));
        burstCloud2 = new Sprite((sprites.get("burstCloud2")));
        burstLines.scale((((8) * (boxWidth)) / ((21) * (burstLines.getWidth()))) - 1);
        burstCloud1.scale((((9) * (boxWidth)) / ((42) * (burstLines.getWidth()))) - 1);
        burstCloud2.scale((((6) * (boxWidth)) / ((21) * (burstLines.getWidth()))) - 1);
        burstBall.scale((((8) * (boxWidth)) / ((21) * (burstBall.getWidth()))) - 1);
        //extreme animations
        blueArrow = new Sprite((sprites.get(("blueArrow"))));
        extremeTachometer = new Sprite((sprites.get("extremeTachometer")));
        blueArrow.scale((((1) * (boxWidth)) / ((6) * (blueArrow.getWidth()))) - 1);
        extremeTachometer.scale((((9) * (boxWidth)) / ((10) * (extremeTachometer.getWidth()))) - 1);
        blueArrow.setCenter(blueArrow.getBoundingRectangle().getWidth() / 2, 0);
        //extremeflip animations
        //extremeBoard = new Sprite(new Texture(Gdx.files.internal("extremeBoard.png")));
        // extremeBoard.setSize(boxWidth / 3, boxHeight / 4);
        // extremeBoard.setOrigin(boxWidth / 3, boxHeight / 4);
        blackBoard = new Sprite((sprites.get("blackBoard")));
        extremeFlipBall = new Sprite((sprites.get("extremeFlipBall")));
        blackBoard.scale((((2) * (boxWidth)) / ((3) * (blackBoard.getWidth()))) - 1);
        extremeFlipBall.scale((((1) * (boxWidth)) / ((3) * (extremeFlipBall.getWidth()))) - 1);
        //blackBoard.setOrigin((w / 21 + (boxWidth / 2)), (Variables.h / 2 - (28 * Variables.h / 24) - Variables.deltaY));
        //extremeFlipBall.setOrigin((w / 21 + (boxWidth / 2)), (Variables.h / 2 - (28 * Variables.h / 24) - Variables.deltaY));
        //duo animations
        duoBar.scale((((4) * (boxWidth)) / ((5) * (duoBar.getWidth()))) - 1);
        stickman1.scale((((1) * (boxWidth)) / ((4) * (stickman1.getWidth()))) - 1);
        stickman2.scale((((1) * (boxWidth)) / ((4) * (stickman2.getWidth()))) - 1);
        versus.scale((((1) * (boxWidth)) / ((3) * (versus.getWidth()))) - 1);
        classicnamme = new Sprite((sprites.get("classicnamme")));
        gameModeIcon = new Sprite((sprites.get("gameModeIcon")));
        redFireLeft = new Sprite((sprites.get("redFireLeft")));
        redFireRight = new Sprite((sprites.get("redFireRight")));
        classicnamme.scale((((2) * (w)) / ((3) * (classicnamme.getWidth()))) - 1);
        gameModeIcon.scale((((w)) / ((2) * (gameModeIcon.getWidth()))) - 1);
        redFireLeft.scale((((1) * (w)) / ((7) * (redFireLeft.getWidth()))) - 1);
        redFireRight.scale((((1) * (w)) / ((7) * (redFireRight.getWidth()))) - 1);
        goldenBrownie = new Sprite(new Texture(Gdx.files.internal("goldenBrownie.png")));
        goldenBrownie.scale((((w)) / ((13) * (goldenBrownie.getWidth()))) - 1);
        moneyBox = new Sprite(new Texture(Gdx.files.internal("moneyBox.png")));
        moneyBox.scale((((w * 7)) / ((24) * (moneyBox.getWidth()))) - 1);
        checkButton = new Sprite((sprites.get("checkButton")));
        flower1 = new Sprite((sprites.get("Modeflower")));
        flower2 = new Sprite((sprites.get("Modeflower")));
        checkButton.scale((((w)) / ((3) * (checkButton.getWidth()))) - 1);
        checkButton.setOriginCenter();
        checkButton.setRotation(-5);
        flower1.scale((((w)) / ((13) * (flower1.getWidth()))) - 1);
        flower2.scale((((w)) / ((13) * (flower2.getWidth()))) - 1);
        storePage = new Sprite(sprites.get("storePage1"));
        storePage.setSize(w, (h * 13 / 16));
        storeTitle = new Sprite((sprites.get("storeTitle")));
        storeTitle.scale((((w)) / ((2) * (storeTitle.getWidth()))) - 1);
        saleBanner1 = new Sprite((sprites.get("saleBanner1")));
        //saleBanner1.scale((((w * 3)) / ((4) * (saleBanner1.getWidth()))) - 1);
        saleBanner1.setSize((w * 6) / 7, h / 8);
        saleBanner2 = new Sprite((sprites.get("saleBanner2")));
        // saleBanner2.scale((((w * 3)) / ((4) * (saleBanner2.getWidth()))) - 1);
        saleBanner2.setSize((w * 6) / 7, h / 8);
        saleBanner3 = new Sprite((sprites.get("saleBanner3")));
        //saleBanner3.scale((((w * 3)) / ((4) * (saleBanner3.getWidth()))) - 1);
        saleBanner3.setSize((w * 6) / 7, h / 8);
        saleBanner4 = new Sprite((sprites.get("saleBanner4")));
        //saleBanner4.scale((((w * 3)) / ((4) * (saleBanner4.getWidth()))) - 1);
        saleBanner4.setSize((w * 6) / 7, h / 8);
        saleBanner5 = new Sprite((sprites.get("saleBanner5")));
        //saleBanner5.scale((((w * 3)) / ((4) * (saleBanner5.getWidth()))) - 1);
        saleBanner5.setSize((w * 6) / 7, h / 8);
        storeButton1 = new Sprite((sprites.get("storeButton1")));
        //storeButton1.scale((((w)) / ((6) * (storeButton1.getWidth()))) - 1);
        storeButton1.setSize((w * 7) / 24, h / 16);
        storeButton2 = new Sprite((sprites.get("storeButton2")));
        //storeButton2.scale((((w)) / ((6) * (storeButton2.getWidth()))) - 1);
        storeButton2.setSize((w * 7) / 24, h / 16);
        storeButton3 = new Sprite((sprites.get("storeButton3")));
        //storeButton3.scale((((w)) / ((6) * (storeButton3.getWidth()))) - 1);
        storeButton3.setSize((w * 7) / 24, h / 16);
        storeButton4 = new Sprite((sprites.get("storeButton4")));
        //storeButton4.scale((((w)) / ((6) * (storeButton4.getWidth()))) - 1);
        storeButton4.setSize((w * 7) / 24, h / 16);
        storeButton5 = new Sprite((sprites.get("storeButton5")));
        //storeButton5.scale((((w)) / ((6) * (storeButton5.getWidth()))) - 1);
        storeButton5.setSize((w * 7) / 24, h / 16);
        mostPopular = new Sprite((sprites.get("mostPopular")));
        mostPopular.setSize(w / 5, h / 16);
        mostPopular.setRotation(-5);
        // mostPopular.scale((((2) * (w)) / ((3) * (mostPopular.getWidth()))) - 1);
        sale1 = new Sprite((sprites.get("sale20")));
        sale1.setSize(w / 3, h / 16);
        sale10 = new Sprite((sprites.get("sale420")));
        sale10.setSize(w / 3, h / 16);
        // sale10.scale((((2) * (w)) / ((3) * (sale10.getWidth()))) - 1);
        sale25 = new Sprite((sprites.get("sale1100")));
        sale25.setSize(w / 3, h / 16);
        //sale25.scale((((2) * (w)) / ((3) * (sale25.getWidth()))) - 1);
        sale100 = new Sprite((sprites.get("sale3000")));
        sale100.setSize(w / 3, h / 16);
        //sale100.scale((((2) * (w)) / ((3) * (sale100.getWidth()))) - 1);
        sale500 = new Sprite((sprites.get("sale5200")));
        sale500.setSize(w / 3, h / 16);
        //sale500.scale((((2) * (w)) / ((3) * (sale500.getWidth()))) - 1);
        brownie1 = new Sprite((sprites.get("brownie1")));
        brownie1.scale((((1) * (w)) / ((12) * (brownie1.getWidth()))) - 1);
        brownie10 = new Sprite((sprites.get("brownie10")));
        // brownie10.setSize(w / 12, h / 16);
        brownie10.scale((((1) * (w)) / ((12) * (brownie10.getWidth()))) - 1);
        brownie25 = new Sprite((sprites.get("brownie25")));
        //brownie25.setSize(w / 8, h / 16);
        brownie25.scale((((1) * (w)) / ((8) * (brownie25.getWidth()))) - 1);
        brownie100 = new Sprite((sprites.get("brownie100")));
        //brownie100.setSize(w / 8, h / 8);
        brownie100.scale((((1) * (w)) / ((8) * (brownie100.getWidth()))) - 1);
        brownie500 = new Sprite((sprites.get("brownie500")));
        //brownie500.setSize(w / 8, h / 8);
        brownie500.scale((((1) * (w)) / ((8) * (brownie500.getWidth()))) - 1);

        //duoreset2.scale(((Gdx.graphics.getWidth()) / (12 * (duoreset2.getWidth()))) - 1);
        randomizeButton = new Sprite((sprites.get("randomize")));
        fastforwardButton = new Sprite((sprites.get("fastforward")));
        exitButton = new Sprite((sprites.get("closeX")));
        popupScreen = new Sprite((sprites.get("popupScreen")));
        achievementBoard = new Sprite((sprites.get("achievementBoard")));
        screenOverlay = new Sprite((sprites.get("screenOverlay")));
        randomizeButton.scale((((1) * (w)) / ((12) * (randomizeButton.getWidth()))) - 1);
        fastforwardButton.scale((((1) * (w)) / ((12) * (fastforwardButton.getWidth()))) - 1);
        exitButton.scale((((1) * (w)) / ((7) * (exitButton.getWidth()))) - 1);
        popupScreen.scale((((5) * (w)) / ((6) * (popupScreen.getWidth()))) - 1);
        achievementBoard.scale((((2) * (w)) / ((3) * (achievementBoard.getWidth()))) - 1);
        achievementBoard.setOriginCenter();
        screenOverlay.setSize(w, h);


        progressBox = new Sprite((sprites.get("progressBox")));
        progressBox.scale((((2) * (w)) / ((6) * (progressBox.getWidth()))) - 1);
        achievementBanner = new Sprite((sprites.get("achievementBanner")));
        achievementBanner.scale((((w)) / ((achievementBanner.getWidth()))) - 1);
        achievementStars = new Sprite((sprites.get("achievementStars")));
        achievementStars.scale((((1) * (w)) / ((4) * (achievementStars.getWidth()))) - 1);
        achievementUnlocked = new Sprite((sprites.get("achievementUnlocked")));
        achievementUnlocked.scale((((2) * (w)) / ((3) * (achievementUnlocked.getWidth()))) - 1);
        //update popup
        updateBoard = new Sprite((sprites.get("updateBoard")));
        updateBoard.scale((((8) * (w)) / (8 * (updateBoard.getWidth()))) - 1);
        updateTitle = new Sprite((sprites.get("updateTitle")));
        updateTitle.scale((((7) * (w)) / ((8) * (updateTitle.getWidth()))) - 1);
        updates = new Sprite((sprites.get("updates")));
        updates.scale((((14) * (w)) / ((16) * (updates.getWidth()))) - 1);
        updateCheck = new Sprite((sprites.get("updateCheck")));
        updateCheck.scale((((1) * (w)) / ((4) * (updateCheck.getWidth()))) - 1);
        updateBrownie = new Sprite((sprites.get("goldenBrownie")));
        updateBrownie.scale((((1) * (w)) / ((8) * (updateBrownie.getWidth()))) - 1);
        //characterShop
        shopIcon = new Sprite((sprites.get("shopIcon")));
        shopIcon.scale((((1) * (w)) / (7 * (shopIcon.getWidth()))) - 1);
        characterShopPage = new Sprite((sprites.get("characterShopPage")));
        characterShopPage.setSize(w, h);
        //characterShopPage.scale((((7) * (w)) / (8 * (characterShopPage.getWidth()))) - 1);
        characterShopBar = new Sprite((sprites.get("characterShopBar")));
        characterShopBar.scale((((14) * (w)) / (16 * (characterShopBar.getWidth()))) - 1);
        characterShopTitle = new Sprite((sprites.get("characterShopTitle")));
        characterShopTitle.scale((((4) * (w)) / (8 * (characterShopTitle.getWidth()))) - 1);
        characterShopTitleBar = new Sprite((sprites.get("characterShopTitleBar")));
        characterShopTitleBar.scale((((8) * (w)) / (8 * (characterShopTitleBar.getWidth()))) - 1);
        characterShopUsing = new Sprite((sprites.get("characterShopUsing")));
        characterShopUsing.scale((((3) * (w)) / (16 * (characterShopUsing.getWidth()))) - 1);
        characterShopNotUsing1 = new Sprite((sprites.get("characterShopNotUsing")));
        characterShopNotUsing1.scale((((3) * (w)) / (16 * (characterShopNotUsing1.getWidth()))) - 1);
        shopY = characterShopTitleBar.getBoundingRectangle().getHeight() / 2 + ((h) / 16);
        timeBar = new Sprite((sprites.get("timeBar")));
        timeBar.scale((((3) * (w)) / (8 * (timeBar.getWidth()))) - 1);
        specialTitle = new Sprite((sprites.get("holidaySpecial")));
        specialTitle.scale((((2) * (w)) / (8 * (specialTitle.getWidth()))) - 1);
        //Progress
        for (int i = 0; i <= 100; i += 4) {
            sprites.get("circularProgress" + String.valueOf(i)).scale((((1) * (w)) / ((3) * (sprites.get("circularProgress" + String.valueOf(i)).getWidth()))) - 1);
        }


        //Font
        stats_font = new BitmapFont(Gdx.files.internal("best_score.fnt"));
        score_font = new BitmapFont(Gdx.files.internal("name.fnt"));
        duo_tally_font = new BitmapFont(Gdx.files.internal("name.fnt"));
        highscore_font = new BitmapFont(Gdx.files.internal("high.fnt"));
        best_font = new BitmapFont(Gdx.files.internal("name.fnt"));
        writing_font = new BitmapFont(Gdx.files.internal("name.fnt"));
        best_score_font = new BitmapFont(Gdx.files.internal("best_score.fnt"));
        progressFont = new BitmapFont(Gdx.files.internal("progressFont.fnt"));
        achievementFont = new BitmapFont(Gdx.files.internal("achievementFont.fnt"));
        percentageFont = new BitmapFont(Gdx.files.internal("percentageFont.fnt"));
        pricingFont = new BitmapFont(Gdx.files.internal("characterPricing.fnt"));
        timeFont = new BitmapFont(Gdx.files.internal("timeLeft.fnt"));

        score_font.getData().scale(((w)) / (30 * score_font.getSpaceWidth()) - 1);
        progressFont.getData().scale(((w)) / (42 * progressFont.getSpaceWidth()) - 1);
        highscore_font.getData().scale(((w)) / (65 * highscore_font.getSpaceWidth()) - 1);
        best_font.getData().scale(((w)) / (40 * best_font.getSpaceWidth()) - 1);
        writing_font.getData().scale(((w)) / (100 * writing_font.getSpaceWidth()) - 1);
        best_score_font.getData().scale(((w)) / (100 * best_score_font.getSpaceWidth()));
        stats_font.getData().scale(((w)) / (25 * stats_font.getSpaceWidth()) - 1);
        duo_tally_font.getData().scale(((w)) / (30 * duo_tally_font.getSpaceWidth()) - 1);
        achievementFont.getData().scale(((w)) / (50 * achievementFont.getSpaceWidth()) - 1);
        percentageFont.getData().scale(((w)) / (25 * percentageFont.getSpaceWidth()) - 1);
        pricingFont.getData().scale(((w)) / (30 * pricingFont.getSpaceWidth()) - 1);
        timeFont.getData().scale(((w)) / (100 * timeFont.getSpaceWidth()) - 1);


        //Strings
        score_string = "" + score;
        title = "BALL GAME";
        moneyLayout.setText(achievementFont, String.valueOf(userBrownies.getInteger("brownies")));
        //textures


        //Others
        random = new Random();
        bounce = Gdx.audio.newSound(Gdx.files.internal("Jump4.wav"));
        musicsound = Gdx.audio.newMusic(Gdx.files.internal("Dubstep.wav"));
        death = Gdx.audio.newMusic(Gdx.files.internal("dead.wav"));
        pausetime = 0;
        yloop = false;
        waittime = 0;
        restarted = 0;
        modeClicked = 0;
        fireDirection = 1;
        openAchievement = false;
        openStore = false;
        modeScreenTime = 0;
        openShop = false;

        //achievment Arrays
        //classicAchievements =
        specialSale = true;
        calendar = Calendar.getInstance();
        DateCompare.isSale();
        characterName = new String[]{"classicBall", "arrow", "flower", "smiley", "soccerball", "person", "heart", "cat", "paw", "volleyball",
                "weight", "butterfly", "burger", "crown"};
        characterPricings = new int[]{0, 100, 200, 300, 410, 520, 700, 725, 800, 850, 925, 950, 1100, 1200};
        allNames = new ArrayList<String>();
        if (specialSale) {
            allNames.add(specialCharacters[specialCharacters.length - 1]);
        }
        for (int i = 0; i < unlockedSpecialCharacters.getString("unlockedSpecialCharacters").length(); i++) {
            if (unlockedSpecialCharacters.getString("unlockedSpecialCharacters").substring(i, i + 1).equals("1")) {//they have unlocked a special character
                allNames.add(specialCharacters[i]);
            }
        }
        for (int i = 0; i < characterName.length; i++) {
            allNames.add(characterName[i]);
        }
        specialCount = 0;
        for (int i = 0; i < unlockedSpecialCharacters.getString("unlockedSpecialCharacters").length(); i++) {
            if (i == unlockedSpecialCharacters.getString("unlockedSpecialCharacters").length() - 1) {//special sale potential
                if (specialSale || unlockedSpecialCharacters.getString("unlockedSpecialCharacters").substring(i, i + 1).equals("1")) {
                    specialCount++;
                }
            } else if (unlockedSpecialCharacters.getString("unlockedSpecialCharacters").substring(i, i + 1).equals("1")) {
                specialCount++;
            }
        }
        charactersBought = new int[unlockedCharacters.getString("unlockedCharacters").length() + specialCount];
        for (int a = unlockedSpecialCharacters.getString("unlockedSpecialCharacters").length(); a > 0; a--) {
            if (a == unlockedSpecialCharacters.getString("unlockedSpecialCharacters").length()) {//special sale potential
                if (specialSale || unlockedSpecialCharacters.getString("unlockedSpecialCharacters").substring(a - 1, a).equals("1")) {
                    charactersBought[specialCount - a] = Integer.parseInt(unlockedSpecialCharacters.getString("unlockedSpecialCharacters").substring(a - 1, a));
                }
            } else if (unlockedSpecialCharacters.getString("unlockedSpecialCharacters").substring(a - 1, a).equals("1")) {
                charactersBought[specialCount - a] = Integer.parseInt(unlockedSpecialCharacters.getString("unlockedSpecialCharacters").substring(a - 1, a));
            }
        }
        for (int j = 0; j < unlockedCharacters.getString("unlockedCharacters").length(); j++) {
            charactersBought[j + specialCount] = Integer.parseInt(unlockedCharacters.getString("unlockedCharacters").substring(j, j + 1));
        }
        for (int i = 0; i < allNames.size(); i++) {
            sprites.get(allNames.get(i)).scale((((2) * (w)) / ((11) * ((sprites.get(allNames.get(i)).getWidth())))) - 1);
            sprites.get(allNames.get(i) + "Title").scale((((1) * (w)) / ((2) * ((sprites.get(allNames.get(i) + "Title").getWidth())))) - 1);
            sprites.get(allNames.get(i) + "Half").scale((((1) * (w)) / ((11) * ((sprites.get(allNames.get(i) + "Half").getWidth())))) - 1);
        }
        leftball = sprites.get(currentCharacter.getString("currentCharacter") + "Half");
        leftball.setColor(243 / 255f, 34 / 255f, 12 / 255f, 1);
        //leftball.setSize(halfwidth, halfheight);
        rightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
        rightball.setColor(200 / 255f, 71 / 255f, 243 / 255f, 1);
        //rightball.setSize(halfwidth, halfheight);
        rightball.flip(true, false);
        blindleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
        blindrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
        secondleftball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
        secondrightball = new Sprite(sprites.get(currentCharacter.getString("currentCharacter") + "Half"));
        blindrightball.flip(true, false);
        secondrightball.flip(true, false);
        ball = sprites.get(currentCharacter.getString("currentCharacter"));
        ball.setOriginCenter();
        ball2 = sprites.get(currentCharacter.getString("currentCharacter"));//different colour tho??
        ball2.setOriginCenter();
        //characters

    }

    public static void firstVariables() {
        companyLogo = new Sprite(new Texture(Gdx.files.internal("logo.png")));
        companyLogo.scale(((3 * (Gdx.graphics.getWidth())) / (4 * companyLogo.getWidth())) - 1);
        companyLogo.setOriginCenter();
        companyLogo.setRotation(10);
        companyName = new Sprite(new Texture(Gdx.files.internal("companyname2.png")));
        companyName.scale((((w)) / ((companyName.getWidth()))) - 1);
        prefs_time = Gdx.app.getPreferences("times");
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        logoX = 0 - (companyLogo.getWidth() / 2);
        chain = new Texture(Gdx.files.internal("chainLink.png"));
        // goldstar = new Texture(Gdx.files.internal("black.png"));

        //region[0] = new TextureRegion(blackStar, 0, 0, blackStar.getWidth(), blackStar.getHeight() / 2);
        //region[1] = new TextureRegion(goldStar, 0, goldStar.getHeight() / 2, goldStar.getWidth(), goldStar.getHeight() / 2);


    }

    //public static void testProgress() {
    //progressCircle = new Sprite(new Texture(Gdx.files.internal("testProgress.png")));
    //progressCircle.scale((((3) * (w)) / ((8) * (progressCircle.getWidth()))) - 1);
    //progressText = new Sprite(new Texture(Gdx.files.internal("testAchievement.png")));
    //progressText.scale((((1) * (w)) / ((2) * (progressText.getWidth()))) - 1);

    //}
}
