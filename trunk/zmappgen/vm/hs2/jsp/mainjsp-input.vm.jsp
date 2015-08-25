#set( $entityObj = ${stringUtils.uncapitalize($entityClassname)} )

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${obj.tableDescription}管理</title>
<%@ include file="/common/meta.jsp"%>

<link href="${ctx}/js/validate/jquery.validate.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/js/validate/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/js/validate/messages_cn.js" type="text/javascript"></script>

<!-- calendar-->
<link rel="stylesheet" type="text/css" media="all" href="${ctx}/js/calendar/calendar-win2k-1.css" />
<script type="text/javascript" src="${ctx}/js/calendar/calendar.js"></script>
<script type="text/javascript" src="${ctx}/js/calendar/lang/calendar-en.js"></script>
<script type="text/javascript" src="${ctx}/js/calendar/calendar-setup.js"></script>

<script>
	$(document).ready(function(){
		$("#inputForm").validate({
			 rules: { 
#set( $_v = "N" )
#foreach(${_col} in ${obj.metaDatas})
  #set( $_v2 = "N" )
  #if($_col.attributeName != "id")
	#if($_v == "Y") , #end
	$_col.attributeName: {
    #if($_col.isRequired == "Y")	
        			required: true 
	    #set( $_v2 = "Y" )
    #end
	#if( $_col.validateRule )
		#if($_v2 == "Y") , #end
		$!_col.validateRule: true
	#end
	#set( $_v = "Y" )
	}
 #end
#end
			}
		});
	});
	
</script>

</head>

<body>
<div id="content">
<h3><s:if test="id == null">创建</s:if><s:else>修改</s:else>${obj.tableDescription}</h3>
<form id="inputForm" action="${lobjname}!save.action" method="post">
<input type="hidden" name="id" value="${id}" />
<table class="inputView">

#foreach(${_col} in ${obj.metaDatas})
 #if($_col.attributeName != "id")

  #if($_col.viewType == "date")
	<tr>
		<td>${_col.description}:</td>
		<td>
		  <input type="text" name="${_col.attributeName}" id="${_col.attributeName}" value="${${_col.attributeName}}" readonly />
		</td>
	</tr>
	<script type="text/javascript">
		Calendar.setup({
		inputField     :    "${_col.attributeName}",
		ifFormat       :    " %Y-%m-%d",
		button         :    "${_col.attributeName}"
		});
	</script>
  #elseif($_col.viewType == "select")

	<tr>
		<td>${_col.description}:</td>
		<td>
		  <select name="${_col.attributeName}" id="${_col.attributeName}" >
		    #foreach(${_enumValue} in ${_col.enumValues})
              <option value=${_enumValue.enkey}>${_enumValue.envalue}</option>
			#end
		  </select>	
		  <script type="text/javascript">$("#${_col.attributeName}").val("${${_col.attributeName}}");</script>
		</td>
	</tr>

  #else
	<tr>
		<td>${_col.description}:</td>
		<td><input type="text" name="${_col.attributeName}" id="${_col.attributeName}" value="${${_col.attributeName}}" /></td>
	</tr>
  #end
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
