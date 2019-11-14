
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "fac_comp_detalle", catalog = "econtreras", schema = "")
public class PurchaseInvoiceDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurchaseInvoiceDetailPK facCompDetallePK;
    @Basic(optional = false)
    @Column(name = "cant", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "precio", nullable = false)
    private double price;
    @JoinColumn(name = "fac_compras_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseInvoice purchaseInvoice;
    @JoinColumn(name = "productos_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

}
