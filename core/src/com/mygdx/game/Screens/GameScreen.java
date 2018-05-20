package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Classes.Level;

/**
 * Created by Iskander2 on 30.03.2018.
 */

public class GameScreen implements Screen {
    private Game game;
    private Camera cam;
    private Model model;
    private Model model1;
    private Array<ModelInstance> instances = new Array<ModelInstance>();
    private ModelInstance heroInstance;
    private ModelBatch modelBatch;
    private Environment environment;
    private ModelBuilder modelBuilder = new ModelBuilder();
    private AssetManager assets;

    int [][] currentLevel;
    int [] currentPosition;
    public CameraInputController camController;
    private boolean loading;

    public GameScreen(Game aGame){
        game = aGame;
        setUpCam();
        setUpLevel();
        setUpHero();
        setUpEnvironment();
        createBox();
        loading = true;
        Gdx.app.log("","Loaded");
    }

    @Override
    public void show() {

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
        modelBatch.dispose();
        model.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camController.update();
        modelBatch.begin(cam);
        for (ModelInstance instance: instances) {
            modelBatch.render(instance,environment);
        }
        if(loading) {
            if (assets.update()) {
                Model hero = assets.get("Models/newpicka.g3db",Model.class);
                heroInstance = new ModelInstance(hero,25f,-1.25f,-7.5f);
                instances.add(heroInstance);
                loading = false;
            }
        }
        modelBatch.end();
    }

    private void setUpHero(){
        modelBatch = new ModelBatch();
        assets = new AssetManager();
        assets.load("Models/pikachu.g3db", Model.class);

    }

    private void setUpLevel(){
        Level level = new Level();
        currentLevel = level.getLevel(1);
        currentPosition = level.getStartPosition(1);
    }

    private void setUpCam(){
        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        cam.position.set(35f,10f,-7);
        cam.lookAt(25f,0f,-7f);
        cam.near = 5f;
        cam.far = 300f;
        cam.update();
        camController = new CameraInputController(cam);
        Gdx.input.setInputProcessor(camController);
    }

    private void movement(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){

        }
    }

    private void  setUpEnvironment(){
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f,0.4f,0.4f,1f));
        environment.add(new DirectionalLight().set(0.8f,0.8f,0.8f,-10f,-10f,-10f));
    }

    private void createBox(){
        model = modelBuilder.createBox(5f,2f,5f, new Material(ColorAttribute.createDiffuse(Color.GRAY)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        for (int i = 0; i < currentLevel.length ; i++) {
            for (int j = 0; j < currentLevel[0].length; j++) {
                if(currentLevel[i][j]==1){
                    Gdx.app.log("Gamescreen","Added new box");
                    if (i<currentPosition[0]){
                        if (j<currentPosition[1]){
                            instances.add(new ModelInstance(model,5*(currentPosition[0]+i),-2.5f,-2.5f+5*(currentPosition[1]-j)));
                        }
                        if (j==currentPosition[1]){
                            instances.add(new ModelInstance(model,5*(currentPosition[0]+i),-2.5f,-2.5f));
                        }
                        if (j>currentPosition[1]){
                            instances.add(new ModelInstance(model,5*(currentPosition[0]+i),-2.5f,-2.5f-5*(j-currentPosition[1])));
                        }
                    }
                    if (i==currentPosition[0]){
                        if (j<currentPosition[1]){
                            instances.add(new ModelInstance(model,0,-2.5f,-2.5f+5*(currentPosition[1]-j)));
                        }
                        if (j>currentPosition[1]){
                            instances.add(new ModelInstance(model,0,-2.5f,-2.5f-5*(currentPosition[1]-j)));
                        }
                    }
                    if (i>currentPosition[0]){
                        if (j<currentPosition[1]){
                            instances.add(new ModelInstance(model,-5*(i-currentPosition[0]),-2.5f,-2.5f+5*(currentPosition[1]-j)));
                        }
                        if (j==currentPosition[1]){
                            instances.add(new ModelInstance(model,-5*(i-currentPosition[0]),-2.5f,-2.5f));
                        }
                        if (j>currentPosition[1]){
                            instances.add(new ModelInstance(model,-5*(i-currentPosition[0]),-2.5f,-2.5f-5*(j-currentPosition[1])));
                        }
                    }
                }
            }
        }
    }



}
