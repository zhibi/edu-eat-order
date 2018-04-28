<head>
    <meta charset="utf-8"/>
    <title>后台管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link rel="stylesheet" href="/themes/plugins/chosen/chosen.css" />
    <link href="/themes/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/themes/plugins/font-awesome/css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="/themes/plugins/font-awesome/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->
    <!-- fonts -->

    <!-- ace styles -->
    <link rel="stylesheet" href="/themes/admin/css/ace.min.css"/>
    <link rel="stylesheet" href="/themes/admin/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="/themes/admin/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/themes/admin/css/ace-ie.min.css"/>
    <![endif]-->

    <link rel="stylesheet" href="/themes/plugins/fileinput/css/fileinput.min.css">
    <link rel="stylesheet" href="/themes/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">

    <!-- inline styles related to this page -->
    <!-- ace settings handler -->

    <script src="/themes/admin/js/ace-extra.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="/themes/admin/js/html5shiv.js"></script>
    <script src="/themes/admin/js/respond.min.js"></script>
    <![endif]-->
</head>
<div class="modal fade" id="modalMsg" tabindex="-1" role="dialog" aria-labelledby="modalMsgLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modalAcceptLabel">信息提示</h4>
            </div>
            <div class="modal-body" id="m-msg">

            </div>
        </div>
    </div>
</div>