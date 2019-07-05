package com.data.dataproject.repository;

import com.data.dataproject.domain.market.LocalFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LocalRepository extends JpaRepository<LocalFood, Long> {
    Optional<LocalFood> findById(Long id);
    List<LocalFood> findAllByCity(String resion);

    @Modifying
    @Query(value = "SELECT *, (" +
            "    3959 * acos (" +
            "      cos ( radians( :latitude ) )  " +
            "      * cos( radians( latitude ) )" +
            "      * cos( radians( longitude ) - radians( :longitude ) )" +
            "      + sin ( radians( :latitude ) )" +
            "      * sin( radians( latitude ) )" +
            "    )" +
            "  ) AS distance" +
            "  FROM localfood" +
            "  HAVING distance < :radius" +
            "  ORDER BY distance" +
            "  LIMIT 0 , 20", nativeQuery = true)
    List<LocalFood> findAllByAddress(@Param("latitude") final float latitude,
                              @Param("longitude") final float longitude,
                                  @Param("radius") final float radius);
}
