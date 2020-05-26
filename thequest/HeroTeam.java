/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Random;
import static thequest.Board.locToTile;
import static thequest.Paladin.getPaladinList;
import static thequest.Sorcerer.getSorcererList;
import static thequest.TheQuest.readInputInt;
import static thequest.Warrior.getWarriorList;
import static thequest.Warrior.printHeros;

/**
 *
 * @author adamstreich
 */
public class HeroTeam {
    private int numHeros;
    private ArrayList heroList;
    private final int MAX_NUM_HEROS = 3;
    private char symbol;
    private int location;
    private int ID;
    private static final char SYMBOL_FOR_HEROTEAM = '&';
    private static final int CHANCE_OF_FIGHT = 75; // must be a number less than 100
    private static final int STARTING_LVL = 1; //added this late in development
    private static final int SPOIL_MONEY = 25; //how much you get for killing a hero * its level
    
    public HeroTeam(int nh, char sym, int id){
        symbol = sym;
        location = 0; //set once it is placed onto the board
        ID=id;
        
        //keeps the hero team size limited.
        if(nh>MAX_NUM_HEROS){
            System.out.println("You have been defaulted to the max number of heros: "+ MAX_NUM_HEROS);
            numHeros = MAX_NUM_HEROS;
        }else{
            numHeros = nh;
        }
        heroList = new ArrayList();
        //builds the team of the selected size
        for(int c = 0; c < numHeros;c++){
            heroList.add(pickHero(c));
        }
        
    }
    
    
    //code to build the hero team
    public static HeroTeam buildHeroTeam(){
        System.out.println("How many heros do you want to fight with??");
        int x = readInputInt(); 
        return new HeroTeam(x,SYMBOL_FOR_HEROTEAM,1);
        
    }
    
    //code for the player to pick a here
    //the reason for using lists here is becasue I thought that would be the best way to
    //pull in data from text files, I never did get to write that so I ended up hard coding in the arrays
    //If i had to do it again i would just make them objects from the begining
    public Hero pickHero(int id){
        Hero test = null;
        //TODO
        //ask if you want Warrior ,Sorc. , or Pal.
        System.out.println("Would you like a:");
        System.out.println("(1) Warrior");
        System.out.println("(2) Sorcerer");
        System.out.println("(3) Paladin");
        System.out.println("");
        //System.out.println("Input the Number of your choice:");
        boolean san = true;
        int x = 0;
        while(san){
            x = readInputInt();
            if(x>0 && x<4){
                san = false;
            }else{
                System.out.println("Not an option, try again...");
            }
        }
        //print the heros of the selected type, get the choice, make it
        if(x==1){
            System.out.println("Who would you like to add to the team?");
            System.out.println(printHeros(getWarriorList()));
            //System.out.println("Enter a number:");
            boolean san2 = true;
            int y = 0;
            while(san2){
                    y = readInputInt();
                if(y>0 && y<=4){
                    san2 = false;
                }else{
                System.out.println("Not an option, try again...");
                }
            }
            //gets the desiered hero from the arraylist
            ArrayList hr = getWarriorList().get(y-1);
            test = new Warrior(id);
            test.setName(hr.get(0).toString());
            test.setHP((Integer) hr.get(1));
            test.setMana((Integer) hr.get(2));
            test.setStreinght((Integer) hr.get(3));
            test.setAgility((Integer) hr.get(4));
            test.setDexterity((Integer) hr.get(5));
            test.setMoney((Integer) hr.get(6));
            test.setXP((Integer) hr.get(7));
            test.setLvlandLvlHP(STARTING_LVL);
            //maybe build the hero then assign the values with setters, not directly in constructor...
        }else if(x==2){
            System.out.println("Who would you like to add to the team?");
            System.out.println(printHeros(getSorcererList()));
            //System.out.println("Enter a number:");
            boolean san2 = true;
            int y = 0;
            while(san2){
                    y = readInputInt();
                if(y>0 && y<=4){
                    san2 = false;
                }else{
                System.out.println("Not an option, try again...");
                }
            }
            //gets the desiered hero from the arraylist
            ArrayList hr = getSorcererList().get(y-1);
            test = new Sorcerer(id);
            test.setName(hr.get(0).toString());
            test.setHP((Integer) hr.get(1));
            test.setMana((Integer) hr.get(2));
            test.setStreinght((Integer) hr.get(3));
            test.setAgility((Integer) hr.get(4));
            test.setDexterity((Integer) hr.get(5));
            test.setMoney((Integer) hr.get(6));
            test.setXP((Integer) hr.get(7));
            test.setLvlandLvlHP(STARTING_LVL);

            
        }else if(x==3){
            System.out.println("Who would you like to add to the team?");
            System.out.println(printHeros(getPaladinList()));
            //System.out.println("Enter a number:");
            boolean san2 = true;
            int y = 0;
            while(san2){
                    y = readInputInt();
                if(y>0 && y<=4){
                    san2 = false;
                }else{
                System.out.println("Not an option, try again...");
                }
            }
            //gets the desiered hero from the arraylist
            ArrayList hr = getPaladinList().get(y-1);
            test = new Paladin(id);
            test.setName(hr.get(0).toString());
            test.setHP((Integer) hr.get(1));
            test.setMana((Integer) hr.get(2));
            test.setStreinght((Integer) hr.get(3));
            test.setAgility((Integer) hr.get(4));
            test.setDexterity((Integer) hr.get(5));
            test.setMoney((Integer) hr.get(6));
            test.setXP((Integer) hr.get(7));
            test.setLvlandLvlHP(STARTING_LVL);

            
            
        }
        //Hero test = new Warrior();
        return test;
    }
    
