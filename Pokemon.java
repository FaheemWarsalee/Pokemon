/*
 Program:ICS3U Summative; Pokemon
 Programmer: Faheem Warsalee
 Course: ICS3U
 Date: May 17th 2018
 
 Brief Description: This program is a simulation of the Pokemon Trading Card Game, done in Java and text based.*/

//Imports
import java.util.ArrayList;
import java.util.Collections;

class Pokemon
{
  //METHOD 1; MAIN
  public static void main(String[] args)
  {
    mainMenu();
  }
  
  //METHOD 2: MAIN MENU
  public static void mainMenu()
  {
    //Varaibles & Arrays
    String menuPick, playPick, cpuModePck;
    int menuChoice, mode, cpuMode;
    
    System.out.println("-_-_-_-_-_-P O K E M O N  C A R D  G A M E-_-_-_-_-_- \n\ncreated by: Faheem Warsalee");
    System.out.println("\n[1] Play \n[2] Rules \n[3] Exit");
    System.out.print("Choose an option: ");
    
    do
    {
      menuPick = In.getString().trim();
      
      parsingInt(menuPick); 
    } while (isInputValid(parsingInt(menuPick)));
    
    menuChoice = parsingInt(menuPick);
    
    if (menuChoice == 1) //PLAYER PICKS PLAY
    {
      System.out.println("Play!");
      System.out.println("[1] Multiplayer \n[2] CPU");
      
      System.out.print("Choose an option: ");
      do
      {
        playPick = In.getString().trim();
        
        parsingInt(playPick);
      }while(isInputValidB(parsingInt(playPick)));
      
      if (parsingInt(playPick) == 1)
      {
        mode = 1;
        cards(mode, mode);
      }
      else
      {
        mode = 2;
        
        System.out.println("CPU Difficulties:");
        System.out.println("[1] Easy\n[2] Medium\n[3] Hard");
        System.out.print("Choose an option:");
        
        //Gets cpu difficutly choice
        do
        {
          cpuModePck = In.getString();
          
          parsingInt(cpuModePck);
        }while(isInputValid(parsingInt(cpuModePck)));
        
        cpuMode = parsingInt(cpuModePck);
        
        cards(mode,cpuMode);
      }
    }
    else if (menuChoice == 2)//PLAYER PICK RULES
    {
      System.out.println("Rules : ");
      rulesDisp();
    }
    else //PLAYER PICK EXIT GAME
    {
      System.out.println("Thanks for Playing!!" );
    }
  }
  
//METHOD 3: PARSING INTEGERS
  public static int parsingInt(String toNum)
  {
    //Variables & Arrays
    int newNum;
    
    try
    {
      newNum = Integer.parseInt(toNum);
      return newNum;
    }
    catch (NumberFormatException e)
    {
      newNum = 0;
      return newNum;//Return new num as 0, it will automatically be false in the isInputValid() method.
    }
  }
  
//METHOD 4: ARE INPUTS ACCEPTABLE?
  public static boolean isInputValid (int numCheck)
  {
    if (numCheck < 1 || numCheck > 3)
    {
      System.out.println("Invalid Input. Choose 1, 2 or 3.. ");
      return true;//Is out of bounds
    }
    else
    {
      return false;//Is inside Bounds
    }
    
  }
  
//METHOD 5: ARE INPUTS ACCEPTALBE? OL
  public static boolean isInputValidB (int numCheck)
  {
    if (numCheck < 1 || numCheck > 2)
    {
      System.out.println("Invalid Input. Choose 1 or 2.. ");
      return true;//Is out of bounds
    }
    else
    {
      return false;//Is inside Bounds
    }
    
  }
  
