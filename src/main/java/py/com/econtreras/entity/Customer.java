package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "clientes")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "borrado", nullable = false)
    private short erased;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAlta;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @Column(name = "fec_eliminacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEliminacion;
    @JoinColumn(name = "persona", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Person person;

}
