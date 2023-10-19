<%--
  Created by IntelliJ IDEA.
  User: w'c'f
  Date: 2023/10/19
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教学辅助系统后台主页面</title>
</head>
<script type="text/javascript">
    function showOrHiddenLogoFrame(isShow){
        if (isShow){
            document.all.middleFrame.cols="180,10,*";
        }else {
            document.all.middleFrame.cols="0,10,*";
        }
    }
</script>
<frameset rows="60,30,*,4" frameborder="no" framespacing="0">
    <frame src="frmWeb/logo.jsp" scrolling="no" name="logeFrame">
    <frame src="frmWeb/menu_tab.html" scrolling="no" name="menutabFrame">
    <frameset cols="180,10,*" id="middleFrame">
        <frame src="frmWeb/menu.html" scrolling="no" name="menuFrame">
        <frame src="frmWeb/left_ctrl_bar.html" scrolling="no" name="leftctrlbarFrame">
        <frame src="frmWeb/welcome.html" scrolling="no" name="mainFrame">
    </frameset>
    <frame src="frmWeb/state_bar.html" scrolling="no" name="statebarFrame">
</frameset>
<body>

</body>
</html>
