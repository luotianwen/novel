<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户阅读小说管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/novel/userNovel/">用户阅读小说列表</a></li>
	<%--	<shiro:hasPermission name="novel:userNovel:edit"><li><a href="${ctx}/novel/userNovel/form">用户阅读小说添加</a></li></shiro:hasPermission>
	--%></ul>
	<form:form id="searchForm" modelAttribute="userNovel" action="${ctx}/novel/userNovel/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户：</label>
				<form:input path="user.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>小说：</label>
				<form:input path="n.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${userNovel.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${userNovel.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>用户</th>
				<th>小说</th>
				<th>创建时间</th>
				<th>阅读量</th>
				<th>章节</th>
				<shiro:hasPermission name="novel:userNovel:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="userNovel">
			<tr>
				<td>
					${userNovel.user.name}
				 </td>
				<td>
					${userNovel.n.name}
				</td>
				<td>
					<fmt:formatDate value="${userNovel.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${userNovel.ydcount}
				</td>
				<td>
					${userNovel.c.name}
				</td>
				<shiro:hasPermission name="novel:userNovel:edit"><td>
    				<%--<a href="${ctx}/novel/userNovel/form?id=${userNovel.id}">修改</a>--%>
					<a href="${ctx}/novel/userNovel/delete?id=${userNovel.id}" onclick="return confirmx('确认要删除该用户阅读小说吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>