    //return 0 to do nothing, 1 to fight, 2 to shop
    //im sure there is a better way to do this based on the objects of the tiles being different, but I cant think of it
    //just going to use ints for now
    public int checkLoc(Board bd){
        int rt = 0;
        Tile temp = locToTile(this.getLoc(),bd);
        if(temp.canFight()){
            ///the code for how frequent you fight goes here
            Random rand = new Random();
            //gets the random int
            int int1 = rand.nextInt(100);
            if(int1 < CHANCE_OF_FIGHT){
                rt=1;
            }
            
        }else if(temp.canShop()){
            rt =2;
        }
        return rt;
    }
    
    
    
    //getters and settter 
    public Tile getLocTile(Board bd){
        return locToTile(this.getLoc(),bd);
    }
    
    public int getID(){
        return this.ID;     
    }
    
    public void setLoc(int i){
        this.location = i;
    }
    
   public int getLoc(){
      return this.location;
    }
   
   public char getSym(){
       return this.symbol;
   }
   
   public int getNumHeros(){
       return this.numHeros;
   }
   
   //used numbers here and not the hero names so that gameplay is faster unlike in the
   //demo in class where you had to type out the heros name
   public Hero getHero(int x){
       return (Hero) this.heroList.get(x);
   }

   //code to view the invetory of a hero team.
   public void inv(){
       //all the inventory code here
       System.out.println("Which Inventory would you like to access?");
       System.out.println(this.toString()+"\n");
       boolean san1 = true;
            int y = 0;
            while(san1){
                y = readInputInt();
                if(y>0 && y <= 3){ //the lower and the upper bounds of the list above
                    san1 = false;
                }else{
                    System.out.println("Not an option, try again...");
                }
            }
       //subtract 1 becasuse indexing into list
       this.getHero(y-1).inventory();
       //this.printInv();
   }
   
   //prints the inventory
   //only used in dev, not final version
   public void printInv(){
       //String rt = " ";
       for(int c = 0; c < this.numHeros;c++){
           this.getHero(c).inventory();
       }
       
       
   }
   
   //to string method for the whole team
   public String toString(){
       String rt ="";
       for(int c = 0;c< this.heroList.size();c++){
           rt+= "("+(c+1)+")"+this.heroList.get(c).toString() + "\n";
       }
       return rt;
   }
   
