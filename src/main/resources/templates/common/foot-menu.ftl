<nav class="mui-bar mui-bar-tab">
    <a class="mui-tab-item <#if (menuAct!'home') == 'home'>mui-active</#if>" onclick="location.href='/'">
        <span class="mui-icon mui-icon-home"></span>
        <span class="mui-tab-label">首页</span>
    </a>
    <a class="mui-tab-item <#if (menuAct!'') == 'search'>mui-active</#if>" href="#">
        <span class="mui-icon mui-icon-search"></span>
        <span class="mui-tab-label">搜索</span>
    </a>

    <a class="mui-tab-item <#if (menuAct!'') == 'user'>mui-active</#if>" href="#">
        <span class="mui-icon mui-icon-contact"></span>
        <span class="mui-tab-label">个人中心</span>
    </a>
</nav>