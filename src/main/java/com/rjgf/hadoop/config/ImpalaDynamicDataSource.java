package com.rjgf.hadoop.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.List;
import java.util.Random;


/**
 * 动态切换数据源
 * @author xula
 */
public class ImpalaDynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 数据源的列表
     */
    private List<String> databaseAlias;

    /**
     * 取得当前使用哪个数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        synchronized (this) {
            if (databaseAlias.size() == 0) {
                return databaseAlias.get(0);
            } else {
                Random random = new Random();
                int randomNum = random.nextInt(databaseAlias.size());
                return databaseAlias.get(randomNum);
            }
        }
    }

    public void setDatabaseAlias(List<String> databaseAlias) {
        this.databaseAlias = databaseAlias;
    }
}