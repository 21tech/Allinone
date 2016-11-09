<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>css/jquery-confirm.css">
<link rel="stylesheet" href="<%=basePath%>css/jquery.toastmessage.css">
<link rel="stylesheet" href="<%=basePath%>css/swiper-3.3.1.min.css">
<link rel="stylesheet" href="<%=basePath%>css/loaders.css">
<link rel="stylesheet" href="<%=basePath%>css/pop.css">
<title>首页</title>
<style type="text/css">
body, .wrapper {
	margin: 0;
	width: 1280px;
	height: 1024px;
	overflow: hidden;
}

body {
	background-image: url(images/content_bg.jpg);
}

a {
	text-decoration: none;
}

ul li {
	float: left;
}

ul li {
	list-style: none;
	margin: 0px;
}

table {
	empty-cells: show;
	border-collapse: collapse;
	table-layout: fixed;
}

table {
	color: #FAFAD2;
}

th, td {
	background-repeat: repeat-x;
	height: 30px;
	table-layout: fixed;
	line-height: 30px;
}

ul li {
	margin-left: 60px;
	width: 200px;
	height: 150px;
	background-color: red;
	border: 1px solid red;
	cursor: pointer;
	-webkit-box-shadow: #000 0 0 30px;
	-webkit-border-radius: 10%;
	padding-top: 50px;
	text-align: center;
}

ul li:active {
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	position: relative;
	top: 1px;
	left: 1px;
	cursor: pointer;
}

.header {
	width: 100%;
	height: 200px;
	padding-top: 40px;
	box-shadow: 0 1px 0 rgba(0, 0, 0, .2) inset, 0 -1x 0
		rgba(255, 255, 255, .2) inset;
	padding-left: 100px;
	clear: both;
}

#zp {
	width: 110px;
	height: 110px;
	border-radius: 110px;
	line-height: 80px; /* remove line-height */
	box-shadow: 0px 0px 15px rgba(0, 0, 0, 1);
	border: 5px solid #FAFAD2;
	margin: 30px;
	float: left;
}

#zp img {
	width: 100%;
	height: 100%;
	border-radius: 50%; /* relative value */
}

#userinfo-panel {
	width: 900px;
	height: 180px;
	background-color: red;
	-webkit-box-shadow: #000 0 0 30px;
	text-align: center;
}

#userinfo-panel table {
	width: 73%;
	height: 100%;
	font-size: 22pt;
	font-family: "华文行楷";
	text-align: right;
	color: #FAFAD2;
	text-shadow: 1px 0 0 #8B4513, 0 1px 0 #8B4513, 0 -1px 0 #8B4513, -1px 0
		0 #8B4513, 2px 0 2px #8B4513, 0 2px 2px #8B4513, 0 -4px 4px #fff, -4px
		0 4px #fff;
}

#userinfo-panel table tr:nth-child(2) td {
	text-align: left;
	text-indent: 6px;
}

#logout {
	margin-top: -140px;
	margin-left: 920px;
	text-align: center;
	width: 110px;
	height: 110px;
	background-color: red;
	border-radius: 110px;
	line-height: 80px; /* remove line-height */
	box-shadow: 0px 0px 15px rgba(0, 0, 0, 1);
	border: 5px solid #FAFAD2;
	border-radius: 110px;
	font-size: 20pt;
	font-family: "黑体";
	color: #FAFAD2;
	cursor: pointer;
}

#logout p {
	margin-top: -50px;
	font-size: 15pt;
}

#logout:active {
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	position: relative;
	top: 1px;
	left: 1px;
	cursor: pointer;
}

.container {
	width: 100%;
	height: 700px;
	padding-top: 200px;
	clear: both;
}

.print-num {
	width: 50px;
	height: 50px;
	border-radius: 50%; /* relative value */
	border: 5px solid #FAFAD2;
	background-color: red;
	margin-top: -60px;
	margin-left: -25px;
	text-align: center;
	line-height: 50px;
	color: #FAFAD2;
	font-size: 22px;
}

span {
	font-weight: bold;
	color: #FAFAD2;
	font-size: 25px;
}

