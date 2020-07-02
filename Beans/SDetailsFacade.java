

import InitDB.Ops.SDetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class SDetailsFacade extends AbstractFacade<SDetails> {

    @PersistenceContext(unitName = "WebAssignPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SDetailsFacade() {
        super(SDetails.class);
    }
    
}
