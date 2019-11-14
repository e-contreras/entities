
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class SalesInvoiceDetailPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "producto", nullable = false)
    private int productId;
    @Basic(optional = false)
    @Column(name = "fac_venta", nullable = false)
    private int invoice;

}
