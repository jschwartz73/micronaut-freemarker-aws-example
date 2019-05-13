<#macro page_content></#macro>

<#macro post_body_javascript></#macro>

<#macro display_page title>

	<!doctype html>
	<html class="fixed has-top-menu">
		<head>
			<!-- Basic -->
			<meta charset="UTF-8">

			<title>${title}</title>

			<!-- Mobile Metas -->
			<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

			<#include "../includes/cssFiles.ftl">

		</head>

		<body>

			<!-- start: page -->
			<@page_content/>
			<!-- end: page -->

			<#include "../includes/jsFiles.ftl">

		</body>

	</html>
</#macro>