        <%@page import="java.util.*" %>
        <%@page import="objetos.*" %>
        <%@page import="org.hibernate.*" %>
<%
String cp = request.getParameter("codigoPostal");
String municipio = "";
Session s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
Transaction tx = s.beginTransaction();
Query q = s.createQuery("from CodPos as cp where cp.codPosId = '"+cp+"'");
List lista = (List) q.list();
if(lista.size()>0)
    municipio = ((CodPos) lista.get(0)).getCodPosNomMun();
s.close();
%>
<input type="text" name="municipio" disabled value="<%=municipio%>"/>
