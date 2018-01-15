package com.xjx.core.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RestResult implements Serializable{
	private static final long serialVersionUID = 1456012564784561234L;
	
	private Integer state;
	
	private String msg;
	
	private Map<String,Object> results;
	
	public RestResult(Integer state,String msg, Map<String,Object> results){
		this.state =state;
		this.msg =msg;
		this.results =results;
	}
	public RestResult(Integer state,String msg, String key ,Object value){
		this.state =state;
		this.msg =msg;
		 Map<String,Object> results = new HashMap<>();
		 results.put(key, value);
		this.results =results;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getResults() {
		return results;
	}
	public void setResults(Map<String, Object> results) {
		this.results = results;
	}
	
	
}
