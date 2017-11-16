package chap08.ryan;

class Account {
    protected double balance;
    public Account(double b) { balance = b; }
    public double getBalance() {
        double result = balance;
        System.out.println("Account getBalance(): " + result);
        return result;
    }
}

class MyAcc extends Account {
    private double ratio;
    public MyAcc (double b, double r) { ratio = r; }
    public double getBalance() {
        double result = balance * ratio;
        System.out.println("MyAcc getBalance(): " + result);
        return result;
    }
}

class Inheritance {
    public static void main(String[] args) {
        Account a = new MyAcc(10.5, 2.57);
        double result = a.getBalance();
    }
}