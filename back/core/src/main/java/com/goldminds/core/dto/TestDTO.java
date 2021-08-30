package com.goldminds.core.dto;

import com.goldminds.common.dto.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author bessam on 22/08/2021
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class TestDTO extends AbstractDTO {

	String test;
}
