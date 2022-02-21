//admin 左侧导航栏
Vue.component('left-navigation', {
  template: '<aside class="lyear-layout-sidebar"><div id="logo" class="sidebar-header"><a href="index.html"><img src="/images/logo-sidebar.png"title="LightYear" alt="LightYear" /></a></div><div class="lyear-layout-sidebar-scroll"><nav class="sidebar-main"><ul class="nav nav-drawer"><li class="nav-item active"> <a href="index.html"><i class="mdi mdi-home"></i> 后台首页</a> </li><li class="nav-item nav-item-has-subnav"><a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 管理</a><ul class="nav nav-subnav"><li> <a href="article_list.html">文章列表</a> </li><li> <a href="create_article_page.html">写文章</a> </li><li> <a href="/admin/frendLinkPage.html">友情连接列表</a> </li><li> <a href="/admin/websiteConfig.html">网站配置</a> </li><li> <a href="/admin/aboutMe.html">aboutMe</a> </li></ul></li></ul></nav><div class="sidebar-footer"><copyright></copyright></div></div></aside>'
})
Vue.component('copyright',{
	template:'<p class="copyright">Copyright &nbsp;2020 - 2025 &nbsp;©&nbsp; Frank Li &nbsp; </p>'
})
Vue.component('page-number',{
	template:''
})
// 用户访问头部信息
Vue.component('index-nav',{
	template:'<header><div class="tophead"><div class="logo"><a href="/index.html">李佳浩个人博客</a></div><div id="mnav"><h2><span class="navicon"></span></h2><ul><li><a href="/index.html">首页</a></li><li><a href="/gbook.html">留言</a></li><li><a href="/about.html">关于我</a></li></ul></div><nav class="topnav" id="topnav"><ul><li><a href="/index.html">首页</a></li><li><a href="/gbook.html">留言</a></li><li><a href="/about.html">关于我</a></li></ul></nav></div></header>'
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