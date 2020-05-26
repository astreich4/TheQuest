/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import java.util.Random;

/**
 *
 * @author adamstreich
 */
public class Board{
    //these numbers represent the upper and the lower bounds cannot be greater than 99
    // cannot overlap
    //not a break up of say 30 percont of the board will be markets and so on
    //but it is each tile has a 30 percent chance of being a market
    private final int[] oddOfB = {0,29};
    private final int[] oddOfM = {30,49};
    private final int[] oddOfE = {50,99};
    private int width;
    private int height;
    private Tile[][] board;
    
    private static final char UP = 'w';
    private static final char DOWN = 's';
    private static final char LEFT = 'a';
    private static final char RIGHT = 'd';
    
  
    public Board(int w, int h){
        width = w;
        height =h;
        //creates the board
        board = new Tile[width][height];
        //fills the board with cells
        int loccounter = 0;
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if( row == board.length -1 ){
                    board[row][col] = getRandTileEB(loccounter);
                }else{
                    board[row][col] = getRandTile(loccounter);
                }
                loccounter++;
            }
        }
        //sets the bottom right tile to always be empty
        board[board.length-1][board[board.length-1].length-1] = new Empty(width*height-1);
        
        
    }
    //constructor to do a square board
    public Board(int wh){
        this(wh,wh);
    }
    
    
    //getters
    public int getW(){
        return this.width;
    }
    
    public int getH(){
        return this.height;
    }
    
    
    //returns a random tile
    public Tile getRandTile(int loc){
        Tile rt = null;
        Random rand = new Random();
        //gets the random int
        int int1 = rand.nextInt(100);
        
        if(int1 >= oddOfB[0] && int1 <= oddOfB[1]){
            //means it will be blocked
            rt = new Blocked(loc);
        }else if(int1 >= oddOfM[0] && int1 <= oddOfM[1]){
            //means it will be a market
            rt = new Market(loc);
        }else if(int1 >= oddOfE[0] && int1 <= oddOfE[1]){
            //means it will be Empty
            rt = new Empty(loc);    
        }
        return rt;  
    }
    
    //gets a random tile but it excludes blocked, used to build paths
    //just makes them empty
        public Tile getRandTileEB(int loc){
        Tile rt = null;
        Random rand = new Random();
        //gets the random int
        int int1 = rand.nextInt(100);
        
        if(int1 >= oddOfB[0] && int1 <= oddOfB[1]){
            //means it will be empty
            rt = new Empty(loc);
        }else if(int1 >= oddOfM[0] && int1 <= oddOfM[1]){
            //means it will be a market
            rt = new Market(loc);
        }else if(int1 >= oddOfE[0] && int1 <= oddOfE[1]){
            //means it will be Empty
            rt = new Empty(loc);    
        }
        return rt;  
    }
   
    //way to visulize the board
    public String toString(){
        String rt = "";
        String dv = "";
        for(int row = 0; row < board.length; row++){
            dv+="-----";
        }
        
        
        for(int row = 0; row < board.length; row++){
            rt+=dv+"\n";
            for(int col = 0; col < board[row].length; col++){
                
                rt += "| " + board[row][col].getSymbol() + " " +board[row][col].getLoc() + " |";
                
                
            }
            rt+="\n";
        }
        rt+=dv;
        return rt;
    }
    
    //just places the team on the board
    //again works with only one team, one player
    public void addTeam(HeroTeam hr){
        board[this.width-1][this.height-1].placeTeam(hr);
    }
    
    //checks to see if the desired spot exists 
    //NEEDS A LOT OF WORK
    public boolean isLocValid(int i){
        boolean rt = true;
        if(i > ( this.width*this.height-1) || i < 0){
            rt = false;
        }
        return rt;
    }
    
    //checks to see if you can move into the spot 
    public boolean canMoveTo(int o, int n){
        boolean rt = false;
        
        //checks to make sure its not blocked
        int[] newHrsLoc = locToRC(n);
        Tile temp2 = this.board[newHrsLoc[0]][newHrsLoc[1]];
        if(temp2.canMoveInto()){
            rt = true;
        }
        //used to maintain the integrity of the board, ie cant moved from 10 to 9 in a 10x10 board
        if( (o % this.width) == 0 && n == o -1 ){
            rt = false;
        }
        return rt;
    }
    
    
   public Tile[][] getBoard(){
        return this.board;
    }
    
    //way to retrieve row and col data with the perscribed location input 
    public int[] locToRC(int lc){
        int[] loc = new int[2];
        Tile[][] brd = this.getBoard();
        int counter = 0;
        for(int row = 0; row < brd.length; row++){
            for(int col = 0; col < brd[row].length; col++){ 
                if(lc == (counter)){
                    loc[0]=row;
                    loc[1]=col;
                }
                counter++;
            }
        }
        return loc;  
    }
    
    //gets the tile that the location refers to, added this way later, could be used to simplify other code
    public static Tile locToTile(int lc, Board bd ){
        int[] loc = bd.locToRC(lc);
        return bd.board[loc[0]][loc[1]];
    }
    
    //moves a hero team around the board
    public boolean move(HeroTeam hrs, char dir){
        boolean rt = false;
        int[] hrsLoc = locToRC(hrs.getLoc());
        //System.out.println(hrs.getLoc());
        //System.out.println(hrsLoc[0]+hrsLoc[1]);
        HeroTeam temp = this.board[hrsLoc[0]][hrsLoc[1]].getTeam();
        int currentLoc = temp.getLoc();
        int newLoc = currentLoc;
        //converts the directions to numbers 
        if(dir == UP){
            newLoc -= this.width;
        }else if(dir == DOWN){
            newLoc += this.width;
        }else if(dir == LEFT){
            //System.out.println("here1");
            newLoc -= 1;
        }else if(dir == RIGHT){
            newLoc += 1;
        }
        //System.out.println(newLoc);
        //if its a valid spot it adds the team to the container of the new tile and removes it from the old
        if (this.isLocValid(newLoc) && this.canMoveTo(currentLoc, newLoc)){
            int[] newHrsLoc = locToRC(newLoc);
            hrs.setLoc(newLoc);
            Tile temp2 = this.board[newHrsLoc[0]][newHrsLoc[1]];
            temp2.placeTeam(temp);
            this.board[hrsLoc[0]][hrsLoc[1]].RemoveTeam();
        }else{
            System.out.println("Out of bounds...");
        }
        
        return rt;
    }
}
