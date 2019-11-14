
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "comp_not_debitos", catalog = "econtreras", schema = "")
public class PurchaseDebitNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "num_not_debito", nullable = false)
    private int debitNoteNumber;
    @Lob
    @Column(name = "comentario", length = 65535)
    private String comment;
    @Column(name = "num_doc_relacionado")
    private Integer relatedDocument;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseDebitNote")
    private List<PurchaseCreditNote> purchaseCreditNoteList;
    @JoinColumn(name = "proveedor", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Provider provider;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User creationUser;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User modificationUser;

}
