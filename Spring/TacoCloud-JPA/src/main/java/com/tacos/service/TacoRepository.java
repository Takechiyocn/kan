package com.tacos.service;

import org.springframework.data.repository.CrudRepository;
import com.tacos.domain.Taco;

public interface TacoRepository
        extends CrudRepository<Taco, Long> {
}
