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
package hut.natsufumij.yuusha.stats.impl;

import hut.natsufumij.yuusha.stats.backend.BackendApp;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

/**
 * 后端应用Verticle实现
 *
 * @author Administrator
 */
public class BackendVerticle extends AbstractVerticle {

    private final BackendApp app;

    public BackendVerticle(BackendApp app) {
        this.app = app;
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        //prepare 
    }

    @Override
    public void init(Vertx vertx, Context context) {
        //
        //
        //
    }
}
