var XMLHttpReq;

function createXMLHttpRequest()
{
name=document.getElementById("userName").value

   if(window.ActiveXObject)
      {
      XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");  
      }
      XMLHttpReq.open("POST","Validate.do",true);
      XMLHttpReq.onreadystatechange=handleRespose;
      XMLHttpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");

      XMLHttpReq.send("name="+name);
}

function handleRespose()
{

   if(XMLHttpReq.readyState == 4)
      if(XMLHttpReq.status == 200)
      {
      ms=XMLHttpReq.responseText;
         document.getElementById("div1").innerHTML=ms;
         
      }
}

