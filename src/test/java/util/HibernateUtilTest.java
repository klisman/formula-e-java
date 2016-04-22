package util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	@Test
	public void testDBConnection(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
}
