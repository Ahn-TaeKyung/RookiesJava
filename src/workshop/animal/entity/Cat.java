package workshop.animal.entity;

public class Cat extends Animal implements Pet {
	private String name;
	
	public Cat(String name) {
		super(4);
		this.name = name;
	}
	
	public Cat() {
		this("");
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
		System.out.println("고양이는 집사가 놀아주지 않아 심심해요...");
	}

	@Override
	public void eat() {
		System.out.println("고양이는 사료만 먹어요!");
	}

}
