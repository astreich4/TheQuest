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
public class Empty extends Tile{
   
    //builds an empty tile
    public Empty(int lc){
        super(lc,true,true,false,' ');
    }
    
    @Override
    //prints the tile as empty or with the hero team in it
    public char getSymbol(){
        char rt = ' ';
        if( this.isConEmpty()){
            
        } else {
            HeroTeam temp = (HeroTeam) this.getCon().get(0);
            rt = temp.getSym();
        }
        return rt;
    }
    
}
