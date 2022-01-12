package beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
        @JsonIgnore
        private String createdAt;
        private String employee_firstname;
        private String employee_lastname;
        private String employee_phonenumbe;
        private String ademployee_emaildress;
        private String citemployee_addressy;
        private String stateemployee_dev_level;
        private String employee_gender;
        private String employee_hire_date;

        @JsonIgnore
        private String employee_onleave;

        @JsonIgnore
        private String[] tech_stack;

        @JsonIgnore
        private String[] project;

        @JsonIgnore
        private String id;
}
