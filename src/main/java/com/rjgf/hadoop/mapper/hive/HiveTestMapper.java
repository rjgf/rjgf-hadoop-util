package com.rjgf.hadoop.mapper.hive;

import com.rjgf.hadoop.config.HadoopMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @email: xuliandream@gmail.com
 * @author: xula
 * @date: 2020/2/5
 * @time: 15:46
 */
@HadoopMapper
public interface HiveTestMapper {


    /***
     * 获取hive的数据列表
     * @return
     */
//    @Select("SELECT * FROM `act_defbr_ctxt` limit 5")
    List<Map<String,Object>> getMapList();
}
