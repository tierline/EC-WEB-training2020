package com.example.training.domain.address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Postcode {
	@NotEmpty
	@Size(min = 7, max = 8)
	@Pattern(regexp = "^[0-9]{3}[0-9]{4}$", message = "郵便番号の形式が間違っています")
	private String value;

	public Postcode(String value) {
		this.value = value;
	}

	public Postcode() {
	}
}
