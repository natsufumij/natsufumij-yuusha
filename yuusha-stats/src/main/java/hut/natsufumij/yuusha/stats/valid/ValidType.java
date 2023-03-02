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
package hut.natsufumij.yuusha.stats.valid;

/**
 * 验证类型
 * @author Administrator
 */
public enum ValidType {
    NOT_NULL,
    STR_LENGTH,
    NUMBER_MIN,
    NUMBER_MAX,
    NUMBER_RANGE,
    NUMBER_LENGTH,
    NUMBER_NOT_RANGE,
    ARRAY_ITEM
}
