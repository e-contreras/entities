
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@Entity
@Table(name = "pre_meraderias", catalog = "econtreras", schema = "")
@XmlRootElement
public class ProductBudget implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductBudgetPK preMeraderiasPK;
    @Basic(optional = false)
    @Column(name = "cant", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "precio", nullable = false)
    private double price;
    @Basic(optional = false)
    @Column(name = "tip_impuesto", nullable = false)
    private int taxeType;
    @JoinColumn(name = "mercaderia", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "presupuesto", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Budget budget;
    
}
