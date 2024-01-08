package hu.wysio.datamanager.model;


import slombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Ital extends AbstractEntity {

	@Column(unique = true, nullable = false)
	@NotNull
	@NotEmpty
	private String nev;

	@Column(nullable = false)
	@NotNull
	@PositiveOrZero
	private Double alkoholTartalom;

	@Column(nullable = false)
	@NotNull
	@Positive
	private Integer egyAdagMennyisege;
}
