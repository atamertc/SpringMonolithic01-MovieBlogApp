package com.atamertc.repository;

import com.atamertc.repository.entity.Movie;
import com.atamertc.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);

    //Email ve passworda göre kullanıcı kontrolu
    Optional<User> findOptionalByEmailAndPassword(String email, String password);

    List<User> findAllByNameContainingIgnoreCase(String value);

    //Kullanıcıları isme göre sıralı getiriniz
    List<User> findAllByOrderByName();

    //Emailleri belirlediğimiz değere göre biten kullanıcılar
    List<User> findAllByEmailEndingWith(String value);

    /*Passwordunun uzunluğu belirediğimiz sayıdan buyuk olanlar (Query yazılacak)*/

    // ? isareti ile alinan parametreleri sirali almak zorundayiz metodta
    @Query("SELECT u FROM User u WHERE length(u.password) >?1")
    List<User> findAllByPasswordLongerThan(Integer sayi);

    @Query(value = "SELECT * FROM tbl_user WHERE length(password)>?1", nativeQuery = true)
    List<User> findAllByPasswordLongerThan2(Integer sayi);

    // : isareti ile alinan parametreleri sirali almak zorunda degiliz
    @Query("SELECT u FROM User u WHERE length(u.password) >:x")
    List<User> findAllByPasswordLongerThan3(@Param("x") Integer sayi);

}
