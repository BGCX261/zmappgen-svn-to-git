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
		//ʹ��Spring��DataBinder ��request�����󶨵�DTO.
		${entityClassname} ${entityObj}=new ${entityClassname}();
		WebUtil.bind(request, ${entityObj});

		//ʹ��Spring ApplicationContext�е�UserService����û�.
		service.create${entityClassname}(${entityObj});

		//��ת��չʾҳ��.
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