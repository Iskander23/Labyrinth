package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.List;

import sun.java2d.ScreenUpdateManager;

/**
 * Created by Iskander2 on 30.03.2018.
 */

public class LevelScreen implements Screen {
    private Game game;
    private final Screen currentScreen;
    private Array<Texture> levels = new Array<Texture>();
    private String pngNumber;
    private Array<ImageButton> buttons = new Array<ImageButton>();
    private Stage stage;
    private String path;
    private int currentButton;
    public LevelScreen(Game aGame){
        game = aGame;
        currentScreen = game.getScreen();
        Gdx.input.setCatchBackKey(true);
        setLevelButtons();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        try {
            if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
                Gdx.app.log("BackKeyIsPressed", "true");
                game.setScreen(new MainScreen(game));
                if (currentScreen != null) {
                    currentScreen.dispose();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void setLevelButtons(){
        stage = new Stage(new ScreenViewport());
        for (int i = 0; i <= 1 ; i++) {
            for (int j = 0; j <=3 ; j++) {
                currentButton++;
                Gdx.app.log("CurrentButton ",Integer.toString(currentButton));
                pngNumber = Integer.toString(currentButton);
                path = "Buttons/00"+pngNumber+".png";
                Gdx.app.log("Path ",path);
                levels.add(new Texture(Gdx.files.internal(path)));
                buttons.add(new ImageButton(new TextureRegionDrawable(new TextureRegion(levels.get(currentButton-1))),new TextureRegionDrawable(new TextureRegion(levels.get(currentButton-1)))));
                buttons.get(currentButton-1).addListener(new InputListener(){
                    @Override
                    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                        Gdx.app.log("isPressed","ofc its pressed");
                        game.setScreen(new GameScreen(game));
                        if (currentScreen != null) {
                            currentScreen.dispose();
                        }
                    }
                    @Override
                    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                        return true;
                    }
                });
                buttons.get(currentButton-1).setPosition(Gdx.graphics.getWidth()*(j+1)/5,Gdx.graphics.getHeight()*(3-i*2)/4);
                stage.addActor(buttons.get(currentButton-1));
            }
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
    this.dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
