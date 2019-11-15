package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "sol_presupuestos", catalog = "econtreras", schema = "")
public class BugetSolicitude implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "fec_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date initDate;
    @Column(name = "fec_fin", length = 45)
    private String endDate;
    @Basic(optional = false)
    @Column(name = "enviado", nullable = false)
    private Character sent;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "fec_modifcacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @ManyToMany(mappedBy = "bugetSolicitudeList")
    private List<ProductCategory> productCategoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bugetSolicitude")
    private List<BudgetSolicitudeProdcut> budgetSolicitudeProdcutList;
    @JoinColumn(name = "pre_seleccionado", referencedColumnName = "id")
    @ManyToOne
    private Budget selectedBudget;
    @JoinColumn(name = "sol_pre_estado", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private BudgetSolicitudeStatus budgetSolicitudeStatus;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private User creationUser;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private User modificationUser;
    @OneToMany(mappedBy = "bugetSolicitude")
    private List<PurchaseInvoice> PurchaseInvoiceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bugetSolicitude")
    private List<Budget> budgetList;
}
