package com.atamertc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSaveRequestDto {
    @NotBlank(message = "Isim bos birakilamaz.")
    String name;
    String surname;
    @Email(message = "E-mail formatini hatali girdiniz.")
    String email;
    String phone;
    @NotBlank
    @Size(min = 4, max = 32, message = "Sifre uzunlugu en az 4 en fazla 32 karakter olmalidir.")
    String password;
}
