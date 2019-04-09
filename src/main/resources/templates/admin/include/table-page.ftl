<div class="page pull-left">
    <ul class="pagination">
        <li>共${pageInfo.total}条数据</li>
        <li>&nbsp;&nbsp;</li>
        <li>共${pageInfo.pages}页</li>
    </ul>
</div>
<div class="page pull-right">
    <!-- 分页插件 -->
    <ul class="pagination">
        <#if pageInfo.hasPreviousPage>
            <li class="disabled">
            <a  href="${requestUrl}&pageNum=${pageInfo.prePage}">
            <i class="icon-double-angle-left"></i>
            </a>
            </li>
        </#if>
        <#list pageInfo.navigatepageNums as num>
            <li <#if pageInfo.pageNum == num>class="active"</#if>>
        <a <#if pageInfo.pageNum != num>href="${requestUrl}&pageNum=${num}" </#if>>${num}</a>
            </li>
        </#list>
        <#if pageInfo.hasNextPage>
            <li class="disabled">
            <a href="${requestUrl}&pageNum=${pageInfo.nextPage}" >
            <i class="icon-double-angle-right"></i>
            </a>
            </li>
        </#if>
    </ul>
</div>