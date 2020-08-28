package com.rjgf.hadoop.mapper.kylin;

import com.rjgf.hadoop.config.HadoopMapper;

import java.util.List;
import java.util.Map;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/5
 * @time: 17:04
 */
@HadoopMapper
public interface KylinTestMapper {


    /**
     * 获取数据
     * @return
     */
    List<Map<String,Object>> getMapList();
}
