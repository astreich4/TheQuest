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
public class Paladin extends Hero {
    private final double Special_LEVELUP_GAIN = 1.05; //5%
    
    public Paladin(int id) {
        super(id);
    }
    
    //would do this like I did the monsters a second time around
       public static ArrayList<ArrayList> getPaladinList(){
              ArrayList<Object> ST = new ArrayList<Object>();
       ST.add("Solonor_Thelandira");
       ST.add(120);

       ST.add(300);
       ST.add(750);
       ST.add(650);
       ST.add(700);
       ST.add(2500);
       ST.add(7);
  
    
    ArrayList<Object> SM = new ArrayList<Object>();
       SM.add("Sehanine_Moonbow");
              SM.add(120);

       SM.add(300);
       SM.add(750);
       SM.add(700);
       SM.add(700);
       SM.add(2500);
       SM.add(7);
    
    ArrayList<Object> SS = new ArrayList<Object>();
       SS.add("Skoraeus_Stonebones");
              SS.add(120);

       SS.add(250);
       SS.add(650);
       SS.add(600);
       SS.add(350);
       SS.add(2500);
       SS.add(4);
    
    
    ArrayList<Object> GG = new ArrayList<Object>();
       GG.add("Garl_Glittergold ");
              GG.add(120);

       GG.add(100);
       GG.add(600);
       GG.add(500);
       GG.add(400);
       GG.add(2500);
       GG.add(5);
    
    
         ArrayList<ArrayList> Paladins = new ArrayList<>();
       Paladins.add(ST);
       Paladins.add(SM);
       Paladins.add(SS);
       Paladins.add(GG);
       
       return Paladins;
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
            this.setDexterity(((int)((this.getDexterity())*Special_LEVELUP_GAIN)));
            
            System.out.println("\n----"+this.getName()+" LEVELED UP-------\n");
            this.setLvlandLvlHP(this.getLvl()+1);
   
        }
    }
   
    
}
