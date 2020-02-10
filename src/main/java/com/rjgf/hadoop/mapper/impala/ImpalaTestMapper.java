package com.rjgf.hadoop.mapper.impala;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/5
 * @time: 17:04
 */
@Mapper
public interface ImpalaTestMapper {


    /**
     * 获取数据
     * @return
     */
    List<Map<String,Object>> getMapList();
}
