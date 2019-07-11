package com.libgdx.java;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import static com.libgdx.java.utils.Constants.PPM;

public class balls {
    public Body createBall(int x,int y,float radius, boolean isStatic)
    {
        World world;
        world=new World(new Vector2(0,-0.98f),false);
        Body pBody;
        BodyDef def=new BodyDef();
        if(isStatic)
            def.type=BodyDef.BodyType.StaticBody;
        else
            def.type=BodyDef.BodyType.DynamicBody;
        CircleShape shape=new CircleShape();
        def.position.set(x/PPM,y/PPM);

        shape.setRadius(radius);
        FixtureDef fix=new FixtureDef();
        fix.shape=shape;
        fix.density=2.5f;
        fix.friction=.25f;
        fix.restitution=.75f;
        pBody=world.createBody(def);
        pBody.createFixture(fix);
        shape.dispose();
        return pBody;
    }
}

