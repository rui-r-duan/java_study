class TestArray {
    public static void main(String[] args) {
	int[] anArray = new int[10];
	int success = 0;
	for (int i = 0; i < 10; i++) {
	    System.out.println(anArray);
	    System.out.println(!success);
	}
    }
}