
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "pag_proveedores", catalog = "econtreras", schema = "")
public class PaymentProvider implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "importe", nullable = false)
    private long amount;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "fac_compra", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PurchaseInvoice purchaseInvoice;
    @JoinColumn(name = "proveedor", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Provider provider;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User creationUser;
    
}
