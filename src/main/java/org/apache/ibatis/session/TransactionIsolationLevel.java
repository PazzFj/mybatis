/**
 * Copyright 2009-2018 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.session;

import java.sql.Connection;

/**
 * 事务隔离级别
 * <p>
 *            脏读 不可重复读 幻读     说明
 * Read uncommitted	√	√	√       直译就是"读未提交",意思就是即使一个更新语句没有提交,但是别的事务可以读到这个改变.这是很不安全的。允许任务读取数据库中未提交的数据更改，也称为脏读。
 * Read committed	×	√	√       直译就是"读提交",可防止脏读，意思就是语句提交以后即执行了COMMIT以后别的事务就能读到这个改变. 只能读取到已经提交的数据。Oracle等多数数据库默认都是该级别
 * Repeatable read	×	×	√       直译就是"可以重复读",这是说在同一个事务里面先后执行同一个查询语句的时候,得到的结果是一样的.在同一个事务内的查询都是事务开始时刻一致的，InnoDB默认级别。在SQL标准中，该隔离级别消除了不可重复读，但是还存在幻象读
 * Serializable	    ×	×	×       直译就是"序列化",意思是说这个事务执行的时候不允许别的事务并发执行. 完全串行化的读，每次读都需要获得表级共享锁，读写相互都会阻塞
 */
public enum TransactionIsolationLevel {
    NONE(Connection.TRANSACTION_NONE),  // 不使用
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),  // 读取已提交
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),  // 读操作未提交
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),  // 可重复读取
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);  // 可串行化

    private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
