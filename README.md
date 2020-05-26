# TheQuest
1. How to Compile
2. How to Run
3. How to Play
4. Implementation Choices


1. How to Compile

Download the  required .java files. 
Place the three files into a folder named thequest. In the terminal enter the thequest directory and for Macs run the command: 
javac *.java
This will compile all the .java files in the directory.

2. How to Run

Make sure the files correctly produced the appropriate .class files. 
Exit the current directory to the directory above thequest and on a Mac run the command:
java thequest.TheQuest

3. How to Play

The instructions will be printed out on the screen. Choose the number of heros, then each hero. After that you are off.

awsd - to move

q - to quit

e - to get the the inventories

4.Implementation Choices

A. Menus

   a.All the menus in the game work by you selecting the number of your choice and not the name. IF YOU ENTER SOMETHING OTHER THAN A NUMBER the program will go into an infinite loop, did not implement an exception handler.
    
B. Building the board

   a. the bottom row of whatever size board will never contain a blocked tile, this way you can always get to at least some part of the board.
   
   b. the heroteam will always start in the bottom right.
    
C. Ending the game

   a. Just hit q and thats it, no other end condition exists.
    
D. Math

   a. I created some formulas for specific things such as the damage a monster can do depending on its level, explained in the code.
    
E. Creation of the Heros v Monster

   a. Originally I thought it would be easy to parse the input files and place the heros in array lists till they were created, that way i didnt create a bunch of objects I didnt use.
   
   a (con.). This turned out to be a terrible idea... The way I have the computer choose what monseters should be on the team should be the same way I do the heros, yet I dont have time given everything to change an test this.
    
F. Strategy

   a. The strategy of the game is get to a market as soon as possible and buy spells.
   
   b. A way to make the game more difficult would be to have different inventories for dofferent shops (my implementation can be expanded out to do this) that way you spend your time exploring the whole board looking for better armor, weapons, and spells.




Written by Adam Streich
