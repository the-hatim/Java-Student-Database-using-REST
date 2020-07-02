
package InitDB.Ops;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hatim
 */
@Entity
@Table(name = "STUDENTDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentdb.findAll", query = "SELECT s FROM Studentdb s")
    , @NamedQuery(name = "Studentdb.findById", query = "SELECT s FROM Studentdb s WHERE s.id = :id")
    , @NamedQuery(name = "Studentdb.findByFirstname", query = "SELECT s FROM Studentdb s WHERE s.firstname = :firstname")
    , @NamedQuery(name = "Studentdb.findBySurname", query = "SELECT s FROM Studentdb s WHERE s.surname = :surname")
    , @NamedQuery(name = "Studentdb.findByDateofbirth", query = "SELECT s FROM Studentdb s WHERE s.dateofbirth = :dateofbirth")})
public class Studentdb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 30)
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;

    public Studentdb() {
    }

    public Studentdb(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentdb)) {
            return false;
        }
        Studentdb other = (Studentdb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InitDB.Ops.Studentdb[ id=" + id + " ]";
    }
    
}
