package com.rjgf.hadoop;

import org.apache.kylin.jdbc.IRemoteClient;
import org.apache.kylin.jdbc.KylinConnection;
import org.apache.kylin.jdbc.shaded.org.apache.calcite.avatica.AvaticaConnection;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class KylinTest {

    private static final String DRIVER_NAME = "org.apache.kylin.jdbc.Driver";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {

        Driver driver = (Driver) Class.forName("org.apache.kylin.jdbc.Driver").newInstance();

        String url = "jdbc:kylin://192.168.110.224:7070/abd_project";
        String user = "ADMIN";
        String pwd = "KYLIN";
        Properties info = new Properties();
        info.put("user", user);
        info.put("password", pwd);
        Connection con = driver.connect(url,info);
//        KylinConnection con = (KylinConnection) driver.connect(url, info);
//        IRemoteClient iRemoteClient = con.getRemoteClient();
        String sql = "select grid_code,grid_mid_ltt,grid_mid_lgt,count(DISTINCT cell_id) AS cell_num,count(DISTINCT imsi) AS user_num,sum(rsrp)/count(rsrp) AS avg_rsrp from gis_village_grid GROUP BY grid_code,grid_mid_ltt,grid_mid_lgt limit 100";
//        System.out.println("Running: " + sql);
//        List<Object> paramValues = null;
//        Map<String, String> queryToggles = new HashMap<>();
//        queryToggles.put("DEBUG_TOGGLE_HIT_CUBE", "abd_cube");
//        IRemoteClient.QueryResult res = iRemoteClient.executeQuery(sql, null, queryToggles);
//        res.columnMeta.forEach(s -> s.toString());
        Statement statement = con.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            System.out.println(res.getString(1) + "===" + res.getString(2));
        }
        statement.close();
        con.close();
    }
}