package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data	
@Entity
@Table(name = "direcciones", catalog = "econtreras", schema = "")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cal_principal", nullable = false, length = 100)
    private String principalStreet;
    @Column(name = "cal_secundaria", length = 100)
    private String secondaryStreet;
    @Column(name = "numero", length = 45)
    private String number;
    @Column(name = "edificio", length = 45)
    private String building;
    @Column(name = "piso", length = 45)
    private String floor;
    @Column(name = "apartamento", length = 45)
    private String apartment;
    @Column(name = "tipo_direccion", length = 45)
    private String addressType;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificactionDate;
//    @OneToMany(mappedBy = "homeAddress")
//    private List<Person> homePersonAddressList;
//    @OneToMany(mappedBy = "workAddress")
//    private List<Person> workPersonAddressList;
    @JoinColumn(name = "barrio", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Neighborhood neighborhood;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private User creationUser;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private User modificationUser;
    @JoinColumn(name = "persona", referencedColumnName = "id")
    @ManyToOne
    private Person person;
    
}