   //returns the highest level of the all the heros
   public int getMaxLvl(){
       int rt = 1;
       for(int c = 0; c < this.numHeros;c++){
           Hero temp = this.getHero(c);
           if(rt < temp.getLvl()){
               rt = temp.getLvl();
           }
       }
       
       return rt;
       
   }
   
   
   //the hero team attacks
   public void attack(MonsterTeam ms){
       for(int c = 0; c < this.numHeros;c++){
           Hero current = this.getHero(c);
                if(current.getHP()>0){
                    //promt each hero with their options
                    System.out.println("It is " +current.getName()+"'s turn");
                    System.out.println("");
                boolean turn = true;
                while(turn){
                    System.out.println("Would you like to:");
                    System.out.println("(1) Attack");
                    System.out.println("(2) Cast a Spell");
                    System.out.println("(3) Use a Potion Or Change Weapon or Armor ");
                    
                    
                    boolean san1 = true;
                    int y = 0;
                    while(san1){
                        y = readInputInt();
                        if(y>0 && y <= 3){ //the lower and the upper bounds of the list above
                            san1 = false;
                        }else{
                            System.out.println("Not an option, try again...");
                        }
                    }
                    if(y==1){
                        ms.takeDamageA(current.attackDam(),c);
                        turn = false;
                    }else if(y==2){
                        Object[] rt = current.useSpell();
                        if((Integer) rt[0] >= 0){
                            ms.takeDamageS((Spell)rt[1], (Integer)rt[0], c);
                            turn = false;
                        }else{
                            //has to choose again becasue they did not cast a spell
                        }
                    }else if(y==3){
                        int rt = current.fightInv();
                        if(rt >= 0){
                            turn = false;
                        }
                        
                    }
                }
                    
                }
            }
   }
   
   //take damage from an incoming attack
   public void takeDamageA(int amount, int heroNum){
        if(this.getHero(heroNum).getHP()>0){
            Hero current = this.getHero(heroNum);
            Random rand = new Random();
            //gets the random int
            int int1 = rand.nextInt(101);
            if(int1>(current.getAgility()*.2)%100){ //this way you never reach a stat where you can dodge evrything
                int temp = amount - current.defense(); // acount for the armor
                if(temp > 0){
                    this.getHero(heroNum).setHP(current.getHP() - temp);
                    System.out.println("\nThe attack Hit! You Took "+ temp+" damage to "+current.getName());
                }else{
                    System.out.println("\n"+current.getName()+"'s armor absorbed the blow!");
                }
                
            }else{
                System.out.println("\nQuick feet "+current.getName()+" dodged an attack");
            }
        }else{
            //find new opponenet
            for(int c = 0; c< this.numHeros;c++){
                if(this.getHero(c).getHP()>0){
                    Hero current = this.getHero(heroNum);
                    Random rand = new Random();
                    //gets the random int
                    int int1 = rand.nextInt(101);
                    if(int1>(current.getAgility()*.2)%100){
                        int temp = amount - current.defense();
                        if(temp > 0){
                            this.getHero(heroNum).setHP(current.getHP() - temp);
                            System.out.println("\nThe attack Hit! You Took "+ temp+" damage to "+current.getName());
                        }else{
                            System.out.println("\n"+current.getName()+"'s armor absorbed the blow!");
                        } 
                    }else{
                        System.out.println("\nQuick feet "+current.getName()+" dodged an attack");
                    }
                }
            }
        }
    }
   
   //checks all the heros hp returns true if team can still fight 
    public boolean checkHHP(){
        boolean rt = true;
        //ArrayList<Hero> fainted = new ArrayList<Hero>();
        int numFainted = 0;
        for(int c = 0; c < this.numHeros;c++){
            Hero temp = this.getHero(c);
            if( temp.getHP() <= 0){
                numFainted++;
                System.out.println("\n"+temp.getName()+" has fainted and is no longer in the fight..\n");
            }
        }
        if(numFainted == this.numHeros){
            rt =false;
        }
        return rt;
    }
    
    //used to boost stats at the end of rounds in a fight
    public void roundUpdate(){
        for(int c = 0; c< this.numHeros;c++){
            Hero current = (Hero) this.heroList.get(c);
            current.setHP(((int) (current.getHP()*1.05)));
            current.setMana(((int) (current.getMana()*1.05)));
        }
    }
    
