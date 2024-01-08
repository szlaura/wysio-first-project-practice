package hu.wysio.datamanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Bunyo extends AbstractEntity {

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Size(min = 2)
	private List<VendegInBunyo> vendegInBunyoList;

	@Column(nullable = false)
	@NotNull
	private LocalDateTime mettol;

	@Column
	private LocalDateTime meddig;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Vendeg nyertes;

}
