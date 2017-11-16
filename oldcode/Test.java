class Test {
    private TestObject a = new TestObject();
    private TestObject b;

    public Test() {
        System.out.println("Test()");
        b = new TestObject();
        System.out.println("Create TextObject b"); 
    }

    public static void main(String[] args) {
        Test t = new Test();
    }
}