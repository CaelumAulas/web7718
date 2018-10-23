import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteBuscaUm {

	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarefas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Tarefa t = em.find(Tarefa.class, 1l);
		em.remove(t);
		em.getTransaction().commit();
		
		System.out.println(t.getDescricao());
	}
}
