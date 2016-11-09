package com.aio.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


@ParentPackage(value = "aio-default")
@Namespace("/")
public class LogoutAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4345939709480827283L;

	@Action(value = "logout",results = { @Result(name = "success", location = "../../welcome.html") }) 
	public String execute() {
		return SUCCESS;
	}
	
}
