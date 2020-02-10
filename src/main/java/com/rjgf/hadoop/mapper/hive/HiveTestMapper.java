package com.rjgf.hadoop.mapper.hive;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/5
 * @time: 15:46
 */
@Mapper
public interface HiveTestMapper {


    /***
     * 获取hive的数据列表
     * @return
     */
    List<Map<String,Object>> getMapList();
}
