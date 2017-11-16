package chap08.ryan;

class TestNewDog {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        Canine c = (Canine)d;
        c.eat();
    }
}
