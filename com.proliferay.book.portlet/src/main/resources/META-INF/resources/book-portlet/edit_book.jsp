<%@ include file="../init.jsp" %>

<portlet:renderURL windowState="normal" var="backURL">
  <portlet:param name="jspPage" value="/book-portlet/view.jsp"></portlet:param>
</portlet:renderURL>
<liferay-ui:header
    backURL="<%= backURL %>"
    title="Back"
/>

<portlet:actionURL name="updateBook" var="updateBookURL"/>

<%
Book book = (Book) request.getAttribute("book");
%>

<aui:form name="fm" action="<%=updateBookURL.toString() %>" method="post">
	<aui:model-context bean="<%=book %>" model="<%=Book.class %>"/>
	<aui:input name="bookName" label="Book Name"/>
	<aui:input type="textarea" name="description" label="Description"/>
	<aui:input name="authorName" label="Author Name"/>
	<aui:input name="isbn" label="ISBN">
		 <aui:validator name="digits"/>
	</aui:input>
	<aui:input name="price" label="Price">
		 <aui:validator name="digits"/>
	</aui:input>
	<aui:button-row>
        <aui:button name="updateBook" type="submit" value="Update Book"  />
    </aui:button-row>
		
</aui:form>