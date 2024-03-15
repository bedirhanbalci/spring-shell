package com.demo.springshelldemo.command;

import com.demo.springshelldemo.util.ShellPrinter;
import com.demo.springshelldemo.util.ShellReader;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;
import org.springframework.shell.command.annotation.Option;

@Command(group = "Test Commands")
@RequiredArgsConstructor
public class TestCommand {

    private final ShellReader shellReader;

    private final ShellPrinter shellPrinter;

    @Command(command = "hi", description = "this will print 'hello!'")
    public void hello(
            @NotBlank
            @Size(min = 3, max = 7)
            @Option(shortNames = 'n', longNames = "name", description = "name input") String name,
            @NotBlank
            @Size(min = 3, max = 7)
            @Option(shortNames = 's', longNames = "surname", description = "surname input") String surname) {
        shellPrinter.printSuccess("hello! %s %s".formatted(name, surname));
        shellPrinter.printError("error!");
    }

    @CommandAvailability(provider = "userLoggedInProvider")
    @Command(command = "inputs", description = "this will print 'hello!'")
    public void inputs() {

        var name = shellReader.readLine("name");
        var surname = shellReader.readLine("surname");
//        var password = shellReader.readLinePassword("password");
        shellPrinter.print(name + " " + surname);
    }

}
