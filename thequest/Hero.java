/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import java.util.ArrayList;
import static thequest.Armor.getSkinArmor;
import static thequest.TheQuest.readInputInt;
import static thequest.Weapon.getBareHand;

/**
 *
 * @author adamstreich
 */
public class Hero extends Character {
    private String name;
    private int mana;
    private int agility;
    private int strength;
    private int dexterity;
    private int money;
    private int experience;
    private int lvl;
    private int HP;
    private int lvl_HP; //not a cap but a reference for where the HP should be at with the level
    private Inventory inv;
    private int id;
    private Body body; //holds the armor and the weapon data 
    private SpellBag SpellBag;
    private String DEFAULT_NAME = "DEFAULT_NAME";
    private final int DEFAULT_VALUE = 0;
    private final int DEFAULT_lvl = 1;
    final double LEVELUP_GAIN = 1.05; //5%
    
     
    
    public Hero(int i){
    name = DEFAULT_NAME;
    HP = DEFAULT_VALUE;
    mana = DEFAULT_VALUE;
    strength = DEFAULT_VALUE;
    agility = DEFAULT_VALUE;
    dexterity=DEFAULT_VALUE;
    money = DEFAULT_VALUE;
    experience = DEFAULT_VALUE;
    inv = new Inventory(new ArrayList<Item>());
    SpellBag = new SpellBag(new ArrayList<Spell>());
    id = i;
    //went with one armor object to make it simpler
    body = new Body();
    lvl = DEFAULT_lvl;
    lvl_HP = lvl * DEFAULT_lvl;
    }
    
    //only for when displaying the heros before they are objects
    public static String printHeros(ArrayList<ArrayList> hrs){
        String rt ="Hero Name        HP        Mana      Strenght       Agility      Dexterity       Money      Experience\n";
        for(int c = 0; c <+ hrs.size(); c++){
            ArrayList temp = hrs.get(c);
            rt+= "("+(c+1)+") " + temp.get(0).toString() + "   " + temp.get(1).toString() + "   " + temp.get(2).toString()
                    + "   " + temp.get(3).toString() + "   " + temp.get(4).toString()
                    + "   " + temp.get(5).toString() + "   " + temp.get(6).toString() +"   "+temp.get(7).toString()
                    + "\n";
        }
        return rt;
    }
    
    
    
    //setters
    public void setName(String x){
        this.name = x;
    }
    
    public void setHP(int x){
        this.HP = x;
    }
    
    public void setMana(int x){
        this.mana = x;
    }
    
    public void setStreinght(int x){
        this.strength = x;
    }
    
    public void setAgility(int x){
        this.agility = x;
    }
    
    public void setDexterity(int x){
        this.dexterity = x;
    }
    
    public void setMoney(int x){
        this.money = x;
    }
    
    public void setXP(int x){
        this.experience = x;
    }
    
    public void setLvlandLvlHP(int x){
        this.lvl =x;
        this.lvl_HP = this.lvl *100;
    }
    
    
    //getters
    public String getName(){
       return this.name;
    }
    
    public int getHP(){
        return this.HP;
    }
    
    public int getMana(){
        return this.mana;
    }
    
    public int getStreinght(){
        return this.strength;
    }
    
    public int getAgility(){
        return this.agility;
    }
    
    public int getDexterity(){
        return this.dexterity;
    }
    
    public int getMoney(){
        return this.money;
    }
    
    public int getXP(){
        return this.experience;
    }
    
    public Inventory getInv(){
        return this.inv;
    }
    
    public SpellBag getSpellBag(){
        return this.SpellBag;
    }
    
    public int getLvl(){
        return this.lvl;
    }
    
