/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import java.util.ArrayList;
import java.util.Scanner;
import static thequest.HeroTeam.buildHeroTeam;


/**
 *
 * @author adamstreich
 */
public class TheQuest {
    //private final char[] chars = {'a','w','s','d','q'};
    private static final String accaptable = "awsdqe";
    private static final String moveChars = "awsd";
    private static final char QUIT ='q';
    private static final char INVENTORY ='e';
    private static final int BOARDSIZE =10;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //testBoard();
        //testMove();
        playGame();
        
    }
    
    //just to test the board
    public static void testBoard(){
        Board bd = new Board(10);
        System.out.println(bd.toString());
    }
    
    //just to test the movement on the board
    public static void testMove(){
        Board bd = new Board(10);
        System.out.println(bd.toString());
        HeroTeam hrs = new HeroTeam(1,'&',1);
        bd.addTeam(hrs);
        hrs.setLoc(bd.getH()*bd.getW()-1);
        boolean gameon = true;
        while(gameon){
            System.out.println(bd.toString());
            char input = readInputChar();
            if( moveChars.indexOf(input) > 0 ){
                bd.move(hrs, input);
            }else if(input == QUIT){
                gameon=false;
                System.out.println("Have a good day, thanks for saving the kingdom!");
            }
            
        }
    }
    
    //the code to run the game
    public static void playGame(){
        //basic intro stuff + builds board
        System.out.println("Hello welcome to the Quest!");
        Board bd = new Board(BOARDSIZE);
        System.out.println("Here is the Kingdom, you will go around and fight monsters in");
        System.out.println("Buy equipment at the market M");
        System.out.println("Move your team using a,w,s,d Quit the game with q, view inventory with e");
        
        //setting up the game
        HeroTeam hrs = buildHeroTeam();
        bd.addTeam(hrs);
        hrs.setLoc(bd.getH()*bd.getW()-1);
        
        //running the game
        boolean gameon = true;
        while(gameon){
            System.out.println(bd.toString());
            char input = readInputChar();
            if( moveChars.indexOf(input) >= 0 ){
                bd.move(hrs, input);
                int type = hrs.checkLoc(bd);
                if(type == 1){
                    MonsterTeam mst = new MonsterTeam(hrs.getNumHeros(),hrs.getMaxLvl());
                    //hrs.fight(mst);
                }else if(type == 2){
                    Market temp = (Market) hrs.getLocTile(bd);
                    temp.shop(hrs);
                }
            }else if(input == QUIT){
                gameon=false;
                System.out.println("\n\n---------------------Final Stats-----------------------");
                System.out.println(hrs.toString());
                System.out.println("Have a good day, thanks for saving the kingdom!");
                
            }else if(input == INVENTORY){
                
                hrs.inv();
                
            }
            
        }
    }
    

    
    
    //just reads the input to make sure its a char, converts it to lower case
    public static char readInputChar(){
        Scanner words  = new Scanner(System.in);
        boolean san = true;
        char c = 0;
        while(san) {
            System.out.print("Please input a letter: ");
            try {
                 String s = words.next();
                 s=s.toLowerCase();
                if(s.length() > 1) {
                    throw new RuntimeException("Input too long!");
                }
                c = s.charAt(0);
                if (accaptable.indexOf(c)<0){
                    throw new RuntimeException("Not an accepted letter");
                }
                san = false;
                    // here you can break the loop and do whatever

            } catch(RuntimeException re){
                System.out.print(re.getMessage());
                // you can break the loop or try again
            }
        } 
      return c;  
    }

    //reads the next input and forces it to be an integer
    //EDIT-I should have had this take in parameters for an upper and a lower bound
    //to late in dev for me to go back
    public static int readInputInt(){
        Scanner words  = new Scanner(System.in);
        //System.out.println("Enter a direction to move");
        boolean san = true;
        int n = 0;
        while(san) {
            System.out.print("Please input an integer: ");
            try {
                n = words.nextInt();
                 
                san = false;
                    // here you can break the loop and do whatever

            } catch(Exception e){
                System.out.print("Not an integer...");
                // you can break the loop or try again
                
            }
        } 
      return n;  
    }
  
}

