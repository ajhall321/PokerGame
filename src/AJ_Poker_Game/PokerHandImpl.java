package AJ_Poker_Game;

public class PokerHandImpl implements PokerHand {

	private Card[] cards;
	private int handRankOnePair = 0;
	private int handRankTwoPair = 0;
	private int handRankThreeOfAKind = 0;
	private int handRankFlush = 0;
	private int handRankStraight = 0;
	private int handRankStraightFlush = 0;
	private int handRankFourOfAKind = 0;
	private int handRankFullHouse = 0;
	
	public PokerHandImpl(Card[] cards) {
		
		if ((cards[0] == null) || (cards[1] == null) || (cards[2] == null) || (cards[3] == null) || (cards[4] == null)) {
			throw new RuntimeException ("Not a valid Hand");
		}
		
		if (cards.length != 5) {
			throw new RuntimeException ("Not a Hand of 5 Cards");
		}
		for (int i=0; i<cards.length; i++) {
			  for (int j=i+1; j<cards.length; j++) {
			    if (cards[i].getRank() > cards[j].getRank()) {
			      Card tmp = cards[i];
			      cards[i] = cards[j];
			      cards[j] = tmp;
			    }
			  }
			}
		this.cards = cards.clone();
}
	
	
//	* Card[] getCards()
//	  * Returns as an array the five cards in the hand.
	public Card[] getCards() {
		Card[] arr = cards.clone();
		return arr;
	}
	
	
//	  * boolean contains(Card c)
//	    * Returns true if one of the cards in the hand matches in rank and suit the card passed in as a parameter.
//	public boolean equals(Card other) {
//		return (other.getRank() == this.getRank()) && (other.getSuit() == this.getSuit());
//	}
	//return type      method name      (argument1 type   argument1 var_name, ...)
	
	public boolean contains(Card c) {
		for(int i = 0; i < cards.length; i++) {
			if (getCards()[i].equals(c)) {
				return true;
			} 
		
		}
		return false;
	}
	
	
//	  * boolean isOnePair()
//	    * Indicates whether the hand is a one pair hand.

	public boolean isOnePair() {
		int pair_counter = 0;
			for(int k = 0; k < cards.length - 1; k++) {
				if (getCards()[k].getRank() == getCards()[k + 1].getRank()) {
					pair_counter += 1;
					handRankOnePair = getCards()[k].getRank();
				}
		}
		return pair_counter == 1;
	}
	
//	  * boolean isTwoPair()
//	    * Indicates whether the hand is a two pair hand.
	
	public boolean isTwoPair() {
		if ((getCards()[0].getRank() == getCards()[1].getRank()) && (getCards()[2].getRank() == getCards()[3].getRank()) 
				&& (getCards()[3].getRank() != getCards()[4].getRank()) 
				&& getCards()[0].getRank() != getCards()[3].getRank()) {
			handRankTwoPair = getCards()[3].getRank();
			return true;
		} else if ((getCards()[0].getRank() != getCards()[1].getRank()) && (getCards()[1].getRank() == getCards()[2].getRank()) 
				&& (getCards()[3].getRank() == getCards()[4].getRank()) 
				&& getCards()[1].getRank() != getCards()[3].getRank()) {
			handRankTwoPair = getCards()[4].getRank();
			return true;
		} else if ((getCards()[0].getRank() == getCards()[1].getRank()) && (getCards()[1].getRank() == getCards()[4].getRank()) 
				&& (getCards()[2].getRank() == getCards()[3].getRank()) 
				&& getCards()[1].getRank() != getCards()[3].getRank()) {
			return false;
		} else {
			return false;
		}
	}
//		int pair_counter = 0;
//		for(int i = 0; i < cards.length - 1; i++) {
//			int match_counter = 0;
//			
//			for(int k = (i + 1); k < cards.length; k++) {
//				if (CardHand[i].getRank() == getCards()[k].getRank()) {
//					match_counter += 1;
//					if (match_counter > 1) {
//						return false;
//					}
//					pair_counter += 1;
//					}
//				}
//			}
//		handRankTwoPair = getCards()[3].getRank();
//		return pair_counter == 2;
//	}
	
	
//	  * boolean isThreeOfAKind()
//	    * Indicates whether the hand is a three of a kind.
	public boolean isThreeOfAKind() {
		if (((getCards()[0].getRank() == getCards()[1].getRank()) && (getCards()[2].getRank() == getCards()[3].getRank()) && (getCards()[3].getRank() != getCards()[4].getRank()) 
				&& getCards()[0].getRank() != getCards()[3].getRank()) || ((getCards()[0].getRank() != getCards()[1].getRank()) && (getCards()[1].getRank() == getCards()[2].getRank()) && (getCards()[3].getRank() == getCards()[4].getRank()) 
						&& getCards()[1].getRank() != getCards()[3].getRank())) {
			return false;
		} else {
		int same_card_counter = 0;
			for(int k = 0; k < cards.length-1; k++) {
				if (getCards()[k].getRank() == getCards()[k + 1].getRank()) {
					same_card_counter += 1;
				}
			}
		handRankThreeOfAKind = getCards()[2].getRank();
		return same_card_counter == 2;
		}
	}
	
	
//	  * boolean isStraight()
//	    * Indicates whether the hand is a straight. Note, a hand that is a straight flush should return true for this method.
	
