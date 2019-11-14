package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "presupuestos", catalog = "econtreras", schema = "")
public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fec_propuesta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date proposalDate;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "archivo", length = 255)
    private String urlArchive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budget")
    private List<ProductBudget> preMeraderiasList;
    @OneToMany(mappedBy = "selectedBudget")
    private List<BugetSolicitude> bugetSolicitudeList;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private User creationUser;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private User modificationUser;
    @JoinColumn(name = "proveedor", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Provider provider;
    @JoinColumn(name = "sol_presupuestos", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private BugetSolicitude bugetSolicitude;
    
}
