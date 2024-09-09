package uz.jvh.prjoectmanagement.domain.dto.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.jvh.prjoectmanagement.enumerators.Permissions;
import uz.jvh.prjoectmanagement.enumerators.UserRole;


import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserCreateDto {
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
    private UserRole role;
    private List<Permissions> permissions;

}
