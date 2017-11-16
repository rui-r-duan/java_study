package chap08.ryan;

public class TestOldDog {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.roam();
        d.bark();
        Canine c = (Canine)d;
        c.roam();
        c.bark();
        Animal a = (Animal)c;
        ((Dog)a).bark();
    }
}