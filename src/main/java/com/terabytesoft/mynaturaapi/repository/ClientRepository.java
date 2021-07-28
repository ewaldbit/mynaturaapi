package com.terabytesoft.mynaturaapi.repository;

import com.terabytesoft.mynaturaapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
