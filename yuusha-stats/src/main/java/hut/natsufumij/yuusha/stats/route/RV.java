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
import java.util.List;

/**
 * 响应结果类
 *
 * @author Administrator
 */
public record RV<T>(int hCode, int code, String msg, T data, Page<T> page) {

    public static RV<Void> of(int code, String msg) {
        return of(400, code, msg);
    }

    public static RV<Void> of(int hCode, int code, String msg) {
        return new RV<>(hCode, code, msg, null, null);
    }

    public static <T> RV<T> of(T t) {
        return new RV<>(200, 0, "OK", t, null);
    }

    public static <T> RV<T> of(Page<T> t) {
        return new RV<>(200, 0, "OK", null, t);
    }

    public static <T> RV<T> of(List<T> t) {
        return new RV<>(200, 0, "OK",
                null, Page.of(t));
    }

    public static void error(int hCode, int code, String msg) {
        throw new RVException(hCode, code, msg);
    }
}
