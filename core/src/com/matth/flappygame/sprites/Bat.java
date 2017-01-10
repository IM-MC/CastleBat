package com.matth.flappygame.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by matth on 1/7/2017.
 */

public class Bat {
  private static final int GRAVITY = -15;
  private static final int MOVEMENT = 100;

  private Animation batAnimation;

  private Vector3 position;
  private Vector3 velocity;
  private Texture bat;
  private Texture texture;

  private Rectangle bounds;

  private Sound flap;
  private Sound dead;

  public Bat (int x, int y){
    position = new Vector3(x,y,0);
    velocity = new Vector3(0,0,0);
    texture = new Texture("picture1.png");
    bounds = new Rectangle(x,y,texture.getWidth()/2,texture.getHeight());
    batAnimation = new Animation(new TextureRegion(texture),2,0.5f);
    flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    dead = Gdx.audio.newSound(Gdx.files.internal("click2.ogg"));
  }

  public void update(float dt){
    batAnimation.update(dt);
    if(position.y > 0)
      velocity.add(0,GRAVITY,0);
    velocity.scl(dt);
    position.add(MOVEMENT*dt,velocity.y,0);
    if(position.y < 0)
      position.y = 0;
    velocity.scl(1/dt);
    bounds.setPosition(position.x,position.y);

  }

  public Vector3 getPosition() {
    return position;
  }

  public TextureRegion getTexture() {
    return batAnimation.getFrame();
  }

  public void jump(){
    velocity.y = 250;
    flap.play(0.5f);
  }

  public Rectangle getBounds(){
    return bounds;
  }

  public void dispose(){
    texture.dispose();
    flap.dispose();
    dead.play(3);
  }
}
