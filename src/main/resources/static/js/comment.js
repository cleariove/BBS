
function insertComment() {
    var topicId = document.getElementById("topicId").value;
    var commentContent = document.getElementById("commentContent").value;
    var commentTo = document.getElementById("topicManager").value;
    var date = getDate();
    var data={
        "commentId":"",
        "commentFrom":"",
        "commentTo":commentTo,
        "content":commentContent,
        "date":date,
        "topicId":topicId
    };
    $.ajax({
        url:"/comment",
        data:JSON.stringify(data),
        contentType : "application/json",              //发送至服务器的类型                                      
        type:"post",
        success:function () {
           window.location.reload();
        },
        error:function () {
          alert("错误")
        }
    });

}