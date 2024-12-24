package com.codegym.c0824g1_spring_boot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    private Integer id;

    @Pattern(regexp = "^[A-Za-z ]{5,100}$", message = "Tên phải đúng định dạng")
    @Column(name = "name_student", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Email(message = "Email phải đúng định dạng")
    @NotBlank(message = "Email không được để trống")
    @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @NotNull(message = "Điểm không được để trống")
//    @Min(value = 0, message = "Điểm phải lớn hơn 0")
//    @Max(value = 10, message = "Điểm phải nhỏ hơn 10")
    @Range(min = 0, max = 10, message = "Điểm phải nằm trong khoảng từ 0 đến 10")
    @Column(name = "score", columnDefinition = "DOUBLE")
    private Float point;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Ngày sinh không được để trống")
    @PastOrPresent(message = "Ngày sinh không thể lớn hơn ngày hiện tại")
    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id")
    @NotNull(message = "Lớp không được để trống")
    private Classroom classroom;
}
