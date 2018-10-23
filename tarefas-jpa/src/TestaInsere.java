import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaInsere {

	public static void main(String[] args) {
		
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("De novo");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarefas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(tarefa);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
