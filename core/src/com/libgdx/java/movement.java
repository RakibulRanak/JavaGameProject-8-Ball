package com.libgdx.java;

import com.badlogic.gdx.physics.box2d.Body;
import static com.libgdx.java.utils.Constants.*;

public class movement {
  public static boolean stop()
    {
        float v0=Math.abs(player.getLinearVelocity().x)+Math.abs(player.getLinearVelocity().y);
        float v1=Math.abs(ball1.getLinearVelocity().x)+Math.abs(ball1.getLinearVelocity().y);
        float v2=Math.abs(ball2.getLinearVelocity().x)+Math.abs(ball2.getLinearVelocity().y);
        float v3=Math.abs(ball3.getLinearVelocity().x)+Math.abs(ball3.getLinearVelocity().y);
        float v4=Math.abs(ball4.getLinearVelocity().x)+Math.abs(ball4.getLinearVelocity().y);
        float v5=Math.abs(ball5.getLinearVelocity().x)+Math.abs(ball5.getLinearVelocity().y);
        float v6=Math.abs(ball6.getLinearVelocity().x)+Math.abs(ball6.getLinearVelocity().y);
        float v7=Math.abs(ball7.getLinearVelocity().x)+Math.abs(ball7.getLinearVelocity().y);
        float v8=Math.abs(ball8.getLinearVelocity().x)+Math.abs(ball8.getLinearVelocity().y);
        float v9=Math.abs(ball9.getLinearVelocity().x)+Math.abs(ball9.getLinearVelocity().y);
        float v10=Math.abs(ball10.getLinearVelocity().x)+Math.abs(ball10.getLinearVelocity().y);
        float v11=Math.abs(ball11.getLinearVelocity().x)+Math.abs(ball11.getLinearVelocity().y);
        float v12=Math.abs(ball12.getLinearVelocity().x)+Math.abs(ball12.getLinearVelocity().y);
        float v13=Math.abs(ball13.getLinearVelocity().x)+Math.abs(ball13.getLinearVelocity().y);
        float v14=Math.abs(ball14.getLinearVelocity().x)+Math.abs(ball14.getLinearVelocity().y);
        float v15=Math.abs(ball15.getLinearVelocity().x)+Math.abs(ball15.getLinearVelocity().y);
        if(v0<0.3)
            player.setLinearVelocity(0,0);
       if(v1<0.3)
            ball1.setLinearVelocity(0,0);
        if(v2<0.3)
            ball2.setLinearVelocity(0,0);
        if(v3<0.3)
            ball3.setLinearVelocity(0,0);
        if(v4<0.3)
            ball4.setLinearVelocity(0,0);
        if(v5<0.3)
            ball5.setLinearVelocity(0,0);
        if(v6<0.3)
            ball6.setLinearVelocity(0,0);
        if(v7<0.3)
            ball7.setLinearVelocity(0,0);
        if(v8<0.3)
            ball8.setLinearVelocity(0,0);
        if(v9<0.3)
            ball9.setLinearVelocity(0,0);
        if(v10<0.3)
            ball10.setLinearVelocity(0,0);
        if(v11<0.3)
            ball11.setLinearVelocity(0,0);
        if(v12<0.3)
            ball12.setLinearVelocity(0,0);
        if(v13<0.3)
            ball13.setLinearVelocity(0,0);
        if(v14<0.3)
            ball14.setLinearVelocity(0,0);
        if(v15<0.3)
            ball15.setLinearVelocity(0,0);

       // int v=(int)v0+(int)v1+(int)v2+(int)v3+(int)v4+(int)v5+(int)v6+(int)v7+(int)v8+(int)v9+(int)v10+(int)v11+(int)v12+(int)v13
         //       +(int)v14+(int)v15;
        if(v0<0.3 &&v2<0.3&&v3<0.3&&v4<0.3&&v5<0.3&&v6<0.3&&v7<0.3&&v8<0.3&&v9<0.3&&v10<0.3&&v11<0.3&&v12<0.3&&v13<0.3&&v14<0.3&&v15<0.3)
            return true;
        else
            return false;
    }
}
