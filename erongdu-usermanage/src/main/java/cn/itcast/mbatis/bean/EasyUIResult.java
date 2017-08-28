package cn.itcast.mbatis.bean;

import java.util.List;

/**
 * A Java bean to interact json data with page which is show data with table
 * that has rows and concrete data
 * 
 * @author yuangh
 *
 * @company erongdu
 *
 * @data 2017年8月28日
 */
public class EasyUIResult {

	/**
	 * The rows to data
	 */
	private Long total;

	/**
	 * The concrete data
	 */
	private List<?> rows;

	public EasyUIResult(Long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public EasyUIResult() {
		super();
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
