/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import static thequest.Armor.getSkinArmor;
import static thequest.Weapon.getBareHand;

/**
 *
 * @author adamstreich
 */
public class Body {
    private Armor armor;
    private Weapon holding;

    public Body( ) {
        this.armor = getSkinArmor();;  
        this.holding = getBareHand();
    }
    
    //method to take off a heros armor
    public Armor takeOffArmor(){
        Armor rt = null;
        if(this.armor.equals(getSkinArmor())){
            rt=rt;
        }else{
            rt = this.armor;
            this.armor = getSkinArmor();
        }
        return rt;
    }
    
    //gets how much damage reduction there should be on an defending an attack
    public int getDamageReduc(){
        return this.armor.getDamageReduc();
    }
    //gets how much damage there should be on an attack
    public int getDamage(){
        return this.holding.getDamage();
    }
    
    //method to put on armor for a hero
    public boolean putOnArmor(Armor x){
        boolean rt = false;
        if(this.armor.equals(getSkinArmor())){
            this.armor = x;
            rt = true;
        }else{
            rt = false;   
        }
        return rt;
    }
    
    //method to unequip / stop holding weapon;
        public Weapon putAwayWeapon(){
        Weapon rt = null;
        if(this.holding.equals(getBareHand())){
            rt=rt;
            //System.out.println("here");
        }else{
            //System.out.println("here1");
            //System.out.println(this.holding.toString());
            rt = this.holding;
            this.holding = getBareHand();
        }
        return rt;
    }
      
        
    //method to hold a weapon for a hero
    public boolean holdWeapon(Weapon x){
        boolean rt = false;
        if(this.holding.equals(getBareHand())){
            this.holding = x;
            rt = true;
        }else{
            rt = false;   
        }
        return rt;
    }

    @Override
    public String toString() {
        String rt = "\nCurently Wearing: \n";
        rt+= this.armor.toString() + "\n";
        rt+= "\nCurrently fighting with \n";
        rt+= this.holding.toString()+"\n";
        return rt;
    }
           
}
