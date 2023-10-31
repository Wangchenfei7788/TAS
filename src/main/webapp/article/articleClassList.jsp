<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:useBean id="ac" class="com.wcf.tas.entity.ArticleClassVO" scope="request"></jsp:useBean>
<html>
<head>
<title>文章栏目管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/oper_area.css" type="text/css" />
<script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
	<!-- ================导航 start=================== -->
	<table style="width: 100%;">
		<tr>
			<td class="title-bar">
				<table style="width: 99%">
					<tr>
						<td class="title-bar-title-icon">&nbsp;</td>
						<td class="title-bar-text">文章栏目管理</td>
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

	<form name="mainForm" method="post" action="">
	<table style="width: 100%;" class="oper-bar">
		<tr>
			<td>
				<table style="width: 99%">
					<tr>

						<td style="width: 100px;text-align: center;">
							<input type="button" class="form-button" value="添加栏目" onclick="location.href='articleClassList.do'">
						</td>
						<td></td>
						<td style="width: 60%; text-align: right;">
							
								<table>
									<tr>
										<td class="oper-bar-text">栏目名称：</td>
										<td><input type="text" name="classname" style="width: 120px;"></td>
										<td>&nbsp;<input type="submit" name="search" value="查询" class="form-button"> <input type="reset" name="Reset" value="清空" class="form-button">
										</td>

									</tr>
								</table>
							
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	
	<table style="width: 100%" class="table-frame">
		<tr>
			<th class="table-titlebar">栏目ID</th>
			<th class="table-titlebar">栏目名称</th>
			<th class="table-titlebar">栏目创建者</th>
			<th class="table-titlebar">创建时间</th>
			<th class="table-titlebar">是否显示</th>
			<th style="width: 70px;" class="table-titlebar">操作</th>
		</tr>
		<c:forEach items="${acList }" var="ac">
			<tr>
				<td class="table-cell">${ac.classId }</td>
				<td class="table-cell">${ac.className }</td>
				<td class="table-cell">${ac.addUid }</td>
				<td class="table-cell">${ac.addDate }</td>
				<td class="table-cell">${ac.show }</td>
				<td style="text-align: center;" class="table-cell"><a href="articleClassList.do?classId=${ac.classId }">改</a> <a href="#"
					onclick="confirmAction(mainForm,'您确定要删除此文章吗？','../article/articleClassDelete.do?classId=${ac.classId }')">删</a></td>
			</tr>
		</c:forEach>
		<!--
			<tr>
				<td class="table-cell">2</td>
				<td class="table-cell">体育快讯</td>
				<td class="table-cell">1</td>
				<td class="table-cell">2021-10-06</td>
				<td class="table-cell">true</td>
				<td style="text-align: center;" class="table-cell"><a href="articleClassList.do?classId=2">改</a> <a href="#"
					onclick="confirmAction(mainForm,'您确定要删除此文章吗？','../article/articleClassDelete.do?classId=2')">删</a></td>
			</tr>
		
			<tr>
				<td class="table-cell">3</td>
				<td class="table-cell">校园风云</td>
				<td class="table-cell">1</td>
				<td class="table-cell">2021-10-06</td>
				<td class="table-cell">true</td>
				<td style="text-align: center;" class="table-cell"><a href="articleClassList.do?classId=3">改</a> <a href="#"
					onclick="confirmAction(mainForm,'您确定要删除此文章吗？','../article/articleClassDelete.do?classId=3')">删</a></td>
			</tr>
		
			<tr>
				<td class="table-cell">4</td>
				<td class="table-cell">国际新闻</td>
				<td class="table-cell">3</td>
				<td class="table-cell">2021-12-20</td>
				<td class="table-cell">false</td>
				<td style="text-align: center;" class="table-cell"><a href="articleClassList.do?classId=4">改</a> <a href="#"
					onclick="confirmAction(mainForm,'您确定要删除此文章吗？','../article/articleClassDelete.do?classId=4')">删</a></td>
			</tr>
		
			<tr>
				<td class="table-cell">5</td>
				<td class="table-cell">运动健康</td>
				<td class="table-cell">3</td>
				<td class="table-cell">2021-12-20</td>
				<td class="table-cell">false</td>
				<td style="text-align: center;" class="table-cell"><a href="articleClassList.do?classId=5">改</a> <a href="#"
					onclick="confirmAction(mainForm,'您确定要删除此文章吗？','../article/articleClassDelete.do?classId=5')">删</a></td>
			</tr>
		
			<tr>
				<td class="table-cell">6</td>
				<td class="table-cell">最新消息</td>
				<td class="table-cell">1</td>
				<td class="table-cell">2021-12-21</td>
				<td class="table-cell">false</td>
				<td style="text-align: center;" class="table-cell"><a href="articleClassList.do?classId=6">改</a> <a href="#"
					onclick="confirmAction(mainForm,'您确定要删除此文章吗？','../article/articleClassDelete.do?classId=6')">删</a></td>
			</tr>
		-->
	
	</table>
	</form>
	
	<p>&nbsp;</p>
	<table style="width: 100%; text-align: center;" class="title-bar2">
		<tr>
			<td><table style="width: 99%; text-align: center;">
					<tr>
						<td class="title-bar2-text">文章栏目信息</td>
					</tr>
				</table></td>
		</tr>
	</table>

	<%--@elvariable id="ac" type=""--%>
	<form:form modelAttribute="ac" id="arClass" name="artclsForm" action="dealArticleClass.do" method="post">
		<form:hidden path="classId"/>
		<!-- <input id="classId" name="classId" type="hidden" value="0"/> -->
		<table style="width: 100%;">
			<tr>
				<td class="table-frame-input-title" style="text-align: right;width: 40%;">栏目名称：</td>
				<td class="table-cell-input" style="width: 60%;">
					<form:input path="className" cssStyle="width: 150px;" maxlength="4" id="className" cssClass="form-input"/>
					<!-- <input id="className" name="className" type="text" class="form-input" style="width: 150px;" maxlength="4"/> -->
				</td>
			</tr>
			<tr>
				<td class="table-frame-input-title" style="text-align: right;">栏目英文名：</td>
				<td class="table-cell-input">
					<form:input path="classEnName" cssStyle="width: 150px;" maxlength="20" id="classEnName" cssClass="form-input"/>
					<!-- <input id="classEnName" name="classEnName" type="text" class="form-input" style="width: 150px;" maxlength="20"/> -->
				</td>
			</tr>
			<tr>
				<td class="table-frame-input-title" style="text-align: right;">是否显示：</td>
				<td class="table-cell-input">
					<form:radiobutton path="show" value="1" label="是"/>
					<!-- <input name="show" type="radio" value="1" />是 -->
					<form:radiobutton path="show" value="0" label="否"/>
    				<!-- <input name="show" type="radio" value="0" checked="checked"/>否 -->
    			</td>
			</tr>
			<tr>
				<td class="table-frame-input-title" style="text-align: right;">栏目备注：</td>
				<td class="table-cell-input">
					<form:input id="classRemark" path="classRemark" cssClass="form-input" cssStyle="width: 350px;"/>
				</td>
			</tr>

			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="${ac.classId>0?'更改': '添加'}" class="form-button"> 
					<input type="reset" name="Reset" value="重置" class="form-button">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
