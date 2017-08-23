package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.controller.WorldController;
import com.mygdx.game.model.World;
import com.mygdx.game.view.WorldRenderer;

/**
 * Created by alien on 13.08.2017.
 */

public class GameScreen implements Screen, InputProcessor {
    MyGdxGame game;
    World world;
    WorldController controller;
    WorldRenderer renderer;
    Vector3 touchV, touchD;
    float touchX, touchY;
    //Gdx.input.setInputProcessor(this);

    public GameScreen(MyGdxGame game) {
        this.game = game;
        this.world = new World();
        this.controller = new WorldController(world);
        this.renderer = new WorldRenderer(world);
        this.touchV = new Vector3();
        this.touchD = new Vector3();
        Gdx.input.setInputProcessor(this);
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        controller.update(delta);
        renderer.render();
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
        Gdx.input.setInputProcessor(null);
    }


    // INPUT Processor
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchV.x = screenX;
        touchV.y = screenY;
        renderer.getCamera().unproject(touchV);
        //touchX = renderer.getCamera().position.x - renderer.getCamera().viewportWidth + touchV.x;
        //touchY = renderer.getCamera().position.y - renderer.getCamera().viewportHeight + touchV.y;

        if (touchV.y > world.getDoor().getPosition().y + world.getDoor().getHeight()) {
            world.addAlien(new Vector2(touchV.x, touchV.y));
        }

        if (Math.abs(world.getJoystick().getPosition().y - touchV.y) <= world.getJoystick().getRadius()) {
            if (Math.abs(world.getJoystick().getPosition().x - touchV.x) <= world.getJoystick().getRadius()) {
                world.getJoystick().touch(touchV.x, touchV.y);
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touchD.x = screenX;
        touchD.y = screenY;
        renderer.getCamera().unproject(touchD);

        if (Math.abs(world.getJoystick().getPosition().y - touchD.y) <= world.getJoystick().getRadius()) {
            if (Math.abs(world.getJoystick().getPosition().x - touchD.x) <= world.getJoystick().getRadius()) {
                world.getJoystick().touch(touchD.x, touchD.y);
            }
        }

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
