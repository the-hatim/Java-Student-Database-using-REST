

import InitDB.Ops.RSubjects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class RSubjectsFacade extends AbstractFacade<RSubjects> {

    @PersistenceContext(unitName = "WebAssignPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RSubjectsFacade() {
        super(RSubjects.class);
    }
    
}
