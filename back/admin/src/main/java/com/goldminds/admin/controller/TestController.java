package com.goldminds.admin.controller;

import com.goldminds.common.controller.*;
import com.goldminds.core.dto.TestDTO;
import com.goldminds.core.service.TestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;


/**
 * @author bessam on 22/08/2021
 */


@RestController
@RequestMapping("/test")
public class TestController implements
        PersistableController<TestDTO>,
        QueryableController<TestDTO>,
        UpdatableController<TestDTO>,
        RemovableController<TestDTO> {

    private final PersistableController<TestDTO> persistableController;
    private final QueryableController<TestDTO> queryableController;
    private final RemovableController<TestDTO> removableController;
    private final UpdatableController<TestDTO> updatableController;

    public TestController(TestService testService) {
        this.persistableController = new PersistableControllerImpl<>(testService);
        this.queryableController = new QueryableControllerImpl<>(testService);
        this.removableController = new RemovableControllerImpl<>(testService);
        this.updatableController = new UpdatableControllerImpl<>(testService);
    }


    @Override
    @PostMapping
    public ResponseEntity<TestDTO> save(TestDTO dto) throws URISyntaxException {
        return persistableController.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<Collection<TestDTO>> saveAll(Collection<TestDTO> list) {
        return persistableController.saveAll(list);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TestDTO> findById(@PathVariable Long id) {
        return queryableController.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<TestDTO>> findAll() {
        return queryableController.findAll();
    }

    @Override
    @GetMapping("/pages")
    public ResponseEntity<Page<TestDTO>> findAll(Pageable pageable) {
        return queryableController.findAll(pageable);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return removableController.delete(id);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<TestDTO> update(@PathVariable Long id, @RequestBody TestDTO testDTO) {
        return updatableController.update(id, testDTO);
    }
}
