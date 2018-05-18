package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import sun.java2d.ScreenUpdateManager;

/**
 * Created by Iskander2 on 30.03.2018.
 */

public class LevelScreen implements Screen {
    private Game game;
    private final Screen currentScreen;

    public LevelScreen(Game aGame){
        game = aGame;
        currentScreen = game.getScreen();
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.6f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        try {
            if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
                Gdx.app.log("BackKeyIsPressed", "true");
                game.setScreen(new MainScreen(game));
                currentScreen.dispose();
            }
        } catch (Exception e){
            e.printStackTrace();
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
