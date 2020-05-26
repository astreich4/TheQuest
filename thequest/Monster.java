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
public class Monster extends Character{
    private String Name;
    private int HP; 
    private int level;
    private int defense;
    private int dodgeChance;
    private int damage;

    public Monster(String Name, int HP, int level, int defense, int dodgeChance, int damage) {
        this.Name = Name;
        this.HP = HP;
        this.level = level;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
        this.damage = damage;
        
    }

    //getters
    public String getName() {
        return Name;
    }

    public int getLevel() {
        return level;
    }

    public int getHP() {
        return HP;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public int getDefense() {
        return defense;
    }

    public int getDamage() {
        return damage;
    }

    //setters
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    
   public String toString(){
        String rt = "";
         rt +=this.Name +" HP: "+ this.HP;
        
        return rt;
    }
    
    
    
    
}
