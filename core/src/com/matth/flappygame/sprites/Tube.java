package com.matth.flappygame.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by matth on 1/7/2017.
 */

public class Tube {
  public static final int TUBE_WIDTH = 52;

  private Rectangle boundsTop, boundsBot;

  private Texture topTube;
  private Texture bottomTube;
  private Vector2 posTopTube, posBotTube;
  private Random rand;
  private static final int FLUCTUATION = 130;
  private static final int TUBE_GAP = 140;
  private static final int LOWEST_OPENING = 120;


  public Tube(float x){
    topTube = new Texture("castle_grey1.png");
    bottomTube = new Texture("tower_beige.png");
    rand = new Random();

    posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
    posBotTube = new Vector2(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());

    boundsTop = new Rectangle(posTopTube.x,posTopTube.y+70,topTube.getWidth(),topTube.getHeight());
    boundsBot = new Rectangle(posBotTube.x,posBotTube.y-70,bottomTube.getWidth(),bottomTube.getHeight());
  }

  public Texture getTopTube() {
    return topTube;
  }

  public Texture getBottomTube() {
    return bottomTube;
  }

  public Vector2 getPosTopTube() {
    return posTopTube;
  }

  public Vector2 getPosBotTube() {
    return posBotTube;
  }

  public void reposition(float x){
    posTopTube.set(x,rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
    posBotTube.set(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());
    boundsTop.setPosition(posTopTube.x,posTopTube.y+70);
    boundsBot.setPosition(posBotTube.x,posBotTube.y-70);
  }

  public boolean collides(Rectangle player){
    return (player.overlaps(boundsTop) || player.overlaps(boundsBot));
  }

  public void dispose(){
    topTube.dispose();
    bottomTube.dispose();
  }
}
