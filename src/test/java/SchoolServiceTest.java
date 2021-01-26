
import model.School;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchoolServiceTest{
    SchoolService service = new SchoolService();

    @Test
    public void addSchool_returnsAddedSchool_andAddsItToList() {
        School school1 = new School();
        School result = service.addSchool(school1);
        assertEquals(school1, result);
        assertEquals(school1, service.schools.get(0));

    }
}