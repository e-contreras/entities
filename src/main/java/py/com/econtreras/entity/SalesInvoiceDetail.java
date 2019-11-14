
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "fac_ven_detalles", catalog = "econtreras", schema = "")
public class SalesInvoiceDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalesInvoiceDetailPK facVenDetallesPK;
    @Basic(optional = false)
    @Column(name = "cant", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "precio", nullable = false)
    private double price;
    @JoinColumn(name = "solicitud", referencedColumnName = "id")
    @ManyToOne
    private Solicitude solicitude;
    @JoinColumn(name = "fac_venta", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesInvoice salesInvoice;
    @JoinColumn(name = "producto", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    
}
