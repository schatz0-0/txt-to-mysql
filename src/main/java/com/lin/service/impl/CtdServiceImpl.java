package com.lin.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import com.lin.domain.Ctd;
import com.lin.service.CtdService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CtdServiceImpl implements CtdService {
    @Override
    public List<Ctd> readCtdFile(String filePath){
        //创建reader对象并获取文件内容
        //既然已经引入hutool了这里就接着用了
        FileReader reader = new FileReader(filePath);
        String content = reader.readString();
        //将文件内容调整为CSV格式方便读取
        content = content.replace("\t", ",").replace("  ", ",");
        //读取数据
        CsvReader csvReader = CsvUtil.getReader();
        CsvData csvRows = csvReader.readFromStr(content);
        ArrayList<Ctd> ctdList = new ArrayList<>();
        for (CsvRow row : csvRows) {
            Ctd ctd = new Ctd();
            //这里属性和列码可能对不上
            ctd.setDateTime(LocalDateTimeUtil.parse(row.get(0),"yyyy-MM-dd/HH:mm:ss"));
            ctd.setId(Integer.valueOf(row.get(1)));
            ctd.setConductivity(Double.valueOf(row.get(3)));
            ctd.setSalinity(Double.valueOf(row.get(4)));
            ctd.setTemp(Double.valueOf(row.get(5)));
            ctd.setDepth(Double.valueOf(row.get(6)));
            ctd.setChlorophyll(Double.valueOf(row.get(7)));
            ctd.setTurbidity(Double.valueOf(row.get(8)));
            ctd.setPh(Double.valueOf(row.get(9)));
            ctd.setDissolvedOxygen(Double.valueOf(row.get(10)));
            ctd.setDissolvedOxygen(Double.valueOf(row.get(11)));
            ctdList.add(ctd);
        }
        //返回结果
        return ctdList;
    }
}
