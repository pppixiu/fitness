/**
 * 全局通用数据
 */
var coachId;     //通用教练Id
var price = 0;   //通用选择时段个数
var onlineTime;  //存储当前在线课程选课时段
var userId;      //通用userId

/**
 * 初始化加载
 */
$(function () {
    header();
    var result = getQueryVariable("coachId");
    getUserId();
    coachId = result;
    coachInfo(result);
    likefuncation();
});

/**
 * 获取登录用户的id
 */
function getUserId() {
    var headerUrl ='/header/sessionInfo';
    $.getJSON(
        headerUrl,
        function (data) {
            var imghtml='';
            var info = data;
            if(info==''){
                alert('没有获取到登录信息');
            }else {
                userId = info.userId;
                return info.userId;
            }
        });
}

/**
 * 获取传参coachId
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
 * 获取教练基本参数
 * @param e
 */
function coachInfo(e) {
    var id = e;
    var coachInfoUrl = '/coach/coachShow?coachId='+id;
    var coachBlogUrl = '/blog/getuserblogbyuserid?pageIndex=0&pageSize=3&userId='+id;
    var coachCourseUrl = '/coach/coachCourse?coachId='+id;
    var coachImageUrl = '/coach/coachImage?coachId='+id;
    var coachCountUrl = '/coach/coachLikeCount?coachId=' + id + '&userId=' + userId;

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

    /*判断颜色*/
    var colorJudge;
    $.getJSON(
        coachCountUrl,
        function (data) {
            if (data.code == "0") {
                var info = data.data;
                colorJudge = info.judge;
                if(colorJudge == 1){
                    $('#control-color').css("color","Red")
                }else if(colorJudge == 0){
                    $('#control-color').css("color","black")
                }
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
                            + '<div class="table" style=" min-height: 230px; max-height: 230px; width: 230px; overflow: hidden;">'
                            + '<h3 class="card-caption">BLOG</h3>'
                            + '<p class="card-description">'
                            + item.blogContent
                            + '</p>'
                            + '<a href="/blog/blogcomment?blogId='
                            + item.blogId
                            + '&userId='
                            + id
                            +'" class="btn btn-danger btn-round"> <i class="fa fa-align-left"></i> 查看详情 </a>'
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
                            + '<div class="card card-background" style="background-image: url('
                            + item.imageUrl
                            + ')">'
                            + '<div class="table" style=" min-height: 230px; max-height: 230px; width: 230px;  overflow: hidden;">'
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
                            + '<div class="table" style="overflow: hidden;  max-height: 230px; min-height: 230px; width: 230px; ">'
                            + '<h6 class="category text-info">COURSE</h6>'
                            + '<h3 class="card-caption">'
                            + item.title
                            + '</h3>'
                            + '<a href="/course/courseInfo?courseId='
                            + item.id
                            + '" class="btn btn-danger btn-round"> <i class="fa fa-align-left"></i> 查看详情 </a>'
                            + '</div> </div> </div>'
                    });
                $('#course-show').html(coursehtml);
            }
        });
    loadComment(id);
}

/**
 * 加载评论，由于用户可评论的特殊性，单独调用
 */
function loadComment(id) {
    var coachCommentUrl = '/comment/coachcommentlist?refId='+id;
    /*加载评论*/
    $.getJSON(
        coachCommentUrl,
        cache = false,
        function (data) {
            if (data.code == "0") {
                var commentList = data.data;
                var commenthtml = '';
                commentList
                    .map(function (item, index) {
                        commenthtml += '<div class="col-md-12" style="height: 50px; margin-top: 10px; border-bottom:2px solid #d9dde1;">'
                            + '<h4 style="display: inline-block; width: 1000px; overflow: hidden;   text-overflow:ellipsis;'
                            + 'word-break:keep-all;  white-space:nowrap; max-height: 30px; color: #1e88e5">@.'
                            + item.user.username
                            + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
                            + '<a style="width: 800px;color: black;">'
                            + item.content
                            + '</a></h4>'
                            + '<button type="button" class="pull-right btn btn-primary btn-lg"'
                            + 'style="display: inline-block; margin-bottom: 25px; color: #999999;">'
                            + '<span class="glyphicon glyphicon-heart-empty"></span>'
                            + '9866'
                            + '</button></div>'
                    });
                $('#comment-show').html(commenthtml);
            }
        });
}

