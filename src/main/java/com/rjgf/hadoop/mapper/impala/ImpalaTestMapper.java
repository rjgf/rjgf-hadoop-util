package com.rjgf.hadoop.mapper.impala;

import com.rjgf.hadoop.config.HadoopMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/5
 * @time: 17:04
 */
@HadoopMapper
public interface ImpalaTestMapper {


    /**
     * 获取数据
     * @return
     */
    List<Map<String,Object>> getMapList();
}
