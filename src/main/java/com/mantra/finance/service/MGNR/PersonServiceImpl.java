package com.mantra.finance.service.MGNR;

import com.mantra.finance.controller.MGNR.dto.CreatePersonDTO;
import com.mantra.finance.controller.MGNR.dto.UpdatePersonDTO;
import com.mantra.finance.exception.ClientException;
import com.mantra.finance.exception.ServerException;
import com.mantra.finance.model.MGNR.Person;
import com.mantra.finance.model.MGNR.PersonPost;
import com.mantra.finance.model.MSEC.User;
import com.mantra.finance.repository.MGNR.personPost.PersonPostRepository;
import com.mantra.finance.repository.MGNR.personPost.CustomPersonPostRepository;
import com.mantra.finance.repository.MSEC.CustomUserRepository;
import com.mantra.finance.repository.MGNR.person.PersonRepository;
import com.mantra.finance.repository.UserRepository;
import com.mantra.finance.tools.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final PersonPostRepository personPostRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomPersonPostRepository customPersonPostRepository;
    private final CustomUserRepository customUserRepository;

    @Transactional
    public Person create(CreatePersonDTO dto) {
        try {
            Person person = personRepository.save(dto.toPerson());
            if (dto.getUsername() != null) {
                userRepository.save(dto.toUser(person, passwordEncoder));
            }
            personPostRepository.saveAll(dto.toPersonPostList(person));
            return person;
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new ClientException("error.unique.constrains.violation", StringUtil.getUniquePropertyFromException(e));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("error.internal.server");
        }


    }

    @Override
    public List<Person> findAll(Integer companyId) {
        Optional<List<Person>> optionalPersonList = personRepository.findAllByIsDeletedIsFalseAndCompanyId_Id(companyId);
        if (optionalPersonList.isEmpty()) {
            throw new ClientException("error.no.person.found");
        } else return optionalPersonList.get();
    }

    @Override
    @Transactional
    public Person update(UpdatePersonDTO dto) {
        Optional<Person> optionalPerson = personRepository.findById(dto.getPersonId());
        if (optionalPerson.isEmpty()) {
            throw new ClientException("error.person.not.found.with.id", String.valueOf(dto.getPersonId()));
        }
        personRepository.save(dto.toPerson());
        if (dto.getUserId() != null) {
            Optional<User> optionalUser = userRepository.findById(dto.getUserId());
            if (optionalUser.isEmpty()) {
                throw new ClientException("error.user.not.found.with.id", String.valueOf(dto.getUserId()));
            }
            userRepository.save(dto.toUser(passwordEncoder));
        }
        if (!dto.getOrgChartList().isEmpty()) {
            List<Short> unAssignOrganChartIsList = dto.getDeletedOrgChartIdList();
            List<PersonPost> personPostListToAdd = dto.toPersonPostList();
            if (!personPostListToAdd.isEmpty()) {
                personPostRepository.saveAll(personPostListToAdd);
            }
            if (!unAssignOrganChartIsList.isEmpty()) {
                customPersonPostRepository.deletePrevPosts(dto.getPersonId(), unAssignOrganChartIsList);
            }
        }
        return null;
    }

    @Override
    public Person getOne(Long id) {

        Optional<Person> optionalPerson = personRepository.findByIdAndIsDeletedIsFalse(id);
        if (optionalPerson.isEmpty()) {
            throw new ClientException("error.person.not.found.with.id", String.valueOf(id));
        }
        return optionalPerson.get();
    }

    @Override
    @Transactional
    public Person delete(Long id) {
        Optional<Person> optionalPerson = personRepository.findByIdAndIsDeletedIsFalse(id);
        if (optionalPerson.isEmpty()) {
            throw new ClientException("error.person.not.found.with.id", String.valueOf(id));
        }
        try {
            customPersonPostRepository.deletePrevPosts(id);
            customUserRepository.deActiveUserByPersonId(optionalPerson.get().getId());
            personRepository.makePersonDeleted(id);
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServerException("error.internal.server");
        }
        return optionalPerson.get();
    }
}
