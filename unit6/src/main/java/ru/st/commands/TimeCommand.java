package ru.st.commands;

import ru.st.Command;
import ru.st.CommandInfo;

import java.util.Date;

@CommandInfo(name="time", Description = "выводит текущее время")
public class TimeCommand implements Command {
    @Override
    public void execute(String[] args) {
        Date current = new Date();
        System.out.printf("%s:%s:%s\n", current.getHours(), current.getMinutes(), current.getSeconds());
    }
}
