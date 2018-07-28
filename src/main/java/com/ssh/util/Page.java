package com.ssh.util;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

	private int curPage=1;
	private int count;
	private int limit=10;
	private int countPage;
	private List<T> data;
	private boolean success=true;
	private String message="操作成功";
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		int num=count/limit;
		this.countPage=count%limit==0 ? num:num+1;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void fail(String message) {
		this.success=false;
		this.message=message;
	}
	@Override
	public String toString() {
		return "Page [curPage=" + curPage + ", count=" + count + ", limit=" + limit + ", countPage=" + countPage
				+ ", data=" + data + ", success=" + success + ", message=" + message + "]";
	}
	
	
	
}
