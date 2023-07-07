package repository;

import org.springframework.data.repository.CrudRepository;

import entities.Account;

public interface AccountDAO extends CrudRepository<Account, Long>{

}