.print, .cancel {
	width: 100px;
	height: 100px;
	background-color: red;
	border-radius: 50%; /* relative value */
	border: 5px solid #FAFAD2;
	text-align: center;
	line-height: 100px;
	color: #FAFAD2;
	font-size: 22px;
	margin-top: 20px;
	margin-left: 350px;
	float: left;
	-webkit-box-shadow: #000 0 0 30px;
	cursor: pointer;
	float: left;
}

.print:active, .cancel:active {
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	position: relative;
	top: 1px;
	left: 1px;
	cursor: pointer;
	position: relative;
}
</style>

</head>

<body>
	<div class="wrapper">
		<div class="header">
			<div id="zp">
				<img />
			</div>
			<div id="userinfo-panel">
				<table>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div id="logout">
				退出
				<p></p>
			</div>
		</div>

		<div class="container">
			<ul>
				<li><div class="print-num"></div> <span>中文成绩单</span><br> <span>普通纸</span></li>
				<li><div class="print-num"></div> <span>英文成绩单</span><br> <span>普通纸</span></li>
				<li><div class="print-num"></div> <span>中文成绩单</span><br> <span>防伪纸</span></li>
				<li><div class="print-num"></div> <span>英文成绩单</span><br> <span>防伪纸</span></li>
			</ul>
		</div>
		<div class="cd-popup loaded">
			<div class="cd-popup-container loaders">
				<div class="loader">
					<h3>数据加载中</h3>
					<div class="loader-inner pacman">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
				</div>
			</div>
		</div>
		<div class="cd-popup1">
			<div class="cd-popup-container1">
				<div></div>
			</div>

			<a href="javascript:0;" class="print">打印</a> <a href="javascript:0;"
				class="cancel">取消</a>
		</div>
	</div>
</body>

