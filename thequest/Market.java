/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import java.util.ArrayList;
import static thequest.Armor.createAllArmor;
import static thequest.FSpell.createAllFSpells;
import static thequest.ISpell.createAllISpells;
import static thequest.LSpell.createAllLSpells;
import static thequest.Potion.createAllPotions;
import static thequest.TheQuest.readInputInt;
import static thequest.Weapon.createAllWeapons;

/**
 *
 * @author adamstreich
 */
public class Market extends Tile{
    private Inventory item_stock;
    private SpellBag spell_stock;
    private int shop_lvl;
    
    //constructor for a fully stocked shop, good for testing and simple gameplay
    public Market(int lc) {
        super(lc, true,false,true,'M');
        item_stock = fullyStockedItems();
        spell_stock = fullyStockedSpells();
        shop_lvl = 0;
    }
    
    //haven't implemented yet
    public Market(int lc,int sl) {
        super(lc, true,false,true,'M');
        shop_lvl = sl;
        //allows for different lvls of stock in the shops
        if(shop_lvl == 0){
            item_stock = fullyStockedItems();
            spell_stock = fullyStockedSpells();
        }else
            //empty shop
            item_stock = new Inventory(new ArrayList<Item>());
            spell_stock = new SpellBag(new ArrayList<Spell>());
    }
    
    //the main code for the shop, will be run from the gamecontroler method in TheQuest class so the player can interact with the shop
    public void shop(HeroTeam hrs){
        if(this.shop_lvl == 0){
            this.fullShop(hrs);
        }else{
            //other levels of shop would go here
            System.out.println("Not open yet...");
        }
        
    }
    
