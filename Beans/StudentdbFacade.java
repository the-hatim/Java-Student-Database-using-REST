

import InitDB.Ops.Studentdb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class StudentdbFacade extends AbstractFacade<Studentdb> {

    @PersistenceContext(unitName = "WebAssignPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentdbFacade() {
        super(Studentdb.class);
    }
    
}
