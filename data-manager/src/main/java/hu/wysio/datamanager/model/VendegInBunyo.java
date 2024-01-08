package hu.wysio.datamanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VendegInBunyo extends AbstractEntity {

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Vendeg vendeg;

	@Column
	@NotNull
	private boolean isKiesett;

	public VendegInBunyo(Vendeg vendeg) {
		super(vendeg.id);
		this.vendeg = vendeg;
		this.isKiesett = false;
	}
}
