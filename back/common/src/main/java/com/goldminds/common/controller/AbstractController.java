//package com.goldminds.common.controller;
//
//import com.goldminds.common.Util.ResponseUtil;
//import com.goldminds.common.dto.AbstractDTO;
//import com.goldminds.common.mapper.AbstractMapper;
//import com.goldminds.common.model.AbstractEntity;
//import com.goldminds.common.service.AbstractService;
//import lombok.AllArgsConstructor;
//import org.slf4j.Logger;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
///**
// * @author bessam on 21/08/2021
// */
//
//
//@AllArgsConstructor
//public abstract class AbstractController<
//		DTO extends AbstractDTO,
//		ENTITY extends AbstractEntity<Long>,
//		MAPPER extends AbstractMapper<ENTITY, DTO>,
//		SERVICE extends AbstractService<DTO, ENTITY, MAPPER, REPOSITORY>,
//		REPOSITORY extends JpaRepository<ENTITY, Long>> {
//
//	public SERVICE service;
//
//	private Logger logger;
//
//
//
//
//
//	/**
//	 * {@code PUT  /:id} : Updates an existing entity.
//	 *
//	 * @param id     the id of the entity to save.
//	 * @param entity the entity to update.
//	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entity,
//	 * or with status {@code 400 (Bad Request)} if the entity is not valid,
//	 * or with status {@code 500 (Internal Server Error)} if the entity couldn't be updated.
//	 * @throws URISyntaxException if the Location URI syntax is incorrect.
//	 */
//	@PutMapping("/{id}")
//	public ResponseEntity<DTO> update(@PathVariable Long id, @RequestBody DTO entity) throws URISyntaxException {
//		if (entity.getId() == null) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "INVALID ID");
//		}
//		if (!Objects.equals(id, entity.getId())) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "INVALID ID");
//		}
//
//		if (!service.existsById(id)) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ENTITY WITH ID " + id + " IS NOT FOUND !");
//		}
//
//		DTO result = service.save(entity);
//		return ResponseEntity
//				.created(new URI("/" + result.getId()))
//				.body(result);
//	}
//
//	/**
//	 * {@code DELETE  /:id} : delete the "id" entity.
//	 *
//	 * @param id the id of the entity to delete.
//	 * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//	 */
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> delete(@PathVariable Long id) {
//		service.removeById(id);
//		return ResponseEntity
//				.noContent()
//				.build();
//	}
//
//
//}
