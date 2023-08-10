package com.pluralsight.springboot.tickets.registration;

import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController()
@RequestMapping(path = "/registrations")
public class RegistrationController {

    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration create(@RequestBody Registration registration) {
        return registrationRepository.create(registration);
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration read(@PathVariable("ticketCode") String ticketCode) {
        return registrationRepository.findByTicketCode(ticketCode).orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));
    }

    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        return registrationRepository.update(registration);
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }

}
