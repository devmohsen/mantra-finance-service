package com.mantra.finance.controller.MGNR;


import com.mantra.finance.controller.MGNR.dto.CreatePersonDTO;
import com.mantra.finance.controller.MGNR.dto.UpdatePersonDTO;
import com.mantra.finance.exception.ClientException;
import com.mantra.finance.model.MGNR.Person;
import com.mantra.finance.service.MGNR.PersonService;
import com.mantra.finance.tools.JwtUtil;
import com.mantra.finance.tools.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<CreatePersonDTO> create(@RequestBody @Valid CreatePersonDTO dto) {
        if (!StringUtil.validateNationalCode(dto.getNationalCode())){
            throw new ClientException("error.national.code.pattern");
        }
        return ResponseEntity.ok().body(dto.fromModel(personService.create(dto)));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll(HttpServletRequest request) {
        Integer companyId = jwtUtil.getCompanyIdFromHeader(request);
        if (companyId == null) {
            throw new ClientException("error.token.value.exception", "companyId");
        }
        return ResponseEntity.ok(personService.findAll(companyId));
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody @Valid UpdatePersonDTO dto) {
        return ResponseEntity.ok(personService.update(dto));
    }

    @GetMapping("by-id")
    public ResponseEntity<Person> getOne(@RequestParam("id") Long id) {
        return ResponseEntity.ok(personService.getOne(id));
    }

    @DeleteMapping
    public ResponseEntity<Person> delete(@RequestParam("id") Long id) {
        return ResponseEntity.ok(personService.delete(id));
    }

}