	public boolean isStraight() {
		int straight_counter = 0;
		if  ((getCards()[0].getRank() == 2) && (getCards()[1].getRank() == 3) && (getCards()[2].getRank() == 4) 
				&& (getCards()[3].getRank() == 5) && (getCards()[4].getRank() == 14)) {
			handRankStraight = getCards()[3].getRank();
			return true;
		} else {
		
		for(int i = 0; i < cards.length-1; i++) {
			if ((getCards()[i].getRank() + 1) == getCards()[i + 1].getRank()) {
				straight_counter += 1;
			}
		}
			handRankStraight = getCards()[4].getRank();
			return straight_counter == 4;
		}
		}
	
//	  * boolean isFlush()
//	    * Indicates whether the hand is a flush. Note, a hand that is a straight flush should return true for this method.
	public boolean isFlush() {
			if ((getCards()[0].getSuit() == getCards()[1].getSuit()) && (getCards()[1].getSuit() == getCards()[2].getSuit()) && 
					(getCards()[2].getSuit() == getCards()[3].getSuit()) && (getCards()[3].getSuit() == getCards()[4].getSuit())) {
				handRankFlush = getCards()[4].getRank();
				return true;
			}
			return false;
	}
	
	
//	  * boolean isFullHouse()
//	    * Indicates whether the hand is a full house.

	public boolean isFullHouse() {
//	 A hand with three cards that match in rank as in a three of a kind with the other two cards in the hand also matching in rank as in a pair.
//	 The hand value of a full house is 7 and the hand rank is the rank of the three cards that match.
		if ((getCards()[0].getRank() == getCards()[1].getRank()) && (getCards()[0].getRank() == getCards()[2].getRank()) && ((getCards()[2].getRank() != getCards()[3].getRank())) 
				&& ((getCards()[3].getRank() == getCards()[4].getRank()))) {
			 handRankFullHouse = getCards()[2].getRank();
		return true;
			} else {
				if ((getCards()[0].getRank() == getCards()[1].getRank()) && (getCards()[0].getRank() != getCards()[2].getRank()) && ((getCards()[2].getRank() == getCards()[3].getRank())) 
						&& ((getCards()[3].getRank() == getCards()[4].getRank()))) {
						handRankFullHouse = getCards()[4].getRank();
						return true;
					} else {
				return false;
				} 
			}
	}
//	  * boolean isFourOfAKind()
//	    * Indicates whether the hand is a four of a kind.
	public boolean isFourOfAKind() {
		if (((getCards()[0].getRank() == getCards()[1].getRank()) && (getCards()[0].getRank() == getCards()[2].getRank()) && ((getCards()[2].getRank() != getCards()[3].getRank())) 
				&& ((getCards()[3].getRank() == getCards()[4].getRank()))) || ((getCards()[0].getRank() == getCards()[1].getRank()) && (getCards()[0].getRank() != getCards()[2].getRank()) && ((getCards()[2].getRank() == getCards()[3].getRank())) 
						&& ((getCards()[3].getRank() == getCards()[4].getRank())))) {
						return false;
		} else {
	int same_card_counter = 0;
		for(int k = 0; k < cards.length - 1; k++) {
			if (getCards()[k].getRank() == getCards()[k + 1].getRank()) {
				same_card_counter += 1;
			}
		}
		handRankFourOfAKind = getCards()[3].getRank();
		return same_card_counter == 3;
		}
}



//	  * boolean isStraightFlush()
//	    * Indicates whether the hand is a straight flush (i.e., both a straight and a flush). 

