package Screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import static Screen.MenuScreen.*;
import static com.libgdx.java.utils.Constants.*;


public class Win implements Screen {
    private Stage stageNow;
    SpriteBatch batch;
    Sprite player1Won, player2Won;

    public Win(SpriteBatch batch){
        this.batch = batch;
    }

    @Override
    public void show() {
        player1Won = new Sprite(new Texture("images/player1won.jpg"));
        player1Won.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        player2Won = new Sprite(new Texture("images/player2won.jpg"));
        player2Won.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        stageNow = new Stage();
        Gdx.input.setInputProcessor(stageNow);

        tableAbout = new Table(skin);
        tableAbout.setBounds(1250,700,Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/4);

        tableAbout.add(buttonBack);
        //tableBack.debug();
        stageNow.addActor(tableAbout);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if(checkWin ==1)
            player1Won.draw(batch);
        else
            player2Won.draw(batch);
        batch.end();

        stageNow.act(delta);
        stageNow.draw();

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
