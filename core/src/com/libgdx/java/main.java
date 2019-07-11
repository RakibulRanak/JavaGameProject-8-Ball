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
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import static com.libgdx.java.utils.Constants.PPM;

public class main extends ApplicationAdapter {
	private boolean DEBUG = false;
	private OrthographicCamera camera;
	private Box2DDebugRenderer b2dr;
	World world;
	private Body player, platform, ground1, ground2, ground3, ground4, ground5, ground6;
	private SpriteBatch batch;
	private Texture tex, img;
	private Sprite sprite1, sprite2;

	@Override
	public void create() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w / 2, h / 2);
		world = new World(new Vector2(0, -0.98f), false);
		b2dr = new Box2DDebugRenderer();
		player = createBox(0, 0, 32, 32, false);
		platform = createBox(50, 50, 64, 32, true);
		ground1 = createBox(294, 115, 160, 0, true);
		ground2 = createBox(476, 115, 160, 0, true);
		ground3 = createBox(200, 210, 0, 160, true);
		ground4 = createBox(571, 210, 0, 160, true);
		ground5 = createBox(294, 307, 160, 0, true);
		ground6 = createBox(476, 307, 160, 0, true);
		batch = new SpriteBatch();
		tex = new Texture("parquet.jpg");
		img = new Texture("poolTable.png");
		sprite1 = new Sprite(img);
		sprite1.setPosition(Gdx.graphics.getWidth() / 2 - sprite1.getWidth() / 2,
				Gdx.graphics.getHeight() / 2 - sprite1.getHeight() / 2);
		sprite2 = new Sprite(tex);
		sprite2.setPosition(0, 0);


	}

	@Override
	public void render() {
		update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(sprite2, sprite2.getX(), sprite2.getY(), Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		batch.draw(sprite1, sprite1.getX(), sprite1.getY());
		batch.end();
		b2dr.render(world, camera.combined.scl(PPM));


	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false, width / 2, height / 2);
	}

	@Override
	public void dispose() {
		world.dispose();
		b2dr.dispose();
		batch.dispose();
		tex.dispose();
		img.dispose();

	}

	public void update(float delta) {
		world.step(1 / 60f, 6, 2);
		inputUpdate(delta);
		camera.update();
		//cameraUpdate(delta);
	}

	public void inputUpdate(float delta) {
		int horizontalForce = 0;
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			horizontalForce -= 1;
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			horizontalForce += 1;
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP))
			player.applyForceToCenter(0, 150, false);
		player.setLinearVelocity(horizontalForce * 5, player.getLinearVelocity().y);

	}
	//public void cameraUpdate(float delta)
	//{
	//Vector3 position=camera.position;
	//position.x=platform.getPosition().x*PPM;
	//position.y=platform.getPosition().y*PPM;
	//camera.position.set(position);
	//camera.update();

	//}
	public Body createBox(int x, int y, int width, int height, boolean isStatic) {
		Body pBody;
		BodyDef def = new BodyDef();
		if (isStatic)
			def.type = BodyDef.BodyType.StaticBody;
		else
			def.type = BodyDef.BodyType.DynamicBody;

		def.position.set(x / PPM, y / PPM);
		def.fixedRotation = true;
		pBody = world.createBody(def);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width / 2 / PPM, height / 2 / PPM);
		pBody.createFixture(shape, 1.0f);
		shape.dispose();
		return pBody;
	}
}


