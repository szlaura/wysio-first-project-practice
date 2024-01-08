package hu.wysio.datamanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Kocsmazas extends AbstractEntity {

	@Column(nullable = false)
	@NotNull
	private Date mettol;

	@Column
	private Date meddig;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn
	private List<Fogyasztas> fogyasztasLista;

	@Column
	private Boolean detoxbaKerules;
}
