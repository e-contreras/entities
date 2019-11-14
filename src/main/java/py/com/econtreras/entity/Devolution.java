package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "devoluciones", catalog = "econtreras", schema = "")
public class Devolution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fec_alta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @Lob
    @Column(name = "comentarios", nullable = false, length = 65535)
    private String comment;
    @Basic(optional = false)
    @Column(name = "concepto", nullable = false, length = 100)
    private String concept;
    @JoinColumn(name = "mercaderia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Product product;

}