  //METHOD 6: ARE INPUTS ACCEPTALBE? OL for cards
  public static boolean isInputValidC (int numCheck)
  {
    if (numCheck < 1 || numCheck > 6)
    {
      System.out.println("Invalid Input. Choose a number between 1-6.. ");
      return true;//Is out of bounds
    }
    else
    {
      return false;//Is inside Bounds
    }
    
  }
  
//METHOD 7: DISPLAY RULES
  public static void rulesDisp()
  {
    System.out.println("1. Each player has a deck contaning 6 cards; each card is a Pokemon");
    System.out.println("2. Each player will select 1 card to play on the field from their deck");
    System.out.println("3. Every Pokemon has 240hp, and 2 different attacks.");
    System.out.println("4. Players will take turns attacking until a player has eliminated their opponnents Pokemon.");
    System.out.println("");
    
    mainMenu();//Returns to main menu
  }
  
//METHOD 8: CARDS
  public static void cards(int mode, int cpuMode) 
  {
    //Variables & Arrays
    String[] p1Deck = new String[6];//Creating 2 decks, 1 per player
    String[] p2Deck = new String[6];
    
    ArrayList<String> pkmns = new ArrayList<String>();//array list for possible pokemon
    
    //(Name attack1 attack2)
    pkmns.add("Pikachu 25 34");//1
    pkmns.add("Charizard 50 37");//2
    pkmns.add("Bulbasaur 15 28");//3
    pkmns.add("Wartortle 30 35");//4
    pkmns.add("Gyrados 65 72");//5
    pkmns.add("Gengar 51 61");//6
    pkmns.add("Medicham 32 45");//7
    pkmns.add("Lapras 48 63");//8
    pkmns.add("Suicune 69 82");//9
    pkmns.add("Entei 70 78");//10
    pkmns.add("Raikou 67 85");//11
    pkmns.add("Mewtwo 20 100");//12
    pkmns.add("Nidoqueen 55 64");//13
    pkmns.add("Rhydon 54 68");//14
    pkmns.add("Dragonite 78 88");//15
    pkmns.add("Snorlax 30 50");//16
    pkmns.add("Lotad 35 12");//17
    pkmns.add("Articuno 40 45");//18
    pkmns.add("Zapdos 45 40");//19
    pkmns.add("Moltres 40 42");//20
    
    for (int i = 0; i <= 5; i++)
    {
      Collections.sort(pkmns); //Shuffles pkmn cards 5x
    }
    
    decks(pkmns, p1Deck, p2Deck);//Fills empty deck arrays with cards
    
    activPkmn(p1Deck, p2Deck, mode, cpuMode);//choose an active pokemon out of decks
  }
  
  //METHOD 9: DECK DISTRIBUTION
  public static void decks(ArrayList<String> pkmns, String[] deck1, String[] deck2)
  {
    //Varaibles & Arrays
    int rand;
    
    for (int i = 0; i < deck1.length; i++)//Fills array with random pokemon
    {
      rand = (int) (15*Math.random());//Random number between 0-15
      deck1[i] = pkmns.get(rand);//rand is an index of the array list pkmns
    }
    
    
    for (int i = 0; i < deck2.length; i++)//Fills deck with random pokemmon
    {
      rand = (int) (15*Math.random());//Generates a new random number for player 2
      deck2[i] = pkmns.get(rand);
    }
    
  }
  
