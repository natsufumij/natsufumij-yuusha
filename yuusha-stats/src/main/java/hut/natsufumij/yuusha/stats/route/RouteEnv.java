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
package hut.natsufumij.yuusha.stats.route;

import hut.natsufumij.yuusha.stats.db.Page;
import hut.natsufumij.yuusha.stats.db.PageModel;
import hut.natsufumij.yuusha.stats.security.UserStats;
import hut.natsufumij.yuusha.stats.valid.ValidObject;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;
import java.util.List;

/**
 * 路由环境
 *
 * @author Administrator
 */
public interface RouteEnv {

    /**
     * 获取路由请求体JSON绑定的对象
     *
     * @param <T>
     * @param tClass
     * @return
     */
    <T> T body(Class<T> tClass);

    /**
     * 获取路由查询参数绑定的对象
     *
     * @param <T>
     * @param tClass
     * @return
     */
    <T> T queryBody(Class<T> tClass);

    /**
     * 获取路由路径绑定的对象
     *
     * @param <T>
     * @param pClass
     * @return
     */
    <T> T pathBody(Class<T> pClass);

    /**
     * 获取请求的用户对象
     *
     * @return
     */
    Future<UserStats> getUser();

    /**
     * 获取验证成功的路由请求体JSON绑定的对象
     *
     * @param <T>
     * @param tClass
     * @return
     */
    <T extends ValidObject> Future<T> validBody(Class<T> tClass);

    /**
     * 获取验证成功的路由查询参数绑定的对象
     *
     * @param <T>
     * @param tClass
     * @return
     */
    <T extends ValidObject> Future<T> validQueryBody(Class<T> tClass);

    /**
     * 获取分页数据配置(从查询参数中查询)
     *
     * @return
     */
    PageModel page();

    /**
     * 获取路由上下文
     *
     * @return
     */
    RoutingContext rtx();

    /**
     * 获取可用vertx实例
     *
     * @return
     */
    Vertx vertx();

    /**
     * 绑定结果，如果失败则返回错误码
     *
     * @param <T>
     * @param data
     */
    <T> void bind(Future<T> data);

    /**
     * 绑定分页数据结果，如果失败则返回错误码
     *
     * @param <T>
     * @param data
     */
    <T> void bindPage(Future<Page<T>> data);

    /**
     * 绑定列表数据结果，如果失败则返回错误码
     *
     * @param <T>
     * @param data
     */
    <T> void bindList(Future<List<T>> data);
}
