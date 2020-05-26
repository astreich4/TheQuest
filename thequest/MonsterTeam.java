/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author adamstreich
 * 
 * This class was added late in development, and illustrates how I would probably go back and change
 * how I designed the heroTeam class and pickHero methods.
 */
public class MonsterTeam {
    private static final int MONSTER_OPTIONS = 3;
    private int numMonsters;
    private ArrayList<Monster> monsterList;
    private int maxLvl;
    private static final int EFFECT_OF_SPELLS = 10;

    public MonsterTeam(int numMonsters, int maxLvl) {
        this.numMonsters = numMonsters;
        this.monsterList = new ArrayList<Monster>();
        for(int c = 0; c< numMonsters;c++){
            monsterList.add(generateMonster(maxLvl));
        }
        this.maxLvl = maxLvl;
        
    }
    
    
    public static Monster generateMonster(int maxLvl){
        Monster rt = null;
        Random rand = new Random();
        //gets the random int
        int int1 = rand.nextInt(MONSTER_OPTIONS);
        //not sure if there is a bettwe way to do this that makes it more expandable
        //but pressed for time this will have to do
        if(int1 == 0){
            //Dragon here 
            rt = getDragon(maxLvl);
        }else if(int1 ==1){
            //Exo here
            rt = getExo(maxLvl);
        }else if(int1 == 2){
            //Spirit here 
            rt=getSpirit(maxLvl);
        } 
        return rt;
    }
    
    //my algorithm for deciding how much damage a certian level monster can hit with
    public static int damageAlg(int x){
        return (int) (pow(x,2.5)+(x*20));
    }
    
    //all the possible dragons and then a random one is chosen 
    public static Dragon getDragon(int maxLvl){
        //can add more monsters, but one is fine for testing
        ArrayList<Dragon> drgs = new ArrayList<>();
        //everything is based of 100, the special attributes are taken care of in the constructors
        //the dodge will fluctuate but always increase, however it will never get over 100, becassue then it would be imposible to fight
        drgs.add(new Dragon("Hungarian Horntail", maxLvl*100, maxLvl, maxLvl*10,((((maxLvl * 10)%50)+maxLvl)%100),damageAlg(maxLvl)));
        
        Random rand = new Random();
        //gets the random int
        int int1 = rand.nextInt(drgs.size());
        return drgs.get(int1);   
    }
    
    //all the possible exos and then a random one is chosen 
    public static Exo getExo(int maxLvl){
        //can add more monsters, but one is fine for testing
        ArrayList<Exo> exos = new ArrayList<>();
        //everything is based of 100, the special attributes are taken care of in the constructors
        //the dodge will fluctuate but always increase, however it will never get over 100, becassue then it would be imposible to fight
        exos.add(new Exo("Bag O' Bones", maxLvl*100, maxLvl, maxLvl*10,((((maxLvl * 10)%50)+maxLvl)%100),damageAlg(maxLvl)));
        
        Random rand = new Random();
        //gets the random int
        int int1 = rand.nextInt(exos.size());
        return exos.get(int1);   
    }
    
    //all the possible spirits and then a random one is chosen 
    public static Spirits getSpirit(int maxLvl){
        //can add more monsters, but one is fine for testing
        ArrayList<Spirits> spts = new ArrayList<>();
        //everything is based of 100, the special attributes are taken care of in the constructors
        //the dodge will fluctuate but always increase, however it will never get over 100, becassue then it would be imposible to fight
        spts.add(new Spirits("Casper", maxLvl*100, maxLvl, maxLvl*10,((((maxLvl * 10)%50)+maxLvl)%100),damageAlg(maxLvl)));
        
        Random rand = new Random();
        //gets the random int
        int int1 = rand.nextInt(spts.size());
        return spts.get(int1);   
    }
    
    
    //getters
    public int getNumMonsters() {
        return numMonsters;
    }
    
