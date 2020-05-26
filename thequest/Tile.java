/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import java.util.ArrayList;

/**
 *
 * @author adamstreich
 */
public class Tile {
    private int loc;
    private ArrayList<HeroTeam> contents;
    private boolean canMoveInto;
    private boolean canEncounterFight;
    private boolean canShop;
    private char symbol;
    
    
    public Tile(int lc, boolean canMove, boolean canFight, boolean cS, char sym){
        contents = new ArrayList();
        loc = lc;
        canMoveInto = canMove;
        canEncounterFight = canFight;
        canShop = cS;
        symbol = sym;
    }
    
    //gets the symbol for the tile
    public char getSymbol(){
        char rt = ' ';
        if(isConEmpty() == false){
            HeroTeam temp = contents.get(0);
            rt = temp.getSym();
        }else{
            rt = this.symbol;
        }
        return rt;
    }
    
    public boolean isConEmpty(){
        return this.contents.isEmpty();
    }
    public ArrayList getCon(){
        return this.contents;
    }
    
    public boolean canMoveInto(){
        return this.canMoveInto;
    }
    
   public boolean canShop(){
        return this.canShop;
    }
   
   public boolean canFight(){
        return this.canEncounterFight;
    }
   
      public int getLoc(){
        return this.loc;
    }
    
    /*
    public HeroTeam getTeam(int id){
        if(contents.contains(id))
    }
*/
    //use this under the assumption that there is only 1 hero team
    public HeroTeam getAndRemoveTeam(){
        HeroTeam rt = (HeroTeam) contents.get(0);
        contents.remove(0);
        return rt;
    }
    
    //returns the team in that tile
    public HeroTeam getTeam(){
        HeroTeam rt = (HeroTeam) contents.get(0);
        
        return rt;
    }
    
    //gets rid of a team from a tile
    public void RemoveTeam(){  
        contents.remove(0);
    }   
    
    
    //puts a team in a tile
    public void placeTeam(HeroTeam team){
        contents.add(team);
    }

   
}
