
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "com_not_deb_detalles", catalog = "econtreras", schema = "")
public class PurchaseCreditNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "concepto", nullable = false, length = 100)
    private String concept;
    @Basic(optional = false)
    @Column(name = "cant", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "monto", nullable = false)
    private double amount;
    @JoinColumn(name = "comp_not_debito", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PurchaseDebitNote purchaseDebitNote;

}
