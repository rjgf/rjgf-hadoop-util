package com.rjgf.hadoop;

import cn.hutool.json.JSONUtil;
import com.rjgf.hadoop.mapper.hive.HiveTestMapper;
import com.rjgf.hadoop.mapper.impala.ImpalaTestMapper;
import com.rjgf.hadoop.mapper.kylin.KylinTestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class RjgfHadoopApplicationTests {

    @Autowired
    private HiveTestMapper hiveTestDemo;

    @Autowired
    private ImpalaTestMapper impalaTestMapper;

    @Autowired
    private KylinTestMapper kylinTestMapper;

    @Test
    public void test() {

//        log.info("========================================================hive");
//        List<Map<String, Object>> hiveTestDemoMapList = hiveTestDemo.getMapList();
//        Iterator<Map<String, Object>> hiveIterator = hiveTestDemoMapList.iterator();
//        while (hiveIterator.hasNext()) {
//            Map<String, Object> row = hiveIterator.next();
//            System.out.println(JSONUtil.toJsonStr(row));
//        }
//
        log.info("========================================================impala");

//        List<Map<String, Object>> impalaTestMapperMapList = impalaTestMapper.getMapList();
//        Iterator<Map<String, Object>> impalaIterator = impalaTestMapperMapList.iterator();
//        while (impalaIterator.hasNext()) {
//            Map<String, Object> row = impalaIterator.next();
//            System.out.println(JSONUtil.toJsonStr(row));
//        }

        log.info("========================================================kylin");

        List<Map<String, Object>> kylinTestMapperMapList = kylinTestMapper.getMapList();
        Iterator<Map<String, Object>> kylinIterator = kylinTestMapperMapList.iterator();
        while (kylinIterator.hasNext()) {
            Map<String, Object> row = kylinIterator.next();
            System.out.println(JSONUtil.toJsonStr(row));
        }
    }

//    public static void main(String[] args) throws SQLException {
//        String driverName = "org.apache.hive.jdbc.HiveDriver";
//        try {
//            Class.forName(driverName);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Connection con = DriverManager.getConnection("jdbc:hive2://192.168.110.221:10000/adp", "hdfs", "");
//        Statement stmt = con.createStatement();
//        String sql = "select * from b_lte_alarm";
//        ResultSet resultSet = stmt.executeQuery(sql);
//        System.out.println(resultSet);
//    }
}
