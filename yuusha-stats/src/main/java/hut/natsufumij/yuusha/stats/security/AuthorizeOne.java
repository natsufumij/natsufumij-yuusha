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
package hut.natsufumij.yuusha.stats.security;

import io.vertx.core.Future;

/**
 * 单项鉴权规则
 * @author Administrator
 */
public interface AuthorizeOne {

    /**
     * 鉴权优先级，最高级为0,值越小代表优先级越高
     * @return 
     */
    int priority();
    
    /**
     * 鉴权方法
     * @param stats
     * @return 
     */
    Future<Void> authorize(UserStats stats);
}
