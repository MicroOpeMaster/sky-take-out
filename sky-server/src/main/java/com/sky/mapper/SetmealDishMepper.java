package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMepper {
    List<Long> getSetmelIdsByDishIds(List<Long> ids);
}
