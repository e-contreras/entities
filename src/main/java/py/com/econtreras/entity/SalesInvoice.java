
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "fac_ventas", catalog = "econtreras", schema = "")
public class SalesInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "num_factura", nullable = false, length = 45)
    private String invoiceNumber;
    @Basic(optional = false)
    @Column(name = "fec_emision", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissionDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesInvoice")
    private List<SalesInvoiceDetail> facVenDetallesList;
    @JoinColumn(name = "fac_ven_timbrado", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ringing ringing;
}
