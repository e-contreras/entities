package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "cuotas", catalog = "econtreras", schema = "")
public class Fee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "cuota")
    private Integer feeNumber;
    @Column(name = "ponderador")
    private BigDecimal ponderator;
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne
    private Category category;

}