    //code for interacting with the shop
    public void fullShop(HeroTeam hrs){
        System.out.println("The game designer must like you, this is the fully stocked shop!");
        boolean atShop = true;
        while(atShop){
            System.out.println("Would you like to:");
            System.out.println("(1) Come inside ");
            System.out.println("(2) Move Along ");
            boolean san = true;
            int x = 0;
            while(san){
                x = readInputInt();
                if(x>0 && x<3){
                    san = false;
                }else{
                    System.out.println("Not an option, try again...");
                }
            }
            
            if(x == 1){
                System.out.println("Welcom!");
                boolean inShop = true;
 
                while(inShop){
                    System.out.println("Which hero would you like to work with?");
                    System.out.println(hrs.toString());
                    System.out.println("(-1) Leave shop");
                    boolean san1 = true;
                    int y = 0;
                    while(san1){
                        y = readInputInt();
                        if(y>=-1 && y <= hrs.getNumHeros()){
                            san1 = false;
                        }else{
                            System.out.println("Not an option, try again...");
                        }
                    }
                    if(y != -1){
                        Hero temp = hrs.getHero(y-1);

                        System.out.println("Would you like to:");
                        System.out.println("(1) Shop ");
                        System.out.println("(2) Sell ");
                        boolean san2 = true;
                        int z = 0;
                        while(san2){
                            z = readInputInt();
                            if(z>0 && z<3){
                            san2 = false;
                            }else{
                                System.out.println("Not an option, try again...");
                            }
                        }
                        if(z==1){
                            System.out.println("Would you like to see our colection of:");
                            System.out.println("(1) Weapons, Armor, and Potions ");
                            System.out.println("(2) Spells ");
                            boolean san3 = true;
                            int i = 0;
                            while(san3){
                                i = readInputInt();
                                if(i>0 && i<3){
                                san3 = false;
                                }else{
                                    System.out.println("Not an option, try again...");
                                }
                            }
                            if(i == 1){
                                System.out.println("Below is our inventory:");
                                System.out.println("----------------Weapons, Armor, and Potions----------------");
                                System.out.println(this.item_stock.toString());
                                System.out.println("(-1) Nothing");
                                System.out.println("What would you like to purchase?");
                                boolean san4 = true;
                                int m = 0;
                                while(san4){
                                    m = readInputInt();
                                    if(m >= -1 && m <= this.item_stock.numItms()){
                                    san4 = false;
                                    }else{
                                         System.out.println("Not an option, try again...");
                                    }
                                }
                                
                                if(m > 0){
                                    //subtract one because its by indexing a list
                                    if(canPurchaseItem(temp,this.item_stock.getItem(m-1))){
                                        System.out.println("Success!");
                                        temp.getInv().addItem(this.item_stock.getItem(m-1));
                                        temp.setMoney(temp.getMoney()- this.item_stock.getItem(m-1).getCost());
                                    }else{
                                        System.out.println("Can't do that. Try a different item.");
                                    }
                                }else{
                                    System.out.println("Ok then...");
                                }
                                
                                
                            }else if(i==2){
                                System.out.println("----------------Spells----------------");
                                System.out.println(this.spell_stock.toString());
                                System.out.println("(-1) Nothing");
                                System.out.println("What would you like to purchase?");
                                
                                boolean san4 = true;
                                int m = 0;
                                while(san4){
                                    m = readInputInt();
                                    if(m >= -1 && m <= this.spell_stock.numSpells()){
                                    san4 = false;
                                    }else{
                                         System.out.println("Not an option, try again...");
                                    }
                                }
                                
                                if(m > 0){
                                    //subtract one because its by indexing a list
                                    if(canPurchaseSpell(temp,this.spell_stock.getSpell(m-1))){
                                        System.out.println("Success!");
                                        temp.getSpellBag().addSpell(this.spell_stock.getSpell(m-1));
                                        temp.setMoney(temp.getMoney()- this.spell_stock.getSpell(m-1).getCost());

                                    }else{
                                        System.out.println("Can't do that. Try a different item.");
                                    }
                                }else{
                                    System.out.println("Ok then...");
                                }
                                
                            }
   
                        }else if(z==2){
                            System.out.println("What would you like to sell?");
                            System.out.println("We pay half its cost...");
                            System.out.println("(1) Weapons, Armor, and Potions ");
                            System.out.println("(2) Spells ");
                            boolean san3 = true;
                            int i = 0;
                            while(san3){
                                i = readInputInt();
                                if(i>0 && i<3){
                                san3 = false;
                                }else{
                                    System.out.println("Not an option, try again...");
                                }
                            }
                            if(i == 1){
                                
                                System.out.println("----------------Weapons, Armor, and Potions----------------");
                                System.out.println(temp.getName() + "\n"+ temp.getInv().toString());
                                //System.out.println(this.item_stock.toString());
                                System.out.println("(-1) Nothing");
                                System.out.println("What would you like to sell?");
                                boolean san4 = true;
                                int m = 0;
                                while(san4){
                                    m = readInputInt();
                                    if(m >= -1 && m <= temp.getInv().numItms()){
                                    san4 = false;
                                    }else{
                                         System.out.println("Not an option, try again...");
                                    }
                                }
                                
                                if(m > 0){
                                    //subtract one because its by indexing a list
                                    Item tempitem = temp.getInv().getItem(m-1);
                                    temp.setMoney(temp.getMoney()+(tempitem.getCost()/2));
                                    temp.getInv().removeItem(tempitem);
                                    System.out.println("Thank you! Enjoy the extra " + tempitem.getCost()/2);

                                    
                                }else{
                                    System.out.println("Ok then...");
                                }
                                
                                
                            }else if(i==2){
                                System.out.println("----------------Spells----------------");
                                System.out.println(temp.getName() + "\n"+ temp.getSpellBag().toString());

                                System.out.println("(-1) Nothing");
                                System.out.println("What would you like to Sell?");
                                
                                boolean san4 = true;
                                int m = 0;
                                while(san4){
                                    m = readInputInt();
                                    if(m >= -1 && m <= temp.getSpellBag().numSpells()){
                                    san4 = false;
                                    }else{
                                         System.out.println("Not an option, try again...");
                                    }
                                }
                                
                                if(m > 0){
                                    //subtract one because its by indexing a list
                                    Spell tempspell = temp.getSpellBag().getSpell(m-1);
                                    temp.setMoney(temp.getMoney()+(tempspell.getCost()/2));
                                    temp.getSpellBag().removeSpell(tempspell);
                                    System.out.println("Thank you! Enjoy the extra " + tempspell.getCost()/2);
                                    
                                }else{
                                    System.out.println("Ok then...");
                                }
                                
                            }


                        }
                        
                    }else{
                        inShop = false;
                    }
                     //subtract one becasue you are indexing right into a list
                    
                    
                }
                
                
                
            }else{
                System.out.println("Have a nice day!");
                atShop = false;
            }
        }
        
        
        
        
    }

    
    //builds the inventory for a fully shop
    public static Inventory fullyStockedItems(){
        Inventory rt = new Inventory(new ArrayList<Item>());
        //rt.addItem(x);
        ArrayList<Armor> allArmor = createAllArmor();
        for(int c = 0; c < allArmor.size(); c++){
            rt.addItem(allArmor.get(c));
        }
        
        ArrayList<Weapon> allWeapons = createAllWeapons();
        for(int c = 0; c < allWeapons.size(); c++){
            rt.addItem(allWeapons.get(c));
        }
        
        ArrayList<Potion> allPotions = createAllPotions();
        for(int c = 0; c < allPotions.size(); c++){
            rt.addItem(allPotions.get(c));
        }
        
        return rt;
        
    }
    
    //builds the spell bag for a full shop
    public static SpellBag fullyStockedSpells(){
        SpellBag rt = new SpellBag(new ArrayList<Spell>());
        //rt.addItem(x);
        
        ArrayList<Spell> allLSpells = createAllLSpells();
        for(int c = 0; c < allLSpells.size(); c++){
            rt.addSpell(allLSpells.get(c));
        }
        
        ArrayList<Spell> allISpells = createAllISpells();
        for(int c = 0; c < allISpells.size(); c++){
            rt.addSpell(allISpells.get(c));
        }
        
        ArrayList<Spell> allFSpells = createAllFSpells();
        for(int c = 0; c < allFSpells.size(); c++){
            rt.addSpell(allFSpells.get(c));
        }
        
        return rt;
        
    }
    
    //checks to see if a hero can purchase a item
    public static boolean canPurchaseItem(Hero hr, Item i){
        boolean rt = false;
        if( hr.getMoney() >= i.getCost() && hr.getLvl() >= i.getLvlReq()){
            rt = true;
        }
        return rt;
    }
    
    //checks to see if a hero can purchase a spell
    public static boolean canPurchaseSpell(Hero hr, Spell i){
        boolean rt = false;
        if( hr.getMoney() >= i.getCost() && hr.getLvl() >= i.getLvlReq()){
            rt = true;
        }
        return rt;
        
        
    }
    
}
