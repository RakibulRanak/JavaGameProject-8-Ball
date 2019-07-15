package com.libgdx.java;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.physics.box2d.*;
import static com.libgdx.java.utils.Constants.*;

public class pocket {


    public static boolean check (Body ball)
    {
        float x=ball.getPosition().x*PPM;
        float y=ball.getPosition().y*PPM;
        int a=0;
        if(x<406 ||x>1131 ||y<226||y>610 ) {
            a=1;
        }
        if(a==1) {
            if(ball.getUserData()!="Striker") {
                if (ball.getUserData() == "BallSolid") {
                    solid++;
                } else if (ball.getUserData() == "BallStripe") {
                    stripe++;
                } else if (ball.getUserData() == "Ball8") {

                    if (player1) {
                        if (SOLID > 0)
                            System.out.println("Player2 Wins");
                        else
                            System.out.println("Player1 Wins");
                    }
                    if (player2) {
                        if (STRIPE > 0)
                            System.out.println("Player1 Wins");
                        else
                            System.out.println("Player2 Wins");
                    }
                    //Game Ends Here
                }

                ballinpocket.play();
                ballroll.play();
                ball.setLinearVelocity(0, 0);
                ball.setTransform(970 / PPM, 15 / PPM, 0);
                ball.applyForceToCenter(-15, 0, false);
            }
            else
            {
                cuepocket.play();
            }

            return false;
        }
        else
            return true;
    }
}

