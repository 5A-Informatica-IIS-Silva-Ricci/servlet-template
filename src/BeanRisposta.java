/*
Classe a cui viene deserializzato un json ricevuto attraverso la richiesta web che effettua la servlet
tramite il WebTarget.
Ogni variabile in questa classe deve corrispondere a un parametro del json che si riceve.
Esempio del JSON:
{
    "dato1": "esempio",
    "dato2": "esempio2"
}
 */
public class BeanRisposta {
    private String dato1;
    private String dato2;

    public String getDato1() {
        return dato1;
    }

    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }

    public String getDato2() {
        return dato2;
    }

    public void setDato2(String dato2) {
        this.dato2 = dato2;
    }
}
