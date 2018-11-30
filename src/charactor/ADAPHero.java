package charactor;

public class ADAPHero extends Hero implements AD, AP {

	@Override
	public void APAttack() {
		// TODO Auto-generated method stub
		System.out.println("AP Attack");
	}

	@Override
	public void ADAttack() {
		// TODO Auto-generated method stub
		System.out.println("AD Attack");
	}

}
