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
public class Armor extends Item{
    private int damage_reduc;
    
   
    public Armor(String name, int cost, int lvl_req, int damage_reduc) {
        super(name,cost,lvl_req);
        this.damage_reduc = damage_reduc;   
    }
    
    //way to get all the armor into an array list
    public static ArrayList<Armor> createAllArmor(){
        ArrayList<Armor> all = new ArrayList<Armor>();
        //added this in case I need it
        //all.add(new Armor("Bare_Skin",0,0,0));
        all.add(new Armor("Platinum_Shield",150,1,200));
        all.add(new Armor("Breastplate",350,3,600));
        all.add(new Armor("Full_Body_Armor",1000,8,1100));
        all.add(new Armor("Wizard_Shield",1200,10,1500));
        all.add(new Armor("Speed_Boots",550,4,600));
        return all;
    }
    
    //gets the damage reduction for the armor
    public int getDamageReduc(){
        return this.damage_reduc;
    }
    
    //basic toString
    public String toString(){
        String rt = "";
        rt+= this.getName() + " Costs: " + this.getCost() + " Level Required: " + this.getLvlReq()
                + " Damage Reduction: " + this.damage_reduc;
        return rt;
    }
    
    //returns the bare skin armor
    public static Armor getSkinArmor(){
        return new Armor("Bare_Skin",0,0,0);
    }

}