  //METHOD 10: ACTIVE POKEMON
  public static void activPkmn (String[] deck1, String[] deck2, int mode, int cpuMode)
  {
    //Variables & Arrays
    String p1ActivPck, p2ActivPck;
    String p1Activ, p2Activ;
    int cpu;
    
    //Player vs Player
    if(mode == 1)
    {
      System.out.println("\nPLAYER VS PLAYER");
      
      //Displays all active pokemon in player 1 deck
      System.out.println("Player 1's deck: ");
      for (int i = 0; i< deck1.length ; i++)
      {
        System.out.print("[" + (i+1) + "] "+ deck1[i].substring(0,deck1[i].indexOf(" ")));
        System.out.print(" ");
      }
      
      System.out.print("\nPlayer 1. Choose your Active pokemon: ");
      do
      {
        p1ActivPck = In.getString().trim();
        
        parsingInt(p1ActivPck);
      }while (isInputValidC(parsingInt(p1ActivPck)));
      
      
      p1Activ = deck1[parsingInt(p1ActivPck)-1];//Sets p1Activ to chosen number at the index of the active pick-1
      
      //All of player 2 pokemons in their deck
      System.out.println("\nPlayer 2's deck: ");      
      for (int i = 0; i< deck2.length ; i++)
      {
        System.out.print("[" + (i+1) + "] "+ deck2[i].substring(0,deck2[i].indexOf(" ")));
        System.out.print(" ");
      }
      
      System.out.print("\nPlayer 2. Choose your Active pokemon: ");      
      do
      {
        p2ActivPck = In.getString().trim();
        
        parsingInt(p2ActivPck);
      }while (isInputValidC(parsingInt(p2ActivPck)));
      
      p2Activ = deck2[parsingInt(p2ActivPck)-1];//sets p2 active to the index of the choice -1
    }
    else//Player vs CPU
    {
      System.out.println("\nPLAYER VS CPU");
      
      //Displays all active pokemon in player 1 deck PLAYER vs CPU
      System.out.println("Player 1's deck: ");
      for (int i = 0; i< deck1.length ; i++)
      {
        System.out.print("[" + (i+1) + "] "+ deck1[i].substring(0,deck1[i].indexOf(" ")));
        System.out.print(" ");
      }
      
      System.out.print("\nPlayer 1. Choose your Active pokemon: ");
      do
      {
        p1ActivPck = In.getString().trim();
        
        parsingInt(p1ActivPck);
      }while (isInputValidC(parsingInt(p1ActivPck)));
      
      
      p1Activ = deck1[parsingInt(p1ActivPck)-1];//Sets p1Activ to chosen number at the index of the active pick-1
      
      //CPU CHOICE
      cpu = (int)(6*Math.random())+1;
      
      p2Activ = deck2[cpu-1];//sets p2 active to the index of the choice -1
    }
    
    fight(p1Activ, p2Activ, mode, cpuMode);//Sends the chosen pkmns to fight
  }
  
