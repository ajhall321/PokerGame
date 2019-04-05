package AJ_Poker_Game;

public class UserImpl implements User {

	private PiggyBankImpl bank;
	private String name;
	private CardImpl myHand;
	
	public class UserImpl(String name) {
		if(name == null) {
			throw new RuntimeException("negative ghostrider");
		}
		this.name = name;
		this.bank = new PiggyBankImpl();
		this.myHand = null;
	}
	
}
