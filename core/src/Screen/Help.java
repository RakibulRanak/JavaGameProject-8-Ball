package Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Help implements Screen {
    public SpriteBatch batch;
    private Sprite help;

    private Stage stage;
    private Skin skin;
    private Table tableBack;
    private TextButton buttonBack;
    private BitmapFont fontWhite;


    public Help(SpriteBatch batch,BitmapFont fontWhite, Skin skin, TextButton buttonBack)
    {
        this.batch = batch;
        this.fontWhite = fontWhite;
        this.skin = skin;
        this.buttonBack = buttonBack;
    }
    @Override
    public void show() {
        help = new Sprite(new Texture("images/Help.png"));
        help.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        tableBack = new Table(skin);
        tableBack.setBounds(1250,700,Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/4);

        tableBack.add(buttonBack);
        //tableBack.debug();
        stage.addActor(tableBack);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        help.draw(batch);
        batch.end();

        stage.act(delta);
        stage.draw();

        if(buttonBack.isPressed()){
           ((Menu) Gdx.app.getApplicationListener()).setScreen(new MenuScreen());
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
