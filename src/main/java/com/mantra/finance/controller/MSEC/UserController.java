package com.mantra.finance.controller.MSEC;

import com.mantra.finance.controller.MGNR.dto.LoginDTO;
import com.mantra.finance.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RequestMapping("user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("get-login-dto")
    public Collection<LoginDTO> getLoginDto(@RequestParam String username, @RequestParam int mantraKey) {
        return userService.getLoginDto(username, mantraKey);
    }

    @GetMapping("role-test")
    @PreAuthorize("hasRole('USER_WRITE')")
    public String test() {
        return "mohsen" ;
    }

}
