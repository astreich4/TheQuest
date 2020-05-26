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
public class LSpell extends Spell {
    
    public LSpell(String name, int cost, int lvl_req, int damage, int mana_cost) {
        super(name, cost, lvl_req, damage, mana_cost);
    }
    
    //creates all the lightning spells
    public static ArrayList<Spell> createAllLSpells(){
        ArrayList<Spell> all = new ArrayList<Spell>();
        
        all.add(new ISpell("Lightnining_Dagger",400,1,500,150));
        all.add(new ISpell("Thunder_Blast",750,4,950,400));
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
