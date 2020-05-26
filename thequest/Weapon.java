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
public class Weapon extends Item{

    private int damage;
    private int req_hand;
    
    public Weapon(String name, int cost, int lvl_req, int damage, int req_hand ) {
        super(name,cost,lvl_req);
        this.damage = damage;
        this.req_hand = req_hand;
       
    }
    
    //way to get all the weapons
    public static ArrayList<Weapon> createAllWeapons(){
        ArrayList<Weapon> all = new ArrayList<Weapon>();
        //added this in case I need it
        //all.add(new Weapon("Bare_Hand",0,0,0,1));
        all.add(new Weapon("Sword",500,1,800,1));
        all.add(new Weapon("Bow",300,2,500,2));
        all.add(new Weapon("Scythe",1000,6,1100,2));
        all.add(new Weapon("Axe",550,5,850,1));
        all.add(new Weapon("Shield",400,1,100,1));
        all.add(new Weapon("Tswords",1400,8,1600,2));
        all.add(new Weapon("Dagger",200,1,250,1));


        return all;
    }
    
    public int getDamage(){
        return this.damage;
    }
 
    
    //basic toString
    public String toString(){
        String rt = "";
        rt+= this.getName() + " Costs: " + this.getCost() + " Level Required: " + this.getLvlReq()
                + " Damage: " + this.damage;
        return rt;
    }
    
    //returns the bare hands 
    public static Weapon getBareHand(){
        return new Weapon("Bare_Hand",0,0,100,1);
    }
    
    
}
