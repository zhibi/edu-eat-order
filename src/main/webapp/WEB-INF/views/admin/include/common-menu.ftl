<a class="menu-toggler" id="menu-toggler" href="#">
    <span class="menu-text"></span>
</a>

<div class="sidebar" id="sidebar">
    <ul class="nav nav-list">

        <#if sessionAdmin.username != 'admin'>
            <li>
                <a href="#" class="dropdown-toggle">
                    <i class="icon-desktop"></i>
                    <span class="menu-text">菜品管理</span>
                    <b class="arrow icon-angle-down"></b>
                </a>
                <ul class="submenu">
                    <li id="foodList">
                        <a href="/admin/food/list"><i class="icon-leaf"></i>菜品列表</a>
                    </li>
                </ul>
            </li>

            <li>
                <a href="#" class="dropdown-toggle">
                    <i class="icon-desktop"></i>
                    <span class="menu-text">商家管理</span>
                    <b class="arrow icon-angle-down"></b>
                </a>
                <ul class="submenu">
                    <li id="noticeAdd">
                        <a href="/admin/business/info"><i class="icon-plus"></i>个人信息</a>
                    </li>

                </ul>
            </li>


            <li>
                <a href="#" class="dropdown-toggle">
                    <i class="icon-desktop"></i>
                    <span class="menu-text">订单管理</span>
                    <b class="arrow icon-angle-down"></b>
                </a>
                <ul class="submenu">
                    <li id="orderList">
                        <a href="/admin/order/list"><i class="icon-leaf"></i>店铺订单</a>
                    </li>
                </ul>
            </li>
            <#else>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"></i>
                        <span class="menu-text">菜品管理</span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li id="foodList">
                            <a href="/admin/food/list"><i class="icon-leaf"></i>菜品列表</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"></i>
                        <span class="menu-text">用户管理</span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li id="userList">
                            <a href="/admin/user/list"><i class="icon-leaf"></i>用户列表</a>
                        </li>

                    </ul>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"></i>
                        <span class="menu-text">商家管理</span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li id="noticeList">
                            <a href="/admin/business/list"><i class="icon-leaf"></i>商家列表</a>
                        </li>
                        <li id="noticeAdd">
                            <a href="/admin/business/add"><i class="icon-plus"></i>添加商家</a>
                        </li>

                    </ul>
                </li>


                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"></i>
                        <span class="menu-text">订单管理</span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li id="orderList">
                            <a href="/admin/order/list"><i class="icon-leaf"></i>所有订单</a>
                        </li>
                    </ul>
                </li>
        </#if>

    </ul><!-- /.nav-list -->

    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
           data-icon2="icon-double-angle-right"></i>
    </div>
</div>
