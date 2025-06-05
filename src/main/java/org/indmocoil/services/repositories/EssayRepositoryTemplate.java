package org.indmocoil.services.repositories;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.spring.data.datastore.core.DatastoreTemplate;
import org.indmocoil.services.entities.Essay;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EssayRepositoryTemplate {

    private final DatastoreTemplate datastoreTemplate;
    public EssayRepositoryTemplate(DatastoreTemplate datastoreTemplate) {
        this.datastoreTemplate = datastoreTemplate;
    }

    public Essay findByEssayId(String id){
        return datastoreTemplate.findById(id, Essay.class);
    }
    public Essay saveEssay(Essay essay){
        datastoreTemplate.save(essay);
        return essay;
    }

    public Essay deleteEssay(Essay essay){
        datastoreTemplate.delete(essay);
        return essay;
    }

    public List<Essay> findAllEssays(){

        return datastoreTemplate.findAll(Essay.class).stream().toList();

    }
    public List<Essay> findByHeading(String heading){
        EntityQuery query =
                Query.newEntityQueryBuilder()
                        .setKind("essay")
                        .setFilter(StructuredQuery.PropertyFilter.eq("heading", heading))
                        .build();
        return datastoreTemplate.query(query, Essay.class).toList();

    }

    public Essay findById(String essayId) {
        return datastoreTemplate.findById(essayId, Essay.class);
    }
}
