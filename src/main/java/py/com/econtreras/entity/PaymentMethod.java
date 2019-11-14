
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "med_pagos", catalog = "econtreras", schema = "")
public class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 45)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentMethod")
    private List<Payment> paymentList;
    
}
