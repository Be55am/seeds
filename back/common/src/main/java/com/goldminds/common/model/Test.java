package com.goldminds.common.model;

import lombok.*;

import javax.persistence.Entity;

/**
 * @author bessam on 24/08/2021
 */

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Test extends AbstractEntity<Long>{

	private String test;

}
