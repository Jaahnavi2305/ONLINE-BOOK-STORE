package com.bootapp.rest.restapp.data;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Publisher;




public interface PublisherRepository extends JpaRepository<Publisher, Integer>  {
	Optional<Publisher> findById(int publisherId);

}
