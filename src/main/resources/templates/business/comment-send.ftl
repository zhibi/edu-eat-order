<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="home"/>
<#assign navTitle='评论 ' + business.name />
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
    <form class="mui-input-group" style="margin-top: 8px" action="/comment/send" method="post" onsubmit="formSubmit()">
        <input type="hidden" name="businessId" value="${business.id}">
        <input type="hidden" name="content" id="content">
        <div class="mui-input-row">
            <label>打分：</label>
            <select class="mui-btn-block" name="start">
                <option value="5">5分</option>
                <option value="4">4分</option>
                <option value="3">3分</option>
                <option value="2">2分</option>
                <option value="1">1分</option>
            </select>
        </div>
        <div class="mui-input-row">
            <label>服务态度：</label>
            <input type="text" name="serve" class="mui-input-clear" required data-input-clear="5"><span
                    class="mui-icon mui-icon-clear mui-hidden"></span>
        </div>
        <div class="mui-input-row">
            <label>就餐建议：</label>
            <input type="text" name="diningAdvice" class="mui-input-clear" required data-input-clear="5"><span
                    class="mui-icon mui-icon-clear mui-hidden"></span>
        </div>
        <div class="mui-input-row">
            <label>就餐环境：</label>
            <input type="text" name="environment" class="mui-input-clear" required data-input-clear="5"><span
                    class="mui-icon mui-icon-clear mui-hidden"></span>
        </div>
        <div class="mui-input-row">
            <label>菜品味道：</label>
            <input type="text" name="taste" class="mui-input-clear" required data-input-clear="5"><span
                    class="mui-icon mui-icon-clear mui-hidden"></span>
        </div>
        <div class="mui-input-row">
            <label>标签：</label>
            <input type="text" name="tag" class="mui-input-clear" required data-input-clear="5"><span
                    class="mui-icon mui-icon-clear mui-hidden"></span>
        </div>
        <script id="container" name="content" type="text/plain"></script>

        <div class="mui-button-row">
            <button type="submit" class="mui-btn mui-btn-primary">发布</button>&nbsp;&nbsp;
        </div>
    </form>
</div>
</body>
<script type="text/javascript" src="/webjars/ueditor-bower/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="/webjars/ueditor-bower/ueditor.all.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('container', {
        autoHeightEnabled: true,
        // 服务器统一请求接口路径
        serverUrl: "http://localhost/ueditor/server"
    });

    function formSubmit() {
        $("#content").val(ue.getContent());
    }

    var err = "${errorMessage!}";
    if (err.length > 0) {
        mui.alert(err, '提示');
    }

</script>
</html>