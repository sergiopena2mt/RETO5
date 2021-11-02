package co.usa.reto3.reto3.model.Reports;

import co.usa.reto3.reto3.model.Client;

public class ContadorClient {
    private Long total;
    private Client client;

    /**
     * 
     * cons parametros
     */
    public ContadorClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
   
}
