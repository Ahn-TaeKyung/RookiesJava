package workshop.animal.entity;

public class Fish extends Animal implements Pet {
	private String name;
	
	public Fish() {
		super(0);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println("물고기는 헤엄치는게 노는게 아니에요!!");
	}

	@Override
	public void eat() {
		System.out.println("물고기는 종마다 먹는게 천지차이에요!!");
	}

}
