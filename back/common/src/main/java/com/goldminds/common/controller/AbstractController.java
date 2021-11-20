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

//
//
//}