/**
 * 点赞、关注加收藏
 */
function likefuncation() {
    var liketimes;
    var coachLikeCountUrl = '/coach/coachLikeCount?coachId=' + coachId + '&userId=' + userId;

    /*加载基本信息*/
    $.getJSON(
        coachLikeCountUrl,
        function (data) {
            if (data.code == "0") {
                var info = data.data;
                likecount = info.count;
                liketimes = info.judge;
                if(liketimes == 1){
                    $('#coach-count').text($('#coach-count').text()*1+1);
                    $('#control-color').css("color","Red")
                }else if(liketimes == 0){
                    $('#coach-count').text($('#coach-count').text()*1-1);
                    $('#control-color').css("color","black")
                }
            }
    });
}

/**
 * 支付宝支付
 */
function alipayOnline(action) {
    document.getElementById("form").action = action;
    $('#coachId').val(coachId);
    $('#timeBucket').val(onlineTime);
    $('#totalMoney').val(online(price));
    $('#persistTime').val(price);
    document.getElementById("form").submit();
}

/**
 * 判断时间(暂做参考，不调用)
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
 * 判断时间选择框是否在当前时间段内
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
    var onlineCoachTime = '';
    var pcs = 0;
    var input = document.getElementsByName("frame");
    for(var i =0;i<input.length;i++){
      if (input[i].checked == true){
          onlineCoachTime += input[i].value+'|';
          pcs += 1;

      }
    }
    onlineTime = onlineCoachTime;
    price = pcs;
    $('#exampleInputTime').val('您共选择'+pcs+'小时课程');
    $('#closemodel').click();
    online(pcs);
}

/**
 * 添加评论
 */
function addComment() {
    var content = $('#coach-content').val();
    var addContentUrl = '/coach/addCoachComment?content=' + content + '&coachId=' + coachId;

    $.getJSON(
        addContentUrl,
        function (data) {
            if (data.code == "0") {
                if(data.data == null){
                    alert("评论失败，请关注教练！");
                }else {
                    var info = data.data;
                    alert("添加成功！");
                    loadComment(coachId);
                }
            }
        });
}

/**
 * 加载当前用户登录信息
 */
function header() {
    var headerUrl = '/header/sessionInfo';
    $.getJSON(
        headerUrl,
        function (data) {
            var imghtml = '';
            var offhtml = '';
            var info = data;
            if (info == '') {
                alert('没有获取到登录信息');
            } else {
                imghtml += '<img style="border-radius: 50px;width: 40px;height: 40px;position: absolute;top: -30px; margin-left: 10px; margin-right: " src="'
                    + info.userImageUrl
                    + '" onclick="window.open('
                    + "'"
                    + '/user/selfcourse?userId='
                    + info.userId
                    + "'"
                    + ')">';
                offhtml += '<a onclick="quitUser();" style="margin-left: 20px;" id="write-off" href="#" onmouseover="this.style.color='
                    + "'"
                    + '#b8d8ba'
                    + "'"
                    + ' "onmouseout="this.style.color='
                    + "'"
                    + '#ffffff'
                    + "'"
                    + '">注销</a>';
                $('#user-img').html(imghtml);
                $('#write-off').html(offhtml);
            }
        });
}

/**
 * 注销用户
 */
function quitUser() {
    var quitUrl='/header/quitUser';

    if(confirm("是否要注销用户?")==true){
        $.getJSON(quitUrl);
        window.location.href="/index";
    }
}