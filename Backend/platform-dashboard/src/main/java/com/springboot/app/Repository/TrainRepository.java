package com.springboot.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.app.Model.Train;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

    // Custom query to find trains by platform using method name
    List<Train> findByPlatform(String platform);

    // Custom query to find trains by platform using @Query
    @Query("SELECT t FROM Train t WHERE t.platform = :platform")
    List<Train> findByPlatformUsingQuery(@Param("platform") String platform);

    // Custom query to find trains with arrival time after a specified time
    @Query("SELECT t FROM Train t WHERE t.arrivalTime > :time")
    List<Train> findTrainsArrivingAfter(@Param("time") LocalDateTime time);

    // You can add additional queries if needed
}

