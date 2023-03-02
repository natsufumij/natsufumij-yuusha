/*
 * Copyright (C) 2023 Administrator
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package hut.natsufumij.yuusha.stats.db;

/**
 * 数据库配置
 *
 * @author Administrator
 */
public interface DataBaseConfigure {

    /**
     * 数据库host 默认localhost
     *
     * @param host
     * @return
     */
    DataBaseConfigure host(String host);

    /**
     * 数据库端口 默认3306
     *
     * @param port
     * @return
     */
    DataBaseConfigure port(int port);

    /**
     * 数据库名称
     *
     * @param db
     * @return
     */
    DataBaseConfigure db(String db);

    /**
     * 连接用户名 默认root
     *
     * @param user
     * @return
     */
    DataBaseConfigure user(String user);

    /**
     * 连接密码 默认root
     *
     * @param password
     * @return
     */
    DataBaseConfigure password(String password);

    /**
     * 连接池数量，默认为1
     *
     * @param size
     * @return
     */
    DataBaseConfigure pool(int size);

    /**
     * 管道数量，默认为1
     *
     * @param limit
     * @return
     */
    DataBaseConfigure pipe(int limit);

    /**
     * 连接超时毫秒数 默认为10000
     *
     * @param connectTimeOut
     * @return
     */
    DataBaseConfigure connectTimeOut(int connectTimeOut);

    /**
     * 重连间隔毫秒数 默认1000
     *
     * @param reconnectInterval
     * @return
     */
    DataBaseConfigure reconnectInterval(int reconnectInterval);

    /**
     * 尝试重连次数 默认10
     *
     * @param reconnectAttempt
     * @return
     */
    DataBaseConfigure reconnectAttempt(int reconnectAttempt);
}
