<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>首页</title>
<script src="${pageContext.request.contextPath}/js/jquery.1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/vendor/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.fileupload.js"></script>
<body>
<h2>Hello World!</h2>

<form action="/login" method="post">
    <c:if test="${!empty param.authentication_error}">
        <span style="color: red;">用户名或密码错误</span>
    </c:if>
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" value="chengpei"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" value="123456"/></td>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </tr>
        <tr>
            <td>记住我 <input type="checkbox" name="remember-me"/></td>
            <td style="text-align: right;"><input type="submit" value="登录"/></td>
        </tr>
    </table>

</form>
</body>

</html>
