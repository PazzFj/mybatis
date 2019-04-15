/**
 * Copyright 2009-2019 the original author or authors.
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
package org.apache.ibatis.cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * 用于缓存提供程序的SPI
 * <p>
 * 将为每个名称空间创建一个缓存实例
 * <p>
 * 缓存实现必须有一个构造函数，该构造函数接收缓存id作为字符串参数
 * <p>
 * MyBatis将名称空间作为id传递给构造函数
 */

public interface Cache {

    /**
     */
    String getId();

    /**
     */
    void putObject(Object key, Object value);

    /**
     */
    Object getObject(Object key);

    /**
     */
    Object removeObject(Object key);

    /**
     */
    void clear();

    /**
     */
    int getSize();

    /**
     * 获取读写锁
     */
    ReadWriteLock getReadWriteLock();

}
