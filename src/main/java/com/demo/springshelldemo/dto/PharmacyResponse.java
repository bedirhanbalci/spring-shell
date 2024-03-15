package com.demo.springshelldemo.dto;

import java.util.List;

public record PharmacyResponse(List<PharmacyItem> result) {
}
