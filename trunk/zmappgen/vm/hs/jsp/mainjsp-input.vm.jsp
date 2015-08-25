#set( $entityObj = ${stringUtils.uncapitalize($entityClassname)} )

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${table.tableDescription}管理</title>
<%@ include file="/common/meta.jsp"%>

<link href="${ctx}/js/validate/jquery.validate.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/js/validate/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/js/validate/messages_cn.js" type="text/javascript"></script>


</head>

<body>
<div id="content">
<h3><s:if test="id == null">创建</s:if><s:else>修改</s:else>${table.tableDescription}</h3>
<form id="inputForm" action="${entityObj}!save.action" method="post">
<input type="hidden" name="id" value="${id}" />
<table class="inputView">

#foreach(${_col} in ${table.columns})
 #if($_col.attributeName != "id")
	<tr>
		<td>${_col.description}:</td>
		<td><input type="text" name="${_col.attributeName}" id="${_col.attributeName}" value="${${_col.attributeName}}" /></td>
	</tr>
 #end
#end
	<tr>
		<td colspan="2">
			<input type="submit" value="提交" />&nbsp; 
			<input type="button" value="取消" onclick="history.back()"/>
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>