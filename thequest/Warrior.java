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
public class Warrior extends Hero{
    
    
    //an array list of each type of warrior
    private static ArrayList<ArrayList> Warriors;
    private static final double Special_LEVELUP_GAIN =1.05;
       
    public Warrior(int id) {
        super(id);        
    }
    /*
    //need to chnaged this to take in an array of options and the number
    public static ArrayList<Object> getHero(int x){
        ArrayList<Object> rt = null;
        if(x == 1){
            rt = GI;
        } 
        return rt;
    }
*/
    //would do this differently going back over this
    public static ArrayList<ArrayList> getWarriorList(){
        
       ArrayList<Object> GI = new ArrayList<Object>();
       GI.add("Gaerdal_Ironhand");
       GI.add(100);//hp
       GI.add(100);//mana
       GI.add(700);
       GI.add(500);
       GI.add(600);
       GI.add(1354);
       GI.add(7);
    
    
       ArrayList<Object> SM = new ArrayList<Object>();
       SM.add("Sehanine_Monnbow");
              SM.add(100);

       SM.add(600);
       SM.add(700);
       SM.add(800);
       SM.add(500);
       SM.add(2500);
       SM.add(8);
    
    
    ArrayList<Object> MD = new ArrayList<Object>();
       MD.add("Muamman_Duathall");
              MD.add(100);

       MD.add(300);
       MD.add(900);
       MD.add(500);
       MD.add(750);
       MD.add(2546);
       MD.add(6);
    
    
    ArrayList<Object> FS = new ArrayList<Object>();
       FS.add("Flandal_Steelskin");
              FS.add(100);

       FS.add(300);
       FS.add(900);
       FS.add(500);
       FS.add(750);
       FS.add(2546);
       FS.add(6);
    
    
    //an array list of each type of warrior
     ArrayList<ArrayList> Warriors = new ArrayList<>();
       Warriors.add(GI);
       Warriors.add(SM);
       Warriors.add(MD);
       Warriors.add(FS);
    
        
        
        
        return Warriors;
    }
    
           //to level up your paladins
    public void levelUp() {
        if(this.getXP() >= (this.getLvl() *10)){
            this.setXP(this.getXP() - (this.getLvl() *10));
            if(this.getHP() > this.getLvl()*100){
                int temp = this.getHP() - (this.getLvl()*100);
                this.setHP((((this.getLvl()+1)*100)+temp));
            }else{
               this.setHP((((this.getLvl()+1)*100))); 
            }
            
            this.setMana(((int)((this.getMana())*LEVELUP_GAIN)));
            this.setAgility(((int)((this.getAgility())*LEVELUP_GAIN)));
            this.setStreinght(((int)((this.getStreinght())*LEVELUP_GAIN)));
            this.setDexterity(((int)((this.getDexterity())*LEVELUP_GAIN)));
            
            this.setStreinght(((int)((this.getStreinght())*Special_LEVELUP_GAIN)));
            this.setAgility(((int)((this.getAgility())*Special_LEVELUP_GAIN)));
            
            System.out.println("\n----"+this.getName()+" LEVELED UP-------\n");
            this.setLvlandLvlHP(this.getLvl()+1);
   
        }
    }
    
}
