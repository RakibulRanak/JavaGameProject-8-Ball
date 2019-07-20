
package com.libgdx.java.utils;


import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;



public final class Constants {
    public static final float PPM=100f;
    public static final int WIDTH=1540;
    public static final int HEIGHT=845;
    public static boolean player1=true,player2=false;
    public static int solid=0, checkWin;
    public static int stripe=0;
    public static int eight=0;
    public static int cue=0,cuegorte=0;
    public static Body player, balltray1,balltray2,balltray3,balltray4,platform, ground1, ground2, ground3, ground4, ground5, ground6,ball1
            ,ball2,ball3,ball4,ball5,ball6,ball7,ball8,ball9,ball10,ball11,ball12,ball13,ball14,ball15,ballwhite;
    public static int point1=0,point2=0,SOLID=7,STRIPE=7;
    public static Texture background, board, striker, textureball1, textureball2, textureball3, textureball4, textureball5, textureball6,
            textureball7, table, textureball8, textureball9, textureball10, textureball11, textureball12,insidetray,
            textureball13, textureball14, textureball15,ballbox,cue1,cue2,f0,f30,f60,f90,f120,f150,f180;

    public static Sprite sprite1, sprite2,stick1,stick2,ballboximg, spritePlayer1, spritePlayer2, spritePlayer1Arrow, spritePlayer2Arrow,F0,F30,F60,F90,F120,F150,F180;
    public static World world;

    public static Box2DDebugRenderer b2dr;
    public static SpriteBatch batch;



    public static boolean player1hit=false,player2hit=false,balllstop=true;
    public static int Force=0;
    public static double angle;
    public static float posx,posy,disA,disB=20,power,mousex,mousey,time=0;
    public static Sound ballinpocket,ballroll,cuepocket,winsound;








}
