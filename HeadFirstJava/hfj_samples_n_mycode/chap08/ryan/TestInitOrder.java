package chap08.ryan;

class Cat {
    // String nickname = breed; // error: illegal forward reference
    String breed = new String("Persian");
    String name = breed;

    Cat() {
        System.out.println("ctor #1: " + breed + " " + name);
        breed = null;
        System.out.println("ctor #1: after set: " + breed);
    }

    Cat(String breed) {
        System.out.println("ctor #2: " + this.breed + " " + name);
        this.breed = breed;
        System.out.println("ctor #2: after set: " + this.breed);
    }
}

public class TestInitOrder {
    public static void main(String[] args) {
        new Cat();
        new Cat("Zhe'er mao");
    }
}
