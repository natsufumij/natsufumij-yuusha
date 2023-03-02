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

/**
 * 异常处理类
 *
 * @author Administrator
 */
public class RVException extends RuntimeException {

    /**
     * 异常的HTTP状态码
     */
    private final int hCode;
    /**
     * 异常的代码
     */
    private final int code;
    /**
     * 异常的消息
     */
    private final String msg;

    public RVException(int hCode, int code, String msg) {
        super(msg);
        this.hCode = hCode;
        this.code = code;
        this.msg = msg;
    }

    public int gethCode() {
        return hCode;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
