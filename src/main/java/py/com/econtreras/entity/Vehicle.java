
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "vehiculos", catalog = "econtreras", schema = "")
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "marca", nullable = false, length = 45)
    private String brand;
    @Basic(optional = false)
    @Column(name = "model", nullable = false, length = 45)
    private String model;
    @Basic(optional = false)
    @Column(name = "anho", nullable = false)
    private Integer year;
    @Basic(optional = false)
    @Column(name = "color", nullable = false, length = 45)
    private String color;
    @Basic(optional = false)
    @Column(name = "capacidad", nullable = false)
    private String capacity;
    @Basic(optional = false)
    @Column(name = "num_documento", nullable = false, length = 45)
    private String documentNumber;
    @Basic(optional = false)
    @Column(name = "matricula", nullable = false, length = 45)
    private String plate;
    @Basic(optional = false)
    @Column(name = "chassis", nullable = false, length = 45)
    private String chassis;
    @Basic(optional = false)
    @Column(name = "borrado", nullable = false)
    private short erased;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    private List<Transfer> transferList;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private User creationUser;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private User modificationUser;
    
}
