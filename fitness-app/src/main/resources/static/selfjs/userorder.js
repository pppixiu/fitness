var listCoachUrl = '/user/onlineorderlist';

//初始化blog数据
function getuserorder() {
    var url = listCoachUrl;
    var html = '';
    $
        .getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var blogList = data.data;
                    blogList
                        .map(function (item, index) {
                            html += '\t<div class="col-md-12 shadow radis" style="background-color: white; margin-bottom: 20px">\n' +
                                '\t\t\t\t\t<div style="padding-top: 10px;padding-left: 20px; border-bottom: solid gainsboro 1px">订单编号:'+ item.orderCode +'</div>\n' +
                                '\t\t\t\t\t<div class="col-md-4" style="padding-top: 10px; padding-bottom: 10px;">\n' +
                                '\t\t\t\t\t\t<img class="head_img" src="'+ item.coach.imageurl +'" alt="" width="150px" height="150px">\n' +
                                '\t\t\t\t\t</div>\n' +
                                '\t\t\t\t\t<div class="col-md-4" style="margin-top: 60px;" >\n' +
                                '\t\t\t\t\t\t<span>预约时间：<br> '+ new Date(item.starttime).Format("yyyy.MM.dd hh:mm") +' - '+ new Date(item.endtime).Format("yyyy.MM.dd hh:mm")+'</span>\n' +
                                '\t\t\t\t\t</div>\n' +
                                '\t\t\t\t\t<div class="col-md-4" style="margin-top: 60px">\n' +
                                '\t\t\t\t\t\t<span>金额 ：'+ item.total +'元<br>'+ item.status +'</span>\n' +
                                '\t\t\t\t\t\t<button type="button" style="margin-top: 40px;float: right;" class="btn btn-success " onclick=levelfunction(2)>再次购买</button>>\n' +
                                '\t\t\t\t\t</div>\n' +
                                '\t\t\t\t</div>'
                        });
                } else {
                    html = '<div style="height: 550px; text-align: center; line-height: 550px; font-size: 20px;" >没有订单信息</div>';
                }
                $('#order-list').html(html);
            });
}

$(function () {
    getuserorder();
});