  //METHOD 11: FIGHTING SYSTEM
  public static void fight(String p1Activ, String p2Activ, int mode, int cpuMode)
  { 
    //Variables & Arrays
    int turn = 0;
    int hp1, hp2;
    int atck1, atck2;
    String getAtck1, getAtck2;
    String[] pkmnName = new String[2];//Holds pokemon names
    String[] pkmnAtckS = new String[4];//String version of attacks
    int[] pkmnAtck = new int[4];// Integer version of attacks
    
    //Healt of both players 
    hp1 = 240;
    hp2 = 240;
    
    //setting the names to their own string array
    pkmnName[0]= p1Activ.substring(0,p1Activ.indexOf(" "));
    pkmnName[1]= p2Activ.substring(0,p2Activ.indexOf(" "));
    
    //Player 1 attacks as Strings
    pkmnAtckS[0] = p1Activ.substring(p1Activ.indexOf(" ")+1);
    pkmnAtckS[1] = pkmnAtckS[0].substring(pkmnAtckS[0].indexOf(" ")+1);   
    pkmnAtckS[0] = pkmnAtckS[0].substring(0,pkmnAtckS[0].indexOf(" "));
    
    //Player 2 attacks as Strings
    pkmnAtckS[2] = p2Activ.substring(p2Activ.indexOf(" ")+1);
    pkmnAtckS[3] = pkmnAtckS[2].substring(pkmnAtckS[2].indexOf(" ")+1);   
    pkmnAtckS[2] = pkmnAtckS[2].substring(0,pkmnAtckS[2].indexOf(" "));
    
    //Sets all player attacks to integers
    for(int i = 0; i < pkmnAtck.length; i++)
    {
      pkmnAtck[i] = parsingInt(pkmnAtckS[i]);
    }
    
    if(mode == 1)//Player VS Player
    {
      do
      {
        if (turn % 2 == 0)//Checks if its player 1's turn 
        {
          //Displays attacks
          System.out.println("\nPlayer 1's turn to attack..");
          System.out.print(pkmnName[0] + "'s attacks:" + "\n[1] ");
          stringAtcks();
          System.out.print("[2] ");
          stringAtcks();//Displays attacks 
          
          //Gets p1 attack
          do
          {
            getAtck1 = In.getString().trim();
            
            parsingInt(getAtck1);
          }while(isInputValidB(parsingInt(getAtck1)));
          
          atck1 = (parsingInt(getAtck1)-1);//set attacks to a valid index number
          
          if(atck1 == 0)//Is attack 1
          {
            hp2 = hp2 - pkmnAtck[0];//substracting attack damage from p2's health
            
            if(hp2>0)//Doesnt display hp if its below 0, so no "pkmn has -13hp left".
            {
              System.out.println(pkmnName[1] + " has " + hp2 + "hp remaining");
            }
          }
          else//is attack2
          {
            hp2 = hp2 - pkmnAtck[1];//substracts damage from health using 2nd attack
            
            if(hp2>0)//Doesnt display hp if its below 0, so no "pkmn has -13hp left".
            {
              System.out.println(pkmnName[1] + " has " + hp2 + "hp remaining");
            }
          }
        }
        else//is player 2's turn
        {
          //Displays p2 Attacks
          System.out.println("\nPlayer 2's turn to attack..");
          System.out.print(pkmnName[1] + "'s attacks:" + "\n[1] ");
          stringAtcks();
          System.out.print("[2] ");
          stringAtcks();//Displays attacks 
          
          //Gets p2 attack
          do
          {
            getAtck2 = In.getString().trim();
            
            parsingInt(getAtck2);
          }
          while(isInputValidB(parsingInt(getAtck2)));
          
          atck2 =(parsingInt(getAtck2)+1);
          
          if(atck2 == 2)
          {
            hp1 = hp1 - pkmnAtck[2];
            
            if(hp1>0)//Doesnt display hp if its below 0, so no "pkmn has -13hp left".
            {
              System.out.println(pkmnName[0] + " has " + hp1 + "hp remaining");
            }
          }
          else
          {
            hp1 = hp1 - pkmnAtck[3];
            
            if(hp1>0)//Doesnt display hp if its below 0, so no "pkmn has -13hp left".
            {
              System.out.println(pkmnName[0] + " has " + hp1 + "hp remaining");
            }
          }
        }
        turn++;
      }while(!isWinner(hp1, hp2, pkmnName));//Winning conditions
    }
    else//Mode is 2; Player VS CPU
    {
      cpuFight(hp1,hp2,pkmnName,pkmnAtck,turn,cpuMode);//Applies when the mode is set to 2 which is CPU vs Player
    }
    rematch();//When game is done, ask to play again.
  }
  
  //METHOD 12: IS WINNER
  public static boolean isWinner(int hlth1, int hlth2,String[] pkmnName)
  {
    if(hlth1 <= 0 || hlth2 <= 0)//has any pokemon died?
    {
      if(hlth1<=0)//Player 1 has lost
      {
        System.out.println(pkmnName[0] + " has fainted.." + "\nPlayer 2 wins!! " );//winner is player 2
      }
      else//Player 2 has lost
      {
        System.out.println(pkmnName[1] + " has fainted.." + "\nPlayer 1 wins!! ");//Winner is player 1
      }
      return true;//There is a winner
    }
    else//If no pokemon has died
    {
      return false;//No one wins; game continues
    }
  }
  
