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

import java.util.Collections;
import java.util.List;

/**
 * 分页数据
 *
 * @author Administrator
 */
public record Page<T>(PageModel mode, int total, List<T> items, int totalPage) {

    public static <T> Page<T> of(PageModel page, Class<T> tc) {
        return new Page<>(page,
                0, List.of(), 0);
    }

    public static <T> Page<T> of(List<T> tc) {
        return new Page<>(new PageModel(1, tc.size()),
                tc.size(), Collections.unmodifiableList(tc),
                tc.size());
    }

    public static <T> Page<T> of(PageModel page, int total, List<T> tc) {
        return new Page<>(page, total,
                Collections.unmodifiableList(tc),
                (int) (Math.ceil(total / page.pageSize())));
    }
}
