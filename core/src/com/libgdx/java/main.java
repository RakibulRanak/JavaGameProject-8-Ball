package com.libgdx.java;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.libgdx.java.utils.Dispose;

import Screen.*;
import static com.libgdx.java.InputUpdate.inputUpdate;
import static com.libgdx.java.movement.stop;
import static com.libgdx.java.pocket.*;
import static com.libgdx.java.utils.Constants.*;

public class  main extends ApplicationAdapter implements Screen{

	private OrthographicCamera camera;
	boolean b0=true,b1=true,b2=true,b3=true,b4=true,b5=true,b6=true,b7=true,b8=true,b9=true,b10=true,b11=true,
	b12=true,b13=true,b14=true,b15=true;


	@Override
	public void create() {

	}


	@Override
	public void show() {

		Gdx.input.setInputProcessor(new InputProcessing());
		world = new World(new Vector2(0,0), false);
		world.setContactListener(new ListenerClass());
		Load.loadResource();
		b2dr = new Box2DDebugRenderer();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth()/PPM, Gdx.graphics.getHeight()/PPM);
		batch = new SpriteBatch();

	}
	@Override
	public void render(float delta){
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		inputUpdate(Gdx.graphics.getDeltaTime());
		//new InputProcessing();
		time+=Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite2.draw(batch);
		sprite1.draw(batch);
		ballboximg.draw(batch);

		spritePlayer1.draw(batch);
		spritePlayer2.draw(batch);

		if(player1) {
			spritePlayer1Arrow.draw(batch);
		}
		else {

			spritePlayer2Arrow.draw(batch);
		}

		if(b1)
			b1=check(ball1);
		batch.draw(textureball1, ball1.getPosition().x*PPM-(textureball1.getWidth()/2), ball1.getPosition().y*PPM-(textureball1.getWidth()/2), textureball1.getWidth(), textureball1.getHeight());
		if(b2)
			b2=check(ball2);
		batch.draw(textureball2, ball2.getPosition().x*PPM-(textureball2.getWidth()/2), ball2.getPosition().y*PPM-(textureball2.getWidth()/2), textureball2.getWidth(), textureball2.getHeight());
		if(b3)
			b3=check(ball3);
		batch.draw(textureball3, ball3.getPosition().x*PPM-(textureball3.getWidth()/2), ball3.getPosition().y*PPM-(textureball3.getWidth()/2), textureball3.getWidth(), textureball3.getHeight());
		if(b4)
			b4=check(ball4);
		batch.draw(textureball4, ball4.getPosition().x*PPM-(textureball4.getWidth()/2), ball4.getPosition().y*PPM-(textureball4.getWidth()/2), textureball4.getWidth(), textureball4.getHeight());
		if(b5)
			b5=check(ball5);
		batch.draw(textureball5, ball5.getPosition().x*PPM-(textureball5.getWidth()/2), ball5.getPosition().y*PPM-(textureball5.getWidth()/2), textureball5.getWidth(), textureball5.getHeight());
		if(b6)
			b6=check(ball6);
		batch.draw(textureball6, ball6.getPosition().x*PPM-(textureball6.getWidth()/2), ball6.getPosition().y*PPM-(textureball6.getWidth()/2), textureball6.getWidth(), textureball6.getHeight());
		if(b7)
			b7=check(ball7);

		batch.draw(textureball7, ball7.getPosition().x*PPM-(textureball7.getWidth()/2), ball7.getPosition().y*PPM-(textureball7.getWidth()/2), textureball7.getWidth(), textureball7.getHeight());
		if(b8)
			b8=check(ball8);

		batch.draw(textureball8, ball8.getPosition().x*PPM-(textureball8.getWidth()/2), ball8.getPosition().y*PPM-(textureball8.getWidth()/2), textureball8.getWidth(), textureball8.getHeight());
		if(b9)
			b9=check(ball9);

		batch.draw(textureball9, ball9.getPosition().x*PPM-(textureball9.getWidth()/2), ball9.getPosition().y*PPM-(textureball9.getWidth()/2), textureball9.getWidth(), textureball9.getHeight());
		if(b10)
			b10=check(ball10);
		batch.draw(textureball10, ball10.getPosition().x*PPM-(textureball10.getWidth()/2), ball10.getPosition().y*PPM-(textureball10.getWidth()/2), textureball10.getWidth(), textureball10.getHeight());
		if(b11)
			b11=check(ball11);
		batch.draw(textureball11, ball11.getPosition().x*PPM-(textureball11.getWidth()/2), ball11.getPosition().y*PPM-(textureball11.getWidth()/2), textureball11.getWidth(), textureball11.getHeight());
		if(b12)
			b12=check(ball12);

		batch.draw(textureball12, ball12.getPosition().x*PPM-(textureball12.getWidth()/2), ball12.getPosition().y*PPM-(textureball12.getWidth()/2), textureball12.getWidth(), textureball12.getHeight());
		if(b13)
			b13=check(ball13);
		batch.draw(textureball13, ball13.getPosition().x*PPM-(textureball13.getWidth()/2), ball13.getPosition().y*PPM-(textureball13.getWidth()/2), textureball13.getWidth(), textureball13.getHeight());
		if(b14)
			b14=check(ball14);

		batch.draw(textureball14, ball14.getPosition().x*PPM-(textureball14.getWidth()/2), ball14.getPosition().y*PPM-(textureball14.getWidth()/2), textureball14.getWidth(), textureball14.getHeight());
		if(b15)
			b15=check(ball15);

		batch.draw(textureball15, ball15.getPosition().x*PPM-(textureball15.getWidth()/2), ball15.getPosition().y*PPM-(textureball15.getWidth()/2), textureball15.getWidth(), textureball15.getHeight());
		if(b0)
		{
			boolean a=check(player);
			if(!a) {
				player.setLinearVelocity(0, 0);
				player.setTransform(450/ PPM, 422 / PPM, 0);
			}

		}
		batch.draw(striker, player.getPosition().x*PPM-(striker.getWidth()/2), player.getPosition().y*PPM-(striker.getWidth()/2), striker.getWidth(), striker.getHeight());
		//System.out.println(time);
		if((player1hit||player2hit) &&time>2)
		{
			balllstop=stop();
			if(balllstop)
			{
				stick1.setPosition(player.getPosition().x * PPM, player.getPosition().y * PPM);
				stick2.setPosition(player.getPosition().x * PPM, player.getPosition().y * PPM);
			}
			//System.out.println(balllstop);
		}
		if(player1 && player1hit && balllstop && solid==0 )
		{
			player1=false;
			player2=true;
			player1hit=false;
			STRIPE-=stripe;
		}
		else if((player1 && player1hit && balllstop && solid!=0))
		{
			player1hit=false;
			point1+=solid;
			SOLID-=solid;
			STRIPE-=stripe;
			if(cue==1)
			{
				player1=false;
				player2=true;
			}
		}
		if(player2 &&player2hit&& balllstop && stripe==0)
		{
			player2=false;
			player1=true;
			player2hit=false;
			SOLID-=solid;

		}
		else if(player2 &&player2hit&& balllstop && stripe!=0)
		{
			player2hit=false;
			point2+=stripe;
			SOLID-=solid;
			STRIPE-=stripe;
			if(cue==1)
			{
				player2=false;
				player1=true;
			}
		}
		if(balllstop||time<0.2) {

			if(player1)
				stick1.draw(batch);
			else
				stick2.draw(batch);
		}
		batch.draw(ballbox,530,0);

		batch.end();
		//b2dr.render(world, camera.combined);
		world.step(1 / 60f, 6, 2);
		camera.update();
		System.out.println(SOLID + " " + STRIPE);
		if(balllstop) {
			solid = 0;
			stripe = 0;
			cue = 0;
			eight = 0;
		}


		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
		{
			((Menu) Gdx.app.getApplicationListener()).setScreen(new MenuScreen());
		}
	}



	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

		Dispose.disposeing();
	}

}
