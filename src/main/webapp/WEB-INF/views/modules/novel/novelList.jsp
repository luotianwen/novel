<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小说管理管理</title>
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
		<li class="active"><a href="${ctx}/novel/novel/">小说管理列表</a></li>
		<shiro:hasPermission name="novel:novel:edit"><li><a href="${ctx}/novel/novel/form">小说管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="novel" action="${ctx}/novel/novel/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>作者：</label>
				<form:input path="author" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>分类：</label>
				<form:select path="type" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${novel.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${novel.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>性别：</label>
				<form:select path="sex" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>作者</th>
				<th>分类</th>
				<th>创建时间</th>
				<th>性别</th>
				<th>封面</th>
				<th>阅读次数</th>
				<th>备注</th>
				<shiro:hasPermission name="novel:novel:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="novel">
			<tr>
				<td><a href="${ctx}/novel/novel/form?id=${novel.id}">
					${novel.name}
				</a></td>
				<td>
					${novel.author}
				</td>
				<td>
					${fns:getDictLabel(novel.type, 'type', '')}
				</td>
				<td>
					<fmt:formatDate value="${novel.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(novel.sex, 'sex', '')}
				</td>
				<td>
					<img src="${novel.pto}" width="100px">

				</td>
				<td>
					${novel.ydcount}
				</td>
				<td>
					${novel.remarks}
				</td>
				<shiro:hasPermission name="novel:novel:edit"><td>
    				<a href="${ctx}/novel/novel/form?id=${novel.id}">修改</a>
					<a href="${ctx}/novel/novel/delete?id=${novel.id}" onclick="return confirmx('确认要删除该小说管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>