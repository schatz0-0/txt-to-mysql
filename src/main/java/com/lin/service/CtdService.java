package com.lin.service;

import com.lin.domain.Ctd;

import java.util.List;

public interface CtdService {
    /**
     * 读取Ctd文件
     * @param filePath 文件路径
     * @return CTD文件内容集合
     */
    List<Ctd> readCtdFile(String filePath);
}
