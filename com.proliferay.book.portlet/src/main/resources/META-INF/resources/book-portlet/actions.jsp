<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="../init.jsp" %>

<%

ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Book book = (Book) row.getObject();

%>


<liferay-ui:icon-menu>

	<portlet:actionURL name="viewBook" var="viewBookURL">
		<portlet:param name="bookId" value="<%=String.valueOf(book.getBookId()) %>"/> 
	</portlet:actionURL>
	
	<liferay-ui:icon image="view" url="<%=viewBookURL.toString() %>"/>
	
	<portlet:actionURL name="viewEdit" var="viewEditURL">
		<portlet:param name="bookId" value="<%=String.valueOf(book.getBookId()) %>"/> 
	</portlet:actionURL>
	
	<liferay-ui:icon image="edit" url="<%=viewEditURL.toString() %>"/>
	
	<portlet:actionURL name="deleteBook" var="deleteBookURL">
		<portlet:param name="bookId" value="<%=String.valueOf(book.getBookId()) %>"/> 
	</portlet:actionURL>
	
	<liferay-ui:icon image="delete" url="<%=deleteBookURL.toString() %>"/>

</liferay-ui:icon-menu>
