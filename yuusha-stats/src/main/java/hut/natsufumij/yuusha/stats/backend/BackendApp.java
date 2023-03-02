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
package hut.natsufumij.yuusha.stats.backend;

import hut.natsufumij.yuusha.stats.db.DataBaseConfigure;
import hut.natsufumij.yuusha.stats.impl.BackendVerticle;
import hut.natsufumij.yuusha.stats.route.RouteConfigure;
import hut.natsufumij.yuusha.stats.security.SecurityConfigure;
import io.vertx.core.Vertx;

/**
 * 后端应用配置接口
 * @author Administrator
 */
public interface BackendApp {

    /**
     * 配置路由
     * @param route 
     */
    default void config(RouteConfigure route){
        
    }

    /**
     * 配置数据库
     * @param db 
     */
    default void config(DataBaseConfigure db) {
    }

    /**
     * 配置安全框架
     * @param security 
     */
    default void config(SecurityConfigure security) {
    }

    /**
     * 启动方法
     * @param app 
     */
    static void boot(BackendApp app) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new BackendVerticle(app));
    }
}
