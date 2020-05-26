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
public class FSpell extends Spell{
    
    public FSpell(String name, int cost, int lvl_req, int damage, int mana_cost) {
        super(name, cost, lvl_req, damage, mana_cost);
    }
    
    //creates the fire spells
    public static ArrayList<Spell> createAllFSpells(){
        ArrayList<Spell> all = new ArrayList<Spell>();
        
        all.add(new FSpell("Flame_Tornado",700,4,850,300));
        all.add(new FSpell("Breath_of_Fire",350,1,450,100));
        /*
        add the rest of the spells later
        all.add(new FSpell("Bow",300,2,500,2));
        all.add(new FSpell("Scythe",1000,6,1100,2));
        all.add(new FSpell("Axe",550,5,850,1));
        all.add(new FSpell("Shield",400,1,100,1));
*/
        


        return all;
    }
    
}
