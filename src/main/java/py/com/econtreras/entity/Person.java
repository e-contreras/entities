
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "personas", catalog = "econtreras", schema = "")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nombre", length = 100)
    private String name;
    @Column(name = "apellido", length = 100)
    private String lastname;
    @Column(name = "raz_social", length = 100)
    private String businessName;
    @Basic(optional = false)
    @Column(name = "documento", nullable = false, length = 45)
    private String documentNumber;
    @Column(name = "fec_nac")
    private LocalDate birthday;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 200)
    private String email;
    @Column(name = "telefono", length = 45)
    private String phone;
    @Column(name = "celular", length = 45)
    private String cellphone;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<User> userList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Provider> providerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Customer> customerList;
//    @JoinColumn(name = "dir_particular", referencedColumnName = "id")
//    @ManyToOne
//    private Address homeAddress;
//    @JoinColumn(name = "dir_laboral", referencedColumnName = "id")
//    @ManyToOne
//    private Address workAddress;
    @JoinColumn(name = "tip_documento", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private DocumentType documentType;
    @JoinColumn(name = "tip_persona", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PersonType personType;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private User creationUser;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private User modificationUser;
    @OneToMany(mappedBy = "person")
    private List<Address> addressList;
    
}
