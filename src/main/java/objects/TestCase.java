package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {

    String testTitle;
    String testStatus;
    String testDescription;
    String testForSuite;
    String testSeverity;
    String testPriority;
    String testType;
    String testLayer;
    String testIsFlaky;
    String testMilestone;
    String testBehavior;
    String testAutomationStatus;
    String testPreconditions;
    String testPostconditions;
}
