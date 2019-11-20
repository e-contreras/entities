package py.com.econtreras.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ReceiptNumberPK implements Serializable {

    @NotNull
    @Size(max = 3)
    private String branch;
    @NotNull
    @Size(max = 3)
    private String salePoint;
}
