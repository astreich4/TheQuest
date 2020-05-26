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
public class Dragon extends Monster {
    
    public Dragon(String Name, int HP, int level, int defense, int dodgeChance, int damage) {
        super(Name, HP, level, defense, dodgeChance, damage);
        this.setDamage( (int) (this.getDamage() * 1.1) );
    }
    
    
    
}
