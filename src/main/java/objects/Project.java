package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    String projectName;
    String projectCode;
    String projectDescription;
    String projectAccessType;
    String memberAccess;
    String groupName;
}
