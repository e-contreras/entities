
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ProductAtributePK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "atributos_id", nullable = false)
    private int atributosId;
    @Basic(optional = false)
    @Column(name = "mercaderias_id", nullable = false)
    private int mercaderiasId;


    public ProductAtributePK(int atributosId, int mercaderiasId) {
        this.atributosId = atributosId;
        this.mercaderiasId = mercaderiasId;
    }
    
}
