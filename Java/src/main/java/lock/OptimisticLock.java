package lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 乐观锁OptimisticLock
 *   操作数据时非常乐观，认为别人不会同时修改数据，因此不会上锁。
 *   只在执行更新时判断在此期间数据是否有修改，如有则放弃执行操作
 *   实现方式：
 *     a. CAS机制
 *     b. 版本号机制
 * 悲观锁
 *   操作数据时非常悲观，认为别人会同时修改数据，操作数据时直接把数据锁住，直到操作完成后释放锁
 *   上锁期间别人不能修改数据
 *   实现方式：
 *    a. 代码块加锁，如Java的Synchronized关键字
 *    b. 对数据加锁，如MySQL中的排它锁
 *
 * CAS(Compare And Swap)操作数:
 *  a.需要读写的内存内置V
 *  b.进行比较的预期值A
 *  c.拟写入的新值B
 * 操作逻辑：
 *  if V==A，则V==B
 *  else do nothing
 *  许多CAS操作都是自旋的，即操作不成功则一直重试直到成功为止
 * CAS原子性：
 *   Compare和Swap两个操作是CPU支持的原子性操作，即硬件层面支持
 *
 * 版本号->实际应用中亦可使用时间戳等标记为版本字段：
 *   在数据中增加一个version字段，用于表示该数据的版本号，每当数据修改时，版本号加1
 * 操作逻辑：
 *   1. 线程查询数据时，将该数据版本号一起查出来
 *   2. 线程更新数据时，判断当前版本号与之前版本号是否一致，一致才进行操作
 *
 * 适用场景：
 *   乐观锁：简单而言多读场景
 *     CAS：
 *       1. 只保证单个变量的原子性操作，即涉及多个变量无法使用CAS
 *          -> 原子性(只能说明原子操作安全)不一定能保证线程安全，需配合volatile保证线程安全
 *       2. 不断重试CPU开销大
 *          -> a. 引入退出机制
 *             b. 高竞争下避免乐观锁
 *       3. 实现需硬件层面支持，普通用户无法直接使用，只能借助atomic包
 *     版本号机制：如果query针对表1，而update针对表2，很难通过简单版本号实现
 *     -> 当竞争不激烈(出现并发冲突概率小)时优先考虑乐观锁
 *   悲观锁：简单而言多写场景
 *     代码级别锁synchronized：对代码块加锁
 *     -> 当竞争激烈(出现并发冲突概率大)时优先考虑悲观锁，因为乐观锁会不断重试
 * 乐观锁自身不加锁：
 *   1. 乐观锁本身不加锁，只在更新时判断数据是否被其他线程更新了。如AtomicInteger
 *   2. 乐观锁可与悲观锁合作，如版本号机制乐观锁中使用queryForUpdate时，会对数据加锁
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
