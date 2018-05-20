package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.Classes.Level;
import com.mygdx.game.Screens.MainScreen;

public class MyGdxGame extends Game {
	static public Skin gameSkin;
	public Level level;
	@Override
	public void create () {
		gameSkin = new Skin(Gdx.files.internal("Skin/lgdxs-ui.json"));
		this.setScreen(new MainScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
	}
}
