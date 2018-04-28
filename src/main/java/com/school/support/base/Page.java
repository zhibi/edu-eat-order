package com.school.support.base;

public class Page {

	private Integer pageNum;
	
	private Integer pageSize;

	/**
	 * 分页条数量
	 */
	public static Integer NAV_SIZE = 5;
	
	public Page() {
		super();
	}

	public Page(Integer pageNum, Integer pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public Page(Integer pageSize){
		super();
		this.pageNum = 1;
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		if(pageNum==null){
			return 1;
		}else{
			return pageNum>0?pageNum : 1;
		}
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		if(pageSize==null){
			return 10;
		}else{
			return pageSize>0?pageSize : 10;
		}
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