    //the interface for using/accesing the inventory when not in a fight
    //cant interact with spells in inv because they are only for fighting and dont need to be equiped
    public void inventory(){
        boolean inInv = true;
        while(inInv){
            System.out.println("-------"+this.name+"-------");
            System.out.println(this.body.toString());
            System.out.println("This is the inventory for "+this.name);
            System.out.println(this.inv.toString());
            System.out.println(this.SpellBag.toString());
            System.out.println("");
            System.out.println("Would you like to:");
            //went with numbers here to speed up the game play, didnt really see a way not to hard code this
            System.out.println("(1) Put away current weapon");
            System.out.println("(2) Put away current armor");
            System.out.println("(3) Equip weapon/armor or use a potion");
            System.out.println("(-1)Leave Inventory");
            
            boolean san1 = true;
            int y = 0;
            while(san1){
                y = readInputInt();
                if(y>=-1 && y <= 3){ //the lower and the upper bounds of the list above
                    san1 = false;
                }else{
                    System.out.println("Not an option, try again...");
                }
            }
            //again couldnt think of another way than to just hard code the options
            if(y==-1){
                inInv=false;
            }else if(y==1){
                //put away curent weapon
                Weapon w =this.body.putAwayWeapon();
                if(w == null){
                    System.out.println("You are not holding a weapon");
                }else{
                    //System.out.println(this.body.putAwayWeapon().toString());
                    this.inv.addItem(w);
                    System.out.println("The weapon has been added back to your inventory.\n");
                }  
            }else if(y ==2){
                //put away current armor
                Armor a = this.body.takeOffArmor();
                if(a == null){
                    System.out.println("You are not wearing any armor");
                }else{
                    this.inv.addItem(a);
                    System.out.println("The weapon has been added back to your inventory.\n");
                }  
            }else if(y ==3){
                //lot more stuff, in the inv
                //list the interactable items
                System.out.println(this.inv.toString());
                //say select one
                System.out.println("Select an item to ineract with:");
                boolean san2 = true;
                int i = 0;
                while(san2){
                    i = readInputInt();
                    if(i>0 && i <= this.inv.numItms()){ //the lower and the upper bounds of the list above
                        san2 = false;
                    }else{
                        System.out.println("Not an option, try again...");
                    }
                }
                //subtract one due to indexing
                i=i-1;
                if(this.inv.getItem(i) instanceof Weapon){
                    Weapon w = (Weapon) this.inv.getItem(i);
                    
                    //weapon: (1) Hold (-1) Nothing
                    System.out.println("Would you like to:");
                    System.out.println("(1) Equip this weapon");
                    System.out.println("(-1) Do nothing");
                    boolean san3 = true;
                    int o = 0;
                    while(san3){
                        o = readInputInt();
                        if(o==1||o==-1){ //the lower and the upper bounds of the list above
                            san3 = false;
                        }else{
                            System.out.println("Not an option, try again...");
                        }
                    }
                    if(o==1){
                        this.body.holdWeapon(w);
                        this.inv.removeItem(w);
                    }else{
                        System.out.println("Okay\n");
                    }   
                }else if(this.inv.getItem(i) instanceof Armor){
                    
                    //Armor: (1) Put on (-1) Nothing
                    Armor a = (Armor) this.inv.getItem(i);
                    
                    //weapon: (1) Hold (-1) Nothing
                    System.out.println("Would you like to:");
                    System.out.println("(1) Equip this Armor");
                    System.out.println("(-1) Do nothing");
                    boolean san3 = true;
                    int o = 0;
                    while(san3){
                        o = readInputInt();
                        if(o==1||o==-1){ //the lower and the upper bounds of the list above
                            san3 = false;
                        }else{
                            System.out.println("Not an option, try again...");
                        }
                    }
                    if(o==1){
                        this.body.putOnArmor(a);
                        this.inv.removeItem(a);
                    }else{
                        System.out.println("Okay\n");
                    }
                    
                    
                    
                }else if(this.inv.getItem(i) instanceof Potion){
                    Potion p = (Potion) this.inv.getItem(i);
                    System.out.println("Would you like to:");
                    System.out.println("(1) Drink this potion");
                    System.out.println("(-1) Do nothing");
                    boolean san3 = true;
                    int o = 0;
                    while(san3){
                        o = readInputInt();
                        if(o==1||o==-1){ //the lower and the upper bounds of the list above
                            san3 = false;
                        }else{
                            System.out.println("Not an option, try again...");
                        }
                    }
                    if(o==1){
                        p.use(this);
                        this.inv.removeItem(p);
                    }else{
                        System.out.println("Okay\n");
                    }
                    //Potion: (1) Drink (-1) Nothing
                  
                }
                
                
            }
            
                    
        }
        

    }
    
