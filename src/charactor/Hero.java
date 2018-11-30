package charactor;	//´ò°ü

public class Hero {
	String name;
	float hp;
	float armor;
	int moveSpeed;
	Hero(){
		System.out.println("Construct");
	}
	public Hero(int a){
		System.out.println("a");
		System.out.println("Construct");
	}
	public void finalize(){
		System.out.println("Deconstruct");
	}
}
