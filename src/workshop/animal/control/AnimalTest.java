package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Pet;

public class AnimalTest {
	public static void main(String[] args) {
		Cat cat1 = new Cat();
		Pet cat2 = new Cat();
		Animal cat3 = new Cat();
		
		//pet
		cat1.setName("톰");
		System.out.println(cat1.getName());
		cat1.play();
		//animal
		cat1.eat();
		cat1.walk();
		
		//pet 메소드만 가능
		cat2.setName("송별");
		System.out.println(cat2.getName());
		cat2.play();
		
		//animal 메소드만 가능
		cat3.eat();
		cat3.walk();
	}
}
