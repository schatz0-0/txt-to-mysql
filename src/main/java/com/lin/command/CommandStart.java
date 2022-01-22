package com.lin.command;

import cn.hutool.db.ds.DSFactory;
import cn.hutool.setting.Setting;
import com.lin.db.DbTableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.sql.SQLException;

/**
 * Shell 命令执行
 */
@ShellComponent
public class CommandStart {

	@Autowired
	private com.lin.service.changeTxt changeTxt;

	/**
	 * shell 命令
	 * @param f 需要解析的文件目录 C:\\Users\\Administrator\\Desktop\\test
	 * @param ip 数据库IP 192.168.0.102
	 * @param d 数据库名 test
	 * @param u 数据库用户名 root
	 * @param p 数据库用户密码 123456
	 * @param t 数据库表名 sea
	 */
	@ShellMethod("连接数据库，格式：start file-path db-url username password")
	public void start(@ShellOption String f,
					  @ShellOption String ip,
					  @ShellOption String d,
					  @ShellOption String u,
					  @ShellOption String p,
					  @ShellOption String t) {
		toStart(f, ip, d, u, p, t);
	}

	/**
	 * 动态创建数据库链接、获取表信息
	 * @param filePath 需要解析的文件目录
	 * @param url 数据库链接
	 * @param username 数据库用户名
	 * @param password 数据库密码
	 * @param t 数据库表名
	 */
	private void toStart(String filePath, String ip, String dbName, String username, String password, String t) {
		// mysql 5.1 驱动需要，否则表字段名为乱码
		String url = "jdbc:mysql://" + ip + ":3306/" + dbName
				+ "?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false";
		Setting setting = new Setting();
		setting.put("url", url);
		setting.put("user", username);
		setting.put("pass", password);
		setting.put("showSql", "true");
		setting.put("formatSql", "false");
		setting.put("showParams", "true");
		setting.put("sqlLevel", "debug");
		// 动态 db 链接信息
		DSFactory.setCurrentDSFactory(DSFactory.create(setting));
		// 获取数据库表、字段信息
		try {
			DbTableInfo tableInfo = new DbTableInfo(DSFactory.get().getConnection(), dbName);
			tableInfo.buildTables();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		changeTxt.run(filePath, t);
	}

}
