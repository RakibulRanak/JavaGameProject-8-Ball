package com.libgdx.java.desktop;

import Screen.Menu;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import static com.libgdx.java.utils.Constants.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=WIDTH;
		config.height=HEIGHT;
		config.backgroundFPS=60;
		config.foregroundFPS=60;
		//config.resizable=false;
		//config.fullscreen=true;
		new LwjglApplication(new Menu(), config);

	}
}
