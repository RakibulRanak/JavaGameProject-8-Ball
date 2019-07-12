package com.libgdx.java;
import com.badlogic.gdx.physics.box2d.*;

import static com.libgdx.java.utils.Constants.PPM;

public class pocket {


    public static boolean check (Body ball)
    {
        float x=ball.getPosition().x*PPM;
        float y=ball.getPosition().y*PPM;
        int a=0;
        if(x<405 ||x>1134 ||y<235||y>615 ) {
            a=1;
        }
        if(a==1) {
            ball.setLinearVelocity(0, 0);
            ball.setTransform(970 / PPM, 15 / PPM, 0);
            ball.applyForceToCenter(-10, 0, false);
            return false;
        }
        else
            return true;
    }
}
