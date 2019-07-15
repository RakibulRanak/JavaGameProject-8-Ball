package Screen;

import com.badlogic.gdx.Game;

public class Menu extends Game {


    @Override
    public void create(){
        setScreen(new MenuScreen());
    }
    @Override
    public void render(){
        super.render();

    }
}
