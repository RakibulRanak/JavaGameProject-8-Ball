package com.libgdx.java;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import static com.libgdx.java.utils.Constants.*;
import static com.libgdx.java.utils.Constants.stick2;

public class InputUpdate {

    public static void inputUpdate(float delta) {
        int horizontalForce = 0;
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            //System.out.println(Gdx.input.getX()+" "+(HEIGHT-1-Gdx.input.getY()));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
            player.applyForceToCenter(0, -50, false);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            player.applyForceToCenter(-50, 0, false);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            player.applyForceToCenter(50, 0, false);
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP))
            player.applyForceToCenter(0, 50, false);
        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)&&hit) {
            power=5;
            Force+=3;
            int x1,y1;
            x1= (int) (player.getPosition().x*PPM);
            y1=(int)(player.getPosition().y*PPM);
            disA= (float) Math.sqrt((y1-mousey)*(y1-mousey)+(x1-mousex)*(x1-mousex))+20;
            disB+=power;
            disA+=disB;
            posx=(disA*x1-disB*mousex)/(disA-disB);
            posy=(disA*y1-disB*mousey)/(disA-disB);
            stick1.setPosition((int)posx,(int)posy);
            stick2.setPosition((int)posx,(int)posy);
        }

    }
}
