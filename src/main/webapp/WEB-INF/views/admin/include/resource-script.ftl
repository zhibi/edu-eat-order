<script src='/themes/admin/js/jquery-2.0.3.min.js'></script>
<script src='/themes/admin/js/jquery.mobile.custom.min.js'></script>
<script src="/themes/plugins/bootstrap/js/bootstrap.js"></script>
<script src="/themes/admin/js/typeahead-bs2.min.js"></script>
<script src="/themes/admin/js/ace-elements.min.js"></script>
<script src="/themes/admin/js/ace.min.js"></script>

<script src="/themes/plugins/fuelux/fuelux.spinner.min.js"></script>
<script src="/themes/admin/js/jquery.autosize.min.js"></script>
<script src="/themes/plugins/chosen/chosen.jquery.min.js"></script>
<script src="/themes/plugins/fileinput/js/fileinput.min.js"></script>
<script src="/themes/plugins/fileinput/js/fileinput_locale_zh.js"></script>
<script src="/themes/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script src="/themes/plugins/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<!-- 自定义js -->
<script src="/themes/plugins/customer-file.js"></script>
<script src="/themes/plugins/common.js"></script>

<script><!-- 菜单展开 -->
var active = "${active!''}";
if(active.length>0){
    var obj = $("#"+active);
    obj.addClass("active");
    obj.parents("li").addClass("active open");
}

$('#spinner').ace_spinner({
    value: ${sort!0},
    min: 0,
    max: 100,
    step: 1,
    on_sides: true,
    icon_up: 'icon-plus smaller-75',
    icon_down: 'icon-minus smaller-75',
    btn_up_class: 'btn-success',
    btn_down_class: 'btn-danger'
});
$('textarea').autosize({
    append: "\n"
});
$(".chosen-select").chosen();
$(".num").onlyNum();
$(".double").onlyDouble();

</script>
<!-- 富文本 -->
<script charset="utf-8" src="/themes/plugins/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="/themes/plugins/kindeditor/lang/zh-CN.js"></script>
<script>
    KindEditor.ready(function (K) {
        window.editor = K.create('#editor', {
            uploadJson: '/uploadFile',
            fileManagerJson: '',
            allowFileManager: false
        });
    });
    var tipMessage = "${tipMessage!}";
    if(tipMessage.length > 0){
        tipMsg(tipMessage);
    }
    function tipMsg(msg){
        $("#m-msg").html(msg);
        $("#modalMsg").modal("show");
    }

</script>


<div class="modal fade bs-example-modal-sm" id="info" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
            </div>
            <div class="modal-body">
                <form  class="form-horizontal" >
                    <div class="input-group has-success col-xs-6" style="margin: 10px auto;">
                        <span class="input-group-addon" style="width: 90px;">原&nbsp;密&nbsp;码:</span>
                        <input type="password" class="form-control" name="password">
                    </div>
                    <div class="input-group has-success col-xs-6" style="margin: 10px auto;">
                        <span class="input-group-addon" style="width: 90px;">新&nbsp;密&nbsp;码:</span>
                        <input type="password" class="form-control" name="pwd">
                    </div>
                    <div class="input-group has-success col-xs-6" style="margin: 10px auto;">
                        <span class="input-group-addon" style="width: 90px;">确认密码:</span>
                        <input type="password" class="form-control" name="pwd2">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary" onclick="pwd_submit()">修改</button>
            </div>
        </div>
    </div>
</div>
<script>
    function pwd_submit() {
        var password = $('input[name="password"]').val();
        var pwd = $('input[name="pwd"]').val();
        var pwd2 = $('input[name="pwd2"]').val();
        if(pwd.length == 0){
            alert("请输入新密码");
            return;
        }
        if(pwd2.length == 0){
            alert("请输入确认密码");
            return;
        }
        if(pwd != pwd2){
            alert("两次密码不一样");
            return;
        }
        $.getJSON("/admin/modifyPwd",{password:password,pwd:pwd,pwd2:pwd2},function(result){
            if(result.code == 200){
                alert("修改成功");
                if(result.message == 'business'){
                    location.href = "/admin/login";
                }else{
                    location.href = "/admin/customer/login";
                }
            }else{
                alert(result.message);
                location.reload(true);
            }
        })
    }
</script>