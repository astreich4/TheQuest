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
public class ISpell extends Spell{
    
    public ISpell(String name, int cost, int lvl_req, int damage, int mana_cost) {
        super(name, cost, lvl_req, damage, mana_cost);
    }
    
    //builds the ice spells
    public static ArrayList<Spell> createAllISpells(){
        ArrayList<Spell> all = new ArrayList<Spell>();
        
        all.add(new ISpell("Snow_Canon",500,2,650,250));
        all.add(new ISpell("Ice_Blaze",250,1,450,100));
        /*
        add the rest of the spells later
        all.add(new ISpell("Bow",300,2,500,2));
        all.add(new ISpell("Scythe",1000,6,1100,2));
        all.add(new ISpell("Axe",550,5,850,1));
        all.add(new ISpell("Shield",400,1,100,1));
*/
        


        return all;
    }
    
}
