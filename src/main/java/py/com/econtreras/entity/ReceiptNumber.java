package py.com.econtreras.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "num_doc_tributarios")
public class ReceiptNumber {
    @EmbeddedId
    private ReceiptNumberPK id;
    @Column
    private Integer sequence;
}

