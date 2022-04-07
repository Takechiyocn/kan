package com.kan.proxy.staticproxy.proxy;

import com.kan.proxy.business.entities.User;
import com.kan.proxy.business.interfaces.UserService;
import com.kan.proxy.business.transactions.MyTransaction;

/**
 * 静态代理
 *   优点：业务类UserServiceImpl只需关注业务逻辑本身，保证业务重用性
 *   缺点：1. 代理对象的一个接口只服务于一种类型的对象，如果代理方法很多
 *           则需为每一种方法进行代理，程序规模稍大时无法胜任
 *        2. 如果接口增加方法如UserService增加修改方法UpdateUser()，则所有实现类和代理类均需实现(重写Override)该方法
 */
public class ProxyUser implements UserService {
    // bean类
    private UserService userService;
    // 事务类
    private MyTransaction transaction;
    // 构造函数
    public ProxyUser(UserService userService, MyTransaction myTransaction) {
        this.userService = userService;
        this.transaction = myTransaction;
    }

    @Override
    public void addUser(User user) {
        transaction.before();
        userService.addUser(user);
        transaction.after();
    }

    @Override
    public void deleteUser(int uid) {
        transaction.before();
        userService.deleteUser(uid);
        transaction.after();
    }
}
