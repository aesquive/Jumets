        <%@page import="java.util.*" %>
        <%@page import="objetos.*" %>
        <%@page import="org.hibernate.*" %>
<%
int actividad = Integer.parseInt(request.getParameter("actividad"));
int sector = Integer.parseInt(request.getParameter("sector"));
Session s = null;
Transaction tx = null;
Query q = null;

%>
<select name="subsector" disabled>
 <option>-Seleccione-</option>
 <%

            s = objetos.HibernateUtil.getSessionFactory().getCurrentSession();
            tx = s.beginTransaction();
            q = s.createQuery("from Ocp  as ocp where ocp.cal.calId = '6'");
            List lista = (List) q.list();
            for(int i=0; i<lista.size();i++){
                Ocp ocp = (Ocp) lista.get(i);
                int orden = Integer.parseInt(ocp.getOcpOrdPre().toString());
                if(orden>(actividad*100+sector*10) && orden<(actividad*100+(sector+1)*10)){
%>
<option value="<%=ocp.getOcpOrdPre()%>"><%=ocp.getOcpDes()%></option>
<%}}%>
</select>
