package com.libgdx.java;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.physics.box2d.*;

public class ListenerClass implements ContactListener {
    Sound ballssound= Gdx.audio.newSound(Gdx.files.internal("sounds/ball_hit_medium.wav"));
    @Override
    public void beginContact(Contact contact) {

    }

    @Override
    public void endContact(Contact contact) {
        Fixture fa=contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
        //System.out.println("collision" );
        //System.out.println(fa.getBody().getUserData() + " "+ fb.getBody().getUserData());
        float velocity1=Math.abs(fb.getBody().getLinearVelocity().x)+Math.abs(fb.getBody().getLinearVelocity().y);
        float velocity2=Math.abs(fa.getBody().getLinearVelocity().x)+Math.abs(fa.getBody().getLinearVelocity().y);
        float velocity=velocity1+velocity2;
        //System.out.println(velocity);
        ballssound.play(velocity/40);
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
;