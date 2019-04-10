<div class="side">
    <section id="shop-notice" class="notice clearfix">
        <p class="warp"></p>
        <h2>商家公告</h2>
        <p class="notice-desc" data-node="shop-notice">${business.content!}</p>
    </section>
    <section class="cart-section cart-fix" id="cart-section">
        <div class="menu-cart menu-cart-box-shadow">
            <div class="cart-bar pointer">
                        <span class="cart-desc submit fr" id="cartSubmit" style=""
                              <#if sessionUser??>onclick="location.href ='/order/myCar'"
                              <#else>onclick="alert('请登录')"</#if>>预&nbsp;约</span>
            </div>
        </div>
    </section>
</div>