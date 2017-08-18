package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.model.Alien;
import com.mygdx.game.model.World;

/**
 * Created by alien on 12.08.2017.
 */

public class WorldRenderer {
    static final int WORLD_HEIGHT = 800;
    static final int WORLD_WIDTH = 480;

    World world;
    OrthographicCamera camera;
    ShapeRenderer shpRenderer;
    SpriteBatch batch;
    BitmapFont font;

    public WorldRenderer(World world) {
        this.world = world;
        float gdxW = Gdx.graphics.getWidth();
        float gdxH = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(WORLD_WIDTH, WORLD_WIDTH * (gdxH / gdxW));

        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();

        shpRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    public void render(){
        drawDoor();
        drawAliens();
    }

    private void drawDoor(){
        shpRenderer.setProjectionMatrix(camera.combined);
        shpRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shpRenderer.setColor(Color.GREEN);
        shpRenderer.rect(world.getDoor().getPosition().x, world.getDoor().getPosition().y, world.getDoor().getWidth(),world.getDoor().getHeight());
        shpRenderer.end();
    }


    private void drawAliens(){
        if (world.getAliens() != null) {
            shpRenderer.setProjectionMatrix(camera.combined);
            batch.setProjectionMatrix(camera.combined);
            shpRenderer.begin(ShapeRenderer.ShapeType.Filled);
            for (Alien alien : world.getAliens()) {
                shpRenderer.setColor(Color.BLUE);
                shpRenderer.circle(alien.getPosition().x, alien.getPosition().y, Alien.SIZE);
                batch.begin();
                font.draw(batch,"x: " + alien.getPosition().x + " y: " + alien.getPosition().y,alien.getPosition().x + Alien.SIZE*2, alien.getPosition().y + Alien.SIZE*2);
                batch.end();
            }
            shpRenderer.end();
        }
    }
}
