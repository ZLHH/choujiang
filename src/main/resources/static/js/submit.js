//签到
function qaindao() {
    var name = $("#name").val();
    var phone = $("#phone").val();
    var major = $("#major").val();
    if (name == null || name == ""){
        alert("请输入姓名");
        return null;
    }
    if (phone == null || phone == ""){
        alert("请输入手机号");
        return null;
    }
    if (major == null || major == ""){
        alert("请输入专业");
        return null;
    }
    $.ajax({
        url: '/people/save',
        type: 'post',
        dataType: "json",
        data: "name=" + name + "&phone=" + phone+"&major="+major,
        success: function (data) {
            if (data.code === 0) {
                alert("签到成功");
            } else {
                console.log(data);
                alert(data.msg);
            }
        }
    });
}