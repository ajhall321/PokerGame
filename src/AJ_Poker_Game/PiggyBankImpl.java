package AJ_Poker_Game;

public class PiggyBankImpl implements PiggyBank {

	private int bank;
	
	public PiggyBankImpl() {
		this.bank = 500;
	}
	

	public int getBank() {
		// TODO Auto-generated method stub
		return this.bank;
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.bank == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void resetBank() {
		// TODO Auto-generated method stub
		this.bank = 500;
	}

	
}
