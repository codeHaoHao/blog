//admin 左侧导航栏
Vue.component('left-navigation', {
  template: '<aside class="lyear-layout-sidebar"><div id="logo" class="sidebar-header"><a href="index.html"><img src="/images/logo-sidebar.png" title="LightYear" alt="LightYear" /></a></div><div class="lyear-layout-sidebar-scroll"> <nav class="sidebar-main"><ul class="nav nav-drawer"><li class="nav-item active"> <a href="index.html"><i class="mdi mdi-home"></i> 后台首页</a> </li><li class="nav-item nav-item-has-subnav"><a href="javascript:void(0)"><i class="mdi mdi-palette"></i> UI 元素</a><ul class="nav nav-subnav"><li> <a href="lyear_ui_buttons.html">按钮</a> </li><li> <a href="lyear_ui_cards.html">卡片</a> </li><li> <a href="lyear_ui_grid.html">格栅</a> </li><li> <a href="lyear_ui_icons.html">图标</a> </li><li> <a href="lyear_ui_tables.html">表格</a> </li><li> <a href="lyear_ui_modals.html">模态框</a> </li><li> <a href="lyear_ui_tooltips_popover.html">提示 / 弹出框</a> </li><li> <a href="lyear_ui_alerts.html">警告框</a> </li><li> <a href="lyear_ui_pagination.html">分页</a> </li><li> <a href="lyear_ui_progress.html">进度条</a> </li><li> <a href="lyear_ui_tabs.html">标签页</a> </li><li> <a href="lyear_ui_typography.html">排版</a> </li><li> <a href="lyear_ui_step.html">步骤</a> </li><li> <a href="lyear_ui_other.html">其他</a> </li></ul></li><li class="nav-item nav-item-has-subnav"><a href="javascript:void(0)"><i class="mdi mdi-format-align-justify"></i> 表单</a><ul class="nav nav-subnav"><li> <a href="lyear_forms_elements.html">基本元素</a> </li><li> <a href="lyear_forms_radio.html">单选框</a> </li><li> <a href="lyear_forms_checkbox.html">复选框</a> </li><li> <a href="lyear_forms_switch.html">开关</a> </li></ul></li><li class="nav-item nav-item-has-subnav"><a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 示例页面</a><ul class="nav nav-subnav"><li> <a href="article_list.html">文章列表</a> </li><li> <a href="create_article_page.html">写文章</a> </li><li> <a href="/admin/frendLinkPage.html">友情连接列表</a> </li><li> <a href="lyear_pages_config.html">网站配置</a> </li><li> <a href="lyear_pages_rabc.html">设置权限</a> </li><li> <a href="lyear_pages_guide.html">表单向导</a> </li><li> <a href="lyear_pages_login.html">登录页面</a> </li><li> <a href="lyear_pages_error.html">错误页面</a> </li></ul></li><li class="nav-item nav-item-has-subnav"><a href="javascript:void(0)"><i class="mdi mdi-language-javascript"></i> JS 插件</a><ul class="nav nav-subnav"><li> <a href="lyear_js_datepicker.html">日期选取器</a> </li><li> <a href="lyear_js_sliders.html">滑块</a> </li><li> <a href="lyear_js_colorpicker.html">选色器</a> </li><li> <a href="lyear_js_chartjs.html">Chart.js</a> </li><li> <a href="lyear_js_jconfirm.html">对话框</a> </li><li> <a href="lyear_js_tags_input.html">标签插件</a> </li><li> <a href="lyear_js_notify.html">通知消息</a> </li></ul></li><li class="nav-item nav-item-has-subnav"><a href="javascript:void(0)"><i class="mdi mdi-menu"></i> 多级菜单</a><ul class="nav nav-subnav"><li> <a href="#!">一级菜单</a> </li><li class="nav-item nav-item-has-subnav"> <a href="#!">一级菜单</a><ul class="nav nav-subnav"><li> <a href="#!">二级菜单</a> </li> <li class="nav-item nav-item-has-subnav"> <a href="#!">二级菜单</a><ul class="nav nav-subnav"><li> <a href="#!">三级菜单</a> </li><li> <a href="#!">三级菜单</a> </li></ul></li></ul></li><li> <a href="#!">一级菜单</a> </li></ul></li></ul></nav><div class="sidebar-footer"><copyright></copyright></div></div> </aside>'
})
Vue.component('copyright',{
	template:'<p class="copyright">Copyright &nbsp;2020 - 2021 &nbsp;©&nbsp; lijiahao1.cn &nbsp; ICP证:&nbsp;<a href="http://www.miitbeian.gov.cn/" target="_blank">豫ICP备18036517号</a></p>'
})
Vue.component('page-number',{
	template:''
})
// 用户访问头部信息
Vue.component('index-nav',{
	template:'<header><div class="tophead"><div class="logo"><a href="/index.html">李佳浩个人博客</a></div><div id="mnav"><h2><span class="navicon"></span></h2><ul><li><a href="/index.html">首页</a></li><li><a href="/list.html">学无止境</a></li><li><a href="/info.html">慢生活</a></li><li><a href="/gbook.html">留言</a></li><li><a href="/about.html">关于我</a></li></ul></div><nav class="topnav" id="topnav"><ul><li><a href="/index.html">首页</a></li><li><a href="/list.html">学无止境</a></li><li><a href="/gbook.html">留言</a></li><li><a href="/about.html">关于我</a></li></ul></nav></div></header>'
})
// admin 头部信息
Vue.component('admin-top-nav',{
	template:'<ul class="dropdown-menu dropdown-menu-right"><li><a href="/admin/selfInformation.html"><i class="mdi mdi-account"></i> 个人信息</a></li><li><a href="lyear_pages_edit_pwd.html"><i class="mdi mdi-lock-outline"></i> 修改密码</a></li><li><a href="javascript:void(0)"><i class="mdi mdi-delete"></i> 清空缓存</a></li><li class="divider"></li><li><a href="lyear_pages_login.html"><i class="mdi mdi-logout-variant"></i> 退出登录</a></li></ul>'
})
var ln = new Vue({
  el: '#left-navigation-template'
})
var copyright = new Vue({
	el: '#copyright-template'
})
var index_nav = new Vue({
	el:'#index-nav-template'
})

var admin_top_nav = new Vue({
	el:'#admin-top-nav-template'
})