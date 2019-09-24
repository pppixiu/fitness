/**值的初始化*/
var tagId = 0;
var rowIndex = 0;
var sortId = 0;
var coachName = 'empty';
var tagList;
var goCount = 0;
var lastCoachId = 0;
/**
 * 初始化
 */
$(function () {
    getcoachlist();
    gettaglist();
});

/**
 * 获得tagId
 * @param e
 */
function tagsfunction(e) {
    var coachOutCount = $(".coach-card").length;
    if(coachOutCount > 0){
        goCount = 0;
        rowIndex = 0;
    }

    if (e == "9"){
        tagId = 0;
    } else {
        tagId = e;
    }
    document.getElementById("tag-title").innerText = tagList[e-1].tagName;
    getcoachlist();
}

/**
 * 获得价钱排序值
 * @param e
 */
function pricefunction(e) {
    sortId = e;
    getcoachlist();
}

/**
 * 获得人气排序值
 * @param e0
 */
function countfunction(e) {
    sortId = e;
    getcoachlist();
}

/**
 * 获得模糊查询值
 */
function namefunction() {
    var coachOutCount = $(".coach-card").length;
    if(coachOutCount > 0){
        goCount = 0;
        rowIndex = 0;
    }
    coachName = document.getElementById('dim-name').value;
    if(coachName == ""){
        coachName = "empty";
    }
    getcoachlist();
}

/**
 * 获取页面值
 */
function pagefunction() {
    goCount += 1;
    rowIndex = 8 * goCount;
    getcoachlist();
}

/**
 * 输出标签
 */
function gettaglist() {
    var tagUrl = '/coach/tag';
    var tagurl = tagUrl;
    $.getJSON(
        tagurl,
        function (data) {
            if(data.code == "0"){
                tagList = data.data;
                var html = "";
                tagList.map(function (item,index) {
                    html += '<li><a href="#" onclick="tagsfunction('
                        + item.tagId
                        + ')">'
                        + item.tagName
                        + '</a></li>'
                });
                $('#tag-show').html(html);
            }
        })
}

/**
 * 输出教练列表
 */
function getcoachlist() {
    goCount = 0;
    rowIndex = 0;
    lastCoachId = 0;
    var coachListUrl = '/coach/coachList?tagId='+tagId+'&rowIndex='+rowIndex+'&sortId='+sortId+'&coachName='+coachName;
    var url = coachListUrl;

    $.getJSON(
        url,
        function (data) {
            if (data.code == "0") {
                var coachList = data.data;
                if(coachList == ""){
                    $("#not-find").text("抱歉！没有找到相关教练");
                }else {
                    $("#not-find").text("");
                }
                var html = '';
                coachList
                    .map(function (item, index) {
                        lastCoachId = item.id;
                        html += '<div id="first-list"><div class="coach-card" style="width: 300px;height:auto;" href="coachPage?coachId='
                            + item.id
                            + '">'
                            + '<div class="card card-product" href="coachPage?coachId='
                            + item.id
                            + '">'
                            + '<div class="card-image" href="coachPage?coachId='
                            + item.id
                            + '"><a href="coachPage?coachId='
                            + item.id
                            + '"><img class="img" src="/images/coachList/blog04.jpeg" href="coachPage?coachId='
                            + item.id
                            + '"></a></div>'
                            + '<div class="table" href="coachPage?coachId='
                            + item.id
                            + '">'
                            + '<h6 class="category text-rose">'
                            + item.count
                            + '</h6>'
                            + '<h4 class="card-caption">'
                            + '<a href="coachPage?coachId='
                            + item.id
                            + '">'
                            + item.name
                            + '</a></h4>'
                            + '<div class="card-description">'
                            + item.desc
                            + '</div>'
                            + '<div class="ftr">'
                            + '<div class="price" style="margin-top: 20px;margin-right: 130px;">'
                            + '<h4>$'
                            + item.price
                            + '</h4></div>'
                            + '<div class="stats" href="coachPage?coachId='
                            + item.id
                            + '">'
                            + '<button type="button" rel="tooltip" title="" class="btn btn-just-icon"'
                            + 'data-original-title="Saved to Wishlist"  href="coachPage?coachId='
                            +  item.id
                            + '"><i class="glyphicon glyphicon-search"  href="coachPage?coachId='
                            + item.id
                            + '"></i></button>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
                            + '</div></div>'
                            + '<div id="add-info-'
                            + item.id
                            + '"></div>'
                    });

                $('#coach-list').html(html);
            }
        });
}

/**
 * 滚动加载 小钲老弟？ 听说你很想用？？ 知道怎么用么？？？  你猜猜？？？？
 */
var addCoachLast = 0;
$(window).scroll(function () {
    var srollPos = $(window).scrollTop()+0.5;    //滚动条距顶部距离(页面超出窗口的高度)
    if (srollPos>=($(document).height()-$(window).height())) {
        goCount += 1;
        rowIndex = goCount * 8;
        var addCoachListUrl = '/coach/coachList?tagId='+tagId+'&rowIndex='+rowIndex+'&sortId='+sortId+'&coachName='+coachName;

        $.getJSON(
            addCoachListUrl,
            function (data) {
                if (data.code == "0") {
                    var addCoachList = data.data;
                    if (addCoachList == "") {
                        alert("已经加载全部教练！")
                    } else {
                        var html = '';
                        addCoachList
                            .map(function (item, index) {
                                addCoachLast = item.id;
                                html += '<div class="coach-card" style="width: 300px;height:auto;" href="coachPage?coachId='
                                    + item.id
                                    + '">'
                                    + '<div class="card card-product" href="coachPage?coachId='
                                    + item.id
                                    + '">'
                                    + '<div class="card-image" href="coachPage?coachId='
                                    + item.id
                                    + '"><a href="coachPage?coachId='
                                    + item.id
                                    + '"><img class="img" src="/images/coachList/blog04.jpeg" href="coachPage?coachId='
                                    + item.id
                                    + '"></a></div>'
                                    + '<div class="table" href="coachPage?coachId='
                                    + item.id
                                    + '">'
                                    + '<h6 class="category text-rose">'
                                    + item.count
                                    + '</h6>'
                                    + '<h4 class="card-caption">'
                                    + '<a href="coachPage?coachId='
                                    + item.id
                                    + '">'
                                    + item.name
                                    + '</a></h4>'
                                    + '<div class="card-description">'
                                    + item.desc
                                    + '</div>'
                                    + '<div class="ftr">'
                                    + '<div class="price" style="margin-top: 20px;margin-right: 130px;">'
                                    + '<h4>$'
                                    + item.price
                                    + '</h4></div>'
                                    + '<div class="stats" href="coachPage?coachId='
                                    + item.id
                                    + '">'
                                    + '<button type="button" rel="tooltip" title="" class="btn btn-just-icon"'
                                    + 'data-original-title="Saved to Wishlist"  href="coachPage?coachId='
                                    + item.id
                                    + '"><i class="glyphicon glyphicon-search"  href="coachPage?coachId='
                                    + item.id
                                    + '"></i></button>'
                                    + '</div>'
                                    + '</div>'
                                    + '</div>'
                                    + '</div>'
                                    + '</div>'
                                    + '<div id="add-info-'
                                    + item.id
                                    + '"></div>';
                            });
                        $('#add-info-' + lastCoachId + '').html(html);
                        lastCoachId = addCoachLast;
                    }
                }
            });
    }
});
