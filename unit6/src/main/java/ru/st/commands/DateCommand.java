package ru.st.commands;

import ru.st.Command;
import ru.st.CommandInfo;

import java.time.LocalDate;

@CommandInfo(name="date", Description = "выводит текущую дату")
public class DateCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println(LocalDate.now());
    }

}
