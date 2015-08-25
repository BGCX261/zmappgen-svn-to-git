#set( $serviceObj = ${stringUtils.uncapitalize($serviceClassname)} )
#set( $entityObj = ${stringUtils.uncapitalize($entityClassname)} )

<%@ page contentType="text/html;charset=UTF-8"
	import="
	com.zoom.appcore.web.jsp.WebUtil,
		${entityPackage}.${entityClassname},
${servicePackage}.${serviceClassname}"%>

<%
${serviceClassname} service = (${serviceClassname}) WebUtil.getBean(application, "${serviceObj}");

	String action = request.getParameter("action");

	if ("create".equals(action)) {
		//使用Spring的DataBinder 将request参数绑定到DTO.
		${entityClassname} ${entityObj}=new ${entityClassname}();
		WebUtil.bind(request, ${entityObj});

		//使用Spring ApplicationContext中的UserService添加用户.
		service.create${entityClassname}(${entityObj});

		//跳转到展示页面.
		response.sendRedirect("${entityObj}.jsp");
		return;
	}

	if ("delete".equals(action)) {
		service.delete${entityClassname}(
		#foreach(${pk} in ${table.primaryKeys})
#if(!${foreach.first}) , #end
${pk.attributeType}.valueOf(request.getParameter("${pk.attributeName}"))
#end);

		response.sendRedirect("${oid}.jsp");
		return;
	}
%>