/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

/**
 *
 * @author adamstreich
 */
public class Spell {
    private String name;
    private int cost;
    private int lvl_req;
    private int damage;
    private int mana_cost;

    public Spell(String name, int cost, int lvl_req, int damage, int mana_cost) {
        this.name = name;
        this.cost = cost;
        this.lvl_req = lvl_req;
        this.damage = damage;
        this.mana_cost = mana_cost; 
    }
    
    
    //getters
     public int getCost(){
        return this.cost;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getLvlReq(){
        return this.lvl_req;
    }

    public int getMana_cost() {
        return mana_cost;
    }

    public int getDamage() {
        return damage;
    }
    
    //overides below
    
    public String toString(){
        String rt = "";
        rt+= this.name + " Costs: " + this.cost + " Level Required: " + this.lvl_req
                + " Damage: " + this.damage + " Mana cost: " + this.mana_cost;
        return rt;
    }
    
   //check equality of spells by name
    public boolean equals(Object obj){
        boolean rt = false;
        if(obj == null){
            rt = false;
        }
        Spell other = (Spell) obj;
        if(this.name.equals(other.name)){
            rt=true;
        }else{
            rt = false;
        }
        return rt;
    }
}
