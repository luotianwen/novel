<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理管理</title>
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
		<li class="active"><a href="${ctx}/novel/nuser/">用户管理列表</a></li>
		<shiro:hasPermission name="novel:nuser:edit"><li><a href="${ctx}/novel/nuser/form">用户管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="nuser" action="${ctx}/novel/nuser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${nuser.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${nuser.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>昵称：</label>
				<form:input path="nk" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:select path="sex" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>生日：</label>
				<input name="beginBr" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${nuser.beginBr}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endBr" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${nuser.endBr}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>地区：</label>
				<form:input path="area" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>邮箱：</label>
				<form:input path="email" htmlEscape="false" maxlength="255" class="input-medium"/>
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
				<th>账号</th>
				<th>创建时间</th>
				<th>昵称</th>
				<th>性别</th>
				<th>生日</th>
				<th>头像</th>
				<th>地区</th>
				<th>邮箱</th>
				<th>备注</th>
				<shiro:hasPermission name="novel:nuser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="nuser">
			<tr>
				<td><a href="${ctx}/novel/nuser/form?id=${nuser.id}">
					${nuser.name}
				</a></td>
				<td>
					${nuser.account}
				</td>
				<td>
					<fmt:formatDate value="${nuser.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${nuser.nk}
				</td>
				<td>
					${fns:getDictLabel(nuser.sex, 'sex', '')}
				</td>
				<td>
					<fmt:formatDate value="${nuser.br}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<img src="${nuser.pto}" width="100px">

				</td>
				<td>
					${nuser.area}
				</td>
				<td>
					${nuser.email}
				</td>
				<td>
					${nuser.remarks}
				</td>
				<shiro:hasPermission name="novel:nuser:edit"><td>
    				<a href="${ctx}/novel/nuser/form?id=${nuser.id}">修改</a>
					<a href="${ctx}/novel/nuser/delete?id=${nuser.id}" onclick="return confirmx('确认要删除该用户管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>