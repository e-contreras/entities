
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "pagos", catalog = "econtreras", schema = "")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fec_pago", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @JoinColumn(name = "med_pago", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PaymentMethod paymentMethod;
    @JoinColumn(name = "solicitude", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Solicitude solicitude;    
}
