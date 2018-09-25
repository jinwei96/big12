package com.oldboy.hbase;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.List;

public class TestScan {

    public void getData() throws Exception{
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);

        Table table = conn.getTable(TableName.valueOf("test:t1"));

        Get get = new Get(Bytes.toBytes("row1"));

        Result rs = table.get(get);

        List<Cell> cells = rs.listCells();

        for (Cell cell : cells) {
            String row = Bytes.toString(CellUtil.cloneRow(cell));
            String cf = Bytes.toString(CellUtil.cloneFamily(cell));
            String col = Bytes.toString(CellUtil.cloneQualifier(cell));
            String value = Bytes.toString(CellUtil.cloneValue(cell));

            System.out.println(row + "/" + cf + "/" + col + "/" + value);

        }
    }

}
