/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

package thequest;

import java.util.ArrayList;


 *
 * @author adamstreich

NONE OF THIS IS IMPLEMENTED, DIDNT DECIDE TO USE THIS, BUT DONT WANT TO DELETE IN CASE I WILL NEED IT
 
public class Fight {
    private HeroTeam Heros;
    private MonsterTeam Monsters;
    private int fHeros;
    private int fMonsters;

    public Fight(HeroTeam Heros, MonsterTeam Monsters) {
        this.Heros = Heros;
        this.Monsters = Monsters; 
        fHeros = Heros.getNumHeros();
        fMonsters = Monsters.getNumMonsters();
        
    }
    
    public HeroTeam happen() {
        HeroTeam rtTeam = this.Heros;
       //MonsterTeam mst = new MonsterTeam(hrs.getNumHeros(),hrs.getMaxLvl());
        System.out.println("Oh No!... Monsters have Appeared!");
        System.out.println(this.Monsters.toString());
        System.out.println("You must fight them to move on!");
        boolean fightOn = true;
        //this will be a toggle 1 for the heros 0 for the monsters
        int winner = 0;
        while(fightOn){
            //fight happens here
            for(int c = 0; c < this.Heros.getNumHeros();c++){
                
            }
            
            
            
        }
        
        
        //update the team to return
        return rtTeam;
    }
    
    public void hAttack(Hero hr, Monster ms){
        
        
    }
    
    public void mAttack(Hero hr, Monster ms){
        
        
    }
    
    
    public ArrayList<Hero> checkHHP(){
        ArrayList<Hero> fainted = new ArrayList<Hero>();
        for(int c = 0; c < this.fHeros;c++){
            Hero temp = Heros.getHero(c);
            if( temp.getHP() <= 0){
                fainted.add(temp);
            }
            
        }
        return fainted;
    }
    
    public ArrayList<Monster> checkMHP(){
        ArrayList<Monster> fainted = new ArrayList<Monster>();
        for(int c = 0; c < this.fMonsters;c++){
            Monster temp = Monsters.getMonster(c);
            if( temp.getHP() <= 0){
                fainted.add(temp);
            }
            
        }
        return fainted;
    }
    
    
}
*/
