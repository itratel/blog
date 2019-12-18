package com.itratel.util;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author yinhao
 * @date 2019/12/19 01:04
 * @apiNote Describe the function of this class in one sentence
 */
public final class OptionalUtil {

    /***
     * 处理集合数据
     * @param list list
     * @param <T> 泛型
     * @return List<T>
     */
    public static <T> List<T> listOption(List<T> list) {
        return Optional.ofNullable(list).orElse(Collections.emptyList());
    }
}
