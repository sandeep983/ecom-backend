package com.ecomhouse.ecomhousebackend.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSupportSpecialHoursDto {

    // Hide this field from the swagger documentation
    @Schema(hidden = true)
    private Long id;

    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$", message = "Date should be in yyyy-MM-dd format")
    private String date;

    @NotBlank(message = "Opening & Closing Hours should not be empty or null")
    private String hours;

}