package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "mer_solicitudes", catalog = "econtreras", schema = "")
public class ProductSolicitude implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductSolicitudePK merSolicitudesPK;
    @Basic(optional = false)
    @Column(name = "cant", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "pre_unitario", nullable = false)
    private double price;
    @JoinColumn(name = "mercaderia", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "solicitud", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Solicitude solicitude;    
}
