
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "rem_no_entregadas", catalog = "econtreras", schema = "")
public class UndeliberedRemissionNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fec_evento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;
    @Lob
    @Column(name = "comentario", length = 65535)
    private String comment;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @JoinColumn(name = "evento", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Event event;
    @JoinColumn(name = "ord_trabajo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private WorkOrder workOrder;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private User creationUser;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private User modificationUser;
}
