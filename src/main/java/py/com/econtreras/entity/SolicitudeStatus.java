
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "estados", catalog = "econtreras", schema = "")
public class SolicitudeStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom_estado", nullable = false, length = 45)
    private String statusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Solicitude> solicitudeList;
}
