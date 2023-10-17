package seedu.address.model.gradedtest;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.expectedgrade.ExpectedGrade;

public class GradedTest {
    public static final String MESSAGE_CONSTRAINTS = "Graded Test Scores should be Alphanumeric";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";
    public static final String DEFAULT_VALUE = "-";
    // Identity fields
    private final String gradedTestsIndv;

    // Data fields
    private final Set<ExpectedGrade> expectedGrades = new HashSet<>();
    private final ReadingAssessment readingAssessment1;
    private final ReadingAssessment readingAssessment2;
    private final MidTerms midTerms;
    private final Finals finals;
    private final PracticalExam practicalExam;

    /**
     * Constructs a {@code GradedTest}.
     *
     * @param readingAssessment1 The first reading assessment.
     * @param readingAssessment2 The second reading assessment.
     * @param midTerms The mid-terms.
     * @param finals The finals.
     * @param practicalExam The practical exam.
     */
    public GradedTest(ReadingAssessment readingAssessment1, ReadingAssessment readingAssessment2,
                      MidTerms midTerms, Finals finals, PracticalExam practicalExam) {
        requireAllNonNull(readingAssessment1, readingAssessment2, midTerms, finals, practicalExam);
        this.readingAssessment1 = readingAssessment1;
        this.readingAssessment2 = readingAssessment2;
        this.midTerms = midTerms;
        this.finals = finals;
        this.practicalExam = practicalExam;
        this.gradedTestsIndv = readingAssessment1.toString() + readingAssessment2.toString() + midTerms.toString()
                + finals.toString() + practicalExam.toString();
    }

    /**
     * Constructs a {@code GradedTest}.
     *
     * @param gradedTestsIndv A valid gradedTest name.
     */
    public GradedTest(String gradedTestsIndv) {
        requireNonNull(gradedTestsIndv);
        // checkArgument(Boolean.valueOf(VALIDATION_REGEX));
        this.gradedTestsIndv = gradedTestsIndv;
        this.readingAssessment1 = new ReadingAssessment(DEFAULT_VALUE);
        this.readingAssessment2 = new ReadingAssessment(DEFAULT_VALUE);
        this.midTerms = new MidTerms(DEFAULT_VALUE);
        this.finals = new Finals(DEFAULT_VALUE);
        this.practicalExam = new PracticalExam(DEFAULT_VALUE);
    }

    public ReadingAssessment getRA1() {
        return readingAssessment1;
    }

    public ReadingAssessment getRA2() {
        return readingAssessment2;
    }

    public MidTerms getMidTerms() {
        return midTerms;
    }

    public Finals getFinals() {
        return finals;
    }

    public PracticalExam getPracticalExam() {
        return practicalExam;
    }

    public String getGradedTests() {
        return gradedTestsIndv;
    }

    /**
     * Returns an immutable gradedTest set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<ExpectedGrade> getExpectedGrade() {
        return Collections.unmodifiableSet(expectedGrades);
    }

    /**
     * Returns true if a given string is a valid gradedTest name.
     */
    public static boolean isValidGradeTestName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if both tasks have the same name and description.
     */
    public boolean isSameGradedTest(GradedTest otherGradedTest) {
        if (otherGradedTest == this) {
            return true;
        }

        return otherGradedTest != null
                && otherGradedTest.getGradedTests().equals(getGradedTests())
                && otherGradedTest.getRA1().equals(getRA1())
                && otherGradedTest.getRA2().equals(getRA2())
                && otherGradedTest.getMidTerms().equals(getMidTerms())
                && otherGradedTest.getFinals().equals(getFinals())
                && otherGradedTest.getPracticalExam().equals(getPracticalExam());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof GradedTest)) {
            return false;
        }

        GradedTest otherTest = (GradedTest) other;
        return readingAssessment1.equals(otherTest.readingAssessment1)
                && readingAssessment2.equals(otherTest.readingAssessment2)
                && midTerms.equals(otherTest.midTerms)
                && finals.equals(otherTest.finals)
                && practicalExam.equals(otherTest.practicalExam);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(readingAssessment1, readingAssessment2, midTerms, finals, practicalExam);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("Reading Assessment 1", readingAssessment1 + "\n")
                .add("Reading Assessment 2", readingAssessment2 + "\n")
                .add("MidTerms", midTerms + "\n")
                .add("Finals", finals + "\n")
                .add("Practical Exam", practicalExam + "\n")
                .toString();
    }

}
