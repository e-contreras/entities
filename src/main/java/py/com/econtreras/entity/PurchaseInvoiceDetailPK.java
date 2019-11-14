
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class PurchaseInvoiceDetailPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "productos_id", nullable = false)
    private int productId;
    @Basic(optional = false)
    @Column(name = "fac_compras_id", nullable = false)
    private int purchaseInvoiceId;
    
}
