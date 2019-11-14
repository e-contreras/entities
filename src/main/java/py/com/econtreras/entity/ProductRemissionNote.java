
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "mer_rem_productos", catalog = "econtreras", schema = "")
public class ProductRemissionNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductRemissionNotePK merRemProductosPK;
    @Basic(optional = false)
    @Column(name = "cant", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "precio", nullable = false)
    private double price;
    @JoinColumn(name = "pro_not_remision", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RemissionNote remissionNote;
    @JoinColumn(name = "mercaderia", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

}
