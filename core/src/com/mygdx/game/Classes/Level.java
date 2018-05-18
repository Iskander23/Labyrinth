package com.mygdx.game.Classes;

/**
 * Created by Iskander2 on 15.04.2018.
 */

public class Level {
    public int [][] level1 = {{0,1,1,0,0},
                              {0,0,1,1,0},
                              {0,0,0,1,1}};
    public int [] startPosition1 = {4,2};

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
