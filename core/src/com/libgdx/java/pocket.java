package com.libgdx.java;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.physics.box2d.*;

import static com.libgdx.java.utils.Constants.PPM;

public class pocket {

    public static Sound wavSound1=Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_ball_in_pocket.wav"));
    public static Sound wavSound2=Gdx.audio.newSound(Gdx.files.internal("sounds/ball_roll.wav"));
    public static boolean check (Body ball)
    {
        float x=ball.getPosition().x*PPM;
        float y=ball.getPosition().y*PPM;
        int a=0;
        if(x<405 ||x>1134 ||y<235||y>615 ) {
            a=1;
        }
        if(a==1) {
            wavSound1.play();
            wavSound2.play();
            ball.setLinearVelocity(0, 0);
            ball.setTransform(970 / PPM, 15 / PPM, 0);
            ball.applyForceToCenter(-15, 0, false);

            return false;
        }
        else
            return true;
    }
}
