package com.pluralsight.springboot.tickets.events;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganiserRepository extends JpaRepository<Organiser, Integer> {
}
