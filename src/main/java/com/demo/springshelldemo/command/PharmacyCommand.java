package com.demo.springshelldemo.command;

import com.demo.springshelldemo.remote.PharmacyApiClient;
import com.demo.springshelldemo.util.PharmacyFormatter;
import com.demo.springshelldemo.util.ShellPrinter;
import lombok.RequiredArgsConstructor;
import org.fusesource.jansi.Ansi;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;
import org.springframework.shell.command.annotation.Option;

import java.util.Objects;

@Command(group = "Pharmacy Commands")
@RequiredArgsConstructor
public class PharmacyCommand {

    private final PharmacyApiClient pharmacyApiClient;

    private final ShellPrinter shellPrinter;

    private final PharmacyFormatter pharmacyFormatter;

    @CommandAvailability(provider = "userLoggedInProvider")
    @Command(command = "pharmacy")
    public void pharmacy(
            @Option(required = true, shortNames = 'c', longNames = "city") String city,
            @Option(required = false, shortNames = 'd', longNames = "district") String district
    ) {
        var data = Objects.requireNonNull(pharmacyApiClient.getPharmacies(city, district)
                        .getBody())
                .result();
        shellPrinter.print(pharmacyFormatter.convertToTable(data), Ansi.Color.CYAN);

    }
}