    public Monster getMonster(int x){
       return (Monster) this.monsterList.get(x);
   }
    
    
    //method to comprehend incoming regular attacks
    public void takeDamageA(int amount, int monsterNum){
        if(this.getMonster(monsterNum).getHP()>0){
            Monster current = this.getMonster(monsterNum);
            Random rand = new Random();
            //gets the random int
            int int1 = rand.nextInt(101);
            if(int1>current.getDodgeChance()){
                int temp = amount - current.getDefense();
                if (temp >0){
                    this.getMonster(monsterNum).setHP(current.getHP() - temp);
                System.out.println("\nThe attack Hit! You did "+ temp+" damage to "+current.getName());
                }else{
                    System.out.println("\nThat attack wasnt strong enough to hurt...");
                }
                
            }else{
                System.out.println("\nThe monster dodged your attack.");
            }
        }else{
            //find new opponenet
            for(int c = 0; c< this.numMonsters;c++){
                if(this.getMonster(c).getHP()>0){
                    Monster current = this.getMonster(c);
                    Random rand = new Random();
                    //gets the random int
                    int int1 = rand.nextInt(101);
                    if(int1>current.getDodgeChance()){
                        int temp = amount - current.getDefense();
                        if (temp >0){
                            current.setHP(current.getHP() - temp);
                            System.out.println("\nThe attack Hit! You did "+ temp+" damage to "+current.getName());
                        }else{
                            System.out.println("\nThat attack wasnt strong enough to hurt...");
                        } 
                    }else{
                    System.out.println("\nThe monster dodged your attack."); 
                    }
                }
            }
        }
    }
    
    //method to take damage from a spell - spells cant be dodged nor can monsters defend against them, they are magical like that 
    public void takeDamageS(Spell s, int damage, int monsterNum){
            if(this.getMonster(monsterNum).getHP()>0){
            Monster current = this.getMonster(monsterNum);
            
                this.getMonster(monsterNum).setHP(current.getHP() - damage);
                System.out.println("The Spell worked! You did "+ damage+" damage to "+current.getName());
                System.out.println("You also lowwered their...");
                if( s instanceof ISpell){
                    this.getMonster(monsterNum).setDamage(current.getDamage()-EFFECT_OF_SPELLS);
                    System.out.println("... Damage Range by "+EFFECT_OF_SPELLS);
                }else if(s instanceof FSpell){
                    this.getMonster(monsterNum).setDefense(current.getDefense()-EFFECT_OF_SPELLS);
                    System.out.println("... Defense by "+EFFECT_OF_SPELLS);
                }else if(s instanceof LSpell){
                    this.getMonster(monsterNum).setDodgeChance(current.getDodgeChance()-EFFECT_OF_SPELLS);
                    System.out.println("... Dodge Chance by "+EFFECT_OF_SPELLS);
                }
            
        }else{
            //find new opponenet
            for(int c = 0; c< this.numMonsters;c++){
                if(this.getMonster(c).getHP()>0){
                    
                    Monster current = this.getMonster(c);
            
                current.setHP(current.getHP() - damage);
                System.out.println("The Spell worked! You did "+ damage+" damage to "+current.getName());
                System.out.println("You also lowwered their...");
                if( s instanceof ISpell){
                    current.setDamage(current.getDamage()-EFFECT_OF_SPELLS);
                    System.out.println("... Damage Range by "+EFFECT_OF_SPELLS);
                }else if(s instanceof FSpell){
                    current.setDefense(current.getDefense()-EFFECT_OF_SPELLS);
                    System.out.println("... Defense by "+EFFECT_OF_SPELLS);
                }else if(s instanceof LSpell){
                    current.setDodgeChance(current.getDodgeChance()-EFFECT_OF_SPELLS);
                    System.out.println("... Dodge Chance by "+EFFECT_OF_SPELLS);
                }  
                    
                }
            }
        }
    }
    
    //returns true if the monsters can still fight, false if not 
    public boolean checkMHP(){
        boolean rt = true;
        
        int numFainted = 0;
        for(int c = 0; c < this.numMonsters;c++){
            Monster temp = this.getMonster(c);
            if( temp.getHP() <= 0){
                numFainted++;
                System.out.println(temp.getName()+" has fainted and is no longer in the fight..");
            }
        }
        if(numFainted == this.numMonsters){
            rt =false;
        }
        return rt;
    }
    
    //lets the team attack
    public void attack(HeroTeam hr){
       for(int c = 0; c < this.numMonsters;c++){
           Monster current = this.getMonster(c);
                if(current.getHP()>0){
                    //monsters attack
                    hr.takeDamageA(current.getDamage(), c);  
                }
       }
    }
    
    //returns the relevant stats for a monster team in a fight
    public String fightStats(){
        String rt = "\n----------Non Fainted Monster Stats--------\n";
        for(int c = 0; c< this.numMonsters;c++){
            Monster current = (Monster) this.monsterList.get(c);
            if(current.getHP()>0){
                rt+=current.getName()+" is still fighting! HP: "+current.getHP()+"\n";
            }
        }
        return rt;
    }
    
    public String toString(){
       String rt ="";
       for(int c = 0;c< this.monsterList.size();c++){
           rt+= "("+(c+1)+")"+this.monsterList.get(c).toString() + "\n";
       }
       return rt;
   }
    
}