    //gets the damage the hero will do in an attack with their weapon
    public int attackDam(){
        return (int) ((this.strength + body.getDamage()) * .05);
    }
    //returns how much damage your armor is absorbing
    public int defense(){
        return body.getDamageReduc();
    }
    
    //chooses a spell from the bag and uses it, return the damages and the spell if rt[0] = -1 then no spell was cast 
    //rt[0] = damage
    //rt[1] = spell
    public Object[] useSpell(){
        Object[] rt = {0,null};
        System.out.println("----------------Spells----------------");
        System.out.println(this.getName() + "\n"+ this.getSpellBag().toString());

        System.out.println("(-1) Go Back");
        System.out.println("What would you like Cast?");
                                
        boolean san4 = true;
        int m = 0;
        while(san4){
            m = readInputInt();
            if(m >= -1 && m <= this.getSpellBag().numSpells() && m != 0){
                san4 = false;
            }else{
                System.out.println("Not an option, try again...");
            }
        }
                                
        if(m > 0){
            //subtract one because its by indexing a list
            Spell tempspell = this.getSpellBag().getSpell(m-1);
            if(this.mana-tempspell.getMana_cost() >= 0){
                //calculate damage
                rt[0] = (tempspell.getDamage()+((this.dexterity/10000))*tempspell.getDamage()); 
                System.out.println("Debug rt[0]="+rt[0]+" dex "+ this.dexterity);
                rt[1] = tempspell;
                //lower mana
                this.mana = this.mana-tempspell.getMana_cost();
            }else{
                System.out.println("You dont have the mana to cast that spell");
                rt[0] = -1;
            } 
        }else{
            rt[0] =-1;
        }
     return rt;   
    }
    
    
    //an inventory class without a loop so you only get to do one thing in the fight
    public int fightInv(){
        int rt = 0;
        
        System.out.println("This is the fight inventory for "+this.name);
        System.out.println("Because you are in a fight you do not have time to dilly dally and can only go through the menu once!");
            System.out.println(this.inv.toString());
            System.out.println(this.SpellBag.toString());
            System.out.println("");
            System.out.println("Would you like to:");
            //went with numbers here to speed up the game play, didnt really see a way not to hard code this
            System.out.println("(1) Put away current weapon");
            System.out.println("(2) Put away current armor");
            System.out.println("(3) Equip weapon/armor or use a potion");
            System.out.println("(-1)Leave Inventory");
            
            boolean san1 = true;
            int y = 0;
            while(san1){
                y = readInputInt();
                if(y>=-1 && y <= 3){ //the lower and the upper bounds of the list above
                    san1 = false;
                }else{
                    System.out.println("Not an option, try again...");
                }
            }
            //again couldnt think of another way than to just hard code the options
            if(y==-1){
                //inInv=false;
                rt =-1;
            }else if(y==1){
                //put away curent weapon
                Weapon w =this.body.putAwayWeapon();
                if(w == null){
                    System.out.println("You are not holding a weapon");
                }else{
                    //System.out.println(this.body.putAwayWeapon().toString());
                    this.inv.addItem(w);
                    System.out.println("The weapon has been added back to your inventory.\n");
                }  
            }else if(y ==2){
                //put away current armor
                Armor a = this.body.takeOffArmor();
                if(a == null){
                    System.out.println("You are not wearing any armor");
                }else{
                    this.inv.addItem(a);
                    System.out.println("The weapon has been added back to your inventory.\n");
                }  
            }else if(y ==3){
                //lot more stuff, in the inv
                //list the interactable items
                System.out.println(this.inv.toString());
                //say select one
                System.out.println("Select an item to ineract with:");
                boolean san2 = true;
                int i = 0;
                while(san2){
                    i = readInputInt();
                    if(i>0 && i <= this.inv.numItms()){ //the lower and the upper bounds of the list above
                        san2 = false;
                    }else{
                        System.out.println("Not an option, try again...");
                    }
                }
                //subtract one due to indexing
                i=i-1;
                if(this.inv.getItem(i) instanceof Weapon){
                    Weapon w = (Weapon) this.inv.getItem(i);
                    
                    //weapon: (1) Hold (-1) Nothing
                    System.out.println("Would you like to:");
                    System.out.println("(1) Equip this weapon");
                    System.out.println("(-1) Do nothing");
                    boolean san3 = true;
                    int o = 0;
                    while(san3){
                        o = readInputInt();
                        if(o==1||o==-1){ //the lower and the upper bounds of the list above
                            san3 = false;
                        }else{
                            System.out.println("Not an option, try again...");
                        }
                    }
                    if(o==1){
                        this.body.holdWeapon(w);
                        this.inv.removeItem(w);
                    }else{
                        System.out.println("Okay\n");
                    }   
                }else if(this.inv.getItem(i) instanceof Armor){
                    
                    //Armor: (1) Put on (-1) Nothing
                    Armor a = (Armor) this.inv.getItem(i);
                    
                    //weapon: (1) Hold (-1) Nothing
                    System.out.println("Would you like to:");
                    System.out.println("(1) Equip this Armor");
                    System.out.println("(-1) Do nothing");
                    boolean san3 = true;
                    int o = 0;
                    while(san3){
                        o = readInputInt();
                        if(o==1||o==-1){ //the lower and the upper bounds of the list above
                            san3 = false;
                        }else{
                            System.out.println("Not an option, try again...");
                        }
                    }
                    if(o==1){
                        this.body.putOnArmor(a);
                        this.inv.removeItem(a);
                    }else{
                        System.out.println("Okay\n");
                    }
                    
                    
                    
                }else if(this.inv.getItem(i) instanceof Potion){
                    Potion p = (Potion) this.inv.getItem(i);
                    System.out.println("Would you like to:");
                    System.out.println("(1) Drink this potion");
                    System.out.println("(-1) Do nothing");
                    boolean san3 = true;
                    int o = 0;
                    while(san3){
                        o = readInputInt();
                        if(o==1||o==-1){ //the lower and the upper bounds of the list above
                            san3 = false;
                        }else{
                            System.out.println("Not an option, try again...");
                        }
                    }
                    if(o==1){
                        p.use(this);
                        this.inv.removeItem(p);
                    }else{
                        System.out.println("Okay\n");
                    }
                    //Potion: (1) Drink (-1) Nothing
                  
                }
                
                
            }
           
        return rt;
    }
    
    
    
    
    //to string overide
    public String toString(){
        String rt = "";
         rt +=this.name +"Level: "+this.lvl+" HP: "+ this.HP + ": Mana: "+this.mana+" Strenght: "+this.strength+" Agility: "
                 +this.agility+" Dexterity: "+this.dexterity+" Money: "+this.money+" Experience:" + this.experience;
        
        return rt;
    }

    //generic level up, will be overridden in hero subclasses classes
    public void levelUp() {
        if(this.experience >= (this.lvl *10)){
            this.setXP(this.experience - (this.lvl *10));
            if(this.HP > this.lvl*100){
                int temp = this.HP - (this.lvl*100);
                this.setHP((((this.lvl+1)*100)+temp));
            }else{
               this.setHP((((this.lvl+1)*100))); 
            }
            this.setMana(((int)((this.lvl+1)*LEVELUP_GAIN)));
            this.setAgility(((int)((this.lvl+1)*LEVELUP_GAIN)));
            this.setStreinght(((int)((this.lvl+1)*LEVELUP_GAIN)));
            this.setDexterity(((int)((this.lvl+1)*LEVELUP_GAIN)));
            this.setLvlandLvlHP(this.getLvl());



            
        }
    }
    
}
