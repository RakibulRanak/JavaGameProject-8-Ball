package com.libgdx.java;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import static com.libgdx.java.utils.Constants.*;

public class CreateWall {

    public static Body wall(int x, int y, int width, int height, boolean isStatic){

        Body pBody;
        BodyDef def = new BodyDef();
        if (isStatic)
            def.type = BodyDef.BodyType.StaticBody;
        else
            def.type = BodyDef.BodyType.DynamicBody;

        def.position.set(x/PPM, y/PPM);
        def.fixedRotation = true;
        pBody = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox((width / 2)/PPM, (height / 2)/PPM);
        pBody.createFixture(shape, 10f);
        pBody.setUserData("Wall");
        shape.dispose();
        return pBody;

    }
}
