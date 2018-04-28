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
        <li <#if !pageInfo.hasPreviousPage>class="disabled"</#if>>
            <a <#if pageInfo.hasPreviousPage> href="${url}&pageNum=${pageInfo.prePage}" </#if>>
                <i class="icon-double-angle-left"></i>
            </a>
        </li>
    <#list pageInfo.navigatepageNums as num>
        <li <#if pageInfo.pageNum == num>class="active"</#if>>
            <a <#if pageInfo.pageNum != num>href="${url}&pageNum=${num}" </#if>>${num}</a>
        </li>
    </#list>
        <li <#if !pageInfo.hasNextPage>class="disabled"</#if>>
            <a <#if pageInfo.hasNextPage> href="${url}&pageNum=${pageInfo.nextPage}" </#if>>
                <i class="icon-double-angle-right"></i>
            </a>
        </li>
    </ul>
</div>