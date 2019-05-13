<#include "../layouts/base.ftl">

<#macro page_content>

	<h1>Picture</h1>

	<img src="/public/StockSnap_ZHN52P08M9.jpg" width="350">
	<br>
<code>
Photo courtesy of StockSnap.io
	<br>
https://stocksnap.io/photo/ZHN52P08M9
</code>

	<br><br>
	<#if loggedIn??>
		<strong>username: <span>${username}</span></strong>
	<#else>
		<strong>You are not logged in</strong>
	</#if>
</#macro>

<@display_page title="My Home"/>
