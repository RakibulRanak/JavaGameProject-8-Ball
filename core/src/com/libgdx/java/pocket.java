

package com.libgdx.java;
        import Screen.Menu;
        import Screen.Win;
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
                }
                else if (ball.getUserData() == "BallStripe") {
                    stripe++;
                }
                else if (ball.getUserData() == "Ball8") {

                    if (player1) {
                        if (SOLID > 0) {
                            System.out.println("Player2 Wins");
                            checkWin=2;

                        }
                        else {
                            System.out.println("Player1 Wins");
                            checkWin=1;

                        }

                    }
                    else if (player2) {
                        if (STRIPE > 0) {
                            System.out.println("Player1 Wins");
                            checkWin=1;
                        }
                        else {
                            System.out.println("Player2 Wins");
                            checkWin=2;
                        }
                    }
                    SOLID=7;
                    STRIPE=7;
                    player1=true;
                    player2=false;
                    point1=0;
                    point2=0;
                    cuegorte=0;
                    disB=20;
                    winsound.play();
                    ((Menu) Gdx.app.getApplicationListener()).setScreen(new Win(batch));
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
                if(cuegorte==0)
                   cuepocket.play();
                cue=1;
                cuegorte=1;
            }

            return false;
        }
        else
            return true;
    }
}