
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "timbrados", catalog = "econtreras", schema = "")
public class Ringing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "timbrado", nullable = false, length = 45)
    private String ringing;
    @Basic(optional = false)
    @Column(name = "fec_validez", nullable = false, columnDefinition = "DATE")
    private LocalDate validityDate;
    @Basic(optional = false)
    @Column(name = "tic_documento", nullable = false, length = 10)
    private String documentType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ringing")
    private List<CreditNote> creditNoteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ringing")
    private List<SalesInvoice> salesInvoiceList;
    @Basic(optional = false)
    @Column(name = "borrado")
    private boolean deleted;
    
}
