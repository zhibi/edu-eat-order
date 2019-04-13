<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="home"/>
<#assign navTitle=business.name + '的评论'/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
    <#list commentList as item>
        <div class="mui-card">
            <div class="mui-card-header mui-card-media">
                <img src="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1874874066,3384346303&fm=27&gp=0.jpg">
                <div class="mui-media-body">
                    ${item.userName!}<span class="mui-badge mui-badge-danger" style="float: right">${item.start!}</span>
                    <p>发表于 ${item.addtime?string('yyyy-MM-dd HH:mm:ss')}</p>

                </div>
            </div>
            <div class="mui-card-content">
                <ul class="mui-table-view">
                    <li class="mui-table-view-cell">服务态度：${item.serve!}</li>
                    <li class="mui-table-view-cell">就餐建议：${item.diningAdvice!}</li>
                    <li class="mui-table-view-cell">就餐环境：${item.environment!}</li>
                    <li class="mui-table-view-cell">菜品味道：${item.taste!}</li>
                </ul>
                <div class="mui-card-content-inner">
                    ${item.content!}
                </div>
            </div>
            <div class="mui-card-footer">${item.flag}</div>
        </div>
    </#list>

</div>
</body>

</html>