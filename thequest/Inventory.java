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
public class Inventory {
        private ArrayList<Item> contents;

    public Inventory(ArrayList<Item> contents) {
        this.contents = contents;
        
    }
    
    //adds an item to the inv
    public void addItem(Item x){
        this.contents.add(x);
    }
    
    //removes an item from the inv
    public boolean removeItem(Item x){
        return this.contents.remove(x);
    }
    
    //chose int here insead of name to speed up gameplay
    public Item getItem(int x){
        return this.contents.get(x);
    }
    
    //return the number of items 
    public int numItms(){
        return contents.size();
    }
    
    //to string for inventory
    public String toString(){
        String rt = "Inventory :\n";
        for(int c = 0;c<contents.size();c++){
            rt += "("+(c+1)+") "+ contents.get(c).toString() + "\n";
        }
        return rt;
    }
}