  //METHOD 13: CPUFIGHT
  public static void cpuFight(int hp1, int hp2, String[] pkmnName, int[] pkmnAtck, int turn, int cpuMode)
  {
    //Variables & Arrays
    String getAtck1;
    int atck2, atck1;
    boolean isEz, isHard;
    
    do
    {
      if (turn % 2 == 0)//Checks if its player 1's turn 
      {
        //Displays attacks 
        System.out.println("\nPlayer 1's turn to attack..");
        System.out.print(pkmnName[0] + "'s attacks:" + "\n[1] ");
        stringAtcks();
        System.out.print("[2] ");
        stringAtcks();
        System.out.print("Choose an option: ");
        
        //get attakcs
        do
        {
          getAtck1 = In.getString().trim();
          
          parsingInt(getAtck1);
        }while(isInputValidB(parsingInt(getAtck1)));
        
        atck1 = (parsingInt(getAtck1)-1);//set attacks to a valid index number
        
        if(atck1 == 0)//Is attack 1
        {
          hp2 = hp2 - pkmnAtck[0];//substracting attack damage from p2's health
          
          if(hp2>0)//Doesnt display hp if its below 0, so no "pkmn has -13hp left".
          {
            System.out.println(pkmnName[1] + " has " + hp2 + "hp remaining");
          }
        }
        else//is attack2
        {
          hp2 = hp2 - pkmnAtck[1];//substracts damage from health using 2nd attack
          
          if(hp2>0)//Doesnt display hp if its below 0, so no "pkmn has -13hp left".
          {
            System.out.println(pkmnName[1] + " has " + hp2 + "hp remaining");
          }
        }
      }
      else//is CPU's turn
      {
        System.out.println("\nCPU's turn to attack..");
        
        //Difficulty attack options
        isEz = pkmnAtck[2] < pkmnAtck[3];
        isHard = pkmnAtck[2] > pkmnAtck[3];
        
        //CPU ATTACK CHOICE BASED ON DIFFICULTY
        if(cpuMode == 1)//CPU is on easy
        {
          if (isEz)
          {
            atck2 = 2;
          }
          else
          {
            atck2 = 3;
          }
        }
        else if (cpuMode == 2)//CPU is on medium
        {
          atck2 = (int) (2*Math.random())+1;
          atck2 = atck2+1;
        }
        else//CPU is on hard
        {
          if(isHard)
          {
            atck2 = 2;
          }
          else
          {
            atck2 = 3;
          }
        }
        
        if(atck2 == 2)//First attack
        {
          hp1 = hp1 - pkmnAtck[2];
          
          
          System.out.print(pkmnName[1] + " uses attack [1] ");//Says which attakc is used by cpu
          stringAtcks();
          
          if(hp1>0)//Doesnt display hp if its below 0, so no "pkmn has -13hp left".
          {
            System.out.println(pkmnName[0] + " has " + hp1 + "hp remaining");
          }
        }
        else//Second attack
        {
          hp1 = hp1 - pkmnAtck[3];
          
          //Displays  attack used
          System.out.print(pkmnName[1] + " uses attack [2] ");
          stringAtcks();
          
          if(hp1>0)//Doesnt display hp if its below 0, so no "pkmn has -13hp left".
          {
            System.out.println(pkmnName[0] + " has " + hp1 + "hp remaining");
          }
        }
      }
      turn++;//round goes up to determine whos turn
    }while(!isWinner(hp1, hp2, pkmnName));
    
  }
  
  //METHOD 14: REMATCH
  public static void rematch()
  {
    //Variables & Arrays
    String playAgn;
    boolean isAgain;
    
    //Gets user choice
    System.out.println("\nWould you like to play again?\n[1] Yes\n[2] No");
    System.out.print("Choose an option: ");
    do
    {
      playAgn = In.getString();
      
      parsingInt(playAgn);
    }
    while(isInputValidB(parsingInt(playAgn)));
    
    //set boolean variable condtion
    isAgain = parsingInt(playAgn) == 1;
    
    if(isAgain)//Player wants to play again
    {
      mainMenu();//returns player to main mnu
    }
    else//Player wants to exit game
    {
      System.out.println("Thanks for Playing!!");
    }
  }
  
  //METHOD 15: ATTACK MOVES STRING
  public static void stringAtcks()
  {
    //Possible attack names
    String[] atckNames = {"Tackle", "Quick Attack", "Swift", "Aura Sphere", "Rock Smash", "Cross Chop", 
                          "Dark Pulse","Thunderbolt","Double-Kick","Dragon Tail","Ember","Hydro Pump" };
    
    //Random attack name
    int rand;
    rand = (int)(Math.random()*11);//0-11 = indicies of the atckNames array.
    
    //Output the random attack name;
    System.out.println(atckNames[rand]);
  }
  
}
//End of Program