<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<%@include file="/WEB-INF/jsp/common/include_script_maps.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		initializeHomeMap("#map_canvas_1");		
	});
</script>

<spring:message code="app.name" var="defaultAppName" htmlEscape="false" />
<spring:message code="generic.title" var="defaultGenericTitle" />

<c:choose>
	<c:when test="${not empty tenantCustomParams and not empty tenantCustomParams.tenantId}">
		<c:set var="messageTenantId" value=".${tenantCustomParams.tenantId}" />
	</c:when>
	<c:otherwise>
		<c:set var="messageTenantId" value="" />
	</c:otherwise>
</c:choose>

<div class="container-fluid">
	<div class="mapcontent">
		<div class="row-fluid">
			<div id="heroBanner" class="hero-unit">
				<br>
				<h1>
					<spring:message code="app.name${messageTenantId}" text="${defaultAppName}" htmlEscape="false" />
				</h1>
				<p>
					<spring:message code="generic.title${messageTenantId}" text="${defaultGenericTitle}"/>
					<br />
				</p>
				<br />
				<p>
					<a id="exploreButton" class="btn btn-inverse btn-large" href="${componentMap}"> 
						<spring:message code="start.browsing" /> 
					</a>
				</p>
			</div>
			<c:set var="mapClass" value="map2" />
			<%@include file="/WEB-INF/jsp/component/public/include_component_map.jsp"%>
		</div>		
	</div>
</div>

<%@include file="/WEB-INF/jsp/common/footer.jsp"%>