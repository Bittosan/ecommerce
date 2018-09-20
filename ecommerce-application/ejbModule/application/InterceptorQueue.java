package application;

import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
public class InterceptorQueue {

@Resource(name="java:/ConnectionFactory")
QueueConnectionFactory factory;
@Resource(name="java:/jms/queue/orders")
Queue ecommerceQueue;
QueueSession session;
QueueSender sender;

public InterceptorQueue()
{
}

@AroundInvoke
public Object order(InvocationContext ic) throws Exception
{
	QueueConnection connection = factory.createQueueConnection();
	session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	sender = session.createSender(ecommerceQueue);
	Properties message = composeMessage(ic);
	try {
		return ic.proceed();
	}finally {
		sendMessage(message);
	}
}

protected Properties composeMessage(InvocationContext ic)
{
	Properties p = new Properties();
	if(ic!=null)
	{
	Object[] params = ic.getParameters();
	p.put("id_order", params[0]);
	p.put("total", params[1]);
	p.put("email", params[2]);
	p.put("purchase_data", params[3]);
	p.put("id_product", params[4]);
	p.put("quantity", params[5]);
	System.out.println("INTERCEPTOR");
	}
	return p;
}

protected void sendMessage(Properties message) {
	MapMessage m;
	try {
		m = session.createMapMessage();
		for(Entry<Object, Object> e: message.entrySet())
		{
			String key = e.getKey().toString();
			Object value = e.getValue();
			m.setObject(key, value);
		}
		sender.send(m);
	}
	catch (Exception e)
	{
		e.printStackTrace(System.out);
	}
}

}
