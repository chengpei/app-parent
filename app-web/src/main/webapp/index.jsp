<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<title>首页</title>
<script src="${pageContext.request.contextPath}/js/jquery.1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/vendor/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.fileupload.js"></script>
<body>
    <h2 onclick="sendPost();">Hello World!</h2>
    <form id="logoutForm" action="/logout" method="post" style="display: none;">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <a href="javascript:void(0);" onclick="$('#logoutForm').submit();">登出</a>

    <h2>图片异步上传Demo</h2>
    <input type="file" name="file" id="fileInput" data-url="${pageContext.request.contextPath}/fileupload/upload.do" multiple>
    <div id="dropzone">
        <img id="imgId" src="/imgs/background.jpg">
    </div>
</body>
<script type="text/javascript">
    $.postJSON = function(url, data, callback) {
        return jQuery.ajax({
            'type': 'POST',
            'url': url,
            'contentType': 'application/json',
            'data': JSON.stringify(data),
            'dataType': 'json',
            'success': callback
        });
    };

    function sendPost(){
        var person = {username:'chengpei', password:'123456'};
        $.postJSON("${pageContext.request.contextPath}/fileupload/http.do", person, function(data){
            alert(data.message);
        })
    }

    $(function(){
        $("#fileInput").fileupload({
            dataType: 'json',
            done: function (e, data) {
                $("#imgId").attr("src", "${pageContext.request.contextPath}/imgs/" + data.result.fileName);
            },
            dropZone: $('#dropzone')
        });
    });

</script>
</html>
