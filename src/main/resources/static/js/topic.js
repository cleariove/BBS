var xmlHttp = false;
var ifHelp=false;
var topicType;

function initAJAX() {
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                window.alert("不支持ajax")
            }
        }
    }
}

function getTopicType(type) {
    topicType = type.innerText;
    if (topicType == "Question") {
        document.getElementById("setting").innerHTML = "<div class=\" form-default\">\n" +
            "        <div class=\"form-group\">\n" +
            "        <input name=\"settingIntegral\" class=\"form-control\" placeholder=\"设置积分\" rows=\"1\">\n" +
            "        </div>\n" +
            "        </div>"
    }
    else {
        document.getElementById("setting").innerHTML="";
    }


}

function getTopic() {

    var topicId =document.getElementById("topicId").value;
    var title = document.getElementById("title").value;
    var content =  document.getElementById("content").value;
    var subItemId = document.getElementById("subItemId").value;
    var type=topicType
    var integral;
    alert(type);
    if(type=="Question"){
        var strValue = [];
        $(".settingIntegral").each(function () {
            var value = $(this).val();
            strValue.push(value);
        });
        ifHelp=true;
        alert(strValue);
    }else {
        ifHelp=false;
        integral=10;
        alert(integral)
    }




    var date=getDate();

    var data={
        "topicId":topicId,
        "title":title,
        "content":content,
        "manager":"",
        "date":date,
        "browse":"111",
        "integral":integral,
        "help":ifHelp,
        "elite":false,
        "onpageTop":false,
        "subItemId":subItemId
    };
    return JSON.stringify(data);
}

function createTopic() {

    var title = document.getElementById("title").value;
    var content =  document.getElementById("content").value;
    var subItemId = document.getElementById("subItemId").value;
    var type=topicType;
    var integral;
    if(type=="Question"){

        integral = -(document.getElementsByName("settingIntegral")[0].value);
        ifHelp=true;

    }else {
        ifHelp=false;
        integral=10;

    }
    var date=getDate();

    var data={
        "topicId":"",
        "title":title,
        "content":content,
        "manager":"",
        "date":date,
        "browse":"0",
        "integral":integral,
        "help":ifHelp,
        "elite":false,
        "onPageTop":false,
        "subItemId":subItemId
    };

    $.ajax({
        url:"/topic/createTopic",
        data:JSON.stringify(data),
        contentType : "application/json",              //发送至服务器的类型   
        dataType : "json",                                     //预期服务器返回类型  
        type:"post",
        success:function (data) {
            if(data.result == "OK") {
                alert("文章发表成功");
                window.location.href = "/topic?subItemId=" + subItemId
            }

        }
    });

}

function deleteTopic() {
    var topicId =document.getElementById("topicId").value;

    $.ajax({
        url:"/topic/delete/"+topicId,
        data:{},
        contentType : "application/json",              //发送至服务器的类型   
        dataType : "json",                                     //预期服务器返回类型  
        type:"GET",
        success:function (data) {
            alert(data);
        }
    });
}



/**
 * yyyy-MM-dd HH:mm:ss
 */
function getDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    //外国的月份都是从0开始的，所以+1
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    //1-9月用0补位
    if(month >=1 && month <=9){
        month = "0" + month;
    }
    //1-9日用0补位
    if(strDate >=0 && strDate <= 9){
        strDate = "0" + strDate;
    }
    //获取当前时间 yyyy-MM-dd HH:mm:ss
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate + " " +date.getHours() + seperator2 + date.getMinutes() + seperator2 + date.getSeconds();
    return currentdate;
}

function updateTopic() {

    var topicId =document.getElementById("topicId").value;
    var title = document.getElementById("title").value;
    var content =  document.getElementById("content").value;
    var subItemId = document.getElementById("subItemId").value;
    var manager= document.getElementById("manager").innerText;
    var date=getDate();

    var data={
        "topicId":topicId,
        "title":title,
        "content":content,
        "manager":manager,
        "date":date,
        "browse":"",
        "integral":"",
        "help":topicType,
        "elite":false,
        "onpageTop":false,
        "subItemId":subItemId
    };

    $.ajax({
        url:"/topic/update",
        data:JSON.stringify(data),
        contentType : "application/json",              //发送至服务器的类型   
        dataType : "json",                                     //预期服务器返回类型  
        type:"post",
        success:function (data){
            if(data.result == "OK")
                alert("修改成功");

        }
    });

}

function topicList() {
    $.ajax({
        url:"/topic/update",
        data:data,
        contentType : "application/json",              //发送至服务器的类型   
        dataType : "json",                                     //预期服务器返回类型  
        type:"post",
        success:function (data) {
            // $("#div1").html(data);
        }
    });
    
}



function addBrowse(topicId) {
    $.ajax({
        url:"/topic/updateBrowse/"+topicId,
        data:{},
        contentType : "application/json",              //发送至服务器的类型   
        dataType : "json",                                     //预期服务器返回类型  
        type:"GET",
        success:function (data) {
        }
    });
    
}

function unLogin(){
    alert("请先登入");
}

