
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "inventarios", catalog = "econtreras", schema = "")
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cant_operacion", nullable = false)
    private int operationQuantity;
    @Basic(optional = false)
    @Column(name = "pre_compra", nullable = false)
    private double purchasePrice;
    @Basic(optional = false)
    @Column(name = "tip_operacion", nullable = false, length = 3)
    private String operationType;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @JoinColumn(name = "deposito", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Warehouse warehouse;
    @JoinColumn(name = "fac_compra", referencedColumnName = "id")
    @ManyToOne
    private PurchaseInvoice purchaseInvoice;
    @JoinColumn(name = "motivo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Motive motive;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private User creationUser;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private User modificationUser;
    @JoinColumn(referencedColumnName = "id", name = "producto", nullable = true)
    @ManyToOne(optional = false)
    private Product product;

}
