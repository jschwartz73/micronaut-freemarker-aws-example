<#include "../layouts/base.ftl">

<#macro page_content>

	<h1>Welcome to Micronaut</h1>

<#--	<img src="/public/StockSnap_ZHN52P08M9.jpg" width="350">-->
<#--	<br>-->
<#--<code>-->
<#--Photo courtesy of StockSnap.io-->
<#--	<br>-->
<#--https://stocksnap.io/photo/ZHN52P08M9-->
<#--</code>-->

	<br>
	<#if loggedIn??>
		<h3>username: <span>${username}</span></h3>
	<#else>
		<h3>You are not logged in</h3>
	</#if>

	<br><br>
	<small> Rendered by Freemarker</small>
</#macro>

<@display_page title="My Home"/>
