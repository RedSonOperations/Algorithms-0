import java.util.*;
public class BlackJackGame {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean stop = false;
		boolean gameOngoing=false;
		double startMoney=0;
		double startMoneyTemp=0;
		double betAmount;
		int playerHandTotal=0;
		int dealerHandTotal=0;
		int playerHitVal=0;
		int dealerHitVal=0;
		char winLoseDraw = 0;
		char moreThan21=0;
		boolean playedAlready=false;
		
		int [] playerHand = new int[11];
		int [] dealerHand = new int[11];
		
		while(stop == false) {
			greeting();
			
			if(playedAlready==false) {
				startMoney=startMoney();
			}
			else {
				System.out.printf("You currently have $%.2f.\n", startMoney);
			}
			
			playedAlready=true;
			betAmount=betAmount(startMoney);
			playerHand=handInitial();
			
			if(playerHand[0] == 11 || playerHand[0] == 1) {
				System.out.println("For your first card, you were dealt an ace! Would you like it to be a 1 or 11?");
				playerHand[0]=input.nextInt();
			}
			
			System.out.println(playerHand[0]);
			
			if(playerHand[1] == 11 || playerHand[1] == 1) {
				System.out.println("For your second card, you were dealt an ace! Would you like it to be a 1 or 11?");
				playerHand[1]=input.nextInt();
			}
			
			System.out.println(playerHand[1]);
			
			playerHandTotal=handTotal(playerHand);
			
			System.out.println("Your initial hand: " + playerHand[0] + ", " + playerHand[1]);
			
			if(playerHand[0]+playerHand[1]!=21) {
				dealerHand=handInitial();
				System.out.println("The dealer now has two cards, the one you can see is: " + dealerHand[0]);
				dealerHandTotal=handTotal(dealerHand);
				gameOngoing=true;
			}
			else {
				System.out.println("You got very lucky! Your score is 21.");
			}
			
			while(gameOngoing) {
				int zeroIndex=0;
				boolean ask = true;
				
				while(ask) {
					System.out.println("Hit? (y/n): ");
					ask=false;
				}
				
				char hitYN=input.next().charAt(0);
				if(hitYN == 'y' || hitYN == 'Y') {
					playerHitVal=hit();
					if(playerHitVal == 11 || playerHitVal == 1) {
						System.out.println("You were dealt an ace! Would you like it to be a 1 or 11?");
						playerHitVal=input.nextInt();
					}
					
					for(int i = 0; i<playerHand.length; i++) {
						if(playerHand[i]==0) {
							zeroIndex=i;
							break;
						}
					}
					for(int i = zeroIndex; i<zeroIndex+1; i++) {
						playerHand[i]=playerHitVal;
						playerHandTotal=handTotal(playerHand);
					}
					
					if(playerHandTotal==21) {
						ask=false;
						gameOngoing=false;
					}
					
					moreThan21=moreThan21(playerHandTotal);
					
					if(moreThan21 == 'y') {
						ask=false;
						gameOngoing=false;
					}
					ask=true;
				}
				else {
					ask=false;
					System.out.println("You chose to stay. Now the dealer will hit...");
					while(dealerHandTotal<17) {
						dealerHitVal=hit();
						for(int i = 0; i<dealerHand.length; i++) {
							if(dealerHand[i]==0) {
								zeroIndex=i;
								break;
							}
						}
						for(int i = zeroIndex; i<zeroIndex+1; i++) {
							dealerHand[i]=dealerHitVal;
							dealerHandTotal=handTotal(dealerHand);
						}
					}
					gameOngoing=false;
				}
				
				System.out.println("Player hand and total: " + deckNoZeroes(playerHand));
				System.out.println("Dealer hand and total: " + deckNoZeroes(dealerHand));
				
			}
			
			winLoseDraw=compare(playerHandTotal, dealerHandTotal);
			startMoney=calculateNetProfit(winLoseDraw, startMoney, betAmount, stop);
				
			if(startMoney!=0) {
				stop=!playAgain();
				restart(stop, gameOngoing, betAmount, playerHandTotal, dealerHandTotal, playerHitVal, dealerHitVal, winLoseDraw, moreThan21, playerHand, dealerHand, playedAlready, startMoneyTemp, startMoney);

			}
			else {
				stop=true;
			}
		}
		
	}

	public static void greeting() {
		System.out.println("Welcome to blackjack by Alec Kain! Let's begin.");
	}
	
	public static double betAmount(double startMoney) {
		Scanner input = new Scanner(System.in);
		double bettingAmtTemp;
		double bettingAmt=0;
		int jam=0;
		
		while(jam==0) {
			System.out.println("How much would you like to bet?");
			bettingAmtTemp=input.nextDouble();
			
			if(bettingAmtTemp<=startMoney) {
				System.out.printf("Excellent! You will be betting with: $%.2f" + ".\n", bettingAmtTemp);
				bettingAmt=bettingAmtTemp;
				jam=1;
			}
			else {
				System.out.println("You can't bet more than you have! Please bet a monetary amount equal to or below the "
						+ "amount of money you have available.");
				
			}
		}
		
		return bettingAmt;
	}
	
	public static double startMoney() {
		Scanner input = new Scanner(System.in);
		double startMoney;
		
		System.out.println("How much money would you like to start with?: ");
		startMoney=input.nextDouble();
		return startMoney;
	}

	public static int [] handInitial() {
		int [] hand = new int[11];
		for(int i = 0; i<2; i++) {
			int handAmt = (int)(Math.floor(Math.random()*11)+1);
			hand[i]=handAmt;
		}
		return hand;
	}
	
	public static int hit() {
		int hit=(int)(Math.floor(Math.random()*11)+1);
		
		return hit;
	}
	
	public static void restart(boolean stop, boolean gameOngoing, double betAmount, int playerHandTotal, int dealerHandTotal, int playerHitVal, int dealerHitVal, char winLoseDraw, char moreThan21, int [] playerHand, int [] dealerHand, boolean playedAlready, double startMoneyTemp, double startMoney) {
		stop = false;
		
		betAmount=0;
		playerHandTotal=0;
		dealerHandTotal=0;
		playerHitVal=0;
		dealerHitVal=0;
		winLoseDraw=0;
		moreThan21=0;
		playedAlready=true;
		startMoneyTemp=startMoney;
		
		playerHand = new int[11];
		dealerHand = new int[11];
		gameOngoing=false;
	}
	
	public static boolean playAgain() {
		Scanner input = new Scanner(System.in);
		char yesOrNo;
		boolean trueOrFalse;
		
		System.out.println("Would you like to play again? (y/n): ");
		yesOrNo=input.next().charAt(0);
		if(yesOrNo == 'Y' || yesOrNo == 'y') {
			trueOrFalse=true;
		}
		else if(yesOrNo == 'N' || yesOrNo == 'n'){
			System.out.println("Thanks for playing! See you at the casino next time!");
			trueOrFalse=false;
		}
		else {
			return false;
		}
		
		return trueOrFalse;
	}
	
	public static int handTotal(int[] arr) {
		int total=0;
		for(int i = 0; i<arr.length; i++) {
			total+=arr[i];
		}
		return total;
	}
	
	public static char moreThan21(int playerHandTotal) {
		char winLoseDraw=0;
		if(playerHandTotal>21) {
			winLoseDraw='y';
		}
		return winLoseDraw;
	}
	public static char compare(int playerHandTotal, int dealerHandTotal) {
		char winLoseDraw;
		if(playerHandTotal>dealerHandTotal && playerHandTotal<=21 || dealerHandTotal>21) {
			System.out.println("You won! Congratulations.");
			winLoseDraw = 'w';
		}
		else if(playerHandTotal<dealerHandTotal && dealerHandTotal<=21 || playerHandTotal>21) {
			System.out.println("You lost! Sorry.");
			winLoseDraw = 'l' ;
		}
		else {
			System.out.println("You and the dealer have the same total hand value! A tie emerges.");
			winLoseDraw = 't';
		}
		
		return winLoseDraw;
	}
	
	public static double calculateNetProfit(char winLoseDraw, double startMoney, double betAmount, boolean stop) {
		
		if(winLoseDraw=='w') {
			betAmount*=2;
			startMoney+=betAmount;
			System.out.printf("Your earnings are: + $%.2f\n", betAmount);
			System.out.printf("Your new total is: $%.2f\n", startMoney);
		}
		else if(winLoseDraw=='l') {
			startMoney-=betAmount;
			System.out.printf("Your losses are: - $%.2f\n", betAmount);
			System.out.printf("Your new total is: $%.2f\n", startMoney);
			if(startMoney<=0) {
				System.out.println("Looks like you ran out of money. Thanks for playing! See you at the casino next time.");
			}
		}
		else {
			System.out.printf("Since it was a tie, your total net earnings will remain the same, at $%.2f\n", startMoney);
			return startMoney;
			
		}
		
		return startMoney;
	}
	
	public static String deckNoZeroes(int [] arr) {
		String string="";
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]!=0) {
				string += arr[i] + " ";
			}
		}
		return string;
	}
}
