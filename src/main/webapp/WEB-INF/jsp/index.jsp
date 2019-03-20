<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城后台管理系统</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/taotao.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body class="easyui-layout">
    <div data-options="region:'west',title:'菜单',split:true" style="width:280px;">
    	<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
         	<li>
         		<span>商城管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'item-add'}">新增商品</li>
	         		<li data-options="attributes:{'url':'item-list'}">商品管理</li>
	         		<li data-options="attributes:{'url':''}">订单管理</li>
	         		<li data-options="attributes:{'url':''}">统计模块</li>
	         	</ul>
         	</li>
         	<li>
         		<span>营销管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':''}">广告管理</li>
	         		<li data-options="attributes:{'url':''}">短信推送</li>
	         	</ul>
         	</li>
         	<li>
         		<span>用户管理</span>
         		<ul>
	         		<li>
	         			<span>权限管理</span>
	         			<ul>
	         				<li data-options="attributes:{'url':''}">管理员列表</li>
	         				<li data-options="attributes:{'url':''}">角色权限</li>
	         			</ul>
	         		</li>
	         		<li>
	         			<span>个人用户管理</span>
	         			<ul>
	         				<li data-options="attributes:{'url':''}">会员列表</li>
	         				<li data-options="attributes:{'url':''}">会员等级</li>
	         			</ul>
	         		</li>
	         		<li  data-options="attributes:{'url':''}">B端用户</li>
	         	</ul>
         	</li>
         	<li>
         		<span>财务管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':''}">评分统计</li>
	         		<li data-options="attributes:{'url':''}">财务报表</li>
	         	</ul>
         	</li>
         </ul>
    </div>
    <div data-options="region:'center',title:''">
    	<div id="tabs" class="easyui-tabs">
		    <div title="首页" style="padding:20px;">
		        	
		    </div>
		</div>
    </div>
    
<script type="text/javascript">
$(function(){
	$('#menu').tree({
		onClick: function(node){
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("select",node.text);
				}else{
					tabs.tabs('add',{
					    title:node.text,
					    href: node.attributes.url,
					    closable:true,
					    bodyCls:"content"
					});
				}
			}
		}
	});
});
</script>
</body>
</html>