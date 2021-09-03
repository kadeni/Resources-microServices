package org.sid.entite;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name="seance")
public class Seance {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	private String debut;
	private String fin;
	/*
	 * @OneToMany (mappedBy = "seance") private Collection<TableAccee> tableAccee;
	 */
}
