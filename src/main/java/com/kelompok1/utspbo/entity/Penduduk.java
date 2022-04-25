package com.kelompok1.utspbo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "penduduk")
public class Penduduk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "First name is required")
    @NotNull(message = "First name cannot be null")
    @Column(nullable = false, name = "first_Name")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @NotNull(message = "Last name cannot be null")
    @Column(nullable = false, name = "last_name")
    private String lastName;

    @NotNull(message = "Please enter birth date")
    @Past(message = "Birth date should less than current date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotEmpty(message = "email is required")
    @Email
    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Phone number is required")
    @NotNull(message = "Phone number cannot be null")
    @Size(min = 10, max = 14, message = "Phone number should be of minimum 10 digits")
    @Column(nullable = false, unique = true)
    private String phone;

    @NotEmpty(message = "Alamat is required")
    @NotNull(message = "Alamat cannot be null")
    @Column(nullable = false)
    private String alamat;
}