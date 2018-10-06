package application;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import model.OrdersLogger;


@MessageDriven(
    activationConfig = { 
        @ActivationConfigProperty(
            propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(
            propertyName = "destination", propertyValue = "java:/jms/queue/orders")})

public class EcommerceMDB implements MessageListener {
  
  @PersistenceContext(unitName="ecommerce-modelAdmin")
  private EntityManager em_admin;

  public EcommerceMDB() {
  }
  public void onMessage(Message message) {
    try {
      if(message!=null && message instanceof MapMessage){ 
    	MapMessage msg = (MapMessage) message;
        int id_order = (int) msg.getObject("id_order");
        int id_product = (int) msg.getObject("id_product");
        String purchase_data = (String) msg.getObject("purchase_data");
        String email = (String) msg.getObject("email");       

        OrdersLogger oLogger = new OrdersLogger();
        oLogger.setId_order(id_order);
        oLogger.setId_product(id_product);
        oLogger.setPurchase_data(purchase_data);
        oLogger.setEmail(email);
        em_admin.persist(oLogger);
      }
    } catch (Exception e) {
      System.err.println("Errore nel salvataggio del log degli ordini");
      e.printStackTrace();
    }
  }
}