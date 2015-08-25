<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
#set( $entityObj = ${stringUtils.uncapitalize($entityClassname)} )

<title>${table.tableDescription}管理</title>
<%@ include file="/common/meta.jsp"%>
</head>

<body>
<div id="menu">
<h3>${table.tableDescription}列表</h3>
</div>

<div id="message"><s:actionmessage theme="mytheme"/></div>

<div id="content">
<table class="listView">
	<tr>

	#foreach(${_col} in ${table.columns})
	<th><a href="${ctx}/${entityObj}/${entityObj}.action?page.orderBy=${_col.attributeName}&page.order=
		<s:if test="page.orderBy=='${_col.attributeName}'">${page.inverseOrder}</s:if><s:else>desc</s:else>
		"><b>${_col.description}</b></a></th>
#end
		<th><b>操作</b></th>
	</tr>

	<s:iterator value="page.result">
		<tr>
			#foreach(${_col} in ${table.columns})
  			<td>${${_col.attributeName}} &nbsp;</td>
#end
			<td>&nbsp; 
				<a href="${entityObj}!input.action?id=${id}">修改</a>、
				<a href="${entityObj}!delete.action?id=${id}">删除</a>
			</td>
		</tr>
	</s:iterator>
</table>
</div>

<div id="footer" style="margin-top:10px">
	第${page.pageNo}页, 共${page.totalPages}页 
	<s:if test="page.hasPre">
		<a href="${entityObj}.action?page.pageNo=${page.prePage}&page.orderBy=${page.orderBy}&page.order=${page.order}">上一页</a>
	</s:if>
	<s:if test="page.hasNext">
		<a href="${entityObj}.action?page.pageNo=${page.nextPage}&page.orderBy=${page.orderBy}&page.order=${page.order}">下一页</a>
	</s:if>

	<a href="${entityObj}!input.action">新增</a>

</div>

</body>
</html>
