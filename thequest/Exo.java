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
public class Exo extends Monster {
    
    public Exo(String Name, int HP, int level, int defense, int dodgeChance, int damage) {
        super(Name, HP, level, (int) (defense * 1.1), dodgeChance, damage);
    }
    
}
