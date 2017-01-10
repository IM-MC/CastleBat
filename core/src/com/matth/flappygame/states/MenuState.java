package com.matth.flappygame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matth.flappygame.FlappyBirdRemake;

/**
 * Created by matth on 1/7/2017.
 */

public class MenuState extends State {
  private Texture background;
  private Texture playBtn;
  public MenuState(GameStateManager gsm) {
    super(gsm);
    cam.setToOrtho(false, FlappyBirdRemake.WIDTH/2,FlappyBirdRemake.HEIGHT/2);

    background = new Texture("colored_castle.png");
    playBtn = new Texture("start.png");
  }

  @Override
  public void handleInput() {
    if(Gdx.input.justTouched()){
      gsm.set(new PlayState(gsm));
    }
  }

  @Override
  public void update(float dt) {
    handleInput();
  }

  @Override
  public void render(SpriteBatch sb) {
    sb.begin();
    sb.setProjectionMatrix(cam.combined);
    sb.draw(background,0,0, FlappyBirdRemake.WIDTH, FlappyBirdRemake.HEIGHT);
    sb.draw(playBtn,cam.position.x-playBtn.getWidth()/2,cam.position.y);
    sb.end();
  }

  @Override
  public void dispose() {
    background.dispose();
    playBtn.dispose();
    System.out.println("MenuState Disposed!");
  }
}
