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
    World world;
    OrthographicCamera camera;
    ShapeRenderer shpRenderer;
    SpriteBatch batch;
    BitmapFont font;

    public WorldRenderer(World world) {
        this.world = world;
        float worldWidth = 480;
        float ppu = Gdx.graphics.getWidth() / worldWidth;
        float worldHeight = Gdx.graphics.getHeight() / ppu;
        camera = new OrthographicCamera(worldWidth, worldHeight);

        camera.position.set(worldWidth / 2, worldHeight / 2, 0); //camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();

        shpRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        font = new BitmapFont();

        Gdx.app.log("world Created", worldWidth + " x " + worldHeight + ", ppu = " + ppu);
    }

    public void render(){
        drawDoor();
        drawSpotlight();
        drawAliens();
        drawJoystick();
    }

    private void drawSpotlight() {
        shpRenderer.setProjectionMatrix(camera.combined);
        shpRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shpRenderer.setColor(Color.YELLOW);
        shpRenderer.circle(world.getSpotLight().getPosition().x, world.getSpotLight().getPosition().y, world.getSpotLight().getRadius());
        shpRenderer.end();
    }

    private void drawJoystick() {
        shpRenderer.setProjectionMatrix(camera.combined);
        shpRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shpRenderer.setColor(Color.LIGHT_GRAY);
        shpRenderer.circle(world.getJoystick().getPosition().x, world.getJoystick().getPosition().y, world.getJoystick().getRadius());
        shpRenderer.end();
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
                shpRenderer.setColor(alien.isSpoted() == false ? Color.BLUE : Color.RED);
                shpRenderer.circle(alien.getPosition().x, alien.getPosition().y, Alien.SIZE);
                batch.begin();
                font.draw(batch,"x: " + alien.getPosition().x + " y: " + alien.getPosition().y,alien.getPosition().x + Alien.SIZE*2, alien.getPosition().y + Alien.SIZE*2);
                batch.end();
            }
            shpRenderer.end();
        }
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