	public boolean isStraightFlush() {
		int waddup = 0;
		int straight_counter = 0;
		if  (((getCards()[4].getRank() == 14) && (getCards()[0].getRank() == 2) && (getCards()[1].getRank() == 3) 
				&& (getCards()[2].getRank() == 4) && (getCards()[3].getRank() == 5)) && ((getCards()[0].getSuit() == getCards()[1].getSuit()) && (getCards()[1].getSuit() == getCards()[2].getSuit()) && 
						(getCards()[2].getSuit() == getCards()[3].getSuit()) && (getCards()[3].getSuit() == getCards()[4].getSuit()))) {
			handRankStraightFlush = getCards()[3].getRank();
			return true;
		} else {
		for(int i = 0; i < cards.length-1; i++) {
			if ((getCards()[i].getRank() + 1) == getCards()[i + 1].getRank()) {
				straight_counter += 1;
			}
		}
			if ((getCards()[0].getSuit() == getCards()[1].getSuit()) && (getCards()[1].getSuit() == getCards()[2].getSuit()) && 
					(getCards()[2].getSuit() == getCards()[3].getSuit()) && (getCards()[3].getSuit() == getCards()[4].getSuit())) {
				waddup += 1;
				handRankStraightFlush = getCards()[4].getRank();
	}
		}
		return straight_counter == 4 && waddup == 1;		
}



//	  * int getHandTypeValue()
//	    * Returns the hand value of the hand as described above.
//* When trying to determine hand rank, for each type of hand, think about whether or not you can identify a particular 
//card position in the sorted array that must contain a card with the appropriate rank of the hand as a whole. For example, 
//in a three of a kind, assuming the cards are stored in rank sorted order, the card in position (i.e., index) 
//2 must be one of the cards that is part of the three of kind.

		public int getHandTypeValue() {
			int hand_type_value = 1;
			if (isOnePair()) {
				hand_type_value = 2;
			}
				if (isTwoPair()) {
					hand_type_value = 3;
				}
					if (isThreeOfAKind()) {
						hand_type_value = 4;
					}
						if (isStraight()) {
							hand_type_value = 5;
						}
							if (isFlush()) {
								hand_type_value = 6;
							}
								if (isStraightFlush()) {
									hand_type_value = 9;
								}
									if (isFourOfAKind()) {
										hand_type_value = 8;
									}
										if (isFullHouse()) {
											hand_type_value = 7;
										}
			
			return hand_type_value;
		}
		

public int getHandRank() {
	// need to get the highest card for the hand OR get the high card 
	
	if (isOnePair()) {
	return handRankOnePair;
	} else {
	if (isTwoPair()) {
	return handRankTwoPair;
	} else {
	if (isThreeOfAKind()) {
	return handRankThreeOfAKind;
	} else {
	if (isStraightFlush()) {
		return handRankStraightFlush;
	} else {
	if (isFlush()) {
		return handRankFlush;
	} else {
	if (isStraight()) {
		return handRankStraight;
	} else {
	if (isFourOfAKind()) {
		return handRankFourOfAKind;
	} else {
	if (isFullHouse()) {
	return handRankFullHouse;
	}}}}}}}}
	return getCards()[4].getRank();
}

public int compareTo(PokerHand other) {

	if (this.getHandTypeValue() > other.getHandTypeValue()) {
		return 1;
	} if (this.getHandTypeValue() < other.getHandTypeValue()) {
		return -1;
	} if (this.getHandTypeValue() == other.getHandTypeValue()) {
			if (this.getHandRank() > other.getHandRank()) {
			return 1;
			} else if (this.getHandRank() < other.getHandRank()) {
			return -1;
			} else { 
				return 0;
			}
	}
	return 0;
}



}

