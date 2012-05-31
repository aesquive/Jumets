
<portlet:defineObjects />
<%	String tableState = "\"display:''\"";
	String errorMessage = (String)request.getAttribute("errorMessage");
	if (null == errorMessage) { errorMessage = ""; tableState = "\"display:none\""; }%>
<table border=0 cellpadding=0 cellspacing=0 id=tblError style=<%=tableState%>>	
	<tr class="form_separator"><td ></td></tr>
	<tr>
		<td>
			<table border=1 cellpadding=0 cellspacing=0 bordercolor="#FF0000">
				<tr>
				   <td bgcolor="#FFE6E6"><font id=errorMessage color="#FF0000"><%=errorMessage%></font></td>
  				</tr>
			</table>
		</td>
	</tr>
	<tr class="form_separator"><td ></td></tr>
</table>