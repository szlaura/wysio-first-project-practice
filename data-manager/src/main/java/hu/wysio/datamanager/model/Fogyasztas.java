package hu.wysio.datamanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Fogyasztas extends AbstractEntity {

	@ManyToOne(optional = false)
	@NotNull
	private Vendeg vendeg;

	@ManyToOne(optional = false)
	@NotNull
	private Ital ital;

	//italbol hany egysegnyit fogyaszt el, pl. rendelt 2 sort, akkor 2 egysegnyit fogyaszt el
	@Column(nullable = false)
	@NotNull
	@Positive
	private Integer hanyEgysegetFogyasztott;
}
