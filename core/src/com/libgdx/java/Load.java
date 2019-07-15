package com.libgdx.java;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.libgdx.java.CreateWall.wall;
import static com.libgdx.java.balls.createBall;
import static com.libgdx.java.utils.Constants.*;

 class Load {


     public static void loadResource() {

         striker = new Texture("ball0.png");
         //System.out.println(striker.getWidth());
         textureball1 = new Texture("ball1.png");
         textureball2 = new Texture("ball2.png");
         textureball3 = new Texture("ball3.png");
         textureball4 = new Texture("ball4.png");
         textureball5 = new Texture("ball5.png");
         textureball6 = new Texture("ball6.png");
         textureball7 = new Texture("ball7.png");
         textureball8 = new Texture("ball8.png");
         textureball9 = new Texture("ball9.png");
         textureball10 = new Texture("ball10.png");
         textureball11 = new Texture("ball11.png");
         textureball12 = new Texture("ball12.png");
         textureball13 = new Texture("ball13.png");
         textureball14 = new Texture("ball14.png");
         textureball15 = new Texture("ball15.png");
         ballbox = new Texture("Ballbox.png");
         insidetray = new Texture("InsideTray.png");
         cue1 = new Texture("cuePurple.png");
         cue2 = new Texture("cueGreen.png");
         background = new Texture("parquet.jpg");
         board = new Texture("poolTable.png");



         // loading sprite

         sprite1 = new Sprite(board);
         sprite1.setPosition(Gdx.graphics.getWidth() / 2 - sprite1.getWidth() / 2, Gdx.graphics.getHeight() / 2 - sprite1.getHeight() / 2);
         sprite2 = new Sprite(background);
         sprite2.setSize(1540, 845);
         sprite2.setPosition(0, 0);
         stick1=new Sprite(cue1);
         stick1.setPosition(200,100);
         stick1.setRotation(0);
         stick2=new Sprite(cue2);
         stick2.setPosition(200,100);
         stick2.setRotation(0);
         ballboximg=new Sprite(insidetray);
         ballboximg.setPosition(545,0);
         ballboximg.setSize(450,40);

         // ceating wall

         ground1 = wall(408, 421, 0, 300, true);
         ground2 = wall(1132, 421, 0, 300, true);
         ground3 = wall(589, 600, 304, 0, true);
         ground4 = wall(589, 241, 304, 0, true);
         ground5 = wall(950, 601, 304, 0, true);
         ground6 = wall(950, 241, 304, 0, true);
         balltray1 = wall(770,32,466,0,true);
         balltray2 = wall(770,1,466,0,true);
         balltray3 = wall(545,20,0,40,true);
         balltray4 = wall(993,20,0,40,true);

         // creating ball

         player = createBall(450,422,14,false,0);
         ball1 = createBall(850,422,14,false,1);
         ball2 = createBall(880,407,14,false,2);
         ball3 = createBall(880,437,14,false,3);
         ball4 = createBall(910,392,14,false,4);
         ball5 = createBall(910,422,14,false,5);
         ball6 = createBall(910,452,14,false,6);
         ball7 = createBall(940,377,14,false,7);
         ball8 = createBall(940,407,14,false,8);
         ball9 = createBall(940,437,14,false,9);
         ball10 = createBall(940,467,14,false,10);
         ball11 = createBall(970,362,14,false,11);
         ball12 = createBall(970,392,14,false,12);
         ball13 = createBall(970,422,14,false,13);
         ball14 = createBall(970,452,14,false,14);
         ball15 = createBall(970,482,14,false,15);

         //sound load
         ballinpocket=Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_ball_in_pocket.wav"));
         ballroll=Gdx.audio.newSound(Gdx.files.internal("sounds/ball_roll.wav"));
         cuepocket=Gdx.audio.newSound(Gdx.files.internal("sounds/cuepocket.wav"));


     }
 }


