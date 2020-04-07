package com.venilry.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//@SuppressWarnings("serial")
//@AllArgsConstructor // 全参构造器
//@NoArgsConstructor // 无参构造器
//@Data
//@Accessors(chain = true)
public class Dept implements Serializable {
	// 主键
	private Long deptno;
	// 部门名称
	private String dname;
	// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	private String db_source;

	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDb_source() {
		return db_source;
	}

	public void setDb_source(String db_source) {
		this.db_source = db_source;
	}

}
