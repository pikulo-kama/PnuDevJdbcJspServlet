package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;


enum Gender {
    Male,
    Female,
    Anonymous
}

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NonNull private String username;

    @NonNull private String password;

    private Gender gender;

    @NonNull private LocalDate registrationDate;
}
