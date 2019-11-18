package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sol_pre_productos", catalog = "econtreras", schema = "")
@Data
public class BudgetSolicitudeProdcut implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BudgetSolicitudePK solPreProductosPK;
    @Basic(optional = false)
    @Column(name = "cant", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "tip_impuesto", nullable = false)
    private int taxeType;
    @JoinColumn(name = "producto", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "sol_presupuesto", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BugetSolicitude bugetSolicitude;

    public BudgetSolicitudeProdcut() {
    }

    public BudgetSolicitudeProdcut(int producto, int solPresupuesto) {
        this.solPreProductosPK = new BudgetSolicitudePK(producto, solPresupuesto);
    }
    
}
