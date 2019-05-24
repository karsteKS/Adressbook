package lt.bit.data;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name = "contact" )

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   @Column(name="ContactType")
    private String contactType;
   @Column(name="Contact")
    private String contact;
   @ManyToOne
   @JoinColumn(name="personId")
    private Person person;
    static int nextId = 0;
    
    public Contact(){}
    
    
    public Contact(String contactType, String contact) {
        this.id = id;
        this.contactType = contactType;
        this.contact = contact;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getContactType() {
        return contactType;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", contactType=" + contactType + ", contact=" + contact + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void createId() {
        this.id = nextId++;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
