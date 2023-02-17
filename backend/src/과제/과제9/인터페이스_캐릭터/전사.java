package 과제.과제9.인터페이스_캐릭터;

public class 전사 implements 캐릭터{
	private int hp;
	@Override
	public void hit() {
		System.out.println("검을 이용하여 공격한다.");		
	}
	@Override
	public void setHp(int hp) {
		if(hp > MAX_HP) {//만약에 hp가 hp 최대치 보다 크면
			this.hp = 캐릭터.MAX_HP;
			System.out.println("최대 HP 회복 " + MAX_HP);
		}else {
			this.hp = hp;
			System.out.println("HP 회복 " + hp);
		}		
	}
}
