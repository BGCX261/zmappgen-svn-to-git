#set( $serviceObj = ${stringUtils.uncapitalize($serviceClassname)} )
#set( $entityObj = ${stringUtils.uncapitalize($entityClassname)} )

<%@ page contentType="text/html;charset=UTF-8"
	import="java.util.*,
com.zoom.appcore.web.jsp.WebUtil,
	${entityPackage}.${entityClassname},
${servicePackage}.${serviceClassname}"%>
<%
	//ʹ��Spring ApplicationContext�е�UserService��ѯ�û��б�.
		${serviceClassname} service = (${serviceClassname}) WebUtil.getBean(application, "${serviceObj}");
${entityClassname} ${entityObj} = service.get${entityClassname}(

#foreach(${pk} in ${table.primaryKeys})
#if(!${foreach.first}) , #end
${pk.attributeType}.valueOf(request.getParameter("${pk.attributeName}"))
#end
);
	//����ѯ�������pageContext(page scope),��JSTL����.
	pageContext.setAttribute("${entityObj}", ${entityObj});
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�û�����</title>
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