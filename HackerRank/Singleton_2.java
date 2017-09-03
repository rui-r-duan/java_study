class Singleton {
	private Singleton() {}
    public static String str;
    
    private static class SingletonHolder {
    	private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getSingleInstance() {
    	return SingletonHolder.INSTANCE;
    }
}
