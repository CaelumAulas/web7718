import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaListagem {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarefas");
		EntityManager em = emf.createEntityManager();
		
		List<Tarefa> tarefas = em.createQuery("select t from Tarefa t", Tarefa.class)
			.getResultList();
		
		for(Tarefa t : tarefas) {
			System.out.println("Descrição " + t.getDescricao());
		}
	}
}
