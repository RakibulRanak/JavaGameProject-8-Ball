package com.libgdx.java;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;

import static com.libgdx.java.utils.Constants.*;

public class InputProcessing implements InputProcessor {
        @Override
        public boolean keyDown ( int keycode){
            return false;
        }

        @Override
        public boolean keyUp ( int keycode){
            return false;
        }

        @Override
        public boolean keyTyped ( char character){
            return false;
        }

        @Override
        public boolean touchDown ( int screenX, int screenY, int pointer, int button){
            if(button==Input.Buttons.LEFT && cuegorte==1)
            {
                cuegorte=0;
                stick1.setPosition(player.getPosition().x * PPM, player.getPosition().y * PPM);
                stick2.setPosition(player.getPosition().x * PPM, player.getPosition().y * PPM);


            }

           if (button == Input.Buttons.LEFT && cuegorte==0) {
                if (Force > 0) {
                    if (Force > 180)
                        Force = 180;
                    Sound hitmedium = Gdx.audio.newSound(Gdx.files.internal("sounds/ball_hit_medium.wav"));
                    Sound hithard = Gdx.audio.newSound(Gdx.files.internal("sounds/ball_hit_hard.wav"));
                    Sound hitweak = Gdx.audio.newSound(Gdx.files.internal("sounds/ballhitweak.wav"));
                    float dX = mousex - player.getPosition().x * PPM;
                    if(dX==0)
                        dX=0.1f;
                    float dY = mousey - player.getPosition().y * PPM;
                    if(dY==0)
                        dY=0.1f;
                    float forceX = (Math.abs(dX) + Math.abs(dY)) / (Math.abs(dY));
                    float forceY = (Math.abs(dX) + Math.abs(dY)) / (Math.abs(dX));
                    float total = Math.abs(forceX) + Math.abs(forceY);
                    forceX = forceX / total;
                    forceY = forceY / total;
                    if (dX < 0)
                        forceX *= -1;
                    if (dY < 0)
                        forceY *= -1;
                    player.applyForceToCenter(forceX * Force, forceY * Force, false);
                    if (Force < 50)
                        hitweak.play();
                    if (Force < 100)
                        hitmedium.play();
                    else
                        hithard.play();

                    if (player1) {
                        stick1.setPosition(player.getPosition().x * PPM, player.getPosition().y * PPM);
                        stick2.setPosition(player.getPosition().x * PPM, player.getPosition().y * PPM);

                        player1hit = true;
                        player2hit = false;
                        balllstop = false;
                        time = 0;
                    } else {
                        stick1.setPosition(player.getPosition().x * PPM, player.getPosition().y * PPM);
                        stick2.setPosition(player.getPosition().x * PPM, player.getPosition().y * PPM);
                        player2hit = true;
                        player1hit = false;
                        balllstop = false;
                        time = 0;

                    }

                }
                Force = 0;
                power = 0;
                disB = 20;
            }
            return false;
        }

        @Override
        public boolean touchUp ( int screenX, int screenY, int pointer, int button){
            return false;
        }

        @Override
        public boolean touchDragged ( int screenX, int screenY, int pointer){
            return false;
        }

        @Override
        public boolean mouseMoved ( int screenX, int screenY){

            mousex = screenX;
            mousey = HEIGHT - 1 - screenY;
            if(cuegorte==1)
            {
                player.setTransform(mousex/PPM,mousey/PPM,0);
            }
            int x2, y2;
            x2 = (int) (player.getPosition().x * PPM);
            y2 = (int) (player.getPosition().y * PPM);
            angle = Math.atan((y2 - mousey) / (x2 - mousex));
            angle = Math.toDegrees(angle);
            if (mousex < x2) {
                stick1.setRotation((float) angle);
                stick2.setRotation((float) angle);

            } else if (mousex > x2) {
                stick1.setRotation(180 - (float) -angle);
                stick2.setRotation(180 - (float) -angle);

            }

            stick1.setOrigin(0, 0);
            stick2.setOrigin(0, 0);

            return false;
        }

        @Override
        public boolean scrolled ( int amount){
            return false;
        }

}
