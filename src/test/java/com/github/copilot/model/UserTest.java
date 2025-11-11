package com.github.copilot.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test class for User model.
 * Tests all methods including equals(), hashCode(), toString(),
 * constructors, getters, and setters.
 */
public class UserTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Should create user with default constructor")
        public void shouldCreateUserWithDefaultConstructor() {
            User user = new User();
            
            assertNotNull(user);
            assertNull(user.getId());
            assertNull(user.getName());
            assertNull(user.getEmail());
            assertNull(user.getRole());
        }

        @Test
        @DisplayName("Should create user with parameterized constructor")
        public void shouldCreateUserWithParameterizedConstructor() {
            User user = new User(1L, "John Doe", "john@example.com", "admin");
            
            assertNotNull(user);
            assertEquals(1L, user.getId());
            assertEquals("John Doe", user.getName());
            assertEquals("john@example.com", user.getEmail());
            assertEquals("admin", user.getRole());
        }
    }

    @Nested
    @DisplayName("Getter and Setter Tests")
    class GetterSetterTests {

        @Test
        @DisplayName("Should set and get id correctly")
        public void shouldSetAndGetId() {
            User user = new User();
            user.setId(42L);
            
            assertEquals(42L, user.getId());
        }

        @Test
        @DisplayName("Should set and get name correctly")
        public void shouldSetAndGetName() {
            User user = new User();
            user.setName("Jane Smith");
            
            assertEquals("Jane Smith", user.getName());
        }

        @Test
        @DisplayName("Should set and get email correctly")
        public void shouldSetAndGetEmail() {
            User user = new User();
            user.setEmail("jane@example.com");
            
            assertEquals("jane@example.com", user.getEmail());
        }

        @Test
        @DisplayName("Should set and get role correctly")
        public void shouldSetAndGetRole() {
            User user = new User();
            user.setRole("user");
            
            assertEquals("user", user.getRole());
        }
    }

    @Nested
    @DisplayName("Equals Method Tests")
    class EqualsTests {

        @Test
        @DisplayName("Should return true when comparing same object")
        public void shouldReturnTrueForSameObject() {
            User user = new User(1L, "John Doe", "john@example.com", "admin");
            
            assertEquals(user, user);
        }

        @Test
        @DisplayName("Should return true for users with same values")
        public void shouldReturnTrueForUsersWithSameValues() {
            User user1 = new User(1L, "John Doe", "john@example.com", "admin");
            User user2 = new User(1L, "John Doe", "john@example.com", "admin");
            
            assertEquals(user1, user2);
        }

        @Test
        @DisplayName("Should return false when comparing with null")
        public void shouldReturnFalseForNull() {
            User user = new User(1L, "John Doe", "john@example.com", "admin");
            
            assertNotEquals(user, null);
        }

        @Test
        @DisplayName("Should return false when comparing with different class")
        public void shouldReturnFalseForDifferentClass() {
            User user = new User(1L, "John Doe", "john@example.com", "admin");
            String notAUser = "not a user";
            
            assertNotEquals(user, notAUser);
        }

        @Test
        @DisplayName("Should return false for users with different ids")
        public void shouldReturnFalseForDifferentIds() {
            User user1 = new User(1L, "John Doe", "john@example.com", "admin");
            User user2 = new User(2L, "John Doe", "john@example.com", "admin");
            
            assertNotEquals(user1, user2);
        }

        @Test
        @DisplayName("Should return false for users with different names")
        public void shouldReturnFalseForDifferentNames() {
            User user1 = new User(1L, "John Doe", "john@example.com", "admin");
            User user2 = new User(1L, "Jane Doe", "john@example.com", "admin");
            
            assertNotEquals(user1, user2);
        }

        @Test
        @DisplayName("Should return false for users with different emails")
        public void shouldReturnFalseForDifferentEmails() {
            User user1 = new User(1L, "John Doe", "john@example.com", "admin");
            User user2 = new User(1L, "John Doe", "jane@example.com", "admin");
            
            assertNotEquals(user1, user2);
        }

        @Test
        @DisplayName("Should return false for users with different roles")
        public void shouldReturnFalseForDifferentRoles() {
            User user1 = new User(1L, "John Doe", "john@example.com", "admin");
            User user2 = new User(1L, "John Doe", "john@example.com", "user");
            
            assertNotEquals(user1, user2);
        }
    }

    @Nested
    @DisplayName("HashCode Method Tests")
    class HashCodeTests {

        @Test
        @DisplayName("Should return same hashCode for users with same values")
        public void shouldReturnSameHashCodeForUsersWithSameValues() {
            User user1 = new User(1L, "John Doe", "john@example.com", "admin");
            User user2 = new User(1L, "John Doe", "john@example.com", "admin");
            
            assertEquals(user1.hashCode(), user2.hashCode());
        }

        @Test
        @DisplayName("Should return different hashCode for users with different values")
        public void shouldReturnDifferentHashCodeForUsersWithDifferentValues() {
            User user1 = new User(1L, "John Doe", "john@example.com", "admin");
            User user2 = new User(2L, "Jane Doe", "jane@example.com", "user");
            
            assertNotEquals(user1.hashCode(), user2.hashCode());
        }

        @Test
        @DisplayName("Should return consistent hashCode for same object")
        public void shouldReturnConsistentHashCode() {
            User user = new User(1L, "John Doe", "john@example.com", "admin");
            
            int hashCode1 = user.hashCode();
            int hashCode2 = user.hashCode();
            
            assertEquals(hashCode1, hashCode2);
        }
    }

    @Nested
    @DisplayName("ToString Method Tests")
    class ToStringTests {

        @Test
        @DisplayName("Should return string representation with all fields")
        public void shouldReturnStringRepresentationWithAllFields() {
            User user = new User(1L, "John Doe", "john@example.com", "admin");
            String result = user.toString();
            
            assertNotNull(result);
            assertTrue(result.contains("User{"));
            assertTrue(result.contains("id=1"));
            assertTrue(result.contains("name='John Doe'"));
            assertTrue(result.contains("email='john@example.com'"));
            assertTrue(result.contains("role='admin'"));
        }

        @Test
        @DisplayName("Should return string representation for user with null fields")
        public void shouldReturnStringRepresentationForNullFields() {
            User user = new User();
            String result = user.toString();
            
            assertNotNull(result);
            assertTrue(result.contains("User{"));
            assertTrue(result.contains("id=null"));
            assertTrue(result.contains("name='null'"));
            assertTrue(result.contains("email='null'"));
            assertTrue(result.contains("role='null'"));
        }
    }
}
