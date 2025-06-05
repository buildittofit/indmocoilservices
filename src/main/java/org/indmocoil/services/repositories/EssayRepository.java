package org.indmocoil.services.repositories;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import com.google.cloud.spring.data.datastore.core.DatastoreTemplate;
import com.google.cloud.spring.data.datastore.repository.query.Query;
import lombok.AllArgsConstructor;
import org.indmocoil.services.entities.Essay;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;

public interface EssayRepository extends DatastoreRepository<Essay, String> {
//    @Query("select * from  |com.example.Singer| where last_name = @name")
//    Slice<Singer> findSingersByLastName(@Param("name") String name, Pageable pageable);

    @Query("Select * from essay where heading = @heading")
    Iterable<Essay> findEssaysByHeading(@Param("heading") String heading);

    @Query("select distinct heading from essay limit 200")
    Iterable<Essay> findAllheadings();

}
