<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>${obj.tableDescription}管理</title>
<%@ include file="/common/meta.jsp"%>

<!-- calendar-->
<link rel="stylesheet" type="text/css" media="all" href="${ctx}/js/calendar/calendar-win2k-1.css" />
<script type="text/javascript" src="${ctx}/js/calendar/calendar.js"></script>
<script type="text/javascript" src="${ctx}/js/calendar/lang/calendar-en.js"></script>
<script type="text/javascript" src="${ctx}/js/calendar/calendar-setup.js"></script>

</head>

<body>
<div id="menu">
<h3>${obj.tableDescription}列表</h3>
</div>

<div id="message"><s:actionmessage theme="mytheme"/></div>

<div id="content">

<form id="inputForm" action="${lobjname}!filterQuery.action" method="post">
<table class="inputView">

	<tr>
		<td>
		  过滤字段:
		 </td>
		 <td>
		  <select name="filterAttribute" id="filterAttribute" onChange="changeFilterAttribute(this.options[this.options.selectedIndex].value)" >
		 
              <option value=" ">--请选择--</option>
			#foreach(${_col} in ${obj.metaDatas})
			 #if($_col.attributeName != "id")
              <option value="${_col.description}">${_col.description}</option>
			 #end
			#end
		  </select>		
		</td>
		<td>
			过滤条件:
		</td>
		<td>
#foreach(${_col} in ${obj.metaDatas})
#if($_col.attributeName != "id")
		  #if($_col.viewType == "date")
			  <input type="text" name="${_col.attributeName}" id="${_col.attributeName}" value="${${_col.attributeName}}" readonly style="display:none" />
				<script type="text/javascript">
					Calendar.setup({
					inputField     :    "${_col.attributeName}",
					ifFormat       :    " %Y-%m-%d",
					button         :    "${_col.attributeName}"
					});
				</script>
		  #elseif($_col.viewType == "select")
			  <select name="${_col.attributeName}" id="${_col.attributeName}" value="${${_col.attributeName}}" style="display:none" >
				#foreach(${_enumValue} in ${_col.enumValues})
				  <option value=${_enumValue.enkey}>${_enumValue.envalue}</option>
				#end
			  </select>		
		  #else
			 <input type="text" name="${_col.attributeName}" id="${_col.attributeName}" value="${${_col.attributeName}}" style="display:none" />
		  #end
#end
#end
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" id="filterSubmit" name="filterSubmit" value="过滤" disabled />&nbsp;
		</td>
	</tr>
</table>
</form>

<!-- ************************************** -->
<table class="listView">
	<tr>

	#foreach(${_col} in ${obj.metaDatas})
	<th><a href="${ctx}/${lobjname}/${lobjname}.action?page.orderBy=${_col.attributeName}&page.order=
		<s:if test="page.orderBy=='${_col.attributeName}'">${page.inverseOrder}</s:if><s:else>desc</s:else>
		"><b>${_col.description}</b></a></th>
#end
		<th><b>操作</b></th>
	</tr>

	<s:iterator value="page.result">
		<tr>
			#foreach(${_col} in ${obj.metaDatas})
  			<td>${${_col.attributeName}} &nbsp;</td>
#end
			<td>&nbsp; 
				<a href="${lobjname}!input.action?id=${id}">修改</a>、
				<a href="${lobjname}!delete.action?id=${id}">删除</a>
			</td>
		</tr>
	</s:iterator>
</table>
</div>

<div id="footer" style="margin-top:10px">
	第${page.pageNo}页, 共${page.totalPages}页 
	<s:if test="page.hasPre">
		<a href="${lobjname}.action?page.pageNo=${page.prePage}&page.orderBy=${page.orderBy}&page.order=${page.order}">上一页</a>
	</s:if>
	<s:if test="page.hasNext">
		<a href="${lobjname}.action?page.pageNo=${page.nextPage}&page.orderBy=${page.orderBy}&page.order=${page.order}">下一页</a>
	</s:if>

	<a href="${lobjname}!input.action">新增</a>

</div>

</body>

<SCRIPT LANGUAGE="JavaScript">
<!--

function changeFilterAttribute(aDivName) {

#foreach(${_col} in ${obj.metaDatas})
 #if($_col.attributeName != "id")
    if(document.getElementById('${_col.description}')){
		//隐藏
	    document.getElementById('${_col.description}').style.display = "none";
		//清空值
		document.getElementById('${_col.description}').value="";
	}
 #end
#end
  if(document.getElementById(aDivName)){
 	document.getElementById(aDivName).style.display = "block";
  }

	if(aDivName!=" "){
		document.getElementById("filterSubmit").disabled = false;
	}else{
		document.getElementById("filterSubmit").disabled = true;
	}

}

//-->
</SCRIPT>
</html>
