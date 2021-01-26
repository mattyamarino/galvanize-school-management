import model.School;

import java.util.ArrayList;
import java.util.List;


public class SchoolService {

    List<School> schools = new ArrayList<>();

    public School addSchool(School schoolToAdd) {
        schools.add(schoolToAdd);
        return schoolToAdd;
    }
}
