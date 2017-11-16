package chap15.ryan;

public class InnerClassSyncMethod {
    private Account account = new Account();

    public static void main(String[] args) {
        InnerClassSyncMethod mainObj = new InnerClassSyncMethod();
        // InnerClassSyncMethod.Withdrawal innerObj = mainObj.new Withdrawal();
        mainObj.doStuff();
    }

    public void doStuff() {
        WithdrawalOne w = new WithdrawalOne();
        WithdrawalTwo d = new WithdrawalTwo();
        Thread alpha = new Thread(w);
        Thread beta = new Thread(d);
        alpha.setName("Alpha");
        beta.setName("Beta");
        alpha.start();
        beta.start();
        // try {
        //     Thread.sleep(4000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // System.out.println("final: " + account.getBalance());
    }

    class WithdrawalOne implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (account) {
                    if (account.getBalance() >= 10) {
                        System.out.println(Thread.currentThread().getName()
                                           + " is about to withdrawal");
                        try {
                            System.out.println(Thread.currentThread().getName()
                                               + " is going to sleep");
                            Thread.sleep(500);
                        } catch (InterruptedException ex) { ex.printStackTrace(); }
                        System.out.println(Thread.currentThread().getName()
                                           + " woke up");
                        account.withdraw(10);
                        System.out.println(Thread.currentThread().getName()
                                           + " completes the withdrawal");
                    } else {
                        System.out.println("Sorry, not enough for "
                                           + Thread.currentThread().getName());
                    }
                }
                if (account.getBalance() < 0) {
                    System.out.println("OVERDRAWN!");
                }
            }
        }
    }

    class WithdrawalTwo implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized(account) {
                    if (account.getBalance() >= 10) {
                        System.out.println("  " + Thread.currentThread().getName()
                                           + " is about to withdrawal");
                        try {
                            System.out.println("  " + Thread.currentThread().getName()
                                               + " is going to sleep");
                            Thread.sleep(500);
                        } catch (InterruptedException ex) { ex.printStackTrace(); }
                        System.out.println("  " + Thread.currentThread().getName()
                                           + " woke up");
                        account.withdraw(10);
                        System.out.println("  " + Thread.currentThread().getName()
                                           + " completes the withdrawal");
                    } else {
                        System.out.println("  " + "Sorry, not enough for "
                                           + Thread.currentThread().getName());
                    }
                }
            }
            if (account.getBalance() < 0) {
                System.out.println("  OVERDRAWN!");
            }
        }
    }
}

class Account {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
