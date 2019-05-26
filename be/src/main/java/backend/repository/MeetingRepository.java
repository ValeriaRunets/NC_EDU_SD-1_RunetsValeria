package backend.repository;

import backend.entity.Meeting;
import backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    //@Query(value="SELECT * FROM MEETING WHERE dateOfEnd >date2 AND dateOfEnd<d2", nativeQuery = true)
    List<Meeting> findAllByDateOfEndBetweenOrderByDateOfTheBeginning(Date d1, Date d2);
    List<Meeting> findAllByDateOfTheBeginningAfterOrDateOfEndBefore(Date date, Date d);
}
