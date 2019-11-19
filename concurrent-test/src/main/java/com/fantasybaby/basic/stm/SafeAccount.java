package com.fantasybaby.basic.stm;

import org.multiverse.api.StmUtils;
import org.multiverse.api.references.TxnLong;
import static org.multiverse.api.StmUtils.*;

/**
 * 使用multiverse 来使用stm
 * @author: liuxi
 * @time: 2019/11/13 20:55
 */
public class SafeAccount {

        //余额
        private TxnLong balance;
        //构造函数
        public SafeAccount(long balance){
            this.balance = StmUtils.newTxnLong(balance);
        }
        //转账
        public void transfer(SafeAccount to, int amt){
            //原子化操作
            atomic(()->{
                if (this.balance.get() > amt) {
                    this.balance.decrement(amt);
                    to.balance.increment(amt);
                }
            });
        }
}
