package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "not_credito", catalog = "econtreras", schema = "")
public class CreditNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "num_doc_relacionado", nullable = false, length = 45)
    private String relatedDocument;
    @Basic(optional = false)
    @Column(name = "fec_emision", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date emisionDate;
    @Lob
    @Column(name = "comentario", length = 65535)
    private String comment;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditNote")
    private List<CreditNoteDetail> creditNoteDetailList;
    @JoinColumn(name = "timbrado", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ringing ringing;
    @JoinColumn(name = "destinatario", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User destiny;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private User creationUser;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private User modificationUser;
}
