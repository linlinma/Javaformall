<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--    边栏nav-->
    <#include "../common/nav.ftl">
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table">
                    <thead>
                    <tr>
                        <th>
                            订单id
                        </th>
                        <th>
                            订单总金额
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            ${orderMaster.orderId}
                        </td>
                        <td>
                            ${orderMaster.orderAmount}
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table class="table">
                    <thead>
                    <tr>
                        <th>
                            商品id
                        </th>
                        <th>
                            商品名称
                        </th>
                        <th>
                            价格
                        </th>
                        <th>
                            数量
                        </th>
                        <th>
                            金额
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <#list orderDetails as orderDetail>
                            <td>
                                ${orderDetail.productId}
                            </td>
                            <td>
                                ${orderDetail.productName}
                            </td>
                            <td>
                                ${orderDetail.productPrice}
                            </td>
                            <td>
                                ${orderDetail.productQuantity}
                            </td>
                            <td>
                                <script>
                                    var a=parseFloat((${orderDetail.productPrice}*${orderDetail.productQuantity}).toFixed(2))
                                    document.write(a);
                                </script>
                            </td>
                        </#list>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>