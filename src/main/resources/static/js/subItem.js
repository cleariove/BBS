// function manageSubItem(subItemId)
// {
//     location.href="/subItem/manage?subItemId="+subItemId;
// }

function getItem(itemId)
{
    $.ajax(
        {
            data:{"itemId":itemId},
            type:"post",
            url:"/subItem/getItem",
            success:function ()
            {

            },
            error:function ()
            {

            }
        }
    )
}

function clickSubInputFile()
{
    document.getElementById("subItemFile").click();
}

function checkImgType(element)
{
    if (element.value == "")
    {
        alert("请上传图片");
        return false;
    }
    else
    {
        if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(element.value))
        {
            alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
            element.value = "";
            return false;
        }
    }
    return true;
}

function uploadSubItemIcon(subItemId)
{
    if(checkImgType(document.getElementById("subItemFile")))
    {
        var formData = new FormData();
        formData.append("subItemId",subItemId);
        //这个地方$("#file")得到的是jquery对象，变为$("#file")[0]后为dom对象
        formData.append("subItemFile",$("#subItemFile")[0].files[0]);
        $.ajax(
            {
                data:formData,
                type:"post",
                url:"/subItem/upload",
                processData: false,
                contentType: false,
                success:function ()
                {
                    location.reload();
                },
                error:function ()
                {
                    alert("未知错误");
                }
            }
        )}
}

function deleteSubItem(subItemId)
{
    if(confirm("删除后无法找回！是否删除？"))
    {
        $.ajax(
            {
                url:"/subItem/delete",
                data:{"subItemId":subItemId},
                type: "post",
                success:function (data)
                {
                    location.href = data;
                },
                error:function ()
                {
                    alert("未知错误");
                }
            }
        )
    }
}

function updateSubItem(subItemId)
{
    let jsonData =
        {
            "subItemId":subItemId,
            "subItemName":$("#subItemName").val(),
            "subItemDescription":$("#subItemDescription").val(),
            "itemId":$("#itemId").val(),
            "manager":$("#subItemManager").val(),
        };
    // "manager":$("#subItemManager").val(),
    // "itemId":$("#itemId").val(),
    // if(jsonData.subItemDescription !== '' && jsonData.subItemName !== '')
    // {
        $.ajax(
            {
                type:"post",
                url:"/subItem/update",
                data:jsonData,
                success:function (data)
                {
                    location.href = data;
                },
                error:function ()
                {
                    alert("未知错误");
                }
            }
        )
    // }
}

function insertSubItem(id)
{
    var subItemName = $("#subItemName").val();
    var subItemDescription = $("#subItemDescription").val();
    var itemId=$("#itemId").val();
    if(subItemDescription !== '' && subItemName !== '')
    {
        $.ajax(
            {
                type:"post",
                url:"/subItem/insert",
                data:
                    {
                        "subItemName":subItemName,
                        "subItemDescription":subItemDescription,
                        "manager":id,
                        "itemId":itemId,
                    },
                success:function (data)
                {
                    location.href = data;
                },
                error:function ()
                {
                    alert("未知错误");
                }
            }
        )
    }
    else
    {
        alert("请填写完整名称与简介")
    }
}

function pushSubItem(subItemId,url)
{
    let jsonData =
        {
            "subItemId":subItemId,
            "subItemName":$("#subItemName").val(),
            "subItemDescription":$("#subItemDescription").val(),
            "manager":$("#subItemManager").val(),
            "itemId":$("#itemId").val(),
        };
    if(jsonData.subItemDescription !== '' && jsonData.subItemName !== '')
    {
        $.ajax(
            {
                type:"post",
                url:url,
                data:jsonData,
                success:function (data)
                {
                    location.href = data;
                },
                error:function ()
                {
                    alert("未知错误");
                }
            }
        )
    }
}