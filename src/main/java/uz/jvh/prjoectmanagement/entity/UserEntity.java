package uz.jvh.prjoectmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.jvh.prjoectmanagement.enumerators.Permissions;
import uz.jvh.prjoectmanagement.enumerators.UserRole;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class UserEntity extends BaseEntity implements UserDetails {

    private String name;
    private String surname;
    @Column(unique = true)
    private String username;

    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Permissions> permissions;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = permissions.stream()
                .map(permissions->new SimpleGrantedAuthority(permissions.name()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
        return authorities;
    }

}
