<nav class="mui-bar mui-bar-tab">
    <a class="mui-tab-item <#if (menuAct!'home') == 'home'>mui-active</#if>"   href="/">
        <span class="mui-icon mui-icon-home"></span>
        <span class="mui-tab-label">首页</span>
    </a>
    <a class="mui-tab-item <#if (menuAct!'') == 'order'>mui-active</#if>"  href="/order/myOrder" >
        <span class="mui-icon-extra mui-icon-extra-cart"></span>
        <span class="mui-tab-label">订单</span>
    </a>
    <a class="mui-tab-item <#if (menuAct!'') == 'user'>mui-active</#if>" href="/user/index">
        <span class="mui-icon mui-icon-contact"></span>
        <span class="mui-tab-label">个人中心</span>
    </a>
</nav>