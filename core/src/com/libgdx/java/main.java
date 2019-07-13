package com.libgdx.java;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import static com.libgdx.java.pocket.*;
import static com.libgdx.java.utils.Constants.*;

public class main extends ApplicationAdapter {

	private OrthographicCamera camera;
	boolean b0=true,b1=true,b2=true,b3=true,b4=true,b5=true,b6=true,b7=true,b8=true,b9=true,b10=true,b11=true,
	b12=true,b13=true,b14=true,b15=true;
	private Box2DDebugRenderer b2dr;
	balls ballmaker=new balls();
	World world;
	 Body player, balltray1,balltray2,balltray3,balltray4,platform, ground1, ground2, ground3, ground4, ground5, ground6,ball1
			,ball2,ball3,ball4,ball5,ball6,ball7,ball8,ball9,ball10,ball11,ball12,ball13,ball14,ball15,ballwhite;
	private SpriteBatch batch;
	private Texture background, board, striker, textureball1, textureball2, textureball3, textureball4, textureball5, textureball6,
			textureball7, table, textureball8, textureball9, textureball10, textureball11, textureball12,
			textureball13, textureball14, textureball15,ballbox;

	private Sprite sprite1, sprite2;

	@Override
	public void create() {


		System.out.println(Gdx.graphics.getWidth() + " " + Gdx.graphics.getHeight());
		world = new World(new Vector2(0,0), false);
		b2dr = new Box2DDebugRenderer();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth()/PPM, Gdx.graphics.getHeight()/PPM);

		player = ballmaker.createBall(450,422,14,false,world);
		ground1 = createBox(398, 424, 0, 323, true);
		ground2 = createBox(1140, 424, 0, 323, true);
		ground3 = createBox(587, 610, 316, 0, true);
		ground4 = createBox(587, 232, 316, 0, true);
		ground5 = createBox(952, 610, 316, 0, true);
		ground6 = createBox(952, 232, 316, 0, true);
		balltray1=createBox(770,32,466,0,true);
		balltray2=createBox(770,1,466,0,true);
		balltray3=createBox(545,20,0,40,true);
		balltray4=createBox(993,20,0,40,true);
		ball1=ballmaker.createBall(850,422,14,false,world);
		ball2=ballmaker.createBall(880,407,14,false,world);
		ball3=ballmaker.createBall(880,437,14,false,world);
		ball4=ballmaker.createBall(910,392,14,false,world);
		ball5=ballmaker.createBall(910,422,14,false,world);
		ball6=ballmaker.createBall(910,452,14,false,world);
		ball7=ballmaker.createBall(940,377,14,false,world);
		ball8=ballmaker.createBall(940,407,14,false,world);
		ball9=ballmaker.createBall(940,437,14,false,world);
		ball10=ballmaker.createBall(940,467,14,false,world);
		ball11=ballmaker.createBall(970,362,14,false,world);
		ball12=ballmaker.createBall(970,392,14,false,world);
		ball13=ballmaker.createBall(970,422,14,false,world);
		ball14=ballmaker.createBall(970,452,14,false,world);
		ball15=ballmaker.createBall(970,482,14,false,world);
		striker = new Texture("ball0.png");
		System.out.println(striker.getWidth());
		textureball1 = new Texture("ball1.png");
		textureball2 = new Texture("ball2.png");
		textureball3 = new Texture("ball3.png");
		textureball4 = new Texture("ball4.png");
		textureball5 = new Texture("ball5.png");
		textureball6 = new Texture("ball6.png");
		textureball7 = new Texture("ball7.png");
		textureball8 = new Texture("ball8.png");
		textureball9 = new Texture("ball9.png");
		textureball10 = new Texture("ball10.png");
		textureball11 = new Texture("ball11.png");
		textureball12 = new Texture("ball12.png");
		textureball13 = new Texture("ball13.png");
		textureball14 = new Texture("ball14.png");
		textureball15 = new Texture("ball15.png");
		ballbox=new Texture("Ballbox.png");

		batch = new SpriteBatch();
		background = new Texture("parquet.jpg");
		board = new Texture("poolTable.png");
		sprite1 = new Sprite(board);

		sprite1.setPosition(Gdx.graphics.getWidth() / 2 - sprite1.getWidth() / 2,
				Gdx.graphics.getHeight() / 2 - sprite1.getHeight() / 2);
		sprite2 = new Sprite(background);
		sprite2.setSize(1540, 845);
		sprite2.setPosition(0, 0);


	}

	@Override
	public void render() {
		inputUpdate(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite2.draw(batch);
		sprite1.draw(batch);
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
		//boolean b=ball1.overlape(ball2);

		batch.draw(ballbox,530,0);
		batch.end();
		//b2dr.render(world, camera.combined);
		world.step(1 / 60f, 6, 2);
		camera.update();


	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void dispose() {
		world.dispose();
		b2dr.dispose();
		batch.dispose();
		background.dispose();
		board.dispose();
		textureball1.dispose();
		textureball2.dispose();
		textureball3.dispose();
		textureball4.dispose();
		textureball5.dispose();
		textureball6.dispose();
		textureball7.dispose();
		textureball8.dispose();
		textureball9.dispose();
		textureball10.dispose();
		textureball11.dispose();
		textureball12.dispose();
		textureball13.dispose();
		textureball14.dispose();
		textureball15.dispose();
		wavSound1.dispose();
		wavSound2.dispose();

	}

	public void inputUpdate(float delta) {
		int horizontalForce = 0;
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			System.out.print("X=" + Gdx.input.getX());
			System.out.println(" Y=" + (HEIGHT - 1 - Gdx.input.getY()));
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
			player.applyForceToCenter(0, -50, false);
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			player.applyForceToCenter(-50, 0, false);
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			player.applyForceToCenter(50, 0, false);
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP))
			player.applyForceToCenter(0, 50, false);
		//player.setLinearVelocity(horizontalForce * 5, player.getLinearVelocity().y);

	}

	public Body createBox(int x, int y, int width, int height, boolean isStatic) {
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
		shape.dispose();
		return pBody;
	}
}
