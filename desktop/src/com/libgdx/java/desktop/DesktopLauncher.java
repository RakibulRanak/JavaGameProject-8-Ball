package com.libgdx.java.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.libgdx.java.main;
import static com.libgdx.java.utils.Constants.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=WIDTH;
		config.height=HEIGHT;
		config.backgroundFPS=60;
		config.foregroundFPS=60;
		new LwjglApplication(new main(), config);
	}
}
