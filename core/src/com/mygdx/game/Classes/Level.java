package com.mygdx.game.Classes;


import com.badlogic.gdx.utils.Array;

/**
 * Created by Iskander2 on 15.04.2018.
 */

public class Level {

    public Level(){
    }


    public int [][] level1 = {{0,1,1,0,0},
                              {0,0,1,1,0},
                              {0,0,0,1,1}};

    public int [][] level2 = {{0,1,1,0,0},
                              {0,0,1,1,0},
                              {0,0,0,1,1}};

    public int [][] level3 = {{0,1,1,0,0},
                              {0,0,1,1,0},
                              {0,0,0,1,1}};

    public int [][] level4 = {{0,1,1,0,0},
                              {0,0,1,1,0},
                              {0,0,0,1,1}};

    public int [][] level5 = {{0,1,1,0,0},
                              {0,0,1,1,0},
                              {0,0,0,1,1}};

    public int [] startPosition1 = {4,2};
    public int [] startPosition2 = {4,2};
    public int [] startPosition3 = {4,2};
    public int [] startPosition4 = {4,2};
    public int [] startPosition5 = {4,2};


    public int[][] getLevel(int id){
      //  if(id==1) {
      //      return level1;
      //  }
        return level1;
    }
    public int[] getStartPosition(int id){
        return startPosition1;
    }
}
