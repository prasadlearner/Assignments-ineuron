// Guesser Game
import java.util.*;

class Guesser
{
   int gNum;
   int guessNumGiveToUmp()
   {
    Scanner scan = new Scanner(System.in);
    System.out.println("Guesser kindly guess the number but the number can't be 0 : ");
    gNum =scan.nextInt();
    return gNum;
   }
}

class Player
{
    
      int guessNumGiveToUmp(int key)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("player kindly guess the any five numbers ");
    int[] arr = new int[5];
    for(int i =0; i<arr.length;i++)
    {
      arr[i] =scan.nextInt();
    }
     
for(int i=0;i<arr.length;i++)
{
    if(arr[i] == key)
      break;
  
    else if(i==arr.length-1) 
    return 0;
} 
return key;

}
}

class Umpire
{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;


    void collectNumFromGuesser()
    {
        Guesser obj = new Guesser();
        numFromGuesser = obj.guessNumGiveToUmp();
    }
    void collectNumFromPlayers()
    {
  
    Player p1 = new Player();
    Player p2 = new Player();
    Player p3 = new Player();
    
  numFromPlayer1=  p1.guessNumGiveToUmp(numFromGuesser);
  numFromPlayer2 =  p2.guessNumGiveToUmp(numFromGuesser);
  numFromPlayer3 =  p3.guessNumGiveToUmp(numFromGuesser);

    }

    void compare()

{


    if(numFromGuesser == numFromPlayer1)
      {
        if(numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3)
        {
          System.out.println("All Playes won the game");
        }
        else if(numFromGuesser == numFromPlayer2)
             {
              System.out.println("player 1 & player 2 won the game");
             }
        else if(numFromGuesser == numFromPlayer3)
        {
          System.out.println("player 1 & player 3 won the game");
        }
        else
        {
        
        System.out.println("player 1 won the game");
        }
      }

      else if(numFromGuesser == numFromPlayer2)
      {
        if(numFromGuesser == numFromPlayer3)
        {
          System.out.println("player 2 & player 3 won the game");
        }
        else
        {	
        System.out.println("player 2 won the game");
        }
      }

      else if(numFromGuesser == numFromPlayer3)
      {
        System.out.println("player 3 won the game");
      }

      else 
      {
        System.out.println("Game lost try Again");
      }
 }

}

public class GuesserGame
{
    public static void main(String[] args) {
        Umpire u = new Umpire();
        u.collectNumFromGuesser();
        u.collectNumFromPlayers();
        u.compare();
    }
    
}