    //brings any fainted heros to half hp
    public void reviveHeros(){
        for(int c = 0; c< this.numHeros;c++){
            Hero current = (Hero) this.heroList.get(c);
            if(current.getHP()<=0){
                current.setHP((current.getLvl()*100)/2);
            }
        }
    }
    
    //takes away half of each heros money...
    public void payCut(){
        for(int c = 0; c< this.numHeros;c++){
            Hero current = (Hero) this.heroList.get(c);
            current.setMoney(current.getMoney()/2);
        }
    }
    
    //gives money to the heros after the fight
    public int moneyForWinning(int mstlvl){
        for(int c = 0; c< this.numHeros;c++){
            Hero current = (Hero) this.heroList.get(c);
            current.setMoney(current.getMoney()+(SPOIL_MONEY*mstlvl));
        }
        return SPOIL_MONEY*mstlvl;
    }
    
    //give the heros xp for winning
    public int xpForWinning(int mstlvl){
        for(int c = 0; c< this.numHeros;c++){
            Hero current = (Hero) this.heroList.get(c);
            if(current.getHP()>0){
                current.setXP(current.getXP()+ (int) pow(mstlvl,1.6));//gives you the level of the monsters ^1.6 of xp if you survive the fight
            }
        }
        return (int) pow(mstlvl,1.6);
    }
    
    //levels up heros who can level up
    public void levelUp(){
        for(int c = 0; c< this.numHeros;c++){
            Hero current = (Hero) this.heroList.get(c);
            current.levelUp();
        }
    }
    
    //gets the updated HeroTeam stats
    public String fightStats(){
        String rt = "\n----------Non Fainted Hero Stats--------\n";
        for(int c = 0; c< this.numHeros;c++){
            Hero current = (Hero) this.heroList.get(c);
            if(current.getHP()>0){
                rt+=current.getName()+" is still fighting! HP: "+current.getHP()+"  Mana: "+ current.getMana()+"\n";
            }
        }
        return rt;
    }
    
/*    
public boolean equals(Object obj) {
        HeroTeam ob = (HeroTeam) obj;
        boolean rt = false;
    if( ob.ID == this.ID){
        rt =true;
    }
    return rt;
}
  **/
    
    
    //all the fight happens here
    public void fight( MonsterTeam mst) {
        System.out.println("\n************Oh No!... Monsters have Appeared!**************");
        System.out.println(mst.toString());
        System.out.println("-----You must fight them to move on!-----");
        boolean fightOn = true;
        //this will be a toggle 1 for the heros 0 for the monsters
        int winner = 0;
        while(fightOn){
            //fight happens here
            System.out.println(this.fightStats());
            System.out.println(mst.fightStats());
            System.out.println("\n--Hero's Attack--\n");
            this.attack(mst);
            if(mst.checkMHP() == false){
                winner = 1;
                fightOn = false;
            }else{
                System.out.println("\n--Monster's Attack--\n");
                mst.attack(this);
                if(this.checkHHP() == false){
                    winner = 0;
                    fightOn = false;
                }
            }
            if(fightOn){
                this.roundUpdate();
            }  
        }
        if(winner == 1){
            //spoils to the heros
            //give them money
            System.out.println("\n\n-------YOU WIN THE FIGHT------\n\n");
            int mn = this.moneyForWinning(mst.getMonster(0).getLevel()); //takes the first monster in the team, mine all have the same level
            //give them xp
            int xp = this.xpForWinning(mst.getMonster(0).getLevel());
            System.out.println("Each heros recives "+mn+" large gold coins for winning!");
            System.out.println("Each hero that didnt fait recived "+xp+" in experience!");
            //level them up if they can
            this.levelUp();
        }else if(winner == 0){
            // dock heros pay
            System.out.println("\n\n-------You lost the fight-----\n\n");
            System.out.println("Your heros give over HALF of there money and regain half hp...");
            System.out.println("They must go find their dignity somewhere else...\n\n");
            this.payCut();
        }
        
        this.reviveHeros();  
    }
    
}
