
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "transacciones", catalog = "econtreras", schema = "")
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Lob
    @Column(name = "men_portadora", length = 65535)
    private String cardProcessorMessage;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "solicitude", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Solicitude solicitude;
}
