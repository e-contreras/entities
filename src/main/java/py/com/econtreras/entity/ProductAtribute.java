
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "atr_mercaderias", catalog = "econtreras", schema = "")
public class ProductAtribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductAtributePK atrMercaderiasPK;
    @Basic(optional = false)
    @Column(name = "valor", nullable = false, length = 100)
    private String value;
    @JoinColumn(name = "atributos_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Attribute attribute;
    @JoinColumn(name = "mercaderias_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
}
