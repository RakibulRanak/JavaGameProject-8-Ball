package Screen;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.libgdx.java.PlayGame;
import com.libgdx.java.main;

public class MenuScreen  implements Screen {

    public SpriteBatch batch;
    private Sprite menuimage;

    private Stage stage;
    private TextureAtlas textureAtlas;
    private Skin skin;
    private Table tablePlay,tableHelp, tableheading,tableAbout, tableExit;
    private TextButton buttonPlay, buttonExit, buttonHelp, buttonAbout, buttonBack;
    private BitmapFont fontWhite;
    private Label heading;


    TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();

    @Override
    public void show() {
        batch = new SpriteBatch();

        menuimage = new Sprite(new Texture("images/pool.jpg"));
        menuimage.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        textureAtlas = new TextureAtlas("ui/button.pack");
        skin = new Skin(textureAtlas);

        tablePlay = new Table(skin);
        tableHelp = new Table(skin);
        tableheading = new Table(skin);
        tableAbout = new Table(skin);
        tableExit = new Table(skin);


        tablePlay.setBounds(70,500,Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/4);
        tableHelp.setBounds(270,300,Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/4);
        tableAbout.setBounds(850,300,Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/4);
        tableExit.setBounds(1050,500,Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/4);
        tableheading.setBounds(360,550,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);

        fontWhite = new BitmapFont(Gdx.files.internal("ui/Myfont.fnt"));

        textButtonStyle.up = skin.getDrawable("Finalbutton");

        textButtonStyle.pressedOffsetX = 3;
        textButtonStyle.checkedOffsetY = -3;
        textButtonStyle.font = fontWhite;
        textButtonStyle.fontColor = Color.CYAN;


        buttonPlay = new TextButton("Play", textButtonStyle);
        buttonPlay.pad(20);

        buttonExit = new TextButton("Exit", textButtonStyle);
        buttonExit.pad(20);

        buttonHelp = new TextButton("Help" , textButtonStyle);
        buttonHelp.pad(20);

        buttonAbout = new TextButton("About",textButtonStyle);
        buttonAbout.pad(20);

        buttonBack = new TextButton("Back",textButtonStyle);
        buttonBack.pad(20);

        // Creating Heading
        Label.LabelStyle labelStyle = new Label.LabelStyle(fontWhite,Color.WHITE);
        heading = new Label("8 Ball Pool",labelStyle);
        heading.setFontScale(3);


        // buttons are added to table

        tableheading.add(heading);
        tablePlay.add(buttonPlay);
        tableHelp.add(buttonHelp);
        tableAbout.add(buttonAbout);
        tableExit.add(buttonExit);


        // tables are added to stage

        //tableAbout.debug();
        //tableExit.debug();
       // tableHelp.debug();tablePlay/

        stage.addActor(tablePlay);
        stage.addActor(tableHelp);
        stage.addActor(tableheading);
        stage.addActor(tableAbout);
        stage.addActor(tableExit);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        menuimage.draw(batch);
        batch.end();

        stage.act(delta);
        stage.draw();

        if(buttonPlay.isPressed()){
            ((Menu) Gdx.app.getApplicationListener()).setScreen( new main());
        }

        if(buttonHelp.isPressed()){
            ((Menu) Gdx.app.getApplicationListener()).setScreen(new Help(batch,fontWhite,skin, buttonBack));
        }

        if(buttonAbout.isPressed()){
            ((Menu) Gdx.app.getApplicationListener()).setScreen(new About(batch,fontWhite,skin, buttonBack));
        }

        if(buttonExit.isPressed())
        {
            Gdx.app.exit();
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
