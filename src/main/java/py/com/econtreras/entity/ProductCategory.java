
package py.com.econtreras.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "cat_mercaderias", catalog = "econtreras", schema = "")
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 45)
    private String description;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @JoinTable(name = "sol_pre_categorias", joinColumns = {
        @JoinColumn(name = "cat_productos_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "sol_presupuesto_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<BugetSolicitude> bugetSolicitudeList;
    @JoinTable(name = "cat_pro_proveedores", joinColumns = {
        @JoinColumn(name = "cat_productos_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "proveedores_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<Provider> providerList;
    @JoinColumn(name = "usu_alta", referencedColumnName = "id")
    @ManyToOne
    private User creationUser;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "id")
    @ManyToOne
    private User modificationUser;
    
}
