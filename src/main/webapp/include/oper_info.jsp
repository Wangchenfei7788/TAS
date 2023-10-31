<%@page pageEncoding="utf-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作处理页</title>

<link href="./css/oper_area.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ================导航 start=================== -->
	<table style="width: 100%;">
		<tr>
			<td class="title-bar">
				<table style="width: 99%">
					<tr>
						<td class="title-bar-title-icon">&nbsp;</td>
						<td class="title-bar-text">操作提示</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<!-- ================导航 end =================== -->
    <p>&nbsp;</p>
    <table style="width: 80%;">
      <tr>
        <td height="29" background="../images/ts.jpg">
            <table style="width: 100%;">
              <tr>
                <td width="44" align="center">
                	<img src="./images/dh.gif" width="22" height="29"/>
                </td>
                <td>操作提示：</td>
              </tr>
            </table>
        </td>
      </tr>
    </table>
    <table style="width: 80%;" class="table-frame">
      <tr>
        <td width="156" height="40" class="table-frame-input-title">操作：</td>
        <td height="40" class="table-cell-input">${action }</td>
      </tr>
      <tr>
        <td height="40" class="table-frame-input-title">提示信息：</td>
        <td height="40" class="table-cell-input">${action_info }</td>
      </tr>
    
      <tr>
       	<td height="40" class="table-frame-input-title">下一步：</td>
        <td height="40" style="font-size: 20px;color:#FF9999;" class="table-cell-input">
        	现正在转向【${next_info }】......
        	<script type="text/javascript">
        		setTimeout("${next_url}",5000);
        	</script>
    	</td>
      </tr>
    </table>
</body>
</html>
