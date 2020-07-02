
package InitDB.Ops;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "R_SUBJECTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RSubjects.findAll", query = "SELECT r FROM RSubjects r")
    , @NamedQuery(name = "RSubjects.findBySCode", query = "SELECT r FROM RSubjects r WHERE r.sCode = :sCode")
    , @NamedQuery(name = "RSubjects.findBySNo", query = "SELECT r FROM RSubjects r WHERE r.sNo = :sNo")
    , @NamedQuery(name = "RSubjects.findByEmail", query = "SELECT r FROM RSubjects r WHERE r.email = :email")})
public class RSubjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "S_CODE")
    private String sCode;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "S_NO")
    private Integer sNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "EMAIL")
    private String email;

    public RSubjects() {
    }

    public RSubjects(Integer sNo) {
        this.sNo = sNo;
    }

    public String getSCode() {
        return sCode;
    }

    public void setSCode(String sCode) {
        this.sCode = sCode;
    }

    public Integer getSNo() {
        return sNo;
    }

    public void setSNo(Integer sNo) {
        this.sNo = sNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sNo != null ? sNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RSubjects)) {
            return false;
        }
        RSubjects other = (RSubjects) object;
        if ((this.sNo == null && other.sNo != null) || (this.sNo != null && !this.sNo.equals(other.sNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InitDB.Ops.RSubjects[ sNo=" + sNo + " ]";
    }
    
}
