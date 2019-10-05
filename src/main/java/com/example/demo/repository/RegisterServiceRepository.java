package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.RegisterService;

public interface RegisterServiceRepository extends CrudRepository<RegisterService, Integer> {
	@Query("from RegisterService where account.idAccount=:id_account and status=1")
	public Iterable<RegisterService> findAllByUserId(@Param("id_account") int idAccount);

	@Query(value = "select *from register_service r inner join invoce i where r.id_account=:id_account and i.end_date> now()", nativeQuery = true)
	public Iterable<RegisterService> findAllByUserOnGoing(@Param("id_account") int idAccount);

	@Query(value = "select *from register_service r inner join invoce i on r.id=i.id_register_service where r.id_account=:id_account and i.start_date> now()", nativeQuery = true)
	public Iterable<RegisterService> findAllByUserUpComing(@Param("id_account") int idAccount);

	@Query(value = "select *from register_service r inner join invoce i on r.id=i.id_register_service INNER JOIN invoce_detail di on i.id=di.id_invoce where r.id_account=:id_account and i.end_date< now() and i.total_price<= (SELECT SUM(di.paid_money) WHERE di.id_invoce=i.id)", nativeQuery = true)
	public Iterable<RegisterService> findAllByAccomplished(@Param("id_account") int idAccount);

	@Override
	@Query("from RegisterService where id=:id and status=1")
	Optional<RegisterService> findById(@Param("id") Integer id);

	@Override
	@Query("from RegisterService where status=1")
	Iterable<RegisterService> findAll();
	
}
