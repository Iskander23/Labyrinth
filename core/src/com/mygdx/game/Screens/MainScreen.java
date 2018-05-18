package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Iskander2 on 30.03.2018.
 */

public class MainScreen implements Screen {

    private Game game;
    private Stage stage;
    private Texture playTexture;
    private Texture levelTexture;


    public MainScreen(Game aGame){
        game = aGame;
        final Screen currentScreen = game.getScreen();
        stage = new Stage(new ScreenViewport());

        Gdx.app.log("Mainscreen"," New Main Screen started");

        Label title = new Label("Labyrinth", MyGdxGame.gameSkin);
        title.setFontScale(4f);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        playTexture = new Texture(Gdx.files.internal("play.png"));
        ImageButton playButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(playTexture)),new TextureRegionDrawable(new TextureRegion(playTexture)));
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
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
        playButton.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/4);
        stage.addActor(playButton);

        levelTexture = new Texture(Gdx.files.internal("menu.png"));
        ImageButton levelButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(levelTexture)), new TextureRegionDrawable(new TextureRegion(levelTexture)));
        levelButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new LevelScreen(game));
                if (currentScreen != null) {
                    currentScreen.dispose();
                }
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        levelButton.setPosition((Gdx.graphics.getWidth()*3/4 - levelButton.getWidth()), Gdx.graphics.getHeight()/4);
        stage.addActor(levelButton);
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
    Gdx.app.log("Mainscreen","screen is paused");
    this.dispose();
    }

    @Override
    public void dispose() {
    stage.dispose();
    }
}
