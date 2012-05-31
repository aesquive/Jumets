        <%@page import="java.util.*" %>
        <%@page import="objetos.*" %>
        <%@page import="org.hibernate.*" %>
<%
int estado = Integer.parseInt(request.getParameter("estado"));
Session s = null;
Transaction tx = null;
Query q = null;

%>
<select name="desarrollo" disabled>
    <option>-Seleccione-</option>
    <%
    s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
    tx = s.beginTransaction();
    q = s.createQuery("from Des  as des where des.cal.calId = '6' and des.edo.edoId="+estado);
    Iterator it = (Iterator) q.iterate();
    while (it.hasNext()) {
        Des des = (Des) it.next();
    %>
    <option value="<%=des.getDesId()%>"><%=des.getDesDes()%></option>
    <%}%>
    </select>
