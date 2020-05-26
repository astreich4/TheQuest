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
public class Sorcerer extends Hero{

    private static final double Special_LEVELUP_GAIN = 1.05;
    

   

    public Sorcerer( int id) {
        super(id);
    }
    
        //would do this like I did the monsters a second time around

      public static ArrayList<ArrayList> getSorcererList(){
              ArrayList<Object> GG = new ArrayList<Object>();
       GG.add("Garl_Glittergold");
              GG.add(130);

       GG.add(700);
       GG.add(550);
       GG.add(600);
       GG.add(500);
       GG.add(2500);
       GG.add(7);
  
    
    ArrayList<Object> RR = new ArrayList<Object>();
       RR.add("Rillifane_Rallathil ");
              RR.add(130);

       RR.add(1300);
       RR.add(750);
       RR.add(450);
       RR.add(500);
       RR.add(2500);
       RR.add(9);
    
    ArrayList<Object> SE = new ArrayList<Object>();
       SE.add("Segojan_Earthcaller ");
              SE.add(130);

       SE.add(900);
       SE.add(800);
       SE.add(500);
       SE.add(650);
       SE.add(2500);
       SE.add(5);
    
    
    ArrayList<Object> SS = new ArrayList<Object>();
       SS.add("Skoraeus_Stonebones");
              SS.add(135);

       SS.add(800);
       SS.add(850);
       SS.add(600);
       SS.add(450);
       SS.add(2500);
       SS.add(6);
    
    
         ArrayList<ArrayList> Sorcerers = new ArrayList<>();
       Sorcerers.add(GG);
       Sorcerers.add(RR);
       Sorcerers.add(SE);
       Sorcerers.add(SS);
       
       return Sorcerers;
      }
      
      
             //to level up your sorcerer
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
            
            
            this.setAgility(((int)((this.getAgility())*Special_LEVELUP_GAIN)));
            this.setDexterity(((int)((this.getDexterity())*Special_LEVELUP_GAIN)));
            
            System.out.println("\n----"+this.getName()+" LEVELED UP-------\n");
            this.setLvlandLvlHP(this.getLvl()+1);
   
        }
    }
}
