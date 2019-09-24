var coachId;
var price = 0;
$(function () {
    var result = getQueryVariable("coachId");
    coachId = result;
    coachInfo(result);
});

/**
 * 获取传参
 * @param variable
 * @returns {*}
 */
function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}

/**
 * 获取参数
 * @param e
 */
function coachInfo(e) {
    var id = e;
    var coachInfoUrl = '/coach/coachShow?coachId='+id;
    var coachBlogUrl = '/blog/getuserblogbyuserid?pageIndex=0&pageSize=3&userId='+id;
    var coachCourseUrl = '/coach/coachCourse?coachId='+id;
    var coachImageUrl = '/coach/coachImage?coachId='+id;

    /*加载基本信息*/
    $.getJSON(
        coachInfoUrl,
        function (data) {
            if (data.code == "0") {
                var info = data.data;
                likecount = info[0].count;
                $('#coach-name').text(info[0].coachname);
                $('#coach-desc').text(info[0].coachdesc);
                $('#coach-count').text(info[0].count);
                $('#exampleInputName').val(info[0].coachname);
                $('#exampleInputPrice').val(info[0].price);
            }
        });

    /*加载博客*/
    $.getJSON(
        coachBlogUrl,
        function (data) {
            if (data.code == "0") {
                var blogList = data.data;
                var bloghtml = '';
                blogList
                    .map(function (item, index) {
                        bloghtml += '<div class="col-md-4" style="overflow: hidden;">'
                            + '<div class="card card-background" style="background-image:  url('
                            +  item.imageUrl
                            + ')">'
                            + '<div class="table" style=" min-height: 230px; max-width: 230px; overflow: hidden;">'
                            + '<h3 class="card-caption">BLOG</h3>'
                            + '<p class="card-description">'
                            + item.blogContent
                            + '</p>'
                            + '<a href="#" class="btn btn-danger btn-round"> <i class="fa fa-align-left"></i> 查看详情 </a>'
                            + '</div> </div> </div>';
                    });
                $('#blog-show').html(bloghtml);
            }
        });

    /*加载图片*/
    $.getJSON(
        coachImageUrl,
        function (data) {
            if (data.code == "0") {
                var imageList = data.data;
                var imagehtml = '';
                imageList
                    .map(function (item, index) {
                        imagehtml += '<div class="col-md-4">'
                            + '<div class="card card-background" style="background-image: url("images/blog07.jpg")">'
                            + '<div class="table" style=" min-height: 230px; max-width: 230px;  overflow: hidden;">'
                            + '</div> </div> </div>'
                    });
                $('#image-show').html(imagehtml);

            }
        });

    /*加载课程*/
    $.getJSON(
        coachCourseUrl,
        function (data) {
            if (data.code == "0") {
                var courseList = data.data;
                var coursehtml = '';
                courseList
                    .map(function (item, index) {
                        coursehtml += '<div class="col-md-4" style="overflow: hidden">'
                            + '<div class="card card-background" style="background-image: url('
                            + item.url
                            + ')">'
                            + '<div class="table" style="overflow: hidden;  min-height: 230px; max-width: 230px; ">'
                            + '<h6 class="category text-info">COURSE</h6>'
                            + '<h3 class="card-caption">'
                            + item.title
                            + '</h3>'
                            + '<a href="#" class="btn btn-danger btn-round"> <i class="fa fa-align-left"></i> 查看详情 </a>'
                            + '</div> </div> </div>'
                    });
                $('#course-show').html(coursehtml);
            }
        });
}

/**
 * 点赞、关注加收藏
 * */
var liketimes=1;
function likefuncation() {
    var coachLikeCountUrl = '/coach/coachLikeCount?coachId=' + coachId + '&likeJudge=' + liketimes;
    if(liketimes == 1){
        liketimes = -1;
        $('#coach-count').text($('#coach-count').text()*1+1);
    }else{
        liketimes = 1;
        $('#coach-count').text($('#coach-count').text()*1-1);
    }

    /*加载基本信息*/
    $.getJSON(
        coachLikeCountUrl,
        function (data) {
            if (data.code == "0") {
                var info = data.data;
                likecount = info.count;
                $('#coach-count').text(info.count);
            }
        });
}

/**
 * 支付宝支付
 */
function alipayOnline(action) {
    document.getElementById("form").action = action;
    $('#outTradeNo').val(generateTimeReqestNumber());
    $('#subject').val($('#exampleInputName').text() + "在线教练课程");
    $('#totalAmount').val(online(price));
    $('#body').val("NICEBODY在线教练课程");
    document.getElementById("form").submit();
}


/**
 * 判断时间
 * @param beginTime
 * @param endTime
 * @param nowTime
 * @returns {boolean}
 */
function time_range(hour, startTime) {
    var strb = hour.split ("点");
    if (strb.length != 1) {
        return false;
    }

    var stre = startTime.split (":");
    if (stre.length != 2) {
        return false;
    }

    var b = new Date ();
    var e = new Date ();
    var n = new Date ();

    b.setHours (strb[0]);
    b.setMinutes ("00");
    b.setSeconds("00");
    alert(b);
    e.setHours (stre[0]);
    e.setMinutes (stre[1]);
    e.setSeconds("00");
    alert(c);
    alert(n);

    if(b.getHours() - n.getHours() < 0){

    }
    if(e.getTime() - n.getTime() < 0){
        alert ("当前时间是：" + n.getHours () + ":" + n.getMinutes () + ":"+n.getSeconds()+"，不在该时间范围内！");
        return false;
    }
}

/**
 * 隐藏时间选择框
 *
 */
var time = new Date();
function hiddenhour() {
    //var onlineCourseUrl = '';
    var hour = document.getElementsByName("frame");
   /* $.getJSON(
        onlineCourseUrl,
        function (data) {
            if (data.code == "0") {
                var val = data.data;
                for (var i = 0;i<val.length;i++) {
                    for (var j = 0; j < hour.length; j++) {
                        var stb = hour[j].value;
                        if (stb == val[i].create_time) {
                            hour[i].disabled = "disabled";
                        }
                        if (stb < time.getHours()){
                            hour[i].disabled = "disabled";
                        }
                    }
                }
            }
        });*/

    for(var i =0;i<hour.length;i++){
        var stb = hour[i].value;
        if(stb < time.getHours()) {
            hour[i].checked = "";
            hour[i].disabled = "disabled";
        }
    }
}

/**
 * 判断选择的时间框，并返回初始时间数据
 * @type {number}
 */

function selectPcs() {
    var pcs = 0;
    var input = document.getElementsByName("frame");
    for(var i =0;i<input.length;i++){
      if (input[i].checked == true){
          pcs += 1;
      }
    }
    price = pcs;
    $('#exampleInputTime').val('您共选择'+pcs+'小时课程');
    $('#closemodel').click();
    online(pcs);
}
