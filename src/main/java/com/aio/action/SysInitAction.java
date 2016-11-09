package com.aio.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.aio.bean.PrintConfig;
import com.aio.bean.PrintItems;
import com.aio.bean.PrintTimes;
import com.aio.bean.PrintTimesView;
import com.aio.bean.SysParam;
import com.aio.common.Constant;
import com.aio.exception.DBException;
import com.aio.service.PrintConfigService;
import com.aio.service.PrintItemsService;
import com.aio.service.PrintTimesService;
import com.aio.service.PrintTimesViewService;
import com.aio.service.SysParamService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "aio-default")
@Namespace("/")
public class SysInitAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8249384666635588672L;

	private static final Logger logger = Logger.getLogger(SysInitAction.class.getName());

	@Autowired
	private PrintConfigService printConfigService;

	@Autowired
	private PrintTimesViewService printTimesViewService;

	@Autowired
	private PrintTimesService printTimesService;

	@Autowired
	private SysParamService sysParamService;

	@Autowired
	private PrintItemsService printItemsService;

	private String xh;

	private String sysId;

	private Map<String, Object> result;

	private Map<String, Object> session;

	@Action(value = "init", results = { @Result(name = "success", location = "/WEB-INF/content/content.jsp") })
	public String execute() {
		result = new HashMap<String, Object>();
		xh = (String) session.get("userName");
		sysId = (String) session.get("sysId");
		try {

			// 纸盒1和纸盒2剩余纸张
			PrintConfig pc = printConfigService.getById(sysId);
			result.put("PrintConfig", pc);

			// 读取学生剩余免费打印次数，如果没有数据，则为第一次使用，插入已打印次数0
			List<PrintTimesView> ptv = printTimesViewService.getAllByXh(xh);
			if (ptv == null || ptv.isEmpty()) {
				PrintTimes[] tmp = { new PrintTimes(), new PrintTimes(), new PrintTimes(), new PrintTimes() };
				tmp[0].setItem("zwcjpt");
				tmp[0].setNumberOfPrint(0);
				tmp[0].setXh(xh);

				tmp[1].setItem("ywcjpt");
				tmp[1].setNumberOfPrint(0);
				tmp[1].setXh(xh);

				tmp[2].setItem("zwcjfw");
				tmp[2].setNumberOfPrint(0);
				tmp[2].setXh(xh);

				tmp[3].setItem("ywcjfw");
				tmp[3].setNumberOfPrint(0);
				tmp[3].setXh(xh);
				for (int i = 0; i < 4; i++) {
					printTimesService.save(tmp[i]);
				}
			}
			ptv = printTimesViewService.getAllByXh(xh);
			result.put("PrintTimes", ptv);

			// 获取二维码验证地址，打印金额等数据
			List<SysParam> sp = sysParamService.getAll();
			result.put("SysParam", sp);

			// 获取打印项目信息
			List<PrintItems> pi = printItemsService.getAll();
			result.put("PrintItems", pi);
			return SUCCESS;

		} catch (DBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constant.CONNECT_ERROR;
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
