class TestObject {
    private static int cnt = 0;
    public TestObject() {
        ++cnt;
        System.out.println("TestObject(): " + cnt);
    }
}