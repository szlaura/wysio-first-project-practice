package hu.wysio.datamanager.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Vendeg extends AbstractEntity {

	@Column(nullable = false)
	@NotNull
	private String becenev;

	@Column(nullable = false)
	@NotNull
	@Positive
	private Integer bicepszMeret;

	@Column(nullable = false)
	@NotNull
	private String majerosseg;

}