<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-confirm.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.toastmessage.js"></script>
<script src='http://localhost:8000/CLodopfuncs.js'></script>
<script src="<%=basePath%>js/LodopFuncs.js"></script>
<script src="<%=basePath%>js/swiper-3.3.1.jquery.min.js"></script>
<script src="<%=basePath%>js/util.js"></script>
<script src="<%=basePath%>js/json2.js"></script>
<script>
	$(function() {
		app.getUserInfo();
	})
	var app = {

	print_config : {
			tray1remain : "<s:property value="result.PrintConfig.tray1remain" />",
			tray2remain : "<s:property value="result.PrintConfig.tray2remain" />"
		},
		print_item_switch : {
			ywcjpt : "<s:iterator status="st" value="result.PrintItems" id="list"><s:if test="item=='zwcjpt'"><s:property value="onoff" /></s:if></s:iterator>",
			ywcjpt : "<s:iterator status="st" value="result.PrintItems" id="list"><s:if test="item=='ywcjpt'"><s:property value="onoff" /></s:if></s:iterator>",
			zwcjfw : "<s:iterator status="st" value="result.PrintItems" id="list"><s:if test="item=='zwcjfw'"><s:property value="onoff" /></s:if></s:iterator>",
			ywcjfw : "<s:iterator status="st" value="result.PrintItems" id="list"><s:if test="item=='ywcjfw'"><s:property value="onoff" /></s:if></s:iterator>",
		},
		sys_param : {
			QRCode_validate_url : "<s:property value="result.SysParam[0].paramvalue" />",
			chargeback_A4 : <s:property value="result.SysParam[1].paramvalue" />,
			chargeback_great_A4 : <s:property value="result.SysParam[2].paramvalue" />
		},
		print_times : {
			zwcjpt : <s:iterator status="st" value="result.PrintTimes" id="list"><s:if test="item=='zwcjpt'"><s:property value="reNumber" /></s:if></s:iterator>,
			ywcjpt : <s:iterator status="st" value="result.PrintTimes" id="list"><s:if test="item=='ywcjpt'"><s:property value="reNumber" /></s:if></s:iterator>,
			zwcjfw : <s:iterator status="st" value="result.PrintTimes" id="list"><s:if test="item=='zwcjfw'"><s:property value="reNumber" /></s:if></s:iterator>,
			ywcjfw : <s:iterator status="st" value="result.PrintTimes" id="list"><s:if test="item=='ywcjfw'"><s:property value="reNumber" /></s:if></s:iterator>,
		},
		print_data : {
			type : 0,
			paper_type : 0,
			print_times : 0
		},
		getUserInfo : function() {
			$.ajax({
				url : "userinfo/get",
				timeout : 10000,
				dataType : "json",
				async : true,
				type : "post",
				beforeSend : function() {
					$('.cd-popup').addClass('is-visible');
				},
				success : function(response) {
					if (response.status == "200") {
						app.user_info = response;
						console.log(app.user_info);
						app.init();
					} else {
						$().toastmessage('showErrorToast', "查询数据出错");
						app.logout();
					}
				},
				complete : function(XMLHttpRequest, status) { // 请求完成后最终执行参数
					if (status == 'timeout' || status == 'error') { // 超时,status还有success,error等值的情况
						$().toastmessage('showErrorToast', "无法连接服务器，请稍后再试");
						app.logout();
					}
					$('.cd-popup').removeClass('is-visible');

				}
			});

		},
		init : function() {
			$("#zp img").attr("src",
					"data:image/jpg;base64," + app.user_info.XsZp);
			$("table td:eq(0)").html(app.user_info.XsXj.xm);
			$("table td:eq(1)").html(app.user_info.XsXj.xb);
			$("table td:eq(3)").html(app.user_info.XsXj.xsm);
			$("table td:eq(4)").html(app.user_info.XsXj.zym);
			$("table td:eq(5)").html(app.user_info.XsXj.bjh);

			$(".print-num:eq(0)").html(app.print_times.zwcjpt);
			$(".print-num:eq(1)").html(app.print_times.ywcjpt);
			$(".print-num:eq(2)").html(app.print_times.zwcjfw);
			$(".print-num:eq(3)").html(app.print_times.ywcjfw);

			setIntervalFunction = setInterval("coolDown.countDown()", 1000);

			$("body").on("click", function() {
				coolDown.time = 30;
			});

			$("#logout").on("click", function(event) {
				event.preventDefault();
				app.logout();
			});
			
			$("ul li:eq(0),ul li:eq(2)").on("click",function(event) {
						event.preventDefault();
						$('.cd-popup1').addClass('is-visible1');
						$('.cd-popup-container1').load("<%=basePath%>template/grade-chs.htm");
						app.print_data.print_times={"0":app.print_times.zwcjpt,"2":app.print_times.zwcjfw}[$(this).index()]||0;
						app.print_data.type=0;
						app.print_data.paper_type={"0":0,"2":1}[$(this).index()]||0;
					});
			$("ul li:eq(1),ul li:eq(3)").on("click",function(event) {
						event.preventDefault();
						$('.cd-popup1').addClass('is-visible1');
						$('.cd-popup-container1').load("<%=basePath%>template/grade-eng.htm");
						app.print_data.print_times = {
							"1" : app.print_times.ywcjpt,
							"3" : app.print_times.ywcjfw
						}[$(this).index()] || 0;
						app.print_data.type = 1;
						app.print_data.paper_type = {
							"1" : 0,
							"3" : 1
						}[$(this).index()] || 0;
					});
			$(".cancel").on("click", function(event) {
				event.preventDefault();
				$('.cd-popup1').removeClass('is-visible1');
				$('.cd-popup-container1').html("");

			})

			$(".print")
					.on(
							"click",
							function() {
								if (app.print_data.print_times < 1) {
									$
											.confirm({
												theme : 'black',
												title : '注意',
												position : {},
												confirmButton : '确定',
												cancelButton : '取消 ',
												content : "你的免费打印次数已用完,需要付费打印，每份<span style='color:red'>"
														+ ({
															"0" : app.sys_param.chargeback_A4,
															"1" : app.sys_param.chargeback_great_A4
														}[app.print_data.paper_type] || 0)
														+ "</span>元",
												confirm : function() {
													app
															.print(
																	app.print_data.type,
																	app.print_data.paper_type,
																	false);
												}
											});

								} else {
									$.confirm({
										theme : 'black',
										title : '注意',
										position : {},
										confirmButton : '确定',
										cancelButton : '取消 ',
										content : '你的免费打印次数还有：'
												+ app.print_data.print_times
												+ "次",
										confirm : function() {
											app.print(app.print_data.type,
													app.print_data.paper_type,
													true);
										}
									});
								}
							});
		},

		print : function(type, paper_type, isfree) {
			if (!isfree) {
				var nMoney = {
					"0" : app.sys_param.chargeback_A4,
					"1" : app.sys_param.chargeback_great_A4
				}[paper_type] || 0;
				var operate_time = curDateTime();
				var data = {
					"nMoney" : nMoney * 100,
					"Tn" : "0",
					"operate_time" : operate_time
				};
				window.cefQuery({
					request : 'Request:DCM=' + JSON.stringify(data),
					onSuccess : function(response) {
						if (response == "-1") {
							$().toastmessage('showErrorToast', "扣费失败");
							return false;
						}
						$
						.ajax({
							url : "login/validate",
							timeout : 10000,
							dataType : "json",
							async : true,
							data :response,
							type : "post",
							success : function(response) {
							},
							complete : function(XMLHttpRequest, status) { // 请求完成后最终执行参数
								if (status == 'timeout') { // 超时,status还有success,error等值的情况
									$().toastmessage('showErrorToast',
											"无法连接服务器，请稍后再试");

								}
							}
						});
					},
					onFailure : function(error_code, error_message) {
						$().toastmessage('showErrorToast', "扣费失败");
						return false;

					}
				});

			}

			var LODOP = getLodop();
			LODOP.PRINT_INIT("成绩打印");
			LODOP.SET_PRINT_MODE("PRINT_DUPLEX", 2);
			LODOP.SET_PRINT_MODE("PRINT_DEFAULTSOURCE", 1);
			//p打印纸张类型，0-普通纸，1-防伪纸
			if (!paper_type) {
				LODOP.SET_PRINT_PAGESIZE(1, 2100, 2965, "");
			} else {
				LODOP.SET_PRINT_PAGESIZE(1, 0, 0, "A4");
			}
			//t打印类型，0-中文成绩，1-英文成绩
			if (!type) {
				app.create_and_print_zw(LODOP);
			} else {
				app.create_and_print_yw(LODOP);
			}
		},
		create_and_print_zw : function(l) {
			var LODOP = l;
			var _table = "<table style='margin: 0 auto; width: 100%; empty-cells: show; border-collapse: collapse; table-layout: fixed; border: 3px solid #000; color: #000;'>";
			_table += $(".grade-chs table:eq(0)").html();
			_table += "</table>";
			console.log(_table);
			LODOP.ADD_PRINT_HTM(106, "2%", "96%", "20%", _table);
			_table = "<table style='margin: 0 auto; width: 100%; empty-cells: show; border-collapse: collapse; table-layout: fixed; border: 3px solid #000;border-top:0 ; color: #000;'>";
			var _thead = "<thead>";
			_thead += $(".grade-chs table:eq(1) thead").html();
			_thead += "</thead>";
			_table += _thead;
			_table += "<tbody>";
			_table += $(".grade-chs table:eq(1) tbody").html();
			_table += "</tbody></table>";
			LODOP.ADD_PRINT_TABLE(243, "2%", "96%", "68%", _table);
			LODOP.SET_PRINT_STYLEA(0, "Offset2Top", -150);
			LODOP.PREVIEW();
		},
		create_and_print_yw : function(l) {
			alert("111");
		},
		logout : function() {
			post("logout",0);
		}
	}, coolDown = {
		"time" : 30,
		countDown : function(s) {
			if (coolDown.time > 0) {
				coolDown.time--;
				$("#logout p").html("[" + coolDown.time + "]");
			} else {
				coolDown.time = 30;
				setTimeout("coolDown.exit()", 1000);
			}
		},
		exit : function() {
			//app.logout();
		}
	}

	var basePath = "";
</script>
</html>