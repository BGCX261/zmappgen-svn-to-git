#set( $serviceObj = ${stringUtils.uncapitalize($serviceClassname)} )
#set( $entityObj = ${stringUtils.uncapitalize($entityClassname)} )
#set( $entityObjList = ${entityObj} + "List" )

<%@ page contentType="text/html;charset=UTF-8"
    import="java.util.*,
com.zoom.appcore.web.jsp.WebUtil,
${entityPackage}.${entityClassname},
${servicePackage}.${serviceClassname}"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    ${serviceClassname} service = (${serviceClassname}) WebUtil.getBean(application, "${serviceObj}");
    Collection<${entityClassname}> ${entityObjList} = service.getAll${entityClassname}();
    pageContext.setAttribute("${entityObjList}", ${entityObjList});
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${table.tableDescription}����</title>
<%@ include file="/meta.jsp"%>
</head>

<body>
<div id="content">
<h2>${table.tableDescription}�б�</h2>
<div id="list">
<table cellspacing="0" cellpadding="1" border="1px">
    <tr>
#foreach(${_col} in ${table.columns})
      <th><b>${_col.description}</b></th>
#end
      <th><b>����</b></th>
    </tr>

<c:forEach items="${ ${entityObjList} }" var="_item">
    <tr>
#foreach(${_col} in ${table.columns})
      <td>${ _item.${_col.attributeName} } &nbsp;</td>
#end
      <td><a href="${oid}View.jsp?
#foreach(${pk} in ${table.primaryKeys})
#if(!${foreach.first})&#end
${pk.attributeName}=${ _item.${pk.attributeName} }
#end
">�鿴</a>�� <a href="${oid}Action.jsp?action=delete&
#foreach(${pk} in ${table.primaryKeys})
#if(!${foreach.first})&#end
${pk.attributeName}=${ _item.${pk.attributeName} }
#end
">ɾ��</a>
      </td>
    </tr>
</c:forEach>
</table>

</div>
<div id="input">
<h2>������${table.tableDescription}</h2>
<form name="mainform" action="${oid}Action.jsp" method="post">
  <input type="hidden" name="action" value="create" />
#foreach(${_col} in ${table.columns})
  <p>${_col.description}: <input type="text" name="${_col.attributeName}" /></p>
#end
  <p><input type="submit" value="�ύ" /></p>
</form>
</div>
</div>
</body>
</html>