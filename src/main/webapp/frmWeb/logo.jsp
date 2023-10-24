<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<title>教学辅助系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/logo.css" rel="stylesheet" type="text/css">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function Date_of_Today() {
	var now = new Date();
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var date = now.getDate();
	if (month < 10)
		month = '0' + month;
	if (date < 10)
		date = '0' + date;
	return (year + '-' + month + '-' + date);
}
function Week_of_Today() {
	var day = new Array();
	day[0] = "星期日";
	day[1] = "星期一";
	day[2] = "星期二";
	day[3] = "星期三";
	day[4] = "星期四";
	day[5] = "星期五";
	day[6] = "星期六";
	var now = new Date();
	//alert(day[now.getDay()]);
	return (day[now.getDay()]);
	
}
function CurentTime() {
	var now = new Date();
	var hour = now.getHours();
	var minute = now.getMinutes();
	var second = now.getTime() % 60000;
	second = (second - (second % 1000)) / 1000;
	var time = hour + ':';
	if (minute < 10)
		time += '0';
	time += minute + ':';
	if (second < 10)
		time += '0';
	time += second;
	return (time);
}
function refreshDateTime() {
	document.all.DateTimeCol.innerHTML = Date_of_Today() + '  ' +Week_of_Today()+  '  ' + CurentTime();
}

	setInterval('refreshDateTime()', 1000);
</script>
</head>
<body>

	<table style="width:100% ">
		<tr>
			<td>
				<table style="width:100% ">
					<tr height="57">
						<td style="vertical-align: middle;" class="logo">
						</td>
						<td style="text-align: right;" class="login-text">[${user.userName}]&nbsp;&nbsp;<span id="DateTimeCol"></span></td>
						<td style="width:280px;text-align: center; ">
							<table style="width:100%;height: 57px;text-align: center; ">
								<tr height="57">
									<td style="width:100% ">
										<table style="text-align: center;">
											<tr height="28">
												<td colspan="3">&nbsp;</td>
											</tr>
											<tr>
												<td class="right-button-left">&nbsp;</td>
												<td style="text-align: right;" class="right-button-bg">
													<table style="height: 29px" >
														<tr>
															<td class="button-help-mouseout"
																onMouseOut="this.className='button-help-mouseout'"
																onMouseOver="this.className='button-help-mouseover'"
																style="cursor:pointer"
																onClick="top.mainFrame.location.href='../help.jsp'">&nbsp;</td>
															<td class="button-split-line">&nbsp;</td>
															<td class="button-mpwd-mouseout"
																onMouseOut="this.className='button-mpwd-mouseout'"
																onMouseOver="this.className='button-mpwd-mouseover'"
																style="cursor:pointer"
																onClick="top.mainFrame.location.href='modifyUserInfo.jsp'">&nbsp;</td>
															<td class="button-split-line">&nbsp;</td>
															<td class="button-logout-mouseout"
																onMouseOut="this.className='button-logout-mouseout'"
																onMouseOver="this.className='button-logout-mouseover'"
																style="cursor:pointer"
																onClick="top.location.href='userLogout.jsp'">&nbsp;</td>
														</tr>
													</table></td>
												<td class="right-button-right">&nbsp;</td>
											</tr>

										</table>
									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="height: 3px" class="bottom-line"></td>
		</tr>
	</table>
</body>
</html>
