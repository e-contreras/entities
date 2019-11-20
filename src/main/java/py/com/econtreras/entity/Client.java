package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "clientes", catalog = "econtreras", schema = "")
public class Client {
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "borrado", nullable = false, columnDefinition = "0")
    private boolean erased;
    @Column(name = "fec_alta", columnDefinition = "DATETIME")
    private LocalDateTime insertDate;
    @Column(name = "fec_modificacion", columnDefinition = "DATETIME")
    private LocalDateTime eliminationDate;
    @Column(name = "fec_modificacion", columnDefinition = "DATETIME", insertable=false, updatable =false)
    private LocalDateTime modificationDate;
    @JoinColumn(name = "persona", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Person person;

}
