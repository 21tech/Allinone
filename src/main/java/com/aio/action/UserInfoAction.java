package com.aio.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.aio.bean.XsCjAllTdkchView;
import com.aio.bean.XsXjbView;
import com.aio.bean.XsZpView;
import com.aio.common.Constant;
import com.aio.common.Decrypt;
import com.aio.exception.DBException;
import com.aio.exception.NullUserGradeException;
import com.aio.exception.NullUserInfoException;
import com.aio.service.QueryGradeService;
import com.aio.service.QueryUserInfoService;
import com.aio.service.QueryUserPhotoService;
import com.opensymphony.xwork2.ActionSupport;

import sun.misc.BASE64Encoder;

@ParentPackage(value = "json-default")
@Namespace("/userinfo")
public class UserInfoAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2102777876869008236L;

	private static final Logger logger = Logger.getLogger(SysInitAction.class.getName());

	@Autowired
	private QueryUserInfoService queryUserInfoService;

	@Autowired
	private QueryUserPhotoService queryUserPhotoService;

	@Autowired
	private QueryGradeService queryGradeService;

	private String username;
	
	private String a;

	private Map<String, Object> result;

	private Map<String, Object> session;

	// select
	@Action(value = "get", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "500", type = "json"), })
	public String get() {
		result = new HashMap<String, Object>();
		username = (String) session.get("userName");
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			logger.info("--读取学生学籍信息开始--");
			XsXjbView xsXjbView = queryUserInfoService.getUserInfoByXh(username);
			logger.info("--读取学生学籍信息正常结束,向result存放学籍信息--");
			result.put("XsXj", xsXjbView);

			logger.info("--读取学生照片信息开始");
			XsZpView xsZpView = queryUserPhotoService.getUserPhotoByXh(username);
			if (xsZpView == null) {
				logger.warn("--读取学生照片信息结束，但学生照片数据为空,向session填空--");
				result.put("XsZp", "");
			} else {
				logger.info("--读取学生照片信息结束，向session存放照片信息");
				result.put("XsZp", encoder.encode(xsZpView.getZp()));
			}

			logger.info("--读取学生成绩开始--");
			List<XsCjAllTdkchView> list = queryGradeService.getCurrentGradeByXh(username);
			result.put("cet4", "");
			Iterator<XsCjAllTdkchView> tmp = list.iterator();
			while (tmp.hasNext()) {
				XsCjAllTdkchView xsCjAllTdkchView = tmp.next();
				if (xsCjAllTdkchView.getKch().equals("3112130")) {
					logger.info("--读取学生四级成绩，向session存放四级成绩信息");
					result.put("cet4", xsCjAllTdkchView.getKccj());
					tmp.remove();
				}
			}
			logger.info("--读取学生成绩结束，向session存放成绩信息--");
			result.put("XsCj", list);

			// 生成二维码加密信息
			Map<String, String> QRCode = new HashMap<String, String>();
			QRCode.put("QRCodeZW", URLEncoder.encode(Decrypt.encrypt("AiOActVer", username + "-aio-0"), "UTF-8"));
			QRCode.put("QRCodeYW", URLEncoder.encode(Decrypt.encrypt("AiOActVer", username + "-aio-1"), "UTF-8"));
			result.put("QRCode", QRCode);

			logger.info("所有信息读取完毕，向session存入状态码:success");
			result.put("status", "200");

		} catch (NullUserGradeException | NullUserInfoException | DBException | UnsupportedEncodingException e) {
			e.printStackTrace();
			result.put("status", Constant.CONNECT_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", Constant.CONNECT_ERROR);
		}
		return SUCCESS;
	}

	// update
	@Action(value = "put", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "500", type = "json"), })
	public String put() {
        
		
		
		return null;
	}

	// delete
	@Action(value = "delete", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "500", type = "json"), })
	public String delete() {

		return null;
	}

	// insert
	@Action(value = "post", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "500", type = "json"), })
	public String post() {

		return null;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
