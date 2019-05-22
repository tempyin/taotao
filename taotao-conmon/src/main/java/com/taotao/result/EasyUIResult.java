package com.taotao.result;

import java.io.Serializable;
import java.util.List;

/**
 * easyUIDataGrid对象返回值
 * Serializable 是一个标记接口
 * java对象在网络上传输必须实现Serializable接口
 */
public class EasyUIResult implements Serializable {
	// 页面需要传送 总记录条数 和当前页数
	private Integer total;
	//  ?代表任意类
	private List<?> rows;
	
	public EasyUIResult(Integer total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}
	
	public EasyUIResult(long total, List<?> rows) {
		this.total = (int) total;
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
