package com.kickstarter.factories;

import android.support.annotation.NonNull;

import com.kickstarter.libs.Config;

import java.util.Arrays;

public final class ConfigFactory {
  private ConfigFactory() {}

  public static @NonNull Config config() {
    final Config.LaunchedCountry US = Config.LaunchedCountry.builder()
      .name("US")
      .currencyCode("USD")
      .currencySymbol("$")
      .trailingCode(true)
      .build();

    final Config.LaunchedCountry GB = Config.LaunchedCountry.builder()
      .name("GB")
      .currencyCode("GBP")
      .currencySymbol("£")
      .trailingCode(false)
      .build();

    final Config.LaunchedCountry CA = Config.LaunchedCountry.builder()
      .name("CA")
      .currencyCode("CAD")
      .currencySymbol("$")
      .trailingCode(true)
      .build();

    return Config.builder()
      .countryCode("US")
      .launchedCountries(Arrays.asList(US, GB, CA))
      .build();
  }

  public static @NonNull Config configForUSUser() {
    return config();
  }

  public static @NonNull Config configForCAUser() {
    return config().toBuilder()
      .countryCode("CA")
      .build();
  }
}
