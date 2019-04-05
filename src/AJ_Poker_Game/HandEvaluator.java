package AJ_Poker_Game;

import java.util.Scanner;

public class HandEvaluator {
//	 ## Jedi: HandEvaluator
//
//	 Read and understand the Deck interface and its implementation DeckImpl. Using these, write a program called HandEvaluator that determines
//	 the winning percentage of a particular hand when pitted against a certain number of players. 
//
//	 The input to HandEvaluator will be a series of test cases in the form:
//
//	 ```
//	 NumberOpponents Rank1 Suit1 Rank2 Suit2 Rank3 Suit3 Rank4 Suit4 Rank5 Suit5
//	 ```

	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num_opponents = s.nextInt();
		while(num_opponents != 0) {
		
			int rank1 = s.nextInt();
			String Suit1 = (s.next());
			int rank2 = s.nextInt();
			String Suit2 = (s.next());
			int rank3 = s.nextInt();
			String Suit3 = (s.next());
			int rank4 = s.nextInt();
			String Suit4 = (s.next());
			int rank5 = s.nextInt();
			String Suit5 = (s.next());
			
			long endscore = handeval(num_opponents, rank1, Suit1, rank2, Suit2, rank3, Suit3, rank4, Suit4, rank5, Suit5);
			System.out.println(endscore);
			
			num_opponents = s.nextInt();
		}
		s.close();
	}
	
	
	
	
	public static Card.Suit stringToSuit(String s) {
		if(s.equals("S")) {
			return Card.Suit.SPADES;
		} if (s.equals("H")) {
			return Card.Suit.HEARTS;
		} if (s.equals("D")) {
			return Card.Suit.DIAMONDS;
		} if (s.equals("C")) {
			return Card.Suit.CLUBS;
		} else {
			return null;
		}
	}
	
	public static long handeval (int num_opponents, int rank1, String Suit1, int rank2, String Suit2, 
			int rank3, String Suit3, int rank4, String Suit4, int rank5, String Suit5) {
		
		double win = 0.0;
		double loss = 0.0;
		
		
		for(int i = 0; i < 10000; i++) {
			
		Deck deck1 = new DeckImpl();
			
		Card card1 = new CardImpl(rank1, stringToSuit(Suit1));
		Card card2 = new CardImpl(rank2, stringToSuit(Suit2));
		Card card3 = new CardImpl(rank3, stringToSuit(Suit3));
		Card card4 = new CardImpl(rank4, stringToSuit(Suit4));
		Card card5 = new CardImpl(rank5, stringToSuit(Suit5));
		
		deck1.findAndRemove(card1);
		deck1.findAndRemove(card2);
		deck1.findAndRemove(card3);
		deck1.findAndRemove(card4);
		deck1.findAndRemove(card5);
		
		Card[] mycards = new Card[5];
		mycards[0] = card1;
		mycards[1] = card2;
		mycards[2] = card3;
		mycards[3] = card4;
		mycards[4] = card5;
		
		PokerHand mypokerhand = new PokerHandImpl(mycards);
		PokerHand[] opphand = new PokerHandImpl[num_opponents];
		
	
		for(int j = 0; j < num_opponents; j++) {
			Card[] pokergame = new Card[5];
			for(int k = 0; k < 5; k++) {
				pokergame[k] = deck1.dealNextCard();
			}
		opphand[j] = new PokerHandImpl(pokergame);
		}
		if (isWin(mypokerhand, opphand)) {
			win++;
		} else {
			loss++;
		}
		
	}
		double winPercent = 100 * (win/(loss+win));
		long thankyajesus = Math.round(winPercent);
		
		return thankyajesus;
}
	
	/*missing output:
	 * 97
	94
	91
	88
	85
	82
	80
	78
	75
	
	From input:
	1 5 H 5 D 14 S 14 D 10 C
2 5 H 5 D 14 S 14 D 10 C
3 5 H 5 D 14 S 14 D 10 C
4 5 H 5 D 14 S 14 D 10 C
5 5 H 5 D 14 S 14 D 10 C
6 5 H 5 D 14 S 14 D 10 C
7 5 H 5 D 14 S 14 D 10 C
8 5 H 5 D 14 S 14 D 10 C
	 */

	public static boolean isWin(PokerHand mypokerhand, PokerHand[] opponent) {
		int i = 0;
		while(i < opponent.length) {
			
			if (mypokerhand.compareTo(opponent[i]) <= 0) {
				return false;
			}
			i++;
		}
		return true;
	}
}
