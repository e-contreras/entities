
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "mer_imagenes", catalog = "econtreras", schema = "")
public class ProductImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductImagePK merImagenesPK;
    @Basic(optional = false)
    @Column(name = "principal", nullable = false)
    private Character principal;
    @JoinColumn(name = "imagenes", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Image image;
    @JoinColumn(name = "mercaderia", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    
}
