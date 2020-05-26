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
public class Potion extends Item{
    private int attribute_increase;
    private String attribute;
    
    public Potion(String n, int c, int lq,String atr, int ai) {
        super(n, c, lq);
        attribute = atr;
        attribute_increase = ai;
        
    }
    
    //builds all the potions
     public static ArrayList<Potion> createAllPotions(){
        ArrayList<Potion> all = new ArrayList<Potion>();
        //One is good for testing
        all.add(new HPPotion("Healing_Potion",250,1,"HP",100));
        
        return all;
    }
    
    /*
    //gets the damage reduction for the armor
    public int getDamageReduc(){
        return this.damage_reduc;
    }
    */
    //basic toString
    public String toString(){
        String rt = "";
        rt+= this.getName() + " Costs: " + this.getCost() + " Level Required: " + this.getLvlReq() + " Atrribute: " +
                this.attribute + " Attribute Increase: " + this.attribute_increase;
        return rt;
    }
    
    //allows the hero to use the potion
    public void use(Hero hr) {
        //checks to see what instance of a potion it is ie what will it do
        if(this instanceof HPPotion){
            hr.setHP(hr.getHP()+this.attribute_increase);
            System.out.println("Success! Your HP went up by "+ this.attribute_increase);
        }
    }
    
}
