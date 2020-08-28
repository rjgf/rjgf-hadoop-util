package com.rjgf.hadoop;

import java.sql.*;

public class HiveTest {
    private static final String DRIVER_NAME = "com.cloudera.impala.jdbc41.Driver";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String url = "jdbc:impala://192.168.110.222:21050/abd"; // NOSASL模式需要添加noSasl
        String user = "rjtx";

        Connection con = DriverManager.getConnection(url, user, "");
        Statement stmt = con.createStatement();

        String sql = "SELECT count(*) FROM base_data_initial WHERE collect_date='202006'";
        System.out.println("Running: " + sql);
        ResultSet res = stmt.executeQuery(sql);
        System.out.println("++++++++++++++++++++ Result ++++++++++++++++++++");
        while (res.next()) {
            System.out.println(res.getString(1));
        }
        stmt.close();
        con.close();
    }
}