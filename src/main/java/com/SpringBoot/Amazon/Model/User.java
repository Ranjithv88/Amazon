package com.SpringBoot.Amazon.Model;

import com.SpringBoot.Amazon.Annotations.ValidGender;
import com.SpringBoot.Amazon.Model.Enum.Gender;
import com.SpringBoot.Amazon.Model.Enum.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = " UserName is Mandatory ......! ")
    @Size(min = 2,message = " UserName Must Be Between 2 & 30 Characters .......! ",max = 40)
    private String userName;

    @NotBlank(message = " Email is Mandatory ......! ")
    @Email(message = " Email is Invalid .......! ")
    private String email;

    @NotBlank(message = " Password is Mandatory ......! ")
    @Size(min = 8,message = " Too Weak .......! ")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NotBlank(message = " Number is Mandatory ......! ")
    @Pattern(regexp = "^\\d{10}$",message = " Number is Not valid ......! ")
    private String number;

    @NotNull(message = " DateOfBirth is Mandatory .......! ")
    @Past(message = " DateOfBirth Must Be A Past Date .    private String gender;\n" +
            "    ......! ")
    private LocalDate dateOfBirth ;

//    @Pattern(regexp = "Male|Female|Other", message = " Gender must be Male, Female, or Other ") // This is the RegXP Pattern Of Gender
//    private String gender;

//    @NotNull(message = " Gender is required .......! ")
//    @Enumerated(value = EnumType.STRING)
//    private Gender gender;

    @ValidGender
    private String gender;

    private LocalDate createdOn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> product;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
}

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}

