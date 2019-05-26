package backend.repository;

import backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "select distinct * FROM room where id not in (select room_id from meeting where " +
            "(STR_TO_DATE(:d1, '%Y-%m-%dT%H:%i:%sZ') between date_of_the_beginning and date_of_end) or " +
            "((STR_TO_DATE(:d1, '%Y-%m-%dT%H:%i:%sZ') <=date_of_the_beginning and STR_TO_DATE(:d2, '%Y-%m-%dT%H:%i:%sZ') >= date_of_the_beginning)))", nativeQuery = true)
    List<Room> findFree(@Param("d1") String d1, @Param("d2") String d2);
}
