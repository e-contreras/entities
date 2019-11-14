package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "not_cre_detalles", catalog = "econtreras", schema = "")
public class CreditNoteDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "concepto", nullable = false, length = 45)
    private String concept;
    @Basic(optional = false)
    @Column(name = "cant", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "monto", nullable = false)
    private double amount;
    @Basic(optional = false)
    @Column(name = "tip_impuesto", nullable = false)
    private int taxeTaype;
    @JoinColumn(name = "not_credito", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CreditNote creditNote;
    
}
