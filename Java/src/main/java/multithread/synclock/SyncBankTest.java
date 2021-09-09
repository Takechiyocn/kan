package multithread.synclock;

public class SyncBankTest {

    // 账户数
    public static final int NACCOUTS = 100;
//    public static final int NACCOUTS = 10;
    // 账户初始化金额
    public static final double INITIAL_BALANCE = 1000;
    // 转账最大金额
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {

        SyncBank syncBank = new SyncBank(NACCOUTS, INITIAL_BALANCE);

        for (int i = 0; i < NACCOUTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                while (true) {
                    int toAccount = (int) (syncBank.size() * Math.random());
                    double amount = MAX_AMOUNT * Math.random();
                    // 阻塞所有线程
//                    double amount = INITIAL_BALANCE * 2;
                    try {
                        syncBank.transfer(fromAccount, toAccount, amount);
//                        SyncBank.printInfo();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep((int) (DELAY * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread t = new Thread(r);
            t.start();
        }
        System.out.println("End!");
    }
}
