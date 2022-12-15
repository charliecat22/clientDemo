/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月2日/上午11:26:15
 * 项目名称：  dfas-common-util
 * 文件名称: WinApplicationContextAware.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2019-2030
 *
 ********************************************************/

package com.example.client.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 包名称： com.win.dfas.common.util
 * 类名称：WinApplicationContextAware
 * 类描述：TODO
 * 创建人：@author hechengcheng
 * 创建时间：2019年7月2日/上午11:26:15
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;

	/**
	 * 获取上下文
	 *
	 * @return
	 * @author: jianshengxiong
	 * @Date: 2020年12月23日/上午11:44:32
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * 根据名称和类型获取Bean
	 *
	 * @param name
	 * @param clazz
	 * @return
	 * @throws
	 * @Title: getBean
	 * @return: T
	 * @author: hechengcheng
	 * @Date: 2019年7月2日/上午11:44:32
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return applicationContext.getBean(name, clazz);
	}

	/**
	 * 根据类型获取Bean
	 *
	 * @param clazz
	 * @return
	 * @throws
	 * @Title: getBean
	 * @return: T
	 * @author: hechengcheng
	 * @Date: 2019年7月10日/下午6:03:10
	 */
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}

	/**
	 * 根据名称获取Bean
	 *
	 * @param name
	 * @return
	 * @throws
	 * @Title: getBean
	 * @return: Object
	 * @author: hechengcheng
	 * @Date: 2019年8月3日/上午11:39:04
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	/**
	 * 获取容器中指定某类型、或实现某接口、或继承某父类所有的 Bean
	 *
	 * @param type 某类型/父类/接口
	 * @return
	 * @throws
	 * @Title: getBeansOfType
	 * @return: Map<String, T>
	 * @author: jinxiaolong
	 * @Date: 2019年9月29日/上午09:26:00
	 */
	public static <T> Map<String, T> getBeansOfType(Class<T> type) {
		return applicationContext.getBeansOfType(type);
	}

	/**
	 * 获取当前环境
	 *
	 * @return
	 * @throws
	 * @Title: getActiveProfile
	 * @return: String
	 * @author: hechengcheng
	 * @Date: 2019年7月2日/上午11:42:51
	 */
	public static String getActiveProfile() {
		return applicationContext.getEnvironment().getActiveProfiles()[0];
	}

	/**
	 * @return
	 * @throws
	 * @Title: getApplicatioName
	 * @Description: 获取应用名称
	 * @return: String
	 * @author: hechengcheng
	 * @Date: 2020年3月2日/下午2:17:06
	 */
	public static String getApplicatioName() {
		return applicationContext.getEnvironment().getProperty("spring.application.name");
	}

	/**
	 * @return
	 * @throws
	 * @Title: getDatasourceUrl
	 * @Description: 获取数据库连接URL
	 * @return: String
	 * @author: hechengcheng
	 * @Date: 2020年5月25日/下午12:02:26
	 */
	public static String getDatasourceUrl() {
		return applicationContext.getEnvironment().getProperty("spring.datasource.url");
	}

	/**
	 * @throws
	 * @Title: getPropertyValue
	 * @Description: 获取配置属性值
	 * @return: java.lang.String
	 * @author: dengyong
	 * @Date: 2020/9/7/14:49
	 */
	public static String getPropertyValue(String property) {
		return getPropertyValue(property, null);
	}

	/**
	 * @throws
	 * @Title: getPropertyValue
	 * @Description: 带默认值的获取配置属性值
	 * @return: java.lang.String
	 * @author: dengyong
	 * @Date: 2020/9/8/9:11
	 */
	public static String getPropertyValue(String property, String defaultValue) {
		return applicationContext.getEnvironment().getProperty(property, defaultValue);
	}

	/**
	 * @param property     指定属性
	 * @param clazz        值类型
	 * @param defaultValue 默认值
	 * @return
	 * @throws
	 * @Title: getPropertyValue
	 * @Description: 获取指定的数据类型
	 * @return: T
	 * @author: hechengcheng
	 * @Date: 2021年1月12日/上午10:01:11
	 */
	public static <T> T getPropertyValue(String property, Class<T> clazz, T defaultValue) {
		return applicationContext.getEnvironment().getProperty(property, clazz, defaultValue);
	}
}
