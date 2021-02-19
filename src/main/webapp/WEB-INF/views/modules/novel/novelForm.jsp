<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小说管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/novel/novel/">小说管理列表</a></li>
		<li class="active"><a href="${ctx}/novel/novel/form?id=${novel.id}">小说管理<shiro:hasPermission name="novel:novel:edit">${not empty novel.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="novel:novel:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="novel" action="${ctx}/novel/novel/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">作者：</label>
			<div class="controls">
				<form:input path="author" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">分类：</label>
			<div class="controls">
				<form:select path="type" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">性别：</label>
			<div class="controls">
				<form:select path="sex" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">封面：</label>
			<div class="controls">
				<form:hidden id="pto" path="pto" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="pto" type="files" uploadPath="/novel/novel" selectMultiple="false"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">阅读次数：</label>
			<div class="controls">
				<form:input path="ydcount" htmlEscape="false" maxlength="11" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">章节：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>名称</th>

								<th>序号</th>
								<th>内容</th>
								<shiro:hasPermission name="novel:novel:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="novelChapterList">
						</tbody>
						<shiro:hasPermission name="novel:novel:edit"><tfoot>
							<tr><td colspan="6"><a href="javascript:" onclick="addRow('#novelChapterList', novelChapterRowIdx, novelChapterTpl);novelChapterRowIdx = novelChapterRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="novelChapterTpl">//<!--
						<tr id="novelChapterList{{idx}}">
							<td class="hide">
								<input id="novelChapterList{{idx}}_id" name="novelChapterList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="novelChapterList{{idx}}_delFlag" name="novelChapterList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="novelChapterList{{idx}}_name" name="novelChapterList[{{idx}}].name" type="text" value="{{row.name}}" maxlength="255" class="input-small "/>
							</td>

							<td>
								<input id="novelChapterList{{idx}}_xh" name="novelChapterList[{{idx}}].xh" type="text" value="{{row.xh}}" maxlength="11" class="input-small "/>
							</td>
							<td>
								<textarea id="novelChapterList{{idx}}_content" name="novelChapterList[{{idx}}].content" rows="4" maxlength="255" class="input-small ">{{row.content}}</textarea>
							</td>
							<shiro:hasPermission name="novel:novel:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#novelChapterList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var novelChapterRowIdx = 0, novelChapterTpl = $("#novelChapterTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(novel.novelChapterList)};
							for (var i=0; i<data.length; i++){
								addRow('#novelChapterList', novelChapterRowIdx, novelChapterTpl, data[i]);
								novelChapterRowIdx = novelChapterRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="novel:novel:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>