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
public class SpellBag {
    private ArrayList<Spell> contents;

    public SpellBag(ArrayList<Spell> contents) {
        this.contents = contents;
        
    }
    
    //adds a spell
    public void addSpell(Spell x){
        this.contents.add(x);
    }
    
    //removes a spell
    public boolean removeSpell(Spell x){
        return this.contents.remove(x);
    }
    
    //chose int here insead of name to speed up gameplay
    public Spell getSpell(int x){
        return this.contents.get(x);
    }

    //returns the number of spells in the bag
    public int numSpells(){
        return contents.size();
    }
    
    public String toString(){
        String rt = "Spell Bag:\n";
        for(int c = 0;c<contents.size();c++){
            rt += "("+(c+1)+") "+ contents.get(c).toString() + "\n";
        }
        return rt;
    }
}
