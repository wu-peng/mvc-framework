package com.mvc.entity;

import java.util.HashMap;
import java.util.Map;

public class MvcBean {
	
	private String entityName;
	private String entityClass;
	private String actionClass;
	private String actionPath;
	private Map<String, String> forward=new HashMap<String, String>();
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getEntityClass() {
		return entityClass;
	}
	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}
	public String getActionClass() {
		return actionClass;
	}
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}
	public String getActionPath() {
		return actionPath;
	}
	public void setActionPath(String actionPath) {
		this.actionPath = actionPath;
	}
	public Map<String, String> getForward() {
		return forward;
	}
	public void setForward(Map<String, String> forward) {
		this.forward = forward;
	}
	
	@Override
	public String toString() {
		return "entityName="+this.entityName+"||entityClass="+this.entityClass+"||actionClass="+this.actionClass+"||actionPath="+this.actionPath+"||forward="+this.forward;
	}

}
