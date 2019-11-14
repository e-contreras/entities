
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "traslados", catalog = "econtreras", schema = "")
public class Transfer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "fec_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solicitudeDate;
    @Column(name = "fec_pre_traslado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferSheduled;
    @Column(name = "fec_traslado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDate;
    @OneToMany(mappedBy = "transfer")
    private List<WorkOrder> workOrderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transfer")
    private List<TransferDetail> transferDetailList;
    @JoinColumn(name = "dep_origen", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Warehouse origin;
    @JoinColumn(name = "dep_destino", referencedColumnName = "id")
    @ManyToOne
    private Warehouse destiny;
    @JoinColumn(name = "chofer", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User driver;
    @JoinColumn(name = "vehiculo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Vehicle vehicle;

}
