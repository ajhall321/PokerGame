package AJ_Poker_Game;

public class CardImpl implements Card {
	private int rank;
	private Card.Suit suit;

	public CardImpl(int rank, Card.Suit suit) {
		this.rank = rank;
		this.suit = suit;

		if ((rank < 2) || (rank > 14)) {
			throw new RuntimeException("Card is out of range");
		}
	}

	public int getRank() {
		return rank;

	}

	public Card.Suit getSuit() {
		return suit;
	}

	// this is used to change the rank's numerical value into english syntax
	// use a string array in the future for this part if necessary in pokerhand etc

	public String toString1(int r) {
		if (r == 2) {
			return "Two";
		}
		if (r == 3) {
			return "Three";
		}
		if (r == 4) {
			return "Four";
		}
		if (r == 5) {
			return "Five";
		}
		if (r == 6) {
			return "Six";
		}
		if (r == 7) {
			return "Seven";
		}
		if (r == 8) {
			return "Eight";
		}
		if (r == 9) {
			return "Nine";
		}
		if (r == 10) {
			return "Ten";
		}
		if (r == 11) {
			return "Jack";
		}
		if (r == 12) {
			return "Queen";
		}
		if (r == 13) {
			return "King";
		}
		if (r == 14) {
			return "Ace";
		}
		return null;
	}

	public String toString() {
		return toString1(rank) + " of " + Card.suitToString(suit);
	}

	public boolean equals(Card other) {
		return (other.getRank() == this.getRank()) && (other.getSuit() == this.getSuit());
	}
}

// Your implementation of the Card interface should be called CardImpl.
//
// The Card interface includes the following methods:
// * int getRank()
// * Returns the "rank" of a playing card. Each card should have a rank between
// 2 and 14. The rank value of the face cards (i.e., Jack, Queen, King, and Ace)
// should be 11, 12, 13, and 14.
// * Card.Suit getSuit()
// * Returns the "suit" of a playing card (i.e., spades, hearts, diamonds, or
// clubs). Each card should have a suit that is one of the enumerated symbols
// defined in the Card.Suit enumeration.
// * String toString()
// * Returns a string representation of the card. This should be in the form of
// "Rank of Suit" where "Rank" is the word representation of each rank. The
// non-face card ranks should be in the form of their English word equivalent
// with an initial capital letter (i.e., "Two", "Three", etc.). The face card
// ranks should be in the form of their names with an initial capital letter
// (i.e., "Jack", "Queen", "King", "Ace"). The string representation of the suit
// should be one of "Spades", "Hearts", "Diamonds", or "Clubs". For example, a
// card with rank value 12 and suit value Card.HEARTS should produce the string:
// "Queen of Hearts".
// * boolean equals(Card other)
// * Returns true if the card passed in as _other_ has the same rank and suit
// values.
//
// CardImpl should provide a constructor with the following declaration:
// ```
// public CardImpl(int rank, Card.Suit suit)
// ```

