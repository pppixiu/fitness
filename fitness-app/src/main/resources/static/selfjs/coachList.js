/**值的初始化*/
var tagId = 0;
var rowIndex = 0;
var sortId = 0;
var coachName = 'empty';
var tagList;
var goCount = 0;

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
    goCount += 8;
    rowIndex = goCount;
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
    var coachListUrl = '/coach?tagId='+tagId+'&rowIndex='+rowIndex+'&sortId='+sortId+'&coachName='+coachName;
    var url = coachListUrl;

    $.getJSON(
        url,
        function (data) {
            if (data.code == "0") {
                var coachList = data.data;
              /*  if(nextCoach == ""){
                    nextCoach = coachList;
                }else{
                    $.extend(true,coachList,nextCoach);
                }*/
                var html = '';
                coachList
                    .map(function (item, index) {
                        html += '<div style="width: 300px;height:auto;" href="coachPage.html?coachId='
                            + item.id
                            + '">'
                            + '<div class="card card-product">'
                            + '<div class="card-image">'
                            + '<a href="coachPage.html?coachId='
                            + item.id
                            +'"> <img class="img" src="images/coachList/blog04.jpeg"> </a></div>'
                            + '<div class="table">'
                            + '<h6 class="category text-rose">'
                            + item.count
                            + '</h6>'
                            + '<h4 class="card-caption">'
                            + '<a href="coachPage.html?coachId='
                            + item.id
                            + '">'
                            + item.name
                            + '</a></h4>'
                            + '<div class="card-description">'
                            + item.desc
                            + '</div>'
                            + '<div class="ftr">'
                            + '<div class="price">'
                            + '<h4>$'
                            + item.price
                            + '</h4></div>'
                            + '<div class="stats">'
                            + '<button type="button" rel="tooltip" title="" class="btn btn-just-icon btn-simple btn-warning"'
                            + 'data-original-title="Saved to Wishlist"><i class="fa fa-shopping-cart"></i></button>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
                    });
                $('#coach-list').html(html);
            }
        });
}