<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--    边栏nav-->
    <#include "../common/nav.ftl">
    <#--     右侧-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#--                        通过.content 获取page中的每一个对象-->
                        <#list orderMasterPage.content as orderMaster>
                            <tr>
                                <td>${orderMaster.orderId}</td>
                                <td>${orderMaster.buyerName}</td>
                                <td>${orderMaster.buyerPhone}</td>
                                <td>${orderMaster.buyerAddress}</td>
                                <td>${orderMaster.orderAmount}</td>
                                <td>${orderMaster.orderStatus}</td>
                                <td>${orderMaster.payStatus}</td>
                                <td>${orderMaster.createTime}</td>
                                <td>
                                    <a href="/seller/order/index?orderId=${orderMaster.orderId}">修改</a>
                                </td>
                                <td>
                                    <#if orderMaster.orderStatus == 0>
                                        <a href="/seller/order/off_order?orderId=${orderMaster.orderId}">取消</a>
                                    </#if>
                                </td>

                            </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <#--                    pull-right 控件靠右-->
                    <ul class="pagination pull-right">

                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else >
                            <li ><a href="/seller/order/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                        </#if>

                        <#--               1.. val 代表从1 开始循环       获取查询数据的总页数  ${productInfoPage.getTotalPages()  }-->

                        <#list 1..orderMasterPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else >
                                <li><a href="/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>

                        </#list>


                        <#if currentPage gte orderMasterPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li ><a href="/seller/order/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                        </#if>
                    </ul>
                </div>

            </div>
        </div>

</div>
</div>
</body>
</html>