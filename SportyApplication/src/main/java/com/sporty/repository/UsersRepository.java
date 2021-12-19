package com.sporty.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sporty.DTO.usersDTO;
import com.sporty.entity.AppUsers;
//import com.sporty.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<AppUsers, Long> {

	@Override
	default <S extends AppUsers> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	};

	AppUsers findById(long id);

	void delete(AppUsers user);

	@Query(value = "select u from AppUsers u where u.userName=?1 and u.password=?2")
	AppUsers findByUserNameAndPassword(String userName, String password);

	@Query(value = "select u from AppUsers u where u.userTypeId=?1")
	List<AppUsers> findByUserType(int userTypeId);

	@Modifying
	@Transactional
	@Query(value = "update AppUsers u set u.password=:new_password where u.id=:id")
	void changePassword(@Param(value = "new_password") String password, @Param(value = "id") Long id);
	
	@Query(value="select new com.sporty.DTO.usersDTO(u.id,u.firstName,u.lastName) from AppUsers u")
	List<usersDTO> findAllUserDetails();
}
