package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalTasks.TASK1;
import static seedu.address.testutil.TypicalTasks.TASK2;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TaskBuilder;

public class TaskTest {

    @Test
    public void isSameTask() {
        // same object -> returns true
        assertTrue(TASK1.isSameTask(TASK1));

        // null -> returns false
        assertFalse(TASK1.isSameTask(null));

        // same name, same description -> returns true
        Task editedTask1 = new TaskBuilder(TASK1).build();
        assertTrue(TASK1.isSameTask(editedTask1));

        // different name, same description -> returns false
        editedTask1 = new TaskBuilder(TASK1).withDescription("Hello world").build();
        assertFalse(TASK1.isSameTask(editedTask1));

        // same name, different description -> returns false
        editedTask1 = new TaskBuilder(TASK1).withName("Say goodbye").build();
        assertFalse(TASK1.isSameTask(editedTask1));

    }

    @Test
    public void equals() {
        // same values -> returns true
        Task taskCopy = new TaskBuilder(TASK1).build();
        assertTrue(TASK1.equals(taskCopy));

        // same object -> returns true
        assertTrue(TASK1.equals(TASK1));

        // null -> returns false
        assertFalse(TASK1.equals(null));

        // different type -> returns false
        assertFalse(TASK1.equals(5));

        // different task -> returns false
        assertFalse(TASK1.equals(TASK2));

        // different name -> returns false
        Task editedTask = new TaskBuilder(TASK1).withName(TASK2.getName().taskName).build();
        assertFalse(TASK1.equals(editedTask));

        // different description -> returns false
        editedTask = new TaskBuilder(TASK1).withDescription(TASK2.getDescription().description).build();
        assertFalse(TASK1.equals(editedTask));

    }

    @Test
    public void toStringMethod() {
        String expected = String.format("%s{name=%s, description=%s}",
                Task.class.getCanonicalName(), TASK1.getName(), TASK1.getDescription());
        assertEquals(expected, TASK1.toString());
    }
}