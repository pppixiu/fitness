
/*function phonefunction() {
    phone = document.getElementById('phone').value;
    authNumberUrl = '/login/code?phone='+phone;
}*/
function phonefunction() {
     // var phone = document.getElementById('phone').val();
    var phone = $('#phone').val();
    $.ajax({
        type: "POST",
        async:false,
        url: "/login/code",
        data: {phone:phone},
        dataType: "json",
        success: function(data){
            //data就是返回的数据
            if(data==null){
                console.log(data)

            }
        }
    });
}

function buttonfunction() {
    var phone = $("#phone").val();
    var smsCode = $("#smsCode").val();
    $.ajax({
        type: "POST",
        async:false,
        url: "/login/judge",
        data: {phone:phone,smsCode:smsCode},
        dataType: "json",
        success: function(data){
            //data就是返回的数据
            if(data.code=="0"){
                window.location.replace("http://localhost:8080/index");
            }else {
                window.location.href = "http://localhost:8080/login";
            }
        }
    });
}
