
package InitDB.Ops;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "S_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SDetails.findAll", query = "SELECT s FROM SDetails s")
    , @NamedQuery(name = "SDetails.findByEmail", query = "SELECT s FROM SDetails s WHERE s.email = :email")
    , @NamedQuery(name = "SDetails.findByBGroup", query = "SELECT s FROM SDetails s WHERE s.bGroup = :bGroup")
    , @NamedQuery(name = "SDetails.findById", query = "SELECT s FROM SDetails s WHERE s.id = :id")})
public class SDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 30)
    @Column(name = "B_GROUP")
    private String bGroup;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    public SDetails() {
    }

    public SDetails(String email) {
        this.email = email;
    }

    public SDetails(String email, int id) {
        this.email = email;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBGroup() {
        return bGroup;
    }

    public void setBGroup(String bGroup) {
        this.bGroup = bGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SDetails)) {
            return false;
        }
        SDetails other = (SDetails) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InitDB.Ops.SDetails[ email=" + email + " ]";
    }
    
}
