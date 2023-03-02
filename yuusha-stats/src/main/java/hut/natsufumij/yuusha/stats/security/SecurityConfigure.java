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

import java.util.List;

/**
 * 用户安全配置
 *
 * @author Administrator
 */
public interface SecurityConfigure {

    /**
     * 配置用户信息认证库
     * @param userStatsRepository 
     */
    void userStats(UserStatsRepository userStatsRepository);
    
    /**
     * 添加密码吻合器
     * @param corder 
     */
    void pass(PassCorder corder);
    
    /**
     * 配置Token颁发仓库
     * @param repo 
     */
    void token(TokenRepository repo);
    
    /**
     * 为用户添加信息进行鉴权
     * @param one
     */
    void authorize(AuthorizeOne one);
    
    /**
     * 添加访问路径白名单 
     * @param routes
     */
    void white(List<String> routes);
}
