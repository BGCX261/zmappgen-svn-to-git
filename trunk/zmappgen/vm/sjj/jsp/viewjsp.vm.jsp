#set( $serviceObj = ${stringUtils.uncapitalize($serviceClassname)} )
#set( $entityObj = ${stringUtils.uncapitalize($entityClassname)} )

<%@ page contentType="text/html;charset=UTF-8"
	import="java.util.*,
com.zoom.appcore.web.jsp.WebUtil,
	${entityPackage}.${entityClassname},
${servicePackage}.${serviceClassname}"%>
<%
	//使用Spring ApplicationContext中的UserService查询用户列表.
		${serviceClassname} service = (${serviceClassname}) WebUtil.getBean(application, "${serviceObj}");
${entityClassname} ${entityObj} = service.get${entityClassname}(

#foreach(${pk} in ${table.primaryKeys})
#if(!${foreach.first}) , #end
${pk.attributeType}.valueOf(request.getParameter("${pk.attributeName}"))
#end
);
	//将查询结果放入pageContext(page scope),供JSTL访问.
	pageContext.setAttribute("${entityObj}", ${entityObj});
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@ include file="/meta.jsp"%>
</head>
<body>
<table cellspacing="0" cellpadding="1" border="1px">
	<tr>
	#foreach(${_col} in ${table.columns})
  <th><b>${_col.description}</b></th>
#end
	</tr>
	<tr>
			#foreach(${_col} in ${table.columns})
  			<td>${ ${entityObj}.${_col.attributeName} } &nbsp;</td>
#end
	</tr>
</table>
</body>
</html>