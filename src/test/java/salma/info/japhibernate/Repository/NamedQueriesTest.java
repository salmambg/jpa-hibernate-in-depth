package salma.info.japhibernate.Repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import salma.info.japhibernate.Entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class NamedQueriesTest {
    @Autowired
    EntityManager entityManager;

    @Test
    public void basic() {
        Query query = entityManager.createNamedQuery("QUERY_ALL_COURSES");
        List resultList = query.getResultList();
        System.out.println(resultList);
    }

    @Test
    public void basic_typed() {
        TypedQuery<Course> query = entityManager.createNamedQuery("QUERY_ALL_COURSES", Course.class);
        List<Course> resultList = query.getResultList();
        System.out.println(resultList);
    }
}
