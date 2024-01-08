package hu.wysio.datamanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

}
