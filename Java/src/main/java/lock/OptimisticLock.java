package lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author moku
 */
public class OptimisticLock {
    // 不使用锁
    private static int value1 = 0;
    // 乐观锁：使用原子类CAS
    private static AtomicInteger value2 = new AtomicInteger(0);
    // 悲观锁
    private static int value3 = 0;

    // 悲观锁
    private static synchronized void increaseValue3() {
        value3++;
    }

    public static void casOptimisticLock() throws InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(
                2,
                10000,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i< 10000; i++) {
            pool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value1++;
                value2.getAndIncrement();
                increaseValue3();
            });
        }
        Thread.sleep(1000);
        System.out.println("线程不安全：" + value1);
        System.out.println("乐观锁(AtomicInteger)：" + value2);
        System.out.println("悲观锁(synchronized)：" + value3);
    }

    /**
     * 更新玩家金币：
     *   更新后的金币数依赖于当前状态(金币数，等级等)
     */
    private static void versionOptimisticLock() {
        Integer playerId = 10;
        // 不使用锁
        updateCoinsUnsafe(playerId);
        // 乐观锁：对数据加锁
        updateCoinsPessimistic(playerId);
        // 悲观锁：版本号机制
        updateCoinsOptimistic(playerId);
    }

    /**
     * 不使用锁
     * 线程不安全：如果其他线程在query和update之间更新了玩家信息，会导致玩家金币数不准确
     *
     * @param playerId
     */
    public static void updateCoinsUnsafe(Integer playerId){
//        //根据player_id查询玩家信息
//        Player player = query("select coins, level from player where player_id = {0}", playerId);
//        //根据玩家当前信息及其他信息，计算新的金币数
//        Long newCoins = ……;
//        //更新金币数
//        update("update player set coins = {0} where player_id = {1}", newCoins, playerId);
    }

    /**
     * 悲观锁(pessimistic)：使用排它锁，select ... for update
     * 上述查询语句会为数据加上排它锁，直到事务提交或回滚才释放，期间其他线程无法更新该数据
     * @param playerId
     */
    private static void updateCoinsPessimistic(Integer playerId) {
//        //根据player_id查询玩家信息（加排它锁）
//        Player player = queryForUpdate("select coins, level from player where player_id = {0} for update", playerId);
//        //根据玩家当前信息及其他信息，计算新的金币数
//        Long newCoins = ……;
//        //更新金币数
//        update("update player set coins = {0} where player_id = {1}", newCoins, playerId);
    }

    /**
     * 乐观锁：版本号(表字段可见，trx_id为视图事务号)
     *   为数据增加一个version字段。
     * 操作流程：
     *   1. 初次查询出version信息
     *   2. 更新时校验version是否发生变化，变化则不更新
     * @param playerId
     */
    private static void updateCoinsOptimistic(Integer playerId) {
//        //根据player_id查询玩家信息，包含version信息
//        Player player = query("select coins, level, version from player where player_id = {0}", playerId);
//        //根据玩家当前信息及其他信息，计算新的金币数
//        Long newCoins = ……;
//        //更新金币数，条件中增加对version的校验
//        update("update player set coins = {0}, version = version + 1 where player_id = {1} and version = {2}", newCoins, playerId, player.version);
    }

    public static void main(String[] args) throws InterruptedException {
        // CAS实现乐观锁
        casOptimisticLock();

        // 版本号实现乐观锁
        versionOptimisticLock();
    }
}
