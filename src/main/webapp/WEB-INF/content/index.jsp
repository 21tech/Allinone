<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>css/jquery-confirm.css">
<link rel="stylesheet" href="<%=basePath%>css/index.css">
<link rel="stylesheet" href="<%=basePath%>css/jquery.toastmessage.css">
</head>
<body oncontextmenu='return false' ondragstart='return false'
	onselectstart='return false' onselect='document.selection.empty()'
	oncopy='document.selection.empty()' onbeforecopy='return false'>

	<div class="container">
		<!-- 空闲教室 -->
		<div class="button">
			<a action-type="kxjs" href="javascript:void(0);"><img
				src="<%=basePath%>images/kxjs.png" /></a>
		</div>
		<!-- 打印成绩 -->
		<div class="button">
			<a action-type="dycj" href="javascript:void(0);"
				onClick="panel.show()"><img src="<%=basePath%>images/dycj.png" /></a>
		</div>
		<!-- 规章制度 -->
		<div class="button">
			<a action-type="gzzd" href="javascript:void(0);"><img
				src="<%=basePath%>images/gzzd.png" /></a>
		</div>
		<!-- 校历 -->
		<div class="button">
			<a action-type="xl" href="javascript:void(0);"><img
				src="<%=basePath%>images/xl.png" /></a>
		</div>
		<!-- 公告 -->
		<div class="button">
			<a action-type="gg" href="javascript:void(0);"><img
				src="<%=basePath%>images/gg.png" /></a>
		</div>
	</div>

	<!--登陆面板-->
	<div class="b-panel">
		<!-- 遮罩层 -->
		<div class="full-screen-mask"></div>
		<!-- 主面板 -->
		<div class="m-panel">
			<!-- 右上角关闭按钮 -->
			<div class="right-top-close-button">
				<ul>
					<li><img src="<%=basePath%>images/logo.png"/ ></li>
					<li><h3>&nbsp;&nbsp;登录成绩打印系统</h3></li>
				</ul>
			</div>
			<br />
			<form action="init" method="POST">
				<!--账号、密码-->
				<div class="i-panel">
					<div id="i_uName" class="text-span input-group input-group-lg">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-user"></span></span> <input type="text"
							class="form-control" placeholder="刷一卡通或手动输入学号"> <br>
					</div>
					<div id="i_pWord" class="text-span input-group input-group-lg ">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-lock"></span></span> <input type="password"
							class="form-control" placeholder="密码">
					</div>
				</div>
			</form>
			<br />
			<!--虚拟键盘-->
			<div id="keybord_area">
				<ul id="keybord_panel">
					<li class="symbol"><span class="off">`</span><span
						class="on">~</span></li>
					<li class="symbol"><span class="off">1</span><span class="on">!</span></li>
					<li class="symbol"><span class="off">2</span><span class="on">@</span></li>
					<li class="symbol"><span class="off">3</span><span class="on">#</span></li>
					<li class="symbol"><span class="off">4</span><span class="on">$</span></li>
					<li class="symbol"><span class="off">5</span><span class="on">%</span></li>
					<li class="symbol"><span class="off">6</span><span class="on">^</span></li>
					<li class="symbol"><span class="off">7</span><span class="on">&</span></li>
					<li class="symbol"><span class="off">8</span><span class="on">*</span></li>
					<li class="symbol"><span class="off">9</span><span class="on">(</span></li>
					<li class="symbol"><span class="off">0</span><span class="on">)</span></li>
					<li class="symbol"><span class="off">-</span><span class="on">_</span></li>
					<li class="symbol"><span class="off">=</span><span class="on">+</span></li>
					<li class="delete lastitem">←</li>
					<li class="tab">tab</li>
					<li class="letter">q</li>
					<li class="letter">w</li>
					<li class="letter">e</li>
					<li class="letter">r</li>
					<li class="letter">t</li>
					<li class="letter">y</li>
					<li class="letter">u</li>
					<li class="letter">i</li>
					<li class="letter">o</li>
					<li class="letter">p</li>
					<li class="symbol"><span class="off">[</span><span class="on">{</span></li>
					<li class="symbol"><span class="off">]</span><span class="on">}</span></li>
					<li class="symbol lastitem"><span class="off">\</span><span
						class="on">|</span></li>
					<li class="capslock">caps lock</li>
					<li class="letter">a</li>
					<li class="letter">s</li>
					<li class="letter">d</li>
					<li class="letter">f</li>
					<li class="letter">g</li>
					<li class="letter">h</li>
					<li class="letter">j</li>
					<li class="letter">k</li>
					<li class="letter">l</li>
					<li class="symbol"><span class="off">;</span><span class="on">:</span></li>
					<li class="symbol"><span class="off">'</span><span class="on">&quot;</span></li>
					<li class="return lastitem">return</li>
					<li class="left-shift">shift</li>
					<li class="letter">z</li>
					<li class="letter">x</li>
					<li class="letter">c</li>
					<li class="letter">v</li>
					<li class="letter">b</li>
					<li class="letter">n</li>
					<li class="letter">m</li>
					<li class="symbol"><span class="off">,</span><span class="on">&lt;</span></li>
					<li class="symbol"><span class="off">.</span><span class="on">&gt;</span></li>
					<li class="symbol"><span class="off">/</span><span class="on">?</span></li>
					<li class="right-shift lastitem">shift</li>
				</ul>
			</div>
			<br />
			<div style="margin: 0 auto; width: 90%">
				<!--登录、刷卡-->
				<div class="button-box">
					<button type="button" id="submit" class="btn btn-success btn-lg ">
						<big>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</big>
					</button>
					<button type="button" id="closePanel" onclick="panel.close()" class="btn btn-danger btn-lg ">
						<big>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;关闭&nbsp;&nbsp;<span>[30]</span>&nbsp;&nbsp;</big>
					</button>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-confirm.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.toastmessage.js"></script>
<script type="text/javascript">
$(function() {
	setIntervalFunction = setInterval("coolDown.countDown()", 1000);
	$("body").click(function() {
		coolDown.time = 30;
	});

	$("#i_uName input").click(function() {
		$("#i_pWord input").removeAttr("id");
		$(this).val('');
		$(this).attr("id", "writing");
		ReadCard("start");
	});
	$("#i_pWord input").click(function() {
		$("#i_uName input").removeAttr("id");
		$(this).val('');
		$(this).attr("id", "writing");
	});
	$('#submit')
			.click(
					function() {
						if ($("#i_uName input").val() == '') {
							$().toastmessage('showWarningToast', "请输入学号");
							return false;
						}

						if ($("#i_pWord input").val() == '') {
							$().toastmessage('showWarningToast', "请输入密码");
							return false;
						}
						$(this)
								.attr("disabled", "true")
								.html(
										"<big>&nbsp;&nbsp;&nbsp;&nbsp;登陆中&nbsp;&nbsp;&nbsp;&nbsp;</big>");
						$
								.ajax({
									url : "login/validate",
									timeout : 10000,
									dataType : "json",
									async : true,
									data : {
										"userName" : $("#i_uName input").val(),
										"passWord" : $("#i_pWord input").val(),
									},
									type : "post",
									success : function(response) {
										$("#submit")
												.removeAttr("disabled")
												.html(
														"<big>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登陆&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</big>");
										if (response == "200") {
											$("form").submit();
										} else if (response == "500") {
											$().toastmessage('showErrorToast',
													"查询数据出错");
										} else {
											$().toastmessage('showErrorToast',
													"错误的用户名或者密码");
										}
									},
									complete : function(XMLHttpRequest, status) { // 请求完成后最终执行参数
										if (status == 'timeout') { // 超时,status还有success,error等值的情况
											$("#submit")
													.removeAttr("disabled")
													.html(
															"<big>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登陆&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</big>");
											$().toastmessage('showErrorToast',
													"无法连接服务器，请稍后再试");

										}
									}
								});

					});

	$('#keybord_panel li').click(
			function() {
				var $write = $("#writing");
  
				var $this = $(this), character = $this.html();
				// Shift keys
				if ($this.hasClass('left-shift')
						|| $this.hasClass('right-shift')) {
					$('.letter').toggleClass('uppercase');
					$('.symbol span').toggle();
					shift = (shift === true) ? false : true;
					capslock = false;
					return false;
				}

				// Caps lock
				if ($this.hasClass('capslock')) {
					$('.letter').toggleClass('uppercase');
					capslock = true;
					return false;
				}

				// Delete
				if ($this.hasClass('delete')) {
					var html = $write.val();

					$write.val(html.substr(0, html.length - 1));
					return false;
				}

				// Special characters
				if ($this.hasClass('symbol'))
					character = $('span:visible', $this).html();
				if ($this.hasClass('space'))
					character = ' ';
				if ($this.hasClass('tab'))
					character = "\t";
				if ($this.hasClass('return'))
					character = "\n";

				if ($this.hasClass('uppercase'))
					character = character.toUpperCase();

				if (shift === true) {
					$('.symbol span').toggle();
					if (capslock === false)
						$('.letter').toggleClass('uppercase');

					shift = false;
				}

				$write.val($write.val()
						+ character.replace("&amp;", "&").replace("&lt;", "<")
								.replace("&gt;", ">"));
			});

})

var shift = false, capslock = false, panel = {
	show : function() {
		$("input").val("");
		document.getElementsByTagName("input")[0].setAttribute("id", "writing");
		document.getElementsByClassName("b-panel")[0].style.display = "block";
		ReadCard("start");
	},
	close : function() {
		document.getElementsByTagName("input")[0].value = "";
		document.getElementsByClassName("b-panel")[0].style.display = "none";
		ReadCard("stop");
	}

}, coolDown = {
	"time" : 30,
	countDown : function(s) {
		if (coolDown.time > 0) {
			coolDown.time--;
			$("#closePanel span").html("[" + coolDown.time + "]");

		} else {
			coolDown.time = 30;
			setTimeout("coolDown.exit()", 1000);
		}
	},
	exit : function() {
		panel.close();
	}
}, ReadCard = function(action) {
	window.cefQuery({
		request : 'Request:RC-' + action,
		onSuccess : function(response) {

		},
		onFailure : function(error_code, error_message) {
		}
	});

};
</script>
</html>
