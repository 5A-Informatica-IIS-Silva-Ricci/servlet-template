import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Prende il parametro passato dal form del file index.html
        String parametro = req.getParameter("parametro");

        // Definisce l'indirro a cui fare la richiesta http
        WebTarget target = ClientBuilder.newClient().target("http://indirizzo.com?parametro=" + parametro);
        // Effettuo la richiesta e prendo il corpo della risposa (JSON) con readEntity()
        String risposta = target
                .request(MediaType.APPLICATION_JSON)
                .buildGet()
                .invoke()
                .readEntity(String.class);

        try {
            // Deserializzo il JSON nella classe BeanRisposta
            BeanRisposta beanRisposta = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(risposta, BeanRisposta.class);
            // Setto l'attributo per la jsp e mando la risposta alla jsp
            req.setAttribute("beanRisposta", beanRisposta);
            req.getRequestDispatcher("risultato.jsp")
                    .forward(req, resp);
        } catch (Exception e) {
            System.out.println("Errore");
        }
    }
}
