package com.libgdx.java;
import com.badlogic.gdx.physics.box2d.*;
import static com.libgdx.java.utils.Constants.*;


public class balls {

    public static Body createBall(int x,int y,int rad,boolean isStatic,int num)
     {
         Body pBody;
         BodyDef def=new BodyDef();
         if(isStatic)
             def.type=BodyDef.BodyType.StaticBody;
         else
             def.type=BodyDef.BodyType.DynamicBody;
         def.position.set(x/PPM,y/PPM);
         def.linearDamping = 0.5f;
         def.fixedRotation=false;
         pBody=world.createBody(def);
         CircleShape shape=new CircleShape();
         shape.setRadius(rad/PPM);
         //Fixture
         FixtureDef fix=new FixtureDef();
         fix.shape=shape;
         fix.density=1.5f;
         fix.friction=25f;
         fix.restitution=.55f;
         pBody.createFixture(fix);
         if(num==0)
             pBody.setUserData("Striker");
         else if(num<8)
             pBody.setUserData("BallSolid");
         else if(num==8)
             pBody.setUserData("Ball8");
         else
             pBody.setUserData("BallStripe");

         shape.dispose();
         return pBody;
    }
}

