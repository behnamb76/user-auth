package ir.maktabsharif.userauth.dto;


import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @NotBlank(message = "First name is required!")
    @Size(min = 2, max = 50, message = "First name must be between {min} and {max} characters!")
    private String firstName;

    @NotBlank(message = "Last name is required!")
    @Size(min = 2, max = 50, message = "Last name must be between {min} and {max} characters!")
    private String lastName;

    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email format!")
    private String email;

    @Size(min = 3, max = 20 , message = "Username must be between {min} and {max} characters!")
    @NotBlank(message = "Username is Required!")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_-]{2,19}$", message = "Username must start with a letter and contain only letters, numbers, underscores, or hyphens")
    private String username;

    @Size(min = 8, max = 20, message = "Password must be between {min} and {max} characters!")
    @NotBlank(message = "Password is Required!")
    private String password;
}
