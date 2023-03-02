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

/**
 * 密码吻合器
 *
 * @author Administrator
 */
public interface PassCorder {

    /**
     * 判断password明文密码与加密密码是否吻合
     *
     * @param encryptedPassword
     * @param password
     * @return
     */
    boolean corder(String encryptedPassword, String password);
}
