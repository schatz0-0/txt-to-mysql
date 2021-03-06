package com.lin.service;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
@PropertySource("classpath:application.yml")
public class changeTxt {
    protected static final Logger logger = LoggerFactory.getLogger(changeTxt.class);

    @Value("${dbshu.title}")
    private String dbTitle;
    @Value("${dbshu.name}")
    private String dbName;
    @Value("${dbshu.root}")
    private String dbRoot;


    private static List<String> list = new ArrayList();
    public void readFile(String filePath){
        // TODO 加载当前项目以.txt结尾的文件 "D:\\项目\\txt-to-mysql\\src\\main\\resources\\1.txt"
        File root = new File(filePath);
        File[] files = root.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            if (fileName.indexOf(".txt") == -1) continue;
            FileReader fileReader = new FileReader(filePath + "/" + fileName);
            String result = fileReader.readString();
            //读取每一行的文件
            String strLines[] = result.split("\n");
            //分割成块，存入数据库
            for (int i = 0; i < strLines.length; i++)
            {
                String strLine[] = strLines[i].split("\t");
                toMysql(strLine);
            }
        }
    }

//   把数据添加到数据库中
    public void toMysql(String strLine[]){
        try {
            Long uid = -1L;
            for (int i = 0; i < list.size(); i++){
                String line = list.get(i);

//                第一个字段add
                if (i == 0){
                    uid = Db.use().insertForGeneratedKey(
                            Entity.create(dbTitle)
                                    .set(line, String.valueOf(strLine[i]))
                    );
                }else {
//                    否则update
                    Db.use().update(
                            Entity.create().set(line, String.valueOf(strLine[i])), //修改的数据
                            Entity.create(dbTitle).set("id", uid) //where条件
                    );
                }
                System.out.println("uid = " + uid + "; line.getName() = " + line + "; strLine[i] = " + strLine[i]);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        String read1[] = dbName.trim().split(" +");
        for (int i = 0; i < read1.length; i++){
            list.add(read1[i]);
        }
        readFile(dbRoot);
    }

}
