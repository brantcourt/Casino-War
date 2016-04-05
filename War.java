package war;

import java.util.Scanner;


public class War {
    
    public static void main(String[] args) {
        
        System.out.println("This is WAR");
        
 
        

        //playingDeck will be the deck the dealer holds
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
	playingDeck.shuffle();
        
        //playerCards will be the cards the player has in their hand
	Deck playerCards = new Deck();
	
        //playerMoney holds players cash - we will be lazy and use doubles instead of bigdecimals
        double playerMoney = 1000.00;
	
        //dealerCards will be the cards the dealer has in their hand
	Deck dealerCards = new Deck();
		
        
        Scanner userinput = new Scanner(System.in);
        
        
        //Play the game while the player has money  
        while(playerMoney>0) {
        //Take Bet
	System.out.println("You have $" + playerMoney + ", how much would you like to bet?");
	double playerBet = Math.abs(userinput.nextDouble());
	boolean endRound = false;
        
        if(playerBet > playerMoney){
	//Break if they bet too much
	System.out.println("You cannot bet more than you have.");
	break;
	}
        
        System.out.println("Dealing cards");
        
        playerCards.draw(playingDeck);
        dealerCards.draw(playingDeck);
        
        
	
        //Display player cards
	System.out.println("Your Hand:" + playerCards.toString());
	
        //Display Value
	System.out.println("Your hand is currently valued at: " + playerCards.cardsValue());
        
        //What do they want to do
	System.out.println("Choose a response: (1) Feeling Lucky  or  (2) I Definitley lost this one");
	int response = userinput.nextInt();
        
        //Display dealer cards
        if(response == 1){
            System.out.println("Dealer Hand: " + dealerCards.getCard(0).toString());
        }
        else{
            System.out.println("Dealer Hand: " + dealerCards.getCard(0).toString());
        }
            
                                  
        //Highest card wins //Determine if player wins
        if(playerCards.cardsValue() > (dealerCards.cardsValue())){
            System.out.println("You WIN! $" + playerBet);
            playerMoney += playerBet;
            endRound = true;
        }
        else{
            System.out.println("You LOSE! $" + playerBet);
            playerMoney -= playerBet;
            endRound = false;
        }
        
        
        //End of hand - put cards back in deck
	playerCards.moveAllToDeck(playingDeck);
	dealerCards.moveAllToDeck(playingDeck);
	System.out.println("End of Hand.");
            
        }
				
        
        }
    }
   

