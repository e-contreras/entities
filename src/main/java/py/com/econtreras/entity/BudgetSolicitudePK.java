package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class BudgetSolicitudePK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "producto", nullable = false)
    private int productId;
    @Basic(optional = false)
    @Column(name = "sol_presupuesto", nullable = false)
    private int budgetSolicitudeId;
	
    public BudgetSolicitudePK(int productId, int budgetSolicitudeId) {
		super();
		this.productId = productId;
		this.budgetSolicitudeId = budgetSolicitudeId;
	}
    
}
