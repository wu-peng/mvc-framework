package com.mvc.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mvc.entity.MvcBean;

/**
 * XML解析
 * @author Administrator
 *
 */
public class XmlParse {
	
	public static Map<String, MvcBean> xmlParse(String path){
		SAXReader saxReader = new SAXReader();
		Map<String, MvcBean> map = new HashMap<String, MvcBean>();
		try {
			Document document = saxReader.read(new File(path));
			Element root = document.getRootElement();
			
			Iterator<?> itAction = root.elementIterator("action");
			while(itAction.hasNext()){
				MvcBean mvcBean = new MvcBean();
				Element actionEle = (Element)itAction.next();
				String entityName = actionEle.attributeValue("entityName");
				String actionClass = actionEle.attributeValue("class");
				String actionPath = actionEle.attributeValue("path");
				mvcBean.setEntityName(entityName);
				mvcBean.setActionClass(actionClass);
				mvcBean.setActionPath(actionPath);
				
				Map<String, String> forwardMap = new HashMap<String, String>();
				Iterator<?> itForward = actionEle.elementIterator("forward");
				while(itForward.hasNext()){
					Element forwardEle = (Element) itForward.next();
					forwardMap.put(forwardEle.attributeValue("name"), forwardEle.attributeValue("value"));
				}
				mvcBean.setForward(forwardMap);
				
				Iterator<?> itEntitys = root.elementIterator("entitys");
				while(itEntitys.hasNext()){
					Element entitysEle = (Element)itEntitys.next();
					Iterator<?> itEntity =  entitysEle.elementIterator("entity");
					while(itEntity.hasNext()){
						Element entityEle = (Element)itEntity.next();
						if (entityEle.attributeValue("name").equals(entityName)) {
							String entityClass = entityEle.attributeValue("class");
							mvcBean.setEntityClass(entityClass);
						}
					}
				}
				
				map.put(actionPath, mvcBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void main(String[] args) {
		//String path=this.getClass().getResource("/").getPath();
		String path="/E:/Workspaces_Blue/mvc/WebRoot/WEB-INF/classes/mvc-config.xml";
		new XmlParse();
		Map<String, MvcBean> map = XmlParse.xmlParse(path);
		
		Set<String> set = map.keySet();
		for (String key : set) {
			System.out.println((MvcBean)map.get(key));
		}
	}

}
