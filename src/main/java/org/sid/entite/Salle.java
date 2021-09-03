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
@Table (name="salle")
public class Salle {
	@Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long num;
private String etage;
	private String etat="libre";// libre: n'est pas mentionnée ds la table d"accée /nonLibre != libre/prise par un prof
	private String type;
	/*
	 * @OneToMany (mappedBy = "salle") private Collection<TableAccee> tableAccee;
	 */

}
