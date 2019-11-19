package py.com.econtreras.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "mer_solicitudes", catalog = "econtreras", schema = "")
@AllArgsConstructor
@NoArgsConstructor
public class ProductSolicitude implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductSolicitudePK merSolicitudesPK;
    @Basic(optional = false)
    @Column(name = "cant", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "pre_unitario", nullable = false)
    private BigInteger price;
    @JoinColumn(name = "mercaderia", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "solicitud", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Solicitude solicitude;

    public ProductSolicitude(ProductSolicitudePK merSolicitudesPK) {
        this.merSolicitudesPK = merSolicitudesPK;
    }
}
