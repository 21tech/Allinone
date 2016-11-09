package com.aio.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.aio.common.Constant;
import com.aio.exception.DBException;
import com.aio.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "json-default")
@Namespace("/login")
public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7520061467143978294L;

	private String userName;

	private String passWord;

	private String result;

	private Map<String, Object> session;

	@Autowired
	private LoginService loginService;

	@Action(value = "validate", results = { @Result(name = "success", type = "json", params = { "root", "result" }) })
	public String checkUser() {
		try {
			result = loginService.ifCorrectUser(userName, passWord);
			if (result.equals("200")) {
				session.put("userName", userName);
			}
		} catch (DBException e) {
			result = Constant.CONNECT_ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			result = Constant.CONNECT_ERROR;
		}
		return SUCCESS;

	}
     
 
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}