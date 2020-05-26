/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

/**
 *
 * @author adamstreich
 */
public class Item {
    private String name;
    private int cost;
    private int lvl_req;
    

    public Item(String n, int c, int lq) {
        name = n;
        cost =c;
        lvl_req = lq;
    }
    
    //getters
    public int getCost(){
        return this.cost;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getLvlReq(){
        return this.lvl_req;
    }
    
    
    //way to compare items by name
    public boolean equals(Object obj){
        boolean rt = false;
        if(obj == null){
            rt = false;
        }
        Item other = (Item) obj;
        if(this.name.equals(other.name)){
            rt=true;
        }else{
            rt = false;
        }
        return rt;
    }
    

}
