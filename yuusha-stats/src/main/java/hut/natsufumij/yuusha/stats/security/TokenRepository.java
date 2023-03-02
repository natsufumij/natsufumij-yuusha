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
 * Token 颁发仓库
 * @author Administrator
 */
public interface TokenRepository {
    
    /**
     * 生成用户的Token
     * @param user
     * @return 
     */
    Future<String> token(UserStats user);

    /**
     * 刷新用户的Token
     * @param token
     * @return 
     */
    Future<String> refreshToken(String token);
    
    /**
     * 根据token获取用户数据
     * @param token
     * @return 
     */
    Future<UserStats> user(String token);
}
